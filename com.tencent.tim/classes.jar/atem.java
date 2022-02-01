import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class atem
  extends atgg
{
  atem(ateh paramateh, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString) {}
  
  public void ek(int paramInt, String paramString)
  {
    super.ek(paramInt, paramString);
    ateh localateh = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localateh.notifyUI(12, bool, new Object[] { this.hE, this.hF, this.val$newFolderName, Integer.valueOf(paramInt), paramString });
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "renameFile pdirKey" + Arrays.toString(this.hE) + " self key " + Arrays.toString(this.hF) + "\n new name" + this.val$newFolderName + " errorCode:" + paramInt + "errorMsg:" + paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atem
 * JD-Core Version:    0.7.0.1
 */