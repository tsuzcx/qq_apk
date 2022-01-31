import java.io.File;
import java.util.HashMap;

public abstract class wzr
{
  wzr jdField_a_of_type_Wzr;
  wzs jdField_a_of_type_Wzs;
  String c;
  String d;
  
  public wzr(wyt paramwyt, wzs paramwzs, String paramString)
  {
    this.jdField_a_of_type_Wzs = paramwzs;
    this.c = paramString;
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(wyt.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public wzd a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      wzd localwzd = (wzd)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localwzd;
    }
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(wyt.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wzr != null) {
      this.jdField_a_of_type_Wzr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzr
 * JD-Core Version:    0.7.0.1
 */