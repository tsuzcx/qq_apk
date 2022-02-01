import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class ysm
  extends SimpleJob<yrz>
  implements wam
{
  protected long a;
  private final way jdField_a_of_type_Way;
  private final yrz jdField_a_of_type_Yrz;
  private long b;
  
  public ysm(yrz paramyrz)
  {
    super("DownloadAndUnZipJob");
    if (paramyrz == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Way = new waz();
    this.jdField_a_of_type_Way.a(this);
    this.jdField_a_of_type_Yrz = paramyrz;
  }
  
  protected yrz a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Way.a(this.jdField_a_of_type_Yrz.e, ysa.a(this.jdField_a_of_type_Yrz.a), 0L);
    return this.jdField_a_of_type_Yrz;
  }
  
  public void a(String paramString, int paramInt)
  {
    yrz localyrz1 = this.jdField_a_of_type_Yrz;
    if (paramInt == 0)
    {
      paramString = ysa.a(localyrz1.a);
      String str = ysa.b(localyrz1.a);
      ykq.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      ykq.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          zeb.d(str);
          i = nwp.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            ykv.b("edit_video", "face_download_timecost", 0, 0, new String[] { localyrz1.a, l1 - l2 + "" });
            ykv.b("edit_video", "face_download_success", 0, 0, new String[] { localyrz1.a });
            ykq.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localyrz1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            wad.a().dispatch(new ysj(localyrz1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          ykq.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        ykq.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        wad.a().dispatch(new ysj(localyrz2, i, false, 0L, 0L));
        ykv.b("edit_video", "face_download_success", 0, i, new String[] { localyrz2.a });
      }
    }
    ykq.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    wad.a().dispatch(new ysj(localyrz2, paramInt, true, 0L, 0L));
    ykv.b("edit_video", "face_download_success", 0, paramInt, new String[] { localyrz2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    yrz localyrz = this.jdField_a_of_type_Yrz;
    if (!TextUtils.equals(localyrz.e, paramString))
    {
      ykq.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localyrz);
      ykq.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    ykq.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    wad.a().dispatch(new ysj(localyrz, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    ykq.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysm
 * JD-Core Version:    0.7.0.1
 */