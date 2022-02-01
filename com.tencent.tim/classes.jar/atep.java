import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class atep
  extends atgg
{
  atep(ateh paramateh, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt) {}
  
  public void em(int paramInt, String paramString)
  {
    super.em(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "copyFile callback pdirKey" + Arrays.toString(this.hE) + " self key " + Arrays.toString(this.hI) + "\n dst key" + this.hH + "fileExistOpt" + this.epz + " errorCode:" + paramInt + "errorMsg:" + paramString);
    }
    ateh localateh = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localateh.notifyUI(15, bool, new Object[] { this.hE, this.hI, this.hH, Integer.valueOf(this.epz), Integer.valueOf(paramInt), paramString });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atep
 * JD-Core Version:    0.7.0.1
 */