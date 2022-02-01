package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.mobileqq.widget.QQToast;
import sbc;

public class FakerFeedsAdapter$2
  implements Runnable
{
  public FakerFeedsAdapter$2(sbc paramsbc, CertifiedAccountMeta.StFeed paramStFeed, int paramInt) {}
  
  public void run()
  {
    this.this$0.updateData(this.c, this.bwb);
    this.this$0.notifyItemChanged(this.bwb);
    if (sbc.a(this.this$0) != null) {
      QQToast.a(sbc.b(this.this$0), 0, 2131697487, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */