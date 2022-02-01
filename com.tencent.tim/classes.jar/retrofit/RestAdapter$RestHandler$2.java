package retrofit;

import java.util.concurrent.Executor;

class RestAdapter$RestHandler$2
  extends CallbackRunnable
{
  RestAdapter$RestHandler$2(RestAdapter.RestHandler paramRestHandler, Callback paramCallback, Executor paramExecutor, ErrorHandler paramErrorHandler, RequestInterceptorTape paramRequestInterceptorTape, RestMethodInfo paramRestMethodInfo, Object[] paramArrayOfObject)
  {
    super(paramCallback, paramExecutor, paramErrorHandler);
  }
  
  public ResponseWrapper obtainResponse()
  {
    return (ResponseWrapper)RestAdapter.RestHandler.access$100(this.this$1, this.val$interceptorTape, this.val$methodInfo, this.val$args);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RestAdapter.RestHandler.2
 * JD-Core Version:    0.7.0.1
 */