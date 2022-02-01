import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class sap
  implements rxc.a<CertifiedAccountRead.StGetFollowRcmdRsp>
{
  sap(sao paramsao, SubscribeGetFollowRcmdRequest paramSubscribeGetFollowRcmdRequest, sao.a parama) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowRcmdRsp paramStGetFollowRcmdRsp)
  {
    boolean bool = VSNetworkHelper.fQ(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowRcmdRsp == null))
    {
      if ((!TextUtils.isEmpty(paramString)) && (sao.a(this.b) != null)) {
        QQToast.a(sao.b(this.b), 1, paramString, 0).show();
      }
      if (!bool)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowRcmdRequest);
        if ((this.b.getItemCount() == 0) && (this.jdField_a_of_type_Sao$a != null)) {
          this.jdField_a_of_type_Sao$a.onError();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramString = paramStGetFollowRcmdRsp.rcmdList.get();
      } while ((bool) && (!sao.a(this.b)));
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (sao.a(this.b)) {
          sao.a(this.b, false);
        }
        sao.a(this.b, paramString, paramStGetFollowRcmdRsp.extInfo, true);
        sqn.d("auth_follow", "blank_exp", 0, 0, new String[0]);
        return;
      }
    } while ((bool) || (this.b.getItemCount() != 0));
    sao.b(this.b, true);
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sap
 * JD-Core Version:    0.7.0.1
 */