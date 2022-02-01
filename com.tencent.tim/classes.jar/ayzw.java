import com.tencent.qphone.base.util.QLog;

final class ayzw
  implements aolm.b
{
  ayzw(String paramString1, String paramString2, ayzv.a parama) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ayzv.access$100(), 2, "onResp resultcode: " + paramaomh.dPy + " threadid=" + Thread.currentThread().getId());
    }
    if ((paramaomh.dPy == 200) && (ayzv.access$200(this.cYt, this.cYs))) {
      if (this.a != null) {
        this.a.onDownloadSuccess();
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.onDownloadError();
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (this.a != null) {
      this.a.onProgress(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzw
 * JD-Core Version:    0.7.0.1
 */