package org.mickey.framework.core.mybatis.unique;

import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author mickey
 * 23/07/2019
 */
@Slf4j
public class UniqueConstaintCustomExecution extends Exception {

    public UniqueConstaintCustomExecution(String message, Throwable casue) {
        super(message, casue);
    }
}
