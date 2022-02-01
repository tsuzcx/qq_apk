import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;

public class aywz
{
  private static Intent a(ayws paramayws, boolean paramBoolean, Context paramContext)
  {
    if (paramBoolean) {
      return new Intent(paramContext, EditWebVideoActivity.class);
    }
    return new Intent(paramContext, EditVideoActivity.class);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, aybv paramaybv, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramVideoCaptureResult, paramLocalMediaInfo, paramaybv, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, aybv paramaybv, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramaybv == null)) {}
    ayby localayby;
    do
    {
      return;
      localayby = paramaybv.a();
      if (localayby != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l1 = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
    long l2;
    if ((paramActivity.getIntent() != null) && (l1 != -1L))
    {
      if ((!localayby.dyg) || (!anki.axP())) {
        break label1405;
      }
      l2 = l1 | 0x10;
      label94:
      l1 = l2;
      if (localayby.aQl()) {
        l1 = l2 | 0x0;
      }
      l2 = l1;
      if (localayby.aQj()) {
        l2 = l1 | 0x2000;
      }
      l1 = l2;
      if (localayby.aQk()) {
        l1 = l2 | 0x4000;
      }
      l2 = l1;
      if (localayby.aQn()) {
        l2 = l1 | 0x200000;
      }
      l1 = l2;
      if (paramaybv.ciS != 10013)
      {
        l1 = l2;
        if (paramaybv.ciS != 10012) {
          l1 = l2 | 0x0 | 0x0;
        }
      }
      l2 = l1;
      if (!localayby.dyb) {
        l2 = l1 & 0xFFFFFFFE & 0xFFFFFFFF;
      }
      long l3 = l2;
      if (paramaybv.th() == 102) {
        l3 = l2 | 0x800000;
      }
      l1 = l3;
      if (anki.axM()) {
        l1 = l3 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
      }
      if (paramBundle2 != null) {
        break label1650;
      }
    }
    label413:
    label752:
    label1650:
    for (Object localObject1 = new Bundle();; localObject1 = paramBundle2)
    {
      boolean bool1;
      if (paramaybv.ciS == 10012)
      {
        if ((paramLocalMediaInfo.mDuration > 20000L) || (paramLocalMediaInfo.mTotalDuration > 20000L))
        {
          ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
          ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
        }
        bool1 = ((Bundle)localObject1).getBoolean("needVideoDoodle", false);
        boolean bool2 = ((Bundle)localObject1).getBoolean("needVideoWording", false);
        l2 = l1;
        if (!bool1) {
          l2 = l1 & 0xDFFFFFFF;
        }
        l1 = l2;
        if (!bool2) {
          l1 = l2 & 0xFFFFFFFE & 0xFFFFFFFF;
        }
      }
      for (;;)
      {
        if (paramLocalMediaInfo.mDuration > 80000L) {
          ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
        }
        Object localObject2 = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
        if (localObject2 != null)
        {
          ((Bundle)localObject1).putString("uin", ((SessionWrap)localObject2).aTl);
          ((Bundle)localObject1).putInt("uintype", ((SessionWrap)localObject2).cZ);
          ((Bundle)localObject1).putString("troop_uin", ((SessionWrap)localObject2).troopUin);
          ((Bundle)localObject1).putString("uinname", ((SessionWrap)localObject2).aTn);
        }
        localObject2 = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (localObject2 != null) {
          ((Bundle)localObject1).putParcelable("edit_send_session_info", (Parcelable)localObject2);
        }
        ((Bundle)localObject1).putInt("qq_sub_business_id", localayby.RL());
        ((Bundle)localObject1).putInt("entrance_type", paramaybv.mEntranceType);
        bool1 = localayby.aQo();
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        int k = paramaybv.EP;
        int m = localayby.RN();
        ras.wN(m);
        localObject2 = ((axro)axov.a().c(8)).b();
        if (localObject2 != null)
        {
          l2 = l1;
          if (((MusicItemInfo)localObject2).mType != 2) {}
        }
        else
        {
          l2 = l1 | 0x1000000;
        }
        ((Bundle)localObject1).putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
        SegmentKeeper.adjustTime(0L);
        l1 = l2;
        int i;
        int j;
        if (paramaybv.ciS == 10002)
        {
          l1 = l2;
          if (localayby.aQh()) {
            l1 = l2 | 0x20000;
          }
          l2 = l1;
          if (localayby.aQg()) {
            l2 = l1 | 0x4000000;
          }
          l1 = l2;
          if (localayby.dyi) {
            l1 = l2 | 0x0;
          }
          i = 0;
          if (paramBundle2 != null)
          {
            if (paramBundle2.getSerializable("extra_follow_capture_param") == null) {
              break label1508;
            }
            i = 1;
          }
          if ((!ayzv.a().aRB()) || (i != 0) || (!anki.axQ())) {
            break label1514;
          }
          j = 1;
          l2 = l1;
          if (j != 0) {
            l2 = l1 | 0x0;
          }
          l1 = l2;
          if (i != 0) {
            l1 = l2 & 0xFFFFFFEF;
          }
          l2 = l1 | 0x2000000;
          l1 = l2;
          if (paramBundle2 != null)
          {
            localObject2 = (FollowCaptureParam)paramBundle2.getSerializable("extra_follow_capture_param");
            l1 = l2;
            if (localObject2 != null)
            {
              l1 = l2;
              if (!((FollowCaptureParam)localObject2).showLink) {
                l1 = l2 & 0xFDFFFFFF;
              }
            }
          }
          l2 = l1;
          if (!localayby.aQm()) {
            l2 = l1 & 0xFDFFFFFF;
          }
          l1 = l2;
          if (localayby.aQi()) {
            l1 = l2 | 0x10000000;
          }
        }
        l2 = l1;
        if (localayby.mode == 5) {
          l2 = l1 & 0xFFFFFFDF & 0xFFFFFFFF;
        }
        l1 = l2;
        if (paramBundle1 != null)
        {
          l1 = l2;
          if (paramBundle1.getBoolean("qa_mode", false)) {
            l1 = l2 & 0xFFFFFFEF & 0xFFFFFFFF;
          }
        }
        localObject1 = new EditVideoParams(k, l1, paramVideoCaptureResult, (Bundle)localObject1);
        ((EditVideoParams)localObject1).mMode = localayby.mode;
        ((EditVideoParams)localObject1).entryType = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
        ((EditVideoParams)localObject1).mExtra.putBoolean("enable_hw_encode", true);
        if (localayby.mode == 2) {
          ((EditVideoParams)localObject1).mFrom = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + ((EditVideoParams)localObject1).toString());
        }
        ((EditVideoParams)localObject1).mExtra.putInt("type", localayby.eJz);
        ((EditVideoParams)localObject1).mExtra.putInt("WebSceneType", localayby.eJA);
        ((EditVideoParams)localObject1).mExtra.putString("failedUrl", localayby.cWE);
        ((EditVideoParams)localObject1).mExtra.putString("succUrl", localayby.cWD);
        if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          ((EditVideoParams)localObject1).mExtra.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
        }
        ((EditVideoParams)localObject1).mExtra.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
        if ((bool1) && (localayby.RM() != 0))
        {
          paramVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
          paramVideoCaptureResult.putExtra("videoId", localayby.RM());
          l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
          if (l1 != 0L) {
            ((EditVideoParams)localObject1).mExtra.putLong("troop_uin", l1);
          }
          rpm.a(paramVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
          paramVideoCaptureResult.putExtra("short_video_entrance_type", m);
          paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
          if (paramaybv.ciS != 10012) {
            break label1593;
          }
          paramVideoCaptureResult.putExtra("op_department", "grp_tribe");
        }
        for (;;)
        {
          paramVideoCaptureResult.putExtra("op_type", "video_edit");
          paramVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
          paramVideoCaptureResult.putExtra("state", paramBundle1);
          paramVideoCaptureResult.putExtra("edit_video_way", paramInt);
          paramVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", axcg.j(paramActivity.getIntent()));
          paramVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", axcg.i(paramActivity.getIntent()));
          if (!(paramActivity instanceof QzoneEditVideoActivity)) {
            break label1631;
          }
          ((QzoneEditVideoActivity)paramActivity).eA(paramVideoCaptureResult);
          return;
          l1 = 671088971L;
          break;
          label1405:
          l2 = l1 | 0x20;
          break label94;
          if (paramaybv.ciS == 10013)
          {
            if ((paramLocalMediaInfo.mDuration <= 20000L) && (paramLocalMediaInfo.mTotalDuration <= 20000L)) {
              break label1647;
            }
            ((Bundle)localObject1).putBoolean("extra_enable_revert", false);
            ((Bundle)localObject1).putBoolean("extra_enable_slow", false);
            break label413;
          }
          if ((paramaybv.ciS != 10000) && (paramaybv.ciS != 10007) && (paramaybv.ciS != 10004)) {
            break label1647;
          }
          l1 &= 0xFFFFFFDF;
          break label413;
          i = 0;
          break label752;
          j = 0;
          break label775;
          if ((paramBundle2 != null) && (paramBundle2.getBoolean("from_qzone_slideshow")))
          {
            paramVideoCaptureResult = new Intent(paramActivity, QzoneEditVideoActivity.class);
            paramVideoCaptureResult.putExtra("qqstory_slide_show_scene", rma.a().tG());
            paramVideoCaptureResult.putExtra("qqstory_slide_show_entrance", rma.a().tF());
            break label1221;
          }
          paramVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
          break label1221;
          if (paramaybv.ciS == 10013) {
            paramVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
          } else {
            paramVideoCaptureResult.putExtra("op_department", "grp_qq");
          }
        }
        paramActivity.startActivityForResult(paramVideoCaptureResult, paramaybv.ciS);
        paramActivity.overridePendingTransition(0, 0);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, aybv paramaybv, Bundle paramBundle, int paramInt, ayws paramayws)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramaybv == null)) {}
    ayby localayby;
    do
    {
      return;
      localayby = paramaybv.a();
      if (localayby != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l2 = 671088971L;
    if (localayby.aQj()) {
      l2 = 0x2800014B | 0x2000;
    }
    long l1 = l2;
    if (localayby.aQn()) {
      l1 = l2 | 0x200000;
    }
    l2 = l1;
    if (localayby.aQg()) {
      l2 = l1 | 0x4000000;
    }
    l1 = l2;
    if (localayby.dyi) {
      l1 = l2 | 0x0;
    }
    if (anki.axM()) {
      l1 = l1 & 0xDFFFFFFF & 0xFFFFFFF7 & 0xFFFFFEFF & 0xFFFFFFBF & 0xFFFFFFDF;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null) {
        localBundle.putParcelable("edit_send_session_info", localSessionInfo);
      }
      localBundle.putInt("qq_sub_business_id", localayby.RL());
      localBundle.putInt("entrance_type", paramaybv.mEntranceType);
      boolean bool = localayby.aQo();
      paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      int i = paramaybv.EP;
      int j = localayby.RN();
      ras.wN(j);
      paramLocalMediaInfo = ((axro)axov.a().c(8)).b();
      if (paramLocalMediaInfo != null)
      {
        l2 = l1;
        if (paramLocalMediaInfo.mType != 2) {}
      }
      else
      {
        l2 = l1 | 0x1000000;
      }
      localBundle.putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
      paramLocalMediaInfo = a(paramayws, bool, paramActivity);
      if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebVideoActivity.class.getName())) {
        paramLocalMediaInfo.putExtra("videoId", localayby.RM());
      }
      paramVideoCaptureResult = new EditVideoParams(i, l2, paramVideoCaptureResult, localBundle);
      paramVideoCaptureResult.mExtra.putBoolean("enable_hw_encode", true);
      if (QLog.isColorLevel()) {
        QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramVideoCaptureResult.toString());
      }
      paramLocalMediaInfo.putExtra("edit_video_call_back", localayby.cWC);
      paramVideoCaptureResult.mExtra.putInt("type", localayby.eJz);
      paramVideoCaptureResult.mExtra.putInt("WebSceneType", localayby.eJA);
      paramVideoCaptureResult.mExtra.putString("failedUrl", localayby.cWE);
      paramVideoCaptureResult.mExtra.putString("succUrl", localayby.cWD);
      l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
      if (l1 != 0L) {
        paramVideoCaptureResult.mExtra.putLong("troop_uin", l1);
      }
      rpm.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras(), paramActivity);
      paramLocalMediaInfo.putExtra("short_video_entrance_type", j);
      paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
      paramLocalMediaInfo.putExtra("op_department", "grp_qq");
      paramLocalMediaInfo.putExtra("op_type", "video_edit");
      paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
      paramLocalMediaInfo.putExtra("state", paramBundle);
      paramLocalMediaInfo.putExtra("edit_video_way", paramInt);
      SegmentKeeper.adjustTime(0L);
      paramActivity.startActivityForResult(paramLocalMediaInfo, paramaybv.ciS);
      paramActivity.overridePendingTransition(0, 0);
      return;
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.h paramh, aybv paramaybv, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramh, paramaybv, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.h paramh, aybv paramaybv, Bundle paramBundle1, int paramInt, Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramaybv == null)) {}
    aybw localaybw;
    do
    {
      return;
      localaybw = paramaybv.a();
      if (localaybw != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
    return;
    boolean bool = localaybw.aQf();
    int i = paramaybv.EP;
    int j = localaybw.RK();
    int k = paramaybv.th();
    int m = localaybw.Is();
    String str = localaybw.Il();
    Intent localIntent = EditPicActivity.a(paramActivity, paramh.filePath, true, localaybw.dyb, true, bool, true, localaybw.aQi(), localaybw.aQg(), localaybw.aQh(), i, k, j, false, null);
    localIntent.putExtra("edit_video_call_back", str);
    if (paramBundle2 != null) {
      localIntent.putExtras(paramBundle2);
    }
    localIntent.putExtra("qcamera_photo_filepath", paramh.filePath);
    localIntent.putExtra("qcamera_rotate", paramh.orientation);
    localIntent.putExtra("shareto_web_mode", localaybw.eJv);
    localIntent.putExtra("camera_type", 103);
    localIntent.putExtra("camera_front_back", m);
    localIntent.putExtra("camera_capture_method", paramh.type);
    localIntent.putExtra("camera_mode", localaybw.mode);
    localIntent.putExtra("state", paramBundle1);
    aytq.a(paramaybv.ciS, "", "0X8007818", null);
    paramBundle1 = localaybw.a();
    paramaybv = localIntent;
    if (paramBundle1 != null)
    {
      localIntent.putExtra("uin", paramBundle1.aTl);
      localIntent.putExtra("uintype", paramBundle1.cZ);
      localIntent.putExtra("troop_uin", paramBundle1.troopUin);
      localIntent.putExtra("uinname", paramBundle1.aTn);
      paramaybv = wja.a(localIntent, null);
    }
    paramaybv.putExtra("edit_video_way", paramInt);
    paramaybv.putExtra("sub_business_id", localaybw.RL());
    paramBundle1 = SplashActivity.class.getName();
    paramBundle2 = localaybw.Ik();
    if ((paramBundle2 != null) && (paramBundle2.equals(ChatActivity.class.getName()))) {
      paramBundle1 = paramBundle2;
    }
    for (;;)
    {
      aytu.AK("finish");
      aytu.cW(paramaybv);
      paramaybv.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle1);
      if (paramh.type == 1) {
        paramaybv.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(paramaybv, 1012);
        aytq.h("", "0X80075C1", "", "", "", "");
        return;
        if (paramh.type == 0) {
          paramaybv.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, ayca paramayca)
  {
    paramayca = new Intent(paramActivity, SplashActivity.class);
    paramayca.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      paramayca.putExtra("main_tab_id", 6);
      paramayca.putExtra("open_now_tab_fragment", true);
      paramayca.putExtra("extra_from_share", true);
      paramayca.setFlags(335544320);
      paramActivity.startActivity(paramayca);
      paramActivity.overridePendingTransition(2130771993, 2130771995);
      return;
    }
    paramayca.putExtra("main_tab_id", 1);
    paramayca.setFlags(335544320);
    paramActivity.startActivity(paramayca);
  }
  
  public static void aa(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioChats&widgetinfo=" + paramString + "&cmode=all"));
    JumpActivity.aC(localIntent);
    JumpActivity.handleIntentForQQBrowser(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void ab(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioGifCameraTail&widgetinfo=" + paramString + "&cmode=singlegif"));
    JumpActivity.aC(localIntent);
    JumpActivity.handleIntentForQQBrowser(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void ac(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    JumpActivity.aC(localIntent);
    JumpActivity.handleIntentForQQBrowser(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static Bundle e(Bundle paramBundle, String paramString)
  {
    Object localObject1 = paramBundle.getString("KEY_CURRENT_SELECT_ID");
    String str = "";
    Object localObject2 = str;
    Object localObject3 = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\^");
      paramString = str;
      if (arrayOfString.length > 0) {
        paramString = arrayOfString[0];
      }
      if (arrayOfString.length == 1)
      {
        localObject1 = arrayOfString[0];
        paramString = AECaptureMode.NORMAL.name;
      }
      if (arrayOfString.length > 1) {
        localObject1 = arrayOfString[1];
      }
      localObject2 = paramString;
      localObject3 = localObject1;
      if (arrayOfString.length > 2)
      {
        localObject3 = arrayOfString[2];
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label153;
        }
        paramBundle.putString("KEY_CURRENT_TYPE", (String)localObject1);
      }
      for (;;)
      {
        paramBundle.putString("KEY_CURRENT_TAB", axcg.sA(paramString));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramBundle.putString("KEY_CURRENT_SELECT_ID", (String)localObject2);
        }
        return paramBundle;
        label153:
        paramBundle.putString("KEY_CURRENT_TYPE", " ");
      }
      localObject1 = "";
      paramString = (String)localObject2;
      localObject2 = localObject3;
    }
  }
  
  public static String sT(@Nullable String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.startsWith("mqqapi://"));
    return "mqqapi://videostory/takevideo?from=qzoneTail&widgetinfo=" + paramString + "&cmode=all";
  }
  
  public static void x(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    paramBundle.putInt("qq_sub_business_id", 3);
    paramBundle.putInt("entrance_type", 10001);
    paramBundle.putLong("qzone_slide_enable_mask", 3848427020667L);
    paramBundle.putBoolean("from_qzone_slideshow", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    QLog.e("QzoneSlideShowPreparingFragment", 2, "jumpToSlideShowEditVideoActivityForQzone start!");
    PublicFragmentActivityForPeak.start(paramActivity.getApplicationContext(), localIntent, QzoneSlideShowPreparingFragment.class);
    paramActivity.overridePendingTransition(2130772009, 2130772013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywz
 * JD-Core Version:    0.7.0.1
 */