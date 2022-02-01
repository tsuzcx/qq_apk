public class qwr
{
  public static ThreadLocal<StringBuilder> o = new qws();
  
  public static String b(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = (StringBuilder)o.get();
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        if (localObject != null) {
          localStringBuilder.append(localObject.toString());
        }
        i += 1;
      }
    }
    return "";
    paramVarArgs = localStringBuilder.toString();
    if (localStringBuilder.length() > 512) {
      o.set(new StringBuilder(512));
    }
    localStringBuilder.setLength(0);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwr
 * JD-Core Version:    0.7.0.1
 */