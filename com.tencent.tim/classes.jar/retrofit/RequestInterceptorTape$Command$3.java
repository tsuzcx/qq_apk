package retrofit;

 enum RequestInterceptorTape$Command$3
{
  RequestInterceptorTape$Command$3()
  {
    super(str, i, null);
  }
  
  public void intercept(RequestInterceptor.RequestFacade paramRequestFacade, String paramString1, String paramString2)
  {
    paramRequestFacade.addEncodedPathParam(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RequestInterceptorTape.Command.3
 * JD-Core Version:    0.7.0.1
 */