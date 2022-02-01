package com.tencent.mobileqq.nearby.profilecard;

import acfp;
import akbz;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QQToast;

public class NearbyAuthVideoPlayerFragment$2$1
  implements Runnable
{
  public NearbyAuthVideoPlayerFragment$2$1(akbz paramakbz, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$isSuccess)
    {
      NearbyAuthVideoPlayerFragment.a(this.a.this$0, NearbyAuthVideoPlayerFragment.a(this.a.this$0), false, false);
      return;
    }
    QQToast.a(this.a.this$0.getActivity(), 1, acfp.m(2131708660), 0).show(this.a.this$0.getActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.a(this.a.this$0).setVisibility(0);
    NearbyAuthVideoPlayerFragment.a(this.a.this$0).setVisibility(0);
    NearbyAuthVideoPlayerFragment.b(this.a.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2.1
 * JD-Core Version:    0.7.0.1
 */