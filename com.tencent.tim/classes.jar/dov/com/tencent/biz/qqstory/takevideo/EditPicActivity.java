package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import aeee;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anki;
import ankq;
import anoq;
import anqh;
import aqhq;
import aqhu;
import atao;
import awrz;
import awtj;
import axim;
import axip;
import axiy;
import axov;
import aydv;
import aydw;
import aydx;
import aydy;
import ayfw;
import aygz;
import ayic;
import ayii;
import ayjw;
import ayjw.c;
import ayqb;
import ayqh;
import aytu;
import ayxa;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import ram;
import rar;
import ras;
import shb;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements ayii
{
  public aygz a;
  PtvTemplateManager.a a;
  public long mCreateTime = -1L;
  private RelativeLayout og;
  
  public EditPicActivity()
  {
    this.jdField_a_of_type_Aygz = new aydy();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$a = new aydv(this);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt, 99, 0, false, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt1, paramInt2, 0, false, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt1, paramInt2, 0, false, null, paramBundle);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, HashMap<String, Object> paramHashMap)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, false, false, false, paramInt1, paramInt2, 0, false, paramHashMap);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean9, HashMap<String, Object> paramHashMap)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramBoolean8, paramInt1, paramInt2, paramInt3, paramBoolean9, paramHashMap, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean9, HashMap<String, Object> paramHashMap, Bundle paramBundle)
  {
    Bundle localBundle = paramActivity.getIntent().getExtras();
    Intent localIntent = new Intent();
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    localIntent.setClass(paramActivity, ArtFilterBridgeActivity.class);
    if (!localIntent.hasExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME")) {
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    }
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.tim");
    if ((paramActivity instanceof SplashActivity)) {
      localIntent.putExtra("key_activity_code", ChatActivityUtils.d(paramActivity));
    }
    localIntent.putExtra("open_chatfragment", true);
    long l2 = 0L;
    if (paramBoolean1) {
      l2 = 0L | 0x20000000;
    }
    long l1 = l2;
    if (paramBoolean2) {
      l1 = l2 | 1L | 0x0;
    }
    l2 = l1;
    if (paramBoolean3) {
      l2 = l1 | 0x8;
    }
    l1 = l2;
    if (paramBoolean4) {
      l1 = l2 | 0x4;
    }
    l2 = l1;
    if (paramBoolean7) {
      l2 = l1 | 0x4000000;
    }
    l1 = l2;
    if (paramBoolean6) {
      l1 = l2 | 0x10000000;
    }
    l2 = l1;
    if (paramBoolean8) {
      l2 = l1 | 0x20000;
    }
    l1 = l2;
    if (paramBoolean5)
    {
      l1 = l2;
      if (Build.VERSION.SDK_INT >= 21) {
        l1 = l2 | 0x40;
      }
    }
    l2 = l1;
    if (paramInt2 == 102) {
      l2 = l1 | 0x800000;
    }
    if (paramInt1 != 2)
    {
      l1 = l2;
      if (paramInt1 != 6) {}
    }
    else
    {
      l1 = l2 | 0x2000 | 0x4000;
    }
    if ((paramInt1 != 8) && (paramInt1 != 4))
    {
      l2 = l1;
      if (paramInt1 != 3) {}
    }
    else
    {
      l2 = l1 | 0x2000;
    }
    l1 = l2;
    if (paramInt1 == 1) {
      l1 = l2 | 0x2000000;
    }
    l2 = l1;
    if (paramInt1 == 2) {
      l2 = l1 | 0x0;
    }
    if ((paramBundle != null) && (paramBundle.getBoolean("key_multi_edit_pic", false))) {
      localIntent.putExtra("key_multi_edit_pic", true);
    }
    l2 |= 0x0;
    l1 = l2;
    if (anki.axM()) {
      l1 = l2 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
    }
    l2 = l1;
    if (paramInt2 == 102) {
      l2 = l1 & 0xFBFFFFFF & 0xFFFDFFFF;
    }
    if ((paramInt2 == 122) || (paramInt2 == 125) || (paramInt2 == 133) || (EditVideoParams.oA(paramInt2))) {}
    for (l1 = l2 & 0xFFFFDFFF;; l1 = l2)
    {
      paramBundle = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
      if (paramBundle != null)
      {
        localIntent.putExtra("uin", paramBundle.aTl);
        localIntent.putExtra("uintype", paramBundle.cZ);
        localIntent.putExtra("troop_uin", paramBundle.troopUin);
        localIntent.putExtra("uinname", paramBundle.aTn);
      }
      localIntent.putExtra("EDIT_BUSI", paramInt1);
      localIntent.putExtra("entrance_type", paramInt2);
      localIntent.putExtra("pic_entrance_type", paramInt3);
      localIntent.putExtra("TEMP_PARAM", l1);
      localIntent.putExtra("PATH", paramString);
      localIntent.putExtra("go_publish_activity", paramBoolean9);
      if (paramHashMap != null) {
        localIntent.putExtra("user_params", paramHashMap);
      }
      localIntent.removeExtra("camera_type");
      if (paramActivity.getClass().getName().contains("ForwardRecentActivity")) {
        return c(localIntent);
      }
      return localIntent;
    }
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
  
  protected Intent a(Intent paramIntent, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return paramIntent;
    case 101: 
      String str = ForwardRecentActivity.class.getName();
      paramIntent.putExtra("forward_type", 1);
      paramIntent.putExtra("forward_ability_entrence_show_in_share", true);
      paramIntent.putExtra("k_qzone", true);
      paramIntent.putExtra("k_qqstory", true);
      paramIntent.putExtra("k_smartdevice", false);
      paramIntent.putExtra("k_favorites", false);
      paramIntent.putExtra("k_phonecontacts", false);
      paramIntent.putExtra("forward_filepath", paramString);
      paramIntent.putExtra("forward_extra", paramString);
      paramIntent.putExtra("forward_thumb", paramString);
      paramIntent.putExtra("forward_urldrawable", true);
      paramIntent.putExtra("forward_urldrawable_big_url", paramString);
      paramIntent.putExtra("forward_urldrawable_thumb_url", paramString);
      paramIntent.putExtra("forward_photo_shortvideo_is_edited", true);
      paramIntent.putExtra("forward_source_from_shoot_quick", true);
      paramIntent.setClassName("com.tencent.mobileqq", str);
      return paramIntent;
    }
    paramIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
    return paramIntent;
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
        break label301;
      }
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject2 = this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
      label123:
      localArrayList.add(localObject2);
      if ((this.jdField_a_of_type_Aygz == null) || (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw == null) || (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw.a() == null) || (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw.a().a() == null)) {
        break label1144;
      }
    }
    label301:
    label838:
    label1104:
    label1109:
    label1134:
    label1139:
    label1144:
    for (Object localObject3 = this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayfw.a().a().mItems;; localObject3 = null)
    {
      JSONArray localJSONArray = new JSONArray();
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ayjw.c localc = (ayjw.c)((Iterator)localObject3).next();
            if ((localc.c != null) && (localc.c.a() != null))
            {
              localJSONArray.put(localc.c.a().toString());
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
              break label123;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + localJSONArray.toString());
      }
      if (localJSONArray.length() > 0) {
        ((Intent)localObject1).putExtra("dynamic_text", localJSONArray.toString());
      }
      ((Intent)localObject1).putExtra(PublishParam.BUNDLE_EXTRA_KEY, paramayqb.b);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("input_full_screen_mode", false);
      boolean bool1;
      int i;
      if ((paramayqb.a.aIF) || (!paramayqb.a.result))
      {
        bool1 = true;
        ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", bool1);
        ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        ((Intent)localObject1).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
        if (!bool1) {
          break label1104;
        }
        i = 2;
        ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
        ((Intent)localObject1).putExtra("PhotoConst.SEND_FLAG", true);
        ((Intent)localObject1).putExtra("video_sync_to_story", paramayqb.aID);
        ((Intent)localObject1).addFlags(603979776);
        if ((this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aQz()) || (bool3)) {
          ((Intent)localObject1).putExtra("key_multi_edit_source_path", this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath());
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject1).getFlags() + ",data = " + ((Intent)localObject1).getExtras());
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
          QLog.d("EditPicActivity", 2, "initclassName:" + (String)localObject2);
        }
        if (localObject2 != null)
        {
          if (((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject2)) && (!"com.tencent.mobileqq.activity.ChatActivity".equals(localObject2))) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject3))) {
            break label1109;
          }
          ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
        }
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
          break label1139;
        }
        if (this.jdField_a_of_type_Aygz.jdField_a_of_type_Ayic.a(this.jdField_a_of_type_Aygz.tj()) == null) {
          break label1134;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("VIDEO_HAS_TAG", bool1);
        paramayqb = ((Intent)localObject1).getStringExtra("key_camera_material_name");
        axiy.i("EditPicActivity", "AIO send photo---takeSameName=" + paramayqb);
        return localObject1;
        bool1 = false;
        break;
        i = 0;
        break label524;
        if (!"com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str)) {
          break label838;
        }
        ((Intent)localObject1).setClassName("com.tencent.mobileqq", (String)localObject2);
        break label838;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public aygz a()
  {
    return this.jdField_a_of_type_Aygz;
  }
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, new Object[] { "finish, publishStoryFlag", Boolean.valueOf(paramBoolean) });
    }
    dov.com.qq.im.QIMEffectCameraCaptureUnit.drT = paramBoolean;
    awtq.dsy = paramBoolean;
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    this.jdField_a_of_type_Aygz.onActivityFinish();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Aygz.onActivityResult(paramInt1, paramInt2, paramIntent);
    ram.i("EditPicActivity", "doOnActivityResult");
    Intent localIntent;
    Object localObject;
    if (paramInt1 == 666) {
      if (paramInt2 == -1)
      {
        localIntent = getIntent();
        localIntent.setClass(this, EditPicActivity.class);
        if (localIntent.getIntExtra("camera_type", -1) == 103)
        {
          paramIntent = this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath();
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity", 2, "reset2Camera end shoot " + this + " new path " + paramIntent);
          }
          localObject = paramIntent;
          if (TextUtils.isEmpty(paramIntent))
          {
            localObject = PreferenceManager.getDefaultSharedPreferences(this).getString("edit_pic_new_path", "");
            QLog.d("EditPicActivity", 1, " be killed. read sp " + (String)localObject);
          }
          if (aqhq.fileExists((String)localObject)) {
            break label248;
          }
          QLog.i("EditPicActivity", 1, "recamera file not exist " + (String)localObject);
          QQToast.a(this, acfp.m(2131705444), 0).show();
          finish();
        }
      }
    }
    label248:
    do
    {
      do
      {
        do
        {
          return;
          paramIntent = localIntent.getStringExtra("image_path");
          break;
          paramIntent = new EditVideoParams(this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi, this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, new EditTakePhotoSource((String)localObject, 2, 0, 0), EditVideoParams.c(this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg()));
          localIntent.putExtra(EditVideoParams.class.getName(), paramIntent);
          finish();
          startActivity(localIntent);
          return;
          ram.i("EditPicActivity", "recamera cancel, finish");
          finish();
          return;
          if (paramInt1 != 1000) {
            break label443;
          }
        } while (paramInt2 != -1);
        if (paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0) == 1003)
        {
          this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi = 1;
          getIntent().putExtra("main_tab_id", 6);
          getIntent().putExtra("fragment_id", 1);
          getIntent().putExtra("switch_anim", true);
          this.jdField_a_of_type_Aygz.bsn();
        }
        for (;;)
        {
          this.jdField_a_of_type_Aygz.onActivityResult(paramInt1, paramInt2, paramIntent);
          return;
          a(paramInt2, paramIntent, 2130772067, 0);
        }
        if (paramInt1 == 1001)
        {
          a(paramInt2, paramIntent, 2130772067, 0);
          return;
        }
      } while (paramInt1 != 19003);
      if (paramInt2 == -1)
      {
        a(paramInt2, paramIntent, 2130772067, 0);
        return;
      }
    } while ((paramInt2 != 0) || (paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
    label443:
    a(-1, paramIntent, 2130772067, 0);
  }
  
  public void doOnBackPressed()
  {
    ram.i("EditPicActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Aygz.onBackPressed()) {
      super.doOnBackPressed();
    }
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    ayxa.resetAllLiuHaiStatus();
    ayxa.resetFullScreen(this);
    ayxa.cX(this);
    if (ayxa.aRq()) {
      ayxa.enableNotch(this);
    }
    atao.init();
    awtj.init();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    aydw.b(QQStoryContext.a().dE(), this);
    paramBundle = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    aytu.X("finish jump activity", aytu.c(getIntent()));
    ram.w("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), paramBundle });
    if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle.a.getSourcePath())))
    {
      QQToast.a(this, acfp.m(2131705447), 0).show();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + paramBundle.a.getSourcePath());
    }
    if (!aqhq.fileExists(paramBundle.a.getSourcePath()))
    {
      QQToast.a(this, acfp.m(2131705448), 0).show();
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("editpic_cameratype", -1);
    if (i == 1)
    {
      aytu.cxF();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      i = getIntent().getIntExtra("edit_video_way", 0);
      this.jdField_a_of_type_Aygz.setFrom(i);
      try
      {
        atao.dgW = true;
        ankq.axX();
        if (VideoEnvironment.d("AVCodec", super.getApplicationContext()) != 0) {
          ram.e("EditPicActivity", "load AVCodec so failed");
        }
        this.jdField_a_of_type_Aygz.dzj = true;
        setContentViewC(2131559254);
        if (isInMultiWindow())
        {
          QQToast.a(this, acfp.m(2131705445), 0).show();
          finish();
          return true;
          if (i != 2) {
            continue;
          }
          aytu.cxG();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ram.e("EditPicActivity", "load so failed", localException);
        }
        eQL();
        this.jdField_a_of_type_Aygz.a(this, paramBundle);
        if (this.jdField_a_of_type_Aygz.b != null)
        {
          this.jdField_a_of_type_Aygz.b.azx = getIntent().getStringExtra("FILTER_STRING");
          this.jdField_a_of_type_Aygz.b.bpM = getIntent().getIntExtra("FILTER_MAXSIDE", 640);
          this.jdField_a_of_type_Aygz.b.azy = getIntent().getStringExtra("FILTER_LOADING_PATH");
        }
        if (this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage == null) {
          break label593;
        }
      }
    }
    long l;
    Object localObject;
    boolean bool;
    label586:
    label593:
    int j;
    int k;
    if (this.jdField_a_of_type_Aygz.jdField_a_of_type_Aydx != null)
    {
      l = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
      localObject = this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage;
      if (l > 0L)
      {
        bool = true;
        ((EditPicRawImage)localObject).aGD = bool;
        localObject = this.jdField_a_of_type_Aygz.jdField_a_of_type_Aydx;
        if (l <= 0L) {
          break label861;
        }
        bool = true;
        ((aydx)localObject).aGD = bool;
      }
    }
    else
    {
      localObject = (awrz)axov.a(13);
      ((awrz)localObject).Gf(this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg());
      this.jdField_a_of_type_Aygz.onCreate();
      PtvTemplateManager.a(this.mApp).a(this.mApp, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$a, false);
      if (paramBundle.mExtra != null) {
        ras.wM(paramBundle.mExtra.getInt("pic_entrance_type", 0));
      }
      ayqh.i(null);
      this.mCreateTime = System.currentTimeMillis();
      j = this.jdField_a_of_type_Aygz.QD();
      k = this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th();
      if (this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1)
      {
        l = getIntent().getLongExtra("stop_record_time", -1L);
        if (l <= 0L) {
          break label867;
        }
      }
    }
    label861:
    label867:
    for (i = (int)(this.mCreateTime - l);; i = 0)
    {
      rar.b("time_openedit", 1, i, new String[] { rar.bY(j), "0", "", String.valueOf(k) });
      i = this.jdField_a_of_type_Aygz.RR();
      getIntent().putExtra("capture_operation_in", i);
      rar.a("video_edit_new", "edit_exp", i, 0, new String[] { rar.bY(j), "", "", String.valueOf(k) });
      ((awrz)localObject).acZ(1);
      ((awrz)localObject).acY(4);
      return true;
      bool = false;
      break;
      bool = false;
      break label586;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ram.d("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_Aygz.onDestroy();
    awrz localawrz = (awrz)axov.a(13);
    if (localawrz != null) {
      localawrz.acZ(1);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ram.i("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_Aygz.onPause();
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ram.i("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_Aygz.onResume();
    aytu.AK("resume activity");
    ((awrz)axov.a(13)).xL(1);
    if (Build.VERSION.SDK_INT >= 29) {
      shb.e(getWindow());
    }
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ram.i("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_Aygz.onStart();
    ras.azm = ras.bZ(this.jdField_a_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi);
    ras.azn = "pic_edit";
    axim.a().eKz();
    axip.a().eLt();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Aygz.onStop();
    axim.a().eKA();
    axiy.i("EditPicActivity", "【doOnStop】");
    ras.azm = "";
    ras.azn = "";
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_Aygz.onWindowFocusChanged(paramBoolean);
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public View getRootView()
  {
    return getWindow().getDecorView();
  }
  
  public void i(aygz paramaygz)
  {
    this.jdField_a_of_type_Aygz = paramaygz;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */