package com.tencent.mobileqq.fragment;

import acff;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class ShieldFriendsListFragment$1
  implements Runnable
{
  ShieldFriendsListFragment$1(ShieldFriendsListFragment paramShieldFriendsListFragment) {}
  
  public void run()
  {
    ArrayList localArrayList = ((acff)this.this$0.getActivity().app.getManager(51)).cn();
    if (this.this$0.getActivity() == null) {
      return;
    }
    this.this$0.getActivity().runOnUiThread(new ShieldFriendsListFragment.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment.1
 * JD-Core Version:    0.7.0.1
 */