package NS_MOBILE_AD_BANNER;

import java.io.Serializable;

public final class EBoardType
  implements Serializable
{
  public static final EBoardType EAppRmd;
  public static final EBoardType ECoverBanner;
  public static final EBoardType EGift;
  public static final EBoardType EHotBar;
  public static final EBoardType EPhoneBanner;
  public static final EBoardType EPullCornerBanner;
  public static final EBoardType EQZActiveFeeds;
  public static final EBoardType ESQActiveFeeds;
  public static final EBoardType ESignedInEvent;
  public static final EBoardType ESignedInRecommend;
  public static final EBoardType EVisitor;
  public static final EBoardType EVisitorBanner;
  public static final int _EAppRmd = 4;
  public static final int _ECoverBanner = 11;
  public static final int _EGift = 5;
  public static final int _EHotBar = 1;
  public static final int _EPhoneBanner = 2;
  public static final int _EPullCornerBanner = 12;
  public static final int _EQZActiveFeeds = 7;
  public static final int _ESQActiveFeeds = 6;
  public static final int _ESignedInEvent = 9;
  public static final int _ESignedInRecommend = 8;
  public static final int _EVisitor = 3;
  public static final int _EVisitorBanner = 10;
  private static EBoardType[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!EBoardType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new EBoardType[12];
      EHotBar = new EBoardType(0, 1, "EHotBar");
      EPhoneBanner = new EBoardType(1, 2, "EPhoneBanner");
      EVisitor = new EBoardType(2, 3, "EVisitor");
      EAppRmd = new EBoardType(3, 4, "EAppRmd");
      EGift = new EBoardType(4, 5, "EGift");
      ESQActiveFeeds = new EBoardType(5, 6, "ESQActiveFeeds");
      EQZActiveFeeds = new EBoardType(6, 7, "EQZActiveFeeds");
      ESignedInRecommend = new EBoardType(7, 8, "ESignedInRecommend");
      ESignedInEvent = new EBoardType(8, 9, "ESignedInEvent");
      EVisitorBanner = new EBoardType(9, 10, "EVisitorBanner");
      ECoverBanner = new EBoardType(10, 11, "ECoverBanner");
      EPullCornerBanner = new EBoardType(11, 12, "EPullCornerBanner");
      return;
    }
  }
  
  private EBoardType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static EBoardType convert(int paramInt)
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
  
  public static EBoardType convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_AD_BANNER.EBoardType
 * JD-Core Version:    0.7.0.1
 */