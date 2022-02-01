package com.tencent.mobileqq.apollo;

import acbk;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import wja;

class FriendCardApolloViewController$DrawerInfoCallback$1
  implements Runnable
{
  FriendCardApolloViewController$DrawerInfoCallback$1(FriendCardApolloViewController.a parama, FriendProfileCardActivity paramFriendProfileCardActivity, View paramView) {}
  
  public void run()
  {
    if (this.b.this$0.c == null)
    {
      this.b.this$0.c = new FrameGifView(this.a);
      this.b.this$0.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(45.0F, this.a.getResources()), wja.dp2px(45.0F, this.a.getResources()));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.bottomMargin = wja.dp2px(45.0F, this.a.getResources());
      localLayoutParams.rightMargin = wja.dp2px(75.0F, this.a.getResources());
      ((RelativeLayout)this.jY.getParent()).addView(this.b.this$0.c, localLayoutParams);
    }
    this.b.this$0.c.setVisibility(0);
    this.b.this$0.c.setGifData(30, null, FriendCardApolloViewController.a(this.b.this$0), acbk.jb(FriendCardApolloViewController.a(this.b.this$0)), true);
    FriendCardApolloViewController.a(this.b.this$0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.DrawerInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */