import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class xwj
  extends xwc
{
  public Bitmap el;
  public String resPath;
  
  public xwj(String paramString)
  {
    super(paramString);
  }
  
  public void d(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.el = paramRedPacketInfo.icon;
      this.resPath = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean isValid()
  {
    return (this.el != null) && (!TextUtils.isEmpty(this.resPath));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwj
 * JD-Core Version:    0.7.0.1
 */