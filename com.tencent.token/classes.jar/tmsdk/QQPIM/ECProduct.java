package tmsdk.QQPIM;

public final class ECProduct
{
  public static final ECProduct ECP_END;
  public static final ECProduct ECP_HIPhonebook;
  public static final ECProduct ECP_None;
  public static final ECProduct ECP_Phonebook;
  public static final ECProduct ECP_Pim;
  public static final ECProduct ECP_Secure;
  public static final int _ECP_END = 5;
  public static final int _ECP_HIPhonebook = 4;
  public static final int _ECP_None = 0;
  public static final int _ECP_Phonebook = 2;
  public static final int _ECP_Pim = 3;
  public static final int _ECP_Secure = 1;
  private static ECProduct[] eg;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!ECProduct.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      eg = new ECProduct[6];
      ECP_None = new ECProduct(0, 0, "ECP_None");
      ECP_Secure = new ECProduct(1, 1, "ECP_Secure");
      ECP_Phonebook = new ECProduct(2, 2, "ECP_Phonebook");
      ECP_Pim = new ECProduct(3, 3, "ECP_Pim");
      ECP_HIPhonebook = new ECProduct(4, 4, "ECP_HIPhonebook");
      ECP_END = new ECProduct(5, 5, "ECP_END");
      return;
    }
  }
  
  private ECProduct(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    eg[paramInt1] = this;
  }
  
  public static ECProduct convert(int paramInt)
  {
    int i = 0;
    while (i < eg.length)
    {
      if (eg[i].value() == paramInt) {
        return eg[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static ECProduct convert(String paramString)
  {
    int i = 0;
    while (i < eg.length)
    {
      if (eg[i].toString().equals(paramString)) {
        return eg[i];
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
 * Qualified Name:     tmsdk.QQPIM.ECProduct
 * JD-Core Version:    0.7.0.1
 */