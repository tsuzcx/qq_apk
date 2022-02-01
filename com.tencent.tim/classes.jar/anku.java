import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public class anku
{
  public static String TAG = "ShortVideoGuideUtil";
  private static int dJn;
  private static final String[] dh = { "N1T", "ZTE A2015" };
  private static final String[] gQ = new String[0];
  private static String mCallBack;
  private static String mPath = "";
  
  public static boolean A(AppInterface paramAppInterface)
  {
    if ((b(paramAppInterface)) && (y(paramAppInterface))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (ankb.axC()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "isSupportDanceGame false");
        }
      }
      return false;
    }
    return true;
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt)
  {
    paramAppInterface = new Intent(paramActivity, StoryTransitionActivity.class);
    paramAppInterface.putExtra("jump_action", 6);
    paramAppInterface.putExtra("web_target_type", paramInt);
    paramActivity.startActivity(paramAppInterface);
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, awtb paramawtb)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "startPTVActivity , supportVideo:" + paramString1 + ", supportPhoto:" + paramString2 + ", cameramode:" + paramString3 + ", beauty:" + paramString4 + ", unfoldDDStr:" + paramString6 + ", dDCategoryName:" + paramString7 + ", dDItemID:" + paramString8 + ", unfoldFilter:" + paramString10 + ", filterCategoryName:" + paramString11 + ", filterItemID:" + paramString12 + ", dealtype:" + paramString14 + ", activityType:" + paramString15 + ", activityId:" + paramString16 + ", callback:" + paramString17 + " subtitle:" + paramString13 + ", callerType:" + paramString18 + ", topicId:" + paramString19 + ", topicName:" + paramString20 + ", adTag=" + paramString21);
    }
    boolean bool1 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    int i;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if ("1".equals(paramString3))
    {
      i = 2;
      bool3 = "1".equals(paramString4);
      bool4 = "1".equals(paramString5);
      bool5 = "1".equals(paramString9);
      bool6 = "1".equals(paramString6);
      bool7 = "1".equals(paramString10);
      "1".equals(paramString13);
      if (!"1".equals(paramString14)) {
        break label400;
      }
    }
    label400:
    for (int j = 1;; j = 0)
    {
      if (paramawtb != null)
      {
        paramawtb.dsr = "1".equals(paramawtb.cSy);
        paramawtb.dss = "1".equals(paramawtb.cSz);
        paramawtb.des = "1".equals(paramawtb.cSC);
        paramawtb.dst = "1".equals(paramawtb.cSD);
      }
      if (alwy.auJ()) {
        break label406;
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "supportMediaCodec = false");
      }
      return false;
      i = 1;
      break;
    }
    label406:
    paramAppInterface = awtc.a(bool1, bool2, i, bool3, bool4, bool6, paramString7, paramString8, bool5, bool7, paramString11, paramString12, j, paramString15, paramString16, paramString17, paramString18, paramString19, paramString20, paramString21, paramawtb);
    paramString1 = new Intent(paramActivity, StoryTransitionActivity.class);
    paramString1.putExtras(paramAppInterface);
    paramString1.putExtra("jump_action", 7);
    paramActivity.startActivity(paramString1);
    return true;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    boolean bool = VideoEnvironment.o(paramAppInterface);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(TAG, 2, "isMobileSupportPTV fasle");
    }
    return bool;
  }
  
  public static void cf(Activity paramActivity)
  {
    if (!TextUtils.isEmpty(mPath))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
      localIntent.putExtra("shareto_web_mode", dJn);
      localIntent.putExtra("edit_video_call_back", mCallBack);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", mPath);
      localIntent.setFlags(536870912);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    boolean bool = true;
    if (paramAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "isAccLoginSucdess false.");
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (v(paramAppInterface)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i(TAG, 2, "isGuideReaded false.");
        return false;
        if (ankq.aB(BaseApplicationImpl.getContext()) == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "ispublicResReady iissupportFilterSo is false");
      return false;
    } while (!alwy.auJ());
    if (ShortVideoUtils.awI()) {}
    for (;;)
    {
      return bool;
      ShortVideoUtils.B(paramAppInterface);
      if (!ShortVideoUtils.awI()) {
        bool = false;
      }
    }
  }
  
  public static boolean v(AppInterface paramAppInterface)
  {
    if (!w(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isGuideReaded isPubicSo= false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isGuideReaded isPubicSo= true");
    }
    return true;
  }
  
  public static boolean w(AppInterface paramAppInterface)
  {
    boolean bool2 = ankq.axZ();
    boolean bool1;
    if (!bool2)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, "ispublicResReady iissupportFilterSo is false");
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      if (VideoEnvironment.o(paramAppInterface)) {
        break;
      }
      bool1 = false;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "ispublicResReady isVersion fasle");
    return false;
    return true;
  }
  
  public static boolean x(AppInterface paramAppInterface)
  {
    if (!ShortVideoUtils.awI())
    {
      ShortVideoUtils.B(paramAppInterface);
      if (!ShortVideoUtils.awI()) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean y(AppInterface paramAppInterface)
  {
    boolean bool = ankq.axZ();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(TAG, 2, "issupportFilterSo false");
    }
    return bool;
  }
  
  public static boolean z(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (Build.VERSION.SDK_INT < 21) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      bool1 = bool2;
      if (b(paramAppInterface))
      {
        bool1 = bool2;
        if (y(paramAppInterface)) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!bool1);
    return anhq.axc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anku
 * JD-Core Version:    0.7.0.1
 */