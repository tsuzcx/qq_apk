import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class mqx
  extends aook
{
  mqx(mqw parammqw) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != 10)) {}
    while ((localaoko.uniseq != this.b.a.mUniseq) || (TextUtils.equals(localaoko.fileMd5, mqw.a(this.b)))) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1001: 
      if (this.b.b != null) {
        this.b.b.aDx();
      }
      mqw.a(this.b, System.currentTimeMillis());
      return;
    case 1003: 
      mqw.b(this.b, System.currentTimeMillis());
      kbp.a(this.b.app, "", "0X8008180", "0X8008180", 0, 0, String.valueOf(mqw.a(this.b)), String.valueOf(mqw.b(this.b)), String.valueOf(mqw.a(this.b) - mqw.b(this.b)), String.valueOf(mqw.c(this.b) - mqw.d(this.b)));
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send finished!");
      }
      mqw.a(this.b, localaoko.fileMd5);
      mqw.b(this.b, localaoko.fileUrl);
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler mImageMd5=" + mqw.a(this.b) + ", mImageUrl=" + mqw.b(this.b));
      }
      mqw.a(this.b, 0, mqw.b(this.b), mqw.a(this.b), null);
      return;
    }
    mqw.b(this.b, System.currentTimeMillis());
    kbp.a(this.b.app, "", "0X8008180", "0X8008180", 0, 1, String.valueOf(mqw.a(this.b)), String.valueOf(mqw.b(this.b)), String.valueOf(mqw.a(this.b) - mqw.b(this.b)), String.valueOf(mqw.c(this.b) - mqw.d(this.b)));
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "mPicTransProcessorHandler send error:" + localaoko.errorCode);
    }
    mqw.a(this.b, 1004, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqx
 * JD-Core Version:    0.7.0.1
 */