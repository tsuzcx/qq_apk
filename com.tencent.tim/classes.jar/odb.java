import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil.9.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

public final class odb
  implements BusinessObserver
{
  odb(Context paramContext, AppInterface paramAppInterface, int paramInt, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      ocp.K(this.val$context, 2131697432);
      return;
    }
    try
    {
      byte[] arrayOfByte = paramBundle.getByteArray("data");
      paramInt = paramBundle.getInt("type", 0);
      if (arrayOfByte != null)
      {
        paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (paramInt == 0)
        {
          paramBundle.mergeFrom(arrayOfByte);
          paramBoolean = true;
        }
        while (paramBoolean) {
          if ((paramBundle.ret_info.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0))
          {
            ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountUtil.9.1(this, paramBundle), 10L);
            return;
            paramBoolean = ocp.a(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle);
          }
          else
          {
            ocp.K(this.val$context, 2131697432);
            return;
          }
        }
        ocp.K(this.val$context, 2131697432);
        return;
      }
      ocp.K(this.val$context, 2131697432);
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odb
 * JD-Core Version:    0.7.0.1
 */