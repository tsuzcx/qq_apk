import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atej
  extends atgg
{
  atej(ateh paramateh, atgg paramatgg, int paramInt) {}
  
  public void a(List<Object> paramList, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    super.a(paramList, paramBoolean, paramLong1, paramLong2, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "size: " + paramList.size() + " hasmore:" + paramBoolean + " errcode: " + paramInt + " errMsg:" + paramString);
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.b != null) {
        this.b.a(paramList, paramBoolean, paramLong1, paramLong2, paramInt, paramString);
      }
      this.this$0.notifyUI(17, bool, new Object[] { Integer.valueOf(this.epx), paramList });
      return;
    }
  }
  
  public void onGetAllItemCountCallback(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    super.onGetAllItemCountCallback(paramLong1, paramLong2, paramInt, paramString);
    if (paramInt == 0) {
      ((atgc)this.this$0.app.getManager(373)).aan((int)paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atej
 * JD-Core Version:    0.7.0.1
 */