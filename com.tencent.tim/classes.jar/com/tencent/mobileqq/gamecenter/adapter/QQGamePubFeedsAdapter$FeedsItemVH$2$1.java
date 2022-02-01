package com.tencent.mobileqq.gamecenter.adapter;

import ahrb.b;
import ahrl;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class QQGamePubFeedsAdapter$FeedsItemVH$2$1
  implements Runnable
{
  public QQGamePubFeedsAdapter$FeedsItemVH$2$1(ahrl paramahrl, int paramInt) {}
  
  public void run()
  {
    if ((this.Is == 3) || (this.Is == 5))
    {
      ahrb.b.a(this.a.a).setVisibility(8);
      this.a.a.n.setVisibility(4);
      this.a.a.TC.setVisibility(4);
      this.a.a.TF.setVisibility(4);
    }
    while (ahrb.b.a(this.a.a).type == 1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1
 * JD-Core Version:    0.7.0.1
 */