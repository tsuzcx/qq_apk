class aibw
{
  public static aibw a = new aibw(null);
  private Object[] argArray;
  private String message;
  private Throwable throwable;
  
  public aibw(String paramString)
  {
    this(paramString, null, null);
  }
  
  public aibw(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    this.message = paramString;
    this.throwable = paramThrowable;
    this.argArray = paramArrayOfObject;
  }
  
  public String getMessage()
  {
    return this.message;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibw
 * JD-Core Version:    0.7.0.1
 */