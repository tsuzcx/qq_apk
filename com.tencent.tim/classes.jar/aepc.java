import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aepc
{
  private String bAn = "";
  private String bAo = "";
  private String bAp = "";
  private String bAq = "";
  private boolean bVr;
  private int cOp = -1;
  private int cOq = -1;
  private int cOr = -1;
  private int cOs = -1;
  private String mTips = "";
  
  public static aepc a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aepc localaepc = new aepc();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      localaepc.cOp = paramArrayOfaeic.getInt("check_day");
      localaepc.cOq = paramArrayOfaeic.getInt("check_time");
      localaepc.cOr = paramArrayOfaeic.getInt("album_days");
      localaepc.cOs = paramArrayOfaeic.getInt("photos_limit");
      localaepc.mTips = paramArrayOfaeic.getString("tips");
      localaepc.bAn = paramArrayOfaeic.getString("jump_text");
      localaepc.bAo = paramArrayOfaeic.getString("t_show");
      localaepc.bAp = paramArrayOfaeic.getString("t_click");
      localaepc.bAq = paramArrayOfaeic.getString("t_close");
      localaepc.bVr = true;
      return localaepc;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfaeic);
    }
    return localaepc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepc
 * JD-Core Version:    0.7.0.1
 */