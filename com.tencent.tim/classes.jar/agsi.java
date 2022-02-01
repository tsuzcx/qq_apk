import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.ArrayList;
import java.util.List;

public class agsi
{
  protected List<agsd> BF;
  protected FileManagerEntity c;
  protected QQAppInterface mApp;
  private int mCurrentIndex;
  protected int mType = 0;
  
  public agsi(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public agqi.a a(BaseActivity paramBaseActivity)
  {
    return new agsj(this, paramBaseActivity);
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    Object localObject = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localObject == null) {
      return false;
    }
    if (paramIntent.getBooleanExtra("from_webview", false))
    {
      apcy localapcy = apsv.a(this.mApp, ((ForwardFileInfo)localObject).getFriendUin(), ((ForwardFileInfo)localObject).getUuid(), ((ForwardFileInfo)localObject).vj(), ((ForwardFileInfo)localObject).getFileName(), ((ForwardFileInfo)localObject).getFileSize(), paramIntent.getIntExtra("bisId", 0));
      l1 = ((ForwardFileInfo)localObject).getFriendUin();
      localObject = paramIntent.getStringExtra("sender_uin");
      long l2 = paramIntent.getLongExtra("last_time", 0L);
      ahbr.a(this.mApp, paramActivity, null, null, l1, localapcy, (String)localObject, l2, -1, 0, null, false, false);
      paramActivity.finish();
      return false;
    }
    long l1 = ((ForwardFileInfo)localObject).fR();
    this.c = this.mApp.a().b(l1);
    if (this.c == null) {
      return false;
    }
    this.BF = new ArrayList();
    this.c.lastTime = paramIntent.getLongExtra("last_time", 0L);
    this.BF.add(agrw.b(this.mApp, this.c));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agsi
 * JD-Core Version:    0.7.0.1
 */