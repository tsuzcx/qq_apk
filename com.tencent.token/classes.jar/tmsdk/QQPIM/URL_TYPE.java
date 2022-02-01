package tmsdk.QQPIM;

import java.io.Serializable;

public final class URL_TYPE
  implements Serializable
{
  public static final URL_TYPE E_URL_BLACK_LIST = new URL_TYPE(3, 3, "E_URL_BLACK_LIST");
  public static final URL_TYPE E_URL_MAX = new URL_TYPE(4, 4, "E_URL_MAX");
  public static final URL_TYPE E_URL_REGULAR;
  public static final URL_TYPE E_URL_SHADINESS;
  public static final URL_TYPE E_URL_WHITE_LIST;
  public static final int _E_URL_BLACK_LIST = 3;
  public static final int _E_URL_MAX = 4;
  public static final int _E_URL_REGULAR = 0;
  public static final int _E_URL_SHADINESS = 2;
  public static final int _E_URL_WHITE_LIST = 1;
  private static URL_TYPE[] ff = new URL_TYPE[5];
  private int eb;
  private String ec = new String();
  
  static
  {
    E_URL_REGULAR = new URL_TYPE(0, 0, "E_URL_REGULAR");
    E_URL_WHITE_LIST = new URL_TYPE(1, 1, "E_URL_WHITE_LIST");
    E_URL_SHADINESS = new URL_TYPE(2, 2, "E_URL_SHADINESS");
  }
  
  private URL_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ff[paramInt1] = this;
  }
  
  public static URL_TYPE convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      URL_TYPE[] arrayOfURL_TYPE = ff;
      if (i >= arrayOfURL_TYPE.length) {
        break;
      }
      if (arrayOfURL_TYPE[i].value() == paramInt) {
        return ff[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static URL_TYPE convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      URL_TYPE[] arrayOfURL_TYPE = ff;
      if (i >= arrayOfURL_TYPE.length) {
        break;
      }
      if (arrayOfURL_TYPE[i].toString().equals(paramString)) {
        return ff[i];
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
 * Qualified Name:     tmsdk.QQPIM.URL_TYPE
 * JD-Core Version:    0.7.0.1
 */