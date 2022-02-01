import android.graphics.Bitmap;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;

public class accm
  extends alfu
{
  public accm(CardHandler paramCardHandler, long paramLong)
  {
    super(paramLong);
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    paramUploadImageSize = alft.getImage(paramAbstractUploadTask.uploadFilePath);
    if (paramUploadImageSize != null)
    {
      paramAbstractUploadTask = new IUploadConfig.UploadImageSize(paramUploadImageSize.getWidth(), paramUploadImageSize.getHeight(), 100);
      paramUploadImageSize.recycle();
      return paramAbstractUploadTask;
    }
    return new IUploadConfig.UploadImageSize(640, 1136, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accm
 * JD-Core Version:    0.7.0.1
 */