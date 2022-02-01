import android.content.SharedPreferences;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class ila
  extends ijo
{
  VoiceRecogTips a = null;
  
  public ila(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static SharedPreferences a(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin() + "qav_voicerecog", 0);
  }
  
  public static ijv.a a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = ((ijv)paramVideoAppInterface.a(3)).aR();
    long l = anaz.gQ();
    paramVideoAppInterface = paramVideoAppInterface.iterator();
    while (paramVideoAppInterface.hasNext())
    {
      ijv.a locala = (ijv.a)paramVideoAppInterface.next();
      if (c(l * 1000L, locala.lu, locala.lv)) {
        return locala;
      }
    }
    return null;
  }
  
  public static boolean c(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 >= paramLong2) && (paramLong1 <= paramLong3);
  }
  
  public static boolean c(VideoAppInterface paramVideoAppInterface)
  {
    return (irk.vm()) && (d(paramVideoAppInterface));
  }
  
  public static boolean d(VideoAppInterface paramVideoAppInterface)
  {
    return ((ikt)paramVideoAppInterface.a(5)).d(3, "normal");
  }
  
  protected void U(String paramString, boolean paramBoolean)
  {
    super.U(paramString, paramBoolean);
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (1 == paramInt) {
      onConnected();
    }
    while (3 != paramInt) {
      return;
    }
    onClose();
  }
  
  protected boolean cs(String paramString)
  {
    return false;
  }
  
  void onClose()
  {
    if (this.a != null)
    {
      this.a.g(this.mApp);
      this.a = null;
    }
  }
  
  void onConnected()
  {
    if (!c(this.mApp)) {}
    iiv localiiv;
    ijv.a locala;
    do
    {
      do
      {
        return;
        localiiv = this.mApp.b().b();
      } while (localiiv == null);
      locala = a(this.mApp);
    } while (locala == null);
    if (this.a != null) {
      this.a.g(this.mApp);
    }
    this.a = new VoiceRecogTips(this.mApp, localiiv.peerUin, locala);
  }
  
  protected void onCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ila
 * JD-Core Version:    0.7.0.1
 */