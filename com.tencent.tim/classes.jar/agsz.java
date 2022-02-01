import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class agsz
  extends agsx
{
  public agsz(agsd paramagsd)
  {
    super(paramagsd);
  }
  
  public boolean S(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.b.b();
    if (localFileManagerEntity == null) {}
    while ((localFileManagerEntity.strTroopFilePath == null) || (!localFileManagerEntity.strTroopFilePath.equalsIgnoreCase(paramString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsz
 * JD-Core Version:    0.7.0.1
 */