import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;

class alfw
  implements IUploadTaskCallback
{
  alfw(alfv paramalfv) {}
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.a.mState = 1002;
    this.a.mErrorCode = paramInt;
    this.a.mErrorMsg = paramString;
    this.a.g(1002, new Object[0]);
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2) {}
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (this.a.mState != paramInt)
    {
      this.a.mState = paramInt;
      this.a.g(this.a.mState, new Object[0]);
    }
  }
  
  public void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject)
  {
    this.a.mState = 1001;
    this.a.mResult = paramObject;
    this.a.g(1001, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfw
 * JD-Core Version:    0.7.0.1
 */