import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;

public class axsj
  implements GifDecoder
{
  private ayob a;
  private String mData;
  private int mType;
  
  public axsj(int paramInt, String paramString)
  {
    this.mType = paramInt;
    this.mData = paramString;
  }
  
  public Bitmap getNextGifFrame(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnimationDecodeWrapper", 2, "timestamp:" + paramLong);
    }
    paramLong = paramLong / 1000L / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("AnimationDecodeWrapper", 2, "timestampMs:" + paramLong);
    }
    if (this.a != null) {
      return this.a.g(paramLong);
    }
    return null;
  }
  
  public void init()
  {
    this.a = aynb.a(BaseApplicationImpl.getContext(), this.mData);
  }
  
  public void release()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsj
 * JD-Core Version:    0.7.0.1
 */