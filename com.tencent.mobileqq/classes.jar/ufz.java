import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ufz
{
  public int a;
  public String a;
  public List<ufv> a;
  public boolean a;
  public int b;
  public String b;
  public List<String> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p = 1;
  public int q;
  public int r;
  public int s;
  
  public ufz(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = "1";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "1";
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementExtInfo", 2, "adExt = " + paramString);
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("AdSlideSpeed");
        this.jdField_b_of_type_Int = paramString.optInt("AdRepeatedFlag");
        this.jdField_c_of_type_Int = paramString.optInt("AdDistance");
        this.jdField_d_of_type_Int = paramString.optInt("RepeatedReqFlag");
        this.jdField_e_of_type_Int = paramString.optInt("KdPos");
        this.jdField_f_of_type_Int = paramString.optInt("refreshLastPos", 0);
        this.jdField_g_of_type_Int = paramString.optInt("refreshLastPosY", 10);
        this.jdField_h_of_type_Int = paramString.optInt("refreshLastPosZ", 10);
        this.jdField_b_of_type_JavaLangString = paramString.optString("button_flag", "1");
        this.i = paramString.optInt("showAdType");
        this.r = paramString.optInt("normal_mask");
        this.jdField_c_of_type_JavaLangString = paramString.optString("pk_ad_vs_pic");
        this.j = paramString.optInt("AdSource");
        this.k = paramString.optInt("slide_effect1");
        this.l = paramString.optInt("slide_effect2");
        this.m = paramString.optInt("delivery_effect");
        this.jdField_d_of_type_JavaLangString = paramString.optString("img_coord");
        this.n = paramString.optInt("slideShowSlipAllowMs");
        this.o = paramString.optInt("slideImgDisplayMs");
        this.p = paramString.optInt("animated_type");
        this.jdField_e_of_type_JavaLangString = paramString.optString("resZipUrl");
        this.jdField_f_of_type_JavaLangString = paramString.optString("res_zip_md5");
        this.q = paramString.optInt("res_zip_version");
        this.s = paramString.optInt("is_video_new");
        this.jdField_a_of_type_JavaLangString = paramString.optString("ad_switchs");
        JSONArray localJSONArray = paramString.optJSONArray("container_ad_item");
        Object localObject;
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          i1 = 0;
          if (i1 < localJSONArray.length())
          {
            localObject = new ufv(localJSONArray.getJSONObject(i1));
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            if (!QLog.isColorLevel()) {
              break label642;
            }
            QLog.d("AdvertisementExtInfo", 2, "adPKImageData = " + ((ufv)localObject).toString());
            break label642;
          }
        }
        localJSONArray = paramString.optJSONArray("img_urls");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          i1 = i2;
          if (i1 < localJSONArray.length())
          {
            localObject = localJSONArray.getString(i1);
            this.jdField_b_of_type_JavaUtilList.add(localObject);
            if (!QLog.isColorLevel()) {
              break label649;
            }
            QLog.d("AdvertisementExtInfo", 2, "imgUrlList = " + this.jdField_b_of_type_JavaUtilList.toString());
            break label649;
          }
        }
        this.jdField_h_of_type_JavaLangString = paramString.optString("liujinReportUrl");
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AdvertisementExtInfo", 2, "advertisementExtInfo Exception = " + paramString.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementExtInfo", 2, "advertisementExtInfo = " + toString());
      }
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("AdvertisementExtInfo", 2, "adExt = null");
        return;
        label642:
        i1 += 1;
        continue;
        label649:
        i1 += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("adSlideSpeed=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuffer.append("adRepeatedFlag=").append(this.jdField_b_of_type_Int).append("|");
    localStringBuffer.append("adDistance=").append(this.jdField_c_of_type_Int).append("|");
    localStringBuffer.append("repeatedReqFlag=").append(this.jdField_d_of_type_Int).append("|");
    localStringBuffer.append("kdPos=").append(this.jdField_e_of_type_Int).append("|");
    localStringBuffer.append("refreshLastPos=").append(this.jdField_f_of_type_Int).append("|");
    localStringBuffer.append("showAdType=").append(this.i).append("|");
    localStringBuffer.append("buttonFlag=").append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuffer.append("slidEffect1=").append(this.k).append("|");
    localStringBuffer.append("slidEffect2=").append(this.l).append("|");
    localStringBuffer.append("deliveryEffect=").append(this.m).append("|");
    localStringBuffer.append("imgCoord=").append(this.jdField_d_of_type_JavaLangString).append("|");
    localStringBuffer.append("slideShowSlipAllowMs=").append(this.n).append("|");
    localStringBuffer.append("slideImgDisplayMs=").append(this.o).append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufz
 * JD-Core Version:    0.7.0.1
 */