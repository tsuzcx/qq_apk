package UserGrowth;

import java.io.Serializable;

public final class eFollowStatus
  implements Serializable
{
  private static eFollowStatus[] __values;
  public static final int _eStatusBidirectFollow = 3;
  public static final int _eStatusDoesNotFollow = 2;
  public static final int _eStatusHasFollow = 1;
  public static final int _eStatusHasReverseFollow = 4;
  public static final int _eStatusNoFollow = 0;
  public static final eFollowStatus eStatusBidirectFollow;
  public static final eFollowStatus eStatusDoesNotFollow;
  public static final eFollowStatus eStatusHasFollow;
  public static final eFollowStatus eStatusHasReverseFollow;
  public static final eFollowStatus eStatusNoFollow;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eFollowStatus.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      __values = new eFollowStatus[5];
      eStatusNoFollow = new eFollowStatus(0, 0, "eStatusNoFollow");
      eStatusHasFollow = new eFollowStatus(1, 1, "eStatusHasFollow");
      eStatusDoesNotFollow = new eFollowStatus(2, 2, "eStatusDoesNotFollow");
      eStatusBidirectFollow = new eFollowStatus(3, 3, "eStatusBidirectFollow");
      eStatusHasReverseFollow = new eFollowStatus(4, 4, "eStatusHasReverseFollow");
      return;
    }
  }
  
  private eFollowStatus(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eFollowStatus convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static eFollowStatus convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.eFollowStatus
 * JD-Core Version:    0.7.0.1
 */