package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.protocol.DataCollector;

class AttachSaveToWeiYunActivity$3
  implements View.OnClickListener
{
  AttachSaveToWeiYunActivity$3(AttachSaveToWeiYunActivity paramAttachSaveToWeiYunActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.qq.qcloud", "com.qq.qcloud.activity.OpenInAlbumBackupListActivity");
    localIntent.setData(Uri.parse("weiyun://*"));
    localIntent.addFlags(268435456);
    localIntent.putExtra("quicklogin_uin", AttachSaveToWeiYunActivity.access$300(this.this$0));
    localIntent.putExtra("quicklogin_buff", QMWtLoginManager.getInstance().getA2(AttachSaveToWeiYunActivity.access$400(this.this$0).getUin()));
    this.this$0.startActivity(localIntent);
    DataCollector.logEvent("Event_Weiyun_Preview_File");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity.3
 * JD-Core Version:    0.7.0.1
 */