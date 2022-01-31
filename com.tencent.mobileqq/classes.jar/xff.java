import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class xff
  extends SimpleJob<xes>
  implements uml
{
  protected long a;
  private final umx jdField_a_of_type_Umx;
  private final xes jdField_a_of_type_Xes;
  private long b;
  
  public xff(xes paramxes)
  {
    super("DownloadAndUnZipJob");
    if (paramxes == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Umx = new umy();
    this.jdField_a_of_type_Umx.a(this);
    this.jdField_a_of_type_Xes = paramxes;
  }
  
  protected xes a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Umx.a(this.jdField_a_of_type_Xes.e, xet.a(this.jdField_a_of_type_Xes.a), 0L);
    return this.jdField_a_of_type_Xes;
  }
  
  public void a(String paramString, int paramInt)
  {
    xes localxes1 = this.jdField_a_of_type_Xes;
    if (paramInt == 0)
    {
      paramString = xet.a(localxes1.a);
      String str = xet.b(localxes1.a);
      wxe.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      wxe.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          xrg.d(str);
          i = ndr.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            wxj.b("edit_video", "face_download_timecost", 0, 0, new String[] { localxes1.a, l1 - l2 + "" });
            wxj.b("edit_video", "face_download_success", 0, 0, new String[] { localxes1.a });
            wxe.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localxes1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            umc.a().dispatch(new xfc(localxes1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          wxe.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        wxe.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        umc.a().dispatch(new xfc(localxes2, i, false, 0L, 0L));
        wxj.b("edit_video", "face_download_success", 0, i, new String[] { localxes2.a });
      }
    }
    wxe.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    umc.a().dispatch(new xfc(localxes2, paramInt, true, 0L, 0L));
    wxj.b("edit_video", "face_download_success", 0, paramInt, new String[] { localxes2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    xes localxes = this.jdField_a_of_type_Xes;
    if (!TextUtils.equals(localxes.e, paramString))
    {
      wxe.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localxes);
      wxe.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    wxe.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    umc.a().dispatch(new xfc(localxes, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    wxe.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xff
 * JD-Core Version:    0.7.0.1
 */