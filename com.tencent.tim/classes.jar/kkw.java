import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class kkw
{
  public int aEx;
  public int aEy;
  public int aJA;
  public int aJB;
  public int aJC;
  public int aJD;
  public int aJE;
  public int aJF;
  public int aJG;
  public int aJH = 1;
  public int aJI;
  public int aJJ;
  public int aJt;
  public int aJu;
  public int aJv;
  public int aJw;
  public int aJx;
  public int aJy;
  public int aJz;
  public String aan = "1";
  public String aao = "";
  public String aap;
  public String aaq;
  public String aar;
  public String aas = "1";
  public boolean agb;
  public List<kkt> gi;
  public List<String> gj;
  
  public kkw(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementExtInfo", 2, "adExt = " + paramString);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        this.aJt = paramString.optInt("AdSlideSpeed");
        this.aJu = paramString.optInt("AdRepeatedFlag");
        this.aJv = paramString.optInt("AdDistance");
        this.aEx = paramString.optInt("RepeatedReqFlag");
        this.aEy = paramString.optInt("KdPos");
        this.aJw = paramString.optInt("refreshLastPos", 0);
        this.aJx = paramString.optInt("refreshLastPosY", 10);
        this.aJy = paramString.optInt("refreshLastPosZ", 10);
        this.aan = paramString.optString("button_flag", "1");
        this.aJz = paramString.optInt("showAdType");
        this.aao = paramString.optString("pk_ad_vs_pic");
        this.aJA = paramString.optInt("AdSource");
        this.aJB = paramString.optInt("slide_effect1");
        this.aJC = paramString.optInt("slide_effect2");
        this.aJE = paramString.optInt("delivery_effect");
        this.aap = paramString.optString("img_coord");
        this.aJF = paramString.optInt("slideShowSlipAllowMs");
        this.aJG = paramString.optInt("slideImgDisplayMs");
        this.aJH = paramString.optInt("animated_type");
        this.aaq = paramString.optString("resZipUrl");
        this.aar = paramString.optString("res_zip_md5");
        this.aJI = paramString.optInt("res_zip_version");
        this.aJJ = paramString.optInt("is_video_new");
        Object localObject = paramString.optJSONArray("container_ad_item");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          this.gi = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            kkt localkkt = new kkt(((JSONArray)localObject).getJSONObject(i));
            this.gi.add(localkkt);
            if (!QLog.isColorLevel()) {
              break label608;
            }
            QLog.d("AdvertisementExtInfo", 2, "adPKImageData = " + localkkt.toString());
            break label608;
          }
        }
        paramString = paramString.optJSONArray("img_urls");
        if ((paramString != null) && (paramString.length() > 0))
        {
          this.gj = new ArrayList();
          i = j;
          if (i < paramString.length())
          {
            localObject = paramString.getString(i);
            this.gj.add(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("AdvertisementExtInfo", 2, "imgUrlList = " + this.gj.toString());
            }
            i += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AdvertisementExtInfo", 2, "advertisementExtInfo Exception = " + paramString.getMessage());
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementExtInfo", 2, "advertisementExtInfo = " + toString());
        }
      }
      while (!QLog.isColorLevel()) {}
      QLog.d("AdvertisementExtInfo", 2, "adExt = null");
      return;
      label608:
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("adSlideSpeed=").append(this.aJt).append("|");
    localStringBuffer.append("adRepeatedFlag=").append(this.aJu).append("|");
    localStringBuffer.append("adDistance=").append(this.aJv).append("|");
    localStringBuffer.append("repeatedReqFlag=").append(this.aEx).append("|");
    localStringBuffer.append("kdPos=").append(this.aEy).append("|");
    localStringBuffer.append("refreshLastPos=").append(this.aJw).append("|");
    localStringBuffer.append("showAdType=").append(this.aJz).append("|");
    localStringBuffer.append("buttonFlag=").append(this.aan).append("|");
    localStringBuffer.append("slidEffect1=").append(this.aJB).append("|");
    localStringBuffer.append("slidEffect2=").append(this.aJC).append("|");
    localStringBuffer.append("deliveryEffect=").append(this.aJE).append("|");
    localStringBuffer.append("imgCoord=").append(this.aap).append("|");
    localStringBuffer.append("slideShowSlipAllowMs=").append(this.aJF).append("|");
    localStringBuffer.append("slideImgDisplayMs=").append(this.aJG).append("|");
    return localStringBuffer.toString();
  }
  
  public boolean yO()
  {
    return this.aJu == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkw
 * JD-Core Version:    0.7.0.1
 */