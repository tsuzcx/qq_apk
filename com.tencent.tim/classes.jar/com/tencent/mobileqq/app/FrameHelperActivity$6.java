package com.tencent.mobileqq.app;

import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import aqep;
import aura;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class FrameHelperActivity$6
  implements Runnable
{
  FrameHelperActivity$6(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.this$0.dU == null) || (FrameHelperActivity.a(this.this$0) == null)) {
      return;
    }
    RandomCoverView localRandomCoverView = (RandomCoverView)this.this$0.dU.findViewById(2131380003);
    Object localObject = this.val$app.getCurrentAccountUin();
    localObject = aqep.a(this.val$app, (String)localObject);
    String str = (String)localObject.getCoverData(0)[0];
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[getCoverData] getCovertUrl from cache,url:" + str);
    }
    if ((!TextUtils.isEmpty(str)) && (!aura.aJA()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "card.isNoCover()=" + ((Card)localObject).isNoCover());
      }
      if ((!aura.a(this.val$app, (Card)localObject)) && (((Card)localObject).isNoCover()))
      {
        FrameHelperActivity.a(this.this$0).wR(false);
        ThreadManager.getUIHandler().post(new FrameHelperActivity.6.1(this, localRandomCoverView));
        return;
      }
      FrameHelperActivity.a(this.this$0).wR(true);
      ThreadManager.getUIHandler().post(new FrameHelperActivity.6.2(this, localRandomCoverView));
      FrameHelperActivity.a(this.this$0, aura.a(this.this$0.getActivity(), this.val$app, (Card)localObject, localRandomCoverView, str, FrameHelperActivity.a(this.this$0), this.this$0.b.Ws()));
      return;
    }
    this.this$0.mUiHandler.postDelayed(new FrameHelperActivity.6.3(this, (Card)localObject), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.6
 * JD-Core Version:    0.7.0.1
 */