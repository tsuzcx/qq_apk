import com.tencent.cloudfile.CloudFileCallback;
import com.tencent.qphone.base.util.QLog;

class atfh
  extends CloudFileCallback
{
  atfh(ateh paramateh) {}
  
  public void onAddRecentHistoryCallback(int paramInt, String paramString)
  {
    super.onAddRecentHistoryCallback(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 1, "onAddRecentHistoryCallback. errCode[" + paramInt + "] errMsg[" + paramString + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfh
 * JD-Core Version:    0.7.0.1
 */