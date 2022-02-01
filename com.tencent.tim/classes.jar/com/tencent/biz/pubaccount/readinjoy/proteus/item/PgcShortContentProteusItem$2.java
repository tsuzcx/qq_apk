package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import lot;

public class PgcShortContentProteusItem$2
  extends ComponentPGCShortContentBig
{
  public PgcShortContentProteusItem$2(lot paramlot, Context paramContext, ArticleInfo paramArticleInfo)
  {
    super(paramContext);
  }
  
  public int oK()
  {
    if ((this.d.mSocialFeedInfo != null) && (this.d.mSocialFeedInfo.a != null)) {
      return 11;
    }
    return super.oK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem.2
 * JD-Core Version:    0.7.0.1
 */