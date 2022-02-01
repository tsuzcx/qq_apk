package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgo;
import aqnm;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kwt;
import kxl;
import kxm;
import lbz;
import lie;
import ljc;
import mas;
import mbx;
import mby;
import mde;
import mqq.app.AppRuntime;
import ndi;
import odv;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import wja;

public class ComponentHeaderFriendRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  ReadInJoyHeadImageView[] a;
  RingAvatarView b;
  public Button bR;
  LinearLayout dU;
  LinearLayout dV;
  ReadInJoyNickNameTextView i;
  private List<Long> iD;
  ImageView jo;
  ImageView jp;
  TextView qx;
  TextView qy;
  
  public ComponentHeaderFriendRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderFriendRecommend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean Dk()
  {
    if (this.jdField_a_of_type_Mas.a.a() == null) {
      return false;
    }
    return mas.F(this.jdField_a_of_type_Mas.a.a());
  }
  
  private void aNl()
  {
    if (this.jdField_a_of_type_Mas.CV())
    {
      this.qx.setVisibility(8);
      this.qy.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Mas.Dd()) || (Dk()))
    {
      this.qx.setVisibility(0);
      this.qx.setText(i(this.jdField_a_of_type_Mas.a.a()));
      Object localObject = this.jdField_a_of_type_Mas.a.a().mSocialFeedInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((SocializeFeedsInfo)localObject).ahO)))
      {
        this.qy.setText(((SocializeFeedsInfo)localObject).ahO);
        return;
      }
      localObject = m(this.jdField_a_of_type_Mas.a.a());
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.qy.setVisibility(8);
        return;
      }
      this.qy.setVisibility(0);
      this.qy.setText((CharSequence)localObject);
      return;
    }
    this.qx.setVisibility(0);
    this.qy.setVisibility(8);
    this.qx.setText(i(this.jdField_a_of_type_Mas.a.a()));
  }
  
  private List<Long> aX()
  {
    Object localObject = this.jdField_a_of_type_Mas.a.a();
    ArrayList localArrayList1 = new ArrayList();
    if (localObject == null) {
      return localArrayList1;
    }
    if (this.jdField_a_of_type_Mas.CV())
    {
      localObject = new ArrayList(1);
      try
      {
        ((List)localObject).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Mas.a.a().mSubscribeID)));
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return localObject;
      }
    }
    ArrayList localArrayList2;
    if ((this.jdField_a_of_type_Mas.Dd()) || (Dk()))
    {
      localArrayList2 = new ArrayList(1);
      localArrayList2.add(Long.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin));
      return localArrayList2;
    }
    if ((((ArticleInfo)localObject).mPackInfoObj != null) && (((ArticleInfo)localObject).mPackInfoObj.has())) {}
    try
    {
      localArrayList2.addAll(((articlesummary.FriendRecommendInfo)((ArticleInfo)localObject).mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList2.isEmpty()) {
        QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void cK(List<Long> paramList)
  {
    if ((paramList != null) && (paramList.size() == 1))
    {
      if ((!this.jdField_a_of_type_Mas.Dd()) && (!Dk())) {
        setOnClickListener(this);
      }
      this.i.setOnClickListener(this);
      this.i.setVisibility(0);
      if (this.jdField_a_of_type_Mas.CV())
      {
        this.i.setText(kxm.ew(this.jdField_a_of_type_Mas.a.a().mSubscribeName));
        this.jo.setVisibility(8);
        return;
      }
      this.i.setNickNameByUin(((Long)paramList.get(0)).longValue());
      if ((this.jdField_a_of_type_Mas.Dd()) || (Dk()))
      {
        if (this.jdField_a_of_type_Mas.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.type == 1)
        {
          this.jo.setVisibility(0);
          return;
        }
        this.jo.setVisibility(8);
        return;
      }
      this.jo.setVisibility(8);
      return;
    }
    setOnClickListener(null);
    this.i.setOnClickListener(null);
    this.i.setVisibility(8);
    this.jo.setVisibility(8);
  }
  
  private void eC(long paramLong)
  {
    if (this.jdField_a_of_type_Mas.CV())
    {
      String str = kwt.acJ + aqgo.encodeToString(String.valueOf(paramLong).getBytes(), 2);
      kxm.aJ(getContext(), str);
    }
    for (;;)
    {
      lO(kxm.f(this.jdField_a_of_type_Mas.a.a()));
      return;
      eD(paramLong);
    }
  }
  
  private String i(ArticleInfo paramArticleInfo)
  {
    String str;
    if ((this.jdField_a_of_type_Mas.Dd()) || (mas.F(paramArticleInfo)))
    {
      str = paramArticleInfo.mSocialFeedInfo.ahN;
      paramArticleInfo = str;
      if (TextUtils.isEmpty(str)) {
        paramArticleInfo = "";
      }
    }
    for (;;)
    {
      return paramArticleInfo;
      try
      {
        str = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
        paramArticleInfo = str;
        if (!TextUtils.isEmpty(str)) {
          continue;
        }
        QLog.w("ComponentHeaderFriendRecommend", 1, "ReadInJoyHeader friend recommend description empty");
        return str;
      }
      catch (Exception paramArticleInfo)
      {
        for (;;)
        {
          paramArticleInfo.printStackTrace();
          str = null;
        }
      }
    }
  }
  
  private void lO(String paramString)
  {
    try
    {
      JSONObject localJSONObject = kxm.v();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", kxm.nR());
      String str = kxm.g(this.jdField_a_of_type_Mas.a.a());
      if (odv.aT(this.jdField_a_of_type_Mas.a.nh())) {}
      for (paramString = "0X8009357";; paramString = "0X800744D")
      {
        kbp.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private String m(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    int j;
    do
    {
      do
      {
        return null;
      } while ((!this.jdField_a_of_type_Mas.Dd()) && (!Dk()));
      if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.ahO)) {
        return paramArticleInfo.mSocialFeedInfo.ahO;
      }
      j = paramArticleInfo.mSocialFeedInfo.aRW;
    } while (j <= 0);
    return kxl.c(j, true);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie)) {
      d((lie)paramObject);
    }
  }
  
  public void a(lie paramlie, List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int j = 0;
      while (j < Math.min(4, paramList.size()))
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[j].setHeadImgByUin(((Long)paramList.get(j)).longValue());
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[j].setVisibility(0);
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[j].setOnClickListener(new mbx(this, paramList, j));
        j += 1;
      }
      j = Math.min(4, paramList.size());
      while (j < 4)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[j].setVisibility(8);
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[j].setOnClickListener(null);
        j += 1;
      }
    }
  }
  
  public void aNf()
  {
    super.aNf();
    Object localObject = (LinearLayout.LayoutParams)this.dV.getLayoutParams();
    if ((this.jdField_a_of_type_Mas.Dd()) || (Dk()))
    {
      this.dU.setPadding(this.dU.getPaddingLeft(), wja.dp2px(15.0F, getResources()), this.dU.getPaddingRight(), wja.dp2px(12.0F, getResources()));
      this.dV.setPadding(this.dV.getPaddingLeft(), wja.dp2px(15.0F, getResources()), this.dV.getPaddingRight(), this.dV.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 48;
      this.qy.setVisibility(0);
    }
    for (;;)
    {
      localObject = (LinearLayout)findViewById(2131376685);
      if ((((LinearLayout)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        if (!Dj()) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject).setMargins(aqnm.dip2px(12.0F), 0, aqnm.dip2px(12.0F), 0);
      }
      return;
      this.dU.setPadding(this.dU.getPaddingLeft(), wja.dp2px(7.5F, getResources()), this.dU.getPaddingRight(), wja.dp2px(7.5F, getResources()));
      this.dV.setPadding(this.dV.getPaddingLeft(), wja.dp2px(7.5F, getResources()), this.dV.getPaddingRight(), this.dV.getPaddingBottom());
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.qy.setVisibility(8);
    }
    ((RelativeLayout.LayoutParams)localObject).setMargins(aqnm.dip2px(12.0F), 0, aqnm.dip2px(2.25F), 0);
  }
  
  public void b(long paramLong, Bitmap paramBitmap)
  {
    if (kxm.AI())
    {
      List localList = aX();
      if ((localList.size() > 0) && (localList.contains(Long.valueOf(paramLong))))
      {
        int j = localList.indexOf(Long.valueOf(paramLong));
        this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[j].setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.dU = ((LinearLayout)findViewById(2131376686));
    this.dV = ((LinearLayout)findViewById(2131376690));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = new ReadInJoyHeadImageView[4];
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[0] = ((ReadInJoyHeadImageView)findViewById(2131376673));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[1] = ((ReadInJoyHeadImageView)findViewById(2131376674));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[2] = ((ReadInJoyHeadImageView)findViewById(2131376675));
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView[3] = ((ReadInJoyHeadImageView)findViewById(2131376676));
    this.i = ((ReadInJoyNickNameTextView)findViewById(2131376689));
    this.jo = ((ImageView)findViewById(2131376683));
    this.qx = ((TextView)findViewById(2131376680));
    this.qy = ((TextView)findViewById(2131376688));
    this.bR = ((Button)findViewById(2131363870));
    this.bR.setOnClickListener(this);
    this.b = ((RingAvatarView)findViewById(2131376630));
    this.jp = ((ImageView)findViewById(2131369908));
  }
  
  public void d(lie paramlie)
  {
    if (isShow()) {}
    for (int j = 0;; j = 8)
    {
      setVisibility(j);
      if (isShow())
      {
        this.iD = aX();
        a(paramlie, this.iD);
        cK(this.iD);
        mde.a(this.jdField_a_of_type_Mas.a, this.b, this.jp);
        aNl();
        setFollowBotton();
      }
      return;
    }
  }
  
  public void eD(long paramLong)
  {
    String str1 = kwt.acF + aqgo.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    kxm.aJ(getContext(), str1);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    kxm.c = localArticleInfo;
    String str2 = kxm.a("1", localArticleInfo, paramLong);
    if (odv.aT(this.jdField_a_of_type_Mas.a.nh())) {}
    for (str1 = "0X800935C"; mas.F(localArticleInfo); str1 = "0X8007BA3")
    {
      kbp.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_Mas.a.a().mFeedId), "0", "" + localArticleInfo.mStrategyId, str2, false);
      ndi.g(this.jdField_a_of_type_Mas.a.a(), this.jdField_a_of_type_Mas.a.nh());
      return;
    }
    kbp.a(null, localArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_Mas.a.a().mFeedId), String.valueOf(this.jdField_a_of_type_Mas.a.a().mArticleID), "" + localArticleInfo.mStrategyId, str2, false);
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560315, this, true);
  }
  
  public boolean isShow()
  {
    lie locallie = this.jdField_a_of_type_Mas.a;
    return (locallie.isShowHeader()) && ((locallie.oF() == 2) || (locallie.oF() == 3));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this)
      {
        localObject = aX();
        if ((localObject != null) && (((List)localObject).size() == 1)) {
          eC(((Long)((List)localObject).get(0)).longValue());
        }
      }
    case 2131376689: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = aX();
        if ((localObject != null) && (((List)localObject).size() == 1)) {
          eC(((Long)((List)localObject).get(0)).longValue());
        }
      }
    }
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    ArticleInfo localArticleInfo;
    if (localAppRuntime != null)
    {
      localArticleInfo = this.jdField_a_of_type_Mas.a.a();
      if (!odv.aT(this.jdField_a_of_type_Mas.a.nh())) {
        break label263;
      }
    }
    label263:
    for (Object localObject = "0X800941D";; localObject = "0X80080EC")
    {
      ndi.b(localArticleInfo, (String)localObject, (String)localObject, this.jdField_a_of_type_Mas.a.nh());
      lbz.k(localArticleInfo);
      if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null))
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
        lbz.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, new mby(this, localArticleInfo));
      }
      aNa();
      break;
    }
  }
  
  public void setFollowBotton()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    if (localArticleInfo == null) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend
 * JD-Core Version:    0.7.0.1
 */