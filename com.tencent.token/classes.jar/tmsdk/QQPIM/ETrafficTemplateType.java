package tmsdk.QQPIM;

public final class ETrafficTemplateType
{
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_BALANCE_BEGIN;
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_BALANCE_END;
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_EXCESS;
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_LEFT;
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_MAX;
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_MIN;
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_PACKAGE;
  public static final ETrafficTemplateType E_TRAFFIC_TEMPLATE_TYPE_USE;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_BALANCE_BEGIN = 5;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_BALANCE_END = 6;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_EXCESS = 3;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_LEFT = 1;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_MAX = 7;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_MIN = 0;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_PACKAGE = 4;
  public static final int _E_TRAFFIC_TEMPLATE_TYPE_USE = 2;
  private static ETrafficTemplateType[] ex;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!ETrafficTemplateType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ex = new ETrafficTemplateType[8];
      E_TRAFFIC_TEMPLATE_TYPE_MIN = new ETrafficTemplateType(0, 0, "E_TRAFFIC_TEMPLATE_TYPE_MIN");
      E_TRAFFIC_TEMPLATE_TYPE_LEFT = new ETrafficTemplateType(1, 1, "E_TRAFFIC_TEMPLATE_TYPE_LEFT");
      E_TRAFFIC_TEMPLATE_TYPE_USE = new ETrafficTemplateType(2, 2, "E_TRAFFIC_TEMPLATE_TYPE_USE");
      E_TRAFFIC_TEMPLATE_TYPE_EXCESS = new ETrafficTemplateType(3, 3, "E_TRAFFIC_TEMPLATE_TYPE_EXCESS");
      E_TRAFFIC_TEMPLATE_TYPE_PACKAGE = new ETrafficTemplateType(4, 4, "E_TRAFFIC_TEMPLATE_TYPE_PACKAGE");
      E_TRAFFIC_TEMPLATE_TYPE_BALANCE_BEGIN = new ETrafficTemplateType(5, 5, "E_TRAFFIC_TEMPLATE_TYPE_BALANCE_BEGIN");
      E_TRAFFIC_TEMPLATE_TYPE_BALANCE_END = new ETrafficTemplateType(6, 6, "E_TRAFFIC_TEMPLATE_TYPE_BALANCE_END");
      E_TRAFFIC_TEMPLATE_TYPE_MAX = new ETrafficTemplateType(7, 7, "E_TRAFFIC_TEMPLATE_TYPE_MAX");
      return;
    }
  }
  
  private ETrafficTemplateType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ex[paramInt1] = this;
  }
  
  public static ETrafficTemplateType convert(int paramInt)
  {
    int i = 0;
    while (i < ex.length)
    {
      if (ex[i].value() == paramInt) {
        return ex[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static ETrafficTemplateType convert(String paramString)
  {
    int i = 0;
    while (i < ex.length)
    {
      if (ex[i].toString().equals(paramString)) {
        return ex[i];
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
 * Qualified Name:     tmsdk.QQPIM.ETrafficTemplateType
 * JD-Core Version:    0.7.0.1
 */