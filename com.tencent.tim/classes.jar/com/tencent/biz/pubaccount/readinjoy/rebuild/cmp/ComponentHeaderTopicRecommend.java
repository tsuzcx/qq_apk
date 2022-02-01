package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqgo;
import aqgv;
import aqhu;
import aqnm;
import awit;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kbp;
import kwt;
import kxl;
import kxm;
import lie;
import mas;
import mat.a;
import mcj;
import mde;
import mih;
import mih.b;
import ndi;
import noz;
import wja;

public class ComponentHeaderTopicRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private mih.b a;
  private ArticleInfo b;
  private Button bR;
  private LinearLayout dW;
  private KanDianUrlRoundCornerImageView e;
  private ReadInJoyYAFolderTextView f;
  private TextView qD;
  private TextView qE;
  
  public ComponentHeaderTopicRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderTopicRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean Dm()
  {
    return (this.jdField_a_of_type_Mas.a != null) && (this.jdField_a_of_type_Mas.a.a() != null) && (this.jdField_a_of_type_Mas.a.a().mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_Mas.a.a().mTopicRecommendFeedsInfo.ld.size() > 0);
  }
  
  private void aNe() {}
  
  private void aNl()
  {
    if (!Dm()) {}
    while ((this.jdField_a_of_type_Mas.a == null) || (this.jdField_a_of_type_Mas.a.a() == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((kxm.j(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (kxm.m(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTime > 0L) {
        localStringBuilder.append(kxl.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendTime, true));
      }
    }
    else if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      localStringBuilder.append(" ");
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.aiI)) {
        break label156;
      }
      localStringBuilder.append(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.aiI);
    }
    for (;;)
    {
      this.qE.setText(localStringBuilder);
      return;
      localStringBuilder.append("刚刚");
      break;
      label156:
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.ld.get(0) != null) {
        localStringBuilder.append(awit.gL(((mih.b)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTopicRecommendFeedsInfo.ld.get(0)).aTk) + "");
      }
    }
  }
  
  private void aOm()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderTopicRecommend", 2, "less =" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess + " title = " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess == 0) {
      localSpannableStringBuilder.setSpan(new b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, -3355444), 0, localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append(": ");
    localSpannableStringBuilder.append(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary);
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.aSG == 9))
    {
      localSpannableStringBuilder.append(" ");
      new ComponentAccountSummary.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_Mas).textSize = 17;
      localSpannableStringBuilder.append(" ");
    }
    this.f.setMaxLines(7);
    this.f.setMoreSpan(new a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
    this.f.setText(localSpannableStringBuilder);
  }
  
  private void aOn()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null))
    {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "Some ugc info is null. ", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo });
      return;
    }
    long l = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
    localSpannableStringBuilder.append(kxm.ew(aqgv.b((QQAppInterface)kxm.getAppRuntime(), String.valueOf(l), true)));
    localSpannableStringBuilder.setSpan(new mat.a(l, -3355444, this.jdField_a_of_type_Mas), 0, localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(": ");
    if ((mas.H(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ndi.aa(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      localSpannableStringBuilder.append(((SocializeFeedsInfo.t)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title);
      this.f.setText(localSpannableStringBuilder);
    }
    for (;;)
    {
      this.f.setMaxLines(7);
      this.f.setMoreSpan(new a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -3355444));
      return;
      mde.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r, this.f, this.jdField_a_of_type_Mas, localSpannableStringBuilder);
    }
  }
  
  private void aOo()
  {
    Object localObject;
    if (Dm())
    {
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessName;
      String str = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessNamePrefix;
      this.qD.setText(str + (String)localObject);
      localObject = new noz();
    }
    try
    {
      ((noz)localObject).url = new URL(this.jdField_a_of_type_Mih$b.picUrl);
      ((noz)localObject).reqWidth = this.e.getWidth();
      ((noz)localObject).reqHeight = this.e.getHeight();
      this.e.setImageForImageCollection((noz)localObject, new mcj(this));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
  }
  
  private void aOp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderTopicRecommend", 2, "business url is " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_Mih$b == null)) {
      QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, " topicRecommendInfo: ", this.jdField_a_of_type_Mih$b });
    }
    while (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl)) {
      return;
    }
    Object localObject = new Intent(getContext(), PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("url", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessUrl);
    getContext().startActivity((Intent)localObject);
    localObject = kxm.f(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str = kxm.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_Mih$b.businessId + "", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    kbp.a(null, (String)localObject, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), Long.toString(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Long.toString(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), str, false);
    ndi.g(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Mas.a.nh());
    kxm.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_b_of_type_Ndi.nh());
  }
  
  private void bind()
  {
    if (Dm())
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Mas.a.a();
      this.jdField_a_of_type_Mih$b = ((mih.b)this.jdField_a_of_type_Mas.a.a().mTopicRecommendFeedsInfo.ld.get(0));
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_Mas.a.a();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    aNl();
    aOo();
    setFollowButton();
    if (ndi.T(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      aOn();
      return;
    }
    aOm();
  }
  
  private void k(Bitmap paramBitmap)
  {
    try
    {
      localBitmap = aqhu.c(paramBitmap, wja.dp2px(3.0F, getResources()), paramBitmap.getWidth(), paramBitmap.getHeight());
      this.e.setImageBitmap(localBitmap);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Bitmap localBitmap = paramBitmap;
        if (QLog.isColorLevel())
        {
          QLog.d("ComponentHeaderTopicRecommend", 2, QLog.getStackTraceString(localOutOfMemoryError));
          localBitmap = paramBitmap;
        }
      }
    }
  }
  
  private void setFollowButton()
  {
    if (this.jdField_a_of_type_Mih$b != null)
    {
      if ((!kxm.i(this.jdField_a_of_type_Mas.a.a())) && (!kxm.l(this.jdField_a_of_type_Mas.a.a()))) {
        break label139;
      }
      if (this.jdField_a_of_type_Mih$b.isFollow != 1) {
        break label95;
      }
      this.bR.setBackgroundColor(-1);
      this.bR.setTextColor(Color.parseColor("#bbbbbb"));
      this.bR.getPaint().setFakeBoldText(false);
      this.bR.setVisibility(0);
    }
    label95:
    while ((!kxm.j(this.jdField_a_of_type_Mas.a.a())) && (!kxm.m(this.jdField_a_of_type_Mas.a.a()))) {
      for (;;)
      {
        return;
        this.bR.setText("");
        this.bR.setBackgroundColor(-1);
        this.bR.setTextColor(Color.parseColor("#07D0B0"));
        this.bR.getPaint().setFakeBoldText(true);
      }
    }
    label139:
    this.bR.setVisibility(4);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie)) {
      bind();
    }
  }
  
  public void aHq()
  {
    super.aHq();
  }
  
  public void aNf()
  {
    super.aNf();
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.dW.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.dW.getLayoutParams();
      if (!Dj()) {
        break label62;
      }
      localLayoutParams.setMargins(aqnm.dip2px(12.0F), 0, aqnm.dip2px(15.0F), 0);
    }
    for (;;)
    {
      this.dW.setLayoutParams(localLayoutParams);
      return;
      label62:
      localLayoutParams.setMargins(aqnm.dip2px(12.0F), 0, aqnm.dip2px(2.25F), 0);
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.e = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131380087));
    this.e.setCorner(wja.dp2px(3.0F, getResources()));
    this.bR = ((Button)paramView.findViewById(2131363870));
    this.bR.getPaint().setFakeBoldText(true);
    this.qD = ((TextView)paramView.findViewById(2131380089));
    this.qD.getPaint().setFakeBoldText(true);
    this.f = ((ReadInJoyYAFolderTextView)paramView.findViewById(2131380086));
    this.qE = ((TextView)paramView.findViewById(2131380088));
    this.dW = ((LinearLayout)paramView.findViewById(2131380090));
    this.dW.setOnClickListener(this);
    this.bR.setOnClickListener(this);
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560321, this, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aNe();
      continue;
      aOp();
    }
  }
  
  public class a
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    ArticleInfo articleInfo;
    private int bgColor = -1;
    boolean mIsPressed;
    private TextPaint mPaint;
    
    public a(ArticleInfo paramArticleInfo, int paramInt)
    {
      this.articleInfo = paramArticleInfo;
      this.bgColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      if (ndi.T(this.articleInfo))
      {
        kxm.a(ComponentHeaderTopicRecommend.this.getContext(), ComponentHeaderTopicRecommend.this.a.a.a(), 4, false, 7, false);
        ndi.g(this.articleInfo, ComponentHeaderTopicRecommend.this.a.a.nh());
        return;
      }
      if (!TextUtils.isEmpty(this.articleInfo.mArticleContentUrl)) {
        kxm.aJ(ComponentHeaderTopicRecommend.this.getContext(), this.articleInfo.mArticleContentUrl);
      }
      kbp.a(null, kxm.f(this.articleInfo), "0X8008A62", "0X8008A62", 0, 0, Long.toString(this.articleInfo.mFeedId), Long.toString(this.articleInfo.mArticleID), Integer.toString(this.articleInfo.mStrategyId), kxm.a(this.articleInfo.innerUniqueID, this.articleInfo.businessId + "", this.articleInfo), false);
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.mIsPressed = paramBoolean;
      if (this.mPaint != null) {
        updateDrawState(this.mPaint);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      this.mPaint = paramTextPaint;
      this.mPaint.setColor(Color.parseColor("#285c95"));
      paramTextPaint = this.mPaint;
      if (this.mIsPressed) {}
      for (int i = this.bgColor;; i = 16119285)
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setUnderlineText(false);
        return;
      }
    }
  }
  
  public class b
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    private int bgColor = -1;
    boolean mIsPressed;
    private TextPaint mPaint;
    protected String mUin;
    
    public b(String paramString, int paramInt)
    {
      this.mUin = paramString;
      this.bgColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      paramView = kwt.acJ + aqgo.encodeToString(this.mUin.getBytes(), 0);
      Intent localIntent = new Intent(ComponentHeaderTopicRecommend.this.getContext(), PublicAccountBrowser.class);
      localIntent.putExtra("url", paramView);
      ComponentHeaderTopicRecommend.this.getContext().startActivity(localIntent);
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.mIsPressed = paramBoolean;
      if (this.mPaint != null) {
        updateDrawState(this.mPaint);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      this.mPaint = paramTextPaint;
      this.mPaint.setColor(Color.parseColor("#285c95"));
      paramTextPaint = this.mPaint;
      if (this.mIsPressed) {}
      for (int i = this.bgColor;; i = -1)
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setUnderlineText(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend
 * JD-Core Version:    0.7.0.1
 */