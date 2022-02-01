package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import acff;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import aqiw;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import jll;
import wja;
import yoy;
import ypa;
import ypb;
import ype;
import ypj;
import ypk;
import ypl;

public class Face2FaceAddContactFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, ypl
{
  private TextView KY;
  private TextView KZ;
  private TextView La;
  private TextView Lb;
  private TextView Lc;
  private TextView Ld;
  private TextView Le;
  private TextView Lf;
  private TextView Lg;
  private TextView Lh;
  private TextView Li;
  private TextView Lj;
  private TextView Lk;
  private TextView Ll;
  private TextView Lm;
  private TextView Ln;
  private TextView Lo;
  private TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  private ype jdField_a_of_type_Ype;
  private yoy b;
  private boolean bnY;
  private String[] cS = { "1234", "0000", "1111", "2222", "3333" };
  private Button eh;
  private View.OnClickListener ek = new ypb(this);
  private long enterTime;
  private LinearLayout hv;
  private LinearLayout hw;
  private LinearLayout hx;
  private StringBuffer j;
  private Drawable mProgressDrawable;
  private RecyclerView recyclerView;
  private TextView sQ;
  Handler uiHandler = new ypa(this);
  private ImageView uq;
  private ImageView ur;
  private ImageView us;
  private ImageView ut;
  private ImageView uu;
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void Ad()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarColor(-16777216);
    }
    getTitleBarView().setBackgroundResource(0);
    getTitleBarView().setBackgroundColor(-16777216);
    this.leftView.setVisibility(8);
    this.centerView.setTextColor(-1);
    setTitle(getString(2131693369), getString(2131693369));
    this.rightViewText.setTextColor(-1);
    setRightButtonText(getString(2131720765), this);
    this.rightViewText.setContentDescription(getString(2131720765));
    this.hv = ((LinearLayout)this.mContentView.findViewById(2131365375));
    this.uq = ((ImageView)this.mContentView.findViewById(2131369740));
    this.sQ = ((TextView)this.mContentView.findViewById(2131373699));
    this.ur = ((ImageView)this.mContentView.findViewById(2131369725));
    this.us = ((ImageView)this.mContentView.findViewById(2131369727));
    this.ut = ((ImageView)this.mContentView.findViewById(2131369726));
    this.uu = ((ImageView)this.mContentView.findViewById(2131369724));
    this.KY = ((TextView)this.mContentView.findViewById(2131380658));
    this.KZ = ((TextView)this.mContentView.findViewById(2131380660));
    this.La = ((TextView)this.mContentView.findViewById(2131380659));
    this.Lb = ((TextView)this.mContentView.findViewById(2131380657));
    this.Lc = ((TextView)this.mContentView.findViewById(2131379598));
    this.Ld = ((TextView)this.mContentView.findViewById(2131379600));
    this.recyclerView = ((RecyclerView)this.mContentView.findViewById(2131368143));
    this.b = new yoy(getActivity(), getActivity().app, this.recyclerView);
    this.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
    this.recyclerView.setAdapter(this.b);
    this.hw = ((LinearLayout)this.mContentView.findViewById(2131370624));
    this.hx = ((LinearLayout)this.mContentView.findViewById(2131370690));
    this.eh = ((Button)this.mContentView.findViewById(2131363863));
    this.eh.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)this.mContentView.findViewById(2131365909));
    this.Le = ((TextView)this.mContentView.findViewById(2131372626));
    this.Lf = ((TextView)this.mContentView.findViewById(2131381039));
    this.Lg = ((TextView)this.mContentView.findViewById(2131379627));
    this.Lh = ((TextView)this.mContentView.findViewById(2131367551));
    this.Li = ((TextView)this.mContentView.findViewById(2131367141));
    this.Lj = ((TextView)this.mContentView.findViewById(2131378458));
    this.Lk = ((TextView)this.mContentView.findViewById(2131378156));
    this.Ll = ((TextView)this.mContentView.findViewById(2131366299));
    this.Lm = ((TextView)this.mContentView.findViewById(2131372400));
    this.Ln = ((TextView)this.mContentView.findViewById(2131382432));
    this.Lo = ((TextView)this.mContentView.findViewById(2131365697));
    this.Le.setOnClickListener(this.ek);
    this.Le.setOnTouchListener(jll.a);
    this.Lf.setOnClickListener(this.ek);
    this.Lf.setOnTouchListener(jll.a);
    this.Lg.setOnClickListener(this.ek);
    this.Lg.setOnTouchListener(jll.a);
    this.Lh.setOnClickListener(this.ek);
    this.Lh.setOnTouchListener(jll.a);
    this.Li.setOnClickListener(this.ek);
    this.Li.setOnTouchListener(jll.a);
    this.Lj.setOnClickListener(this.ek);
    this.Lj.setOnTouchListener(jll.a);
    this.Lk.setOnClickListener(this.ek);
    this.Lk.setOnTouchListener(jll.a);
    this.Ll.setOnClickListener(this.ek);
    this.Ll.setOnTouchListener(jll.a);
    this.Lm.setOnClickListener(this.ek);
    this.Lm.setOnTouchListener(jll.a);
    this.Ln.setOnClickListener(this.ek);
    this.Ln.setOnTouchListener(jll.a);
    this.Lo.setOnClickListener(this.ek);
    this.Lo.setOnTouchListener(jll.a);
  }
  
  private void Ar(boolean paramBoolean)
  {
    this.Le.setEnabled(paramBoolean);
    this.Lf.setEnabled(paramBoolean);
    this.Lg.setEnabled(paramBoolean);
    this.Lh.setEnabled(paramBoolean);
    this.Li.setEnabled(paramBoolean);
    this.Lj.setEnabled(paramBoolean);
    this.Lk.setEnabled(paramBoolean);
    this.Ll.setEnabled(paramBoolean);
    this.Lm.setEnabled(paramBoolean);
    this.Ln.setEnabled(paramBoolean);
    this.Lo.setEnabled(paramBoolean);
  }
  
  private void Em(int paramInt)
  {
    if (paramInt == 4)
    {
      Ar(false);
      if (!aqiw.isNetSupport(getActivity()))
      {
        QQToast.a(getActivity(), 2131696348, 0).show();
        this.uiHandler.sendEmptyMessageDelayed(500, 500L);
      }
    }
    else
    {
      return;
    }
    if (jdMethod_if(this.j.toString()))
    {
      QQToast.a(getActivity(), getString(2131721219), 0).show();
      ypj.u("0X800AB5F", "", "", this.j.toString());
      this.uiHandler.sendEmptyMessageDelayed(500, 500L);
      return;
    }
    this.sQ.setVisibility(0);
    this.sQ.setBackgroundDrawable(this.mProgressDrawable);
    ((Animatable)this.mProgressDrawable).start();
    this.jdField_a_of_type_Ype.a(getActivity(), this.j.toString(), null);
  }
  
  private void En(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.ur.setVisibility(4);
      this.KY.setVisibility(0);
      this.KY.setText(String.valueOf(this.j.charAt(paramInt - 1)));
      return;
    case 2: 
      this.us.setVisibility(4);
      this.KZ.setVisibility(0);
      this.KZ.setText(String.valueOf(this.j.charAt(paramInt - 1)));
      return;
    case 3: 
      this.ut.setVisibility(4);
      this.La.setVisibility(0);
      this.La.setText(String.valueOf(this.j.charAt(paramInt - 1)));
      return;
    }
    this.uu.setVisibility(4);
    this.Lb.setVisibility(0);
    this.Lb.setText(String.valueOf(this.j.charAt(paramInt - 1)));
  }
  
  private void Eo(int paramInt)
  {
    if ((this.Ld == null) || (isDetached())) {
      return;
    }
    if (this.Ld.getVisibility() != 0)
    {
      this.uq.setVisibility(8);
      this.Lc.setVisibility(8);
      this.Ld.setVisibility(0);
      this.KY.setTextSize(wja.dp2px(8.0F, getResources()));
      this.KZ.setTextSize(wja.dp2px(8.0F, getResources()));
      this.La.setTextSize(wja.dp2px(8.0F, getResources()));
      this.Lb.setTextSize(wja.dp2px(8.0F, getResources()));
    }
    if (paramInt > 0)
    {
      String str = getString(2131693376, new Object[] { Integer.valueOf(paramInt) });
      int i = str.indexOf(String.valueOf(paramInt));
      if (i < 0)
      {
        this.Ld.setText(str);
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), i, String.valueOf(paramInt).length() + i, 33);
      this.Ld.setText(localSpannableStringBuilder);
      return;
    }
    this.Ld.setText(getString(2131693375));
  }
  
  private void X(View paramView, int paramInt)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366299: 
    case 2131367141: 
    case 2131367551: 
    case 2131372400: 
    case 2131372626: 
    case 2131378156: 
    case 2131378458: 
    case 2131379627: 
    case 2131381039: 
    case 2131382432: 
      this.j.append(((TextView)paramView).getText());
      return;
    }
    if ((paramInt > 0) && (paramInt < 4)) {
      this.j.deleteCharAt(paramInt - 1);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.ur.setVisibility(0);
      this.KY.setVisibility(4);
      this.KY.setText("");
      return;
    case 2: 
      this.us.setVisibility(0);
      this.KZ.setVisibility(4);
      this.KZ.setText("");
      return;
    case 3: 
      this.ut.setVisibility(0);
      this.La.setVisibility(4);
      this.La.setText("");
      return;
    }
    this.uu.setVisibility(0);
    this.Lb.setVisibility(4);
    this.Lb.setText("");
  }
  
  private void ckn()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    if (getActivity().isResume())
    {
      ckp();
      QQToast.a(getActivity(), getString(2131693380), 0).show();
      return;
    }
    this.bnY = true;
  }
  
  private void cko()
  {
    ((Animatable)this.mProgressDrawable).stop();
    this.sQ.setVisibility(8);
    this.sQ.setBackgroundDrawable(null);
    Eo(0);
    this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(8);
    this.b.notifyDataSetChanged();
    this.recyclerView.setVisibility(0);
  }
  
  private void ckp()
  {
    if (isDetached()) {}
    do
    {
      return;
      ((Animatable)this.mProgressDrawable).stop();
      this.sQ.setVisibility(8);
      this.sQ.setBackgroundDrawable(null);
      this.b.clearData();
      this.uq.setVisibility(0);
      this.Lc.setVisibility(0);
      this.Ld.setVisibility(8);
      ckq();
      this.recyclerView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(0);
      this.hw.setVisibility(8);
    } while (this.uiHandler == null);
    this.uiHandler.removeMessages(301);
    this.uiHandler.removeMessages(401);
  }
  
  private void ckq()
  {
    this.j.delete(0, this.j.length());
    this.KY.setText("");
    this.ur.setVisibility(0);
    this.KZ.setText("");
    this.us.setVisibility(0);
    this.La.setText("");
    this.ut.setVisibility(0);
    this.Lb.setText("");
    this.uu.setVisibility(0);
    Ar(true);
  }
  
  private void ckr()
  {
    this.hx.setVisibility(8);
    this.hv.setVisibility(0);
    ckp();
  }
  
  private void cky()
  {
    if ((this.jdField_a_of_type_Ype != null) && (this.b != null) && (getActivity() != null) && (!getActivity().isFinishing()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "sendFace2FaceHeartBeat isNetworkAvailable:" + aqiw.isNetworkAvailable());
      }
      if (aqiw.isNetworkAvailable())
      {
        Object localObject = this.b.cQ();
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ypk localypk = (ypk)((Iterator)localObject).next();
          if (localypk != null) {
            localArrayList.add(localypk.friendUin);
          }
        }
        this.jdField_a_of_type_Ype.gI(localArrayList);
      }
    }
    else
    {
      return;
    }
    Eq(20000);
  }
  
  private void gotoSetting()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", getActivity().getPackageName(), null));
    getActivity().startActivityForResult(localIntent, 1002);
  }
  
  private boolean jdMethod_if(String paramString)
  {
    return Arrays.asList(this.cS).contains(paramString);
  }
  
  private void initData()
  {
    this.jdField_a_of_type_Ype = new ype(this);
    this.j = new StringBuffer();
    this.mProgressDrawable = getResources().getDrawable(2130839657);
  }
  
  public static void s(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.start(paramContext, paramIntent, Face2FaceAddContactFragment.class);
  }
  
  public void Ep(int paramInt)
  {
    if ((isDetached()) || (getActivity() == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactFragment", 2, "onEnterFace2FaceAddContactSuccess() expireTimeMs:" + paramInt);
      }
      this.enterTime = SystemClock.elapsedRealtime();
      cko();
    } while ((this.uiHandler == null) || (getActivity() == null) || (getActivity().isFinishing()));
    this.uiHandler.removeMessages(401);
    this.uiHandler.sendEmptyMessageDelayed(401, paramInt);
  }
  
  public void Eq(int paramInt)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactFragment", 2, "startFace2FaceAddContactHeartBeat delayTimeMs:" + paramInt);
    }
    if ((this.uiHandler != null) && (getActivity() != null) && (!getActivity().isFinishing())) {
      this.uiHandler.sendEmptyMessageDelayed(301, paramInt);
    }
  }
  
  public void asc()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    while (this.uiHandler == null) {
      return;
    }
    this.uiHandler.sendEmptyMessage(5);
  }
  
  public void ckA()
  {
    this.hx.setVisibility(0);
    this.hv.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(8);
    ypj.u("0X800AB60", "", "", "");
  }
  
  public void cks()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactFragment", 2, "onExitFace2FaceAddContact()");
    }
    ckp();
  }
  
  public void ckt()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    while (this.uiHandler == null) {
      return;
    }
    this.uiHandler.sendEmptyMessage(6);
  }
  
  public void cku()
  {
    ckn();
  }
  
  public void ckv()
  {
    ckn();
  }
  
  public void ckw()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    ckp();
    QQToast.a(getActivity(), getString(2131720359), 0).show();
  }
  
  public void ckx()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    ckp();
    QQToast.a(getActivity(), getString(2131693381), 0).show();
    ypj.u("0X800AB64", "", "", "");
  }
  
  public void ckz()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    do
    {
      return;
      ckp();
      QQToast.a(getActivity(), getString(2131721219), 0).show();
    } while (this.j == null);
    ypj.u("0X800AB5F", "", "", this.j.toString());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    initData();
    Ad();
    this.jdField_a_of_type_Ype.b(getActivity());
  }
  
  public void gH(List<String> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (getActivity().app == null)) {}
    ArrayList localArrayList;
    do
    {
      acff localacff;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactHeartBeat() missingList.size() = " + paramList.size());
          }
        } while (paramList.size() <= 0);
        localacff = (acff)getActivity().app.getManager(51);
      } while (localacff == null);
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        ypk localypk = new ypk();
        localypk.friendUin = ((String)localObject);
        localypk.friendType = 1;
        if (!this.b.cQ().contains(localypk))
        {
          localObject = localacff.a((String)localObject);
          if ((localObject != null) && (((Friends)localObject).isFriend()))
          {
            localypk.AI = ((Friends)localObject).getFriendNick();
            localArrayList.add(localypk);
          }
        }
      }
    } while (localArrayList.size() <= 0);
    s(getActivity().app.getCurrentUin(), localArrayList);
  }
  
  public int getContentLayoutId()
  {
    return 2131559320;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130771991, 2130771992);
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult resultCode:" + paramInt2 + " requestCode:" + paramInt1);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          paramIntent = paramIntent.getStringExtra("ticket");
          if ((!TextUtils.isEmpty(this.j.toString())) && (this.j.length() == 4)) {
            this.jdField_a_of_type_Ype.a(getActivity(), this.j.toString(), paramIntent);
          }
          if (QLog.isDebugVersion()) {
            QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult VERIFY_REQUEST_CODE, verifySig:" + paramIntent);
          }
          ypj.u("0X800AB66", "", "", "");
          return;
        }
      } while (paramInt2 != 0);
      ckp();
      QQToast.a(getActivity(), getString(2131693383), 0).show();
      return;
    } while (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0);
    ckr();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Ype != null) {
      this.jdField_a_of_type_Ype.ckB();
    }
    if (this.b != null) {
      ypj.e(this.enterTime, this.b.cQ());
    }
    return super.onBackEvent();
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
      onBackEvent();
      continue;
      gotoSetting();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ype != null) {
      this.jdField_a_of_type_Ype.onDestroy();
    }
    if (this.b != null) {
      this.b.onDestroy();
    }
    if (this.uiHandler != null) {
      this.uiHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130771990);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity))) {
      ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp.setStatusBarColor(-16777216);
    }
    if ((localFragmentActivity != null) && (this.bnY))
    {
      this.bnY = false;
      ckp();
      QQToast.a(getActivity(), getString(2131693380), 0).show();
    }
  }
  
  public void s(String paramString, List<ypk> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (paramList.size() <= 0) || (this.b.cQ() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactPush() faceFriends.size() = " + paramList.size());
    }
    if (this.recyclerView.getVisibility() != 0)
    {
      this.recyclerView.setVisibility(0);
      this.hw.setVisibility(8);
    }
    int i = this.b.cQ().size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (ypk)paramString.next();
      if (!this.b.cQ().contains(paramList)) {
        this.b.cQ().add(i, paramList);
      }
    }
    int k = this.b.cQ().size();
    if (i != k) {
      this.b.notifyItemRangeInserted(i, k - i);
    }
    Eo(k);
  }
  
  public void yZ(String paramString)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delFriendUin:" + paramString);
    }
    if ((isDetached()) || (getActivity() == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i = 0;
    label57:
    if (i < this.b.cQ().size()) {
      if (!paramString.equals(((ypk)this.b.cQ().get(i)).friendUin)) {}
    }
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delIndex:" + i);
      }
      if (i == -1) {
        break;
      }
      this.b.cQ().remove(i);
      this.b.notifyItemRemoved(i);
      Eo(this.b.cQ().size());
      return;
      i += 1;
      break label57;
      i = -1;
    }
  }
  
  public void za(String paramString)
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("uin", getActivity().app.getCurrentUin());
    localIntent.putExtra("url", paramString);
    try
    {
      getActivity().startActivityForResult(localIntent, 1001);
      ypj.u("0X800AB65", "", "", "");
      return;
    }
    catch (SecurityException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment
 * JD-Core Version:    0.7.0.1
 */