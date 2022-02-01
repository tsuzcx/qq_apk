package com.tencent.mobileqq.openapi;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class OpenApiManager$1
  implements Runnable
{
  OpenApiManager$1(OpenApiManager paramOpenApiManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "onRuntimeCreate, app = " + this.val$app + ", current = " + OpenApiManager.access$000(this.this$0) + ", bg = " + BaseApplicationImpl.sIsBgStartup);
    }
    this.this$0.onRuntimeDestroy(OpenApiManager.access$000(this.this$0));
    OpenApiManager.access$002(this.this$0, this.val$app);
    Intent localIntent = new Intent("com.tencent.mobileqq.openapi.ACTION_LOGIN");
    if (BaseApplicationImpl.sIsBgStartup) {
      localIntent.putExtra("imm_reg", true);
    }
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent);
    OpenApiManager.access$000(this.this$0).addObserver(OpenApiManager.access$100(this.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager.1
 * JD-Core Version:    0.7.0.1
 */