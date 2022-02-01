package com.tencent.mobileqq.emoticon;

import afgc;
import afke;
import afnu;
import ajdg;
import android.os.Bundle;
import aquz;
import aqvc;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;

public class EmojiManager$4
  implements Runnable
{
  public EmojiManager$4(afke paramafke, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject1;
    if (this.bYx)
    {
      localObject1 = afnu.bEf.replace("[epId]", this.aMY);
      localObject2 = this.this$0.a().a((String)localObject1);
      if ((localObject2 == null) || (((aquz)localObject2).isCancel())) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label107;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "startDownloadEmosmJson|epId is in downloading:" + this.aMY);
      }
      return;
      localObject1 = afgc.kw(this.aMY);
      break;
    }
    label107:
    Object localObject3 = this.this$0.a().a(this.aMY, this.val$businessType);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "startDownloadEmosmJson|emoPackage is not exist:" + this.aMY);
      }
      localObject2 = new EmoticonPackage();
      ((EmoticonPackage)localObject2).epId = this.aMY;
      ((EmoticonPackage)localObject2).status = 0;
      if (this.val$businessType != 0) {
        break label382;
      }
      ((EmoticonPackage)localObject2).aio = true;
    }
    for (;;)
    {
      this.this$0.a().m((EmoticonPackage)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "startDownloadEmosmJson epId:" + ((EmoticonPackage)localObject2).epId);
      }
      localObject1 = new aquz((String)localObject1, new File(afnu.bEu.replace("[epId]", this.aMY)));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("jsonType", this.cRx);
      ((Bundle)localObject3).putSerializable("emoticonPackage", (Serializable)localObject2);
      ((Bundle)localObject3).putBoolean("isSmallEmotion", this.bYx);
      if (this.aL != null) {
        ((Bundle)localObject3).putBundle("jsonReqParams", this.aL);
      }
      ((aquz)localObject1).atX = this.this$0.cKT;
      ((aquz)localObject1).cWw = true;
      this.this$0.a().a((aquz)localObject1, this.this$0.q, (Bundle)localObject3);
      return;
      label382:
      if (this.val$businessType == 1) {
        ((EmoticonPackage)localObject2).kandian = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.4
 * JD-Core Version:    0.7.0.1
 */