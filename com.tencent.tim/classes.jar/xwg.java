import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import java.util.HashMap;

public class xwg
  extends xwc
{
  public static String[] cK = { "icon_def", "icon_txt", "icon_voice", "icon_video", "icon_sp" };
  public AnimationView.AnimationInfo animInfo;
  public String background;
  public Bitmap corner;
  public HashMap<String, Bitmap> gX = new HashMap();
  public int isHideTitle;
  public String resPath;
  public String title;
  
  public xwg(String paramString)
  {
    super(paramString);
  }
  
  public Bitmap a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    Object localObject;
    if (paramRedPacketInfo == null)
    {
      localObject = null;
      return localObject;
    }
    if ((paramRedPacketInfo.h instanceof MessageForQQWalletMsg))
    {
      paramRedPacketInfo = (MessageForQQWalletMsg)paramRedPacketInfo.h;
      if (paramRedPacketInfo.messageType == 6) {
        paramRedPacketInfo = "icon_txt";
      }
    }
    for (;;)
    {
      label38:
      if (paramRedPacketInfo != null) {}
      for (paramRedPacketInfo = (Bitmap)this.gX.get(paramRedPacketInfo);; paramRedPacketInfo = null)
      {
        localObject = paramRedPacketInfo;
        if (paramRedPacketInfo != null) {
          break;
        }
        return (Bitmap)this.gX.get("icon_def");
        if (paramRedPacketInfo.messageType == 14)
        {
          paramRedPacketInfo = "icon_video";
          break label38;
        }
        if ((paramRedPacketInfo.messageType == 13) || (paramRedPacketInfo.messageType == 15))
        {
          paramRedPacketInfo = "icon_voice";
          break label38;
        }
        if (paramRedPacketInfo.messageType == 18)
        {
          paramRedPacketInfo = "icon_ksong";
          break label38;
        }
        if (paramRedPacketInfo.messageType == 19)
        {
          paramRedPacketInfo = "icon_emoji";
          break label38;
        }
        if (paramRedPacketInfo.messageType == 22)
        {
          paramRedPacketInfo = "icon_draw";
          break label38;
        }
        if ((paramRedPacketInfo.messageType != 7) && (paramRedPacketInfo.messageType != 8) && (paramRedPacketInfo.messageType != 11) && (paramRedPacketInfo.messageType != 12) && (paramRedPacketInfo.messageType != 23)) {
          break label213;
        }
        paramRedPacketInfo = "icon_sp";
        break label38;
      }
      label213:
      paramRedPacketInfo = null;
    }
  }
  
  public void d(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.background = paramRedPacketInfo.background;
      this.corner = paramRedPacketInfo.corner;
      this.animInfo = paramRedPacketInfo.animInfo;
      this.title = paramRedPacketInfo.title;
      this.isHideTitle = paramRedPacketInfo.isHideTitle;
      this.resPath = paramRedPacketInfo.resPath;
      String[] arrayOfString = cK;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramRedPacketInfo.attribute.containsKey(str))
        {
          Bitmap localBitmap = (Bitmap)paramRedPacketInfo.attribute.getParcelable(str);
          this.gX.put(str, localBitmap);
        }
        i += 1;
      }
    }
  }
  
  public boolean isValid()
  {
    return (this.background != null) || (this.animInfo != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xwg
 * JD-Core Version:    0.7.0.1
 */