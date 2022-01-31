import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

class wko
  implements xgu<CertifiedAccountRead.StGetFollowRcmdRsp>
{
  wko(wkn paramwkn, SubscribeGetFollowRcmdRequest paramSubscribeGetFollowRcmdRequest, wkq paramwkq) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowRcmdRsp paramStGetFollowRcmdRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowRcmdRsp == null))
    {
      if ((!TextUtils.isEmpty(paramString)) && (wkn.a(this.jdField_a_of_type_Wkn) != null)) {
        bcql.a(wkn.b(this.jdField_a_of_type_Wkn), 1, paramString, 0).a();
      }
      if (!bool)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowRcmdRequest);
        if ((this.jdField_a_of_type_Wkn.getItemCount() == 0) && (this.jdField_a_of_type_Wkq != null)) {
          this.jdField_a_of_type_Wkq.a();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramString = paramStGetFollowRcmdRsp.rcmdList.get();
      } while ((bool) && (!wkn.a(this.jdField_a_of_type_Wkn)));
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (wkn.a(this.jdField_a_of_type_Wkn)) {
          wkn.a(this.jdField_a_of_type_Wkn, false);
        }
        wkn.a(this.jdField_a_of_type_Wkn, paramString, paramStGetFollowRcmdRsp.extInfo, true);
        xhb.b("auth_follow", "blank_exp", 0, 0, new String[0]);
        return;
      }
    } while ((bool) || (this.jdField_a_of_type_Wkn.getItemCount() != 0));
    wkn.b(this.jdField_a_of_type_Wkn, true);
    this.jdField_a_of_type_Wkn.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wko
 * JD-Core Version:    0.7.0.1
 */