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

public class vsh
{
  private static String jdField_a_of_type_JavaLangString = "GdtAdWsVideoReport";
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  private static String a(stSimpleMetaFeed paramstSimpleMetaFeed, vgb paramvgb)
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
          paramstSimpleMetaFeed = vpk.a(paramstSimpleMetaFeed).report_info;
          str1 = str2;
          if (paramstSimpleMetaFeed != null)
          {
            str1 = str2;
            if (paramstSimpleMetaFeed.exposure_url != null)
            {
              str1 = str2;
              if (paramvgb != null)
              {
                str1 = str2;
                if (paramvgb.jdField_a_of_type_Vgh != null) {
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
      vmp.a(jdField_a_of_type_JavaLangString, " @getGdtInfo getHttpVideoPlayUrl" + paramString1.toString());
    }
    return "";
  }
  
  public static String a(vqa paramvqa)
  {
    int j = 1;
    if (paramvqa == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bt", paramvqa.jdField_a_of_type_Long);
      localJSONObject.put("et", paramvqa.jdField_b_of_type_Long + "");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramvqa.jdField_a_of_type_Boolean)
      {
        i = 1;
        localJSONObject.put("bf", i + "");
        localStringBuilder = new StringBuilder();
        if (!paramvqa.jdField_b_of_type_Boolean) {
          break label214;
        }
      }
      label214:
      for (int i = j;; i = 0)
      {
        localJSONObject.put("ef", i + "");
        localJSONObject.put("pp", "11");
        localJSONObject.put("pa", paramvqa.jdField_b_of_type_Int);
        localJSONObject.put("ft", paramvqa.c);
        if (paramvqa.d != 0) {
          localJSONObject.put("ps", paramvqa.d + "");
        }
        paramvqa = localJSONObject.toString();
        return paramvqa;
        i = 0;
        break;
      }
      return null;
    }
    catch (Exception paramvqa)
    {
      vmp.a(jdField_a_of_type_JavaLangString, " @getGdtInfo createGDTVideoAttachment" + paramvqa.toString());
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    vqb localvqb = new vqb();
    localvqb.a(paramLong1).b(paramBoolean2).b(paramLong2).d(paramInt4).a(paramInt1).a(paramBoolean1).b(paramInt2).c(paramInt3);
    a(localvqb.a(), paramString);
  }
  
  private static void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new GdtAdWsVideoReport.1(paramString), 0L);
  }
  
  public static void a(vpj paramvpj, vgb paramvgb)
  {
    if ((paramvpj == null) || (paramvgb == null) || (paramvpj.a() == null) || (paramvgb.jdField_a_of_type_Vgi == null) || (paramvpj.a() == null)) {}
    do
    {
      return;
      paramvpj.a().numbersOfGdtAdPlayed += 1;
      localObject = paramvpj.a();
    } while (!(localObject instanceof stSimpleMetaFeed));
    Object localObject = a((stSimpleMetaFeed)localObject, paramvgb);
    if ((paramvpj.a().numbersOfGdtAdPlayed > 1) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      a(0L, paramvgb.jdField_a_of_type_Vgi.c * 1000, false, true, 11, 13, 3, 0, (String)localObject);
      return;
    }
    a(paramvgb.jdField_a_of_type_Long, paramvgb.jdField_a_of_type_Vgi.c * 1000, false, true, 11, 11, 3, 0, (String)localObject);
    paramvpj.a().numbersOfGdtAdPlayed += 1;
  }
  
  public static void a(vpj paramvpj, vgb paramvgb, int paramInt)
  {
    if ((paramvpj == null) || (paramvgb == null) || ((paramvpj.a() == null) && (paramvpj.a() == null)) || (paramvgb.jdField_a_of_type_Vgi == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramvpj.a();
      } while (!(localObject instanceof stSimpleMetaFeed));
      localObject = a((stSimpleMetaFeed)localObject, paramvgb);
    } while ((paramvgb.jdField_a_of_type_Vgh == null) || (TextUtils.isEmpty((CharSequence)localObject)));
    long l = paramvgb.jdField_a_of_type_Vgh.a();
    int i = paramvgb.jdField_a_of_type_Vgi.c;
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
      if (paramvpj.a().numbersOfGdtAdPlayed <= 1) {
        break label159;
      }
      a(paramvgb.jdField_a_of_type_Long, l, jdField_b_of_type_Boolean, jdField_a_of_type_Boolean, 11, 13, paramInt, 0, (String)localObject);
      return;
      jdField_b_of_type_Boolean = false;
      break;
    }
    label159:
    a(paramvgb.jdField_a_of_type_Long, l, jdField_b_of_type_Boolean, jdField_a_of_type_Boolean, 11, 11, paramInt, 0, (String)localObject);
  }
  
  private static void a(vqa paramvqa, String paramString)
  {
    if ((paramvqa == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramvqa = a(paramvqa);
    paramString = a(paramString, paramvqa);
    vmp.a(jdField_a_of_type_JavaLangString, 2, "reportHttpVideoUrl = " + paramvqa);
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsh
 * JD-Core Version:    0.7.0.1
 */