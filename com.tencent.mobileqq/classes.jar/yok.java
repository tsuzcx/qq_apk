import java.io.File;
import java.util.HashMap;

public abstract class yok
{
  yok jdField_a_of_type_Yok;
  yol jdField_a_of_type_Yol;
  String c;
  String d;
  
  public yok(ynm paramynm, yol paramyol, String paramString)
  {
    this.jdField_a_of_type_Yol = paramyol;
    this.c = paramString;
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(ynm.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public ynw a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      ynw localynw = (ynw)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localynw;
    }
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(ynm.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Yok != null) {
      this.jdField_a_of_type_Yok.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yok
 * JD-Core Version:    0.7.0.1
 */