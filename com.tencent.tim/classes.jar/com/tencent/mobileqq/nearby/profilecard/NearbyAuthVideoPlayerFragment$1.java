package com.tencent.mobileqq.nearby.profilecard;

import advm;
import com.tencent.qphone.base.util.QLog;

class NearbyAuthVideoPlayerFragment$1
  implements Runnable
{
  NearbyAuthVideoPlayerFragment$1(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment, String paramString) {}
  
  public void run()
  {
    if (NearbyAuthVideoPlayerFragment.a(this.this$0) != null)
    {
      NearbyAuthVideoPlayerFragment.a(this.this$0).li(this.val$url);
      return;
    }
    QLog.i("NearbyAuthVideoPlayerFragment", 1, "mDynamicAvatarDownloadManager is NULL!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.1
 * JD-Core Version:    0.7.0.1
 */