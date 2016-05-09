package org.modelcatalogue.gel.export

import groovy.util.logging.Log4j
import org.modelcatalogue.builder.spreadsheet.api.Sheet
import org.modelcatalogue.core.*
import org.modelcatalogue.core.audit.AuditService

import static org.modelcatalogue.core.audit.ChangeType.PROPERTY_CHANGED

/**
 * Created by rickrees on 18/04/2016.
 * HPO and Clinical Tests spreadsheet implementation of RD Change Log Excel Exporter
 */
@Log4j
//@CompileStatic
class RareDiseasePhenotypeChangeLogXlsExporter extends RareDiseaseChangeLogXlsExporter {

    RareDiseasePhenotypeChangeLogXlsExporter(AuditService auditService, DataClassService dataClassService, Integer depth = 5, Boolean includeMetadata = false) {
        super(auditService, dataClassService, depth, includeMetadata)
    }

    @Override
    public void export(DataClass dataClass, OutputStream out) {
        String sheetName = PHENOTYPES_SHEET
        exportXls(dataClass, out, sheetName)
    }

    @Override
    void buildSheet(Sheet sheet, List lines) {
        sheet.with {
            row(1) {
                cell {
                    value 'Change reference'
                    style 'h3'
                    height 75
                    width 20
                }
                cell {
                    value 'Level 2 Disease Group (ID)'
                    style 'h3'
                    width 50
                }
                cell {
                    value 'Level 3 Disease Subtype (ID)'
                    style 'h3'
                    width 60
                }
                cell {
                    value 'Level 4 Specific Disorder (ID)'
                    width 60
                    style 'h3'
                }
                cell {
                    value 'Phenotype /Clinical Tests/Guidance'
                    width 35
                    style 'h3'
                }
                cell {
                    value 'Affected Data Item'
                    width 35
                    style 'h3'
                }
                cell {
                    value 'Change Type'
                    width 25
                    style 'h3'
                }
                cell {
                    value 'Current version details'
                    width 30
                    style 'h3'
                    style {wrap text}
                }
                cell {
                    value 'New version details'
                    width 30
                    style 'h3'
                    style {background('#c2efcf')}
                }
            }

            buildRows(it, lines)

        }
    }

    @Override
    List<String> generateLine(CatalogueElement model, List lines, groupDescriptions, level) {
        String subtype
        if (model.name.matches("(?i:.*Phenotype.*)")) {

            subtype = PHENOTYPE
            checkChangeLog(model, lines, subtype, groupDescriptions, level, TOP_LEVEL_RELATIONSHIP_TYPES)
            iterateChildren(model, lines, subtype, groupDescriptions, level, DETAIL_CHANGE_TYPES)

        } else if (model.name.matches("(?i:.*Clinical Test.*)")) {

            subtype = CLINICAL_TESTS
            checkChangeLog(model, lines, subtype, groupDescriptions, level, TOP_LEVEL_RELATIONSHIP_TYPES)
            iterateChildren(model, lines, subtype, groupDescriptions, level, DETAIL_CHANGE_TYPES)

        } else if (model.name.matches("(?i:.*Guidance.*)")) {
            subtype = GUIDANCE
            checkChangeLog(model, lines, subtype, groupDescriptions, level, [PROPERTY_CHANGED])
        }

        lines
    }

}








