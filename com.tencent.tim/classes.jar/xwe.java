import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class xwe
  extends xwc
{
  public Bitmap icon;
  public String resPath;
  
  public xwe(String paramString)
  {
    super(paramString);
  }
  
  public void d(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.icon = paramRedPacketInfo.icon;
      this.resPath = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean isValid()
  {
    return (this.icon != null) && (!TextUtils.isEmpty(this.resPath));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwe
 * JD-Core Version:    0.7.0.1
 */