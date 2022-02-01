import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.ArrayList;
import java.util.List;

public class atyx
{
  protected List<agsd> BF;
  protected FileManagerEntity c;
  protected QQAppInterface mApp;
  protected int mType = 0;
  
  public atyx(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public atxf.a a(BaseActivity paramBaseActivity)
  {
    return new atyy(this, paramBaseActivity);
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localForwardFileInfo == null) {
      return false;
    }
    if (paramIntent.getBooleanExtra("from_webview", false))
    {
      apcy localapcy = apsv.a(this.mApp, localForwardFileInfo.getFriendUin(), localForwardFileInfo.getUuid(), localForwardFileInfo.vj(), localForwardFileInfo.getFileName(), localForwardFileInfo.getFileSize(), paramIntent.getIntExtra("bisId", 0));
      new apca(localForwardFileInfo.getFriendUin(), this.mApp, paramActivity).a(localapcy, paramIntent.getStringExtra("sender_uin"), paramIntent.getLongExtra("last_time", 0L), -1);
      paramActivity.finish();
      return false;
    }
    long l = localForwardFileInfo.fR();
    this.c = this.mApp.a().b(l);
    if (this.c == null) {
      return false;
    }
    this.c.lastTime = paramIntent.getLongExtra("last_time", 0L);
    this.BF = new ArrayList();
    this.BF.add(atyn.b(this.mApp, this.c));
    if (this.c.nFileType == 0)
    {
      this.mType = 1;
      return true;
    }
    this.mType = 3;
    return true;
  }
  
  public List<agsd> fc()
  {
    return this.BF;
  }
  
  public int getType()
  {
    return this.mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyx
 * JD-Core Version:    0.7.0.1
 */