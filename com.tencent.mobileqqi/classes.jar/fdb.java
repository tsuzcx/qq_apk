import com.rookery.translate.tencent.TranslateRespWrapperFYJ;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.I18nTranslatorHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

public class fdb
  implements Callable
{
  Long jdField_a_of_type_JavaLangLong;
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  
  public fdb(I18nTranslatorHandler paramI18nTranslatorHandler, String paramString, Long paramLong, List paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public Boolean a()
  {
    j = 0;
    HttpUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler.a.getApplication());
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder("https://macqq.translator.qq.com/translate");
    for (;;)
    {
      try
      {
        ((StringBuilder)localObject).append("?");
        ((StringBuilder)localObject).append("platform=android");
        ((StringBuilder)localObject).append("&uin=" + this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler.a.a());
        ((StringBuilder)localObject).append("&skey=" + URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler.a.d(), "utf-8"));
        ((StringBuilder)localObject).append("&source=auto");
        ((StringBuilder)localObject).append("&target=" + I18nTranslatorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler, this.jdField_a_of_type_JavaLangString));
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            ((StringBuilder)localObject).append("&source_text=" + URLEncoder.encode((String)this.jdField_a_of_type_JavaUtilList.get(i), "utf-8"));
            i += 1;
            continue;
          }
        }
        localObject = ((StringBuilder)localObject).toString();
      }
      catch (Exception localException2)
      {
        String str = "https://macqq.translator.qq.com/translate";
        continue;
        boolean bool = false;
        int i = j;
        continue;
      }
      try
      {
        localObject = new JSONArray(I18nTranslatorHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler, (String)localObject));
        if (((JSONArray)localObject).getJSONObject(0).getInt("ret") == 0)
        {
          bool = true;
          i = j;
          if (i < ((JSONArray)localObject).length())
          {
            localArrayList.add(((JSONArray)localObject).getJSONObject(i).getString("target_text"));
            i += 1;
            continue;
          }
          if (bool)
          {
            localObject = new TranslateRespWrapperFYJ();
            ((TranslateRespWrapperFYJ)localObject).jdField_a_of_type_JavaLangLong = this.jdField_a_of_type_JavaLangLong;
            ((TranslateRespWrapperFYJ)localObject).jdField_a_of_type_JavaUtilList = localArrayList;
            this.jdField_a_of_type_ComTencentMobileqqAppI18nTranslatorHandler.a(80002, bool, localObject);
          }
          return Boolean.valueOf(bool);
        }
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translate", 2, "Request fail IOException");
        }
        return Boolean.FALSE;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translate", 2, "Request fail OutOfMemoryError");
        }
        return Boolean.FALSE;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translate", 2, "Request fail Exception");
        }
        localException1.printStackTrace();
        return Boolean.FALSE;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdb
 * JD-Core Version:    0.7.0.1
 */