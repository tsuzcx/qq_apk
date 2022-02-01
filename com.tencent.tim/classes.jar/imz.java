import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class imz
{
  String MD5_so;
  String MD5_zip_so;
  public boolean enable;
  String so_name;
  int task_id = 0;
  String url_zip_so;
  
  public static imz a()
  {
    Object localObject = igl.b(298).content;
    imz localimz = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localimz = a((String)localObject);
    }
    localObject = localimz;
    if (localimz == null) {
      localObject = new imz();
    }
    return localObject;
  }
  
  static imz a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      imz localimz = new imz();
      localimz.enable = paramString.getBoolean("enable");
      localimz.task_id = paramString.getInt("task_id");
      localimz.url_zip_so = paramString.getString("url_zip_so");
      localimz.MD5_zip_so = paramString.getString("MD5_zip_so");
      localimz.MD5_so = paramString.getString("MD5_so");
      localimz.so_name = paramString.getString("so_name");
      return localimz;
    }
    catch (Exception paramString)
    {
      QLog.d("QavGPDownloadManager", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
    return null;
  }
  
  public String toString()
  {
    return String.format("task_id[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], MD5_so[%s]", new Object[] { Integer.valueOf(this.task_id), Boolean.valueOf(this.enable), this.url_zip_so, this.MD5_zip_so, this.MD5_so });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imz
 * JD-Core Version:    0.7.0.1
 */