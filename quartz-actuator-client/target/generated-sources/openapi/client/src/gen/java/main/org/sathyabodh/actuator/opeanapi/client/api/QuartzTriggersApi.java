package org.sathyabodh.actuator.opeanapi.client.api;

import org.sathyabodh.actuator.opeanapi.client.ApiException;
import org.sathyabodh.actuator.opeanapi.client.ApiClient;
import org.sathyabodh.actuator.opeanapi.client.ApiResponse;
import org.sathyabodh.actuator.opeanapi.client.Configuration;
import org.sathyabodh.actuator.opeanapi.client.Pair;

import javax.ws.rs.core.GenericType;

import org.sathyabodh.actuator.opeanapi.client.model.ApiError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-09T15:22:40.223298100+03:00[Europe/Simferopol]")
public class QuartzTriggersApi {
  private ApiClient apiClient;

  public QuartzTriggersApi() {
    this(Configuration.getDefaultApiClient());
  }

  public QuartzTriggersApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }
  /**
   * get all triggers
   * The endpoint returns triggers
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public void getAllTriggers() throws ApiException {
    getAllTriggersWithHttpInfo();
  }

  /**
   * get all triggers
   * The endpoint returns triggers
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> getAllTriggersWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/quartz-triggers";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    return apiClient.invokeAPI("QuartzTriggersApi.getAllTriggers", localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * get all triggers
   * The endpoint returns triggers
   * @param group  (required)
   * @param name  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public void getTriggerByGroupAndName(String group, String name) throws ApiException {
    getTriggerByGroupAndNameWithHttpInfo(group, name);
  }

  /**
   * get all triggers
   * The endpoint returns triggers
   * @param group  (required)
   * @param name  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> getTriggerByGroupAndNameWithHttpInfo(String group, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling getTriggerByGroupAndName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling getTriggerByGroupAndName");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-triggers/{group}/{name}"
      .replaceAll("\\{" + "group" + "\\}", apiClient.escapeString(group.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    return apiClient.invokeAPI("QuartzTriggersApi.getTriggerByGroupAndName", localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * get all triggers
   * The endpoint returns triggers
   * @param group  (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public void getTriggersByGroup(String group) throws ApiException {
    getTriggersByGroupWithHttpInfo(group);
  }

  /**
   * get all triggers
   * The endpoint returns triggers
   * @param group  (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> getTriggersByGroupWithHttpInfo(String group) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling getTriggersByGroup");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-triggers/{group}"
      .replaceAll("\\{" + "group" + "\\}", apiClient.escapeString(group.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    return apiClient.invokeAPI("QuartzTriggersApi.getTriggersByGroup", localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * set triggers cron by group and name
   * setting triggers cron to the specified group
   * @param group  (required)
   * @param name  (required)
   * @param body A payload for modifying cron (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public void setTriggerCron(String group, String name, String body) throws ApiException {
    setTriggerCronWithHttpInfo(group, name, body);
  }

  /**
   * set triggers cron by group and name
   * setting triggers cron to the specified group
   * @param group  (required)
   * @param name  (required)
   * @param body A payload for modifying cron (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setTriggerCronWithHttpInfo(String group, String name, String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling setTriggerCron");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling setTriggerCron");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-triggers/{group}/{name}"
      .replaceAll("\\{" + "group" + "\\}", apiClient.escapeString(group.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    return apiClient.invokeAPI("QuartzTriggersApi.setTriggerCron", localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * set triggers cron by group
   * setting triggers cron to the specified group
   * @param group  (required)
   * @param body A payload for modifying cron (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public void setTriggersCron(String group, String body) throws ApiException {
    setTriggersCronWithHttpInfo(group, body);
  }

  /**
   * set triggers cron by group
   * setting triggers cron to the specified group
   * @param group  (required)
   * @param body A payload for modifying cron (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Validation Exception. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> Unauthorized. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> You do not have permission to perform this action. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The specified resource was not found. </td><td>  -  </td></tr>
       <tr><td> 409 </td><td> Conflict with current state of the resource. </td><td>  -  </td></tr>
       <tr><td> 0 </td><td> Something went wrong. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setTriggersCronWithHttpInfo(String group, String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling setTriggersCron");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-triggers/{group}"
      .replaceAll("\\{" + "group" + "\\}", apiClient.escapeString(group.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    
    return apiClient.invokeAPI("QuartzTriggersApi.setTriggersCron", localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
