import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class ydt
  extends SimpleJob<ydg>
  implements vlr
{
  protected long a;
  private final vmd jdField_a_of_type_Vmd;
  private final ydg jdField_a_of_type_Ydg;
  private long b;
  
  public ydt(ydg paramydg)
  {
    super("DownloadAndUnZipJob");
    if (paramydg == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Vmd = new vme();
    this.jdField_a_of_type_Vmd.a(this);
    this.jdField_a_of_type_Ydg = paramydg;
  }
  
  protected ydg a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Vmd.a(this.jdField_a_of_type_Ydg.e, ydh.a(this.jdField_a_of_type_Ydg.a), 0L);
    return this.jdField_a_of_type_Ydg;
  }
  
  public void a(String paramString, int paramInt)
  {
    ydg localydg1 = this.jdField_a_of_type_Ydg;
    if (paramInt == 0)
    {
      paramString = ydh.a(localydg1.a);
      String str = ydh.b(localydg1.a);
      xvv.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      xvv.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          ypi.d(str);
          i = npo.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            xwa.b("edit_video", "face_download_timecost", 0, 0, new String[] { localydg1.a, l1 - l2 + "" });
            xwa.b("edit_video", "face_download_success", 0, 0, new String[] { localydg1.a });
            xvv.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localydg1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            vli.a().dispatch(new ydq(localydg1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          xvv.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        xvv.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        vli.a().dispatch(new ydq(localydg2, i, false, 0L, 0L));
        xwa.b("edit_video", "face_download_success", 0, i, new String[] { localydg2.a });
      }
    }
    xvv.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    vli.a().dispatch(new ydq(localydg2, paramInt, true, 0L, 0L));
    xwa.b("edit_video", "face_download_success", 0, paramInt, new String[] { localydg2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    ydg localydg = this.jdField_a_of_type_Ydg;
    if (!TextUtils.equals(localydg.e, paramString))
    {
      xvv.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localydg);
      xvv.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    xvv.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    vli.a().dispatch(new ydq(localydg, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    xvv.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydt
 * JD-Core Version:    0.7.0.1
 */