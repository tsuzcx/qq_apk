import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport.1;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.net.URLEncoder;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class uvt
{
  private static String jdField_a_of_type_JavaLangString = "GdtAdWsVideoReport";
  private static boolean jdField_a_of_type_Boolean;
  
  private static String a(stSimpleMetaFeed paramstSimpleMetaFeed, ukz paramukz)
  {
    String str2 = "";
    String str1 = str2;
    if (paramstSimpleMetaFeed != null)
    {
      str1 = str2;
      if (paramstSimpleMetaFeed.gdt_ad_type == 1)
      {
        str1 = str2;
        if (paramstSimpleMetaFeed.gdt_ad_info != null)
        {
          paramstSimpleMetaFeed = usw.a(paramstSimpleMetaFeed).report_info;
          str1 = str2;
          if (paramstSimpleMetaFeed != null)
          {
            str1 = str2;
            if (paramstSimpleMetaFeed.exposure_url != null)
            {
              str1 = str2;
              if (paramukz != null)
              {
                str1 = str2;
                if (paramukz.jdField_a_of_type_Ulc != null) {
                  str1 = paramstSimpleMetaFeed.exposure_url.get();
                }
              }
            }
          }
        }
      }
    }
    return str1;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (!TextUtils.isEmpty(paramString1)) {
        localStringBuffer.append(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localStringBuffer.append("&video=");
        localStringBuffer.append(URLEncoder.encode(paramString2));
      }
      paramString1 = localStringBuffer.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      uqf.a(jdField_a_of_type_JavaLangString, " @getGdtInfo getHttpVideoPlayUrl" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(utm paramutm)
  {
    if (paramutm == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bt", paramutm.jdField_a_of_type_Long);
      localJSONObject.put("et", paramutm.jdField_b_of_type_Long + "");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramutm.jdField_a_of_type_Boolean) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("ef", i + "");
        localJSONObject.put("pp", "11");
        if (paramutm.jdField_b_of_type_Int != 0) {
          localJSONObject.put("ps", paramutm.jdField_b_of_type_Int + "");
        }
        paramutm = localJSONObject.toString();
        return paramutm;
      }
      return null;
    }
    catch (Exception paramutm)
    {
      uqf.a(jdField_a_of_type_JavaLangString, " @getGdtInfo createGDTVideoAttachment" + paramutm.toString());
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    utn localutn = new utn();
    localutn.a(paramLong1).a(paramBoolean).b(paramLong2).b(paramInt2).a(paramInt1);
    a(localutn.a(), paramString);
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, ukz paramukz)
  {
    if ((paramstSimpleMetaFeed == null) || (paramukz == null)) {}
    do
    {
      return;
      paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramukz);
    } while ((paramukz.jdField_a_of_type_Ulc == null) || (TextUtils.isEmpty(paramstSimpleMetaFeed)));
    long l = paramukz.jdField_a_of_type_Ulc.a();
    if (l == paramukz.jdField_a_of_type_Uld.c) {}
    for (jdField_a_of_type_Boolean = true;; jdField_a_of_type_Boolean = false)
    {
      a(paramukz.jdField_a_of_type_Long, l, jdField_a_of_type_Boolean, 11, 0, paramstSimpleMetaFeed);
      return;
    }
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, ukz paramukz, int paramInt)
  {
    if ((paramstSimpleMetaFeed == null) || (paramukz == null)) {}
    do
    {
      return;
      paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramukz);
    } while (TextUtils.isEmpty(paramstSimpleMetaFeed));
    a(paramukz.jdField_a_of_type_Long, paramInt, true, 11, 0, paramstSimpleMetaFeed);
  }
  
  private static void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new GdtAdWsVideoReport.1(paramString), 0L);
  }
  
  private static void a(utm paramutm, String paramString)
  {
    if ((paramutm == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramutm = a(paramutm);
    paramString = a(paramString, paramutm);
    uqf.a(jdField_a_of_type_JavaLangString, 2, "reportHttpVideoUrl = " + paramutm);
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvt
 * JD-Core Version:    0.7.0.1
 */