package com.tencent.moai.nativepages.util;

import android.util.Log;

public class DataUtil
{
  public static final String Event_Native_AD_Component_Button_Click = "Event_Native_AD_Component_Button_Click";
  public static final String Event_Native_AD_Component_Button_Show_Count = "Event_Native_AD_Component_Button_Show_Count";
  public static final String Event_Native_AD_Component_Button_Show_Time = "Event_Native_AD_Component_Button_Show_Time";
  public static final String Event_Native_AD_Component_Panorama_Image_Show_Count = "Event_Native_AD_Component_Panorama_Image_Show_Count";
  public static final String Event_Native_AD_Component_Panorama_Image_Show_Time = "Event_Native_AD_Component_Panorama_Image_Show_Time";
  public static final String Event_Native_AD_Component_Panorama_Image_Srcoll_Count = "Event_Native_AD_Component_Panorama_Image_Srcoll_Count";
  public static final String Event_Native_AD_Component_Pure_Show_Count = "Event_Native_AD_Component_Pure_Show_Count";
  public static final String Event_Native_AD_Component_Pure_Show_Time = "Event_Native_AD_Component_Pure_Show_Time";
  public static final String Event_Native_AD_Component_Scroll_Group_Scroll_Count = "Event_Native_AD_Component_Scroll_Group_Scroll_Count";
  public static final String Event_Native_AD_Component_Scroll_Group_Show_Count = "Event_Native_AD_Component_Scroll_Group_Show_Count";
  public static final String Event_Native_AD_Component_Scroll_Group_Show_Time = "Event_Native_AD_Component_Scroll_Group_Show_Time";
  public static final String Event_Native_AD_Component_Stream_Video_Length = "Event_Native_AD_Component_Stream_Video_Length";
  public static final String Event_Native_AD_Component_Stream_Video_Pause_Click = "Event_Native_AD_Component_Stream_Video_Pause_Click";
  public static final String Event_Native_AD_Component_Stream_Video_Play_Count = "Event_Native_AD_Component_Stream_Video_Play_Count";
  public static final String Event_Native_AD_Component_Stream_Video_Play_Full_Count = "Event_Native_AD_Component_Stream_Video_Play_Full_Count";
  public static final String Event_Native_AD_Component_Stream_Video_Play_Time = "Event_Native_AD_Component_Stream_Video_Play_Time";
  public static final String Event_Native_AD_Component_Stream_Video_Show_Count = "Event_Native_AD_Component_Stream_Video_Show_Count";
  public static final String Event_Native_AD_Component_Stream_Video_Show_Time = "Event_Native_AD_Component_Stream_Video_Show_Time";
  public static final String Event_Native_AD_Component_Stream_Video_Sound_Click = "Event_Native_AD_Component_Stream_Video_Sound_Click";
  public static final String Event_Native_AD_Component_Text_Show_Count = "Event_Native_AD_Component_Text_Show_Count";
  public static final String Event_Native_AD_Component_Text_Show_Time = "Event_Native_AD_Component_Text_Show_Time";
  public static final String Event_Native_AD_Module_Count = "Event_Native_AD_Module_Count";
  public static final String Event_Native_AD_Stay_Time = "Event_Native_AD_Stay_Time";
  private static DataCollectionDelegate delegate;
  
  public static void collect(String paramString1, String paramString2, long paramLong)
  {
    String str2 = paramLong + "";
    String str1 = str2;
    if (1L != paramLong)
    {
      str1 = str2;
      if (!"Event_Native_AD_Module_Count".equals(paramString2)) {
        str1 = String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1000.0F) });
      }
    }
    paramString1 = paramString1 + "," + paramString2 + "," + str1;
    if (delegate != null) {
      delegate.collect(paramString1);
    }
    Log.i("AdLandingPageStreamVideo", "detail = " + paramString1);
  }
  
  public static void setDelegate(DataCollectionDelegate paramDataCollectionDelegate)
  {
    delegate = paramDataCollectionDelegate;
  }
  
  public static abstract interface DataCollectionDelegate
  {
    public abstract void collect(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.DataUtil
 * JD-Core Version:    0.7.0.1
 */