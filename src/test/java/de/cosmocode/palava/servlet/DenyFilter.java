package de.cosmocode.palava.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.google.inject.Singleton;

/**
 * A {@link Filter} which denies everything.
 *
 * @since 
 * @author Willi Schoenborn
 */
@Singleton
public final class DenyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException {

        throw new UnsupportedOperationException();
    }

    @Override
    public void destroy() {

    }

}
