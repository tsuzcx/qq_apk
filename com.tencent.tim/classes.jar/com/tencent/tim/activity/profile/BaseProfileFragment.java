package com.tencent.tim.activity.profile;

import acfp;
import ajor;
import ajos;
import alcn;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import anpc;
import aqhu;
import atax;
import atay;
import ataz;
import atba;
import atbb;
import atbe;
import atbo;
import avpw;
import avpw.d;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tim.activity.profile.friend.FriendProfileFragment;
import com.tencent.tim.activity.profile.friend.TroopFriendProfileFragment;
import com.tencent.tim.activity.profile.host.HostProfileFragment;
import com.tencent.tim.activity.profile.host.TroopHostProfileFragment;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public abstract class BaseProfileFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public ImageView EH;
  protected View Kk;
  public TextView Pa;
  protected TextView Pb;
  public alcn a;
  private StateListDrawable a;
  public atbb a;
  public atbo a;
  protected LifeCycleFragment a;
  public QQAppInterface app;
  protected int bHo;
  protected TextView ey;
  protected View mContentView;
  protected View mHeaderView;
  protected TextView mNickName;
  protected ListView x;
  
  public BaseProfileFragment()
  {
    this.jdField_a_of_type_Alcn = new alcn();
  }
  
  private Drawable ay()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable == null) {}
    try
    {
      Drawable localDrawable1 = getResources().getDrawable(2130851119);
      Drawable localDrawable2 = getResources().getDrawable(2130851123);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], localDrawable1);
      return this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BaseProfileFragment", 1, "getBackDrawable fail.", localException);
      }
    }
  }
  
  private void esR()
  {
    String str = kC();
    if (!TextUtils.isEmpty(str)) {
      anpc.report(str);
    }
  }
  
  private void esS()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(getActivity());
      this.mContentView.findViewById(2131377546).setPadding(0, i, 0, 0);
    }
  }
  
  private void initListView()
  {
    this.mHeaderView = LayoutInflater.from(getActivity()).inflate(2131559791, null);
    this.x = ((ListView)this.mContentView.findViewById(2131370946));
    this.x.addHeaderView(this.mHeaderView);
    this.EH = ((ImageView)this.mHeaderView.findViewById(2131368375));
    this.mNickName = ((TextView)this.mHeaderView.findViewById(2131372384));
    this.Pa = ((TextView)this.mHeaderView.findViewById(2131369979));
    this.Pb = ((TextView)this.mHeaderView.findViewById(2131378414));
    this.jdField_a_of_type_Atbb = new atbb();
    this.x.setAdapter(this.jdField_a_of_type_Atbb);
    this.jdField_a_of_type_Atbb.a(new atax(this));
  }
  
  private String kC()
  {
    String str = getClass().getSimpleName();
    if (str.equals(HostProfileFragment.class.getSimpleName())) {
      return "tim_profile_mine";
    }
    if (str.equals(TroopHostProfileFragment.class.getSimpleName())) {
      return "tim_gprofile_mine";
    }
    if (str.equals(FriendProfileFragment.class.getSimpleName())) {
      return "tim_profile_others";
    }
    if (str.equals(TroopFriendProfileFragment.class.getSimpleName())) {
      return "tim_gprofile_others";
    }
    return "";
  }
  
  private void pP()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      SystemBarCompact localSystemBarCompact = getActivity().mSystemBarComp;
      if (localSystemBarCompact != null)
      {
        localSystemBarCompact.setStatusColor(0);
        localSystemBarCompact.setStatusBarDrawable(null);
      }
    }
  }
  
  public void Bm(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.Pb.setVisibility(0);
      this.Pb.setText(paramString);
      return;
    }
    this.Pb.setVisibility(8);
  }
  
  public void YE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseProfileFragment", 2, "updateTitleName nickDesc: " + paramString);
      }
      this.mNickName.setText(paramString);
    }
  }
  
  public void a(atbe paramatbe)
  {
    switch (paramatbe.id)
    {
    default: 
      return;
    case 7: 
      paramatbe = new Intent();
      paramatbe.putExtra("troop_uin", this.jdField_a_of_type_Alcn.troopUin);
      paramatbe.putExtra("member_uin", this.jdField_a_of_type_Alcn.d.uin);
      PublicFragmentActivity.start(getActivity(), paramatbe, TroopMemberHistoryFragment.class);
      return;
    case 13: 
      paramatbe = this.jdField_a_of_type_Atbo.EJ();
      d(getString(2131697276), paramatbe, 60, 2, 1040);
      return;
    }
    paramatbe = avpw.d.a();
    paramatbe.cMP = this.app.getCurrentAccountUin();
    paramatbe.nickname = this.app.getCurrentNickname();
    avpw.a(getActivity(), paramatbe, this.jdField_a_of_type_Alcn.d.uin, 0, 0, 0);
  }
  
  protected void bOY()
  {
    int k = 0;
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_Atbo.getNickName();
    Object localObject2 = this.jdField_a_of_type_Atbo.EH();
    Object localObject3 = this.jdField_a_of_type_Atbo.EI();
    String str = "";
    if (QLog.isColorLevel()) {
      QLog.d("BaseProfileFragment", 2, String.format("showEditNickActionSheet, nickName: %s, troopNick: %s, remark: %s", new Object[] { localObject1, localObject2, localObject3 }));
    }
    int i;
    if (this.jdField_a_of_type_Alcn.e.pa == 0) {
      if (this.jdField_a_of_type_Alcn.cwc)
      {
        localObject1 = getResources().getString(2131694838);
        j = 3;
        i = 1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = new Intent(getActivity(), EditInfoActivity.class);
          ((Intent)localObject3).putExtra("title", (String)localObject1);
          ((Intent)localObject3).putExtra("default_text", (String)localObject2);
          ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_Alcn.d.uin);
          ((Intent)localObject3).putExtra("edit_action", j);
          ((Intent)localObject3).putExtra("max_limit_mode", 1);
          ((Intent)localObject3).putExtra("edit_type", 2);
          if (i == 0) {
            break label827;
          }
          ((Intent)localObject3).putExtra("max_num", 60);
          ((Intent)localObject3).putExtra("isTroopNick", true);
          ((Intent)localObject3).putExtra("troopUin", this.jdField_a_of_type_Alcn.troopUin);
        }
      }
    }
    for (;;)
    {
      getActivity().startActivityForResult((Intent)localObject3, 1034);
      return;
      localObject3 = getResources().getString(2131694837);
      localObject2 = localObject1;
      i = 0;
      j = 1;
      localObject1 = localObject3;
      break;
      if (this.jdField_a_of_type_Alcn.cwc)
      {
        localObject1 = ((TroopManager)this.app.getManager(52)).c(this.jdField_a_of_type_Alcn.troopUin);
        if ((localObject1 != null) && ((((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentUin())) || (((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentUin())))) {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
            {
              localObject1 = getResources().getString(2131694841, new Object[] { acfp.m(2131706612) });
              label413:
              j = 1;
              i = 4;
            }
          }
        }
        for (;;)
        {
          k = i;
          i = j;
          j = k;
          break;
          localObject1 = getResources().getString(2131694841, new Object[] { acfp.m(2131706607) });
          break label413;
          if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
          {
            localObject1 = getResources().getString(2131694913, new Object[] { acfp.m(2131706635) });
            break label413;
          }
          localObject1 = getResources().getString(2131694913, new Object[] { acfp.m(2131706590) });
          break label413;
          if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
          {
            ci(getResources().getString(2131694843, new Object[] { acfp.m(2131706633) }), 1);
            localObject1 = "";
            i = 0;
            localObject2 = "";
            j = k;
          }
          else
          {
            ci(getResources().getString(2131694843, new Object[] { acfp.m(2131706591) }), 1);
            localObject1 = "";
            i = 0;
            localObject2 = "";
            j = k;
          }
        }
      }
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
        for (localObject1 = getResources().getString(2131694833);; localObject1 = getResources().getString(2131694912))
        {
          localObject2 = localObject3;
          i = 0;
          j = 2;
          break;
        }
      }
      if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
      {
        ci(getResources().getString(2131694834, new Object[] { acfp.m(2131706606), acfp.m(2131706606) }), 1);
        localObject1 = "";
        i = 0;
        localObject2 = str;
        break;
      }
      ci(getResources().getString(2131694834, new Object[] { acfp.m(2131706614), acfp.m(2131706614) }), 1);
      localObject1 = "";
      i = 0;
      localObject2 = str;
      break;
      label827:
      i = 36;
      if (j == 2) {
        i = 60;
      }
      ((Intent)localObject3).putExtra("max_num", i);
      ((Intent)localObject3).putExtra("support_emotion", true);
    }
  }
  
  protected abstract void biN();
  
  public void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getActivity().getTitleBarHeight());
  }
  
  public void ci(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).show(getActivity().getTitleBarHeight());
  }
  
  protected void d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(getActivity(), EditInfoActivity.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("max_num", paramInt1);
    localIntent.putExtra("default_text", paramString2);
    localIntent.putExtra("uin", this.jdField_a_of_type_Alcn.d.uin);
    localIntent.putExtra("edit_action", paramInt2);
    localIntent.putExtra("max_limit_mode", 1);
    localIntent.putExtra("edit_type", 2);
    getActivity().startActivityForResult(localIntent, paramInt3);
  }
  
  protected void esT()
  {
    ajos.a(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment, this.jdField_a_of_type_Atbo.E, new atay(this));
    ajos.a(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment, this.jdField_a_of_type_Atbo.F, new ataz(this));
    ajos.a(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment, this.jdField_a_of_type_Atbo.D, new atba(this));
  }
  
  protected void esU()
  {
    getActivity().finish();
  }
  
  protected void esV() {}
  
  protected void initView()
  {
    initListView();
    this.ey = ((TextView)this.mContentView.findViewById(2131369579));
    this.Kk = this.mContentView.findViewById(2131363642);
    this.ey.setOnClickListener(this);
    this.mNickName.setOnClickListener(this);
    this.EH.setOnClickListener(this);
    esS();
    Drawable localDrawable = ay();
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(new LightingColorFilter(0, -16777216));
      this.ey.setBackgroundDrawable(localDrawable);
    }
    esT();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    pP();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1034))
    {
      paramInt1 = paramIntent.getIntExtra("edit_action", 0);
      paramIntent = paramIntent.getStringExtra("nick");
      if ((paramInt1 != 3) && (paramInt1 != 4)) {
        break label71;
      }
      this.jdField_a_of_type_Alcn.gh[1] = paramIntent;
    }
    for (;;)
    {
      this.jdField_a_of_type_Atbo.esY();
      this.jdField_a_of_type_Atbo.refreshList();
      return;
      label71:
      if (paramInt1 == 1) {
        this.jdField_a_of_type_Alcn.gh[0] = paramIntent;
      } else if (paramInt1 == 2) {
        this.jdField_a_of_type_Alcn.gh[4] = paramIntent;
      }
    }
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
      esU();
      continue;
      bOY();
      continue;
      esV();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment = ajor.a(getActivity());
    biN();
    paramBundle = new Intent().putExtras(getArguments());
    this.jdField_a_of_type_Alcn = this.jdField_a_of_type_Atbo.a(this.app, paramBundle);
    if (this.jdField_a_of_type_Alcn.e == null)
    {
      getActivity().finish();
      return;
    }
    esR();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContentView = paramLayoutInflater.inflate(2131559790, paramViewGroup, false);
    initView();
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void wd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (this.EH != null) {
        this.EH.setImageDrawable(aqhu.at());
      }
    }
    for (;;)
    {
      return;
      String str = this.app.getFaceBitmapCacheKey(1, paramString, (byte)1, 0);
      Bitmap localBitmap = this.app.getBitmapFromCache(str);
      if (localBitmap != null)
      {
        paramString = getActivity();
        if (paramString != null) {
          paramString.runOnUiThread(new BaseProfileFragment.5(this, localBitmap));
        }
      }
      else
      {
        while (QLog.isDevelopLevel())
        {
          QLog.i("BaseProfileFragment", 4, "updateFace, " + str + "," + localBitmap);
          return;
          ThreadManager.getFileThreadHandler().post(new BaseProfileFragment.6(this, paramString));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.BaseProfileFragment
 * JD-Core Version:    0.7.0.1
 */