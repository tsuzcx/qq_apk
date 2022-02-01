package com.tencent.mobileqq.activity;

import acfp;
import advr;
import akbr.a;
import akbt;
import albc;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import anot;
import aoiz;
import aqep;
import aqha;
import aqju;
import ausj;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import sxg;
import sxi;
import sxm;
import sxn;
import sxz;
import vbx;
import vby;
import vbz;
import wja;
import xtm;

public class FriendProfilePicBrowserActivity
  extends PicBrowserActivity
  implements akbr.a, DialogInterface.OnCancelListener, View.OnClickListener
{
  albc a;
  private Button dg;
  public int mFromType;
  Handler mHandler = new Handler();
  ArrayList<String> pl;
  private ImageView qe;
  
  private void bPu()
  {
    File localFile = t();
    if (localFile == null) {
      return;
    }
    aqep.a(localFile.getAbsolutePath(), this.app, this);
  }
  
  private void bPv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "deletePic");
    }
    aqju localaqju = aqha.a(this, 0);
    localaqju.setMessage(getString(2131692482)).setCancelable(true);
    localaqju.setNegativeButton(2131721058, new vby(this, localaqju));
    localaqju.setPositiveButton(2131691042, new vbz(this, localaqju));
    if (!isFinishing()) {
      localaqju.show();
    }
  }
  
  private void bm(Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void bst()
  {
    File localFile = t();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfilePicBrowserActivity", 2, "savePic, file is null");
      }
      return;
    }
    xtm.a(this, localFile, Utils.Crc64String(localFile.getAbsolutePath()));
  }
  
  private boolean checkData()
  {
    boolean bool = true;
    int j = 0;
    Object localObject2 = getIntent().getExtras();
    int i = ((Bundle)localObject2).getInt("fromType", 0);
    int k = ((Bundle)localObject2).getInt("index", 0);
    Object localObject1 = ((Bundle)localObject2).getParcelableArrayList("picInfos");
    localObject2 = ((Bundle)localObject2).getStringArrayList("fileIdList");
    if (i == 1)
    {
      if ((localObject1 == null) || (((ArrayList)localObject1).size() != 1)) {
        break label200;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("checkData: ").append(bool).append(",").append(i).append(",").append(k).append(",");
      if (localObject1 != null) {
        break label206;
      }
      i = 0;
      label118:
      localObject1 = localStringBuilder.append(i).append(",");
      if (localObject2 != null) {
        break label215;
      }
    }
    label200:
    label206:
    label215:
    for (i = j;; i = ((ArrayList)localObject2).size())
    {
      QLog.d("FriendProfilePicBrowserActivity", 2, i);
      return bool;
      if ((i == 2) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0) && (localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (((ArrayList)localObject1).size() == ((ArrayList)localObject2).size())) {
        break;
      }
      bool = false;
      break;
      i = ((ArrayList)localObject1).size();
      break label118;
    }
  }
  
  private void forward()
  {
    File localFile = t();
    if (localFile == null) {
      return;
    }
    aqep.b(localFile.getAbsolutePath(), this);
  }
  
  private void hJ()
  {
    File localFile = t();
    if (localFile == null) {
      return;
    }
    aqep.b(localFile.getAbsolutePath(), this.app, this);
  }
  
  private String oR()
  {
    int i = -1;
    String str2 = "";
    if (this.a != null) {
      i = this.a.getSelectedIndex();
    }
    String str1 = str2;
    if (i >= 0)
    {
      str1 = str2;
      if (i < this.pl.size()) {
        str1 = (String)this.pl.get(i);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "getCurrFileId, index=" + i + ",fileId=" + str1);
    }
    return str1;
  }
  
  private void parseIntent()
  {
    Object localObject = getIntent().getExtras();
    this.mFromType = ((Bundle)localObject).getInt("fromType", 0);
    this.mIndex = ((Bundle)localObject).getInt("index", 0);
    if (this.mIndex < 0) {
      this.mIndex = 0;
    }
    this.mPicInfos = null;
    this.mPicInfos = ((Bundle)localObject).getParcelableArrayList("picInfos");
    if (this.mFromType == 1)
    {
      localObject = ((advr)this.app.getManager(180)).a(this.app.getCurrentAccountUin());
      localPicInfo = new PicInfo();
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((DynamicAvatar)localObject).basicBigUrl)) {
          break label150;
        }
        localPicInfo.videoUrl = ((DynamicAvatar)localObject).basicBigUrl;
      }
    }
    label150:
    while (this.mFromType != 2)
    {
      PicInfo localPicInfo;
      for (;;)
      {
        if (!TextUtils.isEmpty(localPicInfo.videoUrl))
        {
          this.mPicInfos = new ArrayList();
          this.mPicInfos.add(localPicInfo);
        }
        return;
        if (!TextUtils.isEmpty(((DynamicAvatar)localObject).basicSmallUrl)) {
          localPicInfo.videoUrl = ((DynamicAvatar)localObject).basicSmallUrl;
        }
      }
    }
    this.pl = ((Bundle)localObject).getStringArrayList("fileIdList");
  }
  
  private File t()
  {
    PicInfo localPicInfo = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "getCurPicPathUrl, curPicInfo=" + localPicInfo);
    }
    if (localPicInfo == null) {
      return null;
    }
    if (!TextUtils.isEmpty(localPicInfo.localPath)) {
      return new File(localPicInfo.localPath);
    }
    return aoiz.getFile(localPicInfo.bSZ);
  }
  
  public void AY(int paramInt) {}
  
  public void Qq()
  {
    boolean bool = this.a.arG();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "showActionSheet, ,forbid=" + bool);
    }
    if (bool) {
      return;
    }
    ausj localausj = ausj.a(this, false);
    localausj.addButton(2131694752);
    localausj.addButton(acfp.m(2131706626));
    localausj.addButton(2131694180);
    if (this.mFromType == 2) {
      localausj.addButton(acfp.m(2131706585), 3);
    }
    localausj.addCancelButton(acfp.m(2131706627));
    localausj.a(new vbx(this, localausj));
    localausj.show();
    anot.a(this.app, "dc00898", "", "", "0X8007C13", "0X8007C13", 0, 0, "", "", "", "");
    anot.a(this.app, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, "1", "", "", "");
  }
  
  public void bPt()
  {
    if (this.dg != null) {
      this.dg.setVisibility(8);
    }
    if (this.qe != null) {
      this.qe.setVisibility(8);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      bm(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    bPt();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (!checkData())
    {
      finish();
      return false;
    }
    getWindow().setFlags(1024, 1024);
    this.b = new a();
    super.doOnCreate(paramBundle);
    this.dg = ((Button)findViewById(2131378118));
    this.dg.setOnClickListener(this);
    this.dg.setEnabled(false);
    this.qe = ((ImageView)findViewById(2131367840));
    this.qe.setContentDescription(acfp.m(2131706631));
    this.qe.setOnClickListener(this);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.a.MG(false);
    if (this.mFromType == 1)
    {
      this.dg.setVisibility(4);
      if ((this.mPicInfos == null) || (this.mPicInfos.size() <= 0) || (TextUtils.isEmpty(((PicInfo)this.mPicInfos.get(0)).videoUrl))) {
        break label287;
      }
      this.qe.setVisibility(4);
      this.a.MG(true);
    }
    label287:
    for (int i = 1;; i = 0)
    {
      QQAppInterface localQQAppInterface = this.app;
      if (i != 0)
      {
        paramBundle = "1";
        anot.a(localQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramBundle, "", "", "");
      }
      for (;;)
      {
        return true;
        paramBundle = "0";
        break;
        if (this.mFromType == 2) {
          anot.a(this.app, "dc00898", "", "", "0X8007C11", "0X8007C11", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    finish();
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    AbstractGifImage.resumeAll();
    super.doOnResume();
  }
  
  public void initData()
  {
    super.initData();
    parseIntent();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
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
      Intent localIntent = getIntent();
      localIntent.putExtra("setHead_fileid", oR());
      setResult(-1, localIntent);
      finish();
      anot.a(this.app, "dc00898", "", "", "0X8007C12", "0X8007C12", 0, 0, "", "", "", "");
      continue;
      Qq();
    }
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    if ((this.a != null) && (this.a.getSelectedIndex() == paramInt)) {
      this.dg.setEnabled(true);
    }
  }
  
  public void onLoadProgressUpdate(int paramInt1, int paramInt2) {}
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    if ((this.a != null) && (this.a.getSelectedIndex() == paramInt1)) {
      this.dg.setEnabled(false);
    }
  }
  
  class a
    extends sxz
  {
    a() {}
    
    public sxg a(Activity paramActivity, sxm paramsxm)
    {
      return super.a(paramActivity, paramsxm);
    }
    
    public sxi a(Activity paramActivity, sxm paramsxm)
    {
      FriendProfilePicBrowserActivity.this.a = new albc((FriendProfilePicBrowserActivity)paramActivity, paramsxm);
      return FriendProfilePicBrowserActivity.this.a;
    }
    
    public sxm a(Activity paramActivity)
    {
      paramActivity = new akbt(FriendProfilePicBrowserActivity.this, FriendProfilePicBrowserActivity.a(FriendProfilePicBrowserActivity.this));
      paramActivity.setSelectedIndex(FriendProfilePicBrowserActivity.a(FriendProfilePicBrowserActivity.this));
      return paramActivity;
    }
    
    public sxn a(Activity paramActivity, sxm paramsxm)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */