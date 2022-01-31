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

public class wak
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
  
  public static Bitmap a(tei paramtei, int paramInt1, int paramInt2)
  {
    if (paramtei == null)
    {
      ved.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    ved.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramtei, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    Object localObject = BaseApplicationImpl.getContext();
    InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout((Context)localObject);
    localInteractContainerLayout.a(paramtei, 0);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localInteractContainerLayout.a(paramtei, 0);
    paramtei = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramtei != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramtei));
      return paramtei;
    }
    ved.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static Bitmap a(tej paramtej, int paramInt1, int paramInt2)
  {
    if (paramtej == null)
    {
      ved.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    Object localObject = BaseApplicationImpl.getContext();
    PollContainerLayout localPollContainerLayout = new PollContainerLayout((Context)localObject);
    localPollContainerLayout.a(paramtej, -1, null);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localPollContainerLayout.a(paramtej, -1, null);
    paramtej = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramtej != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramtej));
      return paramtej;
    }
    ved.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ved.b("FFmpegUtils", "getVideoVoteWidgetPath find not-poll-video");
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
  
  public static String a(tei paramtei, int paramInt1, int paramInt2)
  {
    if (paramtei == null)
    {
      ved.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    ved.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramtei, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new InteractContainerLayout(localBaseApplication);
    ((InteractContainerLayout)localObject).a(paramtei, 0);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((InteractContainerLayout)localObject).a(paramtei, 0);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramtei = localBaseApplication.getCacheDir().getAbsolutePath() + "/grade-" + System.currentTimeMillis() + ".png";
      boolean bool = vxv.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramtei);
      ((Bitmap)localObject).recycle();
      ved.d("FFmpegUtils", "generateInteractWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramtei });
      if (bool) {}
      for (;;)
      {
        return paramtei;
        paramtei = null;
      }
    }
    ved.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static String a(tej paramtej, int paramInt1, int paramInt2)
  {
    if (paramtej == null)
    {
      ved.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new PollContainerLayout(localBaseApplication);
    ((PollContainerLayout)localObject).a(paramtej, -1, null);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((PollContainerLayout)localObject).a(paramtej, -1, null);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramtej = localBaseApplication.getCacheDir().getAbsolutePath() + "/vote-" + System.currentTimeMillis() + ".png";
      boolean bool = vxv.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramtej);
      ((Bitmap)localObject).recycle();
      ved.d("FFmpegUtils", "generateVideoVoteWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramtej });
      if (bool) {}
      for (;;)
      {
        return paramtej;
        paramtej = null;
      }
    }
    ved.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static void a()
  {
    wab.a(BaseApplicationImpl.getApplication()).b(false);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, waj paramwaj)
  {
    ArrayList localArrayList = new ArrayList();
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 11;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.3(paramString1, paramInt1, paramInt2, paramInt3, paramBoolean, paramString2);
    localwah.jdField_a_of_type_Waj = paramwaj;
    localArrayList.add(localwah);
    paramContext = wab.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, waa paramwaa)
  {
    a(false, paramContext, paramString1, paramString2, "h264", paramInt1, paramInt2, paramString3, false, paramwaa);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, waa paramwaa)
  {
    a(false, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, paramBoolean, paramwaa);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, waj paramwaj)
  {
    ArrayList localArrayList = new ArrayList();
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 13;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.2(paramString1, paramString2, paramInt);
    localwah.jdField_a_of_type_Waj = paramwaj;
    localArrayList.add(localwah);
    paramContext = wab.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, waa paramwaa)
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
      localObject2 = new File(ssf.f);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(ssf.f);
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
      a(paramPublishVideoEntry, paramwaa, str2, j, k, (String)localObject1, localArrayList);
      if (i == 0) {
        c(paramPublishVideoEntry, str1, (String)localObject2, paramwaa, localArrayList);
      }
      localObject1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
      str2 = paramPublishVideoEntry.videoUploadTempDir + "local_video_audio.m4a";
      str1 = paramPublishVideoEntry.videoUploadTempDir + "transcode_local_video_audio.m4a";
      if (paramPublishVideoEntry.isLocalPublish)
      {
        b(paramPublishVideoEntry, paramString1, str2, paramwaa, localArrayList);
        c(paramPublishVideoEntry, str2, str1, paramwaa, localArrayList);
      }
      localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append(ssf.f);
      ((StringBuffer)localObject3).append(((String)localObject1).hashCode());
      ((StringBuffer)localObject3).append("_mix_with_music");
      ((StringBuffer)localObject3).append(".mp4");
      localObject3 = new String((StringBuffer)localObject3);
      str3 = ssf.f + paramString1.hashCode() + "_none_audio_video.mp4";
      if (!paramPublishVideoEntry.isLocalPublish) {
        break label575;
      }
      localObject1 = str1;
    }
    label568:
    label575:
    for (;;)
    {
      a(paramPublishVideoEntry, (String)localObject1, (String)localObject2, (String)localObject3, f1, f2, paramwaa, localArrayList);
      a(paramPublishVideoEntry, str3, paramString1, paramwaa, localArrayList);
      a(paramString2, paramPublishVideoEntry, paramBoolean, paramwaa, k, l, (String)localObject2, localArrayList, str2, (String)localObject3, str3);
      paramContext = wab.a(paramContext, true);
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
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, waj paramwaj)
  {
    ArrayList localArrayList = new ArrayList();
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 12;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.1(paramString1, paramString2, paramString3);
    localwah.jdField_a_of_type_Waj = paramwaj;
    localArrayList.add(localwah);
    paramContext = wab.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, waj paramwaj)
  {
    ArrayList localArrayList = new ArrayList();
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 9;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.4(paramString1, paramString2);
    localwah.jdField_a_of_type_Waj = paramwaj;
    localArrayList.add(localwah);
    paramContext = wab.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, waa paramwaa, ArrayList<wah> paramArrayList)
  {
    if (vyf.b(paramString3)) {
      vyf.f(paramString3);
    }
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 17;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.22(paramString1, paramString2, paramString3, paramFloat1, paramFloat2);
    localwah.jdField_a_of_type_Waj = new waq(paramwaa, paramPublishVideoEntry);
    paramArrayList.add(localwah);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, waa paramwaa, ArrayList<wah> paramArrayList)
  {
    if (vyf.b(paramString1)) {
      vyf.f(paramString1);
    }
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 19;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.16(paramString2, paramString1);
    localwah.jdField_a_of_type_Waj = new wan(paramwaa, paramPublishVideoEntry);
    paramArrayList.add(localwah);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, waa paramwaa, String paramString1, int paramInt1, int paramInt2, String paramString2, ArrayList<wah> paramArrayList)
  {
    if (vyf.b(paramString2)) {
      vyf.f(paramString2);
    }
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 3;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.12(paramString1, paramString2, paramInt1, paramInt2);
    localwah.jdField_a_of_type_Waj = new wal(paramwaa, paramPublishVideoEntry);
    paramArrayList.add(localwah);
  }
  
  private static void a(String paramString1, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, waa paramwaa, int paramInt, long paramLong, String paramString2, ArrayList<wah> paramArrayList, String paramString3, String paramString4, String paramString5)
  {
    if (vyf.b(paramString1)) {
      vyf.f(paramString1);
    }
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 4;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.14(paramString5, paramString4, paramString1, paramBoolean, paramInt);
    localwah.jdField_a_of_type_Waj = new wam(paramwaa, paramPublishVideoEntry, paramString2, paramString4, paramString5, paramString3, paramLong);
    paramArrayList.add(localwah);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, waj paramwaj)
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
    wab.a(BaseApplicationImpl.getApplication()).a((String[])localArrayList.toArray(new String[0]), paramwaj);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, waa paramwaa)
  {
    a(paramBoolean, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, false, paramwaa);
  }
  
  private static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean2, waa paramwaa)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = a(paramString2);
    Object localObject2 = new File(ssf.f);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(ssf.f);
    ((StringBuffer)localObject2).append(paramString2.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt1);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt2);
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject2 = new String((StringBuffer)localObject2);
    localObject1 = new ArrayList();
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 3;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.6(paramString2, (String)localObject2, paramInt1, paramInt2);
    localwah.jdField_a_of_type_Waj = new war(paramwaa);
    ((ArrayList)localObject1).add(localwah);
    paramString2 = new wah();
    paramString2.jdField_a_of_type_Int = 4;
    paramString2.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.8(paramString1, (String)localObject2, paramString3, paramString4, paramBoolean2, paramInt2);
    paramString2.jdField_a_of_type_Waj = new was(paramwaa, (String)localObject2, l);
    ((ArrayList)localObject1).add(paramString2);
    if (paramBoolean1) {}
    for (paramContext = wab.b(paramContext, true); paramContext.a(); paramContext = wab.a(paramContext, true))
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
        bbef.a(localBitmap, new File(paramString));
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
    return wba.a(paramProcess);
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
      str = ssf.u;
      str = str + paramStoryVideoItem.mVid + "_max.png";
    } while ((!vyf.c(str)) && (!a(paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.mAtImagePath, str)));
    return str;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, waa paramwaa)
  {
    a(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramString3, true, paramwaa);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3, waj paramwaj)
  {
    ArrayList localArrayList = new ArrayList();
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 20;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.5(paramString1, paramString2, paramString3);
    localwah.jdField_a_of_type_Waj = paramwaj;
    localArrayList.add(localwah);
    paramContext = wab.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  private static void b(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, waa paramwaa, ArrayList<wah> paramArrayList)
  {
    if (vyf.b(paramString2)) {
      vyf.f(paramString2);
    }
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 18;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.18(paramString1, paramString2);
    localwah.jdField_a_of_type_Waj = new wao(paramwaa, paramPublishVideoEntry);
    paramArrayList.add(localwah);
  }
  
  private static void c(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, waa paramwaa, ArrayList<wah> paramArrayList)
  {
    if (vyf.b(paramString2)) {
      vyf.f(paramString2);
    }
    wah localwah = new wah();
    localwah.jdField_a_of_type_Int = 21;
    localwah.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.20(paramString1, paramString2);
    localwah.jdField_a_of_type_Waj = new wap(paramwaa, paramPublishVideoEntry);
    paramArrayList.add(localwah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wak
 * JD-Core Version:    0.7.0.1
 */