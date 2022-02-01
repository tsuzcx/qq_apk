import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONObject;

class aczp
  implements FileFilter
{
  aczp(aczo paramaczo, SparseArray paramSparseArray) {}
  
  public boolean accept(File paramFile)
  {
    Object localObject = new File(paramFile, "config.json");
    if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
      localObject = aqhq.readFileContent((File)localObject);
    }
    try
    {
      int i = Integer.parseInt(paramFile.getName());
      long l = new JSONObject((String)localObject).optLong("version");
      this.cm.append(i, Long.valueOf(l));
      QLog.i("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo roleId: " + i + ", ver: " + l / 1000L);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo failed role: " + paramFile.getAbsolutePath());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczp
 * JD-Core Version:    0.7.0.1
 */