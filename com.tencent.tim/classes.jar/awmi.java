import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_req;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

class awmi
  extends QzoneExternalRequest
{
  awmi(awmh paramawmh, Intent paramIntent) {}
  
  public String getCmdString()
  {
    return "SweetQzoneService.GetCommCfg";
  }
  
  public JceStruct getReq()
  {
    sweet_comm_cfg_get_req localsweet_comm_cfg_get_req = new sweet_comm_cfg_get_req();
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(1));
    localsweet_comm_cfg_get_req.vec_cfg = ((ArrayList)localObject);
    if (this.val$intent != null)
    {
      long l = this.val$intent.getLongExtra("currentUin", -1L);
      localObject = new sweet_req_comm();
      ((sweet_req_comm)localObject).opuin = l;
      ((sweet_req_comm)localObject).uin = l;
      ((sweet_req_comm)localObject).loveuin = 0L;
      ((sweet_req_comm)localObject).qua = avpq.getQUA3();
      ((sweet_req_comm)localObject).pf = 1;
      ((sweet_req_comm)localObject).src = 3;
      localsweet_comm_cfg_get_req.req_comm = ((sweet_req_comm)localObject);
    }
    return localsweet_comm_cfg_get_req;
  }
  
  public String uniKey()
  {
    return "GetCommCfg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmi
 * JD-Core Version:    0.7.0.1
 */