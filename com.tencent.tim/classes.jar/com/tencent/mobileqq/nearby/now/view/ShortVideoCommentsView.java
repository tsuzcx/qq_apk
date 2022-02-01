package com.tencent.mobileqq.nearby.now.view;

import acfp;
import ajpj;
import ajwo.a;
import ajxs;
import ajxv;
import ajxw;
import ajxz;
import ajyf;
import ajyg;
import ajyh;
import ajyi;
import ajyj;
import ajyk;
import ajyl;
import ajym;
import ajyn;
import ajyo;
import ajyp;
import ajyq;
import ajyr;
import ajys;
import ajyt;
import ajyu;
import ajyv;
import ajyw;
import ajyx;
import ajyy;
import ajyz;
import ajza;
import ajzq;
import ajzr;
import ajzv;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqep;
import aqep.a;
import aqha;
import aqju;
import aqmw;
import aqnm;
import ausj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jll;
import mqq.os.MqqHandler;

public class ShortVideoCommentsView
  extends LinearLayout
  implements ajxz, View.OnLayoutChangeListener
{
  private static int dlH;
  public ImageView Bs;
  private View EW;
  private View EX;
  private View EY;
  public View EZ;
  private View Fa;
  private TextView Vi;
  private TextView Vj;
  private TextView Vk;
  private TextView Vl;
  private TextView Vm;
  private TextView Vn;
  private TextView Vo;
  private TextView Vp;
  private boolean Yp;
  private ajwo.a jdField_a_of_type_Ajwo$a = new ajyr(this);
  private ajzq jdField_a_of_type_Ajzq;
  private ajzv jdField_a_of_type_Ajzv;
  public Comments a;
  private BottomAreaRunnable jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable;
  private FocusInputRunnable jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable;
  private HorizontalBallLoadingView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView;
  private TopicLabelListView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView;
  private int aaf;
  public QQAppInterface app;
  private int ayj;
  private ajxw jdField_b_of_type_Ajxw;
  private Comments.Comment jdField_b_of_type_ComTencentMobileqqNearbyNowModelComments$Comment;
  private MedalInfo jdField_b_of_type_ComTencentMobileqqNearbyNowModelMedalInfo;
  private VideoData jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private VideoPlayerPagerAdapter.a jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a;
  private FrameLayout bM;
  private String bSR = "";
  private EditText bl;
  private LinearLayout cX;
  private boolean cqJ;
  private boolean cqK;
  private boolean cqL;
  private boolean cqM;
  private boolean cqN;
  private boolean cqO;
  private boolean cqP;
  private View ev;
  private boolean isEnd;
  private boolean isKeyboardShow;
  private boolean isLoading;
  private LinearLayout jt;
  private RelativeLayout lb;
  private RelativeLayout lc;
  private int mKeyboardHeight;
  private TextView mLocationText;
  private View mRootView;
  private long mSelfUin;
  private Paint mTextPaint;
  private Map<Integer, Integer> md = new HashMap();
  private TextView py;
  private ListView r;
  
  public ShortVideoCommentsView(Context paramContext)
  {
    super(paramContext);
    dlH = (int)jll.dp2px(getContext(), 60.0F);
  }
  
  private int GG()
  {
    if ((this.r != null) && (this.r.getChildCount() > 0))
    {
      View localView = this.r.getChildAt(0);
      int i = -localView.getTop();
      this.md.put(Integer.valueOf(this.r.getFirstVisiblePosition()), Integer.valueOf(localView.getHeight()));
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= this.r.getFirstVisiblePosition()) {
          break;
        }
        k = i;
        if (this.md.get(Integer.valueOf(j)) != null) {
          k = i + ((Integer)this.md.get(Integer.valueOf(j))).intValue();
        }
        j += 1;
        i = k;
      }
    }
    int k = 0;
    return k;
  }
  
  private void Mv(boolean paramBoolean)
  {
    if (this.cqP) {}
    int i;
    do
    {
      return;
      this.cqK = paramBoolean;
      i = GG();
      if ((!this.cqN) && (this.cX != null) && (this.cX.getMeasuredHeight() > 0) && ((getContext() instanceof Activity)))
      {
        Activity localActivity = (Activity)getContext();
        int j = jll.getScreenHeight(getContext());
        if ((this.cX.getMeasuredHeight() <= j - aqnm.getStatusBarHeight(localActivity)) || (this.cX.getMeasuredHeight() - i <= j - aqnm.getStatusBarHeight(localActivity) - jll.dp2px(getContext(), 50.0F)))
        {
          this.cqN = true;
          new ajxs().h("video").i("playpage_com_exp").a().dy(this.app);
          ThreadManagerV2.excute(new ShortVideoCommentsView.28(this, (ajpj)this.app.getManager(106)), 16, null, false);
        }
      }
    } while (this.jdField_a_of_type_Ajzv == null);
    this.jdField_a_of_type_Ajzv.RI(i);
  }
  
  private void RD(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable != null) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable = new BottomAreaRunnable(paramInt);
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable);
  }
  
  private void bIN()
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelComments$Comment = null;
    this.bl.setText("");
    this.bl.clearFocus();
    if (!TextUtils.isEmpty(this.bSR)) {
      this.bl.setHint(this.bSR);
    }
    for (;;)
    {
      dAe();
      return;
      this.bl.setHint(getContext().getResources().getString(2131698605));
    }
  }
  
  private void dAf()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable != null) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable = new FocusInputRunnable(System.currentTimeMillis());
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable, 100L);
  }
  
  private void dAg()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.isEmpty()) || (this.jdField_b_of_type_Ajxw.cqI)) && (this.lb.getVisibility() == 0) && ((this.Vj.getText() == null) || (this.Vj.getText().length() == 0)))
    {
      this.ev.setVisibility(8);
      return;
    }
    this.ev.setVisibility(0);
  }
  
  private void dzY()
  {
    this.bl.addTextChangedListener(new ajyy(this));
    this.bl.setOnTouchListener(new ajyz(this));
    dzZ();
    this.jt.setOnClickListener(new ajza(this));
  }
  
  private void dzZ()
  {
    this.r.setOnScrollListener(new ajyg(this));
    this.r.setOnItemClickListener(new ajyh(this));
    this.r.setLongClickable(true);
    this.r.setOnItemLongClickListener(new ajyi(this));
  }
  
  private void h(Comments.Comment paramComment)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.size())
      {
        if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.get(i)).type != 2) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.add(i, paramComment);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.contains(paramComment)) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.add(paramComment);
        }
        this.jdField_b_of_type_Ajxw.notifyDataSetChanged();
        paramComment = this.py;
        StringBuilder localStringBuilder = new StringBuilder().append("(");
        Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
        long l = localComments.adn + 1L;
        localComments.adn = l;
        paramComment.setText(String.valueOf(l) + ")");
        if (this.jdField_a_of_type_Ajzv != null) {
          this.jdField_a_of_type_Ajzv.kn(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.adn);
        }
        bIN();
        if ((getContext() instanceof Activity))
        {
          paramComment = (Activity)getContext();
          jll.getScreenHeight(getContext());
          postDelayed(new ShortVideoCommentsView.18(this), 100L);
        }
        return;
      }
      i += 1;
    }
  }
  
  private void i(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.remove(paramComment);
    this.jdField_b_of_type_Ajxw.notifyDataSetChanged();
    paramComment = this.py;
    StringBuilder localStringBuilder = new StringBuilder().append("(");
    Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
    long l = localComments.adn - 1L;
    localComments.adn = l;
    paramComment.setText(String.valueOf(l) + ")");
    if (this.jdField_a_of_type_Ajzv != null) {
      this.jdField_a_of_type_Ajzv.kn(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.adn);
    }
  }
  
  private void j(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Ajzq.m(paramComment);
  }
  
  private void k(Comments.Comment paramComment)
  {
    String str = getResources().getString(2131698606);
    aqha.a(getContext(), 232, null, str, new ajyt(this, paramComment), new ajyu(this)).show();
  }
  
  private void loadMore()
  {
    this.isLoading = true;
    this.jdField_a_of_type_Ajzq.dAm();
  }
  
  private String mt(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("#");
      str = paramString;
    } while (i == -1);
    paramString = paramString.split("#");
    if (i > 0) {
      return paramString[0];
    }
    return "";
  }
  
  public void Ne(String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "shortVideoComments showBindPhone, tip=" + paramString + ", activity=" + localBaseActivity);
    }
    if ((!TextUtils.isEmpty(paramString)) && (localBaseActivity != null))
    {
      aqha.a(localBaseActivity, paramString, 2131721058, 2131701360, new ajyp(this, localBaseActivity), new ajyq(this)).show();
      at(this.app, "playpage_phone_exp");
    }
  }
  
  public void a(Comments paramComments, int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 4) {
      this.jdField_a_of_type_Ajzq.start();
    }
  }
  
  public void a(VideoPlayerPagerAdapter.a parama, VideoData paramVideoData)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a = parama;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.cqJ = false;
    onCreate();
    onCreateView();
    a(null, 0);
    dAc();
    dzX();
  }
  
  public void aGy()
  {
    if (this.cqL)
    {
      this.lb.setVisibility(8);
      this.lc.setVisibility(0);
    }
    for (;;)
    {
      postDelayed(new ShortVideoCommentsView.25(this), 100L);
      postDelayed(new ShortVideoCommentsView.26(this), 200L);
      return;
      this.lc.setVisibility(8);
      if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 4)) {
        this.lb.setVisibility(0);
      }
      dAg();
    }
  }
  
  public boolean arE()
  {
    return this.cqK;
  }
  
  public boolean arF()
  {
    return (this.cqK) && (this.lc.getVisibility() != 0) && (this.lb.getVisibility() != 0) && (!this.jdField_a_of_type_Ajzv.aYL) && (!this.jdField_a_of_type_Ajzv.crc);
  }
  
  public void at(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str2 = "";
    String str1 = "";
    String str4 = "";
    String str3 = "";
    localObject4 = str2;
    localObject5 = str1;
    localObject6 = str4;
    localObject7 = str3;
    localObject1 = str2;
    localObject8 = str1;
    localObject2 = str4;
    localObject3 = str3;
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData != null)
      {
        localObject1 = str2;
        localObject8 = str1;
        localObject2 = str4;
        localObject3 = str3;
        localObject6 = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.gender + "";
        localObject1 = str2;
        localObject8 = str1;
        localObject2 = localObject6;
        localObject3 = str3;
        localObject7 = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.age + "";
        localObject1 = str2;
        localObject8 = str1;
        localObject2 = localObject6;
        localObject3 = localObject7;
        localObject4 = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.ads + "";
        localObject1 = localObject4;
        localObject8 = str1;
        localObject2 = localObject6;
        localObject3 = localObject7;
        localObject5 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
      }
      localObject1 = localObject4;
      localObject8 = localObject5;
      localObject2 = localObject6;
      localObject3 = localObject7;
      anot.a(paramQQAppInterface, "dc00899", "grp_lbs", (String)localObject4, "video", paramString, 0, 0, (String)localObject5, (String)localObject6, (String)localObject7, "");
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        localObject4 = localObject1;
        localObject5 = localObject8;
        localObject6 = localObject2;
        localObject7 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("nearby.bindphone", 2, "reportBindPhoneAction: exp=" + paramQQAppInterface.toString());
          localObject4 = localObject1;
          localObject5 = localObject8;
          localObject6 = localObject2;
          localObject7 = localObject3;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "reportBindPhoneAction: action=" + paramString + ", toUin=" + (String)localObject4 + ", gender=" + (String)localObject6 + ", age=" + (String)localObject7 + ", level=" + (String)localObject5);
    }
  }
  
  public void b(Comments.Comment paramComment)
  {
    if (paramComment != null) {}
    new ajxs().h("video").i("playpage_com_suc").a().dy(this.app);
    ThreadManagerV2.excute(new ShortVideoCommentsView.19(this, (ajpj)this.app.getManager(106)), 16, null, false);
  }
  
  public void b(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (paramComment != null)
    {
      if (paramInt != 10003) {
        break label70;
      }
      showToast(getContext().getResources().getString(2131698612));
    }
    for (;;)
    {
      this.bl.requestFocus();
      i(paramComment);
      new ajxs().h("video").i("playpage_com_fail").a().dy(this.app);
      return;
      label70:
      if (paramInt == 10009) {
        Ne(paramString);
      } else {
        showToast(getContext().getResources().getString(2131698614));
      }
    }
  }
  
  public void b(Comments paramComments)
  {
    this.jdField_b_of_type_Ajxw.cqI = false;
    if ((paramComments.adn == 0L) && (paramComments.isEnd)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.isEnd = paramComments.isEnd;
      if ((paramComments.commentList != null) && (paramComments.commentList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.addAll(paramComments.commentList);
        this.jdField_b_of_type_Ajxw.notifyDataSetChanged();
      }
      this.isEnd = paramComments.isEnd;
      this.isLoading = false;
      this.py.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.adn) + ")");
      if (this.jdField_a_of_type_Ajzv != null) {
        this.jdField_a_of_type_Ajzv.kn(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.adn);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.adn = paramComments.adn;
    }
  }
  
  public void bhj()
  {
    if (this.cqL)
    {
      this.cqM = true;
      this.lb.setVisibility(8);
      this.lc.setVisibility(0);
      dAd();
      dAf();
      return;
    }
    this.lc.setVisibility(8);
    this.lb.setVisibility(0);
    dAg();
    postDelayed(new ShortVideoCommentsView.23(this), 100L);
    postDelayed(new ShortVideoCommentsView.24(this), 200L);
  }
  
  public void c(Comments.Comment paramComment)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.contains(paramComment))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList.remove(paramComment);
      this.jdField_b_of_type_Ajxw.notifyDataSetChanged();
      paramComment = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
      paramComment.adn -= 1L;
      this.py.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.adn) + ")");
      if (this.jdField_a_of_type_Ajzv != null) {
        this.jdField_a_of_type_Ajzv.kn(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.adn);
      }
    }
  }
  
  public void d(Comments.Comment paramComment)
  {
    ausj localausj = ausj.b(getContext());
    localausj.addButton(acfp.m(2131714500), 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new ajyj(this, paramComment, localausj));
    localausj.show();
  }
  
  public void dAa()
  {
    if (this.cqL)
    {
      RD(0);
      return;
    }
    RD(1);
  }
  
  public void dAb()
  {
    this.Bs = ((ImageView)this.mRootView.findViewById(2131366406));
    this.Bs.setOnClickListener(new ajym(this));
    this.Bs.setVisibility(0);
  }
  
  public void dAc()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.isInvalid()))
    {
      this.EW.setVisibility(8);
      return;
    }
    String str = "";
    Object localObject = str;
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSJ != null)
    {
      localObject = str;
      if (!this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSJ.isEmpty()) {
        localObject = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSJ.replace("\n", "").replace("\r", "").trim();
      }
    }
    localObject = mt((String)localObject);
    localObject = aqmw.b(getContext(), this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Ajws, (String)localObject);
    label204:
    long l;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "topicTitle is null or the length is 0");
      }
      this.Vl.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(8);
      this.EX.setVisibility(8);
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.ads != this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adu) {
        break label307;
      }
      this.Vn.setVisibility(8);
      this.Vp.setVisibility(8);
      this.Vo.setVisibility(8);
      this.Vo.setOnTouchListener(new ajyn(this));
      l = NetConnInfoCenter.getServerTimeMillis() - this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.time * 1000L;
      if (l >= 0L) {
        break label534;
      }
      localObject = "1分钟前";
    }
    for (;;)
    {
      this.Vm.setText((CharSequence)localObject);
      this.EW.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(8);
      this.Vl.setVisibility(0);
      if ((localObject instanceof SpannableString)) {
        this.Vl.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.Vl.setText((CharSequence)localObject);
      break;
      label307:
      if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adw == this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.adu) && (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType != 4))
      {
        this.Vn.setText(acfp.m(2131714480));
        this.Vp.setText(acfp.m(2131714473));
        this.Vp.setVisibility(0);
        str = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSG;
        localObject = str;
        if (str != null)
        {
          localObject = str;
          if (str.length() > 6)
          {
            localObject = str.substring(0, 6);
            localObject = (String)localObject + "...";
          }
        }
        this.Vo.setText((CharSequence)localObject);
        break label204;
      }
      this.Vn.setText(acfp.m(2131714508));
      this.Vp.setVisibility(8);
      str = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.bSH;
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.length() > 6)
        {
          localObject = str.substring(0, 6);
          localObject = (String)localObject + "...";
        }
      }
      this.Vo.setText((CharSequence)localObject);
      break label204;
      label534:
      if (l < 3600000L) {
        localObject = l / 60L / 1000L + 1L + acfp.m(2131714482);
      } else if (l < 86400000L) {
        localObject = l / 60L / 60L / 1000L + acfp.m(2131714529);
      } else if (l < 31536000000L) {
        localObject = l / 24L / 60L / 60L / 1000L + acfp.m(2131714489);
      } else {
        localObject = l / 365L / 24L / 60L / 60L / 1000L + acfp.m(2131714475);
      }
    }
  }
  
  public void dAd()
  {
    if (this.bl == null) {
      return;
    }
    this.bl.requestFocus();
    if ((!this.isKeyboardShow) && (getContext() != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      this.bl.getWindowToken();
      localInputMethodManager.showSoftInput(this.bl, 0);
      this.isKeyboardShow = true;
    }
    this.EY.setVisibility(0);
  }
  
  public void dAe()
  {
    if (this.bl == null) {}
    do
    {
      return;
      if ((this.isKeyboardShow) && (getContext() != null))
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.bl.getWindowToken(), 0);
        this.isKeyboardShow = false;
      }
      this.cqM = false;
      this.bl.clearFocus();
      this.EY.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable == null);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable);
  }
  
  public void dzU()
  {
    this.jdField_b_of_type_Ajxw.cqI = true;
  }
  
  public void dzX()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "initLocationView: lbsInfo null!");
      }
      this.mLocationText.setVisibility(8);
    }
    LocationInfo localLocationInfo;
    do
    {
      return;
      localLocationInfo = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "initLocationView:" + localLocationInfo.toString());
      }
    } while ((localLocationInfo.isCityEmpty()) && (localLocationInfo.isNameEmpty()));
    this.mLocationText.setVisibility(0);
    String str2 = localLocationInfo.getName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localLocationInfo.getCity();
    }
    this.mLocationText.setText(str1);
    if ((TextUtils.isEmpty(localLocationInfo.getName())) || (localLocationInfo.name.endsWith(acfp.m(2131714518))))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 6)
      {
        this.mLocationText.setCompoundDrawablesWithIntrinsicBounds(2130846439, 0, 0, 0);
        this.mLocationText.setTextColor(Color.parseColor("#777777"));
      }
      this.mLocationText.setOnClickListener(null);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 6)
    {
      this.mLocationText.setCompoundDrawablesWithIntrinsicBounds(2130846376, 0, 0, 0);
      this.mLocationText.setTextColor(Color.parseColor("#576B95"));
    }
    this.mLocationText.setEnabled(true);
    this.mLocationText.setOnClickListener(new ajyf(this, localLocationInfo));
  }
  
  public void e(Comments.Comment paramComment)
  {
    ausj localausj = ausj.b(getContext());
    localausj.addButton(acfp.m(2131714504), 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new ajyk(this, paramComment, localausj));
    localausj.show();
  }
  
  public void f(Comments.Comment paramComment)
  {
    ausj localausj = ausj.b(getContext());
    localausj.addButton(acfp.m(2131714487), 1);
    localausj.addButton(acfp.m(2131714490), 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new ajyl(this, paramComment, localausj));
    localausj.show();
  }
  
  public void g(Comments.Comment paramComment)
  {
    Context localContext = getContext();
    if ((paramComment.uid > 0L) && ((localContext instanceof BaseActivity)))
    {
      Bundle localBundle = new aqep.a().a(paramComment.content).s();
      aqep.b((BaseActivity)localContext, 0L, paramComment.uid + "", null, 20006, "", localBundle);
      return;
    }
    QQToast.a(localContext, 2, acfp.m(2131714465), 0).show();
  }
  
  public void gN(String paramString1, String paramString2)
  {
    if ((this.lb.getVisibility() == 0) || (this.lc.getVisibility() == 0)) {
      RD(0);
    }
    this.cqL = true;
    if ((!TextUtils.isEmpty(paramString1)) && (this.bl != null))
    {
      this.bl.setHint(paramString1);
      this.bSR = paramString1;
      if ((TextUtils.isEmpty(paramString2)) || (this.Vi == null)) {
        break label145;
      }
      this.Vi.setText(paramString2);
    }
    for (;;)
    {
      if (this.cqJ) {
        dAd();
      }
      return;
      if (this.bl == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoComments", 2, "onPermissionGranted text ie empty! etinput use defualt hint ");
      }
      this.bSR = getContext().getResources().getString(2131698605);
      this.bl.setHint(this.bSR);
      break;
      label145:
      if (this.Vi != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ShortVideoComments", 2, "onPermissionGranted btnText ie empty! btnSend use defualt text ");
        }
        this.Vi.setText(getContext().getResources().getString(2131698613));
      }
    }
  }
  
  public void hideLoading()
  {
    if ((this.jdField_a_of_type_Ajzq.GI() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(8);
    }
    this.isLoading = false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 300) || (paramInt1 == 301)) {
      gN("", "");
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 302);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "shortVideoComments onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
      }
    } while (paramInt2 != -1);
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments = new Comments();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.commentList = new ArrayList();
    this.jdField_a_of_type_Ajzq = new ajzr(this, this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.app);
    this.mSelfUin = this.app.getLongAccountUin();
    this.ayj = ((int)(jll.getScreenWidth(getContext()) - jll.dp2px(getContext(), 85.0F)));
    this.mTextPaint = new Paint();
    this.mTextPaint.setTextSize(jll.dp2px(getContext(), 12.0F));
  }
  
  public View onCreateView()
  {
    this.mRootView = LayoutInflater.from(getContext()).inflate(2131561470, this, true);
    this.mKeyboardHeight = (jll.getScreenHeight(getContext()) / 3);
    this.mRootView.setOnClickListener(new ajyo(this));
    this.r = ((ListView)this.mRootView.findViewById(2131370936));
    if ((this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type == 1) || (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.isInvalid())) {
      this.r.setOnTouchListener(new ajys(this));
    }
    this.jdField_b_of_type_Ajxw = new ajxw(getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments, this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.jdField_a_of_type_Ajzq, this.mTextPaint, this.ayj);
    this.EZ = LayoutInflater.from(getContext()).inflate(2131561469, this, false);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.ej = ((ViewGroup)this.EZ);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.ld = ((RelativeLayout)this.EZ.findViewById(2131373402));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView = ((ImageDisplayView)this.EZ.findViewById(2131368924));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView = ((OperationView)this.EZ.findViewById(2131372725));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.app = this.app;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.init();
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c = ((QQStoryVideoPlayerErrorView)this.EZ.findViewById(2131372766));
    Object localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).height = jll.getScreenHeight(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.getContext());
    ((FrameLayout.LayoutParams)localObject).width = jll.getScreenWidth(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.getContext());
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.requestLayout();
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.setOnClickListener(new ajyv(this));
    label596:
    float f2;
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType == 6)
    {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.ld.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.c.setVisibility(8);
      this.jdField_a_of_type_Ajzv = this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a();
      this.EW = LayoutInflater.from(getContext()).inflate(2131561471, this, false);
      this.EX = this.EW.findViewById(2131376984);
      this.Vl = ((TextView)this.EW.findViewById(2131380976));
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView = ((TopicLabelListView)this.EW.findViewById(2131380990));
      this.Vm = ((TextView)this.EW.findViewById(2131380971));
      this.Vn = ((TextView)this.EW.findViewById(2131380724));
      this.Vo = ((TextView)this.EW.findViewById(2131380814));
      this.Vp = ((TextView)this.EW.findViewById(2131380681));
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType != 6) {
        break label1292;
      }
      this.mLocationText = ((TextView)this.EW.findViewById(2131380652));
      this.EW.setVisibility(0);
      this.Fa = LayoutInflater.from(getContext()).inflate(2131561461, this, false);
      this.py = ((TextView)this.Fa.findViewById(2131380623));
      this.cX = new LinearLayout(getContext());
      this.cX.setBackgroundColor(Color.parseColor("#00000000"));
      int i = aqnm.getStatusBarHeight((Activity)this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
      float f1 = jll.getScreenHeight(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()) - i;
      f2 = jll.getScreenWidth(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type == 4)
      {
        this.cX.setBackgroundColor(Color.parseColor("#000000"));
        localObject = new AbsListView.LayoutParams(-1, -1);
        ((AbsListView.LayoutParams)localObject).width = ((int)f2);
        ((AbsListView.LayoutParams)localObject).height = ((int)f1);
        this.cX.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.cX.requestLayout();
      }
      this.EW.setBackgroundColor(Color.parseColor("#ffffff"));
      this.Fa.setBackgroundColor(Color.parseColor("#ffffff"));
      this.cX.setOrientation(1);
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 1)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 6) {
          break label1312;
        }
        localObject = LayoutInflater.from(getContext()).inflate(2131561466, this.cX, true);
        label859:
        this.jdField_a_of_type_Ajzv.hl((View)localObject);
        this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.eX = ((View)localObject);
        if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type == 6)
        {
          this.jdField_a_of_type_Ajzv.dAr();
          this.EW.findViewById(2131376982).setVisibility(8);
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 6) {
        break label1344;
      }
      this.cX.addView(this.EW);
      this.cX.addView(this.EZ, (int)f2, -2);
      this.cX.addView(this.Fa);
      this.Fa.findViewById(2131380010).setVisibility(0);
      label974:
      this.r.addHeaderView(this.cX);
      this.r.setAdapter(this.jdField_b_of_type_Ajxw);
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 4) {
        break label1384;
      }
      dAb();
      this.r.setOnTouchListener(new ajyw(this));
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.isInvalid())
      {
        this.EW.setVisibility(8);
        this.Fa.setVisibility(8);
      }
      this.EY = this.mRootView.findViewById(2131381912);
      this.EY.setOnClickListener(new ajyx(this));
      this.Vi = ((TextView)this.mRootView.findViewById(2131363987));
      this.jt = ((LinearLayout)this.mRootView.findViewById(2131370724));
      this.bl = ((EditText)this.mRootView.findViewById(2131366524));
      dzY();
      this.lb = ((RelativeLayout)this.mRootView.findViewById(2131377447));
      this.Vj = ((TextView)this.mRootView.findViewById(2131370121));
      this.Vk = ((TextView)this.mRootView.findViewById(2131363924));
      this.lc = ((RelativeLayout)this.mRootView.findViewById(2131377397));
      dAe();
      this.ev = this.mRootView.findViewById(2131381913);
      return this.mRootView;
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.feedType == 4)
      {
        this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.ld.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.ld.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      break;
      label1292:
      this.mLocationText = ((TextView)this.EW.findViewById(2131380651));
      break label596;
      label1312:
      localObject = LayoutInflater.from(getContext()).inflate(2131561466, (ViewGroup)this.mRootView.findViewById(2131371090), true);
      break label859;
      label1344:
      this.cX.addView(this.EZ, (int)f2, -2);
      this.cX.addView(this.EW);
      this.cX.addView(this.Fa);
      break label974;
      label1384:
      ajxv.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$a, this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.videoWidth, this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.videoHeight);
      this.bM = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131561456, null, false));
      localObject = new AbsListView.LayoutParams(-1, (int)jll.dp2px(getContext(), 50.0F));
      this.bM.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView = ((HorizontalBallLoadingView)this.bM.findViewById(2131374941));
      this.r.addFooterView(this.bM);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dAe();
    this.jdField_a_of_type_Ajzq.release();
    this.Yp = true;
    if (this.jdField_b_of_type_Ajxw != null) {
      this.jdField_b_of_type_Ajxw.Mt(this.Yp);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0))
    {
      if (paramInt8 - paramInt4 <= this.mKeyboardHeight) {
        break label53;
      }
      ThreadManager.getUIHandler().post(new ShortVideoCommentsView.29(this));
    }
    for (;;)
    {
      if (this.aaf == 0) {
        this.aaf = GG();
      }
      return;
      label53:
      if (paramInt4 - paramInt8 > this.mKeyboardHeight) {
        ThreadManager.getUIHandler().post(new ShortVideoCommentsView.30(this));
      }
    }
  }
  
  public void onPause()
  {
    dAe();
    this.mRootView.removeOnLayoutChangeListener(this);
  }
  
  public void onResume()
  {
    this.mRootView.addOnLayoutChangeListener(this);
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.type != 4) {
      gN("", "");
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      onResume();
      return;
    }
    onPause();
  }
  
  public void scrollToTop()
  {
    dAe();
    this.EY.setVisibility(8);
    this.lc.setVisibility(8);
    this.lb.setVisibility(8);
    this.r.setSelection(0);
    this.aaf = 0;
    ThreadManager.getUIHandler().postDelayed(new ShortVideoCommentsView.22(this), 10L);
  }
  
  public void setVideoData(VideoData paramVideoData)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
  }
  
  public void showLoading()
  {
    if ((this.jdField_a_of_type_Ajzq.GI() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(0);
    }
  }
  
  public void showToast(String paramString)
  {
    if (getContext() != null) {
      QQToast.a(getContext(), 0, paramString, 1).show();
    }
  }
  
  public class BottomAreaRunnable
    implements Runnable
  {
    private int type = 2;
    
    BottomAreaRunnable(int paramInt)
    {
      this.type = paramInt;
    }
    
    public void run()
    {
      switch (this.type)
      {
      default: 
        ShortVideoCommentsView.b(ShortVideoCommentsView.this).setVisibility(8);
        ShortVideoCommentsView.a(ShortVideoCommentsView.this).setVisibility(8);
        return;
      case 0: 
        ShortVideoCommentsView.a(ShortVideoCommentsView.this).setVisibility(8);
        ShortVideoCommentsView.b(ShortVideoCommentsView.this).setVisibility(0);
        return;
      }
      ShortVideoCommentsView.b(ShortVideoCommentsView.this).setVisibility(8);
      if ((ShortVideoCommentsView.a(ShortVideoCommentsView.this) != null) && (ShortVideoCommentsView.a(ShortVideoCommentsView.this).type != 4)) {
        ShortVideoCommentsView.a(ShortVideoCommentsView.this).setVisibility(0);
      }
      ShortVideoCommentsView.d(ShortVideoCommentsView.this);
    }
  }
  
  class FocusInputRunnable
    implements Runnable
  {
    long lastTime;
    
    FocusInputRunnable(long paramLong)
    {
      this.lastTime = paramLong;
    }
    
    public void run()
    {
      if (System.currentTimeMillis() - this.lastTime > 1000L) {
        return;
      }
      ShortVideoCommentsView.a(ShortVideoCommentsView.this).setFocusable(true);
      ShortVideoCommentsView.a(ShortVideoCommentsView.this).setFocusableInTouchMode(true);
      ShortVideoCommentsView.a(ShortVideoCommentsView.this).requestFocus();
      ThreadManager.getUIHandler().postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView
 * JD-Core Version:    0.7.0.1
 */