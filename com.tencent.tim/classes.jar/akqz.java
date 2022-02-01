import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class akqz
  implements anhs.a
{
  akqz(akqx paramakqx, AppInterface paramAppInterface) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    QLog.w(akqx.TAG, 1, "onDownloadProgress, index[3], bDownloadSuc[" + paramBoolean1 + "]");
    int[] arrayOfInt = this.c.mj;
    if (paramBoolean1) {}
    for (paramInt = 100;; paramInt = -1)
    {
      arrayOfInt[3] = paramInt;
      if (this.c.sp() == 100) {
        akqx.a(this.c, "onDownloadProgress1", this.b, false);
      }
      return;
    }
  }
  
  public void onDownloadProgress(int paramInt)
  {
    this.c.mj[3] = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqz
 * JD-Core Version:    0.7.0.1
 */