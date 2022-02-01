import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class atze
  extends atzc
{
  public atze(agsd paramagsd)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atze
 * JD-Core Version:    0.7.0.1
 */