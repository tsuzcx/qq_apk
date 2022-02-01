import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class atfm
  extends atgg
{
  atfm(ateh paramateh, byte[] paramArrayOfByte) {}
  
  public void a(atin paramatin, int paramInt, String paramString)
  {
    super.a(paramatin, paramInt, paramString);
    if (QLog.isDevelopLevel()) {
      QLog.d("CloudFileHandler", 2, "createFileFolder call back dirKey" + Arrays.toString(this.hF) + " errorCode:" + paramInt + "errorMsg:" + paramString);
    }
    ateh localateh = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localateh.notifyUI(3, bool, new Object[] { this.hF, paramatin, paramString });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfm
 * JD-Core Version:    0.7.0.1
 */