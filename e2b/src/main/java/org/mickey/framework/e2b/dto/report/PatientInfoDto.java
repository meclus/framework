package org.mickey.framework.e2b.dto.report;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.mickey.framework.e2b.entity.PatientInfo;

import java.util.Map;

/**
 * description
 *
 * @author mickey
 * 2020-02-21
 */
@Slf4j
@Data
public class PatientInfoDto extends PatientInfo implements IcsrDtoInterface {
    private Map<String, MeddraFieldInfoDto> meddraMap;
    private Map<String, NullFlavorInfoDto> nullFlavorMap;
}
