import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class xwf
  extends xwc
{
  public String resPath;
  
  public xwf(String paramString)
  {
    super(paramString);
  }
  
  public void d(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null) {
      this.resPath = paramRedPacketInfo.resPath;
    }
  }
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.resPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwf
 * JD-Core Version:    0.7.0.1
 */