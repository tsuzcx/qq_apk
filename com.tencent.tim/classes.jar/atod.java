import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;
import com.tencent.tim.filemanager.widget.FileWebView.a;

public class atod
  implements FileWebView.a
{
  public atod(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void webLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity_interfacePage", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atod
 * JD-Core Version:    0.7.0.1
 */