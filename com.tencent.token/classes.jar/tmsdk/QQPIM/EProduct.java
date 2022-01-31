package tmsdk.QQPIM;

import java.io.Serializable;

public final class EProduct
  implements Serializable
{
  public static final EProduct EP_Album;
  public static final EProduct EP_AppAssistant;
  public static final EProduct EP_BenchMark;
  public static final EProduct EP_END;
  public static final EProduct EP_KingRoot;
  public static final EProduct EP_KingUser;
  public static final EProduct EP_King_SuperUser;
  public static final EProduct EP_MobileQQ_Secure;
  public static final EProduct EP_None;
  public static final EProduct EP_Phonebook;
  public static final EProduct EP_PhonebookPro;
  public static final EProduct EP_Phonebook_Eng;
  public static final EProduct EP_Pim;
  public static final EProduct EP_Pim_Eng;
  public static final EProduct EP_Pim_Jailbreak;
  public static final EProduct EP_Pim_Pro;
  public static final EProduct EP_PowerManager;
  public static final EProduct EP_QQBrowse_Secure;
  public static final EProduct EP_QQPhonebook;
  public static final EProduct EP_QZone;
  public static final EProduct EP_SMS_Fraud_Killer;
  public static final EProduct EP_Secure;
  public static final EProduct EP_SecurePro_Enhance;
  public static final EProduct EP_Secure_Eng;
  public static final EProduct EP_Secure_Jailbreak;
  public static final EProduct EP_Secure_Mini;
  public static final EProduct EP_Secure_SDK;
  public static final EProduct EP_Secure_SDK_Ign;
  public static final EProduct EP_Secure_SDK_Pay;
  public static final EProduct EP_TMSVirusSDK_Eng;
  public static final EProduct EP_TencentUser;
  public static final EProduct EP_Tencent_Cleaner;
  public static final EProduct EP_Tracker;
  public static final EProduct EP_WBlog;
  public static final EProduct EP_WeShare;
  public static final EProduct EP_XiaoYou;
  public static final int _EP_Album = 30;
  public static final int _EP_AppAssistant = 12;
  public static final int _EP_BenchMark = 22;
  public static final int _EP_END = 37;
  public static final int _EP_KingRoot = 14;
  public static final int _EP_KingUser = 17;
  public static final int _EP_King_SuperUser = 26;
  public static final int _EP_MobileQQ_Secure = 6;
  public static final int _EP_None = 0;
  public static final int _EP_Phonebook = 2;
  public static final int _EP_PhonebookPro = 20;
  public static final int _EP_Phonebook_Eng = 11;
  public static final int _EP_Pim = 3;
  public static final int _EP_Pim_Eng = 24;
  public static final int _EP_Pim_Jailbreak = 19;
  public static final int _EP_Pim_Pro = 18;
  public static final int _EP_PowerManager = 21;
  public static final int _EP_QQBrowse_Secure = 7;
  public static final int _EP_QQPhonebook = 4;
  public static final int _EP_QZone = 5;
  public static final int _EP_SMS_Fraud_Killer = 25;
  public static final int _EP_Secure = 1;
  public static final int _EP_SecurePro_Enhance = 23;
  public static final int _EP_Secure_Eng = 9;
  public static final int _EP_Secure_Jailbreak = 16;
  public static final int _EP_Secure_Mini = 35;
  public static final int _EP_Secure_SDK = 13;
  public static final int _EP_Secure_SDK_Abroad = 84;
  public static final int _EP_Secure_SDK_Ign = 27;
  public static final int _EP_Secure_SDK_Pay = 15;
  public static final int _EP_TMSVirusSDK_Eng = 46;
  public static final int _EP_TencentUser = 29;
  public static final int _EP_Tencent_Cleaner = 32;
  public static final int _EP_Tracker = 28;
  public static final int _EP_WBlog = 10;
  public static final int _EP_WeShare = 31;
  public static final int _EP_XiaoYou = 8;
  private static EProduct[] er;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!EProduct.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      er = new EProduct[36];
      EP_None = new EProduct(0, 0, "EP_None");
      EP_Secure = new EProduct(1, 1, "EP_Secure");
      EP_Phonebook = new EProduct(2, 2, "EP_Phonebook");
      EP_Pim = new EProduct(3, 3, "EP_Pim");
      EP_QQPhonebook = new EProduct(4, 4, "EP_QQPhonebook");
      EP_QZone = new EProduct(5, 5, "EP_QZone");
      EP_MobileQQ_Secure = new EProduct(6, 6, "EP_MobileQQ_Secure");
      EP_QQBrowse_Secure = new EProduct(7, 7, "EP_QQBrowse_Secure");
      EP_XiaoYou = new EProduct(8, 8, "EP_XiaoYou");
      EP_Secure_Eng = new EProduct(9, 9, "EP_Secure_Eng");
      EP_WBlog = new EProduct(10, 10, "EP_WBlog");
      EP_Phonebook_Eng = new EProduct(11, 11, "EP_Phonebook_Eng");
      EP_AppAssistant = new EProduct(12, 12, "EP_AppAssistant");
      EP_Secure_SDK = new EProduct(13, 13, "EP_Secure_SDK");
      EP_KingRoot = new EProduct(14, 14, "EP_KingRoot");
      EP_Secure_SDK_Pay = new EProduct(15, 15, "EP_Secure_SDK_Pay");
      EP_Secure_Jailbreak = new EProduct(16, 16, "EP_Secure_Jailbreak");
      EP_KingUser = new EProduct(17, 17, "EP_KingUser");
      EP_Pim_Pro = new EProduct(18, 18, "EP_Pim_Pro");
      EP_Pim_Jailbreak = new EProduct(19, 19, "EP_Pim_Jailbreak");
      EP_PhonebookPro = new EProduct(20, 20, "EP_PhonebookPro");
      EP_PowerManager = new EProduct(21, 21, "EP_PowerManager");
      EP_BenchMark = new EProduct(22, 22, "EP_BenchMark");
      EP_SecurePro_Enhance = new EProduct(23, 23, "EP_SecurePro_Enhance");
      EP_Pim_Eng = new EProduct(24, 24, "EP_Pim_Eng");
      EP_SMS_Fraud_Killer = new EProduct(25, 25, "EP_SMS_Fraud_Killer");
      EP_King_SuperUser = new EProduct(26, 26, "EP_King_SuperUser");
      EP_Secure_SDK_Ign = new EProduct(27, 27, "EP_Secure_SDK_Ign");
      EP_Tracker = new EProduct(28, 28, "EP_Tracker");
      EP_TencentUser = new EProduct(29, 29, "EP_TencentUser");
      EP_Album = new EProduct(30, 30, "EP_Album");
      EP_WeShare = new EProduct(31, 31, "EP_WeShare");
      EP_Tencent_Cleaner = new EProduct(32, 32, "EP_Tencent_Cleaner");
      EP_Secure_Mini = new EProduct(33, 35, "EP_Secure_Mini");
      EP_TMSVirusSDK_Eng = new EProduct(34, 46, "EP_TMSVirusSDK_Eng");
      EP_END = new EProduct(35, 37, "EP_END");
      return;
    }
  }
  
  private EProduct(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    er[paramInt1] = this;
  }
  
  public static EProduct convert(int paramInt)
  {
    int i = 0;
    while (i < er.length)
    {
      if (er[i].value() == paramInt) {
        return er[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static EProduct convert(String paramString)
  {
    int i = 0;
    while (i < er.length)
    {
      if (er[i].toString().equals(paramString)) {
        return er[i];
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
 * Qualified Name:     tmsdk.QQPIM.EProduct
 * JD-Core Version:    0.7.0.1
 */