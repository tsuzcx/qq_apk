package com.tencent.mobileqq.fragment;

import aagv;
import abdn;
import adag;
import adah;
import ahmn;
import ahmo;
import ahmp;
import ahmq;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import aqgw;
import aqha;
import aqju;
import arhz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletItem.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AppletsSettingFragment
  extends IphoneTitleBarFragment
{
  private Switch F;
  private TextView Tp;
  private TextView Tq;
  private TextView Tr;
  public aagv a;
  private adah jdField_a_of_type_Adah = new ahmo(this);
  private aqgw jdField_a_of_type_Aqgw;
  private abdn jdField_b_of_type_Abdn;
  private AppletItem jdField_b_of_type_ComTencentMobileqqAppletsDataAppletItem;
  private a jdField_b_of_type_ComTencentMobileqqFragmentAppletsSettingFragment$a = new ahmp(this);
  private boolean chy;
  private Runnable fb = new AppletsSettingFragment.2(this);
  private View.OnClickListener fi = new ahmn(this);
  private RelativeLayout kA;
  private HashMap<String, AppletItem> ld = new HashMap();
  private XListView m;
  private QQAppInterface mApp;
  private arhz n;
  public aqju x;
  
  private void Ks(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AppletsSettingFragment", 2, "appletMainSwitchClick:  isChecked: " + paramBoolean);
    }
    this.F.setChecked(paramBoolean);
    adag localadag = (adag)this.mApp.getBusinessHandler(148);
    ArrayList localArrayList = new ArrayList();
    AppletItem localAppletItem = this.jdField_b_of_type_ComTencentMobileqqAppletsDataAppletItem;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localAppletItem.setValue(i);
      localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqAppletsDataAppletItem);
      localadag.dS(localArrayList);
      return;
    }
  }
  
  private void VG()
  {
    boolean bool2 = true;
    Object localObject = new AppletItem.a();
    ((AppletItem.a)localObject).a(1L);
    String str = this.jdField_a_of_type_Aagv.qw();
    int i;
    label69:
    boolean bool1;
    if (!TextUtils.isEmpty(str))
    {
      ((AppletItem.a)localObject).a(str);
      ((AppletItem.a)localObject).b(null);
      ((AppletItem.a)localObject).a(0);
      if (!this.jdField_a_of_type_Aagv.Wl()) {
        break label247;
      }
      i = 1;
      ((AppletItem.a)localObject).b(i);
      this.jdField_b_of_type_ComTencentMobileqqAppletsDataAppletItem = ((AppletItem.a)localObject).a();
      if (this.jdField_b_of_type_ComTencentMobileqqAppletsDataAppletItem.getValue() != 1) {
        break label252;
      }
      bool1 = true;
      label98:
      this.chy = bool1;
      this.Tp.setText(this.jdField_b_of_type_ComTencentMobileqqAppletsDataAppletItem.getName());
      localObject = this.F;
      if (this.jdField_b_of_type_ComTencentMobileqqAppletsDataAppletItem.getValue() != 1) {
        break label257;
      }
      bool1 = bool2;
      label136:
      ((Switch)localObject).setChecked(bool1);
      localObject = this.jdField_a_of_type_Aagv.qu();
      str = this.jdField_a_of_type_Aagv.qv();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label262;
      }
      this.Tq.setText((CharSequence)localObject);
      label177:
      if (TextUtils.isEmpty(str)) {
        break label281;
      }
      this.Tr.setText(str);
    }
    for (;;)
    {
      ((adag)this.mApp.getBusinessHandler(148)).cPu();
      kU(new ArrayList(this.ld.values()));
      return;
      ((AppletItem.a)localObject).a(getActivity().getString(2131690430));
      break;
      label247:
      i = 0;
      break label69;
      label252:
      bool1 = false;
      break label98;
      label257:
      bool1 = false;
      break label136;
      label262:
      this.Tq.setText(getActivity().getString(2131690434));
      break label177;
      label281:
      this.Tr.setText(getActivity().getString(2131690428));
    }
  }
  
  private String a(AppletItem paramAppletItem)
  {
    return paramAppletItem.getId() + "&" + paramAppletItem.getType();
  }
  
  private void doI()
  {
    Iterator localIterator = this.ld.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AppletItem localAppletItem = (AppletItem)((Map.Entry)localIterator.next()).getValue();
      if ((localAppletItem != null) && (localAppletItem.getValue() == 1)) {
        localIterator.remove();
      }
    }
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_Aqgw = new aqgw(Looper.getMainLooper(), null);
    if (this.leftView != null) {
      this.leftView.setText("");
    }
    this.m = ((XListView)this.mContentView.findViewById(2131362879));
    this.m.setDivider(null);
    this.m.setVerticalScrollBarEnabled(false);
    this.kA = ((RelativeLayout)this.mContentView.findViewById(2131362878));
    this.kA.setBackgroundResource(2130839682);
    this.Tp = ((TextView)this.mContentView.findViewById(2131362873));
    this.F = ((Switch)this.mContentView.findViewById(2131362872));
    this.Tq = ((TextView)this.mContentView.findViewById(2131362871));
    this.Tr = ((TextView)this.mContentView.findViewById(2131362870));
    this.Tr.setVisibility(8);
    this.F.setOnClickListener(this.fi);
    if (this.jdField_b_of_type_Abdn == null)
    {
      this.jdField_b_of_type_Abdn = new abdn(this.mApp, getActivity(), this.jdField_b_of_type_ComTencentMobileqqFragmentAppletsSettingFragment$a);
      this.m.setAdapter(this.jdField_b_of_type_Abdn);
    }
    if (this.n == null)
    {
      this.n = new arhz(getActivity(), getActivity().getTitleBarHeight());
      this.n.setMessage(2131690429);
      this.n.setCanceledOnTouchOutside(true);
    }
  }
  
  private void kU(List<AppletItem> paramList)
  {
    if (this.jdField_b_of_type_Abdn != null) {
      this.jdField_b_of_type_Abdn.cS(paramList);
    }
    if (this.Tr != null)
    {
      if ((paramList == null) || (paramList.size() < 1)) {
        this.Tr.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.Tr.setVisibility(0);
  }
  
  public void bFG()
  {
    if (this.x != null)
    {
      if (!this.x.isShowing()) {
        this.x.show();
      }
      return;
    }
    this.x = aqha.a(getActivity(), 230);
    Object localObject = this.jdField_a_of_type_Aagv.qu();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.x.setMessage((CharSequence)localObject);
    }
    for (;;)
    {
      localObject = new ahmq(this);
      this.x.setNegativeButton(2131721058, (DialogInterface.OnClickListener)localObject);
      this.x.setPositiveButton(2131691970, (DialogInterface.OnClickListener)localObject);
      this.x.show();
      return;
      this.x.setMessage(2131690434);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)getActivity().getAppRuntime());
    }
    this.mApp.addObserver(this.jdField_a_of_type_Adah);
    this.jdField_a_of_type_Aagv = ((aagv)this.mApp.getManager(315));
    initUI();
    VG();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561661;
  }
  
  public void oh(int paramInt)
  {
    Toast.makeText(getActivity().getApplicationContext(), paramInt, 0).show();
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131690433));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aqgw != null) {
      this.jdField_a_of_type_Aqgw.removeCallbacks(this.fb);
    }
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_a_of_type_Adah);
    }
    this.mApp = null;
    super.onDestroy();
  }
  
  public void showProgressBar(boolean paramBoolean)
  {
    if (this.n != null)
    {
      if ((!paramBoolean) || (this.n.isShowing())) {
        break label44;
      }
      this.n.show();
      this.jdField_a_of_type_Aqgw.postDelayed(this.fb, 500L);
    }
    label44:
    while ((paramBoolean) || (!this.n.isShowing())) {
      return;
    }
    this.n.dismiss();
  }
  
  public static abstract interface a
  {
    public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean, AppletItem paramAppletItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.AppletsSettingFragment
 * JD-Core Version:    0.7.0.1
 */