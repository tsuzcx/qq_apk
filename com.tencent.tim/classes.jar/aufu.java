import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import com.tencent.tim.filemanager.widget.SendBottomBar.9;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class aufu
  extends AsyncTask<Object, Object, Integer>
{
  public aufu(SendBottomBar.9 param9) {}
  
  protected Integer doInBackground(Object... paramVarArgs)
  {
    paramVarArgs = atwb.ep().iterator();
    int i = 0;
    File localFile;
    for (;;)
    {
      if (!paramVarArgs.hasNext()) {
        break label150;
      }
      FileInfo localFileInfo = (FileInfo)paramVarArgs.next();
      if (!SendBottomBar.a(this.a.this$0).a().mm(localFileInfo.getPath())) {
        try
        {
          localFile = new File(localFileInfo.getPath());
          if (!localFile.exists()) {
            QLog.e("delDownloadFiles<FileAssistant>", 1, "local file can scan, is not existed? file:" + localFileInfo.getPath());
          }
        }
        catch (Exception localException)
        {
          QLog.e("delDownloadFiles<FileAssistant>", 1, "del file error:" + localException.toString());
        }
      }
    }
    for (;;)
    {
      break;
      localFile.delete();
      i += 1;
    }
    label150:
    anql.a().Qm(true);
    return Integer.valueOf(i);
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.this$0.btB();
    if (paramInteger.intValue() != atwb.fN()) {
      auds.OS(2131693520);
    }
    atwb.clearSelected();
    this.a.this$0.dmH();
    SendBottomBar.a(this.a.this$0).onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufu
 * JD-Core Version:    0.7.0.1
 */