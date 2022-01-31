import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.1;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.12;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.14;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.16;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.18;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.2;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.20;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.22;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.3;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.4;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.5;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.6;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.8;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class vnr
{
  public static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) && (paramBitmap2 == null))
    {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg error");
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap2;
    } while (paramBitmap1 == null);
    if (paramBitmap2 == null) {
      return paramBitmap1;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
    if ((i != k) || (j != m))
    {
      float f1 = i / k;
      float f2 = j / m;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
      localCanvas.drawBitmap(paramBitmap2, localMatrix, null);
    }
    for (;;)
    {
      localCanvas.save();
      paramBitmap1.recycle();
      paramBitmap2.recycle();
      return localBitmap;
      localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
    }
  }
  
  public static Bitmap a(srp paramsrp, int paramInt1, int paramInt2)
  {
    if (paramsrp == null)
    {
      urk.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    urk.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramsrp, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    Object localObject = BaseApplicationImpl.getContext();
    InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout((Context)localObject);
    localInteractContainerLayout.a(paramsrp, 0);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localInteractContainerLayout.a(paramsrp, 0);
    paramsrp = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramsrp != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramsrp));
      return paramsrp;
    }
    urk.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static Bitmap a(srq paramsrq, int paramInt1, int paramInt2)
  {
    if (paramsrq == null)
    {
      urk.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    Object localObject = BaseApplicationImpl.getContext();
    PollContainerLayout localPollContainerLayout = new PollContainerLayout((Context)localObject);
    localPollContainerLayout.a(paramsrq, -1, null);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localPollContainerLayout.a(paramsrq, -1, null);
    paramsrq = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramsrq != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramsrq));
      return paramsrq;
    }
    urk.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static final String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public static String a(StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem == null) || (!paramStoryVideoItem.isPollVideo()))
    {
      urk.b("FFmpegUtils", "getVideoVoteWidgetPath find not-poll-video");
      return null;
    }
    return a(paramStoryVideoItem.getPollLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.contains("?")) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    }
    int i = str.lastIndexOf(".");
    if ((i > -1) && (i < str.length() - 1)) {
      return str.substring(i);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder().append("QQStoryMoment").append(System.currentTimeMillis()).append("_").append(paramString1);
    if (paramString2 != null) {}
    for (;;)
    {
      return paramString2;
      paramString2 = ".mp4";
    }
  }
  
  public static String a(srp paramsrp, int paramInt1, int paramInt2)
  {
    if (paramsrp == null)
    {
      urk.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    urk.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramsrp, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new InteractContainerLayout(localBaseApplication);
    ((InteractContainerLayout)localObject).a(paramsrp, 0);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((InteractContainerLayout)localObject).a(paramsrp, 0);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramsrp = localBaseApplication.getCacheDir().getAbsolutePath() + "/grade-" + System.currentTimeMillis() + ".png";
      boolean bool = vlc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramsrp);
      ((Bitmap)localObject).recycle();
      urk.d("FFmpegUtils", "generateInteractWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramsrp });
      if (bool) {}
      for (;;)
      {
        return paramsrp;
        paramsrp = null;
      }
    }
    urk.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static String a(srq paramsrq, int paramInt1, int paramInt2)
  {
    if (paramsrq == null)
    {
      urk.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new PollContainerLayout(localBaseApplication);
    ((PollContainerLayout)localObject).a(paramsrq, -1, null);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((PollContainerLayout)localObject).a(paramsrq, -1, null);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramsrq = localBaseApplication.getCacheDir().getAbsolutePath() + "/vote-" + System.currentTimeMillis() + ".png";
      boolean bool = vlc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramsrq);
      ((Bitmap)localObject).recycle();
      urk.d("FFmpegUtils", "generateVideoVoteWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramsrq });
      if (bool) {}
      for (;;)
      {
        return paramsrq;
        paramsrq = null;
      }
    }
    urk.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static void a()
  {
    vni.a(BaseApplicationImpl.getApplication()).b(false);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, vnq paramvnq)
  {
    ArrayList localArrayList = new ArrayList();
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 11;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.3(paramString1, paramInt1, paramInt2, paramInt3, paramBoolean, paramString2);
    localvno.jdField_a_of_type_Vnq = paramvnq;
    localArrayList.add(localvno);
    paramContext = vni.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, vnh paramvnh)
  {
    a(false, paramContext, paramString1, paramString2, "h264", paramInt1, paramInt2, paramString3, false, paramvnh);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, vnh paramvnh)
  {
    a(false, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, paramBoolean, paramvnh);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, vnq paramvnq)
  {
    ArrayList localArrayList = new ArrayList();
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 13;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.2(paramString1, paramString2, paramInt);
    localvno.jdField_a_of_type_Vnq = paramvnq;
    localArrayList.add(localvno);
    paramContext = vni.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, vnh paramvnh)
  {
    String str2 = paramPublishVideoEntry.backgroundMusicPath;
    int j = paramPublishVideoEntry.backgroundMusicOffset;
    int k = paramPublishVideoEntry.backgroundMusicDuration;
    float f1 = Float.valueOf(paramPublishVideoEntry.getStringExtra("originalRecordVolume", String.valueOf(0.7F))).floatValue();
    float f2 = Float.valueOf(paramPublishVideoEntry.getStringExtra("backgroundVolume", String.valueOf(1.0F))).floatValue();
    long l = System.currentTimeMillis();
    Object localObject1 = a(str2);
    int i;
    Object localObject2;
    String str1;
    ArrayList localArrayList;
    label252:
    Object localObject3;
    String str3;
    if ((((String)localObject1).equals(".mp4")) || (((String)localObject1).equals(".m4a")))
    {
      i = 1;
      localObject2 = new File(sfm.f);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(sfm.f);
      ((StringBuffer)localObject2).append(str2.hashCode());
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append(j);
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append(k);
      ((StringBuffer)localObject2).append(".m4a");
      localObject2 = new String((StringBuffer)localObject2);
      str1 = paramPublishVideoEntry.videoUploadTempDir + "clipNoneMp4Temp" + (String)localObject1;
      localArrayList = new ArrayList();
      if (i == 0) {
        break label568;
      }
      localObject1 = localObject2;
      a(paramPublishVideoEntry, paramvnh, str2, j, k, (String)localObject1, localArrayList);
      if (i == 0) {
        c(paramPublishVideoEntry, str1, (String)localObject2, paramvnh, localArrayList);
      }
      localObject1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
      str2 = paramPublishVideoEntry.videoUploadTempDir + "local_video_audio.m4a";
      str1 = paramPublishVideoEntry.videoUploadTempDir + "transcode_local_video_audio.m4a";
      if (paramPublishVideoEntry.isLocalPublish)
      {
        b(paramPublishVideoEntry, paramString1, str2, paramvnh, localArrayList);
        c(paramPublishVideoEntry, str2, str1, paramvnh, localArrayList);
      }
      localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append(sfm.f);
      ((StringBuffer)localObject3).append(((String)localObject1).hashCode());
      ((StringBuffer)localObject3).append("_mix_with_music");
      ((StringBuffer)localObject3).append(".mp4");
      localObject3 = new String((StringBuffer)localObject3);
      str3 = sfm.f + paramString1.hashCode() + "_none_audio_video.mp4";
      if (!paramPublishVideoEntry.isLocalPublish) {
        break label575;
      }
      localObject1 = str1;
    }
    label568:
    label575:
    for (;;)
    {
      a(paramPublishVideoEntry, (String)localObject1, (String)localObject2, (String)localObject3, f1, f2, paramvnh, localArrayList);
      a(paramPublishVideoEntry, str3, paramString1, paramvnh, localArrayList);
      a(paramString2, paramPublishVideoEntry, paramBoolean, paramvnh, k, l, (String)localObject2, localArrayList, str2, (String)localObject3, str3);
      paramContext = vni.a(paramContext, true);
      if (!paramContext.a()) {
        break label578;
      }
      paramContext.b(localArrayList);
      return;
      i = 0;
      break;
      localObject1 = str1;
      break label252;
    }
    label578:
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, vnq paramvnq)
  {
    ArrayList localArrayList = new ArrayList();
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 12;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.1(paramString1, paramString2, paramString3);
    localvno.jdField_a_of_type_Vnq = paramvnq;
    localArrayList.add(localvno);
    paramContext = vni.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, vnq paramvnq)
  {
    ArrayList localArrayList = new ArrayList();
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 9;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.4(paramString1, paramString2);
    localvno.jdField_a_of_type_Vnq = paramvnq;
    localArrayList.add(localvno);
    paramContext = vni.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, vnh paramvnh, ArrayList<vno> paramArrayList)
  {
    if (vlm.b(paramString3)) {
      vlm.f(paramString3);
    }
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 17;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.22(paramString1, paramString2, paramString3, paramFloat1, paramFloat2);
    localvno.jdField_a_of_type_Vnq = new vnx(paramvnh, paramPublishVideoEntry);
    paramArrayList.add(localvno);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, vnh paramvnh, ArrayList<vno> paramArrayList)
  {
    if (vlm.b(paramString1)) {
      vlm.f(paramString1);
    }
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 19;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.16(paramString2, paramString1);
    localvno.jdField_a_of_type_Vnq = new vnu(paramvnh, paramPublishVideoEntry);
    paramArrayList.add(localvno);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, vnh paramvnh, String paramString1, int paramInt1, int paramInt2, String paramString2, ArrayList<vno> paramArrayList)
  {
    if (vlm.b(paramString2)) {
      vlm.f(paramString2);
    }
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 3;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.12(paramString1, paramString2, paramInt1, paramInt2);
    localvno.jdField_a_of_type_Vnq = new vns(paramvnh, paramPublishVideoEntry);
    paramArrayList.add(localvno);
  }
  
  private static void a(String paramString1, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, vnh paramvnh, int paramInt, long paramLong, String paramString2, ArrayList<vno> paramArrayList, String paramString3, String paramString4, String paramString5)
  {
    if (vlm.b(paramString1)) {
      vlm.f(paramString1);
    }
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 4;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.14(paramString5, paramString4, paramString1, paramBoolean, paramInt);
    localvno.jdField_a_of_type_Vnq = new vnt(paramvnh, paramPublishVideoEntry, paramString2, paramString4, paramString5, paramString3, paramLong);
    paramArrayList.add(localvno);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, vnq paramvnq)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-b:v");
    localArrayList.add("" + paramInt);
    localArrayList.add("-profile:v");
    localArrayList.add("baseline");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    vni.a(BaseApplicationImpl.getApplication()).a((String[])localArrayList.toArray(new String[0]), paramvnq);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, vnh paramvnh)
  {
    a(paramBoolean, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, false, paramvnh);
  }
  
  private static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean2, vnh paramvnh)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = a(paramString2);
    Object localObject2 = new File(sfm.f);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(sfm.f);
    ((StringBuffer)localObject2).append(paramString2.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt1);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt2);
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject2 = new String((StringBuffer)localObject2);
    localObject1 = new ArrayList();
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 3;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.6(paramString2, (String)localObject2, paramInt1, paramInt2);
    localvno.jdField_a_of_type_Vnq = new vny(paramvnh);
    ((ArrayList)localObject1).add(localvno);
    paramString2 = new vno();
    paramString2.jdField_a_of_type_Int = 4;
    paramString2.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.8(paramString1, (String)localObject2, paramString3, paramString4, paramBoolean2, paramInt2);
    paramString2.jdField_a_of_type_Vnq = new vnz(paramvnh, (String)localObject2, l);
    ((ArrayList)localObject1).add(paramString2);
    if (paramBoolean1) {}
    for (paramContext = vni.b(paramContext, true); paramContext.a(); paramContext = vni.a(paramContext, true))
    {
      paramContext.b((ArrayList)localObject1);
      return;
    }
    paramContext.a((ArrayList)localObject1);
  }
  
  public static boolean a(Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg error");
      return false;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
    if ((i != k) || (j != m))
    {
      float f1 = i / k;
      float f2 = j / m;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
      localCanvas.drawBitmap(paramBitmap2, localMatrix, null);
    }
    for (;;)
    {
      localCanvas.save();
      try
      {
        bacm.a(localBitmap, new File(paramString));
        return true;
      }
      catch (IOException paramString)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg IOException " + paramString.getMessage());
        return false;
      }
      finally
      {
        paramBitmap1.recycle();
        paramBitmap2.recycle();
      }
      localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
    }
  }
  
  public static boolean a(Process paramProcess)
  {
    return voh.a(paramProcess);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      return false;
      paramString2 = SafeBitmapFactory.decodeFile(paramString2);
      paramString1 = SafeBitmapFactory.decodeFile(paramString1);
    } while ((paramString2 == null) || (paramString1 == null));
    return a(paramString1, paramString2, paramString3);
  }
  
  public static String b(StoryVideoItem paramStoryVideoItem)
  {
    switch (paramStoryVideoItem.getVideoMaskType())
    {
    }
    String str;
    do
    {
      return null;
      return paramStoryVideoItem.mLocalMaskPath;
      return paramStoryVideoItem.mAtImagePath;
      str = sfm.u;
      str = str + paramStoryVideoItem.mVid + "_max.png";
    } while ((!vlm.c(str)) && (!a(paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.mAtImagePath, str)));
    return str;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, vnh paramvnh)
  {
    a(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramString3, true, paramvnh);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3, vnq paramvnq)
  {
    ArrayList localArrayList = new ArrayList();
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 20;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.5(paramString1, paramString2, paramString3);
    localvno.jdField_a_of_type_Vnq = paramvnq;
    localArrayList.add(localvno);
    paramContext = vni.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  private static void b(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, vnh paramvnh, ArrayList<vno> paramArrayList)
  {
    if (vlm.b(paramString2)) {
      vlm.f(paramString2);
    }
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 18;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.18(paramString1, paramString2);
    localvno.jdField_a_of_type_Vnq = new vnv(paramvnh, paramPublishVideoEntry);
    paramArrayList.add(localvno);
  }
  
  private static void c(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, vnh paramvnh, ArrayList<vno> paramArrayList)
  {
    if (vlm.b(paramString2)) {
      vlm.f(paramString2);
    }
    vno localvno = new vno();
    localvno.jdField_a_of_type_Int = 21;
    localvno.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.20(paramString1, paramString2);
    localvno.jdField_a_of_type_Vnq = new vnw(paramvnh, paramPublishVideoEntry);
    paramArrayList.add(localvno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnr
 * JD-Core Version:    0.7.0.1
 */