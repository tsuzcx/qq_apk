import java.io.File;
import java.util.HashMap;

public abstract class wks
{
  wks jdField_a_of_type_Wks;
  wkt jdField_a_of_type_Wkt;
  String c;
  String d;
  
  public wks(wju paramwju, wkt paramwkt, String paramString)
  {
    this.jdField_a_of_type_Wkt = paramwkt;
    this.c = paramString;
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(wju.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public wke a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      wke localwke = (wke)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localwke;
    }
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(wju.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wks != null) {
      this.jdField_a_of_type_Wks.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wks
 * JD-Core Version:    0.7.0.1
 */