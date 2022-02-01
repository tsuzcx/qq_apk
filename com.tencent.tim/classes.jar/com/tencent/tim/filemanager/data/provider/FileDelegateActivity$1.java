package com.tencent.tim.filemanager.data.provider;

import android.content.Intent;
import android.view.View.OnClickListener;
import attf;
import atxh;
import audx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FileDelegateActivity$1
  implements Runnable
{
  FileDelegateActivity$1(FileDelegateActivity paramFileDelegateActivity) {}
  
  public void run()
  {
    int i = this.this$0.getIntent().getIntExtra("_action_", -1);
    Object localObject1 = this.this$0.getIntent().getStringExtra("sha");
    Object localObject2 = this.this$0.getIntent().getStringExtra("fileName");
    localObject2 = this.this$0.app.a().c((String)localObject1, (String)localObject2);
    if (localObject2 == null)
    {
      QLog.e("qqBaseActivity", 1, "find sha[" + (String)localObject1 + "] file is null!");
      this.this$0.finish();
    }
    do
    {
      return;
      switch (i)
      {
      }
    } while (!QLog.isDevelopLevel());
    throw new UnsupportedOperationException("unknow cmd:" + i);
    atxh.a(null, (FileManagerEntity)localObject2, this.this$0, this.this$0).onClick(null);
    return;
    atxh.a(this.this$0, ((FileManagerEntity)localObject2).getFilePath(), (FileManagerEntity)localObject2, this.this$0).onClick(null);
    return;
    atxh.a((FileManagerEntity)localObject2, this.this$0).onClick(null);
    this.this$0.finish();
    return;
    atxh.c(this.this$0, ((FileManagerEntity)localObject2).getFilePath()).onClick(null);
    return;
    localObject1 = new ArrayList();
    ((List)localObject1).add(localObject2);
    audx.b(this.this$0.app, (List)localObject1, true);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.data.provider.FileDelegateActivity.1
 * JD-Core Version:    0.7.0.1
 */