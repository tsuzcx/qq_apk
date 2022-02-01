package com.tencent.mobileqq.gamecenter.fragment;

import acfp;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;

class QQGamePubAccountFragment$15
  implements Runnable
{
  QQGamePubAccountFragment$15(QQGamePubAccountFragment paramQQGamePubAccountFragment, WadlResult paramWadlResult) {}
  
  public void run()
  {
    if (this.a.bBa == 12)
    {
      QQGamePubAccountFragment.a(this.this$0).eO(this.a.a.appId, 2);
      return;
    }
    if (this.a.bBa == 6)
    {
      QQGamePubAccountFragment.a(this.this$0).eO(this.a.a.appId, 6);
      return;
    }
    if (this.a.bBa == 4)
    {
      QQGamePubAccountFragment.a(this.this$0).eO(this.a.a.appId, 5);
      QQGamePubAccountFragment.a(this.this$0).gk(this.a.a.appId, this.a.progress + "");
      return;
    }
    if (this.a.bBa == 7)
    {
      if (this.this$0.getActivity() != null) {
        QQToast.a(this.this$0.getActivity(), acfp.m(2131711731), 0).show();
      }
      QQGamePubAccountFragment.a(this.this$0).eO(this.a.a.appId, 2);
      return;
    }
    QQGamePubAccountFragment.a(this.this$0).eO(this.a.a.appId, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.15
 * JD-Core Version:    0.7.0.1
 */