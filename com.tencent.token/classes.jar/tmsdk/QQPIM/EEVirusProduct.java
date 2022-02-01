package tmsdk.QQPIM;

import java.io.Serializable;

public final class EEVirusProduct
  implements Serializable
{
  public static final EEVirusProduct MOBILE_QQ = new EEVirusProduct(1, 1, "MOBILE_QQ");
  public static final EEVirusProduct NONE;
  public static final EEVirusProduct WEIXIN = new EEVirusProduct(2, 2, "WEIXIN");
  public static final int _MOBILE_QQ = 1;
  public static final int _NONE = 0;
  public static final int _WEIXIN = 2;
  private static EEVirusProduct[] el = new EEVirusProduct[3];
  private int eb;
  private String ec = new String();
  
  static
  {
    NONE = new EEVirusProduct(0, 0, "NONE");
  }
  
  private EEVirusProduct(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    el[paramInt1] = this;
  }
  
  public static EEVirusProduct convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EEVirusProduct[] arrayOfEEVirusProduct = el;
      if (i >= arrayOfEEVirusProduct.length) {
        break;
      }
      if (arrayOfEEVirusProduct[i].value() == paramInt) {
        return el[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EEVirusProduct convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EEVirusProduct[] arrayOfEEVirusProduct = el;
      if (i >= arrayOfEEVirusProduct.length) {
        break;
      }
      if (arrayOfEEVirusProduct[i].toString().equals(paramString)) {
        return el[i];
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
 * Qualified Name:     tmsdk.QQPIM.EEVirusProduct
 * JD-Core Version:    0.7.0.1
 */