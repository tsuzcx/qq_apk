package retrofit;

 enum RequestInterceptorTape$Command$4
{
  RequestInterceptorTape$Command$4()
  {
    super(str, i, null);
  }
  
  public void intercept(RequestInterceptor.RequestFacade paramRequestFacade, String paramString1, String paramString2)
  {
    paramRequestFacade.addQueryParam(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RequestInterceptorTape.Command.4
 * JD-Core Version:    0.7.0.1
 */