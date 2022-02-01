package com.tencent.mobileqq.text;

import android.graphics.drawable.Drawable;
import aofy;
import aofy.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class TextUtils$2
  implements Runnable
{
  public TextUtils$2(int paramInt, aofy.a parama) {}
  
  public void run()
  {
    Drawable localDrawable = aofy.i(BaseApplicationImpl.getContext().getResources(), this.aDL);
    if ((localDrawable != null) && (this.a != null)) {
      this.a.v(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils.2
 * JD-Core Version:    0.7.0.1
 */