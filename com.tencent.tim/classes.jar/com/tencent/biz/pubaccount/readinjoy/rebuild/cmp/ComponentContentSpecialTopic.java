package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import kwz;
import kxm;
import lie;
import lwk;
import lwm.a;
import mas;
import mde;

public class ComponentContentSpecialTopic
  extends RelativeLayout
  implements lwk
{
  mas a;
  double aW;
  KandianUrlImageView v;
  
  public ComponentContentSpecialTopic(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentSpecialTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentContentSpecialTopic(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.a.setModel(paramObject);
      aNf();
      paramObject = paramObject.a();
      if (paramObject != null) {
        kwz.a(this.v, kxm.b(paramObject.mFirstPagePicUrl), getContext());
      }
    }
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf()
  {
    ArticleInfo localArticleInfo;
    if (this.a.a != null)
    {
      localArticleInfo = this.a.a.a();
      if (localArticleInfo != null) {
        break label28;
      }
    }
    label28:
    while ((this.aW != 0.0D) && (this.aW == localArticleInfo.mTopicPicWHRatio)) {
      return;
    }
    mde.a(getContext(), this.v, localArticleInfo.mTopicPicWHRatio);
    this.aW = localArticleInfo.mTopicPicWHRatio;
  }
  
  public void cG(View paramView)
  {
    this.v = ((KandianUrlImageView)paramView.findViewById(2131368896));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560308, this, true);
  }
  
  public void init(Context paramContext)
  {
    this.a = new mas();
    this.aW = 0.0D;
    cG(f(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSpecialTopic
 * JD-Core Version:    0.7.0.1
 */