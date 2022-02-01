import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class aten
  extends atgg
{
  aten(ateh paramateh, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString) {}
  
  public void el(int paramInt, String paramString)
  {
    super.el(paramInt, paramString);
    ateh localateh = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localateh.notifyUI(13, bool, new Object[] { this.hE, this.hG, this.cGL, Integer.valueOf(paramInt), paramString });
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "renameFile pdirKey" + Arrays.toString(this.hE) + " self key " + Arrays.toString(this.hG) + "\n new name" + this.cGL + " errorCode:" + paramInt + "errorMsg:" + paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aten
 * JD-Core Version:    0.7.0.1
 */