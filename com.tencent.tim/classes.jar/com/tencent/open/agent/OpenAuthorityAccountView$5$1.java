package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import artw;
import com.tencent.qphone.base.util.QLog;

class OpenAuthorityAccountView$5$1
  implements Runnable
{
  OpenAuthorityAccountView$5$1(OpenAuthorityAccountView.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$bitmap != null)
    {
      QLog.d("OpenAuthorityAccountView", 1, "-->updateAccountFace success uin = " + artw.qx(this.a.val$uin));
      this.a.Gc.setImageBitmap(this.val$bitmap);
      return;
    }
    try
    {
      QLog.d("OpenAuthorityAccountView", 1, "-->updateAccountFace use default uin = " + artw.qx(this.a.val$uin));
      this.a.Gc.setImageBitmap(BitmapFactory.decodeResource(this.a.this$0.getResources(), 2130841398));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("OpenAuthorityAccountView", 1, "-->updateAccountFace oom uin = AuthorityUtil.getSimpleUin(uin)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView.5.1
 * JD-Core Version:    0.7.0.1
 */