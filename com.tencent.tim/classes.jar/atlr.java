import com.tencent.qphone.base.util.QLog;

class atlr
  extends atgg
{
  atlr(atlo paramatlo) {}
  
  public void onIsDirKeyMatchedCallBack(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    QLog.d("CloudFileUploadingStatusController", 1, "checkUploadList isMatched[" + paramBoolean + "]");
    if (paramBoolean) {
      atlo.c(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlr
 * JD-Core Version:    0.7.0.1
 */