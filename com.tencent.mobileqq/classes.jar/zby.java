import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent.CsCmdCallback;
import mqq.os.MqqHandler;

public class zby
  implements SSOTunnelEvent.CsCmdCallback
{
  public zby(AVEngineWalper paramAVEngineWalper, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper.a.b(1, "ctrl Params download failed!!!!");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    ThreadManager.getUIHandler().post(new zbz(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zby
 * JD-Core Version:    0.7.0.1
 */