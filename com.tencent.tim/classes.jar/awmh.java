import SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_rsp;
import SWEET_NEW_COMM_SVR.sweet_comm_cfg_item;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneExternalRequest;
import java.util.Map;

public class awmh
  extends awmb
{
  private void bF(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof sweet_comm_cfg_item)))
    {
      paramObject = (sweet_comm_cfg_item)paramObject;
      if (getAppInterface() != null)
      {
        ahpj localahpj = (ahpj)getAppInterface().getBusinessHandler(153);
        if (localahpj != null) {
          localahpj.i(true, paramObject.wording, paramObject.dynamic_value, paramObject.url);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (getAppInterface() == null);
      paramObject = (ahpj)getAppInterface().getBusinessHandler(153);
    } while (paramObject == null);
    paramObject.i(false, null, null, null);
  }
  
  public QzoneExternalRequest a(Intent paramIntent)
  {
    return new awmi(this, paramIntent);
  }
  
  public QQAppInterface getAppInterface()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public void nS(long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("currentUin", paramLong);
    es(localIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if (paramFromServiceMsg != null) {}
    for (int i = paramFromServiceMsg.getResultCode(); i == 1000; i = -1)
    {
      paramIntent = (sweet_comm_cfg_get_rsp)awct.decode(paramFromServiceMsg.getWupBuffer(), "GetCommCfg");
      if ((paramIntent != null) && (paramIntent.m_cfg_res != null))
      {
        paramIntent = (sweet_comm_cfg_item)paramIntent.m_cfg_res.get(new Long(1L));
        if (paramIntent != null) {
          bool = true;
        }
        bF(bool, paramIntent);
      }
      return;
    }
    bF(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmh
 * JD-Core Version:    0.7.0.1
 */