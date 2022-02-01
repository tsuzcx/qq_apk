import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class xwh
  extends xwc
{
  public AnimationView.AnimationInfo animInfo;
  public String background;
  
  public xwh(String paramString)
  {
    super(paramString);
  }
  
  public void d(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.background = paramRedPacketInfo.background;
      this.animInfo = paramRedPacketInfo.animInfo;
    }
  }
  
  public boolean isValid()
  {
    return (this.background != null) || (this.animInfo != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwh
 * JD-Core Version:    0.7.0.1
 */