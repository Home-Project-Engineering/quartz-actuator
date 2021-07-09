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
public class QuartzJobsApi {
  private ApiClient apiClient;

  public QuartzJobsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public QuartzJobsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }
  /**
   * get all jobs
   * The endpoint returns jobs
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
  public void getAllJobs() throws ApiException {
    getAllJobsWithHttpInfo();
  }

  /**
   * get all jobs
   * The endpoint returns jobs
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
  public ApiResponse<Void> getAllJobsWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/quartz-jobs";

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

    
    return apiClient.invokeAPI("QuartzJobsApi.getAllJobs", localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
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
  public void getJobByGroupAndName(String group, String name) throws ApiException {
    getJobByGroupAndNameWithHttpInfo(group, name);
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
  public ApiResponse<Void> getJobByGroupAndNameWithHttpInfo(String group, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling getJobByGroupAndName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling getJobByGroupAndName");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-jobs/{group}/{name}"
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

    
    return apiClient.invokeAPI("QuartzJobsApi.getJobByGroupAndName", localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * get all jobs
   * The endpoint returns jobs
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
  public void getJobsByGroup(String group) throws ApiException {
    getJobsByGroupWithHttpInfo(group);
  }

  /**
   * get all jobs
   * The endpoint returns jobs
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
  public ApiResponse<Void> getJobsByGroupWithHttpInfo(String group) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling getJobsByGroup");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-jobs/{group}"
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

    
    return apiClient.invokeAPI("QuartzJobsApi.getJobsByGroup", localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * set job state
   * setting job state
   * @param group  (required)
   * @param name  (required)
   * @param body A payload for modifying state (optional)
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
  public void setJobState(String group, String name, String body) throws ApiException {
    setJobStateWithHttpInfo(group, name, body);
  }

  /**
   * set job state
   * setting job state
   * @param group  (required)
   * @param name  (required)
   * @param body A payload for modifying state (optional)
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
  public ApiResponse<Void> setJobStateWithHttpInfo(String group, String name, String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling setJobState");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling setJobState");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-jobs/{group}/{name}"
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

    
    return apiClient.invokeAPI("QuartzJobsApi.setJobState", localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * set jobs state by group
   * setting jobs state to the specified group
   * @param group  (required)
   * @param body A payload for modifying state (optional)
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
  public void setJobsState(String group, String body) throws ApiException {
    setJobsStateWithHttpInfo(group, body);
  }

  /**
   * set jobs state by group
   * setting jobs state to the specified group
   * @param group  (required)
   * @param body A payload for modifying state (optional)
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
  public ApiResponse<Void> setJobsStateWithHttpInfo(String group, String body) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling setJobsState");
    }
    
    // create path and map variables
    String localVarPath = "/quartz-jobs/{group}"
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

    
    return apiClient.invokeAPI("QuartzJobsApi.setJobsState", localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
