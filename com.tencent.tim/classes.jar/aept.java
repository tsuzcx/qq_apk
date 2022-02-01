import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aept
  implements aehx<String>
{
  public boolean bVA;
  public boolean bVB;
  public boolean bVC;
  public boolean bVD;
  public boolean bVE;
  public boolean bVF;
  public boolean bVG;
  public boolean bVH;
  public boolean bVI;
  public boolean bVJ;
  public boolean bVu;
  public boolean bVv;
  public boolean bVw;
  public boolean bVx;
  public boolean bVy;
  public boolean bVz;
  public String byc = "";
  
  private void aX(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no troop");
    }
    do
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("videopreview");
        if (paramJSONObject == null)
        {
          QLog.e("QFileCommonConfigBean", 1, "parse Troop Json |type: 396no videoPreview");
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
        return;
      }
      this.bVG = paramJSONObject.getBoolean("switch");
      if (QLog.isColorLevel()) {
        QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview = " + this.bVG);
      }
      this.bVH = paramJSONObject.getBoolean("svip");
      if (QLog.isColorLevel()) {
        QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview for SVIP = " + this.bVH);
      }
      this.bVI = paramJSONObject.getBoolean("yearsvip");
    } while (!QLog.isColorLevel());
    QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview for YearSVIP = " + this.bVH);
  }
  
  private void aY(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no httpsJson");
    }
    for (;;)
    {
      return;
      try
      {
        this.bVu = paramJSONObject.getBoolean("c2c_up");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2c_up = " + this.bVu);
        }
        this.bVv = paramJSONObject.getBoolean("c2c_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2c_down = " + this.bVv);
        }
        this.bVw = paramJSONObject.getBoolean("c2czip_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2czip_down = " + this.bVw);
        }
        this.bVx = paramJSONObject.getBoolean("c2c_thumb");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2c_thumb = " + this.bVx);
        }
        this.bVy = paramJSONObject.getBoolean("disc_up");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disc_up = " + this.bVy);
        }
        this.bVz = paramJSONObject.getBoolean("disc_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disc_down = " + this.bVz);
        }
        this.bVA = paramJSONObject.getBoolean("disczip_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disczip_down = " + this.bVA);
        }
        this.bVB = paramJSONObject.getBoolean("disc_thumb");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disc_thumb = " + this.bVB);
        }
        this.bVC = paramJSONObject.getBoolean("troop_up");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_troop_up = " + this.bVC);
        }
        this.bVD = paramJSONObject.getBoolean("troop_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_troop_down = " + this.bVD);
        }
        this.bVE = paramJSONObject.getBoolean("troopzip_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_troopzip_down = " + this.bVE);
        }
        this.bVF = paramJSONObject.getBoolean("troop_thumb");
        if (QLog.isColorLevel())
        {
          QLog.d("QFileCommonConfigBean", 2, "https_troop_thumb = " + this.bVF);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
      }
    }
  }
  
  private void aZ(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no mediaPlatformJson");
    }
    for (;;)
    {
      return;
      try
      {
        this.bVJ = paramJSONObject.getBoolean("EnableAQQ");
        if (QLog.isColorLevel())
        {
          QLog.d("QFileCommonConfigBean", 2, "enableFileMediaPlatform = " + this.bVJ);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
      }
    }
  }
  
  public void lR(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396configContent is empty");
      return;
    }
    this.byc = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      aY(paramString.getJSONObject("https"));
      aX(paramString.getJSONObject("troop"));
      aZ(paramString.getJSONObject("UseMediaPlatform"));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileCommonConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aept
 * JD-Core Version:    0.7.0.1
 */