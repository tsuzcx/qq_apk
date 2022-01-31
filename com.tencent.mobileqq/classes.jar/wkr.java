import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

class wkr
  implements xgx<CertifiedAccountRead.StGetFollowRcmdRsp>
{
  wkr(wkq paramwkq, SubscribeGetFollowRcmdRequest paramSubscribeGetFollowRcmdRequest, wkt paramwkt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowRcmdRsp paramStGetFollowRcmdRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowRcmdRsp == null))
    {
      if ((!TextUtils.isEmpty(paramString)) && (wkq.a(this.jdField_a_of_type_Wkq) != null)) {
        bcpw.a(wkq.b(this.jdField_a_of_type_Wkq), 1, paramString, 0).a();
      }
      if (!bool)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowRcmdRequest);
        if ((this.jdField_a_of_type_Wkq.getItemCount() == 0) && (this.jdField_a_of_type_Wkt != null)) {
          this.jdField_a_of_type_Wkt.a();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramString = paramStGetFollowRcmdRsp.rcmdList.get();
      } while ((bool) && (!wkq.a(this.jdField_a_of_type_Wkq)));
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (wkq.a(this.jdField_a_of_type_Wkq)) {
          wkq.a(this.jdField_a_of_type_Wkq, false);
        }
        wkq.a(this.jdField_a_of_type_Wkq, paramString, paramStGetFollowRcmdRsp.extInfo, true);
        xhe.b("auth_follow", "blank_exp", 0, 0, new String[0]);
        return;
      }
    } while ((bool) || (this.jdField_a_of_type_Wkq.getItemCount() != 0));
    wkq.b(this.jdField_a_of_type_Wkq, true);
    this.jdField_a_of_type_Wkq.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wkr
 * JD-Core Version:    0.7.0.1
 */