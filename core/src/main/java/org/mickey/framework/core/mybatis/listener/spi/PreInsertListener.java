package org.mickey.framework.core.mybatis.listener.spi;

import org.mickey.framework.core.mybatis.listener.OrderedListener;

/**
 * description
 *
 * @author mickey
 * 23/07/2019
 */
public interface PreInsertListener extends OrderedListener {
    boolean preInsert(Object object);
}
