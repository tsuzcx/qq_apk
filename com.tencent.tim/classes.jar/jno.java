import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class jno
{
  public static final SparseIntArray A = new SparseIntArray();
  
  static
  {
    A.put(35, 3);
    A.put(11, 2);
    A.put(8, 1);
    A.put(37, 4);
    A.put(52, 5);
  }
  
  public static int a(oidb_0x791.RedDotInfo paramRedDotInfo1, oidb_0x791.RedDotInfo paramRedDotInfo2)
  {
    if (paramRedDotInfo1 == null)
    {
      if (paramRedDotInfo2 == null) {
        return 0;
      }
      return -1;
    }
    if (paramRedDotInfo2 == null) {
      return 1;
    }
    return A.get(paramRedDotInfo1.uint32_appid.get()) - A.get(paramRedDotInfo2.uint32_appid.get());
  }
  
  public static boolean a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    boolean bool = true;
    int i = paramRedDotInfo.uint32_appid.get();
    if (i == 35)
    {
      paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRedDotInfo)) {
        try
        {
          long l = new JSONObject(paramRedDotInfo).optLong("image_red_display_780", 1L);
          if (l == 0L) {
            bool = false;
          }
          return bool;
        }
        catch (JSONException paramRedDotInfo)
        {
          ram.e("TroopRedTouchConfigure", "isStoryDisplayRedDot() APPID_STORY_IMG: Error parse json: ", paramRedDotInfo);
          return true;
        }
      }
      ram.d("TroopRedTouchConfigure", "isStoryDisplayRedDot() APPID_STORY_IMG: str_custom_buffer is null");
      return true;
    }
    return cL(i);
  }
  
  public static boolean cK(int paramInt)
  {
    return (paramInt == 8) || (paramInt == 35) || (paramInt == 11) || (paramInt == 37);
  }
  
  public static boolean cL(int paramInt)
  {
    return (cK(paramInt)) || (paramInt == 52);
  }
  
  public static boolean cM(int paramInt)
  {
    return (cN(paramInt)) || (cO(paramInt)) || (cP(paramInt)) || (cQ(paramInt)) || (paramInt == 40) || (paramInt == 39) || (paramInt == 41) || (paramInt == 42) || (paramInt == 58) || (paramInt == 56) || (paramInt == 57) || (paramInt == 59) || (paramInt == 60) || (paramInt == 61) || (paramInt == 65) || (paramInt == 63) || (paramInt == 53) || (paramInt == 54);
  }
  
  public static boolean cN(int paramInt)
  {
    return paramInt == 25;
  }
  
  public static boolean cO(int paramInt)
  {
    return (paramInt == 23) || (paramInt == 26);
  }
  
  public static boolean cP(int paramInt)
  {
    return (paramInt == 24) || (paramInt == 27);
  }
  
  public static boolean cQ(int paramInt)
  {
    return paramInt == 38;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jno
 * JD-Core Version:    0.7.0.1
 */