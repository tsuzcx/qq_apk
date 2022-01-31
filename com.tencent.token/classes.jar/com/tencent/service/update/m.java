package com.tencent.service.update;

import android.os.Bundle;
import android.util.Log;
import btmsdkobf.ai;
import btmsdkobf.aj;
import btmsdkobf.z;
import com.tmsdk.ConchPushInfoUtil;
import com.tmsdk.JceStructUtil;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;

class m
  extends ConchService.IConchPushListener
{
  m(k paramk, ConchServiceProxy paramConchServiceProxy) {}
  
  public void onRecvPush(ConchService.ConchPushInfo paramConchPushInfo)
  {
    Log.i("UpdateManager", "onRecvPush");
    if ((paramConchPushInfo == null) || (paramConchPushInfo.mConch == null))
    {
      Log.i("UpdateManager", "onRecvPush (conchPushInfo == null) || (conchPushInfo.mConch == null)");
      new Bundle().putInt("soft_update_ret", this.mErrorCode);
      return;
    }
    Log.i("UpdateManager", "onRecvPush info : " + paramConchPushInfo.mTaskId + "|" + paramConchPushInfo.mTaskSeqno + "|" + paramConchPushInfo.mConch.cmdId + "|" + ConchPushInfoUtil.getConchSeqno(paramConchPushInfo.mConch));
    switch (paramConchPushInfo.mConch.cmdId)
    {
    default: 
      return;
    }
    Log.i("UpdateManager", "onRecvPush softUpdate");
    TMSDKContext.saveActionData(1150105);
    if (this.mErrorCode == 0)
    {
      SoftUpdateInfo localSoftUpdateInfo = (SoftUpdateInfo)JceStructUtil.getJceStruct(ConchPushInfoUtil.getConchParams(paramConchPushInfo.mConch), new SoftUpdateInfo(), false);
      if (localSoftUpdateInfo != null) {
        this.a.reportConchResult(paramConchPushInfo, 10, 1);
      }
      for (;;)
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong("valid_End_Time", ConchPushInfoUtil.getConchTime(paramConchPushInfo.mConch).validEndTime);
        localBundle.putInt("ask_type", ConchPushInfoUtil.getConchTips(paramConchPushInfo.mConch).bq);
        localBundle.putSerializable("update_info", localSoftUpdateInfo);
        localBundle.putInt("message_type", ConchPushInfoUtil.getConchTips(paramConchPushInfo.mConch).type);
        localBundle.putString("message_title", ConchPushInfoUtil.getConchTips(paramConchPushInfo.mConch).title);
        localBundle.putLong("taskId", paramConchPushInfo.mTaskId);
        localBundle.putLong("task_seqno", paramConchPushInfo.mTaskSeqno);
        localBundle.putInt("cmd_id", paramConchPushInfo.mConch.cmdId);
        localBundle.putInt("conch_seqno", ConchPushInfoUtil.getConchSeqno(paramConchPushInfo.mConch));
        k.a().a(localBundle);
        return;
        this.a.reportConchResult(paramConchPushInfo, 10, 2);
      }
    }
    if (this.mErrorCode == -2)
    {
      paramConchPushInfo = new Bundle();
      paramConchPushInfo.putInt("soft_update_ret", 0);
      k.a().b(paramConchPushInfo);
      return;
    }
    paramConchPushInfo = new Bundle();
    paramConchPushInfo.putInt("soft_update_ret", this.mErrorCode);
    k.a().b(paramConchPushInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.m
 * JD-Core Version:    0.7.0.1
 */