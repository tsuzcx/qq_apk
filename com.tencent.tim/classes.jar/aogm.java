import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aogm
  implements aqqq
{
  aogm(aogk paramaogk) {}
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOMusicSkin", 2, "onCompleted, scid:" + paramString1);
      }
      this.this$0.refresh();
    }
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogm
 * JD-Core Version:    0.7.0.1
 */