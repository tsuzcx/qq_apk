import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class vme
  extends SimpleJob<vlr>
  implements stk
{
  protected long a;
  private final stw jdField_a_of_type_Stw;
  private final vlr jdField_a_of_type_Vlr;
  private long b;
  
  public vme(vlr paramvlr)
  {
    super("DownloadAndUnZipJob");
    if (paramvlr == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Stw = new stx();
    this.jdField_a_of_type_Stw.a(this);
    this.jdField_a_of_type_Vlr = paramvlr;
  }
  
  protected vlr a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Stw.a(this.jdField_a_of_type_Vlr.e, vls.a(this.jdField_a_of_type_Vlr.a), 0L);
    return this.jdField_a_of_type_Vlr;
  }
  
  public void a(String paramString, int paramInt)
  {
    vlr localvlr1 = this.jdField_a_of_type_Vlr;
    if (paramInt == 0)
    {
      paramString = vls.a(localvlr1.a);
      String str = vls.b(localvlr1.a);
      ved.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      ved.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          vyf.d(str);
          i = nav.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            vei.b("edit_video", "face_download_timecost", 0, 0, new String[] { localvlr1.a, l1 - l2 + "" });
            vei.b("edit_video", "face_download_success", 0, 0, new String[] { localvlr1.a });
            ved.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localvlr1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            stb.a().dispatch(new vmb(localvlr1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          ved.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        ved.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        stb.a().dispatch(new vmb(localvlr2, i, false, 0L, 0L));
        vei.b("edit_video", "face_download_success", 0, i, new String[] { localvlr2.a });
      }
    }
    ved.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    stb.a().dispatch(new vmb(localvlr2, paramInt, true, 0L, 0L));
    vei.b("edit_video", "face_download_success", 0, paramInt, new String[] { localvlr2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    vlr localvlr = this.jdField_a_of_type_Vlr;
    if (!TextUtils.equals(localvlr.e, paramString))
    {
      ved.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localvlr);
      ved.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    ved.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    stb.a().dispatch(new vmb(localvlr, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    ved.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vme
 * JD-Core Version:    0.7.0.1
 */