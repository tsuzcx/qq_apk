import android.graphics.Bitmap.Config;
import java.net.URL;

public class noz
{
  public static int baM = 3;
  public int cacheType = 0;
  public Bitmap.Config d = Bitmap.Config.ARGB_8888;
  public long endTime;
  public String errMsg;
  public int failCode = -2;
  public boolean isPreload;
  public volatile boolean mIsCancel;
  public int reqHeight;
  public int reqWidth;
  public int shape = 0;
  public long startTime;
  public int tryCount;
  public URL url;
  public long xT;
  public long xU;
  public long xV;
  public long xW;
  public long xX;
  public long xY;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramObject == null);
              bool1 = bool3;
            } while (getClass() != paramObject.getClass());
            paramObject = (noz)paramObject;
            bool1 = bool3;
          } while (this.reqWidth != paramObject.reqWidth);
          bool1 = bool3;
        } while (this.reqHeight != paramObject.reqHeight);
        bool1 = bool3;
      } while (this.shape != paramObject.shape);
      if (this.url == null) {
        break;
      }
      bool1 = bool3;
    } while (!this.url.equals(paramObject.url));
    if (this.d == paramObject.d) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if (paramObject.url == null) {
        break;
      }
      return false;
    }
  }
  
  public String getCacheKey()
  {
    return "kandian_zimage_image_req_" + hashCode();
  }
  
  public int hashCode()
  {
    if (this.url != null) {}
    for (int i = this.url.hashCode();; i = 0) {
      return (((i * 31 + this.reqWidth) * 31 + this.reqHeight) * 31 + this.d.hashCode()) * 31 + this.shape;
    }
  }
  
  public String toString()
  {
    return this.url + " " + this.reqWidth + "x" + this.reqHeight + " isPreload:" + this.isPreload + " isCancel:" + this.mIsCancel + " startTime: " + this.startTime + " enterSubThreadTime: " + this.xT + " enterThreadPoolTime: " + this.xU + " startThreadPoolTime: " + this.xV + " downloadAndWriteFileTime: " + this.xW + " decodeTime: " + this.xX + " enterMainThreadTime: " + this.xY + " endTime: " + this.endTime + " failCode: " + this.failCode + " errMsg: " + this.errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noz
 * JD-Core Version:    0.7.0.1
 */