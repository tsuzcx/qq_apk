import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.1;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.2;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExecuteFhlipResponseCallback;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wdj
{
  public static String a;
  private int jdField_a_of_type_Int;
  private ArrayList<FFmpegCommandUnit> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<wdl> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.VideoSaveToAlbumHelper";
  }
  
  public wdj()
  {
    b();
  }
  
  private String a()
  {
    return vzh.r;
  }
  
  private void a(wdl paramwdl)
  {
    ykq.c(jdField_a_of_type_JavaLangString, "generate ffmeng command start...");
    if (TextUtils.isEmpty(paramwdl.jdField_b_of_type_JavaLangString))
    {
      ykq.e(jdField_a_of_type_JavaLangString, "generate failed. the video local path is null.");
      return;
    }
    if (zeb.c(paramwdl.e))
    {
      ykq.b(jdField_a_of_type_JavaLangString, "the video has existed in the album.");
      return;
    }
    wdk localwdk = new wdk(this, paramwdl);
    Object localObject2 = zfl.a(paramwdl.jdField_b_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new int[3];
      localObject1[0] = 0;
      localObject1[1] = paramwdl.jdField_a_of_type_Int;
      localObject1[2] = paramwdl.jdField_b_of_type_Int;
    }
    int j = localObject1[0];
    paramwdl.jdField_a_of_type_Int = localObject1[1];
    paramwdl.jdField_b_of_type_Int = localObject1[2];
    int i;
    String str1;
    String str2;
    if (paramwdl.jdField_a_of_type_Boolean)
    {
      i = 2;
      str1 = FFmpegUtils.getVideoDownloadWatermarkPath(BaseApplication.getContext(), paramwdl.jdField_a_of_type_JavaLangString, paramwdl.jdField_a_of_type_Int, paramwdl.jdField_b_of_type_Int, i);
      if (TextUtils.isEmpty(str1)) {
        ykq.e(jdField_a_of_type_JavaLangString, "Client Error: generate water mark failed! May be this task is strange! %s", new Object[] { paramwdl });
      }
      localObject2 = paramwdl.c;
      localObject1 = FFmpegUtils.generateVideoVoteWidgetImage(paramwdl.jdField_a_of_type_Wlc, paramwdl.jdField_a_of_type_Int, paramwdl.jdField_b_of_type_Int);
      str2 = FFmpegUtils.generateInteractWidgetImage(paramwdl.jdField_a_of_type_Wlb, paramwdl.jdField_a_of_type_Int, paramwdl.jdField_b_of_type_Int);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label306;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str2 = vzh.u;
        str2 = str2 + paramwdl.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + "_new_mask.png";
        if (!FFmpegUtils.combineTwoImg((String)localObject2, (String)localObject1, str2))
        {
          ykq.e(jdField_a_of_type_JavaLangString, "combineTwoImg mask and vote failed");
          return;
          i = 1;
          break;
          label306:
          localObject1 = str2;
          continue;
        }
        localObject1 = str2;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1))) {
          break label585;
        }
        ykq.b(jdField_a_of_type_JavaLangString, "have doodle image, should combine doodle image and logo image.");
        str2 = vzh.k + paramwdl.jdField_a_of_type_JavaLangString + "_newDownloadMask.mp4";
        localObject2 = localObject1;
        if (FFmpegUtils.combineTwoImg((String)localObject1, str1, str2)) {
          localObject2 = str2;
        }
      }
    }
    for (;;)
    {
      paramwdl.c = ((String)localObject2);
      localObject1 = vzh.k + "hflip" + paramwdl.jdField_a_of_type_JavaLangString + ".mp4";
      if ((j != 0) && (j != -1) && (!zeb.c((String)localObject1)))
      {
        localObject2 = new FFmpegCommandUnit();
        ((FFmpegCommandUnit)localObject2).cmdType = 10;
        ((FFmpegCommandUnit)localObject2).arguments = new VideoSaveToAlbumHelper.1(this, paramwdl, (String)localObject1);
        ((FFmpegCommandUnit)localObject2).callback = new FFmpegUtils.ExecuteFhlipResponseCallback(null);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ykq.c(jdField_a_of_type_JavaLangString, "add a hflip command to command list.");
      }
      localObject2 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject2).cmdType = 1;
      ((FFmpegCommandUnit)localObject2).arguments = new VideoSaveToAlbumHelper.2(this, paramwdl, j, (String)localObject1);
      ((FFmpegCommandUnit)localObject2).callback = localwdk;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      ykq.c(jdField_a_of_type_JavaLangString, "add a watermask command to command list.");
      return;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      break;
      label585:
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str1;
      }
    }
  }
  
  private String b()
  {
    return vzh.t;
  }
  
  private void b()
  {
    zeb.a(a(), false);
    zeb.a(c(), false);
    zeb.a(b(), false);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private String c()
  {
    return vzh.s;
  }
  
  public String a(@NonNull String paramString)
  {
    return a() + paramString + ".mp4";
  }
  
  public void a()
  {
    ykq.c(jdField_a_of_type_JavaLangString, "trigger to execute all tasks in the task list.");
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      ykq.e(jdField_a_of_type_JavaLangString, "no task need to be execute.");
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((wdl)((Iterator)localObject).next());
    }
    localObject = FFmpeg.getInstance(BaseApplication.getContext(), true);
    String str = ((wdl)this.jdField_a_of_type_JavaUtilList.get(0)).e;
    if (((FFmpeg)localObject).isFFmpegCommandRunning())
    {
      if (((FFmpeg)localObject).checkSameTask(str))
      {
        ykq.d(jdField_a_of_type_JavaLangString, "this task is already running.");
        return;
      }
      ykq.e(jdField_a_of_type_JavaLangString, "a download task is running. let's return.");
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    try
    {
      ((FFmpeg)localObject).setCurrentTaskUni(str);
      ((FFmpeg)localObject).cmdFFmpegQueue(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      ykq.e(jdField_a_of_type_JavaLangString, "error occured during executing ffmeng commands. error message is : %s.", new Object[] { localException.getMessage() });
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, wlc paramwlc, wlb paramwlb)
  {
    paramString1 = new wdl(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean);
    paramString1.jdField_a_of_type_Wlc = paramwlc;
    paramString1.jdField_a_of_type_Wlb = paramwlb;
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
  }
  
  public boolean a(String paramString)
  {
    Object localObject = VideoCompositeHelper.query(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      if ((localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        ykq.a(jdField_a_of_type_JavaLangString, "waiting other fragments composited. group id is %s.", paramString);
        return false;
      }
    }
    ykq.a(jdField_a_of_type_JavaLangString, "all fragments are composited. group id is %s.", paramString);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    ykq.b(jdField_a_of_type_JavaLangString, "start coping file to temp directory. fromPath = %s. toPath = %s.", paramString1, paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ykq.e(jdField_a_of_type_JavaLangString, "fromPath or toPath is null.");
      return false;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      ykq.e(jdField_a_of_type_JavaLangString, "src file is not exist.");
      return false;
    }
    boolean bool1 = bool2;
    try
    {
      paramString2 = zeb.a(paramString2);
      bool1 = bool2;
      long l = SystemClock.elapsedRealtime();
      bool1 = bool2;
      bool2 = zeb.a(paramString1, paramString2);
      bool1 = bool2;
      ykq.b(jdField_a_of_type_JavaLangString, "copy file to temp directory cost %d ms.", Long.valueOf(SystemClock.elapsedRealtime() - l));
      return bool2;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return bool1;
  }
  
  public boolean b(String paramString)
  {
    paramString = VideoCompositeHelper.query(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (paramString == null) {
      return false;
    }
    paramString = paramString.iterator();
    int i = 0;
    label48:
    if (paramString.hasNext())
    {
      if (((PublishVideoEntry)paramString.next()).videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) {
        break label102;
      }
      i += 1;
    }
    label102:
    for (;;)
    {
      break label48;
      ykq.a(jdField_a_of_type_JavaLangString, "composite failed count is %d.", Integer.valueOf(i));
      if (i != 1) {
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdj
 * JD-Core Version:    0.7.0.1
 */