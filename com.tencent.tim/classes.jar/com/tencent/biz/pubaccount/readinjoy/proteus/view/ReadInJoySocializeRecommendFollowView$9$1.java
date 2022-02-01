package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import kbp;
import kxm;
import lsf;
import lsn;
import mhx;

public class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$9$1(lsn paramlsn) {}
  
  public void run()
  {
    lsf.a(this.a.this$0).requestLayout();
    lsf.a(this.a.this$0, true);
    if (!lsf.a(this.a.this$0).mRecommendFollowInfos.hasReport)
    {
      lsf.a(this.a.this$0).mRecommendFollowInfos.hasReport = true;
      kbp.a(null, kxm.getLongAccountUin() + "", "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */