import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

class atfl
  extends atgg
{
  atfl(ateh paramateh, byte[] paramArrayOfByte, atgg paramatgg, int paramInt) {}
  
  public void a(byte[] paramArrayOfByte, List<Object> paramList, boolean paramBoolean, String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString2)
  {
    super.a(paramArrayOfByte, paramList, paramBoolean, paramString1, paramLong1, paramLong2, paramInt1, paramInt2, paramString2);
    if (paramInt2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (QLog.isDevelopLevel())) {
        QLog.d("CloudFileHandler", 2, "getDirFileList dirKey" + Arrays.toString(this.hF) + " errCode:" + paramInt2 + " errMsg:" + paramString2);
      }
      if (this.b != null) {
        this.b.a(paramArrayOfByte, paramList, paramBoolean, paramString1, paramLong1, paramLong2, paramInt1, paramInt2, paramString2);
      }
      this.this$0.notifyUI(1, bool, new Object[] { this.hF, Integer.valueOf(this.epx), paramList, Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf((int)(paramLong1 + paramLong2)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfl
 * JD-Core Version:    0.7.0.1
 */