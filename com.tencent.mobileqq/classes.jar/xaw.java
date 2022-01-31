import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class xaw
  extends SimpleJob<xaj>
  implements uic
{
  protected long a;
  private final uio jdField_a_of_type_Uio;
  private final xaj jdField_a_of_type_Xaj;
  private long b;
  
  public xaw(xaj paramxaj)
  {
    super("DownloadAndUnZipJob");
    if (paramxaj == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Uio = new uip();
    this.jdField_a_of_type_Uio.a(this);
    this.jdField_a_of_type_Xaj = paramxaj;
  }
  
  protected xaj a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Uio.a(this.jdField_a_of_type_Xaj.e, xak.a(this.jdField_a_of_type_Xaj.a), 0L);
    return this.jdField_a_of_type_Xaj;
  }
  
  public void a(String paramString, int paramInt)
  {
    xaj localxaj1 = this.jdField_a_of_type_Xaj;
    if (paramInt == 0)
    {
      paramString = xak.a(localxaj1.a);
      String str = xak.b(localxaj1.a);
      wsv.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      wsv.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          xmx.d(str);
          i = ndr.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            wta.b("edit_video", "face_download_timecost", 0, 0, new String[] { localxaj1.a, l1 - l2 + "" });
            wta.b("edit_video", "face_download_success", 0, 0, new String[] { localxaj1.a });
            wsv.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localxaj1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            uht.a().dispatch(new xat(localxaj1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          wsv.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        wsv.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        uht.a().dispatch(new xat(localxaj2, i, false, 0L, 0L));
        wta.b("edit_video", "face_download_success", 0, i, new String[] { localxaj2.a });
      }
    }
    wsv.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    uht.a().dispatch(new xat(localxaj2, paramInt, true, 0L, 0L));
    wta.b("edit_video", "face_download_success", 0, paramInt, new String[] { localxaj2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    xaj localxaj = this.jdField_a_of_type_Xaj;
    if (!TextUtils.equals(localxaj.e, paramString))
    {
      wsv.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localxaj);
      wsv.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    wsv.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    uht.a().dispatch(new xat(localxaj, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    wsv.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xaw
 * JD-Core Version:    0.7.0.1
 */