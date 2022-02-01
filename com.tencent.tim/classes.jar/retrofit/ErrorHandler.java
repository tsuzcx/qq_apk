package retrofit;

public abstract interface ErrorHandler
{
  public static final ErrorHandler DEFAULT = new ErrorHandler.1();
  
  public abstract Throwable handleError(RetrofitError paramRetrofitError);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.ErrorHandler
 * JD-Core Version:    0.7.0.1
 */