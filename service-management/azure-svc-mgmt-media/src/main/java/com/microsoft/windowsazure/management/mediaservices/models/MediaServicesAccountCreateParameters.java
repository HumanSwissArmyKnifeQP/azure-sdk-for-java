/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.mediaservices.models;

import java.net.URI;

/**
* Parameters supplied to the Create Media Services Account operation.
*/
public class MediaServicesAccountCreateParameters {
    private String accountName;
    
    /**
    * Required. The name of the Media Services account to create.
    * @return The AccountName value.
    */
    public String getAccountName() {
        return this.accountName;
    }
    
    /**
    * Required. The name of the Media Services account to create.
    * @param accountNameValue The AccountName value.
    */
    public void setAccountName(final String accountNameValue) {
        this.accountName = accountNameValue;
    }
    
    private URI blobStorageEndpointUri;
    
    /**
    * Required. The url of the blob storage endpoint associated with the
    * created Media Services account
    * @return The BlobStorageEndpointUri value.
    */
    public URI getBlobStorageEndpointUri() {
        return this.blobStorageEndpointUri;
    }
    
    /**
    * Required. The url of the blob storage endpoint associated with the
    * created Media Services account
    * @param blobStorageEndpointUriValue The BlobStorageEndpointUri value.
    */
    public void setBlobStorageEndpointUri(final URI blobStorageEndpointUriValue) {
        this.blobStorageEndpointUri = blobStorageEndpointUriValue;
    }
    
    private String region;
    
    /**
    * Required. The region associated with the created Media Services account
    * @return The Region value.
    */
    public String getRegion() {
        return this.region;
    }
    
    /**
    * Required. The region associated with the created Media Services account
    * @param regionValue The Region value.
    */
    public void setRegion(final String regionValue) {
        this.region = regionValue;
    }
    
    private String storageAccountKey;
    
    /**
    * Required. The access key of the storage account associated with the
    * created Media Services account
    * @return The StorageAccountKey value.
    */
    public String getStorageAccountKey() {
        return this.storageAccountKey;
    }
    
    /**
    * Required. The access key of the storage account associated with the
    * created Media Services account
    * @param storageAccountKeyValue The StorageAccountKey value.
    */
    public void setStorageAccountKey(final String storageAccountKeyValue) {
        this.storageAccountKey = storageAccountKeyValue;
    }
    
    private String storageAccountName;
    
    /**
    * Required. The name of the storage account associated with the created
    * Media Services account
    * @return The StorageAccountName value.
    */
    public String getStorageAccountName() {
        return this.storageAccountName;
    }
    
    /**
    * Required. The name of the storage account associated with the created
    * Media Services account
    * @param storageAccountNameValue The StorageAccountName value.
    */
    public void setStorageAccountName(final String storageAccountNameValue) {
        this.storageAccountName = storageAccountNameValue;
    }
}