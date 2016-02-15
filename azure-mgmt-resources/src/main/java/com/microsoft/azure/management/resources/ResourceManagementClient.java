/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.15.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.resources;

import com.microsoft.azure.AzureClient;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.serializer.JacksonMapperAdapter;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

/**
 * The interface for ResourceManagementClient class.
 */
public interface ResourceManagementClient {
    /**
     * Gets the URI used as the base for all cloud service requests.
     * @return The BaseUri value.
     */
    String getBaseUri();

    /**
     * Gets the list of interceptors the OkHttp client will execute.
     * @return the list of interceptors.
     */
    List<Interceptor> getClientInterceptors();

    /**
     * Sets the logging level for OkHttp client.
     *
     * @param logLevel the logging level enum.
     */
    void setLogLevel(Level logLevel);

    /**
     * Gets the adapter for {@link com.fasterxml.jackson.databind.ObjectMapper} for serialization
     * and deserialization operations..
     *
     * @return the adapter.
     */
    JacksonMapperAdapter getMapperAdapter();

    /**
     * Gets the {@link AzureClient} used for long running operations.
     * @return the azure client;
     */
    AzureClient getAzureClient();

    /**
     * Gets Gets Azure subscription credentials..
     *
     * @return the credentials value.
     */
    ServiceClientCredentials getCredentials();

    /**
     * Gets Gets subscription credentials which uniquely identify Microsoft Azure subscription. The subscription ID forms part of the URI for every service call..
     *
     * @return the subscriptionId value.
     */
    String getSubscriptionId();

    /**
     * Sets Gets subscription credentials which uniquely identify Microsoft Azure subscription. The subscription ID forms part of the URI for every service call..
     *
     * @param subscriptionId the subscriptionId value.
     */
    void setSubscriptionId(String subscriptionId);

    /**
     * Gets Client Api Version..
     *
     * @return the apiVersion value.
     */
    String getApiVersion();

    /**
     * Gets Gets or sets the preferred language for the response..
     *
     * @return the acceptLanguage value.
     */
    String getAcceptLanguage();

    /**
     * Sets Gets or sets the preferred language for the response..
     *
     * @param acceptLanguage the acceptLanguage value.
     */
    void setAcceptLanguage(String acceptLanguage);

    /**
     * Gets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30..
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    int getLongRunningOperationRetryTimeout();

    /**
     * Sets Gets or sets the retry timeout in seconds for Long Running Operations. Default value is 30..
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     */
    void setLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout);

    /**
     * Gets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true..
     *
     * @return the generateClientRequestId value.
     */
    boolean getGenerateClientRequestId();

    /**
     * Sets When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true..
     *
     * @param generateClientRequestId the generateClientRequestId value.
     */
    void setGenerateClientRequestId(boolean generateClientRequestId);

    /**
     * Gets the DeploymentsOperations object to access its operations.
     * @return the DeploymentsOperations object.
     */
    DeploymentsOperations getDeploymentsOperations();

    /**
     * Gets the ProvidersOperations object to access its operations.
     * @return the ProvidersOperations object.
     */
    ProvidersOperations getProvidersOperations();

    /**
     * Gets the ResourceGroupsOperations object to access its operations.
     * @return the ResourceGroupsOperations object.
     */
    ResourceGroupsOperations getResourceGroupsOperations();

    /**
     * Gets the ResourcesOperations object to access its operations.
     * @return the ResourcesOperations object.
     */
    ResourcesOperations getResourcesOperations();

    /**
     * Gets the TagsOperations object to access its operations.
     * @return the TagsOperations object.
     */
    TagsOperations getTagsOperations();

    /**
     * Gets the DeploymentOperationsOperations object to access its operations.
     * @return the DeploymentOperationsOperations object.
     */
    DeploymentOperationsOperations getDeploymentOperationsOperations();

    /**
     * Gets the ResourceProviderOperationDetailsOperations object to access its operations.
     * @return the ResourceProviderOperationDetailsOperations object.
     */
    ResourceProviderOperationDetailsOperations getResourceProviderOperationDetailsOperations();

    /**
     * Gets the PolicyDefinitionsOperations object to access its operations.
     * @return the PolicyDefinitionsOperations object.
     */
    PolicyDefinitionsOperations getPolicyDefinitionsOperations();

    /**
     * Gets the PolicyAssignmentsOperations object to access its operations.
     * @return the PolicyAssignmentsOperations object.
     */
    PolicyAssignmentsOperations getPolicyAssignmentsOperations();

}