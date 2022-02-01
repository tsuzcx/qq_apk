package com.tencent.biz.qqstory.takevideo;

import aarz;
import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import ankq;
import anpc;
import aqhq;
import aqhu;
import atao;
import awtj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.a;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import ram;
import rar;
import ras;
import rbm;
import rbn;
import rbp;
import rdc;
import rel;
import rkm;
import rkq;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements rel
{
  PtvTemplateManager.a a;
  public rdc a;
  
  public EditPicActivity()
  {
    this.jdField_a_of_type_Rdc = new rbp();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$a = new rbm(this);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt, 99);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, 99, 0, false, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean6, HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent(paramActivity.getIntent());
    localIntent.setClass(paramActivity, ArtFilterBridgeActivity.class);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    if ((paramActivity instanceof SplashActivity)) {
      localIntent.putExtra("key_activity_code", ChatActivityUtils.d(paramActivity));
    }
    int j = 0;
    if (paramBoolean1) {
      j = 1;
    }
    int i = j;
    if (paramBoolean2) {
      i = j | 0x4;
    }
    j = i;
    if (paramBoolean3) {
      j = i | 0x8;
    }
    i = j;
    if (paramBoolean4) {
      i = j | 0x2;
    }
    j = i;
    if (paramInt1 == 2) {
      j = i | 0x800;
    }
    j |= 0x400;
    i = j;
    if (paramInt1 == 2) {
      i = j | 0x40000;
    }
    localIntent.putExtra("EDIT_BUSI", paramInt1);
    localIntent.putExtra("entrance_type", paramInt2);
    localIntent.putExtra("pic_entrance_type", paramInt3);
    localIntent.putExtra("TEMP_PARAM", i);
    localIntent.putExtra("PATH", paramString);
    localIntent.putExtra("USE_FILTER", paramBoolean5);
    localIntent.putExtra("go_publish_activity", paramBoolean6);
    if (paramHashMap != null) {
      localIntent.putExtra("user_params", paramHashMap);
    }
    localIntent.removeExtra("camera_type");
    if (paramActivity.getClass().getName().contains("ForwardRecentActivity")) {
      return c(localIntent);
    }
    return localIntent;
  }
  
  private Intent a(Intent paramIntent, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return paramIntent;
    case 101: 
    case 104: 
      paramString2 = ForwardRecentActivity.class.getName();
      paramIntent.putExtra("forward_type", 1);
      paramIntent.putExtra("forward_ability_entrence_show_in_share", true);
      paramIntent.putExtra("k_qzone", true);
      paramIntent.putExtra("k_qqstory", true);
      paramIntent.putExtra("k_smartdevice", false);
      paramIntent.putExtra("k_favorites", false);
      paramIntent.putExtra("k_phonecontacts", false);
      paramIntent.putExtra("forward_filepath", paramString1);
      paramIntent.putExtra("forward_extra", paramString1);
      paramIntent.putExtra("forward_thumb", paramString1);
      paramIntent.putExtra("forward_urldrawable", true);
      paramIntent.putExtra("forward_urldrawable_big_url", paramString1);
      paramIntent.putExtra("forward_urldrawable_thumb_url", paramString1);
      paramIntent.putExtra("forward_photo_shortvideo_is_edited", true);
      if (paramInt == 104) {
        paramIntent.putExtra("forward_source_from_pre_guide", true);
      }
      for (;;)
      {
        paramIntent.setClassName("com.tencent.mobileqq", paramString2);
        return paramIntent;
        paramIntent.putExtra("forward_source_from_shoot_quick", true);
      }
    }
    paramIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
    return paramIntent;
  }
  
  public static Intent c(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramIntent.getFlags();
      if ((0x80000 & i) > 0) {
        paramIntent.setFlags(i & 0xFFF7FFFF);
      }
    }
    return paramIntent;
  }
  
  public Intent a(rkm paramrkm)
  {
    Object localObject2 = getIntent();
    String str1 = ((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    String str2 = ((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME");
    ((Intent)localObject2).setClassName(str2, str1);
    ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
    ((Intent)localObject2).putExtra("PhotoConst.HAS_CROP", paramrkm.a.aIG);
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramrkm.a.aIF) || (!paramrkm.a.result))
    {
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject1 = this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
      localArrayList.add(localObject1);
      ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject2).putExtra("PhotoConst.SEND_FLAG", true);
      ((Intent)localObject2).putExtra("video_sync_to_story", paramrkm.aID);
      ((Intent)localObject2).addFlags(603979776);
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject2).getFlags() + ",data = " + ((Intent)localObject2).getExtras());
      }
      localObject1 = a((Intent)localObject2, this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), (String)localObject1, str1, str2);
      paramrkm = (rkm)localObject1;
      if (str1.contains("ForwardRecentActivity")) {
        paramrkm = c((Intent)localObject1);
      }
      localObject1 = paramrkm.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject2 = paramrkm.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      if ((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject1)) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str1)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject2))) {
        break label425;
      }
      paramrkm.setClassName(paramrkm.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
    }
    for (;;)
    {
      paramrkm.putExtra("open_chatfragment_fromphoto", true);
      return paramrkm;
      localObject1 = paramrkm.a.aAZ;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        aqhq.deleteFile(paramrkm.a.aAY);
        new File(paramrkm.a.aAY);
        aqhu.cn(this, paramrkm.a.aAY);
      }
      ((Intent)localObject2).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label425:
      if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str1)) {
        paramrkm.setClassName("com.tencent.mobileqq", (String)localObject1);
      }
    }
  }
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
  }
  
  protected void aV(Bundle paramBundle) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    ram.i("EditPicActivity", "doOnActivityResult");
    this.jdField_a_of_type_Rdc.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 666)
    {
      if (paramInt2 == -1)
      {
        localObject2 = getIntent();
        ((Intent)localObject2).setClass(this, EditPicActivity.class);
        if (((Intent)localObject2).getIntExtra("camera_type", -1) == 103) {}
        for (paramIntent = this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();; paramIntent = ((Intent)localObject2).getStringExtra("image_path"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity", 2, "reset2Camera end shoot " + this + " new path " + paramIntent);
          }
          localObject1 = paramIntent;
          if (TextUtils.isEmpty(paramIntent))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(this).getString("edit_pic_new_path", "");
            QLog.d("EditPicActivity", 1, " be killed. read sp " + (String)localObject1);
          }
          if (aqhq.fileExists((String)localObject1)) {
            break;
          }
          QLog.i("EditPicActivity", 1, "recamera file not exist " + (String)localObject1);
          QQToast.a(this, acfp.m(2131705446), 0).show();
          finish();
          return;
        }
        paramIntent = new EditVideoParams(this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi, this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, new EditTakePhotoSource((String)localObject1, 2, 0, 0), EditVideoParams.c(this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg()));
        ((Intent)localObject2).putExtra(EditVideoParams.class.getName(), paramIntent);
        finish();
        startActivity((Intent)localObject2);
        return;
      }
      ram.i("EditPicActivity", "recamera cancel, finish");
      finish();
      return;
    }
    if (paramInt1 == 1000) {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
        int i = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
        if (paramInt1 != 0) {
          break label529;
        }
        paramInt1 = i;
      }
    }
    label529:
    for (;;)
    {
      if (paramInt1 == 1003)
      {
        localObject2 = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        localObject1 = null;
        paramIntent = (Intent)localObject1;
        if (localObject2 != null)
        {
          paramIntent = (Intent)localObject1;
          if (((ArrayList)localObject2).size() > 0) {
            paramIntent = (String)((ArrayList)localObject2).get(0);
          }
        }
        this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi = 1;
        this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a = new EditTakePhotoSource(paramIntent, 2, this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth(), this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight());
        this.jdField_a_of_type_Rdc.bsZ();
        return;
      }
      a(paramInt2, paramIntent, 2130772067, 0);
      return;
      this.jdField_a_of_type_Rdc.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 != 1001) {
        break;
      }
      a(paramInt2, paramIntent, 2130772067, 0);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    ram.i("EditPicActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Rdc.onBackPressed()) {
      super.doOnBackPressed();
    }
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    atao.dgW = false;
    atao.init();
    awtj.init();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    rbn.b(QQStoryContext.a().dE(), this);
    int i = getIntent().getIntExtra("uintype", -1);
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    aarz.X("finish jump activity", aarz.c(getIntent()));
    ram.w("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if ((localEditVideoParams == null) || (TextUtils.isEmpty(localEditVideoParams.a.getSourcePath())))
    {
      QQToast.a(this, acfp.m(2131705443), 0).show();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + localEditVideoParams.a.getSourcePath());
    }
    if (!aqhq.fileExists(localEditVideoParams.a.getSourcePath()))
    {
      QQToast.a(this, acfp.m(2131705442), 0).show();
      finish();
      return true;
    }
    int j = getIntent().getIntExtra("editpic_cameratype", -1);
    if (j == 1)
    {
      aarz.cxF();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    try
    {
      for (;;)
      {
        ankq.axX();
        if (VideoEnvironment.d("AVCodec", super.getApplicationContext()) != 0) {
          ram.e("EditPicActivity", "load AVCodec so failed");
        }
        getWindow().addFlags(1024);
        setContentViewC(2131559766);
        aV(paramBundle);
        if (localEditVideoParams.mExtra == null) {
          break;
        }
        localEditVideoParams.mExtra.putInt("uintype", i);
        this.jdField_a_of_type_Rdc.a(this, localEditVideoParams);
        if (this.jdField_a_of_type_Rdc.b != null)
        {
          this.jdField_a_of_type_Rdc.b.azx = getIntent().getStringExtra("FILTER_STRING");
          this.jdField_a_of_type_Rdc.b.bpM = getIntent().getIntExtra("FILTER_MAXSIDE", 640);
          this.jdField_a_of_type_Rdc.b.azy = getIntent().getStringExtra("FILTER_LOADING_PATH");
        }
        if ((this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) && (this.jdField_a_of_type_Rdc.jdField_a_of_type_Rbo != null))
        {
          long l2 = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
          long l1 = l2;
          if (l2 == 0L) {
            l1 = getIntent().getLongExtra("arithmetic_ability", 0L) & 1L;
          }
          paramBundle = this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage;
          if (l1 <= 0L) {
            break label697;
          }
          bool = true;
          paramBundle.aGD = bool;
          paramBundle = this.jdField_a_of_type_Rdc.jdField_a_of_type_Rbo;
          if (l1 <= 0L) {
            break label703;
          }
          bool = true;
          paramBundle.aGD = bool;
        }
        this.jdField_a_of_type_Rdc.onCreate();
        PtvTemplateManager.a(this.mApp).a(this.mApp, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$a, false);
        if (localEditVideoParams.mExtra != null) {
          ras.wM(localEditVideoParams.mExtra.getInt("pic_entrance_type", 0));
        }
        rkq.i(null);
        if (localEditVideoParams.asi == 2)
        {
          if (i != 1) {
            break label709;
          }
          paramBundle = "3";
          rar.a("aio_shoot", "exp_edit", 0, 0, new String[] { "2", paramBundle });
        }
        anpc.report("exposure_old_editPic");
        return true;
        if (j == 2) {
          aarz.cxG();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ram.e("EditPicActivity", "load so failed", localException);
        continue;
        ram.e("EditPicActivity", "pic editVideoParams.mExtra is null!!");
        continue;
        label697:
        boolean bool = false;
        continue;
        label703:
        bool = false;
        continue;
        label709:
        if (i == 3000) {
          paramBundle = "2";
        } else {
          paramBundle = "1";
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ram.d("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_Rdc.onDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ram.i("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_Rdc.onPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ram.i("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_Rdc.onResume();
    aarz.AK("resume activity");
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ram.i("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_Rdc.onStart();
    ras.azm = ras.bZ(this.jdField_a_of_type_Rdc.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi);
    ras.azn = "pic_edit";
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ram.i("EditPicActivity", "doOnStop");
    this.jdField_a_of_type_Rdc.onStop();
    ras.azm = "";
    ras.azn = "";
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public View getRootView()
  {
    return getWindow().getDecorView();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */