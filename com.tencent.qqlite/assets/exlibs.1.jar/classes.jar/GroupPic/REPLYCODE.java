package GroupPic;

import java.io.Serializable;

public final class REPLYCODE
  implements Serializable
{
  public static final REPLYCODE E_BLACKLIST;
  public static final REPLYCODE E_ERROR;
  public static final REPLYCODE E_NOT_FOUND;
  public static final REPLYCODE E_OK;
  public static final REPLYCODE E_REDIRECT_FAILED;
  public static final int _E_BLACKLIST = 3;
  public static final int _E_ERROR = 1;
  public static final int _E_NOT_FOUND = 4;
  public static final int _E_OK = 0;
  public static final int _E_REDIRECT_FAILED = 2;
  private static REPLYCODE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!REPLYCODE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new REPLYCODE[5];
      E_OK = new REPLYCODE(0, 0, "E_OK");
      E_ERROR = new REPLYCODE(1, 1, "E_ERROR");
      E_REDIRECT_FAILED = new REPLYCODE(2, 2, "E_REDIRECT_FAILED");
      E_BLACKLIST = new REPLYCODE(3, 3, "E_BLACKLIST");
      E_NOT_FOUND = new REPLYCODE(4, 4, "E_NOT_FOUND");
      return;
    }
  }
  
  private REPLYCODE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static REPLYCODE convert(int paramInt)
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
  
  public static REPLYCODE convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GroupPic.REPLYCODE
 * JD-Core Version:    0.7.0.1
 */