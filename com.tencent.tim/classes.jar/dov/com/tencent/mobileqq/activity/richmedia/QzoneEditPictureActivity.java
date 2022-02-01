package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import anoq;
import anqh;
import aqhq;
import aqhu;
import avpw;
import awig;
import aydy;
import ayfw;
import aygz;
import ayic;
import ayjw;
import ayjw.c;
import ayqb;
import ayqh;
import ayub;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.DataReporter;
import dov.com.tencent.biz.qqstory.takevideo.DataReporter.Destination;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class QzoneEditPictureActivity
  extends EditPicActivity
{
  private ayub a;
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return EditPicActivity.a(paramActivity, paramString, true, true, true, paramBoolean, true, false, false, false, paramInt1, paramInt2, paramInt3, false, null);
  }
  
  private void b(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_Ayub != null) && (this.jdField_a_of_type_Ayub.aRb()))
    {
      paramIntent.putExtra("key_content", this.jdField_a_of_type_Ayub.mContent);
      paramIntent.putExtra("key_priv", this.jdField_a_of_type_Ayub.mPriv);
      paramIntent.putExtra("key_priv_uin_list", this.jdField_a_of_type_Ayub.eo);
      paramIntent.putExtra("key_font_id", this.jdField_a_of_type_Ayub.fontId);
      paramIntent.putExtra("key_font_format_type", this.jdField_a_of_type_Ayub.cig);
      paramIntent.putExtra("key_font_url", this.jdField_a_of_type_Ayub.mFontUrl);
      paramIntent.putExtra("key_super_font_id", this.jdField_a_of_type_Ayub.superFontId);
      paramIntent.putExtra("key_super_font_info", this.jdField_a_of_type_Ayub.bdK);
      paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_Ayub.aRc());
      QLog.i("QzoneEditPictureActivit", 2, "EditPic mSetTimerDelete: " + this.jdField_a_of_type_Ayub.aRc());
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzoneEditPictureActivit", 2, "QzoneEditPictureActivity finish --- resultCode : " + paramInt1);
    }
    if ((paramIntent != null) && (paramInt1 != 0))
    {
      boolean bool = paramIntent.getBooleanExtra("go_publish_activity", false);
      if (paramIntent.getBooleanExtra("extra_directly_back", false))
      {
        paramIntent.setClass(this, NewPhotoListActivity.class);
        paramIntent.addFlags(536870912);
        startActivity(paramIntent);
        setResult(-1);
        super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
        return;
      }
      if (!bool)
      {
        avpw.a(this, "", paramIntent, -1);
        super.a(-1, null, 2130772067, 0, paramBoolean);
        return;
      }
      super.a(-1, paramIntent, 2130772067, 0, paramBoolean);
      return;
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public static Intent d(Activity paramActivity, String paramString)
  {
    paramActivity = EditPicActivity.a(paramActivity, paramString, true, true, true, true, true, false, false, false, 3, 99, 0, false, null);
    paramActivity.putExtra("TEMP_PARAM", paramActivity.getLongExtra("TEMP_PARAM", 0L) & 0xFBFFFFFF & 0xFFFDFFFF & 0xFDFFFFFF | 0x2000);
    return paramActivity;
  }
  
  private void eTD()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneEditPictureActivity.1(this));
  }
  
  public Intent a(ayqb paramayqb)
  {
    boolean bool2 = true;
    Object localObject1;
    String str;
    Object localObject2;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Aygz.w == null)
    {
      localObject1 = getIntent();
      str = ((Intent)localObject1).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME");
      if ((str != null) && (localObject2 != null))
      {
        ((Intent)localObject1).setClassName((String)localObject2, str);
        ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
      }
      localArrayList = new ArrayList();
      if ((!paramayqb.a.aIF) && (paramayqb.a.result)) {
        break label298;
      }
      QLog.d("QzoneEditPictureActivit", 1, "send sourcePath");
      localObject2 = this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
      label120:
      localArrayList.add(localObject2);
      if ((this.jdField_a_of_type_Aygz == null) || (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw == null) || (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw.a() == null) || (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw.a().a() == null)) {
        break label1337;
      }
    }
    label298:
    label1325:
    label1331:
    label1337:
    for (Object localObject3 = this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw.a().a().mItems;; localObject3 = null)
    {
      Object localObject4 = new JSONArray();
      Object localObject5;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject5 = (ayjw.c)((Iterator)localObject3).next();
            if ((((ayjw.c)localObject5).c != null) && (((ayjw.c)localObject5).c.a() != null))
            {
              ((JSONArray)localObject4).put(((ayjw.c)localObject5).c.a().toString());
              continue;
              localObject1 = this.jdField_a_of_type_Aygz.w;
              break;
              localObject2 = paramayqb.a.aAZ;
              if (getIntent().getIntExtra("camera_type", -1) != -1)
              {
                aqhq.deleteFile(paramayqb.a.aAY);
                new File(paramayqb.a.aAY);
                aqhu.cn(this, paramayqb.a.aAY);
              }
              ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
              break label120;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + ((JSONArray)localObject4).toString());
      }
      if (((JSONArray)localObject4).length() > 0) {
        ((Intent)localObject1).putExtra("dynamic_text", ((JSONArray)localObject4).toString());
      }
      ((Intent)localObject1).putExtra(PublishParam.BUNDLE_EXTRA_KEY, paramayqb.b);
      boolean bool1;
      int i;
      if ((paramayqb.a.aIF) || (!paramayqb.a.result))
      {
        bool1 = true;
        ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool1);
        localObject5 = ((Intent)localObject1).getStringExtra("PATH");
        i = ((Intent)localObject1).getIntExtra("p_e_s_type", -1);
        switch (i)
        {
        case 4: 
        case 5: 
        default: 
          ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
          if (QLog.isColorLevel()) {
            QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus,photoEditSourceType = " + i + ",SINGLE_PHOTO_PATH = " + (String)localArrayList.get(0) + ",PHOTO_PATHS = " + localArrayList);
          }
          ((Intent)localObject1).putExtra("PhotoConst.SHOW_ALBUM", false);
          ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
          if (bool1)
          {
            i = 2;
            label635:
            ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
            ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
            ((Intent)localObject1).putExtra("video_sync_to_story", paramayqb.aID);
            ((Intent)localObject1).addFlags(603979776);
            if (QLog.isColorLevel()) {
              QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject1).getFlags() + ",data = " + ((Intent)localObject1).getExtras());
            }
            localObject2 = a((Intent)localObject1, this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), (String)localObject2);
            localObject1 = localObject2;
            if (str != null)
            {
              localObject1 = localObject2;
              if (str.contains("ForwardRecentActivity")) {
                localObject1 = c((Intent)localObject2);
              }
            }
            localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            localObject3 = ((Intent)localObject1).getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
            if (QLog.isColorLevel()) {
              QLog.d("QzoneEditPictureActivit", 2, "initclassName:" + (String)localObject2);
            }
            if (localObject2 != null)
            {
              if ((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject2)) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject3))) {
                break label1300;
              }
              ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
            }
            label895:
            ((Intent)localObject1).putExtra("open_chatfragment_fromphoto", true);
            ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", paramayqb.g.videoLocationDescription);
            ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", paramayqb.g.videoLongitude);
            ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", paramayqb.g.videoLatitude);
            if (paramayqb.dAq)
            {
              ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
              ((Intent)localObject1).removeExtra("PhotoConst.is_troop_send_mixed_msg");
              paramayqb = ((Intent)localObject1).getStringExtra("uin");
              i = ((Intent)localObject1).getIntExtra("uintype", 0);
              localObject3 = new anqh();
              ((anqh)localObject3).Uq = "0X800699A";
              ((anqh)localObject3).toUin = String.valueOf(paramayqb);
              ((anqh)localObject3).cgG = "3";
              ((anqh)localObject3).abL = "shanzhao";
              localObject2 = DataReporter.a().a(i);
              paramayqb = (ayqb)localObject2;
              if (localObject2 == null) {
                paramayqb = DataReporter.Destination.UNKNOWN;
              }
              ((anqh)localObject3).cgH = paramayqb.toString();
              anoq.b(null, (anqh)localObject3);
            }
            if (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayic == null) {
              break label1331;
            }
            if (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayic.a(this.jdField_a_of_type_Aygz.tj()) == null) {
              break label1325;
            }
            bool1 = bool2;
          }
          break;
        }
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("VIDEO_HAS_TAG", bool1);
        return localObject1;
        bool1 = false;
        break;
        localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new ArrayList();
        }
        int j = ((ArrayList)localObject3).indexOf(localObject5);
        if (j != -1) {
          ((ArrayList)localObject3).set(j, localArrayList.get(0));
        }
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
        ((Intent)localObject1).putExtra("PhotoConst.USE_URL_PATH", true);
        ((Intent)localObject1).putExtra("extra_directly_back", true);
        ((Intent)localObject1).putExtra("DirectBackToQzone", true);
        break label539;
        localObject4 = ((Intent)localObject1).getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new ArrayList();
        }
        j = ((ArrayList)localObject3).indexOf(localObject5);
        if (j != -1) {
          ((ArrayList)localObject3).set(j, localArrayList.get(0));
        }
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject3);
        break label539;
        i = 0;
        break label635;
        if (!"com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str)) {
          break label895;
        }
        ((Intent)localObject1).setClassName("com.tencent.mobileqq", (String)localObject2);
        break label895;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, true);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool;
    if ((getIntent() != null) && (getIntent().getBooleanExtra("go_publish_activity", false)))
    {
      this.jdField_a_of_type_Ayub = new ayub(this, true);
      i(this.jdField_a_of_type_Ayub);
      bool = super.doOnCreate(paramBundle);
      paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
      if ((paramBundle == null) || (!aydy.r(paramBundle.aCQ, 64))) {
        break label141;
      }
      eTD();
    }
    label141:
    do
    {
      return bool;
      this.jdField_a_of_type_Ayub = new ayub(this, false);
      i(this.jdField_a_of_type_Ayub);
      QZLog.d("QzoneEditPictureActivit", 2, "doOnCreate do nothing, use original manager " + super.getClass().getName());
      break;
      paramBundle = findViewById(2131374669);
    } while (paramBundle == null);
    paramBundle.setVisibility(8);
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    awig.a().Wp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity
 * JD-Core Version:    0.7.0.1
 */