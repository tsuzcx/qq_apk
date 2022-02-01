package com.tencent.mobileqq.activity.qwallet.widget;

import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.MyAnimationListener;
import cooperation.qwallet.plugin.QWalletHelper;

class QWalletAnimDialog$1
  implements AnimationView.MyAnimationListener
{
  QWalletAnimDialog$1(QWalletAnimDialog paramQWalletAnimDialog) {}
  
  public void onAnimationEnd(AnimationView paramAnimationView) {}
  
  public void onAnimationRepeat(AnimationView paramAnimationView)
  {
    if (!this.this$0.mIsFirstRepeated)
    {
      this.this$0.mIsFirstRepeated = true;
      QWalletHelper.gotoF2FRedpack(this.this$0.mUin, this.this$0.mNickName, this.this$0.mActivity, this.this$0.mUrl, true, this.this$0.mReportSeq);
    }
  }
  
  public void onAnimationStart(AnimationView paramAnimationView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.QWalletAnimDialog.1
 * JD-Core Version:    0.7.0.1
 */