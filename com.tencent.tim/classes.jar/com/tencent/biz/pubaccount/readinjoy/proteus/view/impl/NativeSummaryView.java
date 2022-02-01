package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import anbk;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import aofk;
import aqgv;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kvm;
import kwz;
import kxm;
import lie;
import lsz;
import mas;
import mih;
import mih.b;
import mqq.os.MqqHandler;
import ndi;
import nqp;
import nte;
import ntf;
import ntg;

public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, ntg<CharSequence>
{
  mas jdField_a_of_type_Mas = new mas();
  private ntf<CharSequence> jdField_a_of_type_Ntf;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void a(lie paramlie, SpannableStringBuilder paramSpannableStringBuilder, ReadInJoyUserInfoModule.a parama)
  {
    long l1 = 0L;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramlie.a();
    if (!ndi.ag((BaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    if ((ndi.N((ArticleInfo)localObject)) || (ndi.al((BaseArticleInfo)localObject)) || (ndi.ec(paramlie.getCellType())) || (ndi.ag((BaseArticleInfo)localObject)))
    {
      localObject = paramlie.a().mSubscribeName;
      if ((paramlie.getCellType() == 33) && (paramlie.a().mSocialFeedInfo != null) && (paramlie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo != null)) {
        if (paramlie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.vV == 0L)
        {
          parama = paramlie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.aiH;
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
      }
    }
    while ((!ndi.P((ArticleInfo)localObject)) || (!ndi.S((ArticleInfo)localObject))) {
      for (;;)
      {
        try
        {
          l1 = Long.valueOf(parama).longValue();
          localSpannableStringBuilder.setSpan(new nqp(l1, "2", paramlie.a()), 0, localSpannableStringBuilder.length(), 33);
          localSpannableStringBuilder.append(": ");
          paramSpannableStringBuilder.append(new SpannableStringBuilder(new aofk(localSpannableStringBuilder, 3, 16)));
          return;
          parama = String.valueOf(paramlie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.vV);
          if (kxm.AI())
          {
            localObject = aqgv.b((QQAppInterface)kxm.getAppRuntime(), parama, true);
            continue;
          }
          localObject = paramlie.b().az(paramlie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.vV);
        }
        catch (NumberFormatException parama)
        {
          parama.printStackTrace();
          l1 = 0L;
          continue;
        }
        if (paramlie.a().mAccountLess == 0)
        {
          parama = paramlie.a().mSubscribeID;
          try
          {
            long l2 = Long.valueOf(parama).longValue();
            l1 = l2;
          }
          catch (NumberFormatException parama)
          {
            for (;;)
            {
              parama.printStackTrace();
            }
          }
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new nqp(l1, "2", paramlie.a()), 0, localSpannableStringBuilder.length(), 33);
          continue;
        }
        localSpannableStringBuilder.append((CharSequence)localObject);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
      }
    }
    l1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
    parama = ReadInJoyUserInfoModule.a(l1, parama);
    if (parama != null) {}
    for (parama = parama.nick;; parama = ReadInJoyUserInfoModule.getDefaultNickName())
    {
      if (!TextUtils.isEmpty(parama))
      {
        localSpannableStringBuilder.append(kxm.ew(parama));
        localSpannableStringBuilder.setSpan(new nqp(l1, "2", paramlie.a()), 0, localSpannableStringBuilder.length(), 33);
      }
      if (kxm.w((ArticleInfo)localObject)) {
        localSpannableStringBuilder.append(" 回答了");
      }
      localSpannableStringBuilder.append(": ");
      break;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo, Context paramContext)
  {
    if ((kxm.i(paramArticleInfo)) || (kxm.j(paramArticleInfo)))
    {
      kxm.a(paramContext, paramArticleInfo, 1, false, 4, false);
      ndi.g(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      kxm.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    }
  }
  
  private void b(lie paramlie)
  {
    if (paramlie.a() == null) {
      return;
    }
    this.jdField_a_of_type_Ntf = paramlie.a().articleViewModel.b();
    this.jdField_a_of_type_Ntf.a(this);
    setText((CharSequence)this.jdField_a_of_type_Ntf.get());
    v(paramlie.a());
  }
  
  public static void b(lie paramlie, SpannableStringBuilder paramSpannableStringBuilder, ReadInJoyUserInfoModule.a parama)
  {
    int j = 1;
    int k = 0;
    ArticleInfo localArticleInfo = paramlie.a();
    if (kvm.h(localArticleInfo))
    {
      paramSpannableStringBuilder.append(localArticleInfo.mSocialFeedInfo.ahP);
      return;
    }
    int i;
    switch (paramlie.getCellType())
    {
    default: 
      i = 0;
      if (ndi.ag(localArticleInfo))
      {
        paramlie = "";
        if (!TextUtils.isEmpty(localArticleInfo.mTitle))
        {
          paramlie = localArticleInfo.mTitle;
          label123:
          paramSpannableStringBuilder.append(paramlie);
          i = k;
        }
      }
      break;
    }
    for (;;)
    {
      QLog.d("NativeSummaryView", 2, "addComment: " + localArticleInfo.rawkey + " ssb: " + paramSpannableStringBuilder + " condition flag: " + i);
      return;
      i = 1;
      break;
      i = 1;
      break;
      if (TextUtils.isEmpty(localArticleInfo.mSummary)) {
        break label123;
      }
      paramlie = localArticleInfo.mSummary;
      break label123;
      if ((ndi.N(localArticleInfo)) || (ndi.al(localArticleInfo)) || (ndi.ec(paramlie.getCellType())))
      {
        k = ndi.k(localArticleInfo);
        if (paramlie.a().isPGCShortContent())
        {
          i = 7;
          if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (!TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih))) {
            paramlie = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih;
          }
          for (;;)
          {
            paramSpannableStringBuilder.append(paramlie);
            break;
            if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
              paramlie = localArticleInfo.mTitle;
            } else {
              paramlie = "";
            }
          }
        }
        if ((35 == k) || (34 == k))
        {
          paramlie = new SpannableStringBuilder();
          if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih != null))
          {
            paramlie.append(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih);
            }
          }
          for (;;)
          {
            paramSpannableStringBuilder.append(paramlie);
            i = j;
            break;
            if (localArticleInfo.mTitle != null) {
              paramlie.append(localArticleInfo.mTitle);
            }
          }
        }
        if (i != 0)
        {
          if (!TextUtils.isEmpty(localArticleInfo.mSummary)) {}
          for (paramlie = localArticleInfo.mSummary;; paramlie = "")
          {
            if (!TextUtils.isEmpty(localArticleInfo.mTitle)) {
              paramlie = localArticleInfo.mTitle;
            }
            paramSpannableStringBuilder.append(paramlie);
            i = 2;
            break;
          }
        }
        parama = paramlie.a().mSummary;
        if ((mas.h(paramlie)) || (mas.k(paramlie))) {
          parama = paramlie.a().mTitle;
        }
        if (TextUtils.isEmpty(parama)) {}
        paramSpannableStringBuilder.append(parama);
        SpannableStringBuilder localSpannableStringBuilder;
        if ((paramlie.getCellType() == 33) && (!ndi.ap(localArticleInfo)))
        {
          parama = (mih.b)localArticleInfo.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0);
          localSpannableStringBuilder = paramSpannableStringBuilder.append("“");
          if (!TextUtils.isEmpty(parama.businessNamePrefix)) {
            break label704;
          }
          paramlie = "";
          label664:
          localSpannableStringBuilder = localSpannableStringBuilder.append(paramlie);
          if (!TextUtils.isEmpty(parama.businessName)) {
            break label712;
          }
        }
        label704:
        label712:
        for (paramlie = "";; paramlie = parama.businessName)
        {
          localSpannableStringBuilder.append(paramlie).append("”");
          i = 3;
          break;
          paramlie = parama.businessNamePrefix;
          break label664;
        }
      }
      i = k;
      if (ndi.P(localArticleInfo))
      {
        i = k;
        if (ndi.S(localArticleInfo))
        {
          paramlie = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail;
          if (kxm.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r))
          {
            paramlie = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.a(localArticleInfo, "2", parama);
            if (!TextUtils.isEmpty(paramlie)) {
              paramSpannableStringBuilder.append(paramlie);
            }
            i = 4;
          }
          else if ((mas.H(localArticleInfo)) && (!ndi.aa(localArticleInfo)))
          {
            paramlie = ((SocializeFeedsInfo.t)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title;
            if ((!TextUtils.isEmpty(paramlie)) && (TextUtils.equals(kwz.ep(paramlie), paramlie))) {
              anbk.nn(paramlie);
            }
            i = 5;
          }
          else
          {
            i = k;
            if (!TextUtils.isEmpty(paramlie))
            {
              paramSpannableStringBuilder.append(new aofk(anbk.nn(paramlie), 3, 16));
              i = 6;
            }
          }
        }
      }
    }
  }
  
  private void v(ArticleInfo paramArticleInfo)
  {
    if (!paramArticleInfo.isPGCShortContent()) {}
    setMaxLines(l(paramArticleInfo));
    setMoreSpan(new a(paramArticleInfo, -3355444));
    if ((kxm.r(paramArticleInfo)) || (kxm.s(paramArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
  }
  
  public void a(ntf<CharSequence> paramntf)
  {
    paramntf = (CharSequence)paramntf.get();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramntf));
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
    if (this.jdField_a_of_type_Ntf != null) {
      this.jdField_a_of_type_Ntf.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_Ntf != null) {
      this.jdField_a_of_type_Ntf.b(this);
    }
  }
  
  public void setModel(lie paramlie)
  {
    this.jdField_a_of_type_Mas.setModel(paramlie);
    setShouldCallClick(false);
    switch (paramlie.getCellType())
    {
    }
    for (;;)
    {
      b(paramlie);
      return;
      setShouldCallClick(true);
    }
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
      if ((ndi.ag(this.articleInfo)) && ((NativeSummaryView.this.getContext() instanceof Activity)))
      {
        kxm.b((Activity)NativeSummaryView.this.getContext(), this.articleInfo);
        ndi.g(this.articleInfo, (int)this.articleInfo.mChannelID);
        return;
      }
      if (ndi.S(this.articleInfo)) {}
      for (int i = 2;; i = 3)
      {
        kxm.a(NativeSummaryView.this.getContext(), this.articleInfo, i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */