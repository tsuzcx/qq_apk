package com.tencent.biz.qqstory.takevideo;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import anhm;
import ankq;
import anot;
import anpc;
import aqhu;
import atao;
import awtj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import plr;
import psr;
import psx;
import ptb;
import ram;
import rar;
import ras;
import rbn;
import rdc;
import rel;
import rkm;
import rkq;
import rns;
import rox;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements rel
{
  public rdc a;
  
  private void bsu()
  {
    psr localpsr = (psr)psx.a(10);
    boolean bool1 = ((Boolean)localpsr.c("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
    boolean bool2 = ((Boolean)localpsr.c("boolean_enable_flow_decode", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = ((Boolean)localpsr.c("boolean_use_flow_decode_first", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "check reverse play mode. enableIFrameRevert = " + bool1 + ", enableFlowRevert = " + bool2 + ", useFlowDecodeFirst = " + bool3);
    if (bool3)
    {
      if (bool2)
      {
        alzf.cBz = true;
        alzf.aHn = true;
        return;
      }
      if (bool1)
      {
        alzf.cBz = true;
        alzf.aHn = false;
        return;
      }
      alzf.cBz = false;
      alzf.aHn = false;
      return;
    }
    if (bool1)
    {
      alzf.cBz = true;
      alzf.aHn = false;
      return;
    }
    if (bool2)
    {
      alzf.cBz = true;
      alzf.aHn = true;
      return;
    }
    alzf.cBz = false;
    alzf.aHn = false;
  }
  
  private void bsx()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    ram.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 51200L)
    {
      ram.w("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((ptb)psx.a(26)).vV(2);
      return;
    }
    ((ptb)psx.a(26)).vV(0);
  }
  
  public Intent a(rkm paramrkm)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource))
    {
      Intent localIntent = getIntent();
      localObject1 = localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      ArrayList localArrayList = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      Object localObject2;
      if ((paramrkm.a.aIF) || (!paramrkm.a.result)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.sourcePath))
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
          localIntent.putExtra("need_combine_gif", paramrkm.a.aGy);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + paramrkm.a.aGy);
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(localEditLocalGifSource.sourcePath)) {
          break label507;
        }
        localIntent.putExtra("orign_path", localEditLocalGifSource.getSourcePath());
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramrkm.g.doodlePath);
        localIntent.putExtra("gif_delay_time", paramrkm.a.bsS);
        localIntent.putExtra("gif_has_antishake", this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.aGr);
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeGifSource)) {
          localIntent.putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        localArrayList.add(localObject2);
        aqhu.cn(this, (String)localObject2);
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.addFlags(603979776);
        localIntent.putExtra("PhotoConst.SEND_FLAG", true);
        return localIntent;
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.aGr) {
          if ((localEditLocalGifSource.nt != null) && (localEditLocalGifSource.nt.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.nt.get(0);
          }
        }
        for (;;)
        {
          if (!paramrkm.a.aGy) {
            localIntent.putExtra("use_orign", true);
          }
          localIntent.putExtra("need_combine_gif", true);
          break;
          localObject1 = "";
          continue;
          if ((localEditLocalGifSource.ns != null) && (localEditLocalGifSource.ns.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.ns.get(0);
          } else {
            localObject1 = "";
          }
        }
        localObject2 = paramrkm.a.aAZ;
        localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        localIntent.putExtra("need_combine_gif", true);
      }
      label507:
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.aGr) {
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.nt);
      }
      for (;;)
      {
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramrkm.g.doodlePath);
        localIntent.putExtra("gif_delay_time", paramrkm.a.bsS);
        localIntent.putExtra("gif_has_antishake", this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.aGr);
        break;
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.ns);
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(PublishParam.BUNDLE_EXTRA_KEY, paramrkm.b);
    return localObject1;
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    int i = getIntent().getIntExtra("entrance_type", 99);
    Intent localIntent = paramIntent;
    if (i == 15)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("entrance_type", i);
    }
    setResult(paramInt1, localIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    bsx();
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    if ((Build.MODEL.equals("HM NOTE 1TD")) && (Build.VERSION.SDK_INT < 18))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoActivity", "disable show loading dialog");
      return;
    }
    super.a(paramCharSequence, paramBoolean, paramLong);
  }
  
  protected void aV(Bundle paramBundle) {}
  
  public void bpG()
  {
    super.bpG();
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "onOutOfMemory");
    bsx();
  }
  
  protected void bsv()
  {
    if (this.a == null) {
      this.a = new rdc();
    }
  }
  
  public void bsw()
  {
    if (this.a.jdField_a_of_type_Rbh != null) {
      return;
    }
    ((TrimTextureVideoView)findViewById(2131367295)).stopPlay();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i;
    if ((paramInt1 == 10004) || (paramInt1 == 10010))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "quick shoot onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        SessionInfo localSessionInfo = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (localSessionInfo != null) {
          getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo);
        }
        if (paramInt1 != 10010) {
          break label218;
        }
        getIntent().putExtra("forward_source_from_pre_guide", true);
        int j = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
        i = j;
        if (j == 0)
        {
          i = j;
          if (paramInt1 == 10010) {
            i = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
          }
        }
        if (i != 1002) {
          break label233;
        }
        a(paramInt2, paramIntent, 2130772067, 0);
      }
    }
    for (;;)
    {
      ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label218:
      getIntent().putExtra("forward_source_from_shoot_quick", true);
      break;
      label233:
      if (i == 1003)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi = 1;
        this.a.bsn();
      }
      else
      {
        a(paramInt2, paramIntent, 2130772067, 0);
        continue;
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void doOnBackPressed()
  {
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.a.onBackPressed()) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    bsu();
    atao.dgW = false;
    atao.init();
    awtj.init();
    ram.d("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
    bsv();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    anhm.c(QQStoryContext.a().dE(), this);
    rbn.b(QQStoryContext.a().dE(), this);
    try
    {
      ankq.axX();
      if (VideoEnvironment.d("AVCodec", getApplicationContext()) != 0)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed");
        finish();
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed", paramBundle);
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("uintype", -1);
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent().getBooleanExtra("extra_has_antishake", false)) && (localEditVideoParams != null) && ((localEditVideoParams.a instanceof EditLocalGifSource)))
    {
      localObject = (EditLocalGifSource)localEditVideoParams.a;
      ((EditLocalGifSource)localObject).nt = getIntent().getStringArrayListExtra("extra_antishake_gif_path_list");
      if ((((EditLocalGifSource)localObject).nt != null) && (((EditLocalGifSource)localObject).nt.size() > 1)) {
        ((EditLocalGifSource)localObject).hasAntishake = true;
      }
    }
    if ((localEditVideoParams != null) && ((localEditVideoParams.a instanceof EditLocalGifSource))) {
      ((EditLocalGifSource)localEditVideoParams.a).checkedSimilarityOK = getIntent().getIntExtra("extra_checked_similarity_ok_to_antishake", 0);
    }
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (Object localObject = localEditVideoParams.mT(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      QQToast.a(this, acfp.m(2131705587) + (String)localObject, 0).show();
      finish();
      return true;
    }
    String str2 = getIntent().getStringExtra("op_department");
    String str3 = getIntent().getStringExtra("op_type");
    String str1 = str3;
    localObject = str2;
    if (localEditVideoParams != null)
    {
      str1 = str3;
      localObject = str2;
      if (localEditVideoParams.asi == 1)
      {
        localObject = "grp_story";
        str1 = "video_edit";
      }
    }
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str1 });
    try
    {
      VideoSourceHelper.nativeSetPlayStepFrameCount(1);
      VideoSourceHelper.nativeSetPlayGapFrameCount(1);
      getWindow().addFlags(1024);
      setContentViewC(2131562001);
      aV(paramBundle);
      if (localEditVideoParams.mExtra != null)
      {
        localEditVideoParams.mExtra.putInt("uintype", i);
        rns.g("Q.qqstory.publish.edit.EditVideoActivity", localEditVideoParams.mExtra);
        this.a.a(this, localEditVideoParams);
        this.a.onCreate();
        rox.sG(plr.atc);
        ras.azm = (String)localObject;
        ras.azn = str1;
        if ((!ras.KP()) || (VideoEnvironment.Jr() < 21)) {}
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          VideoSourceHelper.nativeSetMaxPhotoFrameCount(3);
          ram.d("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity set min frame!");
          ras.so("0X80076B5");
          if (localEditVideoParams.asi == 2)
          {
            if (i != 1) {
              break;
            }
            paramBundle = "3";
            rar.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1", paramBundle });
          }
          LpReportInfo_pf00064.allReport(628, 1);
          ram.d("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
          if (localEditVideoParams.asi == 10) {
            anot.a(null, "dc00899", "Grp_tribe", "", "video_edit", "exp_edit", 0, 0, "", "", "", "");
          }
          bsx();
          if ((localEditVideoParams.asi == 10) || (localEditVideoParams.asi == 12)) {
            ((RelativeLayout)findViewById(2131366264)).setBackgroundColor(-16777216);
          }
          anpc.report("exposure_old_editVideo");
          return true;
          localThrowable = localThrowable;
          QLog.w("Q.qqstory.publish.edit.EditVideoActivity", 1, "VideoSourceHelper error:", localThrowable);
        }
        ram.e("Q.qqstory.publish.edit.EditVideoActivity", "video editVideoParams.mExtra is null!!");
      }
      catch (UnsatisfiedLinkError paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "nativeSetMaxPhotoFrameCount:exp=", paramBundle);
            continue;
            if (i == 3000) {
              paramBundle = "2";
            } else {
              paramBundle = "1";
            }
          }
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.a.onDestroy();
    ras.azm = "";
    ras.azn = "";
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.a.onPause();
    ThreadManagerV2.excute(new EditVideoActivity.2(this), 16, null, false);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnRestoreInstanceState");
    this.a.onRestoreInstanceState(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnResume");
    this.a.onResume();
    ThreadManagerV2.excute(new EditVideoActivity.1(this), 16, null, false);
    bsw();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnSaveInstanceState");
    this.a.onSaveInstanceState(paramBundle);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnStart");
    this.a.onStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.a.onStop();
  }
  
  @NonNull
  public View getRootView()
  {
    return getWindow().getDecorView();
  }
  
  @NonNull
  public Activity m()
  {
    return this;
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    bsx();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */