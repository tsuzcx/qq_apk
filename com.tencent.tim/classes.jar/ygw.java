import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ygw
{
  private int bYY;
  private boolean bmD;
  
  public static ygw a(String paramString)
  {
    ygw localygw = new ygw();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("useRecommendedSticker")) && (paramString.has("maxMatchLength")))
      {
        localygw.zW(paramString.getBoolean("useRecommendedSticker"));
        localygw.DV(paramString.getInt("maxMatchLength"));
      }
      return localygw;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("StickerRecConfigBean", 2, paramString.getMessage());
    }
    return localygw;
  }
  
  public void DV(int paramInt)
  {
    this.bYY = paramInt;
  }
  
  public boolean TB()
  {
    return this.bmD;
  }
  
  public int wK()
  {
    return this.bYY;
  }
  
  public void zW(boolean paramBoolean)
  {
    this.bmD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygw
 * JD-Core Version:    0.7.0.1
 */