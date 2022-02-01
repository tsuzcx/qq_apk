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

public class uur
{
  private static String jdField_a_of_type_JavaLangString = "GdtAdWsVideoReport";
  private static boolean jdField_a_of_type_Boolean;
  
  private static String a(stSimpleMetaFeed paramstSimpleMetaFeed, ukb paramukb)
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
          paramstSimpleMetaFeed = urv.a(paramstSimpleMetaFeed).report_info;
          str1 = str2;
          if (paramstSimpleMetaFeed != null)
          {
            str1 = str2;
            if (paramstSimpleMetaFeed.exposure_url != null)
            {
              str1 = str2;
              if (paramukb != null)
              {
                str1 = str2;
                if (paramukb.jdField_a_of_type_Uke != null) {
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
      upe.a(jdField_a_of_type_JavaLangString, " @getGdtInfo getHttpVideoPlayUrl" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(usl paramusl)
  {
    if (paramusl == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bt", paramusl.jdField_a_of_type_Long);
      localJSONObject.put("et", paramusl.jdField_b_of_type_Long + "");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramusl.jdField_a_of_type_Boolean) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("ef", i + "");
        localJSONObject.put("pp", "11");
        if (paramusl.jdField_b_of_type_Int != 0) {
          localJSONObject.put("ps", paramusl.jdField_b_of_type_Int + "");
        }
        paramusl = localJSONObject.toString();
        return paramusl;
      }
      return null;
    }
    catch (Exception paramusl)
    {
      upe.a(jdField_a_of_type_JavaLangString, " @getGdtInfo createGDTVideoAttachment" + paramusl.toString());
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    usm localusm = new usm();
    localusm.a(paramLong1).a(paramBoolean).b(paramLong2).b(paramInt2).a(paramInt1);
    a(localusm.a(), paramString);
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, ukb paramukb)
  {
    if ((paramstSimpleMetaFeed == null) || (paramukb == null)) {}
    do
    {
      return;
      paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramukb);
    } while ((paramukb.jdField_a_of_type_Uke == null) || (TextUtils.isEmpty(paramstSimpleMetaFeed)));
    long l = paramukb.jdField_a_of_type_Uke.a();
    if (l == paramukb.jdField_a_of_type_Ukf.c) {}
    for (jdField_a_of_type_Boolean = true;; jdField_a_of_type_Boolean = false)
    {
      a(paramukb.jdField_a_of_type_Long, l, jdField_a_of_type_Boolean, 11, 0, paramstSimpleMetaFeed);
      return;
    }
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, ukb paramukb, int paramInt)
  {
    if ((paramstSimpleMetaFeed == null) || (paramukb == null)) {}
    do
    {
      return;
      paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramukb);
    } while (TextUtils.isEmpty(paramstSimpleMetaFeed));
    a(paramukb.jdField_a_of_type_Long, paramInt, true, 11, 0, paramstSimpleMetaFeed);
  }
  
  private static void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new GdtAdWsVideoReport.1(paramString), 0L);
  }
  
  private static void a(usl paramusl, String paramString)
  {
    if ((paramusl == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramusl = a(paramusl);
    paramString = a(paramString, paramusl);
    upe.a(jdField_a_of_type_JavaLangString, 2, "reportHttpVideoUrl = " + paramusl);
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uur
 * JD-Core Version:    0.7.0.1
 */