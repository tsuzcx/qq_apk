import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class xzh
  implements yvn<CertifiedAccountRead.StGetFollowRcmdRsp>
{
  xzh(xzg paramxzg, SubscribeGetFollowRcmdRequest paramSubscribeGetFollowRcmdRequest, xzj paramxzj) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowRcmdRsp paramStGetFollowRcmdRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowRcmdRsp == null))
    {
      if ((!TextUtils.isEmpty(paramString)) && (xzg.a(this.jdField_a_of_type_Xzg) != null)) {
        QQToast.a(xzg.b(this.jdField_a_of_type_Xzg), 1, paramString, 0).a();
      }
      if (!bool)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowRcmdRequest);
        if ((this.jdField_a_of_type_Xzg.getItemCount() == 0) && (this.jdField_a_of_type_Xzj != null)) {
          this.jdField_a_of_type_Xzj.a();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramString = paramStGetFollowRcmdRsp.rcmdList.get();
      } while ((bool) && (!xzg.a(this.jdField_a_of_type_Xzg)));
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (xzg.a(this.jdField_a_of_type_Xzg)) {
          xzg.a(this.jdField_a_of_type_Xzg, false);
        }
        xzg.a(this.jdField_a_of_type_Xzg, paramString, paramStGetFollowRcmdRsp.extInfo, true);
        yvu.b("auth_follow", "blank_exp", 0, 0, new String[0]);
        return;
      }
    } while ((bool) || (this.jdField_a_of_type_Xzg.getItemCount() != 0));
    xzg.b(this.jdField_a_of_type_Xzg, true);
    this.jdField_a_of_type_Xzg.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xzh
 * JD-Core Version:    0.7.0.1
 */