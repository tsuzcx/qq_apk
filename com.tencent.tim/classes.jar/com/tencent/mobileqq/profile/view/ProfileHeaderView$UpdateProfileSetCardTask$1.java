package com.tencent.mobileqq.profile.view;

import albb;
import alcn;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class ProfileHeaderView$UpdateProfileSetCardTask$1
  implements Runnable
{
  ProfileHeaderView$UpdateProfileSetCardTask$1(ProfileHeaderView.UpdateProfileSetCardTask paramUpdateProfileSetCardTask, ProfileHeaderView paramProfileHeaderView) {}
  
  public void run()
  {
    try
    {
      if (this.c.mt != null)
      {
        anot.a(null, "CliOper", "", "", "card_mall", "0X80066D3", 0, 0, "", "", "", "");
        View localView = (View)this.c.mt.get("map_key_tips_set_card");
        TextView localTextView = (TextView)localView.findViewById(2131368272);
        ImageView localImageView = (ImageView)localView.findViewById(2131368252);
        Resources localResources = localView.getResources();
        localTextView.setText(localResources.getString(2131721191));
        localImageView.setContentDescription(localResources.getString(2131721191));
        localView.setTag(new albb(29, "CLICK_BANNER"));
        localView.setOnClickListener(this.c.a.mOnClickListener);
        this.c.dA.set(true);
        ProfileHeaderView.a(this.c);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.UpdateProfileSetCardTask.1
 * JD-Core Version:    0.7.0.1
 */