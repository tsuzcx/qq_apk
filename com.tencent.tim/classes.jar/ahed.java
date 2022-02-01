import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar.6;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

public class ahed
  extends AsyncTask<Object, Object, Integer>
{
  public ahed(SendBottomBar.6 param6) {}
  
  protected Integer doInBackground(Object... paramVarArgs)
  {
    paramVarArgs = agmz.D();
    Iterator localIterator = paramVarArgs.iterator();
    int i = 0;
    VFSFile localVFSFile;
    for (;;)
    {
      FileInfo localFileInfo;
      if (localIterator.hasNext())
      {
        localFileInfo = (FileInfo)localIterator.next();
        if (!localFileInfo.isLitePath()) {}
      }
      else
      {
        SendBottomBar.a(this.a.this$0).m(paramVarArgs);
        anql.a().Qm(true);
        return Integer.valueOf(i);
      }
      if (!SendBottomBar.a(this.a.this$0).a().mm(localFileInfo.getPath())) {
        try
        {
          localVFSFile = new VFSFile(localFileInfo.getPath());
          if (!localVFSFile.exists()) {
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
      localVFSFile.delete();
      SendBottomBar.a(this.a.this$0, SendBottomBar.a(this.a.this$0) + localException.getSize());
      i += 1;
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.this$0.btB();
    paramInteger = new Intent();
    paramInteger.putExtra("extra_delete_total_file_size", SendBottomBar.a(this.a.this$0));
    SendBottomBar.a(this.a.this$0).setResult(-1, paramInteger);
    agmz.clearSelected();
    this.a.this$0.dmH();
    SendBottomBar.a(this.a.this$0).onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahed
 * JD-Core Version:    0.7.0.1
 */