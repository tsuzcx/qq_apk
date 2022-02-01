package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import ram;
import rzd;
import san;
import sio;

class SubscribePersonalDetailFragment$4
  implements Runnable
{
  SubscribePersonalDetailFragment$4(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void run()
  {
    ram.i("SubscribePersonalDetail", "onReceiveEvent  publishFeed.type.get()" + this.h.type.get());
    san localsan = new san();
    if (!SubscribePersonalDetailFragment.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localsan.ayK = bool;
      localsan.shareFromType = 1;
      localsan.mFeed = this.h;
      ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
      localExtraTypeInfo.pageType = rzd.br(this.h.type.get());
      ram.i("SubscribePersonalDetail", "onReceiveEvent  publishFeed.share.shortUrl" + this.h.share.shorturl.get());
      if (!TextUtils.isEmpty(this.h.share.shorturl.get())) {
        ram.i("SubscribePersonalDetail", "onReceiveEvent  publishFeed.share.shortUrl" + this.h.share.shorturl.get());
      }
      localsan.mExtraTypeInfo = localExtraTypeInfo;
      localsan.a = this.h.share;
      new sio(this.this$0.getActivity()).b(localsan);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */