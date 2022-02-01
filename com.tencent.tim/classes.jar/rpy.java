class rpy
{
  final String aBI;
  boolean isDone;
  final boolean success;
  
  rpy(boolean paramBoolean, String paramString)
  {
    this.success = paramBoolean;
    this.aBI = paramString;
  }
  
  static rpy a()
  {
    return new rpy(false, "");
  }
  
  static rpy a(Process paramProcess)
  {
    if (d(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = rqx.f(paramProcess.getInputStream());; str = rqx.f(paramProcess.getErrorStream())) {
      return new rpy(d(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean d(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpy
 * JD-Core Version:    0.7.0.1
 */