/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic.v2016_06_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The azure resource error info.
 */
public class AzureResourceErrorInfo extends ErrorInfo {
    /**
     * The error message.
     */
    @JsonProperty(value = "message", required = true)
    private String message;

    /**
     * The error details.
     */
    @JsonProperty(value = "details")
    private List<AzureResourceErrorInfo> details;

    /**
     * Get the message value.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message value.
     *
     * @param message the message value to set
     * @return the AzureResourceErrorInfo object itself.
     */
    public AzureResourceErrorInfo withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the details value.
     *
     * @return the details value
     */
    public List<AzureResourceErrorInfo> details() {
        return this.details;
    }

    /**
     * Set the details value.
     *
     * @param details the details value to set
     * @return the AzureResourceErrorInfo object itself.
     */
    public AzureResourceErrorInfo withDetails(List<AzureResourceErrorInfo> details) {
        this.details = details;
        return this;
    }

}