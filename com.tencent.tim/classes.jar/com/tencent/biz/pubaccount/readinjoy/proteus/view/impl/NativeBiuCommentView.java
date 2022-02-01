package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import aofk;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kxm;
import lie;
import lsz;
import mas;
import mqq.os.MqqHandler;
import ndi;
import nte;
import ntf;
import ntg;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, ntg<CharSequence>
{
  private nte articleViewModel;
  
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(aofk.a);
    setShouldCallClick(false);
  }
  
  private void aNk()
  {
    if (this.articleViewModel != null)
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.articleViewModel.a();
      setMaxLines(l(localArticleInfo));
      setMoreSpan(new a(localArticleInfo, -3355444));
      this.a = this.articleViewModel.c();
      this.a.a(this);
      t(localArticleInfo);
      QLog.d("NativeBiuCommentView", 2, "bindRecommendCommentHeader: " + this.a.get());
      setText((CharSequence)this.a.get());
    }
  }
  
  public void a(ntf<CharSequence> paramntf)
  {
    paramntf = (CharSequence)paramntf.get();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramntf));
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
    this.articleViewModel = paramlie.a().articleViewModel;
    aNk();
  }
  
  public class a
    extends lsz
  {
    ArticleInfo articleInfo;
    
    public a(ArticleInfo paramArticleInfo, int paramInt)
    {
      super(13421772, 860716207);
      this.articleInfo = paramArticleInfo;
    }
    
    public void onClick(View paramView)
    {
      if (ndi.S(this.articleInfo))
      {
        kxm.a(NativeBiuCommentView.this.getContext(), this.articleInfo, 0, false, 5, false);
        ndi.g(this.articleInfo, (int)this.articleInfo.mChannelID);
        return;
      }
      if (ndi.ag(this.articleInfo))
      {
        paramView = NativeBiuCommentView.this.getContext();
        if ((paramView instanceof Activity)) {
          kxm.c(paramView, this.articleInfo, 6);
        }
        ndi.g(this.articleInfo, (int)this.articleInfo.mChannelID);
        return;
      }
      kxm.a(NativeBiuCommentView.this.getContext(), this.articleInfo, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */