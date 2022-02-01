package com.tencent.tim.cloudfile;

import android.text.TextUtils;
import aqcx;
import atlz;
import com.tencent.mobileqq.widget.QQToast;

class CloudFileSendRecvActivity$22
  implements Runnable
{
  CloudFileSendRecvActivity$22(CloudFileSendRecvActivity paramCloudFileSendRecvActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if ((this.dhJ) && (!TextUtils.isEmpty(this.val$finalPath))) {
      QQToast.a(this.this$0, 2, "已保存到" + this.val$finalPath, 0).show(aqcx.dip2px(this.this$0, 44.0F));
    }
    this.this$0.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSendRecvActivity.22
 * JD-Core Version:    0.7.0.1
 */