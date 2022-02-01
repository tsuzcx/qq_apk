package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import amxk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqbn;
import aqcx;
import aqgo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kbp;
import kwt;
import kxl;
import kxm;
import lbz;
import lcc;
import lce;
import lie;
import lis;
import ljc;
import lwm.a;
import mas;
import mca;
import mcb;
import mcc;
import mcd;
import mce;
import mhs;
import mqq.app.AppRuntime;
import ndi;
import odv;
import org.json.JSONObject;
import wja;

public class ComponentHeaderPolymeric
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private boolean alT = true;
  protected lce g = new mce(this);
  private ReadInJoyNickNameTextView j;
  private ImageView jr;
  private View kK;
  private ReadInJoyHeadImageView l;
  private View mRootView;
  private LinearLayout mTitleLayout;
  private TextView mTitleText;
  private TextView qA;
  private TextView qB;
  private long uO;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followUGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.followStatus + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    ljc localljc = lbz.a().a();
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramArticleInfo.mPolymericInfo.followStatus != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localljc.a(paramAppRuntime, paramString, bool, new mca(this, paramArticleInfo), 2);
      return;
    }
  }
  
  private void b(AppRuntime paramAppRuntime, String paramString, ArticleInfo paramArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount followUin = " + paramString + ", followStatus = " + paramArticleInfo.mPolymericInfo.followStatus + ", articleInfoID = " + paramArticleInfo.mArticleID);
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramArticleInfo.mPolymericInfo.followStatus != 1) {
        break label122;
      }
      lbz.a().a().a(paramAppRuntime.getAccount(), paramString, true, new mcb(this, paramArticleInfo), 1);
    }
    label122:
    while (paramArticleInfo.mPolymericInfo.followStatus != 2)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ComponentHeaderPolymeric", 2, "followPGCAccount fail, appInterface is null!");
      return;
    }
    lbz.a().a().a(paramAppRuntime.getAccount(), paramString, false, new mcc(this, paramArticleInfo), 1);
  }
  
  private void f(ArticleInfo paramArticleInfo, int paramInt)
  {
    paramArticleInfo.mPolymericInfo.followStatus = paramInt;
    Object localObject = ((BaseArticleInfo)paramArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).mFollowStatus = paramInt;
    }
    localObject = lcc.a();
    long l1 = paramArticleInfo.mPolymericInfo.uin;
    if (paramArticleInfo.mPolymericInfo.followStatus == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((lcc)localObject).W(l1, bool);
      ThreadManager.post(new ComponentHeaderPolymeric.5(this, paramArticleInfo, paramInt), 5, null, true);
      return;
    }
  }
  
  private void h(BaseArticleInfo paramBaseArticleInfo)
  {
    kbp.a(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", kxm.a(paramBaseArticleInfo.mPolymericInfo).toString(), false);
    if (kxm.s(paramBaseArticleInfo))
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0);
      String str1 = odv.a(getContext(), localBaseArticleInfo.mArticleID, localBaseArticleInfo.mAlgorithmID, 54, this.b.nh(), localBaseArticleInfo.getInnerUniqueID(), localBaseArticleInfo.getVideoVid(), odv.l(localBaseArticleInfo), localBaseArticleInfo.videoReportInfo);
      String str2 = odv.aB(paramBaseArticleInfo.mChannelID);
      kbp.a(null, "CliOper", "", String.valueOf(paramBaseArticleInfo.mPolymericInfo.uin), str2, str2, 0, 0, Long.toString(localBaseArticleInfo.mFeedId), String.valueOf(localBaseArticleInfo.mArticleID), Integer.toString(localBaseArticleInfo.mStrategyId), str1, false);
      return;
    }
    ndi.g((ArticleInfo)paramBaseArticleInfo, this.b.nh());
  }
  
  private void nJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.qB.setBackgroundResource(2130850192);
      this.qB.setTextColor(-2147483648);
      this.qB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.qB.setBackgroundResource(2130850191);
    this.qB.setTextColor(-1);
    this.qB.setCompoundDrawablePadding(wja.dp2px(3.0F, getResources()));
    this.qB.setCompoundDrawablesWithIntrinsicBounds(2130850189, 0, 0, 0);
  }
  
  private void ry(int paramInt)
  {
    if (paramInt == 1) {
      nJ(false);
    }
    while (paramInt != 2) {
      return;
    }
    nJ(true);
  }
  
  public boolean Dj()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null) && ((this.jdField_a_of_type_Mas.a instanceof lis)))
    {
      lis locallis = (lis)this.jdField_a_of_type_Mas.a;
      int i = localArticleInfo.mPolymericInfo.aRX;
      if (((i == 9) || (i == 10) || (i == 11)) && (locallis.mChannelID == 56)) {
        return true;
      }
      if (i == 10) {
        return true;
      }
    }
    return super.Dj();
  }
  
  public void P(Object paramObject)
  {
    int k = 1;
    int i = 1;
    super.P(paramObject);
    ArticleInfo localArticleInfo = ((lie)paramObject).a();
    Object localObject1;
    Object localObject2;
    if ((localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null))
    {
      localObject1 = "";
      if (localArticleInfo.mPolymericInfo.vp > 0L) {
        localObject1 = kxl.c(localArticleInfo.mPolymericInfo.vp, true);
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(localArticleInfo.mPolymericInfo.desc)) {
        localObject2 = (String)localObject1 + " " + localArticleInfo.mPolymericInfo.desc;
      }
      if (localArticleInfo.mPolymericInfo.aRX != 10) {
        break label421;
      }
      this.kK.setVisibility(8);
      this.mTitleText.setVisibility(8);
      this.mTitleLayout.setVisibility(8);
      this.l.setVisibility(8);
      switch (localArticleInfo.mPolymericInfo.aRX)
      {
      case 7: 
      case 8: 
      default: 
        this.j.setText(localArticleInfo.mPolymericInfo.title);
        this.qA.setText((CharSequence)localObject2);
        this.uO = 0L;
        if (!TextUtils.isEmpty(localArticleInfo.mPolymericInfo.iconUrl))
        {
          this.l.setImage(kxm.b(localArticleInfo.mPolymericInfo.iconUrl));
          localObject1 = this.l;
          if (localArticleInfo.mPolymericInfo.aSf != 0) {
            break label950;
          }
        }
        break;
      }
    }
    label421:
    label950:
    for (boolean bool = true;; bool = false)
    {
      ((ReadInJoyHeadImageView)localObject1).setRound(bool);
      for (;;)
      {
        if ((localArticleInfo != null) && (localArticleInfo.mGroupSubArticleList != null) && (!localArticleInfo.mGroupSubArticleList.isEmpty()) && (localArticleInfo.mPolymericInfo != null) && ((localArticleInfo.mPolymericInfo.followStatus == 2) || (localArticleInfo.mPolymericInfo.followStatus == 1))) {
          break label956;
        }
        this.qB.setVisibility(8);
        if ((QLog.isColorLevel()) && (localArticleInfo != null) && (localArticleInfo.mPolymericInfo != null)) {
          QLog.d("ComponentHeaderPolymeric", 2, "articleInfo.mPolymericInfo = " + localArticleInfo.mPolymericInfo.toString());
        }
        return;
        this.mTitleText.setVisibility(8);
        this.mTitleLayout.setVisibility(0);
        this.l.setVisibility(0);
        break;
        this.j.setText(localArticleInfo.mPolymericInfo.title);
        this.qA.setText((CharSequence)localObject2);
        this.uO = localArticleInfo.mPolymericInfo.uin;
        this.l.setImageDrawable(amxk.b(this.jdField_a_of_type_Aqdf, String.valueOf(this.uO), 1));
        continue;
        localObject2 = localArticleInfo.mPolymericInfo.title;
        if (((String)localObject2).startsWith("#"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("# ")) {
            localObject1 = "# " + ((String)localObject2).substring(1);
          }
          localObject1 = new SpannableString((CharSequence)localObject1);
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131167145)), 0, 1, 33);
          ((SpannableString)localObject1).setSpan(new ImageSpan(getContext(), 2130843744), 1, 2, 33);
          this.j.setText((CharSequence)localObject1);
        }
        for (;;)
        {
          this.qA.setText(localArticleInfo.mPolymericInfo.desc);
          this.uO = 0L;
          if (TextUtils.isEmpty(localArticleInfo.mPolymericInfo.iconUrl)) {
            break;
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject2 = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
          localObject1 = URLDrawable.getDrawable(kxm.b(localArticleInfo.mPolymericInfo.iconUrl), (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setTag(aqbn.d(72, 72, aqcx.dip2px(this.l.getContext(), 2.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(aqbn.a);
          this.l.setImageDrawable((Drawable)localObject1);
          break;
          this.j.setText(localArticleInfo.mPolymericInfo.title);
        }
        this.mTitleText.setText(localArticleInfo.mPolymericInfo.desc);
        continue;
        this.qA.setText(localArticleInfo.mPolymericInfo.desc);
        this.uO = localArticleInfo.mPolymericInfo.uin;
        if ((localArticleInfo.mGroupSubArticleList != null) && (localArticleInfo.mGroupSubArticleList.size() > 0))
        {
          localObject1 = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
          if (((localObject1 instanceof ArticleInfo)) && (ndi.Y((ArticleInfo)localObject1)))
          {
            this.j.setText(localArticleInfo.mPolymericInfo.title);
            this.l.setImageDrawable(amxk.b(this.jdField_a_of_type_Aqdf, String.valueOf(this.uO), 1));
          }
          else
          {
            this.l.setHeadImgByUin(this.uO);
            this.j.setNickNameByUin(this.uO);
          }
        }
      }
    }
    label956:
    this.alT = true;
    if (localArticleInfo.mPolymericInfo.aRX == 11)
    {
      if (localArticleInfo.mPolymericInfo.followStatus == 2) {}
      for (i = 1;; i = 0)
      {
        this.qB.setTag(String.valueOf(localArticleInfo.mPolymericInfo.uin));
        localObject1 = ((BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
        if ((localObject1 != null) && (((SocializeFeedsInfo)localObject1).a != null)) {
          break;
        }
        this.qB.setVisibility(8);
        return;
      }
      if (((SocializeFeedsInfo)localObject1).a != null) {
        if (((SocializeFeedsInfo)localObject1).a.type == 1)
        {
          this.jr.setVisibility(0);
          if (i != 0) {
            break label1256;
          }
          this.qB.setVisibility(0);
          nJ(false);
          label1098:
          localObject1 = (LinearLayout.LayoutParams)this.qB.getLayoutParams();
          if (!Dj()) {
            break label1268;
          }
        }
      }
    }
    label1256:
    label1268:
    for (((LinearLayout.LayoutParams)localObject1).rightMargin = aqcx.dip2px(getContext(), 12.0F);; ((LinearLayout.LayoutParams)localObject1).rightMargin = aqcx.dip2px(getContext(), 0.0F))
    {
      this.qB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!(paramObject instanceof lis)) {
        break label1294;
      }
      if ((((lis)paramObject).nh() != 56) || (((lis)paramObject).mPosition == 0)) {
        break label1284;
      }
      this.kK.setVisibility(0);
      return;
      this.jr.setVisibility(8);
      break;
      this.jr.setVisibility(8);
      break;
      if (localArticleInfo.mPolymericInfo.aRX != 9) {
        break;
      }
      if (localArticleInfo.mPolymericInfo.followStatus == 2) {}
      for (i = k;; i = 0)
      {
        this.qB.setTag(String.valueOf(localArticleInfo.mPolymericInfo.vr));
        break;
      }
      this.qB.setVisibility(8);
      break label1098;
    }
    label1284:
    this.kK.setVisibility(8);
    return;
    label1294:
    this.kK.setVisibility(8);
  }
  
  public void a(lwm.a parama)
  {
    super.a(parama);
  }
  
  public void aHq()
  {
    super.aHq();
  }
  
  protected void aOc()
  {
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    ArticleInfo localArticleInfo;
    String str;
    if (localAppRuntime != null)
    {
      this.alT = false;
      localArticleInfo = this.jdField_a_of_type_Mas.a.a();
      if (!odv.aT(this.jdField_a_of_type_Mas.a.nh())) {
        break label157;
      }
      str = "0X800941D";
      ndi.b(localArticleInfo, str, str, this.jdField_a_of_type_Mas.a.nh());
      lbz.k(localArticleInfo);
      str = String.valueOf(localArticleInfo.mPolymericInfo.uin);
      if ((localArticleInfo.mGroupSubArticleList == null) || (localArticleInfo.mGroupSubArticleList.size() <= 0)) {
        break label173;
      }
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localArticleInfo.mGroupSubArticleList.get(0);
      if ((!(localBaseArticleInfo instanceof ArticleInfo)) || (!ndi.Y((ArticleInfo)localBaseArticleInfo))) {
        break label173;
      }
    }
    label157:
    label173:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        a(localAppRuntime, str, localArticleInfo);
        return;
        str = "0X80080EC";
        break;
      }
      b(localAppRuntime, str, localArticleInfo);
      return;
    }
  }
  
  protected void aOd()
  {
    boolean bool = false;
    Object localObject = kxm.getAppRuntime();
    ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Mas.a.a().mGroupSubArticleList.get(0);
    localObject = ((AppRuntime)localObject).getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPGCAccount topicID = " + localArticleInfo.mPolymericInfo.vr + ", followStatus = " + localArticleInfo.mPolymericInfo.followStatus + ", articleInfoID = " + localArticleInfo.mArticleID);
    }
    ljc localljc = lbz.a().a();
    String str = Long.toString(localArticleInfo.mPolymericInfo.vr);
    if (localArticleInfo.mPolymericInfo.followStatus != 2) {
      bool = true;
    }
    localljc.a((String)localObject, str, bool, new mcd(this, localArticleInfo), 3);
  }
  
  public void b(long paramLong, Bitmap paramBitmap)
  {
    if (this.uO != paramLong) {
      return;
    }
    this.l.setImageBitmap(paramBitmap);
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.kK = paramView.findViewById(2131380010);
    this.j = ((ReadInJoyNickNameTextView)paramView.findViewById(2131376687));
    this.qA = ((TextView)paramView.findViewById(2131376679));
    this.l = ((ReadInJoyHeadImageView)paramView.findViewById(2131376682));
    this.mTitleLayout = ((LinearLayout)paramView.findViewById(2131376690));
    this.mTitleText = ((TextView)paramView.findViewById(2131376691));
    this.qB = ((TextView)paramView.findViewById(2131376681));
    this.jr = ((ImageView)findViewById(2131376683));
    this.mRootView = paramView.findViewById(2131377546);
    this.mRootView.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.qB.setOnClickListener(this);
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560318, this, true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    lcc.a().b(this.g);
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (localArticleInfo.mPolymericInfo.aRX)
      {
      }
      for (;;)
      {
        h(localArticleInfo);
        break;
        String str = kwt.acF + aqgo.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.uin).getBytes(), 2);
        kxm.aJ(getContext(), str);
        continue;
        str = kwt.acJ + aqgo.encodeToString(String.valueOf(localArticleInfo.mPolymericInfo.uin).getBytes(), 2);
        kxm.aJ(getContext(), str);
        continue;
        kxm.aJ(getContext(), localArticleInfo.mPolymericInfo.jumpUrl);
      }
      if ((localArticleInfo.mPolymericInfo.followStatus == 2) || (localArticleInfo.mPolymericInfo.followStatus == 1)) {
        if (!this.alT)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ComponentHeaderPolymeric", 2, "click when the button is disabled");
          }
        }
        else if (localArticleInfo.mPolymericInfo.aRX == 11) {
          aOc();
        } else if (localArticleInfo.mPolymericInfo.aRX == 9) {
          aOd();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    lcc.a().c(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */