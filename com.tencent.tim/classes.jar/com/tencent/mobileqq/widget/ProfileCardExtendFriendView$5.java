package com.tencent.mobileqq.widget;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqho;
import arhd;
import com.tencent.mobileqq.data.Card;

public class ProfileCardExtendFriendView$5
  implements Runnable
{
  ProfileCardExtendFriendView$5(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void run()
  {
    if (aqho.a(this.this$0.acg, this.this$0.lq.getWidth()) > 4)
    {
      this.this$0.acg.setText(this.c.schoolName);
      ImageView localImageView = this.this$0.FH;
      if (this.c.authState == 2L) {}
      for (int i = 2130846054;; i = 2130846055)
      {
        localImageView.setImageResource(i);
        this.this$0.FH.setVisibility(0);
        if (ProfileCardExtendFriendView.e(this.this$0)) {
          this.this$0.FH.setOnClickListener(new arhd(this));
        }
        return;
      }
    }
    this.this$0.FH.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView.5
 * JD-Core Version:    0.7.0.1
 */