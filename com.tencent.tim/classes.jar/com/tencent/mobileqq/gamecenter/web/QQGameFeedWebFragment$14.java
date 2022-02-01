package com.tencent.mobileqq.gamecenter.web;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;

class QQGameFeedWebFragment$14
  implements Runnable
{
  QQGameFeedWebFragment$14(QQGameFeedWebFragment paramQQGameFeedWebFragment, int paramInt) {}
  
  public void run()
  {
    if (this.val$pos > 0) {
      QQGameFeedWebFragment.b(this.this$0);
    }
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (QQGameFeedWebFragment.a(this.this$0) != null)) {
      QQGameFeedWebFragment.a(this.this$0).setCurrentItem(this.val$pos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.14
 * JD-Core Version:    0.7.0.1
 */