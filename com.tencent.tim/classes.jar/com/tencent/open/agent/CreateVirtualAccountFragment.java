package com.tencent.open.agent;

import acfp;
import aelq;
import aelq.a;
import aelq.b;
import aelr;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import aqhu;
import arhz;
import arqk;
import arql;
import arqn;
import artd;
import asbh;
import ausj;
import auss;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;
import zti;

public class CreateVirtualAccountFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener
{
  private static String cBK = "1001_0cab6b944b59d75644e53b70de2f5d5a";
  private View JS;
  private View JT;
  private View JU;
  private View JV;
  private View JW;
  private List<aelq.b> Jz;
  private final String TAG = "CreateVirtualAccountFragment";
  private artd jdField_a_of_type_Artd = new arqn(this);
  private asbh jdField_a_of_type_Asbh;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private long awm;
  private long awn;
  private EditText bE;
  private String cBL;
  private URLImageView cd;
  private final int dXy = 1000;
  boolean dcR;
  private int ekL;
  private ImmersiveTitleBar2 j;
  protected arhz mProgress;
  SystemBarCompact mSystemBarComp;
  public Uri x;
  
  private void WT(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new CreateVirtualAccountFragment.5(this, paramString));
  }
  
  private void b(URLImageView paramURLImageView, String paramString)
  {
    if (paramURLImageView == null) {}
    for (;;)
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = null;
      try
      {
        localObject = getResources().getDrawable(2130851638);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString != null)
        {
          if (paramString.getStatus() == 2)
          {
            QLog.d("CreateVirtualAccountFragment", 1, "setVirtualIcon restartDownload");
            paramString.restartDownload();
          }
          if (paramString.getStatus() != 2)
          {
            paramURLImageView.setImageDrawable(paramString);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject = localURLDrawableOptions;
          if (QLog.isColorLevel())
          {
            QLog.e("CreateVirtualAccountFragment", 1, "-->create color drawable oom.", localOutOfMemoryError);
            localObject = localURLDrawableOptions;
          }
        }
        QLog.d("CreateVirtualAccountFragment", 1, "getStatus OTHERS: ");
      }
    }
  }
  
  private void dv(String paramString, boolean paramBoolean)
  {
    if (getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "showToast activity is null");
      return;
    }
    getActivity().runOnUiThread(new CreateVirtualAccountFragment.3(this, paramBoolean, paramString));
  }
  
  private void elf()
  {
    if ((this.Jz == null) || (this.Jz.size() == 0))
    {
      dv(acfp.m(2131704524), false);
      QLog.d("CreateVirtualAccountFragment", 1, "randomInfo config is null");
      return;
    }
    int i = this.ekL;
    int k = this.Jz.size();
    aelq.b localb = (aelq.b)this.Jz.get(i % k);
    if (localb == null)
    {
      QLog.d("CreateVirtualAccountFragment", 1, " current randomInfo is null");
      return;
    }
    this.bE.setText(localb.nickName);
    if (!TextUtils.isEmpty(localb.bzx))
    {
      this.cBL = localb.bzx;
      b(this.cd, localb.bzx);
    }
    this.ekL += 1;
  }
  
  private String qw(String paramString)
  {
    Iterator localIterator = this.Jz.iterator();
    while (localIterator.hasNext())
    {
      aelq.b localb = (aelq.b)localIterator.next();
      if (TextUtils.equals(localb.bzx, paramString)) {
        return localb.bzw;
      }
    }
    return "";
  }
  
  private void showLoading()
  {
    if (this.mProgress != null)
    {
      if (this.mProgress.isShowing()) {
        return;
      }
      this.mProgress.show();
      return;
    }
    this.mProgress = new arhz(getActivity(), 0, 2131561630, 17);
    this.mProgress.setHeightParams(-1);
    this.mProgress.show();
  }
  
  private boolean sn(String paramString)
  {
    if (this.Jz == null) {
      return false;
    }
    Iterator localIterator = this.Jz.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((aelq.b)localIterator.next()).bzx, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void Qq()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    String[] arrayOfString = super.getResources().getStringArray(2130968638);
    localausj.addButton(arrayOfString[24]);
    localausj.addButton(arrayOfString[13]);
    localausj.addCancelButton(arrayOfString[16]);
    localausj.a(new arql(this, localausj));
    try
    {
      if (!getActivity().isFinishing()) {
        localausj.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() == 0))
    {
      this.JU.setEnabled(false);
      return;
    }
    this.JU.setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void hideSoftInput()
  {
    if (getActivity() == null) {
      QLog.e("CreateVirtualAccountFragment", 1, "hideSoftInput activity is null");
    }
    do
    {
      InputMethodManager localInputMethodManager;
      do
      {
        do
        {
          return;
        } while (this.bE == null);
        this.bE.clearFocus();
        this.bE.setCursorVisible(false);
        localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
      } while (localInputMethodManager == null);
      localInputMethodManager.hideSoftInputFromWindow(this.bE.getWindowToken(), 0);
    } while (!QLog.isColorLevel());
    QLog.d("CreateVirtualAccountFragment", 2, new Object[] { "hideSoftInput, ", this.bE.getWindowToken() });
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void jf()
  {
    if (getActivity() == null) {
      QLog.e("CreateVirtualAccountFragment", 1, "dismissDialogProgress activity is null");
    }
    while ((getActivity().isFinishing()) || (this.mProgress == null) || (!this.mProgress.isShowing())) {
      return;
    }
    try
    {
      this.mProgress.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    QLog.d("CreateVirtualAccountFragment", 2, "doOnActivity result ====");
    jf();
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
      paramIntent = this.x;
      paramIntent = aqhu.getRealPathFromContentURI(getActivity(), paramIntent);
    } while (TextUtils.isEmpty(paramIntent));
    zti.l(getActivity(), paramIntent, 103);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.JU) && (System.currentTimeMillis() - this.awm > 1000L))
    {
      this.awm = System.currentTimeMillis();
      if (TextUtils.isEmpty(this.bE.getText())) {
        dv(acfp.m(2131704521), false);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      hideSoftInput();
      String str = this.bE.getText().toString();
      if (TextUtils.isEmpty(this.cBL))
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + cBK);
        showLoading();
        this.jdField_a_of_type_Asbh.a(this.awn, str, cBK, this.jdField_a_of_type_Artd);
      }
      else if (sn(this.cBL))
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + qw(this.cBL));
        showLoading();
        this.jdField_a_of_type_Asbh.a(this.awn, str, qw(this.cBL), this.jdField_a_of_type_Artd);
      }
      else
      {
        showLoading();
        QLog.d("CreateVirtualAccountFragment", 2, "========> doUploadAvatarAndCreateVirtualAccount localPath = " + this.cBL);
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(String.valueOf(this.awn), this.cBL, this.jdField_a_of_type_Artd);
        continue;
        if (paramView == this.JV)
        {
          hideSoftInput();
          elf();
        }
        else if (paramView == this.JS)
        {
          Qq();
        }
        else if (paramView == this.JW)
        {
          if (getActivity() != null) {
            getActivity().finish();
          }
          onBackEvent();
        }
        else if (paramView == this.bE)
        {
          showSoftInput();
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559876, paramViewGroup, false);
    if (QLog.isColorLevel()) {
      QLog.d("CreateVirtualAccountFragment", 2, "-->onCreate--");
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.JW = paramLayoutInflater.findViewById(2131363226);
    this.JS = paramLayoutInflater.findViewById(2131368712);
    this.JT = paramLayoutInflater.findViewById(2131372196);
    this.JV = paramLayoutInflater.findViewById(2131376605);
    this.JU = paramLayoutInflater.findViewById(2131377645);
    this.cd = ((URLImageView)paramLayoutInflater.findViewById(2131382041));
    this.bE = ((EditText)paramLayoutInflater.findViewById(2131382045));
    this.bE.addTextChangedListener(this);
    this.j = ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131379866));
    this.j.setBackgroundColor(0);
    this.JW.setOnClickListener(this);
    this.JU.setOnClickListener(this);
    this.JS.setOnClickListener(this);
    this.JV.setOnClickListener(this);
    this.bE.setOnClickListener(this);
    this.jdField_a_of_type_Asbh = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    paramViewGroup = aelr.b(466);
    if ((paramViewGroup != null) && (paramViewGroup.a() != null))
    {
      this.Jz = paramViewGroup.a().list;
      if ((this.Jz != null) && (this.Jz.size() > 0)) {
        this.ekL = Math.abs(new Random().nextInt(this.Jz.size()));
      }
    }
    this.mProgress = new arhz(getActivity(), 0, 2131561630, 17);
    this.mProgress.setHeightParams(-1);
    paramViewGroup = getActivity().getIntent();
    try
    {
      this.awn = Long.parseLong(paramViewGroup.getStringExtra("appid"));
      QLog.d("CreateVirtualAccountFragment", 1, new Object[] { "========> init appid = ", Long.valueOf(this.awn), ", mRandIndex=", Integer.valueOf(this.ekL) });
      this.bE.setFilters(new InputFilter[] { new arqk(this) });
      this.bE.postDelayed(new CreateVirtualAccountFragment.2(this), 300L);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        QLog.d("CreateVirtualAccountFragment", 1, "parse exception = ", paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Artd = null;
    this.jdField_a_of_type_Asbh = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    jf();
    QLog.d("CreateVirtualAccountFragment", 2, "doOnNewIntent====");
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (paramIntent != null) {
      WT(paramIntent);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("CreateVirtualAccountFragment", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    }
    if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
      ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      if (!this.dcR) {
        break;
      }
      return;
      ImmersiveUtils.l(getActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mSystemBarComp = new SystemBarCompact(getActivity(), true, getResources().getColor(2131167654));
      this.mSystemBarComp.setStatusBarColor(getResources().getColor(2131167654));
      this.mSystemBarComp.init();
    }
    this.dcR = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void showSoftInput()
  {
    if (getActivity() == null) {
      QLog.e("CreateVirtualAccountFragment", 1, "showSoftInput activity is null");
    }
    do
    {
      InputMethodManager localInputMethodManager;
      do
      {
        do
        {
          return;
        } while (this.bE == null);
        this.bE.setFocusable(true);
        this.bE.setFocusableInTouchMode(true);
        this.bE.setCursorVisible(true);
        this.bE.requestFocus();
        localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
      } while (localInputMethodManager == null);
      localInputMethodManager.showSoftInput(this.bE, 0);
    } while (!QLog.isColorLevel());
    QLog.d("CreateVirtualAccountFragment", 2, new Object[] { "hideSoftInput, ", this.bE.getWindowToken() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment
 * JD-Core Version:    0.7.0.1
 */