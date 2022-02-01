import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class awqh
  implements awqd.b
{
  awqh(awqd paramawqd, awqd.c paramc, int paramInt) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    awqb.a locala;
    for (int i = 1;; i = 0)
    {
      locala = new awqb.a();
      locala.filePath = paramString2;
      locala.fileId = paramString1;
      locala.errorCode = paramInt;
      locala.errorMsg = paramString3;
      if (i == 0) {
        break;
      }
      locala.state = 4;
      this.d.a(paramString1, this.eCn, locala, true);
      return;
    }
    locala.state = 5;
    this.d.a(paramString1, this.eCn, locala, true);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    awqb.a locala = new awqb.a();
    locala.fileId = paramString;
    locala.state = 2;
    locala.currSize = (paramFloat);
    locala.totalSize = paramLong;
    this.d.a(paramString, this.eCn, locala, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqh
 * JD-Core Version:    0.7.0.1
 */