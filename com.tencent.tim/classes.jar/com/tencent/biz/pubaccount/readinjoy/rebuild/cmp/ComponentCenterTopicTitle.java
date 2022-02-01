package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import awit;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.ArrayList;
import lie;
import lwl;
import lwm.a;
import mas;
import mih;
import mih.b;

public class ComponentCenterTopicTitle
  extends ComponentTitle
  implements lwl
{
  TextView mDesc;
  TextView mTitle;
  
  public ComponentCenterTopicTitle(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.a.setModel(paramObject);
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.mTopicRecommendFeedsInfo != null) && (paramObject.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld != null) && (!paramObject.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.isEmpty()))
      {
        paramObject = (mih.b)paramObject.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0);
        String str = paramObject.businessNamePrefix + paramObject.businessName;
        this.mTitle.setText(str);
        if (paramObject.aTk <= 0) {
          break label176;
        }
        paramObject = String.format("- %s人正在参与 -", new Object[] { awit.gL(paramObject.aTk) });
        this.mDesc.setText(paramObject);
        this.mDesc.setVisibility(0);
      }
    }
    for (;;)
    {
      aNf();
      return;
      label176:
      this.mDesc.setVisibility(8);
    }
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf() {}
  
  public void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560332, this, true);
    this.mTitle = ((TextView)findViewById(2131365126));
    this.mDesc = ((TextView)findViewById(2131365721));
  }
  
  public void setReadedStatus(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentCenterTopicTitle
 * JD-Core Version:    0.7.0.1
 */