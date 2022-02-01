import android.content.Context;
import java.io.File;

final class awrf
  implements awqd.b
{
  awrf(String paramString1, String paramString2, awre.a parama, Context paramContext, File paramFile1, File paramFile2) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if (paramBoolean) {
      awqd.a().a(awre.access$000(), this.cSi, "SoHelper", new awrg(this));
    }
    while (this.a == null) {
      return;
    }
    this.a.IY(paramString3);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.a != null) {
      this.a.d(paramLong, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrf
 * JD-Core Version:    0.7.0.1
 */