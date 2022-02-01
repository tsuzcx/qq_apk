import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class yyq
  extends SimpleJob<yyd>
  implements wfx
{
  protected long a;
  private final wgj jdField_a_of_type_Wgj;
  private final yyd jdField_a_of_type_Yyd;
  private long b;
  
  public yyq(yyd paramyyd)
  {
    super("DownloadAndUnZipJob");
    if (paramyyd == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Wgj = new wgk();
    this.jdField_a_of_type_Wgj.a(this);
    this.jdField_a_of_type_Yyd = paramyyd;
  }
  
  protected yyd a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Wgj.a(this.jdField_a_of_type_Yyd.e, yye.a(this.jdField_a_of_type_Yyd.a), 0L);
    return this.jdField_a_of_type_Yyd;
  }
  
  public void a(String paramString, int paramInt)
  {
    yyd localyyd1 = this.jdField_a_of_type_Yyd;
    if (paramInt == 0)
    {
      paramString = yye.a(localyyd1.a);
      String str = yye.b(localyyd1.a);
      yqp.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      yqp.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          zkr.d(str);
          i = nmk.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            yqu.b("edit_video", "face_download_timecost", 0, 0, new String[] { localyyd1.a, l1 - l2 + "" });
            yqu.b("edit_video", "face_download_success", 0, 0, new String[] { localyyd1.a });
            yqp.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localyyd1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            wfo.a().dispatch(new yyn(localyyd1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          yqp.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        yqp.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        wfo.a().dispatch(new yyn(localyyd2, i, false, 0L, 0L));
        yqu.b("edit_video", "face_download_success", 0, i, new String[] { localyyd2.a });
      }
    }
    yqp.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    wfo.a().dispatch(new yyn(localyyd2, paramInt, true, 0L, 0L));
    yqu.b("edit_video", "face_download_success", 0, paramInt, new String[] { localyyd2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    yyd localyyd = this.jdField_a_of_type_Yyd;
    if (!TextUtils.equals(localyyd.e, paramString))
    {
      yqp.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localyyd);
      yqp.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    yqp.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    wfo.a().dispatch(new yyn(localyyd, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    yqp.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyq
 * JD-Core Version:    0.7.0.1
 */