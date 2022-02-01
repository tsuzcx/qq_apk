package com.tencent.mobileqq.msgbackup.fragment;

import acfp;
import ajdt;
import ajee;
import ajfs;
import ajft;
import ajfu;
import ajgv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import aqha;
import aqju;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class MsgBackupPcBaseFragment
  extends MsgBackupBaseFragment
{
  public boolean cnI;
  public boolean cod;
  public String mExtraData;
  
  public static void aq(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_start", 5);
    localIntent.putExtra("BIZ_TYPE", paramInt);
    PublicFragmentActivity.start(paramContext, localIntent, MsgBackupPCTransportFragment.class);
  }
  
  private void bpM()
  {
    if ((getActivity() != null) && (this.a != null)) {
      getActivity().addObserver(this.a);
    }
  }
  
  private void removeObserver()
  {
    if ((getActivity() != null) && (this.a != null)) {
      getActivity().removeObserver(this.a);
    }
  }
  
  protected void aZv()
  {
    super.aZv();
    ajgv.b("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", new Object[] { Integer.valueOf(this.diy), Boolean.valueOf(this.cnI) });
  }
  
  protected void bindData()
  {
    super.bindData();
    bpM();
  }
  
  public void dwZ()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    Object localObject;
    do
    {
      return;
      localObject = acfp.m(2131708503);
      String str1 = acfp.m(2131708489);
      this.diy = ajdt.a().Gi();
      if (this.diy == 2) {
        localObject = acfp.m(2131708485);
      }
      if (this.diy == 2) {
        str1 = acfp.m(2131708491);
      }
      String str2 = acfp.m(2131708499);
      if (this.diy == 1) {
        str2 = acfp.m(2131708486);
      }
      localObject = aqha.b(localFragmentActivity, 0, (String)localObject, str2, localFragmentActivity.getString(2131690716), str1, new ajft(this), new ajfu(this));
    } while (localFragmentActivity.isFinishing());
    ((aqju)localObject).show();
  }
  
  public void dxc()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    String str2 = acfp.m(2131708484);
    this.diy = ajdt.a().Gi();
    String str1 = acfp.m(2131708500);
    if (this.diy == 1) {
      str1 = acfp.m(2131708490);
    }
    aqha.b(localFragmentActivity, 0, null, str1, null, str2, new ajfs(this), null).show();
  }
  
  public void dxd()
  {
    if (this.diy == 1) {
      MsgBackupCompleteFragment.b(getActivity(), this.mTotalCount, this.diq, this.cnI);
    }
    while (this.diy != 2) {
      return;
    }
    MsgBackupCompleteFragment.u(getActivity(), this.mTotalCount, this.diq);
  }
  
  protected void initTitle()
  {
    super.initTitle();
    setTitle(getActivity().getString(2131690706));
    if (ajdt.a().Gi() == 2) {
      setTitle(getActivity().getString(2131690703));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    boolean bool2 = true;
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        this.dix = paramActivity.getIntExtra("param_start", -1);
        this.diy = paramActivity.getIntExtra("BIZ_TYPE", 1);
        this.mExtraData = paramActivity.getStringExtra("0x11bpush_extra");
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "toPage = " + this.dix + "; mBizType = " + this.diy);
        }
      }
      bool1 = bool2;
      if (TextUtils.isEmpty(this.mExtraData)) {
        if (!ajee.cnI) {
          break label124;
        }
      }
    }
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cnI = bool1;
      return;
    }
  }
  
  protected void kJ()
  {
    super.kJ();
    this.gI.setOnClickListener(this);
    this.gJ.setOnClickListener(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "onDestroyView topage = " + this.dix + ", bizType = " + ajdt.a().Gi() + ", sIsShouQiBtnClick = " + ajee.cnG);
    }
    removeObserver();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
 * JD-Core Version:    0.7.0.1
 */