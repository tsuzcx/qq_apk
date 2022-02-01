import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_byebye_req;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

class awmg
  extends QzoneExternalRequest
{
  awmg(awmf paramawmf, Intent paramIntent) {}
  
  public String getCmdString()
  {
    return "SweetQzoneService.sweet_pair_byebye";
  }
  
  public JceStruct getReq()
  {
    sweet_pair_byebye_req localsweet_pair_byebye_req = new sweet_pair_byebye_req();
    if (this.val$intent != null)
    {
      long l1 = this.val$intent.getLongExtra("currentUin", -1L);
      long l2 = this.val$intent.getLongExtra("friendUin", -1L);
      sweet_req_comm localsweet_req_comm = new sweet_req_comm();
      localsweet_req_comm.opuin = l1;
      localsweet_req_comm.uin = l1;
      localsweet_req_comm.loveuin = l2;
      localsweet_req_comm.qua = avpq.getQUA3();
      localsweet_req_comm.pf = 1;
      localsweet_req_comm.src = 3;
      localsweet_pair_byebye_req.req_comm = localsweet_req_comm;
    }
    return localsweet_pair_byebye_req;
  }
  
  public String uniKey()
  {
    return "sweet_pair_byebye";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmg
 * JD-Core Version:    0.7.0.1
 */