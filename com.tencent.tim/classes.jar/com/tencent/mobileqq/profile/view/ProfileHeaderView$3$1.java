package com.tencent.mobileqq.profile.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ProfileHeaderView$3$1
  implements Runnable
{
  ProfileHeaderView$3$1(ProfileHeaderView.3 param3, Bitmap paramBitmap) {}
  
  public void run()
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)this.a.this$0.mt.get("map_key_face");
    if (localAvatarLayout == null) {}
    for (Object localObject = null;; localObject = localAvatarLayout.Q(0))
    {
      localObject = (ImageView)localObject;
      if (localObject != null)
      {
        if (this.en != null)
        {
          QLog.d("Q.qqhead.freq", 1, "ProfileHeaderView updateAvatar, bitmap: " + this.en);
          localAvatarLayout.setStaticAvatar(this.en);
        }
        ProfileHeaderView.a(this.a.this$0, (ImageView)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.3.1
 * JD-Core Version:    0.7.0.1
 */