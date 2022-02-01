import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionCommPicTryUp;

public class avdg
  implements Manager
{
  private aooi a;
  private akyf c = new avdh(this);
  public RemoteCommand.OnInvokeFinishLinstener d;
  private QQAppInterface mApp;
  private String mUin;
  
  public avdg(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.a = paramQQAppInterface.a();
    this.mUin = paramQQAppInterface.getCurrentUin();
  }
  
  public void a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      this.d = paramOnInvokeFinishLinstener;
      paramOnInvokeFinishLinstener = new aool();
      paramOnInvokeFinishLinstener.mFileType = 24;
      paramOnInvokeFinishLinstener.dOM = 20;
      paramOnInvokeFinishLinstener.ckW = "actQqComicPicUpload";
      paramOnInvokeFinishLinstener.mSelfUin = this.mUin;
      paramOnInvokeFinishLinstener.mPeerUin = this.mUin;
      paramOnInvokeFinishLinstener.cNy = true;
      paramOnInvokeFinishLinstener.dQ = paramBundle.getString("localPath");
      paramOnInvokeFinishLinstener.b = this.c;
      Object localObject = paramBundle.getString("comicId");
      String str1 = paramBundle.getString("picMd5");
      String str2 = paramBundle.getString("actionData");
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("comicId", localObject);
        paramBundle.put("picMd5", str1);
        paramBundle.put("actionData", str2);
        localObject = new cmd0x388.ExtensionCommPicTryUp();
        ((cmd0x388.ExtensionCommPicTryUp)localObject).rpt_bytes_extinfo.add(ByteStringMicro.copyFrom(paramBundle.toString().getBytes()));
        paramOnInvokeFinishLinstener.gb = ((cmd0x388.ExtensionCommPicTryUp)localObject).toByteArray();
        if (this.a == null) {
          continue;
        }
        this.a.a(paramOnInvokeFinishLinstener);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
    this.mUin = null;
    this.d = null;
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdg
 * JD-Core Version:    0.7.0.1
 */