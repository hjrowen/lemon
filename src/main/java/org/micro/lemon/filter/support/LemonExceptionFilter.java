package org.micro.lemon.filter.support;

import org.micro.lemon.common.LemonStatusCode;
import org.micro.lemon.filter.IFilter;
import org.micro.lemon.filter.LemonChain;
import org.micro.lemon.server.LemonContext;
import lombok.extern.slf4j.Slf4j;
import org.micro.lemon.extension.Extension;

/**
 * LemonExceptionFilter
 *
 * @author lry
 */
@Slf4j
@Extension(value = "exception", order = 0)
public class LemonExceptionFilter implements IFilter {

    @Override
    public void preFilter(LemonChain chain, LemonContext context) throws Throwable {
        try {
            chain.doFilter(context);
        } catch (Throwable t) {
            log.error("Lemon exception filter", t);
            context.callback(LemonStatusCode.INTERNAL_SERVER_ERROR);
        }
    }

}
