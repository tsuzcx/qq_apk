import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class atzt
  extends atvo
{
  atzt(atzs paramatzs) {}
  
  public void Zj(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.getFilePath())))
    {
      QLog.w("FileBrowserModelBase", 1, "onFileContentChanged : local file is modified, and refresh file. filepath:" + this.a.getFilePath());
      long l = new File(paramString).lastModified();
      if (this.a.aab != l)
      {
        this.a.aab = l;
        this.a.e.ir();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzt
 * JD-Core Version:    0.7.0.1
 */