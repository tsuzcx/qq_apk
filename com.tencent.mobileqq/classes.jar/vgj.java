import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;

public class vgj
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new vgk(this));
  private vgl jdField_a_of_type_Vgl;
  private vha jdField_a_of_type_Vha = vhe.a().a();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public vgj()
  {
    ThreadManager.executeOnSubThread(new WSVideoPluginInstall.1(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Vha.a();
    try
    {
      if (!this.b)
      {
        this.jdField_a_of_type_Vha.a(BaseApplicationImpl.getContext());
        vmp.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][initVideoSDK] finish!");
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
  
  public void a(vgl paramvgl)
  {
    this.jdField_a_of_type_Vgl = paramvgl;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Vha.a(BaseApplicationImpl.getContext());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Vgl = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgj
 * JD-Core Version:    0.7.0.1
 */