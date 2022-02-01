import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.a;

public class xwi
  extends xwc
{
  public CustomizeStrategyFactory.a a;
  public boolean aHx;
  public Bitmap dv;
  public Drawable[] e;
  
  public xwi(String paramString)
  {
    super(paramString);
  }
  
  public void d(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.dv = paramRedPacketInfo.dv;
      this.e = paramRedPacketInfo.e;
      this.a = paramRedPacketInfo.a;
      this.aHx = paramRedPacketInfo.aHx;
    }
  }
  
  public boolean isValid()
  {
    return (this.dv != null) || (this.e != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwi
 * JD-Core Version:    0.7.0.1
 */