package com.tencent.qqmail.nativepages;

import android.util.Log;
import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.CommercialAdvertiseEnum;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import moai.oss.OssHelper;

public class NativeAdsHelper
{
  public static final String Event_Native_AD_Inner_Mail_List_Delete = "Event_Native_AD_Inner_Mail_List_Delete";
  public static final String Event_Native_AD_Inner_Mail_List_Expose_From_Unread = "Event_Native_AD_Inner_Mail_List_Expose_From_Unread";
  public static final String Event_Native_AD_Mail_List_Click = "Event_Native_AD_Mail_List_Click";
  public static final String Event_Native_AD_Mail_List_Delete = "Event_Native_AD_Mail_List_Delete";
  public static final String Event_Native_AD_Mail_List_Position = "Event_Native_AD_Mail_List_Position";
  public static final String Event_Native_AD_Mail_List_Show = "Event_Native_AD_Mail_List_Show";
  public static final String Event_Native_AD_Mail_List_Stay_Time = "Event_Native_AD_Mail_List_Stay_Time";
  public static final String TAG = "NativeAdsHelper";
  private static volatile NativeAdsHelper instance;
  private int indexOfExposeAdsItemInMailList = -1;
  private boolean lockForUpdateMaillistExposeState = false;
  
  public static NativeAdsHelper getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new NativeAdsHelper();
      }
      return instance;
    }
    finally {}
  }
  
  public static boolean shouldExposeAdvertiseDetailInMaillist(Popularize paramPopularize)
  {
    boolean bool = true;
    if ((paramPopularize == null) || (paramPopularize.getType() != 9)) {}
    do
    {
      return false;
      QMLog.log(4, "NativeAdsHelper", String.format("isRender %s isStop %s isExpire %s ", new Object[] { paramPopularize.isRender() + "", paramPopularize.isStop() + "", paramPopularize.isExpire() + "" }));
    } while ((!paramPopularize.isRender()) && (paramPopularize.isStop()));
    CommercialAdvertiseEnum localCommercialAdvertiseEnum = paramPopularize.getCommercialAdvertiseType();
    switch (NativeAdsHelper.2.$SwitchMap$com$tencent$qqmail$popularize$model$CommercialAdvertiseEnum[localCommercialAdvertiseEnum.ordinal()])
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((paramPopularize.isExpire()) || (paramPopularize.isCancel()) || (paramPopularize.isRead()) || (!VirtualAdManager.getInstance().ensureVirtualAdsMailDownloaded(paramPopularize))) {
        break;
      }
      continue;
      if ((paramPopularize.isExpire()) || (paramPopularize.isCancel()) || (paramPopularize.isRead())) {
        break;
      }
      continue;
      if ((paramPopularize.isExpire()) || (paramPopularize.isCancel())) {
        break;
      }
      continue;
      bool = false;
    }
  }
  
  public int getIndexOfExposeAdsItemInMailList()
  {
    return this.indexOfExposeAdsItemInMailList;
  }
  
  public boolean isLockForUpdateMaillistExposeState()
  {
    return this.lockForUpdateMaillistExposeState;
  }
  
  public void log(int paramInt, String paramString)
  {
    QMLog.log(4, "NativeAdsHelper", "log  serverId = " + paramInt + " event = " + paramString);
    OssHelper.nativeAdsDetail(new Object[] { paramInt + ",," + paramString + "," + 1 });
  }
  
  public void logNativeAdsItemClick(int paramInt)
  {
    QMLog.log(4, "NativeAdsHelper", "logNativeAdsItemClick  serverId = " + paramInt);
    String str = paramInt + ",," + "Event_Native_AD_Mail_List_Click" + "," + 1;
    Log.i("NativeAdsHelper", "logNativeAdsItemClick oss detail  = " + str);
    OssHelper.nativeAdsDetail(new Object[] { str });
  }
  
  public void logNativeAdsItemLocation(int paramInt1, int paramInt2)
  {
    Log.i("NativeAdsHelper", "logNativeAdsItemLocation " + paramInt2);
    String str1 = paramInt1 + ",," + "Event_Native_AD_Mail_List_Position" + "," + paramInt2;
    String str2 = paramInt1 + ",," + "Event_Native_AD_Mail_List_Show" + "," + 1;
    Log.i("NativeAdsHelper", "logNativeAdsItemLocation oss detail ossDetailForExistPostion = " + str1);
    Log.i("NativeAdsHelper", "logNativeAdsItemLocation oss detail ossDetailForExistCount = " + str2);
    OssHelper.nativeAdsDetail(new Object[] { str1 });
    OssHelper.nativeAdsDetail(new Object[] { str2 });
  }
  
  public void logNativeAdsShowInMailistDuration(int paramInt, long paramLong)
  {
    String str = String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1000.0F) });
    QMLog.log(4, "NativeAdsHelper", "logNativeAdsShowInMailistDuration  serverId = " + paramInt + "reportAdsItemShowTime = " + paramLong + " formattedDuration = " + str);
    str = paramInt + ",," + "Event_Native_AD_Mail_List_Stay_Time" + "," + str;
    Log.i("NativeAdsHelper", "logNativeAdsShowInMailistDuration oss detail  = " + str);
    OssHelper.nativeAdsDetail(new Object[] { str });
  }
  
  public void maillistAdsItemHasExpose(Popularize paramPopularize)
  {
    if (paramPopularize == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPopularize);
    Threads.runInBackground(new NativeAdsHelper.1(this, localArrayList));
  }
  
  public boolean makesureAvatarUrlDownload(Popularize paramPopularize)
  {
    if (paramPopularize == null) {}
    String str;
    do
    {
      do
      {
        return true;
      } while (paramPopularize.getType() != 9);
      str = paramPopularize.getAvatar_url();
    } while ((str == null) || (str.length() == 0) || (PopularizeThumbManager.sharedInstance().getPopularizeThumb(paramPopularize.getAvatar_url()) != null));
    PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(paramPopularize.getAvatar_url(), paramPopularize.getAvatar_url_md5(), null);
    return false;
  }
  
  public void setIndexOfExposeAdsItemInMailList(int paramInt)
  {
    this.indexOfExposeAdsItemInMailList = paramInt;
  }
  
  public void setLockForUpdateMaillistExposeState(boolean paramBoolean)
  {
    this.lockForUpdateMaillistExposeState = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.nativepages.NativeAdsHelper
 * JD-Core Version:    0.7.0.1
 */