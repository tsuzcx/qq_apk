package tmsdk.QQPIM;

public final class ECloudCmdUserAction
{
  public static final ECloudCmdUserAction EUA_Accept = new ECloudCmdUserAction(1, 1, "EUA_Accept");
  public static final ECloudCmdUserAction EUA_None;
  public static final ECloudCmdUserAction EUA_Reject = new ECloudCmdUserAction(2, 2, "EUA_Reject");
  public static final int _EUA_Accept = 1;
  public static final int _EUA_None = 0;
  public static final int _EUA_Reject = 2;
  private static ECloudCmdUserAction[] ei = new ECloudCmdUserAction[3];
  private int eb;
  private String ec = new String();
  
  static
  {
    EUA_None = new ECloudCmdUserAction(0, 0, "EUA_None");
  }
  
  private ECloudCmdUserAction(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ei[paramInt1] = this;
  }
  
  public static ECloudCmdUserAction convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      ECloudCmdUserAction[] arrayOfECloudCmdUserAction = ei;
      if (i >= arrayOfECloudCmdUserAction.length) {
        break;
      }
      if (arrayOfECloudCmdUserAction[i].value() == paramInt) {
        return ei[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static ECloudCmdUserAction convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      ECloudCmdUserAction[] arrayOfECloudCmdUserAction = ei;
      if (i >= arrayOfECloudCmdUserAction.length) {
        break;
      }
      if (arrayOfECloudCmdUserAction[i].toString().equals(paramString)) {
        return ei[i];
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return this.ec;
  }
  
  public int value()
  {
    return this.eb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ECloudCmdUserAction
 * JD-Core Version:    0.7.0.1
 */