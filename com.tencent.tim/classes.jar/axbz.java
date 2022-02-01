import java.io.File;

public class axbz
  extends axbu
{
  public String cTH;
  public String cTI;
  
  public String HD()
  {
    File localFile = new File(this.cTI);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.cTI + File.separator;
  }
  
  public String HE()
  {
    File localFile = new File(this.cTH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.cTH + File.separator + this.name;
  }
  
  public String getLocalPath()
  {
    File localFile = new File(this.cTI);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.cTI + File.separator + this.name;
  }
  
  public boolean isUsable()
  {
    Object localObject = new File(getLocalPath());
    if (!((File)localObject).exists()) {}
    do
    {
      return false;
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length <= 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbz
 * JD-Core Version:    0.7.0.1
 */