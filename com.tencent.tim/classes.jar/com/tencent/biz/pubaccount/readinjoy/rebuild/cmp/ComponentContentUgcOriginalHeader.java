package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import anbk;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aofk;
import aqgo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kbp;
import kwt;
import kxm;
import lie;
import lwl;
import lwm.a;
import mas;
import mbw;
import ndi;
import odv;
import wja;

public class ComponentContentUgcOriginalHeader
  extends LinearLayout
  implements lwl
{
  mas a;
  private SpannableStringBuilder c;
  public ReadInJoyYAFolderTextView c;
  
  public ComponentContentUgcOriginalHeader(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ComponentContentUgcOriginalHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void B(ArticleInfo paramArticleInfo)
  {
    long l = paramArticleInfo.mSocialFeedInfo.a.cuin;
    Object localObject2 = paramArticleInfo.mSocialFeedInfo.a.ail;
    Object localObject1 = ReadInJoyUserInfoModule.a(l, null);
    if (localObject1 != null)
    {
      localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
      this.jdField_c_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
      this.jdField_c_of_type_AndroidTextSpannableStringBuilder.append(kxm.ew((String)localObject1));
      this.jdField_c_of_type_AndroidTextSpannableStringBuilder.setSpan(new b(l, -3355444), 0, this.jdField_c_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.jdField_c_of_type_AndroidTextSpannableStringBuilder.append(": ");
      if ((!mas.H(paramArticleInfo)) || (ndi.aa(paramArticleInfo))) {
        break label199;
      }
      localObject1 = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.a.lb.get(0)).title;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_c_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
    label325:
    for (;;)
    {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setText(this.jdField_c_of_type_AndroidTextSpannableStringBuilder);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new a(paramArticleInfo, -3355444));
      return;
      localObject1 = ReadInJoyUserInfoModule.getDefaultNickName();
      break;
      label199:
      if (kxm.a(paramArticleInfo.mSocialFeedInfo.a))
      {
        List localList = paramArticleInfo.mSocialFeedInfo.a.b.iT;
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject3 = new ArrayList();
        int i = localList.size();
        localObject2 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).ahj;
        int j;
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
        {
          localObject1 = ((String)localObject2).substring(1);
          localStringBuilder.append((String)localObject1);
          j = localStringBuilder.length();
          i -= 2;
          if (i < 0) {
            break label545;
          }
          localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
          l = localBiuCommentInfo.i.longValue();
          localObject1 = ReadInJoyUserInfoModule.a(l, null);
          if (localObject1 == null) {
            break label527;
          }
          localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
          label372:
          localObject2 = "@" + (String)localObject1;
          localObject1 = localObject2;
          if (localBiuCommentInfo.aSO == 1) {
            localObject1 = (String)localObject2 + " ";
          }
          if (localBiuCommentInfo.ahj != null) {
            break label535;
          }
        }
        for (localObject2 = "";; localObject2 = localBiuCommentInfo.ahj)
        {
          localStringBuilder.append((String)localObject1).append((String)localObject2);
          localObject2 = new ComponentHeaderNewSocial.c();
          ((ComponentHeaderNewSocial.c)localObject2).ahi = j;
          ((ComponentHeaderNewSocial.c)localObject2).adh = (((String)localObject1).length() + j);
          ((ComponentHeaderNewSocial.c)localObject2).uin = l;
          ((List)localObject3).add(localObject2);
          j = localStringBuilder.length();
          i -= 1;
          break label325;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = "";
          break;
          localObject1 = ReadInJoyUserInfoModule.getDefaultNickName();
          break label372;
        }
        localObject1 = new SpannableStringBuilder(new aofk(localStringBuilder, 7, 16));
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ComponentHeaderNewSocial.c)((Iterator)localObject2).next();
          ((SpannableStringBuilder)localObject1).setSpan(new b(((ComponentHeaderNewSocial.c)localObject3).uin, -3355444), ((ComponentHeaderNewSocial.c)localObject3).ahi, ((ComponentHeaderNewSocial.c)localObject3).adh, 17);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_c_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
        }
      }
      else if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new aofk(anbk.nn((String)localObject2), 7, 16);
        this.jdField_c_of_type_AndroidTextSpannableStringBuilder.append((CharSequence)localObject1);
      }
    }
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      paramObject = ((lie)paramObject).a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null)) {
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcOriginalHeader", 2, "article info is null");
      }
    }
    label66:
    do
    {
      return;
      B(paramObject);
    } while ((!ndi.W(paramObject)) || (!TextUtils.isEmpty(paramObject.businessName)));
    paramObject = (LinearLayout.LayoutParams)getLayoutParams();
    paramObject.bottomMargin = wja.dp2px(12.0F, getContext().getResources());
    setLayoutParams(paramObject);
  }
  
  public void a(lwm.a parama) {}
  
  public void init(Context paramContext)
  {
    this.a = new mas();
    setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(wja.dp2px(12.0F, paramContext.getResources()), wja.dp2px(12.0F, paramContext.getResources()), wja.dp2px(20.0F, paramContext.getResources()), 0);
    setLayoutParams(localLayoutParams);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView = new ReadInJoyYAFolderTextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setLayoutParams(paramContext);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setIncludeFontPadding(false);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#606060"));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setTextSize(2, 16.0F);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView.setMoreSpan(new mbw(this));
    addView(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyYAFolderTextView);
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
      kxm.a(ComponentContentUgcOriginalHeader.this.getContext(), this.articleInfo, 2, false, 6, false);
      ndi.g(this.articleInfo, ComponentContentUgcOriginalHeader.this.a.a.nh());
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
      for (int i = this.bgColor;; i = Color.parseColor("#F8F8F8"))
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setTextSize(wja.a(2, 14, ComponentContentUgcOriginalHeader.this.getResources()));
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
    protected long mUin;
    
    public b(long paramLong, int paramInt)
    {
      this.mUin = paramLong;
      this.bgColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      paramView = kwt.acF + aqgo.encodeToString(String.valueOf(this.mUin).getBytes(), 2);
      kxm.aJ(ComponentContentUgcOriginalHeader.this.getContext(), paramView);
      ArticleInfo localArticleInfo = ComponentContentUgcOriginalHeader.this.a.a.a();
      kxm.c = localArticleInfo;
      String str = kxm.a("2", localArticleInfo, this.mUin);
      if (odv.aT(ComponentContentUgcOriginalHeader.this.a.a.nh())) {}
      for (paramView = "0X800935C";; paramView = "0X8007BA3")
      {
        kbp.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.a.cuin), paramView, paramView, 0, 0, String.valueOf(ComponentContentUgcOriginalHeader.this.a.a.a().mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
        ndi.g(ComponentContentUgcOriginalHeader.this.a.a.a(), ComponentContentUgcOriginalHeader.this.a.a.nh());
        return;
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
      this.mPaint.setColor(Color.parseColor("#285c95"));
      paramTextPaint = this.mPaint;
      if (this.mIsPressed) {}
      for (int i = this.bgColor;; i = Color.parseColor("#F8F8F8"))
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setUnderlineText(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader
 * JD-Core Version:    0.7.0.1
 */