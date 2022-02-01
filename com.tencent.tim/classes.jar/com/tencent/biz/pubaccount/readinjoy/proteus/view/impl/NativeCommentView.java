package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import acfp;
import android.content.Context;
import android.text.TextUtils;
import aofk;
import aprv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.d;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kxm;
import lie;
import ltg;
import lth;
import mas;
import mqq.os.MqqHandler;
import ndi;
import nte;
import ntf;
import ntg;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, ntg<CharSequence>
{
  protected ntf<CharSequence> a;
  protected int aPH;
  protected String afx;
  public boolean akP;
  public boolean akQ;
  public mas b = new mas();
  protected long uF;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    setShouldCallClick(true);
  }
  
  private void aNl()
  {
    ArticleInfo localArticleInfo;
    Object localObject;
    if ((this.b.a != null) && (this.b.a.a() != null) && (this.b.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.b.a.a();
      this.a = localArticleInfo.articleViewModel.a();
      t(localArticleInfo);
      this.a.a(this);
      localObject = (CharSequence)this.a.get();
      QLog.d("NativeCommentView", 2, "setDesc: " + localObject);
      if ((localArticleInfo.mFeedType != 30) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z.longValue() != 30L)) && ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d == null) || (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d.name)))) {
        break label499;
      }
      localObject = new aofk(aprv.ep(((CharSequence)this.a.get()).toString().replaceAll("\024", "")), 3, 16);
    }
    label499:
    for (;;)
    {
      setVisibility(0);
      if (this.akQ)
      {
        setMaxLines(2);
        setSpanText("");
        setMoreSpan(null);
        setEllipsis("...");
        setText((CharSequence)localObject);
        return;
      }
      if ((ndi.K(this.b.a.a())) || (ndi.am(this.b.a.a())) || (ndi.R(this.b.a.a())))
      {
        setMaxLines(l(this.b.a.a()));
        if (localArticleInfo.isPGCShortContent()) {}
        setMoreSpan(new ltg(this, -15504151, 16777215, 860716207));
        if (this.akQ)
        {
          setHeight(0);
          return;
        }
        setText((CharSequence)localObject);
        return;
      }
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null)
      {
        setMaxLines(l(this.b.a.a()));
        if (((kxm.r(localArticleInfo)) || (kxm.s(localArticleInfo))) && (this.b.a.a().mChannelID != 0L))
        {
          setSpanText("");
          setMoreSpan(null);
        }
        while (!TextUtils.isEmpty((CharSequence)localObject))
        {
          setText((CharSequence)localObject);
          return;
          setMoreSpan(new lth(this, -15504151, 16777215, 860716207, localArticleInfo));
        }
        setVisibility(8);
        return;
      }
      setVisibility(8);
      return;
    }
  }
  
  public void a(ntf<CharSequence> paramntf)
  {
    paramntf = (CharSequence)paramntf.get();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramntf));
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void nG(boolean paramBoolean)
  {
    QLog.d("NativeCommentView", 1, "showPreCommentText: " + paramBoolean);
    if (paramBoolean) {
      this.afx = (acfp.m(2131718866) + "：");
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null) {
      this.a.b(this);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.a != null) {
      this.a.b(this);
    }
  }
  
  public void setModel(lie paramlie)
  {
    this.b.setModel(paramlie);
    switch (paramlie.getCellType())
    {
    }
    for (;;)
    {
      aNl();
      setShouldCallClick(this.akQ);
      return;
      this.akQ = true;
    }
  }
  
  public void setPreAccountUin(long paramLong)
  {
    QLog.d("NativeCommentView", 1, "setPreAccountUin: " + paramLong);
    this.uF = paramLong;
  }
  
  public void setPreBlankNum(int paramInt)
  {
    QLog.d("NativeCommentView", 1, "setPreBlankNum: " + paramInt);
    this.aPH = paramInt;
  }
  
  protected void t(ArticleInfo paramArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("current text: ");
    Object localObject;
    if (this.a != null)
    {
      localObject = (CharSequence)this.a.get();
      QLog.d("NativeCommentView", 1, localObject);
      if ((paramArticleInfo != null) && (paramArticleInfo.articleViewModel != null))
      {
        paramArticleInfo.articleViewModel.aPH = this.aPH;
        paramArticleInfo.articleViewModel.uF = this.uF;
        paramArticleInfo.articleViewModel.afx = this.afx;
        paramArticleInfo.articleViewModel.reset();
      }
      localObject = new StringBuilder().append("current text: ");
      if (this.a == null) {
        break label149;
      }
    }
    label149:
    for (paramArticleInfo = (CharSequence)this.a.get();; paramArticleInfo = null)
    {
      QLog.d("NativeCommentView", 1, paramArticleInfo);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView
 * JD-Core Version:    0.7.0.1
 */