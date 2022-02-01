import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.SliceSttManager.SliceSttServet.1.1;
import com.tencent.mobileqq.stt.SliceSttManager.SliceSttServet.1.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class anvp
  implements wqc
{
  anvp(anvo.a parama) {}
  
  public void Cx(int paramInt)
  {
    if (this.a.ciy != null)
    {
      localObject = new File(this.a.ciy);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
    this.a.g.sttAbility = 3;
    this.a.g.sttText = acfp.m(2131714622);
    this.a.g.isReadPtt = true;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_succ_flag", "0");
    ((HashMap)localObject).put("param_version", Build.VERSION.SDK_INT + "");
    ((HashMap)localObject).put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "ptttotextSuc", false, 0L, 0L, (HashMap)localObject, null);
    try
    {
      this.a.g.serial();
      this.a.b.mApp.b().c(this.a.g.frienduin, this.a.g.istroop, this.a.g.uniseq, this.a.g.msgData);
      this.a.b.M.post(new SliceSttManager.SliceSttServet.1.2(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SliceSttManager", 2, "updatedb", localException);
        }
      }
    }
  }
  
  public void caF() {}
  
  public void caG()
  {
    anvo.a.a(this.a);
  }
  
  public void setSttNetFinish()
  {
    anvo.a.a(this.a);
  }
  
  public void xC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SliceSttManager", 2, "updateText =" + paramString);
    }
    this.a.cix = paramString;
    this.a.b.M.post(new SliceSttManager.SliceSttServet.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvp
 * JD-Core Version:    0.7.0.1
 */