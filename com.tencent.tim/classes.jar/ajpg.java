import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class ajpg
  implements Manager
{
  QQAppInterface app;
  boolean cpD = true;
  boolean cpE = true;
  SharedPreferences sp;
  
  public ajpg(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.sp = BaseApplicationImpl.getContext().getSharedPreferences("NearbyGeneralConfig", 0);
    if (this.sp != null)
    {
      this.cpD = this.sp.getBoolean("Notify_on_like", true);
      this.cpE = this.sp.getBoolean("key_allow_nearby_like", true);
    }
  }
  
  public void Mh(boolean paramBoolean)
  {
    this.cpD = paramBoolean;
    if (this.sp != null) {
      this.sp.edit().putBoolean("Notify_on_like", paramBoolean).commit();
    }
  }
  
  public void Mi(boolean paramBoolean)
  {
    if ((this.cpE != paramBoolean) && (this.sp != null))
    {
      this.cpE = paramBoolean;
      this.sp.edit().putBoolean("key_allow_nearby_like", paramBoolean).commit();
    }
  }
  
  public boolean aro()
  {
    return this.cpD;
  }
  
  public boolean arp()
  {
    return this.cpE;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpg
 * JD-Core Version:    0.7.0.1
 */