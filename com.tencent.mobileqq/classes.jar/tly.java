import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tly
{
  public int a;
  public String a;
  public List<tlu> a;
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
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q = 1;
  public int r;
  public int s;
  
  public tly(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "1";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "1";
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
        this.g = paramString.optInt("refreshLastPosY", 10);
        this.h = paramString.optInt("refreshLastPosZ", 10);
        this.jdField_a_of_type_JavaLangString = paramString.optString("button_flag", "1");
        this.i = paramString.optInt("showAdType");
        this.jdField_b_of_type_JavaLangString = paramString.optString("pk_ad_vs_pic");
        this.j = paramString.optInt("AdSource");
        this.k = paramString.optInt("slide_effect1");
        this.l = paramString.optInt("slide_effect2");
        this.n = paramString.optInt("delivery_effect");
        this.jdField_c_of_type_JavaLangString = paramString.optString("img_coord");
        this.o = paramString.optInt("slideShowSlipAllowMs");
        this.p = paramString.optInt("slideImgDisplayMs");
        this.q = paramString.optInt("animated_type");
        this.jdField_d_of_type_JavaLangString = paramString.optString("resZipUrl");
        this.jdField_e_of_type_JavaLangString = paramString.optString("res_zip_md5");
        this.r = paramString.optInt("res_zip_version");
        this.s = paramString.optInt("is_video_new");
        Object localObject = paramString.optJSONArray("container_ad_item");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          i1 = 0;
          if (i1 < ((JSONArray)localObject).length())
          {
            tlu localtlu = new tlu(((JSONArray)localObject).getJSONObject(i1));
            this.jdField_a_of_type_JavaUtilList.add(localtlu);
            if (!QLog.isColorLevel()) {
              break label608;
            }
            QLog.d("AdvertisementExtInfo", 2, "adPKImageData = " + localtlu.toString());
            break label608;
          }
        }
        paramString = paramString.optJSONArray("img_urls");
        if ((paramString != null) && (paramString.length() > 0))
        {
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          i1 = i2;
          if (i1 < paramString.length())
          {
            localObject = paramString.getString(i1);
            this.jdField_b_of_type_JavaUtilList.add(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("AdvertisementExtInfo", 2, "imgUrlList = " + this.jdField_b_of_type_JavaUtilList.toString());
            }
            i1 += 1;
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
      i1 += 1;
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
    localStringBuffer.append("buttonFlag=").append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuffer.append("slidEffect1=").append(this.k).append("|");
    localStringBuffer.append("slidEffect2=").append(this.l).append("|");
    localStringBuffer.append("deliveryEffect=").append(this.n).append("|");
    localStringBuffer.append("imgCoord=").append(this.jdField_c_of_type_JavaLangString).append("|");
    localStringBuffer.append("slideShowSlipAllowMs=").append(this.o).append("|");
    localStringBuffer.append("slideImgDisplayMs=").append(this.p).append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tly
 * JD-Core Version:    0.7.0.1
 */