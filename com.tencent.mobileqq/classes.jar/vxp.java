import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

class vxp
  implements wxx<CertifiedAccountRead.StGetFollowRcmdRsp>
{
  vxp(vxo paramvxo, SubscribeGetFollowRcmdRequest paramSubscribeGetFollowRcmdRequest, vxq paramvxq) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowRcmdRsp paramStGetFollowRcmdRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowRcmdRsp == null))
    {
      if ((!TextUtils.isEmpty(paramString)) && (vxo.a(this.jdField_a_of_type_Vxo) != null)) {
        bbmy.a(vxo.b(this.jdField_a_of_type_Vxo), 1, paramString, 0).a();
      }
      if (!bool)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowRcmdRequest);
        if ((this.jdField_a_of_type_Vxo.getItemCount() == 0) && (this.jdField_a_of_type_Vxq != null)) {
          this.jdField_a_of_type_Vxq.a();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramString = paramStGetFollowRcmdRsp.rcmdList.get();
      } while ((bool) && (!vxo.a(this.jdField_a_of_type_Vxo)));
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (vxo.a(this.jdField_a_of_type_Vxo)) {
          vxo.a(this.jdField_a_of_type_Vxo, false);
        }
        vxo.a(this.jdField_a_of_type_Vxo, paramString, paramStGetFollowRcmdRsp.extInfo, true);
        wye.b("auth_follow", "blank_exp", 0, 0, new String[0]);
        return;
      }
    } while ((bool) || (this.jdField_a_of_type_Vxo.getItemCount() != 0));
    vxo.b(this.jdField_a_of_type_Vxo, true);
    this.jdField_a_of_type_Vxo.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vxp
 * JD-Core Version:    0.7.0.1
 */