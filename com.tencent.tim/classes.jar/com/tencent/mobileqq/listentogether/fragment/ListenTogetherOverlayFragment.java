package com.tencent.mobileqq.listentogether.fragment;

import aiob;
import aiog;
import aioh;
import aioi;
import aioj;
import aiok;
import aiol;
import aiom;
import aion;
import aioo;
import aiop;
import aioq;
import aior;
import aipd;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import anot;
import aqha;
import aqju;
import ausj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherOverlayFragment
  extends PublicBaseFragment
{
  private FragmentActivity activity;
  private QQAppInterface app;
  private boolean ckQ;
  private boolean ckR;
  aqju dialog;
  private ausj e;
  private int mType = -1;
  private int mUinType = -1;
  
  private void Qq()
  {
    if (this.e != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
    }
    aipd localaipd = ListenTogetherManager.a(this.app).a();
    this.e = ausj.b(this.activity);
    boolean bool = aiob.aph();
    if (bool) {
      this.e.addButton(2131695353);
    }
    this.e.addButton(2131695323);
    this.e.addCancelButton(2131721058);
    this.e.a(new aiog(this, localaipd));
    this.e.setOnCancelListener(new aiok(this, localaipd));
    this.e.a(new aiol(this, bool, localaipd));
    this.e.show();
    localaipd.Lm(true);
    anot.a(this.app, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
  }
  
  private void cgr()
  {
    if (this.e != null) {}
    while (this.ckR) {
      return;
    }
    this.ckR = false;
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.app);
    this.e = ausj.b(this.activity);
    this.e.addButton(2131717260);
    this.e.addButton(2131695370, 3);
    this.e.addCancelButton(2131721058);
    this.e.a(new aioo(this, localListenTogetherManager));
    this.e.setOnDismissListener(new aiop(this));
    this.e.show();
  }
  
  private void dti()
  {
    if (this.dialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    aipd localaipd;
    aqju localaqju;
    int j;
    if (this.mUinType == 1)
    {
      i = 1;
      localaipd = ListenTogetherManager.a(this.app).a();
      localaqju = aqha.a(this.activity, 230);
      if (i == 0) {
        break label146;
      }
      j = 2131695329;
      label62:
      this.dialog = localaqju.setMessage(j).setNegativeButton(2131721651, new aioi(this));
      localaqju = this.dialog;
      if (i == 0) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 2131695331;; i = 2131695330)
    {
      localaqju.setTitle(i);
      this.dialog.setOnDismissListener(new aioj(this, localaipd));
      this.dialog.setCanceledOnTouchOutside(false);
      this.dialog.show();
      localaipd.Lm(true);
      return;
      i = 0;
      break;
      j = 2131695328;
      break label62;
    }
  }
  
  private void lC()
  {
    if (this.dialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
    }
    this.dialog = aqha.a(this.activity, 230).setMessage(2131698085).setNegativeButton(2131721058, new aion(this)).setPositiveButton(2131698089, new aiom(this));
    this.dialog.setTitle(2131698087);
    this.dialog.setCancelable(false);
    this.dialog.setCanceledOnTouchOutside(false);
    this.dialog.show();
  }
  
  private void tZ()
  {
    if (this.dialog != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
    }
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a(this.app);
    aipd localaipd = localListenTogetherManager.a();
    this.dialog = aqha.a(this.activity, 230).setNegativeButton(2131721058, new aior(this, localListenTogetherManager, localaipd)).setPositiveButton(2131695369, new aioq(this, localListenTogetherManager, localaipd));
    this.dialog.setTitle(2131695327);
    this.dialog.setOnDismissListener(new aioh(this, localListenTogetherManager, localaipd));
    this.dialog.setCanceledOnTouchOutside(false);
    this.dialog.show();
    localaipd.Lm(true);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app = getActivity().app;
    this.activity = getActivity();
    paramBundle = this.activity.getIntent();
    if (paramBundle != null)
    {
      this.mType = paramBundle.getIntExtra("type", 0);
      this.mUinType = paramBundle.getIntExtra("uinType", -1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onDestroy");
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onResume mType: " + this.mType + " mHasGotoSetting:" + this.ckQ + " mUinType:" + this.mUinType);
    }
    if (this.mType == 1)
    {
      Qq();
      return;
    }
    if (this.mType == 2)
    {
      if (this.ckQ)
      {
        this.activity.finish();
        return;
      }
      lC();
      return;
    }
    if (this.mType == 3)
    {
      cgr();
      return;
    }
    if (this.mType == 4)
    {
      dti();
      return;
    }
    this.activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment
 * JD-Core Version:    0.7.0.1
 */