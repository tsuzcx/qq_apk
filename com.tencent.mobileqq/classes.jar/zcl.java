import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class zcl
  extends SimpleJob<zby>
  implements wjs
{
  protected long a;
  private final wke jdField_a_of_type_Wke;
  private final zby jdField_a_of_type_Zby;
  private long b;
  
  public zcl(zby paramzby)
  {
    super("DownloadAndUnZipJob");
    if (paramzby == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Wke = new wkf();
    this.jdField_a_of_type_Wke.a(this);
    this.jdField_a_of_type_Zby = paramzby;
  }
  
  protected zby a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Wke.a(this.jdField_a_of_type_Zby.e, zbz.a(this.jdField_a_of_type_Zby.a), 0L);
    return this.jdField_a_of_type_Zby;
  }
  
  public void a(String paramString, int paramInt)
  {
    zby localzby1 = this.jdField_a_of_type_Zby;
    if (paramInt == 0)
    {
      paramString = zbz.a(localzby1.a);
      String str = zbz.b(localzby1.a);
      yuk.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      yuk.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          zom.d(str);
          i = nof.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            yup.b("edit_video", "face_download_timecost", 0, 0, new String[] { localzby1.a, l1 - l2 + "" });
            yup.b("edit_video", "face_download_success", 0, 0, new String[] { localzby1.a });
            yuk.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localzby1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            wjj.a().dispatch(new zci(localzby1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          yuk.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        yuk.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        wjj.a().dispatch(new zci(localzby2, i, false, 0L, 0L));
        yup.b("edit_video", "face_download_success", 0, i, new String[] { localzby2.a });
      }
    }
    yuk.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    wjj.a().dispatch(new zci(localzby2, paramInt, true, 0L, 0L));
    yup.b("edit_video", "face_download_success", 0, paramInt, new String[] { localzby2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    zby localzby = this.jdField_a_of_type_Zby;
    if (!TextUtils.equals(localzby.e, paramString))
    {
      yuk.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localzby);
      yuk.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    yuk.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    wjj.a().dispatch(new zci(localzby, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    yuk.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcl
 * JD-Core Version:    0.7.0.1
 */