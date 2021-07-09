# QuartzJobsApi

All URIs are relative to *http://localhost/actuator*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllJobs**](QuartzJobsApi.md#getAllJobs) | **GET** /quartz-jobs | get all jobs
[**getJobByGroupAndName**](QuartzJobsApi.md#getJobByGroupAndName) | **GET** /quartz-jobs/{group}/{name} | get all triggers
[**getJobsByGroup**](QuartzJobsApi.md#getJobsByGroup) | **GET** /quartz-jobs/{group} | get all jobs
[**setJobState**](QuartzJobsApi.md#setJobState) | **POST** /quartz-jobs/{group}/{name} | set job state
[**setJobsState**](QuartzJobsApi.md#setJobsState) | **POST** /quartz-jobs/{group} | set jobs state by group



## getAllJobs

> getAllJobs()

get all jobs

The endpoint returns jobs

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzJobsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzJobsApi apiInstance = new QuartzJobsApi(defaultClient);
        try {
            apiInstance.getAllJobs();
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzJobsApi#getAllJobs");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | Validation Exception. |  -  |
| **401** | Unauthorized. |  -  |
| **403** | You do not have permission to perform this action. |  -  |
| **404** | The specified resource was not found. |  -  |
| **409** | Conflict with current state of the resource. |  -  |
| **0** | Something went wrong. |  -  |


## getJobByGroupAndName

> getJobByGroupAndName(group, name)

get all triggers

The endpoint returns triggers

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzJobsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzJobsApi apiInstance = new QuartzJobsApi(defaultClient);
        String group = "group_example"; // String | 
        String name = "name_example"; // String | 
        try {
            apiInstance.getJobByGroupAndName(group, name);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzJobsApi#getJobByGroupAndName");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **group** | **String**|  |
 **name** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | Validation Exception. |  -  |
| **401** | Unauthorized. |  -  |
| **403** | You do not have permission to perform this action. |  -  |
| **404** | The specified resource was not found. |  -  |
| **409** | Conflict with current state of the resource. |  -  |
| **0** | Something went wrong. |  -  |


## getJobsByGroup

> getJobsByGroup(group)

get all jobs

The endpoint returns jobs

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzJobsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzJobsApi apiInstance = new QuartzJobsApi(defaultClient);
        String group = "group_example"; // String | 
        try {
            apiInstance.getJobsByGroup(group);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzJobsApi#getJobsByGroup");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **group** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | Validation Exception. |  -  |
| **401** | Unauthorized. |  -  |
| **403** | You do not have permission to perform this action. |  -  |
| **404** | The specified resource was not found. |  -  |
| **409** | Conflict with current state of the resource. |  -  |
| **0** | Something went wrong. |  -  |


## setJobState

> setJobState(group, name, body)

set job state

setting job state

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzJobsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzJobsApi apiInstance = new QuartzJobsApi(defaultClient);
        String group = "group_example"; // String | 
        String name = "name_example"; // String | 
        String body = "body_example"; // String | A payload for modifying state
        try {
            apiInstance.setJobState(group, name, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzJobsApi#setJobState");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **group** | **String**|  |
 **name** | **String**|  |
 **body** | **String**| A payload for modifying state | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | Validation Exception. |  -  |
| **401** | Unauthorized. |  -  |
| **403** | You do not have permission to perform this action. |  -  |
| **404** | The specified resource was not found. |  -  |
| **409** | Conflict with current state of the resource. |  -  |
| **0** | Something went wrong. |  -  |


## setJobsState

> setJobsState(group, body)

set jobs state by group

setting jobs state to the specified group

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzJobsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzJobsApi apiInstance = new QuartzJobsApi(defaultClient);
        String group = "group_example"; // String | 
        String body = "body_example"; // String | A payload for modifying state
        try {
            apiInstance.setJobsState(group, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzJobsApi#setJobsState");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **group** | **String**|  |
 **body** | **String**| A payload for modifying state | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** | Validation Exception. |  -  |
| **401** | Unauthorized. |  -  |
| **403** | You do not have permission to perform this action. |  -  |
| **404** | The specified resource was not found. |  -  |
| **409** | Conflict with current state of the resource. |  -  |
| **0** | Something went wrong. |  -  |

