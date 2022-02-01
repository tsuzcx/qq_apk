package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class AuthorityAccountView$5$1
  implements Runnable
{
  AuthorityAccountView$5$1(AuthorityAccountView.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$bitmap != null)
    {
      QLog.d("AuthorityAccountView", 1, "-->updateAccountFace success uin");
      this.a.Gc.setImageBitmap(this.val$bitmap);
      return;
    }
    try
    {
      QLog.d("AuthorityAccountView", 1, "-->updateAccountFace use default uin");
      this.a.Gc.setImageBitmap(BitmapFactory.decodeResource(this.a.this$0.getResources(), 2130841398));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("AuthorityAccountView", 1, "-->updateAccountFace oom");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.5.1
 * JD-Core Version:    0.7.0.1
 */