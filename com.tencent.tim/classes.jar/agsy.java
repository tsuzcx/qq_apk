import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class agsy
  extends agsx
{
  public agsy(agsd paramagsd)
  {
    super(paramagsd);
  }
  
  public boolean S(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.b.b();
    if (localFileManagerEntity == null) {
      return false;
    }
    return paramString.equals(String.valueOf(localFileManagerEntity.nSessionId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsy
 * JD-Core Version:    0.7.0.1
 */