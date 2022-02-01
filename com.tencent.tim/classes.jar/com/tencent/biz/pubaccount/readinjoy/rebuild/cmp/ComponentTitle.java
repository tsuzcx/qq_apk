package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import aqgz;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import java.util.ArrayList;
import java.util.List;
import kxm;
import lie;
import lwl;
import lwm.a;
import mas;
import mhr;
import mhr.a;
import ndi;
import wja;

public class ComponentTitle
  extends FrameLayout
  implements lwl
{
  mas a;
  TextView title;
  
  public ComponentTitle(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  public ComponentTitle(Context paramContext, Object paramObject)
  {
    super(paramContext);
    b(paramContext, paramObject);
  }
  
  private void b(Context paramContext, Object paramObject)
  {
    bY(paramContext);
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      aNf();
    }
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.a.setModel(paramObject);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      try
      {
        ArticleInfo localArticleInfo = paramObject.a();
        if (((ndi.ak(localArticleInfo)) || (ndi.S(localArticleInfo)) || (ndi.T(localArticleInfo)) || (ndi.U(localArticleInfo))) && (!ndi.aa(paramObject.a()))) {
          paramObject = ((SocializeFeedsInfo.t)paramObject.a().mSocialFeedInfo.a.lb.get(0)).title;
        }
        for (;;)
        {
          localSpannableStringBuilder.append(paramObject);
          this.title.setText(localSpannableStringBuilder);
          return;
          if (kxm.B(localArticleInfo)) {
            paramObject = ((mhr.a)localArticleInfo.mNewPolymericInfo.iP.get(0)).articleTitle;
          } else {
            paramObject = paramObject.a().mTitle;
          }
        }
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
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
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.title.getLayoutParams();
    if (this.a.Df())
    {
      localLayoutParams1.setMargins(0, 0, 0, 0);
      if (this.a.Dg()) {
        this.title.setLineSpacing(4.0F, 1.0F);
      }
    }
    for (;;)
    {
      if ((aqgz.getWidth() >= 1080L) && (this.title != null) && ((this.title.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localLayoutParams1.topMargin = Math.max(localLayoutParams1.topMargin - wja.dp2px(4.5F, getResources()), 0);
        localLayoutParams1.bottomMargin = Math.max(localLayoutParams1.bottomMargin - wja.dp2px(6.0F, getResources()), 0);
      }
      this.title.setLayoutParams(localLayoutParams1);
      return;
      if (kxm.B(this.a.a.a()))
      {
        this.title.setTextSize(14.0F);
        this.title.setTextColor(Color.parseColor("#D8FFFFFF"));
        this.title.setLines(2);
        this.title.setEllipsize(TextUtils.TruncateAt.END);
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.title.getLayoutParams();
        localLayoutParams2.leftMargin = 0;
        localLayoutParams2.topMargin = wja.dp2px(4.0F, getResources());
        localLayoutParams2.rightMargin = wja.dp2px(10.0F, getResources());
        localLayoutParams2.bottomMargin = wja.dp2px(0.0F, getResources());
        this.title.setLayoutParams(localLayoutParams2);
        this.title.setGravity(51);
        this.title.setPadding(0, wja.dp2px(2.0F, getResources()), 0, wja.dp2px(2.0F, getResources()));
      }
      else if (this.a.De())
      {
        int i = this.title.getPaddingTop();
        this.title.getBottom();
        int j = this.title.getPaddingLeft();
        int k = this.title.getPaddingRight();
        if (this.a.CV())
        {
          localLayoutParams1.topMargin = wja.dp2px(0.0F, getResources());
          localLayoutParams1.bottomMargin = wja.dp2px(0.0F, getResources());
          localLayoutParams1.leftMargin = wja.dp2px(11.0F, getResources());
          localLayoutParams1.rightMargin = wja.dp2px(11.0F, getResources());
          int m = wja.dp2px(10.0F, getResources());
          this.title.setPadding(j, i, k, m);
        }
        else
        {
          localLayoutParams1.topMargin = wja.dp2px(18.0F, getResources());
          localLayoutParams1.bottomMargin = wja.dp2px(0.0F, getResources());
          localLayoutParams1.leftMargin = wja.dp2px(11.0F, getResources());
          localLayoutParams1.rightMargin = wja.dp2px(11.0F, getResources());
          this.title.setPadding(j, i, k, 0);
        }
      }
      else if ((this.a.CW()) || (this.a.CX()))
      {
        localLayoutParams1.topMargin = wja.dp2px(0.0F, getResources());
        localLayoutParams1.bottomMargin = wja.dp2px(0.0F, getResources());
        localLayoutParams1.leftMargin = wja.dp2px(12.0F, getResources());
        localLayoutParams1.rightMargin = wja.dp2px(20.0F, getResources());
      }
      else if (this.a.CY())
      {
        localLayoutParams1.topMargin = wja.dp2px(0.0F, getResources());
        localLayoutParams1.bottomMargin = wja.dp2px(0.0F, getResources());
        localLayoutParams1.leftMargin = wja.dp2px(12.0F, getResources());
        localLayoutParams1.rightMargin = wja.dp2px(20.0F, getResources());
      }
      else if ((this.a.CZ()) || (this.a.Db()) || (mas.G(this.a.a.a())) || (this.a.Dc()))
      {
        localLayoutParams1.topMargin = wja.dp2px(13.0F, getResources());
        localLayoutParams1.bottomMargin = wja.dp2px(17.0F, getResources());
        localLayoutParams1.leftMargin = wja.dp2px(12.0F, getResources());
        localLayoutParams1.rightMargin = wja.dp2px(12.0F, getResources());
      }
      else if (this.a.Da())
      {
        this.title.setMinimumHeight(wja.dp2px(40.0F, getResources()));
      }
      else if (this.a.CV())
      {
        localLayoutParams1.topMargin = wja.dp2px(13.0F, getResources());
        localLayoutParams1.bottomMargin = wja.dp2px(0.0F, getResources());
        localLayoutParams1.leftMargin = wja.dp2px(11.0F, getResources());
        localLayoutParams1.rightMargin = wja.dp2px(11.0F, getResources());
      }
      else
      {
        localLayoutParams1.topMargin = wja.dp2px(13.0F, getResources());
        localLayoutParams1.bottomMargin = wja.dp2px(11.0F, getResources());
        localLayoutParams1.leftMargin = wja.dp2px(11.0F, getResources());
        localLayoutParams1.rightMargin = wja.dp2px(11.0F, getResources());
      }
    }
  }
  
  public void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560329, this, true);
    this.title = ((TextView)findViewById(2131365126));
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    if ((!this.a.Dd()) && (!this.a.Df()) && (!mas.G(this.a.a.a())))
    {
      if (!paramBoolean) {
        this.title.setTextColor(getContext().getResources().getColor(2131165381));
      }
    }
    else {
      return;
    }
    this.title.setTextColor(getContext().getResources().getColor(2131166741));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle
 * JD-Core Version:    0.7.0.1
 */