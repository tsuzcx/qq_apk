package com.tencent.open.agent;

import acfp;
import android.text.TextUtils;
import android.widget.EditText;
import arqn;
import asbh;
import com.tencent.qphone.base.util.QLog;

public class CreateVirtualAccountFragment$6$1
  implements Runnable
{
  public CreateVirtualAccountFragment$6$1(arqn paramarqn, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.a.this$0.jf();
    QLog.d("CreateVirtualAccountFragment", 2, "========> onUploadAvatar isSuccess = " + this.bIj + " filePath ==" + this.val$filePath + " headid==" + this.cBN);
    if (this.bIj)
    {
      if (TextUtils.isEmpty(CreateVirtualAccountFragment.a(this.a.this$0).getText()))
      {
        CreateVirtualAccountFragment.a(this.a.this$0, acfp.m(2131704523), false);
        return;
      }
      String str = CreateVirtualAccountFragment.a(this.a.this$0).getText().toString();
      QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + this.cBN);
      CreateVirtualAccountFragment.a(this.a.this$0);
      CreateVirtualAccountFragment.a(this.a.this$0).a(CreateVirtualAccountFragment.a(this.a.this$0), str, this.cBN, CreateVirtualAccountFragment.a(this.a.this$0));
      return;
    }
    CreateVirtualAccountFragment.a(this.a.this$0, acfp.m(2131704525) + this.val$code, false);
    QLog.d("CreateVirtualAccountFragment", 1, "upload avatar failed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.6.1
 * JD-Core Version:    0.7.0.1
 */