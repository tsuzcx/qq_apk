package tmsdk.QQPIM;

import java.io.Serializable;

public final class ESubPlatform
  implements Serializable
{
  public static final ESubPlatform ESP_Android_General;
  public static final ESubPlatform ESP_Android_HD;
  public static final ESubPlatform ESP_Android_Pad;
  public static final ESubPlatform ESP_BB_General;
  public static final ESubPlatform ESP_END = new ESubPlatform(19, 902, "ESP_END");
  public static final ESubPlatform ESP_Ipad;
  public static final ESubPlatform ESP_Iphone_General;
  public static final ESubPlatform ESP_Ipod;
  public static final ESubPlatform ESP_Kjava_General;
  public static final ESubPlatform ESP_MTK_General;
  public static final ESubPlatform ESP_NK_Kjava_General;
  public static final ESubPlatform ESP_NONE;
  public static final ESubPlatform ESP_PC_WindowsGeneral;
  public static final ESubPlatform ESP_Server_General;
  public static final ESubPlatform ESP_Symbian_3;
  public static final ESubPlatform ESP_Symbian_V2;
  public static final ESubPlatform ESP_Symbian_V3;
  public static final ESubPlatform ESP_Symbian_V5;
  public static final ESubPlatform ESP_WinPhone_General;
  public static final ESubPlatform ESP_WinPhone_Tablet;
  public static final int _ESP_Android_General = 201;
  public static final int _ESP_Android_HD = 203;
  public static final int _ESP_Android_Pad = 202;
  public static final int _ESP_BB_General = 801;
  public static final int _ESP_END = 902;
  public static final int _ESP_Ipad = 302;
  public static final int _ESP_Iphone_General = 301;
  public static final int _ESP_Ipod = 303;
  public static final int _ESP_Kjava_General = 401;
  public static final int _ESP_MTK_General = 701;
  public static final int _ESP_NK_Kjava_General = 402;
  public static final int _ESP_NONE = 0;
  public static final int _ESP_PC_WindowsGeneral = 901;
  public static final int _ESP_Server_General = 501;
  public static final int _ESP_Symbian_3 = 104;
  public static final int _ESP_Symbian_V2 = 103;
  public static final int _ESP_Symbian_V3 = 101;
  public static final int _ESP_Symbian_V5 = 102;
  public static final int _ESP_WinPhone_General = 601;
  public static final int _ESP_WinPhone_Tablet = 602;
  private static ESubPlatform[] ev = new ESubPlatform[20];
  private int eb;
  private String ec = new String();
  
  static
  {
    ESP_NONE = new ESubPlatform(0, 0, "ESP_NONE");
    ESP_Symbian_V3 = new ESubPlatform(1, 101, "ESP_Symbian_V3");
    ESP_Symbian_V5 = new ESubPlatform(2, 102, "ESP_Symbian_V5");
    ESP_Symbian_V2 = new ESubPlatform(3, 103, "ESP_Symbian_V2");
    ESP_Symbian_3 = new ESubPlatform(4, 104, "ESP_Symbian_3");
    ESP_Android_General = new ESubPlatform(5, 201, "ESP_Android_General");
    ESP_Android_Pad = new ESubPlatform(6, 202, "ESP_Android_Pad");
    ESP_Android_HD = new ESubPlatform(7, 203, "ESP_Android_HD");
    ESP_Iphone_General = new ESubPlatform(8, 301, "ESP_Iphone_General");
    ESP_Ipad = new ESubPlatform(9, 302, "ESP_Ipad");
    ESP_Ipod = new ESubPlatform(10, 303, "ESP_Ipod");
    ESP_Kjava_General = new ESubPlatform(11, 401, "ESP_Kjava_General");
    ESP_NK_Kjava_General = new ESubPlatform(12, 402, "ESP_NK_Kjava_General");
    ESP_Server_General = new ESubPlatform(13, 501, "ESP_Server_General");
    ESP_WinPhone_General = new ESubPlatform(14, 601, "ESP_WinPhone_General");
    ESP_WinPhone_Tablet = new ESubPlatform(15, 602, "ESP_WinPhone_Tablet");
    ESP_MTK_General = new ESubPlatform(16, 701, "ESP_MTK_General");
    ESP_BB_General = new ESubPlatform(17, 801, "ESP_BB_General");
    ESP_PC_WindowsGeneral = new ESubPlatform(18, 901, "ESP_PC_WindowsGeneral");
  }
  
  private ESubPlatform(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ev[paramInt1] = this;
  }
  
  public static ESubPlatform convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      ESubPlatform[] arrayOfESubPlatform = ev;
      if (i >= arrayOfESubPlatform.length) {
        break;
      }
      if (arrayOfESubPlatform[i].value() == paramInt) {
        return ev[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static ESubPlatform convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      ESubPlatform[] arrayOfESubPlatform = ev;
      if (i >= arrayOfESubPlatform.length) {
        break;
      }
      if (arrayOfESubPlatform[i].toString().equals(paramString)) {
        return ev[i];
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
 * Qualified Name:     tmsdk.QQPIM.ESubPlatform
 * JD-Core Version:    0.7.0.1
 */