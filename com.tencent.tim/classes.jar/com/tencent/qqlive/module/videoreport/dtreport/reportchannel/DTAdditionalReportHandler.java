package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;

public class DTAdditionalReportHandler
  implements IAdditionalReportListener, ISessionChangeListener
{
  private static final String TAG = "DTAdditionalReportHandl";
  private String mLastCallFrom = "";
  private String mLastCallScheme = "";
  private int mLastStartType = -1;
  
  private DTAdditionalReportHandler()
  {
    VideoReport.registerSessionChangeListener(this);
  }
  
  public static DTAdditionalReportHandler getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private boolean handleAppVstEvent()
  {
    Object localObject = DTEventDynamicParams.getInstance().getDTParamProvider();
    if (localObject == null) {}
    int i;
    String str;
    do
    {
      return false;
      i = ((IDTParamProvider)localObject).getStartType();
      str = ((IDTParamProvider)localObject).getCallFrom();
      localObject = ((IDTParamProvider)localObject).getCallScheme();
      if (VideoReport.isDebugMode()) {
        Log.i("DTAdditionalReportHandl", "handleAppVstEvent: startType=" + i + ", callFrom=" + str + ", callScheme=" + (String)localObject);
      }
    } while (!isStartParamsChanged(i, str, (String)localObject));
    this.mLastStartType = i;
    this.mLastCallFrom = str;
    this.mLastCallScheme = ((String)localObject);
    return true;
  }
  
  private boolean isStartParamsChanged(int paramInt, String paramString1, String paramString2)
  {
    return (this.mLastStartType != paramInt) || (!TextUtils.equals(this.mLastCallFrom, paramString1)) || (!TextUtils.equals(this.mLastCallScheme, paramString2));
  }
  
  private void updateAppStartParams()
  {
    IDTParamProvider localIDTParamProvider = DTEventDynamicParams.getInstance().getDTParamProvider();
    if (localIDTParamProvider == null) {}
    do
    {
      return;
      this.mLastStartType = localIDTParamProvider.getStartType();
      this.mLastCallFrom = localIDTParamProvider.getCallFrom();
      this.mLastCallScheme = localIDTParamProvider.getCallScheme();
    } while (!VideoReport.isDebugMode());
    Log.i("DTAdditionalReportHandl", "updateAppStartParams: mLastStartType=" + this.mLastStartType + "， mLastCallFrom=" + this.mLastCallFrom + "， mLastCallScheme=" + this.mLastCallScheme);
  }
  
  public void changeSession(SessionChangeReason paramSessionChangeReason)
  {
    if (VideoReport.isDebugMode()) {
      Log.i("DTAdditionalReportHandl", "changeSession: reason=" + paramSessionChangeReason);
    }
    updateAppStartParams();
  }
  
  public boolean shouldAdditionalReport(String paramString)
  {
    if (VideoReport.isDebugMode()) {
      Log.i("DTAdditionalReportHandl", "shouldAdditionalReport: eventKey=" + paramString);
    }
    boolean bool = false;
    if ("vst".equals(paramString)) {
      bool = handleAppVstEvent();
    }
    return bool;
  }
  
  static class InstanceHolder
  {
    static final DTAdditionalReportHandler INSTANCE = new DTAdditionalReportHandler(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAdditionalReportHandler
 * JD-Core Version:    0.7.0.1
 */