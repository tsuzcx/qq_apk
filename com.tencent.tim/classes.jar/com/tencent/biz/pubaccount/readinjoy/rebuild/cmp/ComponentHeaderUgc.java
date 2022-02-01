package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import anbk;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;
import aofk;
import aqgo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.b;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kbp;
import kwt;
import kxl;
import kxm;
import lbz;
import lcc;
import lce;
import lie;
import ljc;
import mas;
import mcl;
import mcm;
import mcn;
import mco;
import mde;
import mqq.app.AppRuntime;
import ndi;
import odv;

public class ComponentHeaderUgc
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  public boolean akP;
  RingAvatarView b;
  public Button bR;
  public ReadInJoyYAFolderTextView e;
  protected lce g = new mco(this);
  private ReadInJoyHeadImageView j;
  ImageView jp;
  private ImageView js;
  public ReadInJoyNickNameTextView k;
  private Context mContext;
  private TextView qy;
  
  public ComponentHeaderUgc(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public ComponentHeaderUgc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void aNl()
  {
    ArticleInfo localArticleInfo;
    if ((this.a.a != null) && (this.a.a.a() != null) && (this.a.a.a().mSocialFeedInfo != null))
    {
      localArticleInfo = this.a.a.a();
      this.e.setMaxLines(7);
      this.e.setMoreSpan(new mcl(this, localArticleInfo));
      if (!kxm.l(localArticleInfo)) {
        break label130;
      }
      this.e.setVisibility(8);
      if (TextUtils.isEmpty(localArticleInfo.mSocialFeedInfo.ahO)) {
        break label807;
      }
      this.qy.setText(localArticleInfo.mSocialFeedInfo.ahO);
    }
    label130:
    label320:
    label365:
    while (localArticleInfo.mTime <= 0L)
    {
      return;
      if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null)
      {
        Object localObject2 = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r;
        if ((mas.H(localArticleInfo)) && (!ndi.aa(localArticleInfo)))
        {
          this.e.setText(((SocializeFeedsInfo.t)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title);
          break;
        }
        Object localObject1;
        if (kxm.a((SocializeFeedsInfo.r)localObject2))
        {
          List localList = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT;
          StringBuilder localStringBuilder = new StringBuilder();
          Object localObject3 = new ArrayList();
          int i = localList.size();
          localObject2 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).ahj;
          int m;
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
          long l;
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
          {
            localObject1 = ((String)localObject2).substring(1);
            localStringBuilder.append((String)localObject1);
            m = localStringBuilder.length();
            i -= 2;
            if (i < 0) {
              break label537;
            }
            localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
            l = localBiuCommentInfo.i.longValue();
            localObject1 = ReadInJoyUserInfoModule.a(l, null);
            if (localObject1 == null) {
              break label519;
            }
            localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
            localObject2 = "@" + (String)localObject1;
            localObject1 = localObject2;
            if (localBiuCommentInfo.aSO == 1) {
              localObject1 = (String)localObject2 + " ";
            }
            if (localBiuCommentInfo.ahj != null) {
              break label527;
            }
          }
          for (localObject2 = "";; localObject2 = localBiuCommentInfo.ahj)
          {
            localStringBuilder.append((String)localObject1).append((String)localObject2);
            localObject2 = new ComponentHeaderNewSocial.c();
            ((ComponentHeaderNewSocial.c)localObject2).ahi = m;
            ((ComponentHeaderNewSocial.c)localObject2).adh = (((String)localObject1).length() + m);
            ((ComponentHeaderNewSocial.c)localObject2).uin = l;
            ((List)localObject3).add(localObject2);
            m = localStringBuilder.length();
            i -= 1;
            break label320;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            localObject1 = "";
            break;
            localObject1 = ReadInJoyUserInfoModule.getDefaultNickName();
            break label365;
          }
          localObject1 = new SpannableStringBuilder(new aofk(localStringBuilder, 7, 16));
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ComponentHeaderNewSocial.c)((Iterator)localObject2).next();
            ((SpannableStringBuilder)localObject1).setSpan(new a(((ComponentHeaderNewSocial.c)localObject3).uin, -3355444), ((ComponentHeaderNewSocial.c)localObject3).ahi, ((ComponentHeaderNewSocial.c)localObject3).adh, 17);
          }
          if (localArticleInfo.mSocialFeedInfo.aSL == 1) {}
          for (i = 1;; i = 0)
          {
            if ((!this.akP) || (i != 0)) {
              break label703;
            }
            ((SpannableStringBuilder)localObject1).append(" ");
            new mcm(this, localArticleInfo);
            ((SpannableStringBuilder)localObject1).append(" ");
            this.e.ask = true;
            this.e.setText((CharSequence)localObject1);
            break;
          }
          this.e.setText((CharSequence)localObject1);
          break;
        }
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.r)localObject2).ail))
        {
          localObject1 = null;
          try
          {
            localObject2 = anbk.nn(((SocializeFeedsInfo.r)localObject2).ail);
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("ComponentHeaderUgc", 1, "parse bytes_comments failed ", localException);
            }
          }
          this.e.setText(new aofk((CharSequence)localObject1, 7, 16));
          break;
        }
        this.e.setVisibility(8);
        break;
      }
      this.e.setVisibility(8);
      break;
    }
    label519:
    label527:
    label537:
    label703:
    this.qy.setText(kxl.c(localArticleInfo.mSocialFeedInfo.aRW, true));
    label807:
  }
  
  private void eD(long paramLong)
  {
    if ((this.a.a == null) || (this.a.a.a() == null) || (this.a.a.a().mSocialFeedInfo == null) || (this.a.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null)) {
      return;
    }
    String str1 = kwt.acF + aqgo.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    kxm.aJ(getContext(), str1);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderUgc", 2, "personal url =" + str1);
    }
    ArticleInfo localArticleInfo = this.a.a.a();
    kxm.c = localArticleInfo;
    String str2 = kxm.a("3", localArticleInfo, paramLong);
    if (odv.aT(this.a.a.nh())) {}
    for (str1 = "0X800935C";; str1 = "0X8007BA3")
    {
      kbp.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin), str1, str1, 0, 0, String.valueOf(this.a.a.a().mFeedId), "0", "" + localArticleInfo.mStrategyId, str2, false);
      ndi.g(localArticleInfo, this.a.a.nh());
      return;
    }
  }
  
  private void eE(long paramLong)
  {
    if ((this.a.a != null) && (this.a.a.a() != null))
    {
      this.k.setNickNameByUin(paramLong, true);
      this.k.setOnClickListener(this);
    }
  }
  
  private void setAvatar(long paramLong)
  {
    this.j.setHeadImgByUin(paramLong);
    this.j.setOnClickListener(this);
    ArticleInfo localArticleInfo = this.a.a.a();
    if (localArticleInfo == null) {
      this.js.setVisibility(8);
    }
    while ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null)) {
      return;
    }
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.type == 1)
    {
      this.js.setVisibility(0);
      return;
    }
    this.js.setVisibility(8);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie)) {
      d((lie)paramObject);
    }
  }
  
  public void c(long paramLong, Bitmap paramBitmap)
  {
    if ((kxm.AI()) && (this.a.cG() == paramLong)) {
      this.j.setImageBitmap(paramBitmap);
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.j = ((ReadInJoyHeadImageView)findViewById(2131363175));
    this.k = ((ReadInJoyNickNameTextView)findViewById(2131372384));
    this.k.getPaint().setFakeBoldText(true);
    this.qy = ((TextView)findViewById(2131379661));
    this.e = ((ReadInJoyYAFolderTextView)findViewById(2131365748));
    this.bR = ((Button)findViewById(2131363870));
    this.js = ((ImageView)findViewById(2131376683));
    this.bR.setOnClickListener(this);
    this.b = ((RingAvatarView)findViewById(2131376630));
    this.jp = ((ImageView)findViewById(2131369908));
  }
  
  public void d(lie paramlie)
  {
    long l = this.a.cG();
    setAvatar(l);
    eE(l);
    mde.a(this.a.a, this.b, this.jp);
    aNl();
    setFollowButton();
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560322, this, true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    lcc.a().b(this.g);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363175: 
    case 2131372384: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        eD(this.a.cG());
      }
    }
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    ArticleInfo localArticleInfo;
    if (localAppRuntime != null)
    {
      localArticleInfo = this.a.a.a();
      if (localArticleInfo != null) {
        if (!odv.aT(localArticleInfo.mChannelID)) {
          break label183;
        }
      }
    }
    label183:
    for (String str = "0X800941D";; str = "0X80080EC")
    {
      ndi.b(localArticleInfo, str, str, (int)localArticleInfo.mChannelID);
      lbz.k(localArticleInfo);
      if (localArticleInfo.mSocialFeedInfo != null)
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
        lbz.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, new mcn(this, localArticleInfo));
      }
      aNa();
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    lcc.a().c(this.g);
  }
  
  public void setFollowButton()
  {
    ArticleInfo localArticleInfo = this.a.a.a();
    if (localArticleInfo == null)
    {
      this.bR.setVisibility(8);
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo == null)
    {
      this.bR.setVisibility(8);
      return;
    }
    if (localSocializeFeedsInfo.mFollowStatus == 1)
    {
      this.bR.setVisibility(0);
      this.bR.setEnabled(true);
      this.bR.getPaint().setFakeBoldText(true);
      return;
    }
    if ((localArticleInfo.isNeedShowBtnWhenFollowed) && (localSocializeFeedsInfo.mFollowStatus == 2))
    {
      this.bR.setVisibility(0);
      this.bR.getPaint().setFakeBoldText(false);
      this.bR.setEnabled(false);
      return;
    }
    this.bR.setVisibility(8);
  }
  
  public class a
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    private int bgColor = -1;
    boolean mIsPressed;
    private TextPaint mPaint;
    protected long mUin;
    
    public a(long paramLong, int paramInt)
    {
      this.mUin = paramLong;
      this.bgColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      ComponentHeaderUgc.a(ComponentHeaderUgc.this, this.mUin);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc
 * JD-Core Version:    0.7.0.1
 */