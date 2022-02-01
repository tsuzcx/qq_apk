package com.tencent.mobileqq.activity.contact.recommendtroop;

import acff;
import acms;
import acnd;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdj;
import aqgv;
import aqiw;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yuz;
import yva;
import yvk;
import yvl;
import yvm;
import yvn;
import yvo;
import yvp;
import yvx;

public class TroopRecommendFriendFragment
  extends IphoneTitleBarFragment
{
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private yvp<yva> jdField_a_of_type_Yvp;
  private final acnd b = new yvo(this);
  private int bXd;
  private acms c;
  private int cbs;
  private byte[] ct;
  private QQAppInterface mApp;
  private int mCurrentScrollState = 0;
  private View mLoadingView;
  private String mTroopUin;
  private ArrayList<Long> rp;
  
  private void VG()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Yvp);
    if (!aqiw.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.mLoadingView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696272), 0).show();
      return;
    }
    biW();
  }
  
  private void a(yvx paramyvx, yva paramyva, int paramInt)
  {
    if ((paramyvx == null) || (paramyva == null)) {}
    Object localObject;
    do
    {
      return;
      ((yuz)paramyvx).a = paramyva;
      localObject = (ImageView)paramyvx.getView(2131361802);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(aqdj.a(this.mApp, 1, paramyva.uin));
      }
      localObject = (TextView)paramyvx.getView(2131372384);
      if (localObject != null) {
        ((TextView)localObject).setText(paramyva.name);
      }
      localObject = (TextView)paramyvx.getView(2131371194);
      if (localObject != null) {
        ((TextView)localObject).setText(paramyva.reason);
      }
      localObject = (TroopLabelLayout)paramyvx.getView(2131380324);
      if (localObject != null) {
        ((TroopLabelLayout)localObject).a(paramyva.lables, paramyva.age, paramyva.gender, 1);
      }
      localObject = (Button)paramyvx.getView(2131377201);
      paramyvx = (TextView)paramyvx.getView(2131377211);
    } while ((localObject == null) || (paramyvx == null));
    String str = hQ(paramyva.uin);
    if (TextUtils.isEmpty(str))
    {
      paramyvx.setVisibility(8);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131721053);
      ((Button)localObject).setOnClickListener(new yvn(this, paramyva));
      return;
    }
    paramyvx.setVisibility(0);
    paramyvx.setText(str);
    ((Button)localObject).setVisibility(8);
  }
  
  private void ak(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "addFriend troopUin = " + paramString1 + ", memberUin =" + paramString2 + ", troopCode =" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    String str = aqgv.h(this.mApp, paramString1, paramString2);
    int i = this.bXd;
    paramString2 = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, paramString3, 3004, i, str, null, null, null, null);
    paramString2.putExtra("need_result_uin", true);
    paramString2.putExtra("troop_uin", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramString2, 11);
  }
  
  private void biW()
  {
    acms localacms;
    String str;
    int i;
    byte[] arrayOfByte;
    if (this.mTroopUin != null)
    {
      localacms = this.c;
      str = this.mTroopUin;
      i = this.cbs;
      arrayOfByte = this.ct;
      if (this.ct != null) {
        break label55;
      }
    }
    label55:
    for (ArrayList localArrayList = this.rp;; localArrayList = null)
    {
      localacms.a(str, 2, i, arrayOfByte, 50, localArrayList);
      return;
    }
  }
  
  private void bng()
  {
    if (this.ct != null) {
      biW();
    }
  }
  
  private String hQ(String paramString)
  {
    acff localacff = (acff)this.mApp.getManager(51);
    if (localacff.isFriend(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694021);
    }
    if (localacff.w(paramString, false)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131701841);
    }
    return null;
  }
  
  private void initAdapter()
  {
    this.jdField_a_of_type_Yvp = new yvl(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560124);
    this.jdField_a_of_type_Yvp.a(2131561721);
    this.jdField_a_of_type_Yvp.a(new yvm(this));
  }
  
  private void initUI(View paramView)
  {
    this.mLoadingView = paramView.findViewById(2131376898);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131380384));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new yvk(this));
  }
  
  public static void s(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.b.start(paramContext, paramIntent, PublicFragmentActivity.class, TroopRecommendFriendFragment.class);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mApp.addObserver(this.b);
    initUI(this.mContentView);
    initAdapter();
    VG();
  }
  
  public int getContentLayoutId()
  {
    return 2131560096;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.mApp = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.c = ((acms)this.mApp.getBusinessHandler(20));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.mTroopUin = paramBundle.getStringExtra("troopUin");
    this.cbs = paramBundle.getIntExtra("grayType", 0);
    this.bXd = paramBundle.getIntExtra("grayTypeSubId", 0);
    paramBundle = paramBundle.getSerializableExtra("grayUinList");
    if ((paramBundle instanceof ArrayList)) {
      this.rp = ((ArrayList)paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "onCreate mSubId " + this.bXd + " mTroopUin =" + this.mTroopUin + " mGrayTipType =" + this.cbs);
    }
    anot.a(this.mApp, "dc00898", "", "", "0X800AD50", "0X800AD50", 0, 0, "", "", "", "");
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689787));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.b);
    }
    this.mApp = null;
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Yvp != null) {
      this.jdField_a_of_type_Yvp.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */