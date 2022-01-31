import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class uzl
  extends SimpleJob<uyy>
  implements sgr
{
  protected long a;
  private final shd jdField_a_of_type_Shd;
  private final uyy jdField_a_of_type_Uyy;
  private long b;
  
  public uzl(uyy paramuyy)
  {
    super("DownloadAndUnZipJob");
    if (paramuyy == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Shd = new she();
    this.jdField_a_of_type_Shd.a(this);
    this.jdField_a_of_type_Uyy = paramuyy;
  }
  
  protected uyy a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Shd.a(this.jdField_a_of_type_Uyy.e, uyz.a(this.jdField_a_of_type_Uyy.a), 0L);
    return this.jdField_a_of_type_Uyy;
  }
  
  public void a(String paramString, int paramInt)
  {
    uyy localuyy1 = this.jdField_a_of_type_Uyy;
    if (paramInt == 0)
    {
      paramString = uyz.a(localuyy1.a);
      String str = uyz.b(localuyy1.a);
      urk.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      urk.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          vlm.d(str);
          i = mpx.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            urp.b("edit_video", "face_download_timecost", 0, 0, new String[] { localuyy1.a, l1 - l2 + "" });
            urp.b("edit_video", "face_download_success", 0, 0, new String[] { localuyy1.a });
            urk.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localuyy1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            sgi.a().dispatch(new uzi(localuyy1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          urk.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        urk.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        sgi.a().dispatch(new uzi(localuyy2, i, false, 0L, 0L));
        urp.b("edit_video", "face_download_success", 0, i, new String[] { localuyy2.a });
      }
    }
    urk.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    sgi.a().dispatch(new uzi(localuyy2, paramInt, true, 0L, 0L));
    urp.b("edit_video", "face_download_success", 0, paramInt, new String[] { localuyy2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    uyy localuyy = this.jdField_a_of_type_Uyy;
    if (!TextUtils.equals(localuyy.e, paramString))
    {
      urk.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localuyy);
      urk.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    urk.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    sgi.a().dispatch(new uzi(localuyy, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    urk.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzl
 * JD-Core Version:    0.7.0.1
 */