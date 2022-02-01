package com.tencent.mobileqq.receipt;

import alid;
import alte;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import java.util.ArrayList;

public class ReceiptMsgManager$1
  implements Runnable
{
  public ReceiptMsgManager$1(alte paramalte, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, String paramString, int paramInt3, boolean paramBoolean, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    this.this$0.f.voiceLength = QQRecorder.d(this.dwX);
    this.this$0.f.voiceChangeFlag = this.dwY;
    this.this$0.f.voiceType = this.d.mAudioType;
    this.this$0.f.fullLocalPath = this.val$path;
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.this$0.f);
    alid.nZ(this.val$path);
    Bundle localBundle = new Bundle();
    localBundle.putString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH", this.val$path);
    localBundle.putInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE", this.dwZ);
    localBundle.putBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED", this.czf);
    alte.a(this.this$0, this.val$app, this.a.aTl, this.a.cZ, this.a.troopUin, alte.a(this.this$0, 3), false, localArrayList, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager.1
 * JD-Core Version:    0.7.0.1
 */