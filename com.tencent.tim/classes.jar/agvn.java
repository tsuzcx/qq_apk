import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class agvn
{
  private agvq a;
  private String bJp;
  private Rect bZ;
  private int cYM;
  private boolean cfi;
  private boolean cfj;
  private int mEntranceType;
  private Context mSourceContext;
  private Class<?> w;
  
  public agvn(Context paramContext, agvq paramagvq)
  {
    this.mSourceContext = paramContext;
    this.a = paramagvq;
    this.w = FileBrowserActivity.class;
    this.cYM = -1;
  }
  
  private boolean amy()
  {
    if (!bw()) {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser isFromAIO return false, mEntranceType:" + this.mEntranceType);
      }
    }
    ChatMessage localChatMessage;
    SessionInfo localSessionInfo;
    do
    {
      do
      {
        do
        {
          return false;
          localChatMessage = this.a.e();
          if (localChatMessage != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getChatMessage return falase");
        return false;
        localSessionInfo = this.a.a();
        if (localSessionInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getSessionInfo return falase");
      return false;
      if (this.a.amw())
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser set video resume, return true");
        }
        return true;
      }
      if (this.a.amx()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser canUseNewVideoBrowser is false, don't start new video browser");
    return false;
    ahbr.a(this.mSourceContext, this.bZ, localChatMessage, localSessionInfo, this.a.isMute(), this.a.amz(), this.a.amA(), null);
    return true;
  }
  
  private boolean bw()
  {
    return (this.mEntranceType == 1) || (this.mEntranceType == 5) || (this.mEntranceType == 3);
  }
  
  private void djO()
  {
    if ((this.a.amx()) && (amy())) {}
    do
    {
      return;
      Intent localIntent = this.a.x();
      if (localIntent == null)
      {
        QLog.i("FileBrowserCreator<FileAssistant>", 1, "openFileBrowser error, intent params is null.");
        return;
      }
      if (this.cYM != -1) {
        localIntent.setFlags(this.cYM);
      }
      localIntent.setClass(this.mSourceContext, this.w);
      localIntent.putExtra("file_enter_file_browser_type", this.mEntranceType);
      Bundle localBundle = new Bundle();
      localBundle.putInt("file_enter_file_browser_type", this.mEntranceType);
      if (this.bZ != null) {
        localBundle.putParcelable("file_browser_params_thumb_bound", this.bZ);
      }
      this.a.cC(localBundle);
      localIntent.putExtra("file_browser_extra_params", localBundle);
      if (!TextUtils.isEmpty(this.bJp)) {
        localIntent.putExtra("selfSet_leftViewText", this.bJp);
      }
      this.mSourceContext.startActivity(localIntent);
    } while (!(this.mSourceContext instanceof Activity));
    ((Activity)this.mSourceContext).overridePendingTransition(2130772077, 2130772079);
  }
  
  private void djP()
  {
    agvp localagvp = new agvp(this);
    String str1 = this.mSourceContext.getString(2131693826);
    String str2 = this.mSourceContext.getString(2131693828);
    ahal.a(this.mSourceContext, str1, str2, localagvp);
  }
  
  public void JE(boolean paramBoolean)
  {
    this.cfi = paramBoolean;
  }
  
  public void JF(boolean paramBoolean)
  {
    this.cfj = paramBoolean;
  }
  
  public void Jl(String paramString) {}
  
  public void Oy(int paramInt)
  {
    this.mEntranceType = paramInt;
  }
  
  public void Oz(int paramInt)
  {
    this.cYM = paramInt;
  }
  
  public void djN()
  {
    if ((this.cfi) && (this.a.SG()))
    {
      if (ahbr.a(this.mSourceContext, false, new agvo(this))) {
        djP();
      }
      return;
    }
    djO();
  }
  
  public void g(Class<?> paramClass)
  {
    this.w = paramClass;
  }
  
  public void k(Rect paramRect)
  {
    this.bZ = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvn
 * JD-Core Version:    0.7.0.1
 */