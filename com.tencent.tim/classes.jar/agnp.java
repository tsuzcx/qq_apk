import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class agnp
  extends agns
{
  public CharSequence getDescription()
  {
    Object localObject = (FileManagerEntity)this.Br.get(0);
    String str1 = ahcb.bu(((FileManagerEntity)localObject).srvTime);
    String str2 = ahav.e((FileManagerEntity)localObject);
    localObject = ahbj.g(((FileManagerEntity)localObject).fileSize);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2).append("  ").append(str1).append("  ").append((String)localObject);
    this.T = localStringBuilder;
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agnp
 * JD-Core Version:    0.7.0.1
 */