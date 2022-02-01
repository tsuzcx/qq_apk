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
public class qqz
{
  public long Bk = -1L;
  private final RMVideoStateMgr a;
  private final boolean aER;
  private boolean aES;
  public String ayg;
  public int bnI;
  public int bnJ = -1;
  public int bnK = 1;
  private final Activity mActivity;
  
  public qqz(@NonNull Activity paramActivity, @NonNull RMVideoStateMgr paramRMVideoStateMgr, @NonNull Intent paramIntent)
  {
    this.mActivity = paramActivity;
    this.a = paramRMVideoStateMgr;
    this.aER = paramIntent.getBooleanExtra("extra_now_tab", ppf.getBoolean(2131099654).booleanValue());
    this.bnK = paramIntent.getIntExtra("extra_memories_from", 1);
    this.bnJ = paramIntent.getIntExtra("start_origin", -1);
    this.Bk = paramIntent.getLongExtra("start_time", -1L);
    this.aES = paramIntent.getBooleanExtra("extra_donot_jump_story_home", false);
    this.ayg = paramIntent.getStringExtra("story_default_label");
    if ((paramIntent.getIntExtra("edit_video_type", 0) == 10002) && (this.Bk > 0L)) {
      rar.b("take_video", "video_startup", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.Bk), String.valueOf(this.bnJ) });
    }
    ram.b("QQStoryTakeVideoHelper", "default label:%s", this.ayg);
  }
  
  private boolean Kk()
  {
    if (TextUtils.isEmpty(this.a.bdG))
    {
      ram.e("QQStoryTakeVideoHelper", "check manifest's existance error. directory is null.");
      return false;
    }
    return aqhq.fileExists(this.a.bdG + File.separator + "manifest.ini");
  }
  
  private void a(PublishParam paramPublishParam, String paramString, int paramInt)
  {
    boolean bool2 = true;
    Intent localIntent;
    if (!this.aES)
    {
      if (((!this.aER) || (this.bnJ == 3)) && ((!this.aER) || (this.bnK < 1000))) {
        break label235;
      }
      if (ppg.ID())
      {
        StoryTransitionActivity.c(this.mActivity, qqp.class.getName(), null);
        this.mActivity.overridePendingTransition(0, 0);
      }
    }
    else
    {
      localIntent = new Intent();
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.putExtra("totalPublishVideoCount", paramPublishParam.bsP);
      if (paramPublishParam.bsY != 1) {
        break label288;
      }
      bool1 = true;
      label111:
      localIntent.putExtra("isTakePhoto", bool1);
      if (paramPublishParam.bta != 1) {
        break label294;
      }
    }
    label288:
    label294:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("isLocalPublish", bool1);
      if (!(this.mActivity instanceof SplashActivity)) {
        break label300;
      }
      return;
      localIntent = new Intent(this.mActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      this.mActivity.startActivity(localIntent);
      break;
      label235:
      if (paramInt == 15)
      {
        StoryTransitionActivity.cD(this.mActivity);
        break;
      }
      localIntent = new Intent(this.mActivity, QQStoryMainActivity.class);
      localIntent.putExtra("new_video_extra_info", paramString);
      this.mActivity.startActivity(localIntent);
      break;
      bool1 = false;
      break label111;
    }
    label300:
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
    this.mActivity.overridePendingTransition(0, 0);
  }
  
  public void a(Intent paramIntent, @NonNull ImageView paramImageView)
  {
    ram.d("QQStoryTakeVideoHelper", "preview confirm");
    PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
    if (localPublishParam == null) {
      return;
    }
    int i = paramIntent.getIntExtra("entrance_type", 99);
    String str = localPublishParam.thumbPath;
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
        if (localPublishParam.bsY != 1) {
          break;
        }
        ram.d("QQStoryTakeVideoHelper", "preview confirm takephoto ");
        a(localPublishParam, str, i);
        return;
        paramImageView.setImageDrawable(new ColorDrawable(-16777216));
      }
      if (!Kk())
      {
        ram.w("QQStoryTakeVideoHelper", "manifest file doesn't exist. generate again before publishing.");
        a(new qra(this, localPublishParam, str, i));
        return;
      }
      ram.i("QQStoryTakeVideoHelper", "manifest file already exists. start publishing.");
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
  
  public void a(qqz.a parama)
  {
    this.bnI = 1;
    Stream.of(this.a).map(new ThreadOffFunction("QQStoryTakeVideoHelper", 2)).map(new rkv()).subscribe(new qrb(this, parama));
  }
  
  public void bpQ()
  {
    qwv.a(new qrc(this, (psr)psx.a(10)));
  }
  
  public void bpR()
  {
    if ((this.bnJ == 3) && (this.bnK != 2)) {
      QQStoryMemoriesActivity.a(this.mActivity, this.bnK, QQStoryContext.a().getCurrentUid(), false);
    }
  }
  
  public String fY(String paramString)
  {
    Object localObject = (psr)psx.a(10);
    int i = ((Integer)((psr)localObject).c("StoryVideoWidth", Integer.valueOf(-1))).intValue();
    int j = ((Integer)((psr)localObject).c("StoryVideoHeight", Integer.valueOf(-1))).intValue();
    int k = ((Integer)((psr)localObject).c("StoryVideoMaxrate", Integer.valueOf(-1))).intValue();
    int m = ((Integer)((psr)localObject).c("StoryVideoMinrate", Integer.valueOf(-1))).intValue();
    String str = (String)((psr)localObject).c("StoryVideoKey", "960*720#600#1000;640*480#450#750");
    ram.d("QQStoryTakeVideoHelper", "setupStoryVideoConfig : key = " + str + " width = " + i + " height = " + j + " maxrate = " + k + " minrate = " + m);
    if ((i == -1) && (j == -1) && (k == -1) && (m == -1) && ((str == null) || (str.isEmpty()) || (str.equals("-1")))) {
      ram.d("QQStoryTakeVideoHelper", "setupStoryVideoConfig : no configs");
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
              paramString = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
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
    ram.w("QQStoryTakeVideoHelper", "setupStoryVideoConfig(): newConfig = " + paramString);
    return paramString;
  }
  
  public String mM()
  {
    return (String)((psr)psx.a(10)).c("StorySvc.get_photography_guide.word", acfp.m(2131712454));
  }
  
  public void th(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.aES = paramBoolean;
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onError();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqz
 * JD-Core Version:    0.7.0.1
 */