import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;

class vmh
  extends SimpleJob<vlu>
  implements stn
{
  protected long a;
  private final stz jdField_a_of_type_Stz;
  private final vlu jdField_a_of_type_Vlu;
  private long b;
  
  public vmh(vlu paramvlu)
  {
    super("DownloadAndUnZipJob");
    if (paramvlu == null) {
      throw new IllegalArgumentException("doodleEmojiItem should not be null");
    }
    this.jdField_a_of_type_Stz = new sua();
    this.jdField_a_of_type_Stz.a(this);
    this.jdField_a_of_type_Vlu = paramvlu;
  }
  
  protected vlu a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_Stz.a(this.jdField_a_of_type_Vlu.e, vlv.a(this.jdField_a_of_type_Vlu.a), 0L);
    return this.jdField_a_of_type_Vlu;
  }
  
  public void a(String paramString, int paramInt)
  {
    vlu localvlu1 = this.jdField_a_of_type_Vlu;
    if (paramInt == 0)
    {
      paramString = vlv.a(localvlu1.a);
      String str = vlv.b(localvlu1.a);
      veg.b("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
      veg.b("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
      for (;;)
      {
        int i;
        try
        {
          vyi.d(str);
          i = nay.a(paramString, str);
          if (i == 0)
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            vel.b("edit_video", "face_download_timecost", 0, 0, new String[] { localvlu1.a, l1 - l2 + "" });
            vel.b("edit_video", "face_download_success", 0, 0, new String[] { localvlu1.a });
            veg.c("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
            localvlu1.a(str);
            new File(str).setLastModified(System.currentTimeMillis());
            ste.a().dispatch(new vme(localvlu1, paramInt, true, 0L, 0L));
            return;
          }
        }
        catch (Exception localException)
        {
          veg.d("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
          continue;
        }
        finally
        {
          new File(paramString).delete();
        }
        veg.d("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
        ste.a().dispatch(new vme(localvlu2, i, false, 0L, 0L));
        vel.b("edit_video", "face_download_success", 0, i, new String[] { localvlu2.a });
      }
    }
    veg.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
    ste.a().dispatch(new vme(localvlu2, paramInt, true, 0L, 0L));
    vel.b("edit_video", "face_download_success", 0, paramInt, new String[] { localvlu2.a });
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    vlu localvlu = this.jdField_a_of_type_Vlu;
    if (!TextUtils.equals(localvlu.e, paramString))
    {
      veg.d("DoodleEmojiManager", "DownloadListener onProgress error : " + localvlu);
      veg.d("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
    }
    while (paramLong1 <= paramLong2 / 10L + this.b) {
      return;
    }
    veg.a("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
    ste.a().dispatch(new vme(localvlu, 0, false, paramLong2, paramLong1));
    this.b = paramLong1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    veg.b("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmh
 * JD-Core Version:    0.7.0.1
 */