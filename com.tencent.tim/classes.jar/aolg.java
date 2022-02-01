import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

final class aolg
  implements aolm.b
{
  long fileSize = 0L;
  
  aolg(URLDrawableHandler paramURLDrawableHandler, String paramString, aoli paramaoli) {}
  
  public void onResp(aomh paramaomh)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.fileSize + " file.path = " + paramaomh.b.atY + " resp.result = " + paramaomh.mResult);
    }
    if (paramaomh.mResult == 3) {
      return;
    }
    boolean bool1;
    if (paramaomh.mResult == 0)
    {
      bool1 = bool2;
      if (this.val$handler != null)
      {
        this.val$handler.onFileDownloadSucceed(this.fileSize);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        aolf.a(bool1, new URL(this.val$url), null, true, paramaomh.dPy, paramaomh.dPI, null, this.a);
        return;
      }
      catch (Exception paramaomh)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.val$handler != null)
      {
        this.val$handler.onFileDownloadFailed(paramaomh.mResult);
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.fileSize = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolg
 * JD-Core Version:    0.7.0.1
 */