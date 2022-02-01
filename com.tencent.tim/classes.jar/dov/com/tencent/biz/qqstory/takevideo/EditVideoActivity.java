package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqhu;
import atao;
import awrz;
import awtj;
import axim;
import axip;
import axiy;
import axov;
import axvu;
import axvv;
import axyr;
import ayfw;
import aygz;
import ayii;
import ayjw;
import ayjw.c;
import ayqb;
import ayqh;
import ayva;
import ayva.c;
import ayxa;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import plr;
import psx;
import ptb;
import ram;
import rar;
import ras;
import rox;
import shb;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements ayii, ayva.c
{
  public aygz a;
  protected boolean dyN = true;
  public long mCreateTime = -1L;
  private RelativeLayout og;
  
  private void aMX()
  {
    long l1 = getIntent().getLongExtra("stop_record_time", -1L);
    int j = this.a.QD();
    int k = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th();
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1) {
      if (l1 <= 0L) {
        break label222;
      }
    }
    label222:
    for (int i = (int)(this.mCreateTime - l1);; i = 0)
    {
      long l2 = this.a.getVideoTime();
      rar.b("time_openedit", 1, i, new String[] { rar.bY(j), String.valueOf(l2), "", String.valueOf(k) });
      if ((axvu.dwO) && (l1 != -1L))
      {
        axvu.f.startMonitor();
        axvu.f.busType = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi;
        axvu.f.ay(0, l1);
        axvu.f.ay(1, this.mCreateTime);
      }
      i = this.a.RR();
      getIntent().putExtra("capture_operation_in", i);
      rar.b("edit_exp", i, 0, new String[] { rar.bY(j), "", "", String.valueOf(k) });
      return;
    }
  }
  
  private boolean aQv()
  {
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent() != null) && (getIntent().getIntExtra("qqstory_slide_show_scene", -1) == 22)) {}
    for (int i = 1;; i = 0) {
      return (localEditVideoParams != null) && (localEditVideoParams.asi == 3) && (i == 0);
    }
  }
  
  private void bsx()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    ram.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 10240L)
    {
      ram.w("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((ptb)psx.a(26)).vV(2);
      return;
    }
    ((ptb)psx.a(26)).vV(0);
  }
  
  private void eQL()
  {
    if (ayxa.aRq())
    {
      this.og = ((RelativeLayout)findViewById(2131370603));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.og.getLayoutParams();
      localLayoutParams.height = ayxa.Sk();
      this.og.setLayoutParams(localLayoutParams);
      this.og.setVisibility(0);
    }
  }
  
  private void eRb()
  {
    View localView1 = findViewById(2131364110);
    if ((localView1 != null) && ((localView1 instanceof ViewGroup)))
    {
      View localView2 = findViewById(2131374675);
      if (localView2 != null) {
        ((ViewGroup)localView1).removeView(localView2);
      }
    }
  }
  
  private void eRc()
  {
    atao.dgW = true;
    ThreadManager.excute(new EditVideoActivity.6(this), 16, null, true);
  }
  
  public void CT(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Ayeh != null) {
      ThreadManager.getUIHandler().post(new EditVideoActivity.7(this));
    }
  }
  
  public Intent a(ayqb paramayqb)
  {
    Object localObject3;
    Object localObject4;
    Object localObject2;
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource))
    {
      localObject3 = getIntent();
      localObject1 = ((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject3).setClassName(((Intent)localObject3).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      localObject4 = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      if ((paramayqb.a.aIF) || (!paramayqb.a.result)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.sourcePath))
        {
          localObject1 = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
          ((Intent)localObject3).putExtra("need_combine_gif", paramayqb.a.aGy);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + paramayqb.a.aGy);
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(localEditLocalGifSource.sourcePath)) {
          break label516;
        }
        ((Intent)localObject3).putExtra("orign_path", localEditLocalGifSource.getSourcePath());
        ((Intent)localObject3).putExtra("combine_image_path", (String)localObject2);
        ((Intent)localObject3).putExtra("doodle_bitmap_path", paramayqb.g.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", paramayqb.a.bsS);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.aGr);
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeGifSource)) {
          ((Intent)localObject3).putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        ((ArrayList)localObject4).add(localObject2);
        aqhu.cn(this, (String)localObject2);
        ((Intent)localObject3).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject4);
        ((Intent)localObject3).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject4).get(0));
        ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        ((Intent)localObject3).addFlags(603979776);
        ((Intent)localObject3).putExtra("PhotoConst.SEND_FLAG", true);
        return localObject3;
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.aGr) {
          if ((localEditLocalGifSource.nt != null) && (localEditLocalGifSource.nt.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.nt.get(0);
          }
        }
        for (;;)
        {
          if (!paramayqb.a.aGy) {
            ((Intent)localObject3).putExtra("use_orign", true);
          }
          ((Intent)localObject3).putExtra("need_combine_gif", true);
          break;
          localObject1 = "";
          continue;
          if ((localEditLocalGifSource.ns != null) && (localEditLocalGifSource.ns.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.ns.get(0);
          } else {
            localObject1 = "";
          }
        }
        localObject2 = paramayqb.a.aAZ;
        ((Intent)localObject3).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        ((Intent)localObject3).putExtra("need_combine_gif", true);
      }
      label516:
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.aGr) {
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.nt);
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("combine_image_path", (String)localObject2);
        ((Intent)localObject3).putExtra("doodle_bitmap_path", paramayqb.g.doodlePath);
        ((Intent)localObject3).putExtra("gif_delay_time", paramayqb.a.bsS);
        ((Intent)localObject3).putExtra("gif_has_antishake", this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.aGr);
        break;
        ((Intent)localObject3).putExtra("orign_list_path", localEditLocalGifSource.ns);
      }
    }
    if (this.a.w == null) {}
    for (Object localObject1 = new Intent();; localObject1 = this.a.w)
    {
      ((Intent)localObject1).putExtra("widgetinfo", getIntent().getStringExtra("widgetinfo"));
      localObject2 = getIntent().getStringExtra("key_camera_material_name");
      ((Intent)localObject1).putExtra("key_camera_material_name", (String)localObject2);
      axiy.i("EditVideoActivity", "AIO send video---takeSameName=" + (String)localObject2);
      localObject3 = null;
      localObject2 = localObject3;
      if (this.a.jdField_a_of_type_Ayfw != null)
      {
        localObject2 = localObject3;
        if (this.a.jdField_a_of_type_Ayfw.a() != null)
        {
          localObject2 = localObject3;
          if (this.a.jdField_a_of_type_Ayfw.a().a() != null) {
            localObject2 = this.a.jdField_a_of_type_Ayfw.a().a().mItems;
          }
        }
      }
      localObject3 = new JSONArray();
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (ayjw.c)((Iterator)localObject2).next();
        if ((((ayjw.c)localObject4).c != null) && (((ayjw.c)localObject4).c.a() != null)) {
          ((JSONArray)localObject3).put(((ayjw.c)localObject4).c.a().toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "EditVideoActivity getPublishIntent, content is: " + ((JSONArray)localObject3).toString());
    }
    ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject3).toString());
    ((Intent)localObject1).putExtra(PublishParam.BUNDLE_EXTRA_KEY, paramayqb.b);
    return localObject1;
  }
  
  public aygz a()
  {
    return this.a;
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, new Object[] { "finish, publishStoryFlag ", Boolean.valueOf(paramBoolean) });
    }
    dov.com.qq.im.QIMEffectCameraCaptureUnit.drT = paramBoolean;
    awtq.dsy = paramBoolean;
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi != 3)
    {
      ayva.a().a(null, this, this.a.RS());
      ayva.a().a(null);
    }
    int i = getIntent().getIntExtra("take_video_entrance_type", 99);
    Intent localIntent = paramIntent;
    if (i == 15)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("take_video_entrance_type", i);
    }
    paramIntent = localIntent;
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra != null)
    {
      paramBoolean = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra.getBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
      String str = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra.getString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA");
      paramIntent = localIntent;
      if (paramBoolean)
      {
        paramIntent = localIntent;
        if (!TextUtils.isEmpty(str))
        {
          paramIntent = localIntent;
          if (localIntent == null) {
            paramIntent = new Intent();
          }
          paramIntent.putExtra("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", str);
        }
      }
    }
    localIntent = paramIntent;
    if (this.a.aQD())
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("key_edit_to_photo_list", true);
    }
    setResult(paramInt1, localIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.a.onActivityFinish();
    bsx();
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
      this.a = new aygz();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10004)
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
        getIntent().putExtra("forward_source_from_shoot_quick", true);
        if (paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0) != 1003) {
          break label185;
        }
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi = 1;
        this.a.bsn();
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
      ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
      return;
      label185:
      a(paramInt2, paramIntent, 2130772067, 0);
    }
  }
  
  public void doOnBackPressed()
  {
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.a.onBackPressed()) {
      super.doOnBackPressed();
    }
    eRb();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    ayxa.resetAllLiuHaiStatus();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    atao.init();
    awtj.init();
    ram.d("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
    bsv();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    if (!aQv()) {
      eRc();
    }
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    ThreadManager.getFileThreadHandler().post(new EditVideoActivity.1(this));
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.2(this));
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent().getBooleanExtra("extra_has_antishake", false)) && (localEditVideoParams != null) && ((localEditVideoParams.a instanceof EditLocalGifSource)))
    {
      localObject = (EditLocalGifSource)localEditVideoParams.a;
      ((EditLocalGifSource)localObject).nt = getIntent().getStringArrayListExtra("extra_antishake_gif_path_list");
      if ((((EditLocalGifSource)localObject).nt != null) && (((EditLocalGifSource)localObject).nt.size() > 1)) {
        ((EditLocalGifSource)localObject).hasAntishake = true;
      }
    }
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (Object localObject = localEditVideoParams.mT(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      QQToast.a(this, acfp.m(2131705698) + (String)localObject, 0).show();
      finish();
      return true;
    }
    localObject = getIntent().getStringExtra("op_department");
    String str = getIntent().getStringExtra("op_type");
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str });
    ayxa.resetAllLiuHaiStatus();
    ayxa.resetFullScreen(this);
    ayxa.cX(this);
    if (ayxa.aRq()) {
      ayxa.enableNotch(this);
    }
    this.a.dzj = true;
    setContentViewC(2131559264);
    aV(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131705479), 0).show();
      finish();
      return true;
    }
    eQL();
    int i = getIntent().getIntExtra("edit_video_way", 0);
    this.a.setFrom(i);
    this.a.a(this, localEditVideoParams);
    paramBundle = (awrz)axov.a(13);
    paramBundle.acY(8);
    paramBundle.Gf(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg());
    this.a.onCreate();
    rox.sG(plr.atc);
    ras.azm = (String)localObject;
    ras.azn = str;
    ras.so("0X80076B5");
    rar.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1" });
    LpReportInfo_pf00064.allReport(628, 1);
    ram.d("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
    sendBroadcast(new Intent("action_fire_get_config"));
    bsx();
    ((awrz)axov.a(13)).acZ(1);
    eRd();
    this.mCreateTime = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new EditVideoActivity.3(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ram.w("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.a.onDestroy();
    ras.azm = "";
    ras.azn = "";
    axvu.d.stopMonitor();
    ((awrz)axov.a(13)).acZ(1);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.a.onPause();
    ThreadManagerV2.excute(new EditVideoActivity.5(this), 16, null, false);
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
    ThreadManagerV2.excute(new EditVideoActivity.4(this), 16, null, false);
    ((awrz)axov.a(13)).xL(1);
    if (Build.VERSION.SDK_INT >= 29) {
      shb.e(getWindow());
    }
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
    axim.a().eKz();
    axip.a().eLt();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ram.i("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.a.onStop();
    axim.a().eKA();
    axiy.i("Q.qqstory.publish.edit.EditVideoActivity", "【doOnStop】");
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.a.onWindowFocusChanged(paramBoolean);
  }
  
  protected void eRd()
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 14) {
      axyr.registerModule();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */