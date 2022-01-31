import java.io.File;
import java.util.HashMap;

public abstract class wzu
{
  wzu jdField_a_of_type_Wzu;
  wzv jdField_a_of_type_Wzv;
  String c;
  String d;
  
  public wzu(wyw paramwyw, wzv paramwzv, String paramString)
  {
    this.jdField_a_of_type_Wzv = paramwzv;
    this.c = paramString;
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(wyw.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public wzg a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      wzg localwzg = (wzg)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localwzg;
    }
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(wyw.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wzu != null) {
      this.jdField_a_of_type_Wzu.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzu
 * JD-Core Version:    0.7.0.1
 */