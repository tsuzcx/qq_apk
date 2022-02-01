package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import aviz;
import com.tencent.qphone.base.util.QLog;
import svi;

public class Share$5
  implements Runnable
{
  public Share$5(svi paramsvi, String paramString) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.aHp))
      {
        aviz.a(0, this.this$0.zc, this.this$0.mShareUrl, null, this.this$0.aue, this.this$0.auf, null, null, false, -1L).c(this.aHp).a("lCategory", 10L).b(this.this$0.activity, this.aHp);
        return;
      }
      aviz.a(0, this.this$0.zc, this.this$0.mShareUrl, null, this.this$0.aue, this.this$0.auf, null, null, false, -1L).c(this.this$0.uin).b(this.this$0.activity, this.this$0.uin);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(svi.TAG, 1, "QfavBuilder.newLink error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.5
 * JD-Core Version:    0.7.0.1
 */