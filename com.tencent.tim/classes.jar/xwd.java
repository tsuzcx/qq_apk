import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class xwd
  extends xwc
{
  public AnimationView.AnimationInfo specailBackgroundAnimInfo;
  public Bitmap specialBackground;
  
  public xwd(String paramString)
  {
    super(paramString);
  }
  
  public void d(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.specialBackground = paramRedPacketInfo.specialBackground;
      this.specailBackgroundAnimInfo = paramRedPacketInfo.specailBackgroundAnimInfo;
    }
  }
  
  public boolean isValid()
  {
    return (this.specailBackgroundAnimInfo != null) || (this.specialBackground != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwd
 * JD-Core Version:    0.7.0.1
 */