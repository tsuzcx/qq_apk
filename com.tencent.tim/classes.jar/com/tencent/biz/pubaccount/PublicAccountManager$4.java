package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.lang.ref.WeakReference;
import kaw;
import kbg;

public class PublicAccountManager$4
  implements Runnable
{
  public PublicAccountManager$4(kaw paramkaw) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.n.get();
    String str = this.this$0.VK;
    boolean bool = this.this$0.adr;
    if ((this.this$0.bZ != null) && (this.this$0.bZ.get() != null) && (localQQAppInterface != null)) {
      SosoInterface.a(new kbg(this, 1, true, true, 0L, true, false, "PublicAccountManager", str, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountManager.4
 * JD-Core Version:    0.7.0.1
 */