import java.io.File;
import java.util.HashMap;

public abstract class ysz
{
  ysz jdField_a_of_type_Ysz;
  yta jdField_a_of_type_Yta;
  String c;
  String d;
  
  public ysz(ysb paramysb, yta paramyta, String paramString)
  {
    this.jdField_a_of_type_Yta = paramyta;
    this.c = paramString;
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(ysb.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public ysl a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      ysl localysl = (ysl)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localysl;
    }
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(ysb.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ysz != null) {
      this.jdField_a_of_type_Ysz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */