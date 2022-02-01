import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class afxa
{
  private int cUV;
  private int cUW;
  
  public static afxa a(aeic paramaeic)
  {
    afxa localafxa = new afxa();
    if (paramaeic != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
      try
      {
        paramaeic = paramaeic.content;
        if (!TextUtils.isEmpty(paramaeic))
        {
          paramaeic = new JSONObject(paramaeic);
          localafxa.Nz(paramaeic.optInt("business_switch", 0));
          localafxa.NA(paramaeic.optInt("showInRecentView", 0));
          return localafxa;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localafxa;
        }
      }
      catch (JSONException paramaeic)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramaeic.toString());
        }
      }
    }
    return localafxa;
  }
  
  void NA(int paramInt)
  {
    this.cUW = paramInt;
  }
  
  void Nz(int paramInt)
  {
    this.cUV = paramInt;
  }
  
  public boolean ahA()
  {
    return this.cUV == 1;
  }
  
  public boolean aky()
  {
    return this.cUW == 1;
  }
  
  public String toString()
  {
    return String.format("mBusinessSwitch:%d", new Object[] { Integer.valueOf(this.cUV) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxa
 * JD-Core Version:    0.7.0.1
 */