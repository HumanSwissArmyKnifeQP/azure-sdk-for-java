/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.textanalytics;

import com.microsoft.azure.cognitiveservices.language.textanalytics.models.EntitiesOptionalParameter;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.SentimentOptionalParameter;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.DetectLanguageOptionalParameter;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.KeyPhrasesOptionalParameter;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.EntitiesBatchResult;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.ErrorResponseException;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.KeyPhraseBatchResult;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.LanguageBatchResult;
import com.microsoft.azure.cognitiveservices.language.textanalytics.models.SentimentBatchResult;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in TextAnalytics.
 */
public interface TextAnalytics {
    /**
     * The API returns a list of recognized entities in a given document.
     * To get even more information on each recognized entity we recommend using the Bing Entity Search API by
     *   querying for the recognized entities names. See the
     *   &lt;a href="https://docs.microsoft.com/en-us/azure/cognitive-services/text-analytics/text-analytics-supported-languages"&gt;Supported languages
     *   in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     *
     * @param entitiesOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the EntitiesBatchResult object if successful.
     */
    EntitiesBatchResult entities(EntitiesOptionalParameter entitiesOptionalParameter);

    /**
     * The API returns a list of recognized entities in a given document.
     * To get even more information on each recognized entity we recommend using the Bing Entity Search API by
     *   querying for the recognized entities names. See the
     *   &lt;a href="https://docs.microsoft.com/en-us/azure/cognitive-services/text-analytics/text-analytics-supported-languages"&gt;Supported languages
     *   in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     *
     * @param entitiesOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the EntitiesBatchResult object
     */
    Observable<EntitiesBatchResult> entitiesAsync(EntitiesOptionalParameter entitiesOptionalParameter);

    /**
     * The API returns a numeric score between 0 and 1.
     * Scores close to 1 indicate positive sentiment, while scores close to 0 indicate negative sentiment. A score
     *   of 0.5 indicates the lack of sentiment (e.g. a factoid statement). See the
     *   &lt;a href="https://docs.microsoft.com/en-us/azure/cognitive-services/text-analytics/overview#supported-languages"&gt;Text Analytics Documentation&lt;/a&gt; for
     *   details about the languages that are supported by sentiment analysis.
     *
     * @param sentimentOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the SentimentBatchResult object if successful.
     */
    SentimentBatchResult sentiment(SentimentOptionalParameter sentimentOptionalParameter);

    /**
     * The API returns a numeric score between 0 and 1.
     * Scores close to 1 indicate positive sentiment, while scores close to 0 indicate negative sentiment. A score
     *   of 0.5 indicates the lack of sentiment (e.g. a factoid statement). See the
     *   &lt;a href="https://docs.microsoft.com/en-us/azure/cognitive-services/text-analytics/overview#supported-languages"&gt;Text Analytics Documentation&lt;/a&gt; for
     *   details about the languages that are supported by sentiment analysis.
     *
     * @param sentimentOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the SentimentBatchResult object
     */
    Observable<SentimentBatchResult> sentimentAsync(SentimentOptionalParameter sentimentOptionalParameter);

    /**
     * The API returns the detected language and a numeric score between 0 and 1.
     * Scores close to 1 indicate 100% certainty that the identified language is true. A total of 120 languages are
     *   supported.
     *
     * @param detectLanguageOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the LanguageBatchResult object if successful.
     */
    LanguageBatchResult detectLanguage(DetectLanguageOptionalParameter detectLanguageOptionalParameter);

    /**
     * The API returns the detected language and a numeric score between 0 and 1.
     * Scores close to 1 indicate 100% certainty that the identified language is true. A total of 120 languages are
     *   supported.
     *
     * @param detectLanguageOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LanguageBatchResult object
     */
    Observable<LanguageBatchResult> detectLanguageAsync(DetectLanguageOptionalParameter detectLanguageOptionalParameter);

    /**
     * The API returns a list of strings denoting the key talking points in the input text.
     * See the
     *   &lt;a href="https://docs.microsoft.com/en-us/azure/cognitive-services/text-analytics/overview#supported-languages"&gt;Text Analytics Documentation&lt;/a&gt;
     *   for details about the languages that are supported by key phrase extraction.
     *
     * @param keyPhrasesOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the KeyPhraseBatchResult object if successful.
     */
    KeyPhraseBatchResult keyPhrases(KeyPhrasesOptionalParameter keyPhrasesOptionalParameter);

    /**
     * The API returns a list of strings denoting the key talking points in the input text.
     * See the
     *   &lt;a href="https://docs.microsoft.com/en-us/azure/cognitive-services/text-analytics/overview#supported-languages"&gt;Text Analytics Documentation&lt;/a&gt;
     *   for details about the languages that are supported by key phrase extraction.
     *
     * @param keyPhrasesOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the KeyPhraseBatchResult object
     */
    Observable<KeyPhraseBatchResult> keyPhrasesAsync(KeyPhrasesOptionalParameter keyPhrasesOptionalParameter);

}
