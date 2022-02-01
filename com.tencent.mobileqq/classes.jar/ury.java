import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;

public class ury
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new urz(this));
  private usa jdField_a_of_type_Usa;
  private usp jdField_a_of_type_Usp = ust.a().a();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ury()
  {
    ThreadManager.executeOnSubThread(new WSVideoPluginInstall.1(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Usp.a();
    try
    {
      if (!this.b)
      {
        this.jdField_a_of_type_Usp.a(BaseApplicationImpl.getContext());
        uya.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][initVideoSDK] finish!");
        this.b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new WSVideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(usa paramusa)
  {
    this.jdField_a_of_type_Usa = paramusa;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Usp.a(BaseApplicationImpl.getContext());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Usa = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ury
 * JD-Core Version:    0.7.0.1
 */