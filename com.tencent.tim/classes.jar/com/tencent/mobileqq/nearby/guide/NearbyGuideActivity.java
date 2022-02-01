package com.tencent.mobileqq.nearby.guide;

import acbn;
import acfp;
import ajqo;
import ajrb;
import ajrk;
import ajrs;
import ajrw;
import ajub;
import ajuc;
import ajud;
import ajue;
import ajuf;
import ajug;
import ajuh;
import akyj;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anot;
import aomd;
import aooi;
import aook;
import aool;
import aqdj;
import aqdj.a;
import aqfy;
import aqha;
import aqiw;
import aqmr;
import arhz;
import aurd;
import ausj;
import auss;
import avpw;
import avpw.d;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.widget.MonitorSizeChangeRelativeLayout;
import com.tencent.mobileqq.widget.MonitorSizeChangeRelativeLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class NearbyGuideActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, Animation.AnimationListener, TextView.OnEditorActionListener, aqdj.a, MonitorSizeChangeRelativeLayout.a
{
  ImageView Bl;
  View EN;
  View EO;
  View EP;
  TextView UZ;
  ajrw jdField_a_of_type_Ajrw = new ajue(this);
  arhz jdField_a_of_type_Arhz;
  MonitorSizeChangeRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout;
  Animation aG;
  Animation aH;
  Animation aI;
  Animation aJ;
  Animation aK;
  Intent ai;
  public Dialog av = null;
  ajrw jdField_b_of_type_Ajrw = new ajud(this);
  CustomImgView jdField_b_of_type_ComTencentWidgetCustomImgView;
  public String bSu;
  String bSv;
  EditText bj;
  public ajrs c;
  boolean cqj = false;
  boolean cqk = false;
  boolean cql = false;
  int dla = 0;
  Button gR;
  Button gS;
  aook k = new ajub(this);
  ScrollView m;
  boolean mAnimating = false;
  int mTitleBarHeight;
  Handler mUiHandler;
  TextView my;
  int oR = 0;
  boolean tL = true;
  public ArrayList<Integer> yb = new ArrayList();
  
  public void AF(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Arhz.setMessage(paramString);
    this.jdField_a_of_type_Arhz.show();
  }
  
  void MX(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NearbyGuideActivity", 2, "uploadPhoto filePath is empty.");
      }
      return;
    }
    paramString = new CompressInfo(paramString, 0);
    paramString.picType = 0;
    akyj.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..uploadPhoto(), img_path = " + paramString.destPath);
    }
    if (!aqmr.isEmpty(paramString.destPath))
    {
      aool localaool = new aool();
      localaool.cNy = true;
      localaool.dQ = paramString.destPath;
      localaool.mFileType = 8;
      this.app.a().a(localaool);
      return;
    }
    cwL();
    aL(1, acfp.m(2131708719));
    aF(true, null);
  }
  
  public void MY(String paramString)
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = this.app.getCurrentAccountUin();
    locald.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.bigUrl = paramString;
    localArrayList.add(localPhotoInfo);
    localBundle.putSerializable("picturelist", localArrayList);
    localBundle.putInt("curindex", 0);
    localBundle.putInt("mode", 0);
    localBundle.putBoolean("need_clear_cache", true);
    avpw.c(this, locald, localBundle, 6);
  }
  
  void Mp(boolean paramBoolean)
  {
    ajqo.Rn(2);
    Intent localIntent = new Intent(this, NearbyActivity.class);
    localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
    localIntent.putExtra("FROM_WHERE", getIntent().getIntExtra("FROM_WHERE", -1));
    localIntent.putExtra("SHOW_EDIT_TIP", paramBoolean);
    localIntent.putExtra("IS_HAS_REDTOUCH", this.ai.getBooleanExtra("IS_HAS_REDTOUCH", false));
    localIntent.putExtra("RANK_BANNER_PUSH", this.ai.getStringExtra("RANK_BANNER_PUSH"));
    startActivity(localIntent);
    overridePendingTransition(17432576, 17432577);
    finish();
  }
  
  public void Z(Drawable paramDrawable)
  {
    if (this.jdField_b_of_type_ComTencentWidgetCustomImgView != null)
    {
      Drawable localDrawable = this.jdField_b_of_type_ComTencentWidgetCustomImgView.getDrawable();
      this.jdField_b_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramDrawable);
      if ((localDrawable != paramDrawable) && ((localDrawable instanceof aqdj))) {
        ((aqdj)localDrawable).cancel();
      }
    }
  }
  
  public void aF(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      Z(aqdj.a(this.app, 200, this.app.getCurrentAccountUin(), 3, this));
      this.mUiHandler.sendEmptyMessageDelayed(2, 3000L);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      Z(getResources().getDrawable(2130846334));
      this.Bl.setVisibility(0);
      return;
    }
    ThreadManager.postImmediately(new NearbyGuideActivity.8(this, paramString), null, true);
  }
  
  void aL(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).show(this.mTitleBarHeight);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    ajrk.a(this.bj, 36);
    dzl();
  }
  
  TopGestureLayout b()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void cwL()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  void d(boolean paramBoolean, int paramInt, ArrayList<UpdatePhotoList.HeadInfo> paramArrayList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handleImportQZonePhotoList ").append(paramBoolean).append(" ").append(paramInt).append(" ");
      if (paramArrayList == null)
      {
        i = -1;
        QLog.i("NearbyGuideActivity", 2, i);
      }
    }
    else
    {
      if ((!paramBoolean) || ((paramInt != 0) && (paramInt != 1))) {
        break label358;
      }
      if (paramInt != 0) {
        break label332;
      }
      if (paramArrayList != null) {
        break label210;
      }
      paramInt = 0;
      label87:
      localArrayList = new ArrayList();
      i = 0;
      label99:
      if (i >= paramInt) {
        break label226;
      }
      localObject = (UpdatePhotoList.HeadInfo)paramArrayList.get(i);
      if ((localObject != null) && (((UpdatePhotoList.HeadInfo)localObject).uint32_headid.has()) && (((UpdatePhotoList.HeadInfo)localObject).uint32_headid.get() >= 0))
      {
        localArrayList.add(Integer.valueOf(((UpdatePhotoList.HeadInfo)localObject).uint32_headid.get()));
        if (i == 0) {
          if (!((UpdatePhotoList.HeadInfo)localObject).str_headurl.has()) {
            break label218;
          }
        }
      }
    }
    label210:
    label218:
    for (Object localObject = ((UpdatePhotoList.HeadInfo)localObject).str_headurl.get();; localObject = "")
    {
      this.bSu = ((String)localObject);
      i += 1;
      break label99;
      i = paramArrayList.size();
      break;
      paramInt = paramArrayList.size();
      break label87;
    }
    label226:
    cwL();
    if (localArrayList.size() <= 0) {
      showToast(acfp.m(2131708729));
    }
    label332:
    while (paramInt != 1)
    {
      ArrayList localArrayList;
      return;
      this.yb.clear();
      this.yb.addAll(localArrayList);
      aL(2, acfp.m(2131708727));
      aF(false, null);
      paramArrayList = this.app.getCurrentNickname();
      this.bj.setText(paramArrayList);
      if (paramArrayList.length() > 0) {
        this.bj.setSelection(paramArrayList.length());
      }
      this.cqj = true;
      this.cqk = true;
      dzl();
      return;
    }
    this.mUiHandler.removeMessages(1);
    this.mUiHandler.sendEmptyMessageDelayed(1, 2000L);
    return;
    label358:
    cwL();
    showToast(acfp.m(2131708725));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      str = paramIntent.getStringExtra("key_cover_selected_img_path");
    } while (aqmr.isEmpty(str));
    paramIntent = new Intent(this, PhotoCropActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    paramIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    String str = acbn.SDCARD_PATH + "nearby_people_photo/";
    paramIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    paramIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", acfp.m(2131708738));
    startActivity(paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.cqj) {
      dzs();
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2131561443);
    initViews();
    getWindow().setBackgroundDrawable(null);
    try
    {
      anot.a(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_guide_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      return bool;
    }
    catch (Exception paramBundle) {}
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_b_of_type_Ajrw);
    removeObserver(this.jdField_a_of_type_Ajrw);
    dzo();
    if ((this.mUiHandler != null) && (this.mUiHandler.hasMessages(1))) {
      this.mUiHandler.removeMessages(1);
    }
    Z(null);
    ajqo.Ro(2);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent == null) {
      return;
    }
    this.bSu = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.e("NearbyGuideActivity", 2, "doOnNewIntent path is: " + this.bSu);
    }
    if (!TextUtils.isEmpty(this.bSu))
    {
      aF(true, this.bSu);
      if (this.cqj)
      {
        dzs();
        this.cqj = false;
      }
      if (!this.yb.isEmpty()) {
        break label118;
      }
      this.yb.add(Integer.valueOf(-1));
    }
    for (;;)
    {
      dzl();
      return;
      label118:
      this.yb.set(0, Integer.valueOf(-1));
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.tL))
    {
      this.tL = false;
      ajqo.fl(this.app.getAccount(), 2);
    }
  }
  
  void dzl()
  {
    String str1 = this.gS.getText().toString();
    String str2 = getString(2131701386);
    if ((str2 != null) && (str2.equals(str1)))
    {
      this.gS.setEnabled(true);
      return;
    }
    if (this.bj.getText() == null) {}
    for (str1 = "";; str1 = this.bj.getText().toString())
    {
      this.bSv = str1;
      this.bSv = ajrk.mr(this.bSv);
      if (!TextUtils.isEmpty(this.bSv)) {
        break;
      }
      this.gS.setEnabled(false);
      return;
    }
    if ((TextUtils.isEmpty(this.bSu)) && (!this.cqj))
    {
      this.gS.setEnabled(false);
      return;
    }
    this.gS.setEnabled(true);
  }
  
  void dzm()
  {
    aurd.hide(this.bj);
    if (this.cqj)
    {
      aL(2, acfp.m(2131708720));
      this.bj.setText(this.app.getCurrentNickname());
      dzl();
      return;
    }
    if (!aqiw.isNetSupport(this.app.getApp()))
    {
      showToast(acfp.m(2131708731));
      return;
    }
    dzt();
  }
  
  public void dzn()
  {
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(acfp.m(2131708717));
    localausj.addButton(acfp.m(2131708728));
    localausj.addCancelButton(2131721058);
    localausj.a(new ajug(this, localausj));
    localausj.show();
  }
  
  void dzo()
  {
    this.app.a().b(this.k);
  }
  
  public void dzp()
  {
    Intent localIntent = new Intent(this, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", getPackageName());
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = acbn.SDCARD_PATH + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("enter_from", 30);
    startActivity(localIntent);
    aqfy.anim(this, false, true);
  }
  
  public void dzq()
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = this.app.getCurrentAccountUin();
    locald.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131718034));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    avpw.a(this, locald, localBundle, 10);
  }
  
  void dzr()
  {
    if ((this.bj != null) && (this.bj.getVisibility() != 0))
    {
      this.bj.setVisibility(0);
      this.dla = 0;
      this.mAnimating = true;
      if (this.aJ == null)
      {
        this.aJ = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(int)(this.mDensity * 5.0F + 0.5F));
        this.aJ.setDuration(1300);
        this.aJ.setFillAfter(true);
        this.aJ.setAnimationListener(this);
      }
      this.EP.startAnimation(this.aJ);
      if (this.aK == null)
      {
        this.aK = new AlphaAnimation(0.5F, 1.0F);
        this.aK.setDuration(1300);
        this.aK.setAnimationListener(this);
        this.aK.setFillAfter(true);
      }
      this.bj.startAnimation(this.aK);
      if (this.aI == null)
      {
        this.aI = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(int)(this.mDensity * 25.0F + 0.5F));
        this.aI.setDuration(1300);
        this.aI.setAnimationListener(this);
        this.aI.setFillAfter(true);
      }
      this.EO.startAnimation(this.aI);
      Message localMessage = Message.obtain();
      localMessage.arg1 = 1;
      localMessage.what = 4;
      this.mUiHandler.sendMessageDelayed(localMessage, 1310);
    }
  }
  
  void dzs()
  {
    this.c.eA(new ArrayList());
  }
  
  void dzt()
  {
    this.av = aqha.a(this, 2131701382, getString(2131701381), 2131701379, 2131701380, new ajuh(this), new ajuc(this), false, true);
    if ((this.av != null) && (!isFinishing())) {
      this.av.show();
    }
  }
  
  public void eB(ArrayList<Integer> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    localBundle.putString("key_new_nickname", this.bSv);
    ajrs localajrs = (ajrs)this.app.getBusinessHandler(60);
    if (localajrs != null) {
      ThreadManager.post(new NearbyGuideActivity.7(this, paramArrayList, localajrs, localBundle), 5, null, true);
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.i("NearbyGuideActivity", 4, "NearbyCardHandler is null");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label531:
    for (;;)
    {
      return false;
      if (this.c == null) {
        this.c = ((ajrs)this.app.getBusinessHandler(60));
      }
      this.c.dyX();
      return false;
      this.mUiHandler.removeMessages(2);
      if ((paramMessage.obj instanceof Bitmap)) {
        Z(new BitmapDrawable(getResources(), (Bitmap)paramMessage.obj));
      }
      dzr();
      return false;
      this.mAnimating = false;
      this.mUiHandler.removeMessages(4);
      this.EO.clearAnimation();
      this.EP.clearAnimation();
      this.bj.clearAnimation();
      int i = (int)(this.mDensity * 15.0F + 0.5F);
      int j = (int)(this.mDensity * 15.0F + 0.5F);
      this.EO.setPadding(0, i, 0, j);
      i = (int)(this.mDensity * 5.0F + 0.5F);
      j = (int)(this.mDensity * 5.0F + 0.5F);
      this.EP.setPadding(0, i, 0, j);
      this.gS.setText(2131697310);
      this.gS.setContentDescription(getString(2131697310));
      dzl();
      if (QLog.isDevelopLevel())
      {
        ajrk.f("NearbyGuideActivity", "MSG_ANIM_END", new Object[] { Integer.valueOf(this.dla), Integer.valueOf(paramMessage.arg1) });
        return false;
        if (QLog.isDevelopLevel()) {
          ajrk.f("NearbyGuideActivity", "MSG_TIP_ANIM", new Object[] { this.my });
        }
        if (this.my != null)
        {
          paramMessage = new TranslateAnimation(0.0F, 0.0F, 0.0F, -25.0F);
          paramMessage.setInterpolator(new CycleInterpolator(2.0F));
          paramMessage.setFillAfter(false);
          paramMessage.setDuration(1300L);
          this.my.startAnimation(paramMessage);
          return false;
          if (QLog.isDevelopLevel()) {
            ajrk.f("NearbyGuideActivity", "MSG_FADEOUT_END", new Object[] { Integer.valueOf(this.oR), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.getChildCount()) });
          }
          paramMessage = null;
          if (this.oR == 1)
          {
            paramMessage = this.m;
            i = 0;
          }
          for (;;)
          {
            if ((paramMessage == null) || (i >= this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.getChildCount())) {
              break label531;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.getChildAt(i) == paramMessage)
            {
              if (QLog.isDevelopLevel()) {
                ajrk.f("NearbyGuideActivity", "MSG_FADEOUT_END", new Object[] { "find child index", Integer.valueOf(i) });
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.removeViewAt(i);
              return false;
              if (this.oR != 2) {
                break;
              }
              paramMessage = this.EN;
              break;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  void initData()
  {
    this.mTitleBarHeight = getTitleBarHeight();
    this.ai = getIntent();
    if (getIntent() == null)
    {
      ajqo.Rn(2);
      NearbyFakeActivity.S(this, new Intent(this, NearbyActivity.class));
      finish();
    }
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
    if (!((Boolean)ajrb.c(this.app.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(false))).booleanValue()) {
      kk(0L);
    }
    for (;;)
    {
      this.k.addFilter(new Class[] { aomd.class });
      this.app.a().a(this.k);
      return;
      kl(0L);
    }
  }
  
  void initTitle()
  {
    int i = getResources().getColor(2131166691);
    if (this.mTitleContainer == null) {
      this.mTitleContainer = findViewById(2131377361);
    }
    this.mTitleContainer.setBackgroundColor(i);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusColor(i);
    }
    if ((this.centerView instanceof TextView)) {
      this.centerView.setTextColor(-1);
    }
    if ((this.leftView instanceof TextView))
    {
      this.leftView.setTextColor(-1);
      this.leftView.setBackgroundResource(2130846466);
      this.leftView.setOnClickListener(this);
    }
    if (this.oR == 1)
    {
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(8);
      setTitle(acfp.m(2131708734));
      if ((this.leftView instanceof TextView))
      {
        String str1 = null;
        if (getIntent() != null) {
          str1 = getIntent().getExtras().getString("leftViewText");
        }
        String str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          str2 = getString(2131690700);
        }
        this.leftView.setText(str2);
      }
      return;
    }
    setTitle(acfp.m(2131708730));
    if ((this.leftView instanceof TextView)) {
      this.leftView.setText(2131690700);
    }
    this.rightViewText.setVisibility(0);
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setText(acfp.m(2131708722));
    this.rightViewText.setTextColor(-1);
    this.rightViewText.setOnClickListener(this);
  }
  
  public void initViews()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout = ((MonitorSizeChangeRelativeLayout)findViewById(2131377472));
    initData();
    this.app.addObserver(this.jdField_b_of_type_Ajrw, true);
    this.app.addObserver(this.jdField_a_of_type_Ajrw, true);
  }
  
  void kk(long paramLong)
  {
    this.cql = true;
    this.oR = 1;
    initTitle();
    if (this.EN == null)
    {
      this.EN = LayoutInflater.from(this).inflate(2131561431, null);
      if (Build.VERSION.SDK_INT >= 9) {
        this.EN.setOverScrollMode(2);
      }
      this.gR = ((Button)this.EN.findViewById(2131372236));
      this.gR.setOnClickListener(this);
      uu("0X8005901");
    }
    if (this.EN.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.addView(this.EN, new RelativeLayout.LayoutParams(-1, -1));
    }
    if (paramLong > 0L)
    {
      if (this.aG == null)
      {
        this.aG = new AlphaAnimation(0.0F, 1.0F);
        this.aG.setDuration(400L);
        this.aG.setAnimationListener(this);
      }
      this.EN.startAnimation(this.aG);
    }
  }
  
  @TargetApi(9)
  void kl(long paramLong)
  {
    this.oR = 2;
    initTitle();
    TopGestureLayout localTopGestureLayout = b();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(false);
    }
    if (this.m == null)
    {
      this.m = ((ScrollView)LayoutInflater.from(this).inflate(2131561444, null));
      if (Build.VERSION.SDK_INT >= 9) {
        this.m.setOverScrollMode(2);
      }
      this.m.findViewById(2131379991).setOnClickListener(this);
      this.EO = this.m.findViewById(2131368409);
      this.EP = this.m.findViewById(2131366231);
      this.my = ((TextView)this.m.findViewById(2131381163));
      this.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.m.findViewById(2131369092));
      this.bj = ((EditText)this.m.findViewById(2131366536));
      this.gS = ((Button)this.m.findViewById(2131363867));
      this.UZ = ((TextView)this.m.findViewById(2131381141));
      this.jdField_b_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(getResources().getDrawable(2130845961));
      this.jdField_b_of_type_ComTencentWidgetCustomImgView.setImageDrawable(getResources().getDrawable(2130846334));
      this.Bl = ((ImageView)this.m.findViewById(2131369096));
      this.bj.setSelection(0);
      this.bj.setVisibility(4);
      this.bj.setOnEditorActionListener(this);
      this.gS.setText(2131701386);
      this.gS.setContentDescription(getString(2131701386));
      if (this.cqj) {
        break label529;
      }
    }
    label529:
    for (boolean bool = true;; bool = false)
    {
      aF(bool, this.bSu);
      dzl();
      uu("0X8005903");
      this.bj.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.setCallBack(this);
      this.UZ.setOnClickListener(this);
      this.gS.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
      int i = ((Integer)ajrb.c(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("NearbyGuideActivity", 2, "qqAvatarType is: " + i);
      }
      if (i != 1)
      {
        this.UZ.setText("");
        this.UZ.setOnClickListener(null);
      }
      if (this.m.getParent() == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMonitorSizeChangeRelativeLayout.addView(this.m, new RelativeLayout.LayoutParams(-1, -1));
      }
      if (paramLong <= 0L) {
        break;
      }
      if (this.aG == null)
      {
        this.aG = new AlphaAnimation(0.0F, 1.0F);
        this.aG.setDuration(400L);
        this.aG.setAnimationListener(this);
      }
      this.m.startAnimation(this.aG);
      return;
    }
    this.mUiHandler.sendEmptyMessageDelayed(5, 100L);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.aG) {
      if (this.oR == 2) {
        this.mUiHandler.sendEmptyMessageDelayed(5, 100L);
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
            return;
            if (paramAnimation == this.aH)
            {
              this.mUiHandler.sendEmptyMessage(6);
              return;
            }
            if (paramAnimation != this.aJ) {
              break;
            }
            this.dla |= 0x1;
          } while ((this.dla & 0x7) != 7);
          this.mUiHandler.sendEmptyMessage(4);
          return;
          if (paramAnimation != this.aI) {
            break;
          }
          this.dla |= 0x2;
        } while ((this.dla & 0x7) != 7);
        this.mUiHandler.sendEmptyMessage(4);
        return;
      } while (paramAnimation != this.aK);
      this.dla |= 0x4;
    } while ((this.dla & 0x7) != 7);
    this.mUiHandler.sendEmptyMessage(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (paramView == this.leftView) {
      if (this.oR == 2) {
        if (this.cql)
        {
          if (this.bj != null) {
            ((InputMethodManager)this.bj.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.bj.getWindowToken(), 0);
          }
          if (this.aH == null)
          {
            this.aH = new AlphaAnimation(1.0F, 0.0F);
            this.aH.setDuration(400L);
            this.aH.setAnimationListener(this);
          }
          this.m.startAnimation(this.aH);
          kk(400L);
        }
      }
    }
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.cqj) {
        dzs();
      }
      finish();
      continue;
      if (this.oR == 1)
      {
        if (this.cqj) {
          dzs();
        }
        finish();
        continue;
        if (paramView == this.rightViewText)
        {
          if (this.oR == 2)
          {
            if (this.cqj) {
              dzs();
            }
            Mp(false);
            ajrb.c(this.app.getAccount(), "sp_key_user_skip_guide", Boolean.valueOf(true));
            uu("0X8005D91");
          }
        }
        else if (paramView == this.UZ)
        {
          dzm();
          uu("0X8005908");
        }
        else
        {
          if (paramView != this.gS) {
            break label453;
          }
          if (!this.mAnimating)
          {
            localObject = this.gS.getText().toString();
            String str = getString(2131701386);
            if ((str != null) && (str.equals(localObject)))
            {
              dzn();
            }
            else
            {
              if (aqiw.isNetSupport(this.app.getApp())) {
                break;
              }
              showToast(acfp.m(2131708724));
            }
          }
        }
      }
    }
    AF(acfp.m(2131708733));
    if (((Integer)this.yb.get(0)).intValue() == -1)
    {
      MX(this.bSu);
      label370:
      if (!this.cqk) {
        break label674;
      }
      if ((this.bSv.equals(this.app.getCurrentNickname())) && (this.cqj)) {}
    }
    label674:
    for (i = 3;; i = 1)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005D92", "0X8005D92", i, 0, "", "", "", "");
      break;
      eB(this.yb);
      break label370;
      label453:
      if (paramView == this.jdField_b_of_type_ComTencentWidgetCustomImgView)
      {
        if (TextUtils.isEmpty(this.bSu))
        {
          dzn();
          break;
        }
        localObject = (ausj)auss.a(this, null);
        ((ausj)localObject).addButton(acfp.m(2131708721));
        ((ausj)localObject).addButton(acfp.m(2131708735));
        ((ausj)localObject).addCancelButton(2131721058);
        ((ausj)localObject).a(new ajuf(this, (ausj)localObject));
        ((ausj)localObject).show();
        break;
      }
      if (paramView == this.gR)
      {
        ajrb.c(this.app.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(true));
        if (this.aH == null)
        {
          this.aH = new AlphaAnimation(1.0F, 0.0F);
          this.aH.setDuration(400L);
          this.aH.setAnimationListener(this);
        }
        this.EN.startAnimation(this.aH);
        kl(400L);
        uu("0X8005902");
        break;
      }
      if ((paramView.getId() != 2131379991) || (this.bj == null)) {
        break;
      }
      ((InputMethodManager)this.bj.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.bj.getWindowToken(), 0);
      break;
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f("NearbyGuideActivity", "onEditorAction", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramInt == 6)
    {
      if (TextUtils.isEmpty(this.bj.getText().toString())) {
        showToast(acfp.m(2131708726));
      }
    }
    else {
      return true;
    }
    onClick(this.gS);
    return true;
  }
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.mUiHandler.sendEmptyMessage(2);
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == paramInt3) && (paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4)) {
      this.m.postDelayed(new NearbyGuideActivity.5(this), 300L);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      this.bj.setSelection(0);
    }
  }
  
  public void showToast(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).show(this.mTitleBarHeight);
  }
  
  public void uu(String paramString)
  {
    ThreadManager.post(new NearbyGuideActivity.11(this, paramString), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity
 * JD-Core Version:    0.7.0.1
 */