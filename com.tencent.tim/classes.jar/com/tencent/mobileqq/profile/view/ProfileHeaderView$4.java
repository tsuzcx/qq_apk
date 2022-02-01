package com.tencent.mobileqq.profile.view;

import alcn;
import android.view.View;
import android.widget.ImageView;
import anlm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import java.util.HashMap;

class ProfileHeaderView$4
  implements Runnable
{
  ProfileHeaderView$4(ProfileHeaderView paramProfileHeaderView, ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject2 = (AvatarLayout)this.this$0.mt.get("map_key_face");
    Object localObject1;
    int i;
    if (localObject2 == null)
    {
      localObject1 = null;
      localObject1 = (ImageView)localObject1;
      if (!(localObject1 instanceof DynamicAvatarView)) {
        break label208;
      }
      ((AvatarLayout)localObject2).setFaceDrawable(this.this$0.app, 1, this.f.uin, 200, true, true, true, false, 3);
      localObject2 = (View)this.this$0.mt.get("map_key_face_stoke");
      if ((this.this$0.a == null) || (this.this$0.a.d == null)) {
        break label229;
      }
      if (!this.this$0.a.d.isNoCover()) {
        break label179;
      }
      i = 1;
    }
    for (;;)
    {
      label121:
      if (localObject2 != null)
      {
        if ((i != 1) || (ThemeUtil.isNowThemeIsNight(this.this$0.app, false, null))) {
          break label184;
        }
        ((View)localObject2).setVisibility(4);
      }
      for (;;)
      {
        if (anlm.ayn()) {
          ((View)localObject2).setVisibility(4);
        }
        ProfileHeaderView.a(this.this$0, (ImageView)localObject1);
        return;
        localObject1 = ((AvatarLayout)localObject2).Q(0);
        break;
        label179:
        i = 0;
        break label121;
        label184:
        ((View)localObject2).setVisibility(VasFaceManager.f(this.f.uin, this.this$0.app));
      }
      label208:
      this.this$0.a(this.f, this.val$type, this.val$key, false);
      return;
      label229:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.4
 * JD-Core Version:    0.7.0.1
 */