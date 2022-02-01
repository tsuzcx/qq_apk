import java.io.File;
import java.util.HashMap;

public abstract class zqo
{
  zqo jdField_a_of_type_Zqo;
  zqp jdField_a_of_type_Zqp;
  String c;
  String d;
  
  public zqo(zpq paramzpq, zqp paramzqp, String paramString)
  {
    this.jdField_a_of_type_Zqp = paramzqp;
    this.c = paramString;
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(zpq.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public zqa a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      zqa localzqa = (zqa)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localzqa;
    }
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(zpq.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Zqo != null) {
      this.jdField_a_of_type_Zqo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqo
 * JD-Core Version:    0.7.0.1
 */