package com.tencent.tim.activity.profile.host;

import accv;
import accv.b;
import acfp;
import ajos;
import alcn;
import aldd;
import amhj;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anlm;
import aqbn;
import aqdj;
import aqek;
import aqep;
import aqhu;
import aqiw;
import aqmj;
import arhz;
import atbe;
import atbg;
import atbo;
import atcb;
import atcc;
import atcd;
import atce;
import atcf;
import atcg;
import atch;
import atcj;
import atck;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.activity.profile.BaseProfileFragment;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class HostProfileFragment
  extends BaseProfileFragment
{
  public arhz I = null;
  private long Lo;
  private accv.b jdField_a_of_type_Accv$b = new atcg(this);
  accv jdField_a_of_type_Accv;
  private atbg jdField_a_of_type_Atbg;
  public boolean aWO = false;
  public int bHl = 0;
  private AtomicBoolean bQ = new AtomicBoolean(false);
  private AtomicBoolean bR = new AtomicBoolean(false);
  private String bas;
  private IphonePickerView jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private RichStatus jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus;
  private ausj mActionSheet;
  arhz u = null;
  private Uri x;
  
  private void AX(int paramInt)
  {
    int i = this.jdField_a_of_type_Accv.Ai();
    if (i != 0)
    {
      i = this.jdField_a_of_type_Accv.q(i, true);
      if (QLog.isColorLevel()) {
        QLog.d("HostProfileFragment", 2, "startLocationSelectActivity | update result = " + i);
      }
      if (i == 2)
      {
        QQToast.a(getActivity(), 2131696272, 0).show(getActivity().getTitleBarHeight());
        return;
      }
      if (i == 0)
      {
        bg(paramInt, getString(2131691966));
        this.jdField_a_of_type_Accv.addListener(this.jdField_a_of_type_Accv$b);
        return;
      }
      bg(paramInt, getString(2131691966));
      ThreadManager.getUIHandler().postDelayed(new HostProfileFragment.5(this), 20000L);
      return;
    }
    String[] arrayOfString;
    if (paramInt == 1)
    {
      i = 2;
      arrayOfString = i(paramInt);
      if ((arrayOfString != null) && (arrayOfString.length == 4)) {
        break label272;
      }
      arrayOfString = new String[] { "0", "0", "0", "0" };
    }
    label272:
    for (;;)
    {
      Intent localIntent = new Intent(getActivity(), LocationSelectActivity.class);
      localIntent.putExtra("param_is_popup", false);
      localIntent.putExtra("param_req_type", i);
      localIntent.putExtra("param_location", arrayOfString);
      localIntent.putExtra("param_location_param", this.jdField_a_of_type_Accv.e(arrayOfString));
      if (paramInt == 1) {}
      for (paramInt = 1005;; paramInt = 1006)
      {
        startActivityForResult(localIntent, paramInt);
        return;
        i = 3;
        break;
      }
    }
  }
  
  private void CA()
  {
    if ((this.u != null) && (this.u.isShowing())) {
      this.u.dismiss();
    }
  }
  
  private boolean VG()
  {
    int i = 0;
    boolean bool;
    if (TextUtils.isEmpty(this.bas)) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HostProfileFragment", 2, "isNeedShowHDHead, result=" + bool + ", hdHeadUrl=" + this.bas + ",openflag=" + i);
      }
      this.bR.set(bool);
      return bool;
      String[] arrayOfString = DeviceProfileManager.b().aJ(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1|0").split("\\|");
      if (arrayOfString.length > 3)
      {
        i = Integer.parseInt(arrayOfString[3]);
        if (i == 0) {
          bool = false;
        }
      }
      else
      {
        bool = false;
        continue;
      }
      bool = true;
    }
  }
  
  private boolean b(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool = true;
    if (paramArrayOfString1 == paramArrayOfString2) {}
    for (;;)
    {
      return bool;
      try
      {
        int i;
        if (paramArrayOfString1.length == paramArrayOfString2.length) {
          i = 0;
        }
        for (;;)
        {
          if ((i >= paramArrayOfString1.length) || (!paramArrayOfString1[i].equals(paramArrayOfString2[i])))
          {
            int j = paramArrayOfString1.length;
            if (i == j) {
              break;
            }
            bool = false;
            break;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramArrayOfString1)
      {
        QLog.d("HostProfileFragment", 1, paramArrayOfString1, new Object[0]);
      }
    }
  }
  
  private void bPj()
  {
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.addButton(2131697186, 0);
    localausj.addButton(2131697188, 0);
    localausj.addButton(2131697187, 0);
    localausj.addCancelButton(2131691246);
    localausj.a(new atcc(this, localausj));
    localausj.show();
  }
  
  private void bPk()
  {
    if (this.jdField_a_of_type_Atbo.PI())
    {
      if (this.I == null)
      {
        this.I = new arhz(getActivity(), getActivity().getTitleBarHeight());
        this.I.setMessage(acfp.m(2131706586));
      }
      if (this.aWO)
      {
        this.I.dismiss();
        if (!getActivity().isFinishing()) {
          getActivity().finish();
        }
      }
    }
    while (getActivity().isFinishing())
    {
      do
      {
        do
        {
          return;
          if (aqiw.isNetSupport(getActivity())) {
            break;
          }
          cf(2131696272, 0);
        } while (getActivity().isFinishing());
        getActivity().finish();
        return;
        if (this.jdField_a_of_type_Atbo.a(this.jdField_a_of_type_Accv))
        {
          this.aWO = true;
          this.I.show();
          return;
        }
      } while (getActivity().isFinishing());
      getActivity().finish();
      return;
    }
    getActivity().finish();
  }
  
  private void bPn()
  {
    if (this.mActionSheet == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getActivity().getLayoutInflater().inflate(2131561390, null));
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new atce(this));
      this.mActionSheet = ausj.d(getActivity());
      this.mActionSheet.setCloseAutoRead(true);
      this.mActionSheet.setActionContentView(this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.mActionSheet.findViewById(2131362014);
      ((DispatchActionMoveScrollView)localObject).cZW = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      localObject = this.mActionSheet.getWindow();
      if (localObject != null) {
        ((Window)localObject).setFlags(16777216, 16777216);
      }
      this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new atcf(this));
    }
    byte b2 = this.jdField_a_of_type_Atbo.j();
    byte b1 = b2;
    if (b2 != 0)
    {
      b1 = b2;
      if (b2 != 1) {
        b1 = 0;
      }
    }
    m(b1);
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    if (b1 != 1) {}
    for (int i = 0;; i = 1)
    {
      ((IphonePickerView)localObject).setSelection(0, i);
      try
      {
        this.mActionSheet.show();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("HostProfileFragment", 1, localException, new Object[0]);
      }
    }
  }
  
  private void bg(int paramInt, String paramString)
  {
    this.bHl = paramInt;
    if (this.u == null) {
      this.u = new arhz(getActivity(), getActivity().getTitleBarHeight());
    }
    this.u.setMessage(paramString);
    this.u.show();
  }
  
  private void cqL()
  {
    ThreadManager.excute(new HostProfileFragment.9(this), 64, null, true);
  }
  
  private void cqS()
  {
    Intent localIntent = new Intent();
    int i = aqep.w(getActivity());
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("fromWhereClick", 11);
    PhotoUtils.a(localIntent, getActivity(), PublicFragmentActivity.class.getName(), i, i, 1080, 1080, aqep.BR());
  }
  
  private void cqT()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        getActivity().requestPermissions(new atcj(this), 0, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      cqS();
      return;
    }
    cqS();
  }
  
  private String[] i(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = (String[])this.jdField_a_of_type_Atbo.a(2, [Ljava.lang.String.class);
      if ((localObject == null) || (localObject.length <= 0)) {}
    }
    String[] arrayOfString;
    do
    {
      return localObject;
      return this.jdField_a_of_type_Atbo.H();
      if (paramInt != 2) {
        break label78;
      }
      arrayOfString = (String[])this.jdField_a_of_type_Atbo.a(3, [Ljava.lang.String.class);
      if (arrayOfString == null) {
        break;
      }
      localObject = arrayOfString;
    } while (arrayOfString.length > 0);
    return this.jdField_a_of_type_Atbo.T();
    label78:
    return null;
  }
  
  private void vC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HostProfileFragment", 2, "gotoSchoolWeb " + paramString);
    }
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    startActivityForResult(localIntent, 1012);
  }
  
  private void zC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HostProfileFragment", 2, "initHDHeadUrl: uin=" + paramString);
    }
    Setting localSetting = this.app.b(paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      String str = QQHeadDownloadHandler.a(localSetting.url, localSetting.bFaceFlags);
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        paramString = MsfSdkUtils.insertMtype("QQHeadIcon", str);
      }
      this.Lo = localSetting.headImgTimestamp;
      ThreadManager.getUIHandler().post(new HostProfileFragment.10(this, paramString));
      return;
    }
    this.app.EH(paramString);
  }
  
  private void zD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HostProfileFragment", 2, "onGetHDHeadUrl: url=" + paramString);
    }
    this.bas = paramString;
    if (VG())
    {
      paramString = aqdj.a(this.app, 1, this.jdField_a_of_type_Alcn.e.uin);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.EH.getWidth();
      localURLDrawableOptions.mRequestHeight = this.EH.getHeight();
      localURLDrawableOptions.mFailedDrawable = paramString;
      localURLDrawableOptions.mLoadingDrawable = paramString;
      if (this.bQ.get())
      {
        if ((this.EH.getDrawable() instanceof BitmapDrawable)) {
          localURLDrawableOptions.mLoadingDrawable = this.EH.getDrawable();
        }
        this.bQ.set(false);
      }
      this.bas = (this.bas + "?" + this.Lo);
      URLDrawable.removeMemoryCacheByUrl(this.bas, localURLDrawableOptions);
      paramString = URLDrawable.getDrawable(this.bas, localURLDrawableOptions);
      if (anlm.ayn())
      {
        paramString.setDecodeHandler(aqbn.a);
        paramString.setTag(new int[] { 640, 640, (int)(640.0F * aqhu.AE) });
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HostProfileFragment", 2, "onGetHDHeadUrl: newDisplayHDHead");
        }
        this.EH.setImageDrawable(paramString);
        return;
        paramString.setDecodeHandler(aqbn.b);
        paramString.setTag(new int[] { 640, 640 });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HostProfileFragment", 2, "onGetHDHeadUrl: oldDisplayHead");
    }
    wd(this.jdField_a_of_type_Alcn.e.uin);
  }
  
  protected void AW(int paramInt)
  {
    if (aqek.ay(paramInt)) {}
    for (this.bHo = paramInt;; this.bHo = -1)
    {
      String str2 = aqek.ga(paramInt);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        this.bHo = -1;
        str1 = getString(2131697271);
      }
      this.jdField_a_of_type_Atbo.d(4, str1, Integer.valueOf(paramInt));
      return;
    }
  }
  
  public void Bm(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.Pb.setVisibility(0);
      p(this.Pb, paramString);
      return;
    }
    this.Pb.setVisibility(8);
  }
  
  public void Qq()
  {
    int i = aqmj.aO(getActivity(), this.app.getCurrentAccountUin());
    Object localObject = (ausj)auss.a(getActivity(), null);
    String[] arrayOfString = super.getResources().getStringArray(2130968638);
    ((ausj)localObject).addButton(arrayOfString[24]);
    ((ausj)localObject).addButton(arrayOfString[13]);
    ((ausj)localObject).addButton(arrayOfString[23]);
    ((ausj)localObject).addCancelButton(arrayOfString[16]);
    ((ausj)localObject).a(new atch(this, (ausj)localObject));
    try
    {
      if (!getActivity().isFinishing())
      {
        ((ausj)localObject).show();
        localObject = ((ausj)localObject).findViewById(0);
        if (localObject != null) {
          ((View)localObject).setContentDescription(acfp.m(2131702995));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "showActionSheet, historyHeadNumFlag=" + i);
    }
  }
  
  public void YE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      p(this.mNickName, paramString);
    }
  }
  
  public void a(atbe paramatbe)
  {
    super.a(paramatbe);
    switch (paramatbe.id)
    {
    }
    do
    {
      return;
      paramatbe = new Intent(getActivity(), AgeSelectionActivity.class);
      paramatbe.putExtra("param_birthday", this.jdField_a_of_type_Atbo.Of());
      startActivityForResult(paramatbe, 1003);
      return;
      paramatbe = new Intent(getActivity(), JobSelectionActivity.class);
      paramatbe.putExtra("param_id", this.bHo);
      startActivityForResult(paramatbe, 1004);
      return;
      AX(1);
      return;
      AX(2);
      return;
      bPn();
      return;
      paramatbe = this.jdField_a_of_type_Atbo.EK();
      d(getString(2131695599), paramatbe, 50, 5, 1038);
      return;
      paramatbe = this.jdField_a_of_type_Atbo.EL();
      d(getString(2131697196), paramatbe, 120, 6, 1039);
      return;
      bPj();
      return;
    } while (!(paramatbe.fO instanceof aldd));
    paramatbe = (aldd)paramatbe.fO;
    vC(String.format(Locale.getDefault(), "https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(paramatbe.dsa), Integer.valueOf(paramatbe.drZ) }));
  }
  
  protected void ak(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (atcb)this.jdField_a_of_type_Atbo.a(0, atcb.class);
    int i;
    if (localObject == null) {
      if (paramInt1 != this.jdField_a_of_type_Atbo.Oe()) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = getString(2131697180);
        if (paramInt1 != 0) {
          localObject = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
        }
        atcb localatcb = null;
        if (paramInt1 != this.jdField_a_of_type_Atbo.Oe()) {
          localatcb = new atcb(paramInt1, paramInt2, paramInt3);
        }
        this.jdField_a_of_type_Atbo.d(0, (String)localObject, localatcb);
      }
      return;
      i = 0;
      continue;
      if (((atcb)localObject).birthday != paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void biN()
  {
    this.jdField_a_of_type_Atbo = ((atbo)ajos.a(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment).get(atck.class));
  }
  
  public void esT()
  {
    super.esT();
    ajos.a(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment, this.jdField_a_of_type_Atbo.G, new atcd(this));
  }
  
  public void esU()
  {
    bPk();
  }
  
  public void esV()
  {
    if (aqep.aBY())
    {
      QQToast.a(getActivity(), 1, 2131721613, 0).show(getActivity().getTitleBarHeight());
      return;
    }
    Qq();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    DynamicAvatarRecordActivity.c(getActivity(), 1, 1);
  }
  
  public void initView()
  {
    super.initView();
    this.mHeaderView.findViewById(2131369730).setVisibility(0);
    this.Pb.setOnClickListener(this);
  }
  
  public void m(byte paramByte)
  {
    int i = 0;
    Object localObject = (Byte)this.jdField_a_of_type_Atbo.a(1, Byte.class);
    if (localObject == null) {
      if (paramByte != this.jdField_a_of_type_Atbo.i())
      {
        i = 1;
        if (i != 0)
        {
          localObject = getString(2131697279);
          if (paramByte != 0) {
            break label108;
          }
          localObject = getString(2131695654);
        }
      }
    }
    for (;;)
    {
      Byte localByte = null;
      if (paramByte != this.jdField_a_of_type_Atbo.Oe()) {
        localByte = Byte.valueOf(paramByte);
      }
      this.jdField_a_of_type_Atbo.d(1, (String)localObject, localByte);
      return;
      i = 0;
      break;
      if (paramByte != ((Byte)localObject).byteValue()) {
        i = 1;
      }
      break;
      label108:
      if (paramByte == 1) {
        localObject = getString(2131693477);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1002) {
      if (paramInt2 != 1001) {
        this.jdField_a_of_type_Atbo.esY();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            String[] arrayOfString;
            do
            {
              do
              {
                Object localObject1;
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            if (paramInt1 == 1012)
                            {
                              if (QLog.isDevelopLevel()) {
                                QLog.d("HostProfileFragment", 2, "doOnActivityResult school web");
                              }
                              ((atck)this.jdField_a_of_type_Atbo).etc();
                              return;
                            }
                          } while (paramInt2 != -1);
                          if (paramInt1 == 5)
                          {
                            paramIntent = this.x;
                            paramIntent = aqhu.getRealPathFromContentURI(getActivity(), paramIntent);
                            paramInt1 = aqep.w(getActivity());
                            localObject1 = new Intent();
                            ((Intent)localObject1).putExtra("Business_Origin", 100);
                            ((Intent)localObject1).putExtra("BUSINESS_ORIGIN_NEW", 100);
                            ((Intent)localObject1).putExtra("fromWhereClick", 10);
                            ((Intent)localObject1).putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
                            PhotoUtils.a((Intent)localObject1, getActivity(), PublicFragmentActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, aqep.BR());
                            return;
                          }
                          if (paramInt1 != 1003) {
                            break;
                          }
                        } while (paramIntent == null);
                        ak(paramIntent.getShortExtra("param_year", (short)1990) << 16 | paramIntent.getByteExtra("param_month", (byte)1) << 8 | paramIntent.getByteExtra("param_day", (byte)1), paramIntent.getIntExtra("param_age", 0), paramIntent.getIntExtra("param_constellation_id", 0));
                        return;
                        if (paramInt1 != 1004) {
                          break;
                        }
                      } while (paramIntent == null);
                      paramInt1 = paramIntent.getIntExtra("param_id", -1);
                    } while (paramInt1 == this.bHo);
                    AW(paramInt1);
                    return;
                    if (paramInt1 != 1005) {
                      break;
                    }
                  } while (paramIntent == null);
                  arrayOfString = paramIntent.getStringArrayExtra("param_location");
                  paramIntent = i(1);
                } while ((paramIntent == null) || (b(paramIntent, arrayOfString)));
                paramIntent = null;
                try
                {
                  localObject1 = this.jdField_a_of_type_Accv.d(arrayOfString);
                  paramIntent = (Intent)localObject1;
                }
                catch (Exception localException1)
                {
                  for (;;)
                  {
                    QLog.d("HostProfileFragment", 1, localException1, new Object[0]);
                  }
                }
                if (!TextUtils.isEmpty(paramIntent))
                {
                  localObject1 = paramIntent;
                  if (!"不限".equals(paramIntent)) {}
                }
                else
                {
                  localObject1 = "";
                }
                p((String)localObject1, arrayOfString);
                return;
                if (paramInt1 != 1006) {
                  break;
                }
              } while (paramIntent == null);
              arrayOfString = paramIntent.getStringArrayExtra("param_location");
              paramIntent = i(2);
            } while ((paramIntent == null) || (b(paramIntent, arrayOfString)));
            paramIntent = null;
            try
            {
              localObject2 = this.jdField_a_of_type_Accv.d(arrayOfString);
              paramIntent = (Intent)localObject2;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Object localObject2;
                QLog.d("HostProfileFragment", 1, localException2, new Object[0]);
              }
            }
            if (!TextUtils.isEmpty(paramIntent))
            {
              localObject2 = paramIntent;
              if (!"不限".equals(paramIntent)) {}
            }
            else
            {
              localObject2 = "";
            }
            q((String)localObject2, arrayOfString);
            return;
            if (paramInt1 != 1038) {
              break;
            }
          } while (paramIntent == null);
          paramIntent = paramIntent.getStringExtra("result");
        } while (paramIntent == null);
        vI(paramIntent);
        return;
      } while ((paramInt1 != 1039) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("result");
    } while (paramIntent == null);
    vE(paramIntent);
  }
  
  public boolean onBackEvent()
  {
    bPk();
    return true;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("from_type", 4);
      SignTextEditFragment.a(getActivity(), this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus, "", localBundle, -1);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Accv = ((accv)this.app.getManager(59));
    this.jdField_a_of_type_Accv.aV(this);
    paramBundle = (amhj)this.app.getManager(15);
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus = paramBundle.a(false);
    if ((this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus == null) || (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.isEmpty())) {
      ThreadManager.getFileThreadHandler().post(new HostProfileFragment.1(this, paramBundle));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Accv != null)
    {
      this.jdField_a_of_type_Accv.aW(this);
      this.jdField_a_of_type_Accv.removeListener(this.jdField_a_of_type_Accv$b);
      this.jdField_a_of_type_Accv = null;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (str != null)
    {
      if (aqep.a(this.app, str, paramIntent)) {
        cqL();
      }
    }
    else {
      return;
    }
    QQToast.a(getActivity(), 1, 2131719573, 0).show(getActivity().getTitleBarHeight());
  }
  
  protected void p(TextView paramTextView, String paramString)
  {
    if ((paramTextView instanceof EllipsizeWithImageSpanTextView))
    {
      if (this.jdField_a_of_type_Atbg == null) {
        this.jdField_a_of_type_Atbg = new atbg();
      }
      paramTextView.post(new HostProfileFragment.2(this, paramTextView, paramString));
      return;
    }
    paramTextView.setText(paramString);
  }
  
  protected void p(String paramString, String[] paramArrayOfString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str = getString(2131697241);
    }
    this.jdField_a_of_type_Atbo.d(2, str, paramArrayOfString);
  }
  
  protected void q(String paramString, String[] paramArrayOfString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str = getString(2131697237);
    }
    this.jdField_a_of_type_Atbo.d(3, str, paramArrayOfString);
  }
  
  protected void vE(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = BaseApplicationImpl.getContext().getString(2131697195);; str = paramString)
    {
      this.jdField_a_of_type_Atbo.d(5, str, paramString);
      return;
    }
  }
  
  protected void vI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = BaseApplicationImpl.getContext().getString(2131697228);; str = paramString)
    {
      this.jdField_a_of_type_Atbo.d(6, str, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.host.HostProfileFragment
 * JD-Core Version:    0.7.0.1
 */