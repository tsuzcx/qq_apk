package com.tencent.open.downloadnew.common;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.Iterator;
import java.util.List;

public class NoticeDownloadListener
  implements DownloadListener
{
  protected static NoticeDownloadListener a;
  protected static final String a = "NoticeDownloadListener";
  protected NoticeUpdateHandler a;
  
  public static NoticeDownloadListener a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeDownloadListener == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeDownloadListener = new NoticeDownloadListener();
      }
      NoticeDownloadListener localNoticeDownloadListener = jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeDownloadListener;
      return localNoticeDownloadListener;
    }
    finally {}
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler = new NoticeUpdateHandler(paramLooper);
  }
  
  protected void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler == null) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler = new NoticeUpdateHandler();
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler.sendMessage(paramMessage);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      LogUtility.a("NoticeDownloadListener", "onDownloadPause " + paramDownloadInfo.jdField_b_of_type_JavaLangString);
    } while ((paramDownloadInfo.h == 1) || (paramDownloadInfo.jdField_b_of_type_Boolean));
    Message localMessage = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    LogUtility.a("NoticeDownloadListener", "onDownloadError ,downloadInfo" + paramDownloadInfo);
    if ((paramDownloadInfo == null) || (paramDownloadInfo.h == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler.obtainMessage();
    localMessage.what = -2;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    localMessage.obj = paramString;
    localMessage.arg2 = paramInt2;
    a(localMessage);
  }
  
  public void a(String paramString1, String paramString2)
  {
    LogUtility.a("NoticeDownloadListener", "onInstallSucceed ,appId" + paramString1);
    paramString1 = DownloadManager.a().b(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler.obtainMessage();
      paramString2.what = 6;
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.a, paramString1.jdField_b_of_type_JavaLangString);
      paramString2.setData(localBundle);
      a(paramString2);
    }
  }
  
  public void a(List paramList)
  {
    LogUtility.a("NoticeDownloadListener", "onDownloadUpdate notify enter infos=" + paramList.size());
    paramList = paramList.iterator();
    for (;;)
    {
      DownloadInfo localDownloadInfo;
      if (paramList.hasNext())
      {
        localDownloadInfo = (DownloadInfo)paramList.next();
        if ((localDownloadInfo == null) || (localDownloadInfo.h == 1)) {
          continue;
        }
        if (!localDownloadInfo.jdField_b_of_type_Boolean) {}
      }
      else
      {
        return;
      }
      Message localMessage = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler.obtainMessage();
      localMessage.what = 2;
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", localDownloadInfo.jdField_b_of_type_JavaLangString);
      localMessage.setData(localBundle);
      a(localMessage);
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.h == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject2 = new StringBuilder().append("onDownloadWait notify enter info.id=");
    if (paramDownloadInfo == null) {}
    for (Object localObject1 = "";; localObject1 = paramDownloadInfo.jdField_b_of_type_JavaLangString)
    {
      LogUtility.a("NoticeDownloadListener", (String)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler.obtainMessage();
      ((Message)localObject1).what = 20;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appId", paramDownloadInfo.jdField_b_of_type_JavaLangString);
      ((Message)localObject1).setData((Bundle)localObject2);
      a((Message)localObject1);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    LogUtility.a("NoticeDownloadListener", "onDownloadFinish ");
    if ((paramDownloadInfo == null) || (paramDownloadInfo.h == 1)) {}
    while (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_ComTencentOpenDownloadnewCommonNoticeUpdateHandler.obtainMessage();
    localMessage.what = 4;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localMessage.setData(localBundle);
    a(localMessage);
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void d(DownloadInfo paramDownloadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeDownloadListener
 * JD-Core Version:    0.7.0.1
 */