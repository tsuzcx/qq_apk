package com.tencent.mobileqq.forward;

import acbn;
import acfp;
import afei;
import ahbj;
import ahgg.a;
import ahhm;
import ahiz;
import ahja;
import alld;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoiz;
import aoop;
import aqft;
import aqhq;
import aqhr;
import aqju;
import aqnm;
import arnv;
import auqv;
import aviz;
import avjg;
import avpw;
import awsw;
import com.dataline.activities.LiteActivity;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jqs;
import kaw;
import mqq.os.MqqHandler;
import rar;
import syw;
import szw;
import szy;
import vtm;
import wja;
import xkl;

public class ForwardPhotoOption
  extends ahhm
{
  private a jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a;
  vtm jdField_a_of_type_Vtm;
  private boolean chf = true;
  
  public ForwardPhotoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.cgP = true;
    this.cZS = 6;
  }
  
  private File E()
  {
    String str = this.bf.getString("forward_filepath");
    Object localObject = str;
    if (str == null) {
      localObject = this.bKv;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath p: " + (String)localObject);
    }
    boolean bool = this.bf.getBoolean(SearchEmoticonFragment.bEM, false);
    if ((localObject != null) && (((String)localObject).length() > 4) && ((".gif".equals(((String)localObject).substring(((String)localObject).length() - 4, ((String)localObject).length()))) || (bool)))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  private File a(Parcelable paramParcelable)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramParcelable instanceof MessageForPic))
    {
      paramParcelable = (MessageForPic)paramParcelable;
      if (paramParcelable.imageType != 3)
      {
        localObject1 = localObject2;
        if (paramParcelable.imageType != 2000) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage msgPic gif.");
        }
        localObject1 = aoiz.getFile(aoop.a(paramParcelable, 1, null).toString());
      }
    }
    do
    {
      return localObject1;
      if (!(paramParcelable instanceof AIOImageData)) {
        break label157;
      }
      paramParcelable = (AIOImageData)paramParcelable;
      if (paramParcelable.mImageType == 3) {
        break;
      }
      localObject1 = localObject2;
    } while (paramParcelable.mImageType != 2000);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage AIOImageData gif");
    }
    if (paramParcelable.gF(2)) {
      paramParcelable = paramParcelable.c(2);
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramParcelable == null) {
        break;
      }
      localObject1 = localObject2;
      if (!paramParcelable.exists()) {
        break;
      }
      return paramParcelable;
      if (paramParcelable.gF(4))
      {
        paramParcelable = paramParcelable.c(4);
        continue;
        label157:
        return E();
      }
      else
      {
        paramParcelable = null;
      }
    }
  }
  
  private boolean anF()
  {
    Object localObject3 = fg();
    this.bf.putBoolean("isBack2Root", false);
    Object localObject1 = Boolean.valueOf(this.mIntent.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.mIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.mIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + localObject1 + "isFromShare=" + bool4);
    }
    Object localObject2;
    if (((Boolean)localObject1).booleanValue())
    {
      if (this.mIntent.getBooleanExtra("isFromShare", false)) {
        this.bf.putString("leftBackText", acfp.m(2131706471));
      }
      if (this.jdField_a_of_type_Vtm == null) {
        this.jdField_a_of_type_Vtm = new vtm((BaseActivity)this.mActivity);
      }
      localObject2 = this.bf.getStringArrayList("foward_key_m_p_l");
      localObject1 = localObject2;
      int i;
      if (localObject2 == null)
      {
        Object localObject4 = this.bf.get("android.intent.extra.STREAM");
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject2;
          if ((localObject4 instanceof ArrayList))
          {
            localObject4 = (ArrayList)localObject4;
            localObject2 = new ArrayList();
            i = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= ((ArrayList)localObject4).size()) {
                break;
              }
              localObject1 = f((Uri)((ArrayList)localObject4).get(i));
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((ArrayList)localObject2).add(localObject1);
              }
              i += 1;
            }
          }
        }
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
        localObject2 = ((List)localObject3).iterator();
      }
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject2).next();
        this.jdField_a_of_type_Vtm.a(((ResultRecord)localObject3).QD, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).lk(), ((ResultRecord)localObject3).name, this.bf, (ArrayList)localObject1);
        if ((QSecFramework.a().c(1003).booleanValue()) && (bool4) && (this.cgS))
        {
          i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            arnv.a().n(3, (String)((ArrayList)localObject1).get(i), ((ResultRecord)localObject3).lk(), ((ResultRecord)localObject3).uin);
            i += 1;
          }
          arnv.a().report();
          continue;
          QQToast.a(BaseApplication.getContext(), 1, this.mActivity.getResources().getString(2131719483), 0).show();
        }
      }
      return true;
    }
    localObject1 = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
    ((Intent)localObject1).putExtra("KEY_MSG_FORWARD_ID", this.bf.getInt("KEY_MSG_FORWARD_ID", 0));
    if ((this.b != null) && (this.b.getType() == 10011))
    {
      ((Intent)localObject1).putExtras(this.bf);
      ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject1, null);
    }
    for (;;)
    {
      this.mActivity.setResult(-1, (Intent)localObject1);
      return false;
      if ((this.b != null) && (this.b.getType() == 10012))
      {
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtras(this.bf);
        ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject1, null);
      }
      else if (this.bf.getBoolean("key_help_forward_pic", false))
      {
        ((Intent)localObject1).putExtras(this.bf);
        ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject1, null);
      }
      else
      {
        if (bool4)
        {
          this.bf.putString("leftBackText", acfp.m(2131706474));
          ((Intent)localObject1).addFlags(268435456);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtras(this.bf);
          bool4 = aa((Intent)localObject1);
          boolean bool5 = this.bf.getBoolean("isFromFavorites");
          if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool5 + "isFromAIOFav=" + bool4);
          }
          if (this.cgS)
          {
            ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject1, null);
            if (QSecFramework.a().c(1003).booleanValue())
            {
              localObject2 = ((List)localObject3).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (ResultRecord)((Iterator)localObject2).next();
                arnv.a().n(3, this.bf.getString("forward_filepath"), ((ResultRecord)localObject3).lk(), ((ResultRecord)localObject3).uin);
                arnv.a().report();
              }
            }
          }
          else if (!bool1)
          {
            ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject1, null);
          }
        }
        this.bf.putInt("forward_source_uin_type", this.mActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
        ((Intent)localObject1).putExtras(this.bf);
        if ((bool2) || (bool3))
        {
          ((Intent)localObject1).removeExtra("forward_filepath");
          ((Intent)localObject1).removeExtra("forward_extra");
          this.mActivity.startActivity((Intent)localObject1);
        }
      }
    }
  }
  
  private String b(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramUri = alld.query(this.mActivity.getContentResolver(), paramUri, new String[] { "_data" }, null, null, null);
        int i = paramUri.getColumnIndexOrThrow("_data");
        paramUri.moveToFirst();
        str = paramUri.getString(i);
        paramUri.close();
        return str;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private void don()
  {
    Object localObject3 = null;
    Object localObject6 = a(this.bf.getParcelable("FORWARD_MSG_FOR_PIC"));
    if (localObject6 != null) {}
    for (;;)
    {
      try
      {
        Object localObject1 = NativeGifImage.getImageSize((File)localObject6, false);
        Object localObject4;
        Object localObject5;
        int j;
        float f;
        Object localObject2 = null;
      }
      catch (IOException localIOException1)
      {
        try
        {
          localObject6 = ((File)localObject6).toURI().toURL();
          i = 1;
          localObject3 = localObject1;
          localObject1 = localObject6;
          if (i != 0) {
            this.cZS = 5;
          }
          if (!xkl.bgG) {
            i = 0;
          }
          if (i != 0) {
            continue;
          }
          c(this.bKv, this.e);
          ThreadManager.getSubThreadHandler().postDelayed(new PhotoRunnable(this.mActivity), 1000L);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          continue;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        localIOException1 = localIOException1;
        localObject1 = null;
        localIOException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "getImageSize " + localIOException1.toString());
        }
        localObject6 = null;
        localObject4 = localObject1;
        i = 0;
        localObject1 = localObject6;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localObject1 = null;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "getImageSize oom " + localOutOfMemoryError2.toString());
        }
        localObject6 = null;
        localObject5 = localObject1;
        i = 0;
        localObject1 = localObject6;
        continue;
        if ((localObject5 != null) && (localObject1 != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImagePath load gif start " + ((URL)localObject1).toString());
          }
          j = localObject5.width();
          i = localObject5.height();
          f = this.mActivity.getResources().getDisplayMetrics().densityDpi / 160;
          j = (int)(j * f);
          i = (int)(i * f);
          try
          {
            localObject1 = aoop.getDrawable((URL)localObject1, j, i, new afei(j, i), aoop.getFailedDrawable(), true);
            this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.a((Drawable)localObject1, true, 0, true);
            this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.framePreviewImage.setOnTouchListener(new ahja(this));
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError1) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ForwardOption.ForwardPhotoOption", 2, "initPreviewImage_getDrawable oom " + localOutOfMemoryError1.toString());
          return;
        }
        c(this.bKv, this.e);
        return;
      }
      int i = 0;
    }
  }
  
  public String B()
  {
    if (msg == null) {
      return this.mAppContext.getString(2131720168);
    }
    return msg;
  }
  
  public int EU()
  {
    return 2;
  }
  
  public int EW()
  {
    Object localObject1;
    int i;
    if (this.bf.getBoolean("sendMultiple", false))
    {
      localObject1 = (ArrayList)this.bf.get("android.intent.extra.STREAM");
      QLog.i("Qfav", 1, "shareToQfav sendMultiple . size = " + ((ArrayList)localObject1).size());
      i = 0;
      if (i >= ((ArrayList)localObject1).size()) {
        break label364;
      }
      if (!aviz.b(b((Uri)((ArrayList)localObject1).get(i))).a(this.app).b(this.mActivity, this.app.getAccount(), -1, null)) {
        i = -1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        avjg.a(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
      i += 1;
      break;
      QLog.i("Qfav", 1, "shareToQfav single pic");
      Object localObject2 = this.bf.getString("forward_filepath");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (this.b != null) {
          localObject1 = this.b.getLocalPath();
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.bf.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.bKv;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if (new File((String)localObject1).exists())
        {
          if (aviz.b((String)localObject1).a(this.app).b(this.mActivity, this.app.getAccount(), -1, null)) {
            i = 0;
          }
        }
        else if (aviz.a(this.mIntent.getStringExtra("forward_photo_md5"), -1, this.mIntent.getStringExtra("forward_download_image_server_path"), this.mIntent.getLongExtra("forward_photo_group_fileid", 0L), this.mIntent.getStringExtra("forward_extra"), this.mIntent.getLongExtra("forward_file_size", 0L)).b(this.mActivity, this.app.getAccount(), -1, null))
        {
          i = 0;
          continue;
        }
      }
      i = -1;
      continue;
      label364:
      i = 0;
    }
  }
  
  public void Ka(String paramString)
  {
    ArrayList localArrayList = this.mIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      anot.a(this.app, "CliOper", "", "", "0X8007815", "0X8007815", 0, 0, "", "", "", "");
      avpw.b(paramString, localArrayList, "source_from_quick_shoot");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "content:" + paramString + "path:" + localArrayList);
    }
    paramString = new Intent(this.mActivity, SplashActivity.class);
    paramString.setFlags(67108864);
    paramString.putExtra("main_tab_id", 4);
    paramString.putExtra("fragment_id", 1);
    paramString.putExtra("switch_anim", true);
    paramString.putExtra("forward_to_someplace_from_shoot_quick", 1002);
    this.mActivity.setResult(-1, paramString);
    this.mActivity.finish();
  }
  
  public void Kd(String paramString)
  {
    this.bKv = paramString;
  }
  
  public void Pa(int paramInt)
  {
    Bundle localBundle = new Bundle();
    String str1 = acbn.bkw;
    if (paramInt == ab.intValue()) {
      str1 = acbn.bkx;
    }
    localBundle.putAll(this.bf);
    if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      LiteActivity.a(this.app, this.bKv, this.mActivity);
      String str2 = this.mIntent.getStringExtra("caller_name");
      paramInt = this.mIntent.getIntExtra("forward_type", 2147483647);
      String str3 = this.mIntent.getStringExtra("forward_filepath");
      if ((("QQBrowserActivity".equals(str2)) || ("PublicAccountBrowser".equals(str2))) && (paramInt == 1) && (!TextUtils.isEmpty(str3))) {
        this.mActivity.setResult(-1);
      }
      for (;;)
      {
        a(localBundle, str1, null);
        this.mActivity.finish();
        return;
        this.mActivity.setResult(-1, this.mIntent);
      }
    }
    super.Pa(paramInt);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.mActivity.runOnUiThread(new ForwardPhotoOption.3(this, paramDrawable, paramBoolean1, paramInt));
  }
  
  public void a(Bundle paramBundle, AIOImageProviderService paramAIOImageProviderService, AIORichMediaData paramAIORichMediaData)
  {
    if (this.bf.getBoolean("key_allow_forward_photo_preview_edit", false)) {
      paramBundle.putBoolean("key_allow_forward_photo_preview_edit", true);
    }
    super.a(paramBundle, paramAIOImageProviderService, paramAIORichMediaData);
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    syw localsyw = (syw)this.app.getBusinessHandler(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localsyw.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(1)) && (e(aa))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    int i = this.mIntent.getIntExtra("key_new_img_shareactionsheet", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 8001) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP)))
      {
        localArrayList.add(localRecentUser);
      }
      else if ((localRecentUser != null) && (localRecentUser.uin.equalsIgnoreCase(acbn.bkw)))
      {
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "getForwardRecentList uin = " + localRecentUser.uin + "  | fromNewImgType = " + i);
        if (i == 1) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  boolean anG()
  {
    this.bf.putBoolean("isBack2Root", false);
    int j = this.bf.getInt("uintype");
    String str1 = this.bf.getString("uin");
    String str2 = this.bf.getString("uinname");
    String str3 = this.bf.getString("troop_uin");
    Object localObject1 = Boolean.valueOf(this.mIntent.getBooleanExtra("sendMultiple", false));
    boolean bool4 = this.mIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.mIntent.getBooleanExtra("isJumpAIO", false);
    boolean bool2 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool3 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + localObject1 + "isFromShare=" + bool4);
    }
    Object localObject2;
    if (((Boolean)localObject1).booleanValue())
    {
      if (this.mIntent.getBooleanExtra("isFromShare", false)) {
        this.bf.putString("leftBackText", acfp.m(2131706478));
      }
      if (this.jdField_a_of_type_Vtm == null) {
        this.jdField_a_of_type_Vtm = new vtm((BaseActivity)this.mActivity);
      }
      localObject2 = this.bf.getStringArrayList("foward_key_m_p_l");
      localObject1 = localObject2;
      int i;
      if (localObject2 == null)
      {
        Object localObject3 = this.bf.get("android.intent.extra.STREAM");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof ArrayList))
          {
            localObject2 = (ArrayList)localObject3;
            localObject1 = new ArrayList();
            i = 0;
            while (i < ((ArrayList)localObject2).size())
            {
              localObject3 = f((Uri)((ArrayList)localObject2).get(i));
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((ArrayList)localObject1).add(localObject3);
              }
              i += 1;
            }
          }
        }
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        this.jdField_a_of_type_Vtm.a(str3, str1, j, str2, this.bf, (ArrayList)localObject1);
        if ((QSecFramework.a().c(1003).booleanValue()) && (bool4) && (this.cgS))
        {
          i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            arnv.a().n(3, (String)((ArrayList)localObject1).get(i), j, str1);
            i += 1;
          }
          arnv.a().report();
        }
      }
      for (;;)
      {
        return true;
        QQToast.a(BaseApplication.getContext(), 1, this.mActivity.getResources().getString(2131719483), 0).show();
      }
    }
    if (j == 1008)
    {
      localObject2 = new Intent(this.mActivity, ChatActivity.class);
      ((Intent)localObject2).putExtra("chat_subType", kaw.a(str1, this.app));
      auqv.aX(true, this.bf.getString("forward_filepath"));
      if ((this.b == null) || (this.b.getType() != 10011)) {
        break label621;
      }
      ((Intent)localObject2).putExtras(this.bf);
      ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject2, null);
    }
    label621:
    do
    {
      for (;;)
      {
        doa();
        this.mActivity.setResult(-1, (Intent)localObject2);
        this.mActivity.finish();
        return false;
        localObject2 = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
        break;
        if ((this.b != null) && (this.b.getType() == 10012))
        {
          ((Intent)localObject2).addFlags(268435456);
          ((Intent)localObject2).addFlags(67108864);
          ((Intent)localObject2).putExtras(this.bf);
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject2, null);
        }
        else if (this.bf.getBoolean("key_help_forward_pic", false))
        {
          ((Intent)localObject2).putExtras(this.bf);
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject2, null);
        }
        else
        {
          if (!this.bf.getBoolean("key_share_from_screen_shot", false)) {
            break label783;
          }
          ((Intent)localObject2).putExtras(this.bf);
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject2, null);
        }
      }
      if (bool4)
      {
        this.bf.putString("leftBackText", acfp.m(2131706476));
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtras(this.bf);
        bool4 = aa((Intent)localObject2);
        boolean bool5 = this.bf.getBoolean("isFromFavorites");
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool5 + "isFromAIOFav=" + bool4);
        }
        if (!this.cgS) {
          break label1070;
        }
        this.mActivity.startActivity((Intent)localObject2);
        if (QSecFramework.a().c(1003).booleanValue())
        {
          arnv.a().n(3, this.bf.getString("forward_filepath"), j, str1);
          arnv.a().report();
        }
      }
      this.bf.putInt("forward_source_uin_type", this.mActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject2).putExtras(this.bf);
    } while ((!bool2) && (!bool3));
    label783:
    label951:
    localObject1 = "";
    if (j == 0) {
      localObject1 = "0X8007812";
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      ((Intent)localObject2).removeExtra("forward_filepath");
      ((Intent)localObject2).removeExtra("forward_extra");
      this.mActivity.startActivity((Intent)localObject2);
      break;
      label1070:
      if (bool1) {
        break label951;
      }
      ForwardUtils.a(this.app, this.mActivity, this.mAppContext, (Intent)localObject2, null);
      break label951;
      if (j == 1) {
        localObject1 = "0X8007813";
      } else if (j == 3000) {
        localObject1 = "0X8007814";
      }
    }
  }
  
  public boolean anj()
  {
    super.anj();
    if (TextUtils.isEmpty(this.bKv)) {
      this.bKv = this.bf.getString("forward_filepath");
    }
    if ((this.mIntent.getBooleanExtra("sendMultiple", false)) && (this.mIntent.getStringArrayListExtra("foward_key_m_p_l") == null))
    {
      Object localObject = this.bf.get("android.intent.extra.STREAM");
      if ((localObject != null) && ((localObject instanceof ArrayList)))
      {
        localObject = (ArrayList)localObject;
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          String str = f((Uri)((ArrayList)localObject).get(i));
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          }
          i += 1;
        }
        this.bf.putStringArrayList("foward_key_m_p_l", localArrayList);
      }
    }
    return true;
  }
  
  public boolean anl()
  {
    if (anq()) {
      return anF();
    }
    return anG();
  }
  
  public boolean ann()
  {
    return true;
  }
  
  public boolean ans()
  {
    return true;
  }
  
  public boolean ant()
  {
    return this.bf.getBoolean("key_allow_multiple_forward_from_limit", true);
  }
  
  public View cc()
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131559147, null);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a = new a(null);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.dummyFirstPreviewImage = ((TextView)localView.findViewById(2131366154));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.previewImage = ((TextView)localView.findViewById(2131373567));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.framePreviewImage = ((ImageView)localView.findViewById(2131367585));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.framePreview = localView.findViewById(2131367584);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.editPicTag = ((TextView)localView.findViewById(2131365849));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.progressBar = ((ProgressBar)localView.findViewById(2131365894));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.framePreview.setMinimumHeight(aqnm.dip2px(85.0F));
    int i = aqnm.dip2px(15.0F);
    localView.setPadding(0, i, 0, i);
    don();
    ArrayList localArrayList = this.bf.getStringArrayList("foward_key_m_p_l");
    if (localArrayList != null)
    {
      TextView localTextView = (TextView)localView.findViewById(2131365863);
      localTextView.setVisibility(0);
      localTextView.setText(acfp.m(2131706475) + localArrayList.size() + acfp.m(2131706472));
    }
    return localView;
  }
  
  public void dnO()
  {
    super.dnO();
    int i = getExtras().getInt("key_forward_ability_type");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "-->getCancelListener--onClick--type = " + i);
    }
    if (i == ad.intValue()) {
      rar.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  public void dnP()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a != null)
    {
      View.OnClickListener localOnClickListener = a(new ahiz(this));
      if ((localOnClickListener != null) && (this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.framePreviewImage != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.framePreviewImage.setOnClickListener(localOnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardPhotoOption$a.framePreviewImage.setContentDescription(acfp.m(2131706477));
      }
    }
  }
  
  public void dnU()
  {
    Object localObject1;
    String str;
    Object localObject2;
    label94:
    ArrayList localArrayList;
    syw localsyw;
    if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      localObject1 = this.bKv;
      str = this.bf.getString("uin");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!TextUtils.isEmpty(ahbj.getExtension((String)localObject1))) {
          break label292;
        }
        localObject2 = acbn.SDCARD_PATH + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        aqhq.copyFile((String)localObject1, (String)localObject2);
        localObject1 = localObject2;
        localObject2 = (szy)this.app.getBusinessHandler(49);
        localArrayList = new ArrayList();
        localArrayList.add(localObject1);
        localsyw = (syw)this.app.getBusinessHandler(51);
        if ((!localsyw.bn(Long.parseLong(str))) || (!localsyw.i(Long.parseLong(str), 17))) {
          break label295;
        }
      }
    }
    label292:
    label295:
    for (boolean bool = true;; bool = false)
    {
      if (Boolean.valueOf(bool).booleanValue()) {
        break label300;
      }
      ((szy)localObject2).a().a(szy.aIl, str, localArrayList);
      this.mActivity.finish();
      return;
      localObject2 = this.bf.getString("forward_extra");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.mIntent.getStringExtra("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.mIntent.getStringExtra("forward_filepath");
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.bf.getString("forward_filepath");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.bf.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
      this.bf.putString("forward_filepath", (String)localObject2);
      localObject1 = localObject2;
      break;
      break label94;
    }
    label300:
    localsyw.a(Long.parseLong(str), "", "", "", 0, null);
    super.aG((String)localObject1, str, "pic");
  }
  
  public void dnV()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
    anot.a(this.app, "CliOper", "", "", "0X8007816", "0X8007816", 0, 0, "", "", "", "");
    rar.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void dnr()
  {
    if (anx()) {
      this.cs.add(S);
    }
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    this.cs.add(Z);
    boolean bool1 = this.mIntent.getBooleanExtra("k_phonecontacts", true);
    if ((this.b != null) && (this.b.getType() == 10006)) {}
    for (;;)
    {
      bool1 = this.mIntent.getBooleanExtra("k_dataline", true);
      boolean bool2 = this.mIntent.getBooleanExtra("forward_is_selfie_face", false);
      if ((bool1) && (!bool2))
      {
        this.cs.add(W);
        this.cs.add(ab);
      }
      if ((this.mIntent.getBooleanExtra("k_smartdevice", true)) && (anz())) {
        this.cs.add(aa);
      }
      if (this.mIntent.getBooleanExtra("k_qzone", false)) {
        this.cs.add(V);
      }
      if (this.mIntent.getBooleanExtra("k_qqstory", false)) {
        this.cs.add(ad);
      }
      return;
      if ((anu()) && (bool1)) {
        this.cs.add(Y);
      }
    }
  }
  
  public void dns()
  {
    if (!TextUtils.isEmpty(this.bKv)) {
      this.e.setMessage(null);
    }
  }
  
  public void dnv()
  {
    ccu();
    if (this.cgQ)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.cgQ = false;
    }
    if (anq())
    {
      Object localObject1 = fg();
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
        super.h(localResultRecord.uin, localResultRecord.QD, localResultRecord.lk());
      }
      if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        int j = this.bf.getInt("KEY_MSG_FORWARD_ID", 0);
        localObject1 = ((List)localObject1).iterator();
        boolean bool = false;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          bool |= aqhr.a(this.app, this.bKv, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).lk(), ((ResultRecord)localObject2).QD, true, this.mActivity, j);
        }
        if (bool) {
          this.mActivity.setResult(-1);
        }
        return;
      }
      dnT();
      return;
    }
    super.dnN();
    if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      int i = this.bf.getInt("KEY_MSG_FORWARD_ID", 0);
      if (aqhr.a(this.app, this.bKv, this.bf.getString("uin"), this.bf.getInt("uintype"), this.bf.getString("troop_uin"), true, this.mActivity, i)) {
        this.mActivity.setResult(-1);
      }
      this.mActivity.finish();
      return;
    }
    dnT();
  }
  
  public void dt(Intent paramIntent)
  {
    ArrayList localArrayList3 = null;
    Object localObject = this.bf.getParcelableArrayList("fileinfo_array");
    ArrayList localArrayList1 = localArrayList3;
    if (localObject != null) {}
    try
    {
      localArrayList1 = (ArrayList)localObject;
      localArrayList3 = (ArrayList)this.bf.get("android.intent.extra.STREAM");
      if (localArrayList1 == null)
      {
        localArrayList1 = this.bf.getStringArrayList("foward_key_m_p_l");
        if ((localArrayList1 == null) || (localArrayList1.isEmpty()))
        {
          localArrayList1 = new ArrayList();
          int i = 0;
          while (i < localArrayList3.size())
          {
            localObject = (Uri)localArrayList3.get(i);
            localArrayList1.add(b(this.mActivity, (Uri)localObject));
            i += 1;
          }
          paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList1);
        }
      }
      else
      {
        paramIntent.putExtra("dataline_forward_type", 101);
        paramIntent.putExtra("sendMultiple", true);
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
  }
  
  public void du(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 101);
    Object localObject2 = this.bf.getString("forward_extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mIntent.getStringExtra("forward_extra");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.mIntent.getStringExtra("forward_filepath");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.bf.getString("forward_filepath");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.bf.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    QLog.d("ForwardOption.ForwardPhotoOption", 1, "sendDatalineSingle filePath: " + (String)localObject2);
    paramIntent.putExtra("filepath_copy", this.mIntent.getBooleanExtra("filepath_copy", false));
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
    auqv.aX(true, (String)localObject2);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      String str = this.bf.getString("forward_filepath");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "refresh forward preview,editPicPath:" + paramIntent + " :currentFile" + str);
      }
      if (!str.equals(paramIntent))
      {
        this.cgO = false;
        this.bf.remove("FORWARD_MSG_FOR_PIC");
        this.bf.putString("forward_filepath", paramIntent);
        this.bf.putString("forward_extra", paramIntent);
        this.bf.putBoolean("extra_is_edited_pic", true);
        Kd(paramIntent);
        c(this.bKv, this.e);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Vtm != null) {
      this.jdField_a_of_type_Vtm.destory();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
  }
  
  static class PhotoRunnable
    implements Runnable
  {
    WeakReference<Activity> cH;
    
    PhotoRunnable(Activity paramActivity)
    {
      this.cH = new WeakReference(paramActivity);
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardPhotoOption", 2, "preload peak");
      }
      if (((this.cH.get() instanceof Activity)) && (!((Activity)this.cH.get()).isFinishing())) {
        awsw.gC((Context)this.cH.get());
      }
    }
  }
  
  public static class a
  {
    public TextView dummyFirstPreviewImage;
    public TextView editPicTag;
    public View framePreview;
    public ImageView framePreviewImage;
    public TextView previewImage;
    public ProgressBar progressBar;
    
    public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      if (paramDrawable == null) {
        return;
      }
      if (paramBoolean1)
      {
        this.framePreview.setVisibility(0);
        this.previewImage.setVisibility(8);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        this.framePreviewImage.setLayoutParams(localLayoutParams);
        if (!paramBoolean2)
        {
          this.framePreviewImage.setAdjustViewBounds(true);
          this.framePreviewImage.setMaxHeight(aqnm.dip2px(140.0F));
          this.framePreviewImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        for (;;)
        {
          this.framePreviewImage.setImageDrawable(paramDrawable);
          if (paramInt >= 2) {
            break;
          }
          this.framePreview.setBackgroundDrawable(null);
          return;
          this.framePreviewImage.setAdjustViewBounds(true);
          this.framePreviewImage.setMaxWidth(aqnm.dip2px(120.0F));
          this.framePreviewImage.setMaxHeight(aqnm.dip2px(120.0F));
          this.framePreviewImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (paramInt == 2)
        {
          this.framePreview.setBackgroundResource(2130840515);
          return;
        }
        this.framePreview.setBackgroundResource(2130840516);
        return;
      }
      this.framePreview.setVisibility(8);
      this.previewImage.setVisibility(0);
      this.previewImage.setCompoundDrawablePadding(0);
      this.previewImage.setCompoundDrawables(paramDrawable, null, null, null);
      if (paramDrawable != null)
      {
        this.previewImage.setVisibility(0);
        return;
      }
      this.previewImage.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption
 * JD-Core Version:    0.7.0.1
 */