package com.tencent.biz.pubaccount.ecshopassit.view;

import android.os.Bundle;
import arcn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kev;

public class EcshopWebviewPool$1
  implements Runnable
{
  public EcshopWebviewPool$1(kev paramkev, String paramString) {}
  
  public void run()
  {
    if (!this.this$0.ds(this.YQ))
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("_accelerator_mode_", 3);
      arcn.a().dD((Bundle)localObject);
      localObject = EcshopWebview.a(BaseApplicationImpl.sApplication);
      kev.a(this.this$0).put(this.YQ, localObject);
      if (QLog.isColorLevel()) {
        QLog.i("parsons111", 2, "【init】webViewLinkedList.size: " + kev.a(this.this$0).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebviewPool.1
 * JD-Core Version:    0.7.0.1
 */