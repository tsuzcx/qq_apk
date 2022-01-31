package wifiphoto;

import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.Cryptor;
import java.util.HashMap;
import java.util.Map;

public class WifiPhotoUrlParser
{
  private String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap;
  private String b;
  
  public WifiPhotoUrlParser(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString.trim();
  }
  
  public String a()
  {
    return this.b;
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (this.jdField_a_of_type_JavaLangString.length() == 0);
          localObject1 = this.jdField_a_of_type_JavaLangString.split("\\u003F");
        } while (localObject1.length != 2);
        localObject2 = localObject1[0].trim();
        localObject1 = localObject1[1].trim();
      } while ((((String)localObject2).length() == 0) || (((String)localObject1).length() == 0));
      this.b = ((String)localObject2);
      localObject2 = Base64Util.a(((String)localObject1).substring(4), 0);
      localObject2 = new Cryptor().decrypt((byte[])localObject2, DataLineHandler.a.jdField_a_of_type_JavaLangString.getBytes());
    } while (localObject2 == null);
    try
    {
      localObject2 = new String((byte[])localObject2, 0, localObject2.length, "UTF-8");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    return a((String)localObject1);
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.trim();
      } while (paramString.length() == 0);
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length != 2) {}
        for (;;)
        {
          i += 1;
          break;
          String str1 = arrayOfString[0].trim();
          String str2 = arrayOfString[1].trim();
          if ((str1.length() != 0) && (str2.length() != 0)) {
            this.jdField_a_of_type_JavaUtilMap.put(arrayOfString[0], arrayOfString[1]);
          }
        }
      }
    } while (this.jdField_a_of_type_JavaUtilMap.size() <= 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wifiphoto.WifiPhotoUrlParser
 * JD-Core Version:    0.7.0.1
 */