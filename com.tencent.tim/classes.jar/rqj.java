import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
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

public class rqj
{
  public static final SimpleDateFormat u = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
  
  public static Bitmap a(StoryVideoItem.a parama, int paramInt1, int paramInt2)
  {
    if (parama == null)
    {
      ram.d("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    ram.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", parama, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    Object localObject = BaseApplicationImpl.getContext();
    InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout((Context)localObject);
    localInteractContainerLayout.a(parama, 0);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localInteractContainerLayout.a(parama, 0);
    parama = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (parama != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(parama));
      return parama;
    }
    ram.w("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static Bitmap a(StoryVideoItem.b paramb, int paramInt1, int paramInt2)
  {
    if (paramb == null)
    {
      ram.d("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    Object localObject = BaseApplicationImpl.getContext();
    PollContainerLayout localPollContainerLayout = new PollContainerLayout((Context)localObject);
    localPollContainerLayout.a(paramb, -1, null);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localPollContainerLayout.a(paramb, -1, null);
    paramb = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramb != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramb));
      return paramb;
    }
    ram.w("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static final String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public static String a(StoryVideoItem.a parama, int paramInt1, int paramInt2)
  {
    if (parama == null)
    {
      ram.d("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    ram.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", parama, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new InteractContainerLayout(localBaseApplication);
    ((InteractContainerLayout)localObject).a(parama, 0);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((InteractContainerLayout)localObject).a(parama, 0);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      parama = localBaseApplication.getCacheDir().getAbsolutePath() + "/grade-" + System.currentTimeMillis() + ".png";
      boolean bool = rop.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, parama);
      ((Bitmap)localObject).recycle();
      ram.w("FFmpegUtils", "generateInteractWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), parama });
      if (bool) {}
      for (;;)
      {
        return parama;
        parama = null;
      }
    }
    ram.w("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static String a(StoryVideoItem.b paramb, int paramInt1, int paramInt2)
  {
    if (paramb == null)
    {
      ram.d("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new PollContainerLayout(localBaseApplication);
    ((PollContainerLayout)localObject).a(paramb, -1, null);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((PollContainerLayout)localObject).a(paramb, -1, null);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramb = localBaseApplication.getCacheDir().getAbsolutePath() + "/vote-" + System.currentTimeMillis() + ".png";
      boolean bool = rop.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramb);
      ((Bitmap)localObject).recycle();
      ram.w("FFmpegUtils", "generateVideoVoteWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramb });
      if (bool) {}
      for (;;)
      {
        return paramb;
        paramb = null;
      }
    }
    ram.w("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    rqg localrqg = new rqg();
    localrqg.cmdType = 11;
    localrqg.nL = new FFmpegUtils.3(paramString1, paramInt1, paramInt2, paramInt3, paramBoolean, paramString2);
    localrqg.d = paramrqi;
    localArrayList.add(localrqg);
    paramContext = rqa.a(paramContext);
    if (paramContext.LT())
    {
      paramContext.cv(localArrayList);
      return;
    }
    paramContext.cu(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, rpz paramrpz)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    a(false, paramContext, paramString1, paramString2, "h264", paramInt1, paramInt2, paramString3, false, paramrpz);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, rpz paramrpz)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    a(false, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, paramBoolean, paramrpz);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    rqg localrqg = new rqg();
    localrqg.cmdType = 13;
    localrqg.nL = new FFmpegUtils.2(paramString1, paramString2, paramInt);
    localrqg.d = paramrqi;
    localArrayList.add(localrqg);
    paramContext = rqa.a(paramContext);
    if (paramContext.LT())
    {
      paramContext.cv(localArrayList);
      return;
    }
    paramContext.cu(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, rpz paramrpz)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    String str2 = paramPublishVideoEntry.backgroundMusicPath;
    int j = paramPublishVideoEntry.backgroundMusicOffset;
    int k = paramPublishVideoEntry.backgroundMusicDuration;
    float f1 = Float.valueOf(paramPublishVideoEntry.getStringExtra("originalRecordVolume", String.valueOf(0.7F))).floatValue();
    float f2 = Float.valueOf(paramPublishVideoEntry.getStringExtra("backgroundVolume", String.valueOf(1.0F))).floatValue();
    long l = System.currentTimeMillis();
    Object localObject1 = gr(str2);
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
      localObject2 = new File(plr.atd);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(plr.atd);
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
      a(paramPublishVideoEntry, paramrpz, str2, j, k, (String)localObject1, localArrayList);
      if (i == 0) {
        c(paramPublishVideoEntry, str1, (String)localObject2, paramrpz, localArrayList);
      }
      localObject1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
      str2 = paramPublishVideoEntry.videoUploadTempDir + "local_video_audio.m4a";
      str1 = paramPublishVideoEntry.videoUploadTempDir + "transcode_local_video_audio.m4a";
      if (paramPublishVideoEntry.isLocalPublish)
      {
        b(paramPublishVideoEntry, paramString1, str2, paramrpz, localArrayList);
        c(paramPublishVideoEntry, str2, str1, paramrpz, localArrayList);
      }
      localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append(plr.atd);
      ((StringBuffer)localObject3).append(((String)localObject1).hashCode());
      ((StringBuffer)localObject3).append("_mix_with_music");
      ((StringBuffer)localObject3).append(".mp4");
      localObject3 = new String((StringBuffer)localObject3);
      str3 = plr.atd + paramString1.hashCode() + "_none_audio_video.mp4";
      if (!paramPublishVideoEntry.isLocalPublish) {
        break label575;
      }
      localObject1 = str1;
    }
    label568:
    label575:
    for (;;)
    {
      a(paramPublishVideoEntry, (String)localObject1, (String)localObject2, (String)localObject3, f1, f2, paramrpz, localArrayList);
      a(paramPublishVideoEntry, str3, paramString1, paramrpz, localArrayList);
      a(paramString2, paramPublishVideoEntry, paramBoolean, paramrpz, k, l, (String)localObject2, localArrayList, str2, (String)localObject3, str3);
      paramContext = rqa.a(paramContext, true);
      if (!paramContext.LT()) {
        break label578;
      }
      paramContext.cv(localArrayList);
      return;
      i = 0;
      break;
      localObject1 = str1;
      break label252;
    }
    label578:
    paramContext.cu(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    rqg localrqg = new rqg();
    localrqg.cmdType = 12;
    localrqg.nL = new FFmpegUtils.1(paramString1, paramString2, paramString3);
    localrqg.d = paramrqi;
    localArrayList.add(localrqg);
    paramContext = rqa.a(paramContext);
    if (paramContext.LT())
    {
      paramContext.cv(localArrayList);
      return;
    }
    paramContext.cu(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    rqg localrqg = new rqg();
    localrqg.cmdType = 9;
    localrqg.nL = new FFmpegUtils.4(paramString1, paramString2);
    localrqg.d = paramrqi;
    localArrayList.add(localrqg);
    paramContext = rqa.a(paramContext);
    if (paramContext.LT())
    {
      paramContext.cv(localArrayList);
      return;
    }
    paramContext.cu(localArrayList);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, rpz paramrpz, ArrayList<rqg> paramArrayList)
  {
    if (rox.checkFileExist(paramString3)) {
      rox.deleteFile(paramString3);
    }
    rqg localrqg = new rqg();
    localrqg.cmdType = 17;
    localrqg.nL = new FFmpegUtils.22(paramString1, paramString2, paramString3, paramFloat1, paramFloat2);
    localrqg.d = new rqp(paramrpz, paramPublishVideoEntry);
    paramArrayList.add(localrqg);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, rpz paramrpz, ArrayList<rqg> paramArrayList)
  {
    if (rox.checkFileExist(paramString1)) {
      rox.deleteFile(paramString1);
    }
    rqg localrqg = new rqg();
    localrqg.cmdType = 19;
    localrqg.nL = new FFmpegUtils.16(paramString2, paramString1);
    localrqg.d = new rqm(paramrpz, paramPublishVideoEntry);
    paramArrayList.add(localrqg);
  }
  
  private static void a(PublishVideoEntry paramPublishVideoEntry, rpz paramrpz, String paramString1, int paramInt1, int paramInt2, String paramString2, ArrayList<rqg> paramArrayList)
  {
    if (rox.checkFileExist(paramString2)) {
      rox.deleteFile(paramString2);
    }
    rqg localrqg = new rqg();
    localrqg.cmdType = 3;
    localrqg.nL = new FFmpegUtils.12(paramString1, paramString2, paramInt1, paramInt2);
    localrqg.d = new rqk(paramrpz, paramPublishVideoEntry);
    paramArrayList.add(localrqg);
  }
  
  private static void a(String paramString1, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, rpz paramrpz, int paramInt, long paramLong, String paramString2, ArrayList<rqg> paramArrayList, String paramString3, String paramString4, String paramString5)
  {
    if (rox.checkFileExist(paramString1)) {
      rox.deleteFile(paramString1);
    }
    rqg localrqg = new rqg();
    localrqg.cmdType = 4;
    localrqg.nL = new FFmpegUtils.14(paramString5, paramString4, paramString1, paramBoolean, paramInt);
    localrqg.d = new rql(paramrpz, paramPublishVideoEntry, paramString2, paramString4, paramString5, paramString3, paramLong);
    paramArrayList.add(localrqg);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, rpz paramrpz)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    a(paramBoolean, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, false, paramrpz);
  }
  
  private static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean2, rpz paramrpz)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    long l = System.currentTimeMillis();
    Object localObject1 = gr(paramString2);
    Object localObject2 = new File(plr.atd);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(plr.atd);
    ((StringBuffer)localObject2).append(paramString2.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt1);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt2);
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject2 = new String((StringBuffer)localObject2);
    localObject1 = new ArrayList();
    rqg localrqg = new rqg();
    localrqg.cmdType = 3;
    localrqg.nL = new FFmpegUtils.6(paramString2, (String)localObject2, paramInt1, paramInt2);
    localrqg.d = new rqq(paramrpz);
    ((ArrayList)localObject1).add(localrqg);
    paramString2 = new rqg();
    paramString2.cmdType = 4;
    paramString2.nL = new FFmpegUtils.8(paramString1, (String)localObject2, paramString3, paramString4, paramBoolean2, paramInt2);
    paramString2.d = new rqr(paramrpz, (String)localObject2, l);
    ((ArrayList)localObject1).add(paramString2);
    if (paramBoolean1) {}
    for (paramContext = rqa.b(paramContext, true); paramContext.LT(); paramContext = rqa.a(paramContext, true))
    {
      paramContext.cv((ArrayList)localObject1);
      return;
    }
    paramContext.cu((ArrayList)localObject1);
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
        aqhu.saveBitmapToFile(localBitmap, new File(paramString));
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
    return rqx.a(paramProcess);
  }
  
  public static String ak(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder().append("QQStoryMoment").append(System.currentTimeMillis()).append("_").append(paramString1);
    if (paramString2 != null) {}
    for (;;)
    {
      return paramString2;
      paramString2 = ".mp4";
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, rpz paramrpz)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    a(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramString3, true, paramrpz);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    rqg localrqg = new rqg();
    localrqg.cmdType = 20;
    localrqg.nL = new FFmpegUtils.5(paramString1, paramString2, paramString3);
    localrqg.d = paramrqi;
    localArrayList.add(localrqg);
    paramContext = rqa.a(paramContext);
    if (paramContext.LT())
    {
      paramContext.cv(localArrayList);
      return;
    }
    paramContext.cu(localArrayList);
  }
  
  private static void b(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, rpz paramrpz, ArrayList<rqg> paramArrayList)
  {
    if (rox.checkFileExist(paramString2)) {
      rox.deleteFile(paramString2);
    }
    rqg localrqg = new rqg();
    localrqg.cmdType = 18;
    localrqg.nL = new FFmpegUtils.18(paramString1, paramString2);
    localrqg.d = new rqn(paramrpz, paramPublishVideoEntry);
    paramArrayList.add(localrqg);
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
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
    rqa.a(BaseApplicationImpl.getApplication()).a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public static void bvT()
  {
    rqa.a(BaseApplicationImpl.getApplication()).uf(false);
  }
  
  private static void c(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, rpz paramrpz, ArrayList<rqg> paramArrayList)
  {
    if (rox.checkFileExist(paramString2)) {
      rox.deleteFile(paramString2);
    }
    rqg localrqg = new rqg();
    localrqg.cmdType = 21;
    localrqg.nL = new FFmpegUtils.20(paramString1, paramString2);
    localrqg.d = new rqo(paramrpz, paramPublishVideoEntry);
    paramArrayList.add(localrqg);
  }
  
  public static String d(StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem == null) || (!paramStoryVideoItem.isPollVideo()))
    {
      ram.d("FFmpegUtils", "getVideoVoteWidgetPath find not-poll-video");
      return null;
    }
    return a(paramStoryVideoItem.getPollLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
  }
  
  public static Bitmap e(Bitmap paramBitmap1, Bitmap paramBitmap2)
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
  
  public static String e(StoryVideoItem paramStoryVideoItem)
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
      str = plr.atr;
      str = str + paramStoryVideoItem.mVid + "_max.png";
    } while ((!rox.fileExistsAndNotEmpty(str)) && (!g(paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.mAtImagePath, str)));
    return str;
  }
  
  public static boolean g(String paramString1, String paramString2, String paramString3)
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
  
  public static String gr(String paramString)
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
  
  public static class a
    implements rqi
  {
    public rqi f;
    public long mStartTime;
    
    public a(rqi paramrqi)
    {
      this.f = paramrqi;
    }
    
    public void onFailure(String paramString)
    {
      if (this.f != null) {
        this.f.onFailure(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video hflip video Error:" + paramString);
      }
    }
    
    public void onFinish(boolean paramBoolean) {}
    
    public void onProgress(String paramString) {}
    
    public void onStart()
    {
      this.mStartTime = SystemClock.uptimeMillis();
    }
    
    public void onSuccess(String paramString)
    {
      paramString = String.valueOf(SystemClock.uptimeMillis() - this.mStartTime);
      rar.a("play_video", "down_watermark_hfliptime", 0, 0, new String[] { paramString });
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "play_video down_watermark_hfliptime:" + paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqj
 * JD-Core Version:    0.7.0.1
 */