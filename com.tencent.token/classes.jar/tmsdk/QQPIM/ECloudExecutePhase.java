package tmsdk.QQPIM;

public final class ECloudExecutePhase
{
  public static final ECloudExecutePhase ECEP_Phase_Execute;
  public static final ECloudExecutePhase ECEP_Phase_None;
  public static final ECloudExecutePhase ECEP_Phase_Show;
  public static final ECloudExecutePhase ECEP_Phase_User_Confirm;
  public static final int _ECEP_Phase_Execute = 3;
  public static final int _ECEP_Phase_None = 0;
  public static final int _ECEP_Phase_Show = 1;
  public static final int _ECEP_Phase_User_Confirm = 2;
  private static ECloudExecutePhase[] ej;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!ECloudExecutePhase.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ej = new ECloudExecutePhase[4];
      ECEP_Phase_None = new ECloudExecutePhase(0, 0, "ECEP_Phase_None");
      ECEP_Phase_Show = new ECloudExecutePhase(1, 1, "ECEP_Phase_Show");
      ECEP_Phase_User_Confirm = new ECloudExecutePhase(2, 2, "ECEP_Phase_User_Confirm");
      ECEP_Phase_Execute = new ECloudExecutePhase(3, 3, "ECEP_Phase_Execute");
      return;
    }
  }
  
  private ECloudExecutePhase(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ej[paramInt1] = this;
  }
  
  public static ECloudExecutePhase convert(int paramInt)
  {
    int i = 0;
    while (i < ej.length)
    {
      if (ej[i].value() == paramInt) {
        return ej[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static ECloudExecutePhase convert(String paramString)
  {
    int i = 0;
    while (i < ej.length)
    {
      if (ej[i].toString().equals(paramString)) {
        return ej[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
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
 * Qualified Name:     tmsdk.QQPIM.ECloudExecutePhase
 * JD-Core Version:    0.7.0.1
 */