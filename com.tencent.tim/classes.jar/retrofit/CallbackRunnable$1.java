package retrofit;

class CallbackRunnable$1
  implements Runnable
{
  CallbackRunnable$1(CallbackRunnable paramCallbackRunnable, ResponseWrapper paramResponseWrapper) {}
  
  public void run()
  {
    CallbackRunnable.access$000(this.this$0).success(this.val$wrapper.responseBody, this.val$wrapper.response);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.CallbackRunnable.1
 * JD-Core Version:    0.7.0.1
 */