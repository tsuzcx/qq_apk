import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler.1;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler.2;
import com.tencent.mobileqq.earlydownload.xmldata.PokeResData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class affc
  extends afeu
{
  private boolean bXQ;
  
  public affc(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.poke.res_0625", paramQQAppInterface);
  }
  
  public void HL(boolean paramBoolean)
  {
    super.HL(paramBoolean);
    ThreadManager.executeOnSubThread(new PokeResHandler.2(this));
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess:" + paramString);
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    String str = aqul.getSDKPrivatePath(xks.pt());
    if (QLog.isColorLevel()) {
      QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess imagePath=" + str);
    }
    ThreadManager.post(new PokeResHandler.1(this, str, paramString), 8, null, true);
    super.HO(paramString);
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public void cYO()
  {
    BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).edit().putBoolean("ready", true);
  }
  
  public Class<? extends XmlData> g()
  {
    return PokeResData.class;
  }
  
  public int getBusinessId()
  {
    return 10044;
  }
  
  public boolean isSuccess()
  {
    if (!this.bXQ) {
      this.bXQ = BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).getBoolean("ready", false);
    }
    return super.isSuccess() & this.bXQ;
  }
  
  public String un()
  {
    return "PokeResHandler_0625";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affc
 * JD-Core Version:    0.7.0.1
 */