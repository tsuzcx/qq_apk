package com.tencent.biz.qqstory.storyHome.detail.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qrd;
import qrn;
import qsr;
import qss;
import qst;
import qsu;
import qsv;
import qsw;
import qta;
import qtb;
import qtf;
import qth;
import rsd;

public class StoryDetailListView
  extends SegmentList
{
  private qrd a;
  public int bnW;
  public int mSource;
  private List<rsd> nQ = new ArrayList();
  private Activity y;
  
  public StoryDetailListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryDetailListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryDetailListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean Kx()
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext())
    {
      rsd localrsd = (rsd)localIterator.next();
      if ((localrsd instanceof qsw)) {
        return false;
      }
      if (localrsd.getCount() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.a != null) {
      this.a.pullToRefresh();
    }
    return true;
  }
  
  public void bd(Activity paramActivity)
  {
    this.y = paramActivity;
  }
  
  public void box()
  {
    super.setActTAG("list_qqstory_detail");
    this.nQ.add(new qtf(this.y, this.mSource, this.bnW));
    this.nQ.add(new qth(this.y, this.mSource, this.bnW));
    this.nQ.add(new qsr(this.y));
    this.nQ.add(new qsw(this.y));
    this.nQ.add(new qtb(this.y));
    this.nQ.add(new qst(this.y));
    this.nQ.add(new qta(this.y));
    this.nQ.add(new qss(this.y));
    this.nQ.add(new qsu(this.y));
    this.nQ.add(new qsv(this.y));
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      a((rsd)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130851428);
  }
  
  public void pn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.xT(1);
      return;
    }
    super.eu(1, buK);
  }
  
  public int sC()
  {
    Iterator localIterator = this.nQ.iterator();
    rsd localrsd;
    for (int i = 0;; i = localrsd.getCount() + i) {
      if (localIterator.hasNext())
      {
        localrsd = (rsd)localIterator.next();
        if (!(localrsd instanceof qss)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public int sD()
  {
    Iterator localIterator = this.nQ.iterator();
    int i = 0;
    rsd localrsd;
    if (localIterator.hasNext())
    {
      localrsd = (rsd)localIterator.next();
      if ((localrsd instanceof qss)) {
        i = localrsd.getCount() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localrsd.getCount() + i;
        break;
      }
      return i;
    }
  }
  
  public void setCallback(qrn paramqrn)
  {
    qtf localqtf = (qtf)a("GeneralFeedProfileSegment");
    qth localqth = (qth)a("ShareGroupFeedProfileSegment");
    qsr localqsr = (qsr)a("BannerProfileSegment");
    qsw localqsw = (qsw)a("DetailInteractSegment");
    qst localqst = (qst)a("DetailDoubleTabSegment");
    qta localqta = (qta)a("DetailLikeListSegment");
    qss localqss = (qss)a("DetailCommentSegment");
    localqtf.setCallback(paramqrn);
    localqth.setCallback(paramqrn);
    localqsr.setCallback(paramqrn);
    localqsw.setCallback(paramqrn);
    localqst.setCallback(paramqrn);
    localqta.setCallback(paramqrn);
    localqss.setCallback(paramqrn);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.nQ.iterator();
    for (;;)
    {
      rsd localrsd;
      if (localIterator.hasNext())
      {
        localrsd = (rsd)localIterator.next();
        if (!(localrsd instanceof qsw)) {}
      }
      else
      {
        return;
      }
      localrsd.setDisplay(paramBoolean);
    }
  }
  
  public void setRequestDataListener(qrd paramqrd)
  {
    this.a = paramqrd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */