package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import aqgo;
import aqgv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.b;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kwt;
import kxm;
import lbz;
import lhu;
import lie;
import lwl;
import lwm.a;
import mas;
import mih;
import ndi;
import nnw;
import wja;

public class ComponentAccountSummary
  extends FrameLayout
  implements lwl
{
  mas a;
  public boolean akQ;
  public boolean alO;
  public boolean alP;
  ReadInJoyYAFolderTextView b;
  
  public ComponentAccountSummary(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    lie locallie;
    if ((paramObject instanceof lie))
    {
      locallie = (lie)paramObject;
      this.a.setModel(locallie);
      if (locallie.a() != null) {}
    }
    else
    {
      return;
    }
    Object localObject = locallie.a().mSubscribeName;
    String str = locallie.a().mSummary;
    if ((this.a.CX()) || (this.a.Db())) {
      str = locallie.a().mTitle;
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if ((locallie.getCellType() == 33) && (locallie.a().mSocialFeedInfo != null) && (locallie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo != null)) {
        if (locallie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.vV == 0L)
        {
          paramObject = locallie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.aiH;
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new c(paramObject, -3355444), 0, ((String)localObject).length(), 33);
          label204:
          localSpannableStringBuilder.append(": ");
          paramObject = locallie.a();
          if ((!this.alO) && (!this.alP)) {
            break label611;
          }
          localObject = new SpannableStringBuilder();
          if ((paramObject.mSocialFeedInfo == null) || (paramObject.mSocialFeedInfo.a == null) || (paramObject.mSocialFeedInfo.a.aih == null)) {
            break label592;
          }
          ((SpannableStringBuilder)localObject).append(paramObject.mSocialFeedInfo.a.aih);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramObject.mSocialFeedInfo.a.aih);
          }
          label327:
          ((SpannableStringBuilder)localObject).append(" ");
          new b(paramObject, -3355444, getContext(), getResources(), this.a);
          ((SpannableStringBuilder)localObject).append(" ");
          localSpannableStringBuilder.append((CharSequence)localObject);
          this.b.ask = true;
        }
      }
      for (;;)
      {
        this.b.setMaxLines(7);
        this.b.setMoreSpan(new a(locallie.a(), -3355444));
        this.b.setText(localSpannableStringBuilder);
        aNf();
        return;
        paramObject = String.valueOf(locallie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.vV);
        if (kxm.AI())
        {
          localObject = aqgv.b((QQAppInterface)kxm.getAppRuntime(), paramObject, true);
          break;
        }
        localObject = locallie.b().az(locallie.a().mSocialFeedInfo.mTopicRecommendFeedsInfo.vV);
        break;
        if (locallie.a().mAccountLess == 0)
        {
          paramObject = locallie.a().mSubscribeID;
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(new c(paramObject, -3355444), 0, ((String)localObject).length(), 33);
          break label204;
        }
        localSpannableStringBuilder.append((CharSequence)localObject);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, ((String)localObject).length(), 33);
        break label204;
        label592:
        if (paramObject.mTitle == null) {
          break label327;
        }
        ((SpannableStringBuilder)localObject).append(paramObject.mTitle);
        break label327;
        label611:
        if (this.akQ)
        {
          localObject = new SpannableStringBuilder();
          if ((paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null) && (paramObject.mSocialFeedInfo.a.aih != null))
          {
            ((SpannableStringBuilder)localObject).append(paramObject.mSocialFeedInfo.a.aih);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.ui", 2, "Comment String: " + paramObject.mSocialFeedInfo.a.aih);
            }
          }
          for (;;)
          {
            localSpannableStringBuilder.append((CharSequence)localObject);
            break;
            if (paramObject.mTitle != null) {
              ((SpannableStringBuilder)localObject).append(paramObject.mTitle);
            }
          }
        }
        localSpannableStringBuilder.append(str);
      }
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
    LayoutInflater.from(paramContext).inflate(2131560328, this, true);
    this.b = ((ReadInJoyYAFolderTextView)findViewById(2131365125));
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
      kxm.a(ComponentAccountSummary.this.getContext(), this.articleInfo, 3);
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
  
  public static class b
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    mas a;
    ArticleInfo articleInfo;
    private int bgColor = -1;
    Context mContext;
    boolean mIsPressed;
    private TextPaint mPaint;
    Resources mResources;
    public int textSize = 16;
    
    public b(ArticleInfo paramArticleInfo, int paramInt, Context paramContext, Resources paramResources, mas parammas)
    {
      this.articleInfo = paramArticleInfo;
      this.bgColor = paramInt;
      this.mContext = paramContext;
      this.mResources = paramResources;
      this.a = parammas;
    }
    
    private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
    {
      kxm.a((Activity)this.mContext, paramArticleInfo);
    }
    
    private void aMX()
    {
      if (this.articleInfo != null)
      {
        int j = -1;
        int i = j;
        if (this.a != null)
        {
          i = j;
          if (this.a.a != null) {
            i = this.a.a.nh();
          }
        }
        ndi.h(this.articleInfo, i);
        return;
      }
      QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
    }
    
    private void q(ArticleInfo paramArticleInfo)
    {
      nnw.K("fast_web_show_light_house_1");
      lbz.a().a().a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
      a(paramArticleInfo, null);
    }
    
    public void onClick(View paramView)
    {
      if (!TextUtils.isEmpty(this.articleInfo.mArticleContentUrl))
      {
        if (!kxm.a(this.articleInfo.mArticleContentUrl, this.articleInfo.mChannelID, this.articleInfo)) {
          break label157;
        }
        q(this.articleInfo);
      }
      for (;;)
      {
        aMX();
        if ((kxm.i(this.articleInfo)) || (kxm.j(this.articleInfo))) {
          kbp.a(null, kxm.f(this.articleInfo), "0X8008A62", "0X8008A62", 0, 0, Long.toString(this.articleInfo.mFeedId), Long.toString(this.articleInfo.mArticleID), Integer.toString(this.articleInfo.mStrategyId), kxm.a(this.articleInfo.innerUniqueID, this.articleInfo.businessId + "", this.articleInfo), false);
        }
        return;
        label157:
        kxm.aJ(this.mContext, this.articleInfo.mArticleContentUrl);
      }
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
      this.mPaint.setColor(-14132075);
      paramTextPaint = this.mPaint;
      if (this.mIsPressed) {}
      for (int i = this.bgColor;; i = 16777215)
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setTextSize(wja.a(2, this.textSize, this.mResources));
        this.mPaint.setUnderlineText(false);
        return;
      }
    }
  }
  
  public class c
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    private int bgColor = -1;
    boolean mIsPressed;
    private TextPaint mPaint;
    protected String mUin;
    
    public c(String paramString, int paramInt)
    {
      this.mUin = paramString;
      this.bgColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      kxm.c = ComponentAccountSummary.this.a.a.a();
      paramView = kwt.acJ + aqgo.encodeToString(String.valueOf(this.mUin).getBytes(), 2);
      kxm.aJ(ComponentAccountSummary.this.getContext(), paramView);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */