import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.1;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.2;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class upq
{
  public static String a;
  private int jdField_a_of_type_Int;
  private ArrayList<xti> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<ups> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.VideoSaveToAlbumHelper";
  }
  
  public upq()
  {
    b();
  }
  
  private String a()
  {
    return ulg.r;
  }
  
  private void a(ups paramups)
  {
    wxe.c(jdField_a_of_type_JavaLangString, "generate ffmeng command start...");
    if (TextUtils.isEmpty(paramups.jdField_b_of_type_JavaLangString))
    {
      wxe.e(jdField_a_of_type_JavaLangString, "generate failed. the video local path is null.");
      return;
    }
    if (xrg.c(paramups.e))
    {
      wxe.b(jdField_a_of_type_JavaLangString, "the video has existed in the album.");
      return;
    }
    upr localupr = new upr(this, paramups);
    Object localObject2 = xsv.a(paramups.jdField_b_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new int[3];
      localObject1[0] = 0;
      localObject1[1] = paramups.jdField_a_of_type_Int;
      localObject1[2] = paramups.jdField_b_of_type_Int;
    }
    int j = localObject1[0];
    paramups.jdField_a_of_type_Int = localObject1[1];
    paramups.jdField_b_of_type_Int = localObject1[2];
    int i;
    String str1;
    String str2;
    if (paramups.jdField_a_of_type_Boolean)
    {
      i = 2;
      str1 = xtl.a(BaseApplication.getContext(), paramups.jdField_a_of_type_JavaLangString, paramups.jdField_a_of_type_Int, paramups.jdField_b_of_type_Int, i);
      if (TextUtils.isEmpty(str1)) {
        wxe.e(jdField_a_of_type_JavaLangString, "Client Error: generate water mark failed! May be this task is strange! %s", new Object[] { paramups });
      }
      localObject2 = paramups.c;
      localObject1 = xtl.a(paramups.jdField_a_of_type_Uxk, paramups.jdField_a_of_type_Int, paramups.jdField_b_of_type_Int);
      str2 = xtl.a(paramups.jdField_a_of_type_Uxj, paramups.jdField_a_of_type_Int, paramups.jdField_b_of_type_Int);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label306;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str2 = ulg.u;
        str2 = str2 + paramups.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + "_new_mask.png";
        if (!xtl.a((String)localObject2, (String)localObject1, str2))
        {
          wxe.e(jdField_a_of_type_JavaLangString, "combineTwoImg mask and vote failed");
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
        wxe.b(jdField_a_of_type_JavaLangString, "have doodle image, should combine doodle image and logo image.");
        str2 = ulg.k + paramups.jdField_a_of_type_JavaLangString + "_newDownloadMask.mp4";
        localObject2 = localObject1;
        if (xtl.a((String)localObject1, str1, str2)) {
          localObject2 = str2;
        }
      }
    }
    for (;;)
    {
      paramups.c = ((String)localObject2);
      localObject1 = ulg.k + "hflip" + paramups.jdField_a_of_type_JavaLangString + ".mp4";
      if ((j != 0) && (j != -1) && (!xrg.c((String)localObject1)))
      {
        localObject2 = new xti();
        ((xti)localObject2).jdField_a_of_type_Int = 10;
        ((xti)localObject2).jdField_a_of_type_JavaUtilArrayList = new VideoSaveToAlbumHelper.1(this, paramups, (String)localObject1);
        ((xti)localObject2).jdField_a_of_type_Xtk = new xtu(null);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        wxe.c(jdField_a_of_type_JavaLangString, "add a hflip command to command list.");
      }
      localObject2 = new xti();
      ((xti)localObject2).jdField_a_of_type_Int = 1;
      ((xti)localObject2).jdField_a_of_type_JavaUtilArrayList = new VideoSaveToAlbumHelper.2(this, paramups, j, (String)localObject1);
      ((xti)localObject2).jdField_a_of_type_Xtk = localupr;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      wxe.c(jdField_a_of_type_JavaLangString, "add a watermask command to command list.");
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
    return ulg.t;
  }
  
  private void b()
  {
    xrg.a(a(), false);
    xrg.a(c(), false);
    xrg.a(b(), false);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private String c()
  {
    return ulg.s;
  }
  
  public String a(@NonNull String paramString)
  {
    return a() + paramString + ".mp4";
  }
  
  public void a()
  {
    wxe.c(jdField_a_of_type_JavaLangString, "trigger to execute all tasks in the task list.");
    if (this.jdField_a_of_type_JavaUtilList.size() < 1)
    {
      wxe.e(jdField_a_of_type_JavaLangString, "no task need to be execute.");
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((ups)((Iterator)localObject).next());
    }
    localObject = xtc.a(BaseApplication.getContext(), true);
    String str = ((ups)this.jdField_a_of_type_JavaUtilList.get(0)).e;
    if (((xtc)localObject).a())
    {
      if (((xtc)localObject).a(str))
      {
        wxe.d(jdField_a_of_type_JavaLangString, "this task is already running.");
        return;
      }
      wxe.e(jdField_a_of_type_JavaLangString, "a download task is running. let's return.");
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    try
    {
      ((xtc)localObject).a(str);
      ((xtc)localObject).a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      wxe.e(jdField_a_of_type_JavaLangString, "error occured during executing ffmeng commands. error message is : %s.", new Object[] { localException.getMessage() });
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, uxk paramuxk, uxj paramuxj)
  {
    paramString1 = new ups(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean);
    paramString1.jdField_a_of_type_Uxk = paramuxk;
    paramString1.jdField_a_of_type_Uxj = paramuxj;
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
  }
  
  public boolean a(String paramString)
  {
    Object localObject = upd.a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      if ((localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        wxe.a(jdField_a_of_type_JavaLangString, "waiting other fragments composited. group id is %s.", paramString);
        return false;
      }
    }
    wxe.a(jdField_a_of_type_JavaLangString, "all fragments are composited. group id is %s.", paramString);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    wxe.b(jdField_a_of_type_JavaLangString, "start coping file to temp directory. fromPath = %s. toPath = %s.", paramString1, paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      wxe.e(jdField_a_of_type_JavaLangString, "fromPath or toPath is null.");
      return false;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      wxe.e(jdField_a_of_type_JavaLangString, "src file is not exist.");
      return false;
    }
    boolean bool1 = bool2;
    try
    {
      paramString2 = xrg.a(paramString2);
      bool1 = bool2;
      long l = SystemClock.elapsedRealtime();
      bool1 = bool2;
      bool2 = xrg.a(paramString1, paramString2);
      bool1 = bool2;
      wxe.b(jdField_a_of_type_JavaLangString, "copy file to temp directory cost %d ms.", Long.valueOf(SystemClock.elapsedRealtime() - l));
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
    paramString = upd.a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
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
      wxe.a(jdField_a_of_type_JavaLangString, "composite failed count is %d.", Integer.valueOf(i));
      if (i != 1) {
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upq
 * JD-Core Version:    0.7.0.1
 */