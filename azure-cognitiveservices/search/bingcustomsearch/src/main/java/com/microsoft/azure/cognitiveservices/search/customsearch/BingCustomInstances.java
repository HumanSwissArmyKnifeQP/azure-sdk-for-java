/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.search.customsearch;

import com.microsoft.azure.cognitiveservices.search.customsearch.models.SearchOptionalParameter;
import com.microsoft.azure.cognitiveservices.search.customsearch.models.ErrorResponseException;
import com.microsoft.azure.cognitiveservices.search.customsearch.models.SearchResponse;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in BingCustomInstances.
 */
public interface BingCustomInstances {
    /**
     * The Custom Search API lets you send a search query to Bing and get back web pages found in your custom view
     *   of the web.
     *
     * @param customConfig The identifier for the custom search configuration
     * @param query The user's search query term. The term may not be empty. The term may contain Bing Advanced Operators. For
     *   example, to limit results to a specific domain, use the site: operator.
     * @param searchOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the SearchResponse object if successful.
     */
    SearchResponse search(long customConfig, String query, SearchOptionalParameter searchOptionalParameter);

    /**
     * The Custom Search API lets you send a search query to Bing and get back web pages found in your custom view
     *   of the web.
     *
     * @param customConfig The identifier for the custom search configuration
     * @param query The user's search query term. The term may not be empty. The term may contain Bing Advanced Operators. For
     *   example, to limit results to a specific domain, use the site: operator.
     * @param searchOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the SearchResponse object
     */
    Observable<SearchResponse> searchAsync(long customConfig, String query, SearchOptionalParameter searchOptionalParameter);

}
