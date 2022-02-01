package retrofit;

import retrofit.client.Response;

final class ResponseWrapper
{
  final Response response;
  final Object responseBody;
  
  ResponseWrapper(Response paramResponse, Object paramObject)
  {
    this.response = paramResponse;
    this.responseBody = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.ResponseWrapper
 * JD-Core Version:    0.7.0.1
 */