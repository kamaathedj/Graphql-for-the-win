package com.kamaathedj.Graphql;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;

import java.util.List;

public class GraphErrors extends DataFetcherExceptionResolverAdapter {


    @Override
    protected List<GraphQLError> resolveToMultipleErrors(Throwable ex, DataFetchingEnvironment env) {
        return super.resolveToMultipleErrors(ex, env);
    }

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return super.resolveToSingleError(ex, env);
        
    }
}
