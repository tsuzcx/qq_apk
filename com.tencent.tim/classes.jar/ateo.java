import com.tencent.cloudfile.BatchResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ateo
  extends atgg
{
  ateo(ateh paramateh, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, List paramList) {}
  
  public void g(int paramInt, String paramString, List<BatchResult> paramList)
  {
    super.g(paramInt, paramString, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "move file callback  source pdirKey" + Arrays.toString(this.hE) + " dst key name" + Arrays.toString(this.hH) + " errorCode:" + paramInt + "errorMsg:" + paramString);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BatchResult localBatchResult = (BatchResult)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "move file source pdirKey:" + Arrays.toString(localBatchResult.pDirKey) + " dst key:" + Arrays.toString(this.hH));
      }
    }
    paramList = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramList.notifyUI(14, bool, new Object[] { this.hE, this.Kp, this.hH, Integer.valueOf(paramInt), paramString });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ateo
 * JD-Core Version:    0.7.0.1
 */