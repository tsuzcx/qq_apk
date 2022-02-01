package com.tencent.mobileqq.vas.avatar;

import android.graphics.drawable.Drawable;
import aqsg;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

public class VasAvatarLoader$1
  implements Runnable
{
  public VasAvatarLoader$1(aqsg paramaqsg, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    VasAvatar localVasAvatar = (VasAvatar)this.this$0.iu.get();
    if ((localVasAvatar != null) && (localVasAvatar.a == this.this$0))
    {
      localVasAvatar.setImageDrawable(this.x);
      if (!this.this$0.cVM)
      {
        Drawable localDrawable = this.x.getCurrDrawable();
        if ((localDrawable instanceof ApngDrawable))
        {
          if (this.this$0.mSource != -1) {
            VasFaceManager.b((ApngDrawable)localDrawable);
          }
          VasFaceManager.a(this.this$0.uin, (ApngDrawable)localDrawable);
          localVasAvatar.efn();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatarLoader.1
 * JD-Core Version:    0.7.0.1
 */