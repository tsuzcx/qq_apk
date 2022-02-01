import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class mqz
  extends aook
{
  mqz(mqy parammqy) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != 10)) {}
    while ((localaoko.uniseq != this.a.a.mUniseq) || (localaoko.fileMd5.equals(mqy.a(this.a)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mVideoTransProcessorHandler transfer=" + localaoko.transferedSize + ", total=" + localaoko.fileSize);
      mqy.a(this.a, (float)localaoko.transferedSize * 100.0F / (float)localaoko.fileSize);
      return;
    case 1003: 
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler send finished!");
      mqy.a(this.a, localaoko.fileMd5);
      mqy.b(this.a, localaoko.fileUrl);
      QLog.d("KingsMomentVideoDeliveControllerr", 1, "mPicTransProcessorHandler mImageMd5=" + mqy.a(this.a) + ", mImageUrl=" + mqy.b(this.a));
      mqy.a(this.a, 0, mqy.b(this.a), mqy.a(this.a), null, null, null);
      return;
    }
    QLog.d("KingsMomentVideoDeliveControllerr", 1, "upload king moment cover failed");
    mqy.a(this.a, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqz
 * JD-Core Version:    0.7.0.1
 */