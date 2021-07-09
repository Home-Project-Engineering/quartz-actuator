# QuartzTriggersApi

All URIs are relative to *http://localhost/actuator*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllTriggers**](QuartzTriggersApi.md#getAllTriggers) | **GET** /quartz-triggers | get all triggers
[**getTriggerByGroupAndName**](QuartzTriggersApi.md#getTriggerByGroupAndName) | **GET** /quartz-triggers/{group}/{name} | get all triggers
[**getTriggersByGroup**](QuartzTriggersApi.md#getTriggersByGroup) | **GET** /quartz-triggers/{group} | get all triggers
[**setTriggerCron**](QuartzTriggersApi.md#setTriggerCron) | **POST** /quartz-triggers/{group}/{name} | set triggers cron by group and name
[**setTriggersCron**](QuartzTriggersApi.md#setTriggersCron) | **POST** /quartz-triggers/{group} | set triggers cron by group



## getAllTriggers

> getAllTriggers()

get all triggers

The endpoint returns triggers

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzTriggersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzTriggersApi apiInstance = new QuartzTriggersApi(defaultClient);
        try {
            apiInstance.getAllTriggers();
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzTriggersApi#getAllTriggers");
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


## getTriggerByGroupAndName

> getTriggerByGroupAndName(group, name)

get all triggers

The endpoint returns triggers

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzTriggersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzTriggersApi apiInstance = new QuartzTriggersApi(defaultClient);
        String group = "group_example"; // String | 
        String name = "name_example"; // String | 
        try {
            apiInstance.getTriggerByGroupAndName(group, name);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzTriggersApi#getTriggerByGroupAndName");
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


## getTriggersByGroup

> getTriggersByGroup(group)

get all triggers

The endpoint returns triggers

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzTriggersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzTriggersApi apiInstance = new QuartzTriggersApi(defaultClient);
        String group = "group_example"; // String | 
        try {
            apiInstance.getTriggersByGroup(group);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzTriggersApi#getTriggersByGroup");
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


## setTriggerCron

> setTriggerCron(group, name, body)

set triggers cron by group and name

setting triggers cron to the specified group

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzTriggersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzTriggersApi apiInstance = new QuartzTriggersApi(defaultClient);
        String group = "group_example"; // String | 
        String name = "name_example"; // String | 
        String body = "body_example"; // String | A payload for modifying cron
        try {
            apiInstance.setTriggerCron(group, name, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzTriggersApi#setTriggerCron");
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
 **body** | **String**| A payload for modifying cron | [optional]

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


## setTriggersCron

> setTriggersCron(group, body)

set triggers cron by group

setting triggers cron to the specified group

### Example

```java
// Import classes:
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.models.*;
import org.sathyabodh.actuator.opeanapi.client.api.QuartzTriggersApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/actuator");

        QuartzTriggersApi apiInstance = new QuartzTriggersApi(defaultClient);
        String group = "group_example"; // String | 
        String body = "body_example"; // String | A payload for modifying cron
        try {
            apiInstance.setTriggersCron(group, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuartzTriggersApi#setTriggersCron");
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
 **body** | **String**| A payload for modifying cron | [optional]

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

