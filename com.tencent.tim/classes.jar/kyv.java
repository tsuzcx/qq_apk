import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kyv
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      if (TextUtils.equals("readinjoyClickChannelView", str1)) {
        awit.H("sp_key_readinjoy_click_channel_view", Boolean.valueOf(TextUtils.equals(str2, "1")));
      } else if (TextUtils.equals("readinjoySlideChannelView", str1)) {
        awit.H("sp_key_readinjoy_slide_channel_view", Boolean.valueOf(TextUtils.equals(str2, "1")));
      } else if (TextUtils.equals("readinjoyClickDiversionCard", str1)) {
        awit.H("sp_key_readinjoy_click_diversion_card", Boolean.valueOf(TextUtils.equals(str2, "1")));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    awit.H("sp_key_readinjoy_click_channel_view", Boolean.valueOf(false));
    awit.H("sp_key_readinjoy_slide_channel_view", Boolean.valueOf(false));
    awit.H("sp_key_readinjoy_click_diversion_card", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyv
 * JD-Core Version:    0.7.0.1
 */