import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport.1;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.net.URLEncoder;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class vdo
{
  private static String jdField_a_of_type_JavaLangString = "GdtAdWsVideoReport";
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  private static String a(stSimpleMetaFeed paramstSimpleMetaFeed, urt paramurt)
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
          paramstSimpleMetaFeed = var.a(paramstSimpleMetaFeed).report_info;
          str1 = str2;
          if (paramstSimpleMetaFeed != null)
          {
            str1 = str2;
            if (paramstSimpleMetaFeed.exposure_url != null)
            {
              str1 = str2;
              if (paramurt != null)
              {
                str1 = str2;
                if (paramurt.jdField_a_of_type_Urw != null) {
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
      uya.a(jdField_a_of_type_JavaLangString, " @getGdtInfo getHttpVideoPlayUrl" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(vbh paramvbh)
  {
    int j = 1;
    if (paramvbh == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bt", paramvbh.jdField_a_of_type_Long);
      localJSONObject.put("et", paramvbh.jdField_b_of_type_Long + "");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramvbh.jdField_a_of_type_Boolean)
      {
        i = 1;
        localJSONObject.put("bf", i + "");
        localStringBuilder = new StringBuilder();
        if (!paramvbh.jdField_b_of_type_Boolean) {
          break label214;
        }
      }
      label214:
      for (int i = j;; i = 0)
      {
        localJSONObject.put("ef", i + "");
        localJSONObject.put("pp", "11");
        localJSONObject.put("pa", paramvbh.jdField_b_of_type_Int);
        localJSONObject.put("ft", paramvbh.c);
        if (paramvbh.d != 0) {
          localJSONObject.put("ps", paramvbh.d + "");
        }
        paramvbh = localJSONObject.toString();
        return paramvbh;
        i = 0;
        break;
      }
      return null;
    }
    catch (Exception paramvbh)
    {
      uya.a(jdField_a_of_type_JavaLangString, " @getGdtInfo createGDTVideoAttachment" + paramvbh.toString());
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    vbi localvbi = new vbi();
    localvbi.a(paramLong1).b(paramBoolean2).b(paramLong2).d(paramInt4).a(paramInt1).a(paramBoolean1).b(paramInt2).c(paramInt3);
    a(localvbi.a(), paramString);
  }
  
  private static void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new GdtAdWsVideoReport.1(paramString), 0L);
  }
  
  public static void a(vaq paramvaq, urt paramurt)
  {
    if ((paramvaq == null) || (paramurt == null) || (paramvaq.a() == null) || (paramurt.jdField_a_of_type_Urx == null) || (paramvaq.a() == null)) {}
    do
    {
      return;
      paramvaq.a().numbersOfGdtAdPlayed += 1;
      localObject = paramvaq.a();
    } while (!(localObject instanceof stSimpleMetaFeed));
    Object localObject = a((stSimpleMetaFeed)localObject, paramurt);
    if ((paramvaq.a().numbersOfGdtAdPlayed > 1) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      a(0L, paramurt.jdField_a_of_type_Urx.c * 1000, false, true, 11, 13, 3, 0, (String)localObject);
      return;
    }
    a(paramurt.jdField_a_of_type_Long, paramurt.jdField_a_of_type_Urx.c * 1000, false, true, 11, 11, 3, 0, (String)localObject);
    paramvaq.a().numbersOfGdtAdPlayed += 1;
  }
  
  public static void a(vaq paramvaq, urt paramurt, int paramInt)
  {
    if ((paramvaq == null) || (paramurt == null) || ((paramvaq.a() == null) && (paramvaq.a() == null)) || (paramurt.jdField_a_of_type_Urx == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramvaq.a();
      } while (!(localObject instanceof stSimpleMetaFeed));
      localObject = a((stSimpleMetaFeed)localObject, paramurt);
    } while ((paramurt.jdField_a_of_type_Urw == null) || (TextUtils.isEmpty((CharSequence)localObject)));
    long l = paramurt.jdField_a_of_type_Urw.a();
    int i = paramurt.jdField_a_of_type_Urx.c;
    if (l == 0L)
    {
      jdField_b_of_type_Boolean = true;
      if (l != i) {
        break label152;
      }
    }
    label152:
    for (jdField_a_of_type_Boolean = true;; jdField_a_of_type_Boolean = false)
    {
      if (paramvaq.a().numbersOfGdtAdPlayed <= 1) {
        break label159;
      }
      a(paramurt.jdField_a_of_type_Long, l, jdField_b_of_type_Boolean, jdField_a_of_type_Boolean, 11, 13, paramInt, 0, (String)localObject);
      return;
      jdField_b_of_type_Boolean = false;
      break;
    }
    label159:
    a(paramurt.jdField_a_of_type_Long, l, jdField_b_of_type_Boolean, jdField_a_of_type_Boolean, 11, 11, paramInt, 0, (String)localObject);
  }
  
  private static void a(vbh paramvbh, String paramString)
  {
    if ((paramvbh == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramvbh = a(paramvbh);
    paramString = a(paramString, paramvbh);
    uya.a(jdField_a_of_type_JavaLangString, 2, "reportHttpVideoUrl = " + paramvbh);
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdo
 * JD-Core Version:    0.7.0.1
 */