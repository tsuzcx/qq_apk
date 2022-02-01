import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class tmr
  implements tmq
{
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private tmp jdField_a_of_type_Tmp;
  
  public tmr(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException("" + paramString1 + " : " + paramString2);
    }
    this.jdField_a_of_type_Tmp = new tmp(paramContext, paramString2);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaIoFile = new File(paramString1);
  }
  
  public InputStream a(String paramString)
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString + "/" + paramString);
    if (((File)localObject).exists()) {
      try
      {
        localObject = new FileInputStream((File)localObject);
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        QLog.e("ReadMergeFile", 2, "getFile:" + paramString, localFileNotFoundException);
      }
    }
    InputStream localInputStream = this.jdField_a_of_type_Tmp.a(paramString);
    QLog.d("TemplateFactory", 1, "使用兜底 file: " + paramString);
    return localInputStream;
  }
  
  public List<String> a()
  {
    Object localObject2 = this.jdField_a_of_type_Tmp.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = this.jdField_a_of_type_JavaIoFile.list();
    if (localObject2 != null)
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject1).add(localObject2[i]);
        i += 1;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmr
 * JD-Core Version:    0.7.0.1
 */