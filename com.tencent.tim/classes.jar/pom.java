import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.1;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper.2;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pom
{
  public static String TAG = "Q.qqstory.publish.upload.VideoSaveToAlbumHelper";
  private int bjG;
  private ArrayList<rqg> mA = new ArrayList();
  private List<pom.b> mr = new ArrayList();
  
  public pom()
  {
    clearCache();
  }
  
  private void a(pom.b paramb)
  {
    ram.i(TAG, "generate ffmeng command start...");
    if (TextUtils.isEmpty(paramb.videoLocalPath))
    {
      ram.e(TAG, "generate failed. the video local path is null.");
      return;
    }
    if (rox.fileExistsAndNotEmpty(paramb.auc))
    {
      ram.d(TAG, "the video has existed in the album.");
      return;
    }
    pom.a locala = new pom.a(paramb);
    Object localObject2 = rpv.h(paramb.videoLocalPath);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new int[3];
      localObject1[0] = 0;
      localObject1[1] = paramb.videoWidth;
      localObject1[2] = paramb.videoHeight;
    }
    int j = localObject1[0];
    paramb.videoWidth = localObject1[1];
    paramb.videoHeight = localObject1[2];
    int i;
    String str1;
    String str2;
    if (paramb.aAZ)
    {
      i = 2;
      str1 = rqj.a(BaseApplication.getContext(), paramb.vid, paramb.videoWidth, paramb.videoHeight, i);
      if (TextUtils.isEmpty(str1)) {
        ram.e(TAG, "Client Error: generate water mark failed! May be this task is strange! %s", new Object[] { paramb });
      }
      localObject2 = paramb.aua;
      localObject1 = rqj.a(paramb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$b, paramb.videoWidth, paramb.videoHeight);
      str2 = rqj.a(paramb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a, paramb.videoWidth, paramb.videoHeight);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label306;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str2 = plr.atr;
        str2 = str2 + paramb.vid + System.currentTimeMillis() + "_new_mask.png";
        if (!rqj.g((String)localObject2, (String)localObject1, str2))
        {
          ram.e(TAG, "combineTwoImg mask and vote failed");
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
        ram.d(TAG, "have doodle image, should combine doodle image and logo image.");
        str2 = plr.ath + paramb.vid + "_newDownloadMask.mp4";
        localObject2 = localObject1;
        if (rqj.g((String)localObject1, str1, str2)) {
          localObject2 = str2;
        }
      }
    }
    for (;;)
    {
      paramb.aua = ((String)localObject2);
      localObject1 = plr.ath + "hflip" + paramb.vid + ".mp4";
      if ((j != 0) && (j != -1) && (!rox.fileExistsAndNotEmpty((String)localObject1)))
      {
        localObject2 = new rqg();
        ((rqg)localObject2).cmdType = 10;
        ((rqg)localObject2).nL = new VideoSaveToAlbumHelper.1(this, paramb, (String)localObject1);
        ((rqg)localObject2).d = new rqj.a(null);
        this.mA.add(localObject2);
        ram.i(TAG, "add a hflip command to command list.");
      }
      localObject2 = new rqg();
      ((rqg)localObject2).cmdType = 1;
      ((rqg)localObject2).nL = new VideoSaveToAlbumHelper.2(this, paramb, j, (String)localObject1);
      ((rqg)localObject2).d = locala;
      this.mA.add(localObject2);
      ram.i(TAG, "add a watermask command to command list.");
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
  
  private void clearCache()
  {
    rox.delete(mm(), false);
    rox.delete(mo(), false);
    rox.delete(mn(), false);
    this.mr.clear();
    this.mA.clear();
  }
  
  private String mm()
  {
    return plr.ato;
  }
  
  private String mn()
  {
    return plr.atq;
  }
  
  private String mo()
  {
    return plr.atp;
  }
  
  public boolean O(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    ram.d(TAG, "start coping file to temp directory. fromPath = %s. toPath = %s.", paramString1, paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ram.e(TAG, "fromPath or toPath is null.");
      return false;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      ram.e(TAG, "src file is not exist.");
      return false;
    }
    boolean bool1 = bool2;
    try
    {
      paramString2 = rox.createFile(paramString2);
      bool1 = bool2;
      long l = SystemClock.elapsedRealtime();
      bool1 = bool2;
      bool2 = rox.copyFile(paramString1, paramString2);
      bool1 = bool2;
      ram.d(TAG, "copy file to temp directory cost %d ms.", Long.valueOf(SystemClock.elapsedRealtime() - l));
      return bool2;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return bool1;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, StoryVideoItem.b paramb, StoryVideoItem.a parama)
  {
    paramString1 = new pom.b(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean);
    paramString1.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$b = paramb;
    paramString1.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a = parama;
    this.mr.add(paramString1);
  }
  
  public void bmb()
  {
    ram.i(TAG, "trigger to execute all tasks in the task list.");
    if (this.mr.size() < 1)
    {
      ram.e(TAG, "no task need to be execute.");
      return;
    }
    Object localObject = this.mr.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((pom.b)((Iterator)localObject).next());
    }
    localObject = rqa.a(BaseApplication.getContext(), true);
    String str = ((pom.b)this.mr.get(0)).auc;
    if (((rqa)localObject).LT())
    {
      if (((rqa)localObject).fF(str))
      {
        ram.w(TAG, "this task is already running.");
        return;
      }
      ram.e(TAG, "a download task is running. let's return.");
      return;
    }
    this.bjG = this.mA.size();
    try
    {
      ((rqa)localObject).sH(str);
      ((rqa)localObject).cu(this.mA);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      ram.e(TAG, "error occured during executing ffmeng commands. error message is : %s.", new Object[] { localException.getMessage() });
    }
  }
  
  public String fP(@NonNull String paramString)
  {
    return mm() + paramString + ".mp4";
  }
  
  public boolean fa(String paramString)
  {
    Object localObject = pog.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      if ((localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC) && (localPublishVideoEntry.videoProcessState != PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        ram.b(TAG, "waiting other fragments composited. group id is %s.", paramString);
        return false;
      }
    }
    ram.b(TAG, "all fragments are composited. group id is %s.", paramString);
    return true;
  }
  
  public boolean fb(String paramString)
  {
    paramString = pog.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
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
      ram.b(TAG, "composite failed count is %d.", Integer.valueOf(i));
      if (i != 1) {
        break;
      }
      return true;
    }
  }
  
  public class a
    implements rqi
  {
    private pom.b a;
    
    public a(pom.b paramb)
    {
      this.a = paramb;
    }
    
    public void onFailure(String paramString)
    {
      ram.e(pom.TAG, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
    }
    
    public void onFinish(boolean paramBoolean)
    {
      pom.a(pom.this);
      if (pom.b(pom.this) == 0)
      {
        ram.d(pom.TAG, "all ffmpeg commands have already finished. start clearing cache.");
        pom.a(pom.this);
      }
    }
    
    public void onProgress(String paramString) {}
    
    public void onStart()
    {
      ram.d(pom.TAG, "start executing ffmpeg commands.");
    }
    
    public void onSuccess(String paramString)
    {
      if (rox.saveVideoToAlbum(BaseApplication.getContext(), this.a.aub, this.a.auc))
      {
        ram.d(pom.TAG, "save video to album success.");
        rar.a("video_edit", "video_save_local", 0, 0, new String[0]);
        return;
      }
      ram.e(pom.TAG, "save video to album failed.");
    }
  }
  
  public static class b
  {
    StoryVideoItem.a jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$a;
    StoryVideoItem.b jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$b;
    boolean aAZ;
    public String aua;
    public String aub;
    public String auc;
    String vid;
    public int videoHeight;
    public String videoLocalPath;
    public int videoWidth;
    
    public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.vid = paramString1;
      this.videoLocalPath = paramString2;
      this.aua = paramString3;
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      this.aAZ = paramBoolean;
      this.aub = (plr.atq + paramString1 + ".mp4");
      this.auc = qem.k(paramString1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pom
 * JD-Core Version:    0.7.0.1
 */