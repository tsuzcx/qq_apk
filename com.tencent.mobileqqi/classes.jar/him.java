import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import mqq.observer.BusinessObserver;

public class him
  implements BusinessObserver
{
  public him(AuthorityActivity paramAuthorityActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a.equals(localObject)) {}
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      if (paramBoolean)
      {
        GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
        try
        {
          localObject = paramBundle.getByteArray("data");
          paramBundle = (Bundle)localObject;
          if (!this.a.i) {
            paramBundle = this.a.b((byte[])localObject);
          }
          if (paramBundle != null)
          {
            localGetAppinfoResponse.mergeFrom(paramBundle);
            if ((localGetAppinfoResponse.has()) && (localGetAppinfoResponse.ret.get() == 0))
            {
              paramBundle = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
              paramBundle.what = 3;
              paramBundle.obj = localGetAppinfoResponse;
              this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
              return;
            }
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     him
 * JD-Core Version:    0.7.0.1
 */