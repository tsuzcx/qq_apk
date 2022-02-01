package dov.com.tencent.mobileqq.activity.richmedia;

import aaqj;
import aaqq;
import aaqq.a;
import acfp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import axov;
import axpr;
import ayii;
import aytw;
import ayum;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.ArrayList;
import rlr;
import rma;

public class QzoneEditVideoActivity
  extends EditVideoActivity
{
  private static final String TAG = QzoneEditVideoActivity.class.getSimpleName();
  private aytw b;
  private boolean dAV;
  private QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, aaqj paramaaqj, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.hs(str, paramString4);
    }
    aaqq.a locala = new aaqq.a();
    locala.E = this;
    locala.bdL = str;
    locala.mAudioFilePath = paramString1;
    locala.ciH = paramInt1;
    locala.aAu = paramString2;
    locala.mThumbFilePath = paramString3;
    locala.mThumbWidth = 0;
    locala.gP = 0;
    locala.fakeVid = paramString4;
    locala.ciC = paramInt2;
    locala.a = paramaaqj;
    locala.mContent = paramString5;
    locala.mPriv = paramInt3;
    locala.eo = paramArrayList;
    locala.topicSyncQzone = paramBoolean1;
    locala.fontId = paramInt4;
    locala.fontFormatType = paramInt5;
    locala.fontUrl = paramString6;
    locala.superFontId = paramInt6;
    locala.bdK = paramString7;
    locala.bxp = paramBoolean2;
    locala.bxq = paramBoolean3;
    locala.isSyncToQQStory = paramBoolean4;
    locala.bxr = paramBoolean5;
    locala.cii = 3;
    locala.mUin = "";
    locala.mUinType = 0;
    locala.mTroopUin = "";
    new aaqq(locala).execute(new Void[0]);
  }
  
  private boolean aB(Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    int j;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("key_content");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      j = paramIntent.getIntExtra("key_priv", 1);
      localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      if (localObject2 != null) {
        break label257;
      }
      localObject2 = new ArrayList();
    }
    label257:
    for (;;)
    {
      if (m().getIntent() != null) {
        m().getIntent().putExtra("from_qzone_slideshow", true);
      }
      int k = paramIntent.getIntExtra("key_font_id", -1);
      int m = paramIntent.getIntExtra("key_font_format_type", 0);
      String str1 = paramIntent.getStringExtra("key_font_url");
      int n = paramIntent.getIntExtra("key_super_font_id", -1);
      String str2 = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      if (localPublishParam.saveMode <= 5) {}
      for (int i = localPublishParam.saveMode;; i = 0)
      {
        int i1 = (int)localPublishParam.videoDuration;
        boolean bool4 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
        a(localPublishParam.audioFilePath, i, localPublishParam.videoFilePath, localPublishParam.thumbPath, localPublishParam.fakeVid, i1, null, (String)localObject1, j, (ArrayList)localObject2, false, k, m, str1, n, str2, bool1, bool2, bool3, bool4);
        return true;
      }
      return false;
    }
  }
  
  private boolean aRd()
  {
    boolean bool2 = false;
    int i = getIntent().getIntExtra("entry_source", 0);
    boolean bool1 = bool2;
    if (i != 3)
    {
      bool1 = bool2;
      if (i != 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ez(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "QzoneEditVideoActivity finish --- resultCode : " + paramInt1);
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  private void eTJ()
  {
    this.b.dAM = aRd();
    this.b.bwI = getIntent().getBooleanExtra("mIsQzoneVip", false);
  }
  
  private void eTK()
  {
    boolean bool = getIntent().getBooleanExtra("enable_input_text", true);
    this.b.bxD = bool;
    this.b.bxE = getIntent().getBooleanExtra("enable_sync_qzone", false);
    this.b.bxH = getIntent().getBooleanExtra("enable_priv_list", true);
    if (!TextUtils.isEmpty(getIntent().getStringExtra("topic_id"))) {
      this.b.isTopic = true;
    }
    this.b.fontId = getIntent().getIntExtra("key_font_id", -1);
    this.b.superFontId = getIntent().getIntExtra("key_super_font_id", -1);
    this.b.bdK = getIntent().getStringExtra("key_super_font_info");
  }
  
  private void eTL()
  {
    this.qzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)getIntent().getParcelableExtra("key_qzone_topic"));
    this.b.qzoneVerticalVideoTopicInfo = this.qzoneVerticalVideoTopicInfo;
  }
  
  private void ez(@Nullable Intent paramIntent)
  {
    if ((paramIntent != null) && (this.b != null))
    {
      paramIntent.putExtra("key_content", this.b.mContent);
      paramIntent.putExtra("key_topic_sync_qzone", this.b.topicSyncQzone);
      paramIntent.putExtra("key_priv", this.b.mPriv);
      paramIntent.putExtra("key_priv_uin_list", this.b.eo);
      paramIntent.putExtra("key_font_id", this.b.fontId);
      paramIntent.putExtra("key_font_format_type", this.b.cig);
      paramIntent.putExtra("key_font_url", this.b.mFontUrl);
      paramIntent.putExtra("key_super_font_id", this.b.superFontId);
      paramIntent.putExtra("key_super_font_info", this.b.bdK);
      paramIntent.putExtra("key_generate_gif", this.b.aHe);
      paramIntent.putExtra("key_timer_delete", this.b.dAP);
      paramIntent.putExtra("key_sync_to_qqstory", this.b.dAN);
      paramIntent.putExtra("param.isUploadOrigin", this.b.dAO);
      if ((rlr.a().tF() == 14) || (rlr.a().tF() == 19)) {
        aB(paramIntent);
      }
      QLog.i(TAG, 2, "QzoneEditVideoActivity " + paramIntent.getExtras());
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if (this.b.dAR)
    {
      b(paramInt1, paramIntent, paramInt2, paramInt3, false);
      return;
    }
    b(paramInt1, paramIntent, paramInt2, paramInt3, true);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public void bsv()
  {
    this.b = new aytw(this);
    this.a = this.b;
    eTK();
    eTJ();
    eTL();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 666) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_is_qzone_slide_show_edited", false)))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("qzone_slide_show_matters");
      rlr.a().eW(paramIntent);
      rlr.a().setData(paramIntent);
      getIntent().putExtra("from_qzone_slideshow", true);
      getIntent().putExtra("edit_video_type", 10001);
      getIntent().putExtra("qq_sub_business_id", 3);
      getIntent().putExtra("qzone_slide_enable_mask", 3848427020667L);
      this.b.a.a(acfp.m(2131713052), false, 500L);
      this.b.pauseVideo();
      this.dAV = true;
      ((axpr)axov.a(5)).cT(this);
      rlr.a().a(this, new ayum(this), 2);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.b != null) {
      this.b.dAR = true;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    findViewById(2131374669).setVisibility(8);
    return bool;
  }
  
  public void doOnDestroy()
  {
    if ((!this.dAV) && (rlr.a().tG() == 22))
    {
      if (rlr.a().tF() != 19) {
        break label54;
      }
      rlr.a().xK(14);
    }
    for (;;)
    {
      if (this.dAV) {
        this.dAV = false;
      }
      super.doOnDestroy();
      return;
      label54:
      if (rlr.a().tF() == 14)
      {
        rlr.a().xL(20);
        rlr.a().xK(99);
      }
    }
  }
  
  public void eA(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      localObject = paramIntent.getExtras();
      if (localObject != null)
      {
        localObject = (EditVideoParams)((Bundle)localObject).getParcelable(EditVideoParams.class.getName());
        if (localObject == null) {
          break label80;
        }
      }
    }
    label80:
    for (Object localObject = ((EditVideoParams)localObject).mT(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      QQToast.a(this, acfp.m(2131713056) + (String)localObject, 0).show();
      finish();
      return;
    }
    doOnPause();
    doOnStop();
    doOnDestroy();
    setIntent(paramIntent);
    doOnCreate(null);
    doOnResume();
    this.b.a.bpm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity
 * JD-Core Version:    0.7.0.1
 */