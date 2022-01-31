package protocol.KQQConfig;

import java.io.Serializable;

public final class ENResourceType
  implements Serializable
{
  public static final int _eRES_TYPE_IMAGE = 0;
  public static final int _eRES_TYPE_LABEL = 3;
  public static final int _eRES_TYPE_MAX = 1024;
  public static final int _eRES_TYPE_MIN = -1;
  public static final int _eRES_TYPE_MQQ_PLUGIN = 64;
  public static final int _eRES_TYPE_PLUGIN = 1;
  public static final int _eRES_TYPE_THEME = 2;
  private static ENResourceType[] a;
  public static final ENResourceType eRES_TYPE_IMAGE;
  public static final ENResourceType eRES_TYPE_LABEL;
  public static final ENResourceType eRES_TYPE_MAX;
  public static final ENResourceType eRES_TYPE_MIN;
  public static final ENResourceType eRES_TYPE_MQQ_PLUGIN;
  public static final ENResourceType eRES_TYPE_PLUGIN;
  public static final ENResourceType eRES_TYPE_THEME;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!ENResourceType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new ENResourceType[7];
      eRES_TYPE_MIN = new ENResourceType(0, -1, "eRES_TYPE_MIN");
      eRES_TYPE_IMAGE = new ENResourceType(1, 0, "eRES_TYPE_IMAGE");
      eRES_TYPE_PLUGIN = new ENResourceType(2, 1, "eRES_TYPE_PLUGIN");
      eRES_TYPE_THEME = new ENResourceType(3, 2, "eRES_TYPE_THEME");
      eRES_TYPE_LABEL = new ENResourceType(4, 3, "eRES_TYPE_LABEL");
      eRES_TYPE_MQQ_PLUGIN = new ENResourceType(5, 64, "eRES_TYPE_MQQ_PLUGIN");
      eRES_TYPE_MAX = new ENResourceType(6, 1024, "eRES_TYPE_MAX");
      return;
    }
  }
  
  private ENResourceType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static ENResourceType convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static ENResourceType convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
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
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.ENResourceType
 * JD-Core Version:    0.7.0.1
 */