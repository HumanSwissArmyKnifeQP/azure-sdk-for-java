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

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.resources.models.GenericResource;
import com.microsoft.azure.management.resources.models.GenericResourceFilter;
import com.microsoft.azure.management.resources.models.PageImpl;
import com.microsoft.azure.management.resources.models.ResourcesMoveInfo;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.ServiceResponseEmptyCallback;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in ResourcesOperations.
 */
public final class ResourcesOperationsImpl implements ResourcesOperations {
    /** The Retrofit service to perform REST calls. */
    private ResourcesService service;
    /** The service client containing this operation class. */
    private ResourceManagementClient client;

    /**
     * Initializes an instance of ResourcesOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ResourcesOperationsImpl(Retrofit retrofit, ResourceManagementClient client) {
        this.service = retrofit.create(ResourcesService.class);
        this.client = client;
    }

    /**
     * Begin moving resources.To determine whether the operation has finished processing the request, call GetLongRunningOperationStatus.
     *
     * @param sourceResourceGroupName Source resource group name.
     * @param parameters move resources' parameters.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @throws InterruptedException exception thrown when long running operation is interrupted
     * @return the ServiceResponse object if successful.
     */
    public ServiceResponse<Void> moveResources(String sourceResourceGroupName, ResourcesMoveInfo parameters) throws CloudException, IOException, IllegalArgumentException, InterruptedException {
        Response<ResponseBody> result = service.moveResources(sourceResourceGroupName, this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage()).execute();
        return client.getAzureClient().getPostOrDeleteResult(result, new TypeToken<Void>() { }.getType());
    }

    /**
     * Begin moving resources.To determine whether the operation has finished processing the request, call GetLongRunningOperationStatus.
     *
     * @param sourceResourceGroupName Source resource group name.
     * @param parameters move resources' parameters.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> moveResourcesAsync(String sourceResourceGroupName, ResourcesMoveInfo parameters, final ServiceCallback<Void> serviceCallback) {
        if (sourceResourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter sourceResourceGroupName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (parameters == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
        }
        Validator.validate(parameters, serviceCallback);
        Call<ResponseBody> call = service.moveResources(sourceResourceGroupName, this.client.getSubscriptionId(), parameters, this.client.getApiVersion(), this.client.getAcceptLanguage());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                serviceCallback.failure(t);
            }
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                client.getAzureClient().getPostOrDeleteResultAsync(response, new TypeToken<Void>() { }.getType(), serviceCallback);
            }
        });
        return call;
    }

    /**
     * Get all of the resources under a subscription.
     *
     * @param filter The filter to apply on the operation.
     * @param top Query parameters. If null is passed returns all resource groups.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;GenericResource&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<GenericResource>> list(final GenericResourceFilter filter, final Integer top) throws CloudException, IOException, IllegalArgumentException {
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.list(this.client.getSubscriptionId(), client.getMapperAdapter().serializeRaw(filter), top, this.client.getApiVersion(), this.client.getAcceptLanguage());
        ServiceResponse<PageImpl<GenericResource>> response = listDelegate(call.execute());
        List<GenericResource> result = response.getBody().getItems();
        while (response.getBody().getNextPageLink() != null) {
            response = listNext(response.getBody().getNextPageLink());
            result.addAll(response.getBody().getItems());
        }
        return new ServiceResponse<>(result, response.getResponse());
    }

    /**
     * Get all of the resources under a subscription.
     *
     * @param filter The filter to apply on the operation.
     * @param top Query parameters. If null is passed returns all resource groups.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> listAsync(final GenericResourceFilter filter, final Integer top, final ListOperationCallback<GenericResource> serviceCallback) {
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.list(this.client.getSubscriptionId(), client.getMapperAdapter().serializeRaw(filter), top, this.client.getApiVersion(), this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<List<GenericResource>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<GenericResource>> result = listDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listNextAsync(result.getBody().getNextPageLink(), serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                        }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<PageImpl<GenericResource>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<GenericResource>, CloudException>()
                .register(200, new TypeToken<PageImpl<GenericResource>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Checks whether resource exists.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Boolean object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Boolean> checkExistence(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (parentResourcePath == null) {
            throw new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null.");
        }
        if (resourceType == null) {
            throw new IllegalArgumentException("Parameter resourceType is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (apiVersion == null) {
            throw new IllegalArgumentException("Parameter apiVersion is required and cannot be null.");
        }
        Call<Void> call = service.checkExistence(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, this.client.getAcceptLanguage());
        return checkExistenceDelegate(call.execute());
    }

    /**
     * Checks whether resource exists.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<Void> checkExistenceAsync(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion, final ServiceCallback<Boolean> serviceCallback) {
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (resourceProviderNamespace == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null."));
            return null;
        }
        if (parentResourcePath == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null."));
            return null;
        }
        if (resourceType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceType is required and cannot be null."));
            return null;
        }
        if (resourceName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (apiVersion == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter apiVersion is required and cannot be null."));
            return null;
        }
        Call<Void> call = service.checkExistence(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseEmptyCallback<Boolean>(serviceCallback) {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                try {
                    serviceCallback.success(checkExistenceDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Boolean> checkExistenceDelegate(Response<Void> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Boolean, CloudException>()
                .register(204, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .registerError(CloudException.class)
                .buildEmpty(response);
    }

    /**
     * Delete resource and all of its resources.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    public ServiceResponse<Void> delete(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (parentResourcePath == null) {
            throw new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null.");
        }
        if (resourceType == null) {
            throw new IllegalArgumentException("Parameter resourceType is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (apiVersion == null) {
            throw new IllegalArgumentException("Parameter apiVersion is required and cannot be null.");
        }
        Call<ResponseBody> call = service.delete(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, this.client.getAcceptLanguage());
        return deleteDelegate(call.execute());
    }

    /**
     * Delete resource and all of its resources.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> deleteAsync(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion, final ServiceCallback<Void> serviceCallback) {
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (resourceProviderNamespace == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null."));
            return null;
        }
        if (parentResourcePath == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null."));
            return null;
        }
        if (resourceType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceType is required and cannot be null."));
            return null;
        }
        if (resourceName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (apiVersion == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter apiVersion is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.delete(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deleteDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> deleteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, CloudException>()
                .register(200, new TypeToken<Void>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .register(202, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Create a resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @param parameters Create or update resource parameters.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the GenericResource object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<GenericResource> createOrUpdate(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion, GenericResource parameters) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (parentResourcePath == null) {
            throw new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null.");
        }
        if (resourceType == null) {
            throw new IllegalArgumentException("Parameter resourceType is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (apiVersion == null) {
            throw new IllegalArgumentException("Parameter apiVersion is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        Validator.validate(parameters);
        Call<ResponseBody> call = service.createOrUpdate(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, parameters, this.client.getAcceptLanguage());
        return createOrUpdateDelegate(call.execute());
    }

    /**
     * Create a resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @param parameters Create or update resource parameters.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> createOrUpdateAsync(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion, GenericResource parameters, final ServiceCallback<GenericResource> serviceCallback) {
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (resourceProviderNamespace == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null."));
            return null;
        }
        if (parentResourcePath == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null."));
            return null;
        }
        if (resourceType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceType is required and cannot be null."));
            return null;
        }
        if (resourceName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (apiVersion == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter apiVersion is required and cannot be null."));
            return null;
        }
        if (parameters == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
            return null;
        }
        Validator.validate(parameters, serviceCallback);
        Call<ResponseBody> call = service.createOrUpdate(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, parameters, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<GenericResource>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(createOrUpdateDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<GenericResource> createOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<GenericResource, CloudException>()
                .register(201, new TypeToken<GenericResource>() { }.getType())
                .register(200, new TypeToken<GenericResource>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Returns a resource belonging to a resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the GenericResource object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<GenericResource> get(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion) throws CloudException, IOException, IllegalArgumentException {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (resourceProviderNamespace == null) {
            throw new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null.");
        }
        if (parentResourcePath == null) {
            throw new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null.");
        }
        if (resourceType == null) {
            throw new IllegalArgumentException("Parameter resourceType is required and cannot be null.");
        }
        if (resourceName == null) {
            throw new IllegalArgumentException("Parameter resourceName is required and cannot be null.");
        }
        if (this.client.getSubscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null.");
        }
        if (apiVersion == null) {
            throw new IllegalArgumentException("Parameter apiVersion is required and cannot be null.");
        }
        Call<ResponseBody> call = service.get(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, this.client.getAcceptLanguage());
        return getDelegate(call.execute());
    }

    /**
     * Returns a resource belonging to a resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceProviderNamespace Resource identity.
     * @param parentResourcePath Resource identity.
     * @param resourceType Resource identity.
     * @param resourceName Resource identity.
     * @param apiVersion the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> getAsync(String resourceGroupName, String resourceProviderNamespace, String parentResourcePath, String resourceType, String resourceName, String apiVersion, final ServiceCallback<GenericResource> serviceCallback) {
        if (resourceGroupName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
            return null;
        }
        if (resourceProviderNamespace == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceProviderNamespace is required and cannot be null."));
            return null;
        }
        if (parentResourcePath == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter parentResourcePath is required and cannot be null."));
            return null;
        }
        if (resourceType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceType is required and cannot be null."));
            return null;
        }
        if (resourceName == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter resourceName is required and cannot be null."));
            return null;
        }
        if (this.client.getSubscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getSubscriptionId() is required and cannot be null."));
            return null;
        }
        if (apiVersion == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter apiVersion is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.get(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName, this.client.getSubscriptionId(), apiVersion, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<GenericResource>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<GenericResource> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<GenericResource, CloudException>()
                .register(200, new TypeToken<GenericResource>() { }.getType())
                .register(204, new TypeToken<GenericResource>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Get all of the resources under a subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;GenericResource&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PageImpl<GenericResource>> listNext(final String nextPageLink) throws CloudException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage());
        return listNextDelegate(call.execute());
    }

    /**
     * Get all of the resources under a subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public Call<ResponseBody> listNextAsync(final String nextPageLink, final ListOperationCallback<GenericResource> serviceCallback) {
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<List<GenericResource>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponse<PageImpl<GenericResource>> result = listNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listNextAsync(result.getBody().getNextPageLink(), serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponse<>(serviceCallback.get(), result.getResponse()));
                    }
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<PageImpl<GenericResource>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<GenericResource>, CloudException>()
                .register(200, new TypeToken<PageImpl<GenericResource>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}