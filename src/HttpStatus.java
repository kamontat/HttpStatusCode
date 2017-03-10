import java.util.*;

/**
 * Base on wikipedia & Ben Griffiths Code
 * <ul>
 * <li><a href="https://github.com/whostolebenfrog/status-codes/blob/master/src/main/java/com/floatbackwards/statuscodes/HttpStatus.java">Github gist</a></li>
 * <li><a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">Wiki</a></li>
 * </ul>
 *
 * @author kamontat
 * @version 1.0
 * @since Fri 10/Mar/2017 - 12:19 AM
 */
public enum HttpStatus {
	/**
	 * <b>Information</b> <br>
	 * The server has received the request headers and the client should proceed to send the request body (in the case of a request for which a body needs to be sent; for example, a POST request).
	 */
	Continue(100, "The client should continue with its request."),
	/**
	 * <b>Information</b> <br>
	 * The requester has asked the server to switch protocols and the server has agreed to do so.
	 */
	Switching_Protocols(101, "Informs the client that the server will switch to the protocol specified in the Upgrade message header field."),
	/**
	 * <b>Information</b> <br>
	 * A WebDAV request may contain many sub-requests involving file operations, requiring a long time to complete the request. This code indicates that the server has received and is processing the request, but no response is available yet. This prevents the client from timing out and assuming the request was lost.
	 */
	Processing(102, "The server requiring a long time to complete the request. This prevents the client from timing out and assuming the request was lost."),
	/**
	 * <b>Information</b> <br>
	 * (ResumableHttpRequestsProposal) Used in the resumable requests proposal to resume aborted PUT or POST requests.
	 */
	Checkpoint(103, "Used in the resumable requests proposal to resume aborted PUT or POST requests.[65]"),
	/**
	 * <b>Information</b> <br>
	 * (Oku, Kazuho) Used to return some response headers before entire HTTP response.
	 */
	Early_Hints(103, "Used to return some response headers before entire HTTP response."),
	
	// --------------------------------------------------------------------
	
	/**
	 * <b>Success</b> <br>
	 * Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action.
	 */
	OK(200, "The request sent by the client was successful."),
	/**
	 * <b>Success</b> <br>
	 * The request has been fulfilled, resulting in the creation of a new resource.
	 */
	Created(201, "The request was successful and the resource has been created."),
	/**
	 * <b>Success</b> <br>
	 * The request has been accepted for processing, but the processing has not been completed. The request might or might not be eventually acted upon, and may be disallowed when processing occurs.
	 */
	Accepted(202, "The request has been accepted but has not yet finished processing."),
	/**
	 * <b>Success</b> <br>
	 * The server is a transforming proxy (e.g. a Web accelerator) that received a 200 OK from its origin, but is returning a modified version of the origin's response.
	 */
	Non_Authoritative_Information(203, "The returned meta-information in the entity header is not the definitive set of information, it might be a local copy or contain local alterations."),
	/**
	 * <b>Success</b> <br>
	 * The server successfully processed the request and is not returning any content.
	 */
	No_Content(204, "The request was successful but not require the return of an entity body."),
	/**
	 * <b>Success</b> <br>
	 * The server successfully processed the request, but is not returning any content. Unlike a 204 response, this response requires that the requester reset the document view.
	 */
	Reset_Content(205, "The request was successful and the user agent should reset the view that sent the request."),
	/**
	 * <b>Success</b> <br>
	 * The server is delivering only part of the resource (byte serving) due to a range header sent by the client. The range header is used by HTTP clients to enable resuming of interrupted downloads, or split a download into multiple simultaneous streams.
	 */
	Partial_Content(206, "The partial request was successful."),
	/**
	 * <b>Success</b> <br>
	 * The message body that follows is an XML message and can contain a number of separate response codes, depending on how many sub-requests were made.
	 */
	Multi_Status(207, "The message body that follows is an XML message and can contain a number of separate response codes, depending on how many sub-requests were made."),
	/**
	 * <b>Success</b> <br>
	 * The members of a DAV binding have already been enumerated in a previous reply to this request, and are not being included again.
	 */
	Already_Reported(208, "The members of a DAV binding have already been enumerated in a previous reply to this request, and are not being included again.[16]"),
	/**
	 * <b>Success</b> <br>
	 * The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.
	 */
	IM_Used(226, "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance."),
	
	// --------------------------------------------------------------------
	
	/**
	 * <b>Redirection</b> <br>
	 * Indicates multiple options for the resource from which the client may choose (via agent-driven content negotiation). For example, this code could be used to present multiple video format options, to list files with different filename extensions, or to suggest word-sense disambiguation.
	 */
	Multiple_Choices(300, "The requested resource has multiple choices, each of which has a different location."),
	/**
	 * <b>Redirection</b> <br>
	 * This and all future requests should be directed to the given URI.
	 */
	Moved_Permanently(301, "The requested resources has moved permanently to a new location."),
	/**
	 * <b>Redirection</b> <br>
	 * This is an example of industry practice contradicting the standard. The HTTP/1.0 specification (RFC 1945) required the client to perform a temporary redirect (the original describing phrase was "Moved Temporarily"), but popular browsers implemented 302 with the functionality of a 303 See Other. Therefore, HTTP/1.1 added status codes 303 and 307 to distinguish between the two behaviours.
	 */
	Found(302, "The requested resource has been found at a different location but the client should use the original URI."),
	/**
	 * <b>Redirection</b> <br>
	 * The response to the request can be found under another URI using a GET method. When received in response to a POST (or PUT/DELETE), the client should presume that the server has received the data and should issue a redirect with a separate GET message.
	 */
	See_Other(303, "The requested resource is located at a different location which should be returned by the location field in the response."),
	/**
	 * <b>Redirection</b> <br>
	 * Indicates that the resource has not been modified since the version specified by the request headers If-Modified-Since or If-None-Match. In such case, there is no need to retransmit the resource since the client still has a previously-downloaded copy.
	 */
	Not_Modified(304, "The resource has not been modified since the last request."),
	/**
	 * <b>Redirection</b> <br>
	 * The requested resource is available only through a proxy, the address for which is provided in the response. Many HTTP clients (such as Mozilla and Internet Explorer) do not correctly handle responses with this status code, primarily for security reasons.
	 */
	Use_Proxy(305, "The requested resource can only be accessed through a proxy which should be provided in the location field."),
	/**
	 * <b>Redirection</b> <br>
	 * No longer used.
	 */
	Switch_Proxy(306, "No longer used. Originally meant Subsequent requests should use the specified proxy."),
	/**
	 * <b>Redirection</b> <br>
	 * In this case, the request should be repeated with another URI; however, future requests should still use the original URI. In contrast to how 302 was historically implemented, the request method is not allowed to be changed when reissuing the original request. For example, a POST request should be repeated using another POST request.
	 */
	Temporary_Redirect(307, "The requested resource is temporarily moved to the provided location but the client should continue to use this location as the resource may again move."),
	/**
	 * <b>Redirection</b> <br>
	 * The request and all future requests should be repeated using another URI. 307 and 308 parallel the behaviors of 302 and 301, but do not allow the HTTP method to change. So, for example, submitting a form to a permanently redirected resource may continue smoothly.
	 */
	Permanent_Redirect(308, "The request and all future requests should be repeated using another URI. Do not allow the HTTP method to change."),
	
	// --------------------------------------------------------------------
	
	Bad_Request(400, "The request could not be understood by the server."),
	Unauthorized(401, "The request requires authorization."),
	Payment_Required(402, "Reserved for future use."),
	Forbidden(403, "Whilst the server did understand the request, the server is refusing to complete it. This is not an authorization problem."),
	Not_Found(404, "The requested resource was not found."),
	Method_Not_Allowed(405, "The supplied method was not allowed on the given resource."),
	Not_Acceptable(406, "The resource is not able to return a response that is suitable for the characteristics required by the accept headers of the request."),
	Proxy_Authentication_Required(407, "The client must authenticate themselves with the proxy."),
	Request_Timeout(408, "The client did not supply a request in the period required by the server."),
	Conflict(409, "The request could not be completed as the resource is in a conflicted state."),
	Gone(410, "The requested resource is no longer available on the server and no redirect address is available."),
	Length_Required(411, "The server will not accept the request without a Content-Length field."),
	Precondition_Failed(412, "The supplied precondition evaluated to false on the server."),
	Request_Entity_Too_Large(413, "The request was unsuccessful because the request entity was larger than the server would allow"),
	Requested_URI_Too_Long(414, "The request was unsuccessful because the requested URI is longer than the server is willing to process (that's what she said)."),
	Unsupported_Media_Type(415, "The request was unsuccessful because the request was for an unsupported format."),
	Request_Range_Not_Satisfiable(416, "The range of the resource does not overlap with the values specified in the requests Range header field and not alternative If-Range field was supplied."),
	Expectation_Failed(417, "The expectation supplied in the Expectation header field could not be met by the server."),
	Im_A_Teapot(418, "I'm a teapot (IETF April Fools' jokes)"),
	/**
	 * Spring Framework
	 */
	Method_Failure(420, "A deprecated response when a method has failed."),
	/**
	 * version 1 of the Twitter Search and Trends API
	 */
	Enhance_Your_Calm(420, "The client is being rate limited"),
	Misdirected_Request(421, "The request was directed at a server that is not able to produce a response (for example because a connection reuse)"),
	Unprocessed_Entity(422, "The request was well-formed but was unable to be followed due to semantic errors."),
	Locked(423, "The resource that is being accessed is locked."),
	Failed_Dependency(424, "The request failed due to failure of a previous request."),
	Upgrade_Required(426, "The client should switch to a different protocol , given in the Upgrade header field."),
	Precondition_Required(428, "The origin server requires the request to be conditional. Intended to prevent the lost update problem."),
	Too_Many_Requests(429, "The user has sent too many requests in a given amount of time. Intended for use with rate-limiting schemes."),
	Request_Header_Fields_Too_Large(431, "The server is unwilling to process the request because either an individual header field, or all the header fields, are too large."),
	Login_Time_Out(440, "The client's session has expired."),
	Retry_With(449, "The server cannot honour the request because the user has not provided the required information."),
	/**
	 * Microsoft
	 */
	Blocked_by_Windows_Parental_Controls(450, "when Windows Parental Controls are turned on and are blocking access to the given webpage."),
	Unavailable_For_Legal_Reasons(451, "A server operator has received a legal demand to deny access to a resource or to a set of resources that includes the requested resource."),
	/**
	 * Exchange ActiveSync
	 */
	Redirect(451, "Used when either a more efficient server is available or the server cannot access the users' mailbox."),
	/**
	 * (Esri) ArcGIS Server
	 */
	Invalid_Token(498, "indicates an expired or otherwise invalid token."),
	/**
	 * (Esri) ArcGIS Server
	 */
	Token_Required(499, "indicates that a token is required but was not submitted."),
	
	// --------------------------------------------------------------------
	
	Internal_Server_Error(500, "The request was unsuccessful because the server encountered an unexpected error."),
	Not_Implemented(501, "The server does not support the request."),
	Bad_Gateway(502, "The server, whilst acting as a proxy, received an invalid response from the server that was fulfilling the request."),
	Service_Unavailable(503, "The request was unsuccessful as the server is either down or slash reedited."),
	Gateway_Timeout(504, "The server, whilst acting as a proxy, did not receive a response from the upstream server in an acceptable time."),
	Http_Version_Not_Supported(505, "The server does not supported the HTTP protocol version specified in the request"),
	
	Variant_Also_Negotiates(506, "Transparent content negotiation for the request results in a circular reference."),
	Insufficient_Storage(507, "The server is unable to store the representation needed to complete the request."),
	Loop_Detected(508, "The server detected an infinite loop while processing the request."),
	/**
	 * shared hosting providers
	 */
	Bandwidth_Limit_Exceeded(509, "The server has exceeded the bandwidth specified by the server administrator."),
	Not_Extended(510, "Further extensions to the request are required for the server to fulfill it."),
	Network_Authentication_Required(511, "The client needs to authenticate to gain network access."),
	/**
	 * the Pantheon web platform
	 */
	Site_is_Frozen(530, "indicate a site that has been frozen due to inactivity."),
	/**
	 * some HTTP proxies
	 */
	Network_read_timeout_error(598, "to signal a network read timeout behind the proxy to a client in front of the proxy."),
	
	Network_connect_timeout_error(599, "indicate when the connection to the network times out."),
	
	// --------------------------------------------------------------------
	
	Unknown(999, "Unknown or unsupported HTTP status code");
	
	private final int code;
	private final String name;
	private final String description;
	private final String jsonString;
	
	private HttpStatus(int code, String description) {
		this.code = code;
		this.name = this.name().replace("_", " ");
		this.description = description;
		this.jsonString = generateJsonString();
	}
	
	/**
	 * Returns the int status code this enum represents
	 *
	 * @return the int status code this enum represents
	 */
	public final int getCode() {
		return code;
	}
	
	/**
	 * Returns the name of the HTTP status this enum represents
	 *
	 * @return the name of the HTTP status this enum represents
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Returns a description of the HTTP status this enum represents
	 *
	 * @return a description of the HTTP status this enum represents
	 */
	public final String getDescription() {
		return description;
	}
	
	/**
	 * Returns a json string representing this HttpStatus
	 *
	 * @return a json string representing this HttpStatus
	 */
	public final String getJsonString() {
		return jsonString;
	}
	
	/**
	 * Returns the HttpStatus object with a code matching the supplied int
	 *
	 * @param httpStatus
	 * 		the httpStatus code
	 * @return the HttpStatus object with a code matching the supplied int
	 */
	public static HttpStatus[] getByCode(int httpStatus) {
		ArrayList<HttpStatus> statusList = new ArrayList<>();
		for (HttpStatus status : HttpStatus.values()) {
			if (status.getCode() == httpStatus) {
				statusList.add(status);
			}
		}
		return statusList.size() == 0 ? new HttpStatus[]{Unknown}: statusList.toArray(new HttpStatus[statusList.size()]);
	}
	
	/**
	 * Returns the HttpStatus with the Integer code that matches the supplied
	 * String. Returns HttpStatus.Unknown if the supplied String is not a valid
	 * Integer or is not in the list of available HTTP status codes.
	 *
	 * @param httpStatus
	 * 		the String containing the status code to match
	 * @return the HttpStatus for the supplied String
	 */
	public static HttpStatus[] getByCode(String httpStatus) {
		int statusCode;
		try {
			statusCode = Integer.parseInt(httpStatus);
		} catch (NumberFormatException e) {
			return new HttpStatus[]{Unknown};
		}
		return getByCode(statusCode);
	}
	
	/**
	 * Returns a json string representing this HttpStatus
	 *
	 * @return a json string representing this HttpStatus
	 */
	public String generateJsonString() {
		return String.format("{\"code\": %s, \"name\": \"%s\", \"description\": \"%s\"}", code, name, description);
	}
	
	@Override
	public String toString() {
		return String.format("{\n\t\"code\": %s, \n\t\"name\": \"%s\", \n\t\"description\": \"%s\"}", code, name, description);
	}
}