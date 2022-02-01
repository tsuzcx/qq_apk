import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.io.File;

@TargetApi(14)
public class yen
{
  public int a;
  public long a;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public String a;
  private final boolean jdField_a_of_type_Boolean;
  public int b;
  private boolean b;
  public int c = 1;
  
  public yen(@NonNull Activity paramActivity, @NonNull RMVideoStateMgr paramRMVideoStateMgr, @NonNull Intent paramIntent)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = paramRMVideoStateMgr;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("extra_now_tab", wnu.a(2131099651).booleanValue());
    this.c = paramIntent.getIntExtra("extra_memories_from", 1);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("start_origin", -1);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("start_time", -1L);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("extra_donot_jump_story_home", false);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("story_default_label");
    if ((paramIntent.getIntExtra("edit_video_type", 0) == 10002) && (this.jdField_a_of_type_Long > 0L)) {
      yup.b("take_video", "video_startup", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Int) });
    }
    yuk.a("QQStoryTakeVideoHelper", "default label:%s", this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(PublishParam paramPublishParam, String paramString, int paramInt)
  {
    boolean bool2 = true;
    Intent localIntent;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 3)) && ((!this.jdField_a_of_type_Boolean) || (this.c < 1000))) {
        break label235;
      }
      if (wnv.a())
      {
        StoryTransitionActivity.a(this.jdField_a_of_type_AndroidAppActivity, ydw.class.getName(), null);
        this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      }
    }
    else
    {
      localIntent = new Intent();
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.putExtra("totalPublishVideoCount", paramPublishParam.k);
      if (paramPublishParam.h != 1) {
        break label287;
      }
      bool1 = true;
      label111:
      localIntent.putExtra("isTakePhoto", bool1);
      if (paramPublishParam.l != 1) {
        break label293;
      }
    }
    label287:
    label293:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("isLocalPublish", bool1);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label299;
      }
      return;
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      break;
      label235:
      if (paramInt == 15)
      {
        StoryTransitionActivity.a(this.jdField_a_of_type_AndroidAppActivity);
        break;
      }
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryMainActivity.class);
      localIntent.putExtra("new_video_extra_info", paramString);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      break;
      bool1 = false;
      break label111;
    }
    label299:
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  private boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString))
    {
      yuk.e("QQStoryTakeVideoHelper", "check manifest's existance error. directory is null.");
      return false;
    }
    return bhmi.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + File.separator + "manifest.ini");
  }
  
  public String a()
  {
    return (String)((wta)wth.a(10)).b("StorySvc.get_photography_guide.word", anzj.a(2131709931));
  }
  
  public String a(String paramString)
  {
    Object localObject = (wta)wth.a(10);
    int i = ((Integer)((wta)localObject).b("StoryVideoWidth", Integer.valueOf(-1))).intValue();
    int j = ((Integer)((wta)localObject).b("StoryVideoHeight", Integer.valueOf(-1))).intValue();
    int k = ((Integer)((wta)localObject).b("StoryVideoMaxrate", Integer.valueOf(-1))).intValue();
    int m = ((Integer)((wta)localObject).b("StoryVideoMinrate", Integer.valueOf(-1))).intValue();
    String str = (String)((wta)localObject).b("StoryVideoKey", "960*720#600#1000;640*480#450#750");
    yuk.b("QQStoryTakeVideoHelper", "setupStoryVideoConfig : key = " + str + " width = " + i + " height = " + j + " maxrate = " + k + " minrate = " + m);
    if ((i == -1) && (j == -1) && (k == -1) && (m == -1) && ((str == null) || (str.isEmpty()) || (str.equals("-1")))) {
      yuk.b("QQStoryTakeVideoHelper", "setupStoryVideoConfig : no configs");
    }
    label390:
    String[] arrayOfString;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return paramString;
            localObject = paramString;
            if (paramString == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQStoryTakeVideoHelper", 2, "setupStoryVideoConfig()[use user passed config]: config is null");
              }
              paramString = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
              if (QLog.isColorLevel()) {
                QLog.d("QQStoryTakeVideoHelper", 2, "setupStoryVideoConfig(): DPConfig = " + paramString);
              }
              localObject = paramString;
              if (paramString == null) {
                localObject = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
              }
            }
            try
            {
              paramString = ((String)localObject).split(",");
              if ((paramString != null) && (paramString.length != 0)) {
                break label390;
              }
              paramString = (String)localObject;
              if (QLog.isColorLevel())
              {
                QLog.d("QQStoryTakeVideoHelper", 2, "setupStoryVideoConfig(): configs is null or its length is 0");
                return localObject;
              }
            }
            catch (Exception localException)
            {
              paramString = (String)localObject;
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQStoryTakeVideoHelper", 2, "setupStoryVideoConfig(): parse config exception config = " + (String)localObject, localException);
        return localObject;
        arrayOfString = paramString[0].split("\\|");
        if ((arrayOfString != null) && (arrayOfString.length >= 13)) {
          break;
        }
        paramString = (String)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("QQStoryTakeVideoHelper", 2, "setupStoryVideoConfig(): configs is null or length less than 13");
      return localObject;
      paramString = arrayOfString[3].split("\\*");
      if ((paramString != null) && (paramString.length == 2)) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("QQStoryTakeVideoHelper", 2, "setupStoryVideoConfig(): resolution is null or length is not 2");
    return localObject;
    if ((!str.isEmpty()) && (!str.equals("-1")))
    {
      arrayOfString[13] = "key=";
      arrayOfString[13] = (arrayOfString[13] + str);
    }
    if ((i > 0) && (j > 0)) {
      arrayOfString[3] = (i + "*" + j);
    }
    if (k > 0) {
      arrayOfString[4] = (k + "");
    }
    if (m > 0) {
      arrayOfString[5] = (m + "");
    }
    paramString = "";
    i = 0;
    while (i < arrayOfString.length)
    {
      localObject = paramString + arrayOfString[i];
      paramString = (String)localObject;
      if (i != arrayOfString.length - 1) {
        paramString = (String)localObject + "|";
      }
      i += 1;
    }
    yuk.d("QQStoryTakeVideoHelper", "setupStoryVideoConfig(): newConfig = " + paramString);
    return paramString;
  }
  
  public void a()
  {
    yow.a(new yeq(this, (wta)wth.a(10)));
  }
  
  public void a(Intent paramIntent, @NonNull ImageView paramImageView)
  {
    yuk.b("QQStoryTakeVideoHelper", "preview confirm");
    PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
    if (localPublishParam == null) {
      return;
    }
    int i = paramIntent.getIntExtra("entrance_type", 99);
    String str = localPublishParam.c;
    Object localObject;
    if (paramImageView != null)
    {
      localObject = null;
      paramIntent = localObject;
      if (new File(str).exists())
      {
        paramIntent = new BitmapFactory.Options();
        paramIntent.inPreferredConfig = Bitmap.Config.RGB_565;
        paramIntent.inSampleSize = 2;
      }
    }
    try
    {
      paramIntent = BitmapFactory.decodeFile(str);
      if (paramIntent != null) {
        paramImageView.setImageBitmap(paramIntent);
      }
      for (;;)
      {
        paramImageView.setVisibility(0);
        if (localPublishParam.h != 1) {
          break;
        }
        yuk.b("QQStoryTakeVideoHelper", "preview confirm takephoto ");
        a(localPublishParam, str, i);
        return;
        paramImageView.setImageDrawable(new ColorDrawable(-16777216));
      }
      if (!a())
      {
        yuk.d("QQStoryTakeVideoHelper", "manifest file doesn't exist. generate again before publishing.");
        a(new yeo(this, localPublishParam, str, i));
        return;
      }
      yuk.c("QQStoryTakeVideoHelper", "manifest file already exists. start publishing.");
      a(localPublishParam, str, i);
      return;
    }
    catch (OutOfMemoryError paramIntent)
    {
      for (;;)
      {
        paramIntent = localObject;
      }
    }
  }
  
  public void a(yer paramyer)
  {
    this.jdField_a_of_type_Int = 1;
    Stream.of(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr).map(new ThreadOffFunction("QQStoryTakeVideoHelper", 2)).map(new ziq()).subscribe(new yep(this, paramyer));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_Int == 3) && (this.c != 2)) {
      QQStoryMemoriesActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.c, QQStoryContext.a().b(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yen
 * JD-Core Version:    0.7.0.1
 */