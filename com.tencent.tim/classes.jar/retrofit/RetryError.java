package retrofit;

public class RetryError
  extends RuntimeException
{
  private Throwable cause;
  
  public RetryError(Throwable paramThrowable)
  {
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RetryError
 * JD-Core Version:    0.7.0.1
 */