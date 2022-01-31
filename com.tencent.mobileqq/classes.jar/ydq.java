import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import android.text.TextUtils;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ydq
  implements zac<CertifiedAccountRead.StGetFollowRcmdRsp>
{
  ydq(ydp paramydp, SubscribeGetFollowRcmdRequest paramSubscribeGetFollowRcmdRequest, yds paramyds) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowRcmdRsp paramStGetFollowRcmdRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowRcmdRsp == null))
    {
      if ((!TextUtils.isEmpty(paramString)) && (ydp.a(this.jdField_a_of_type_Ydp) != null)) {
        QQToast.a(ydp.b(this.jdField_a_of_type_Ydp), 1, paramString, 0).a();
      }
      if (!bool)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowRcmdRequest);
        if ((this.jdField_a_of_type_Ydp.getItemCount() == 0) && (this.jdField_a_of_type_Yds != null)) {
          this.jdField_a_of_type_Yds.a();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramString = paramStGetFollowRcmdRsp.rcmdList.get();
      } while ((bool) && (!ydp.a(this.jdField_a_of_type_Ydp)));
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (ydp.a(this.jdField_a_of_type_Ydp)) {
          ydp.a(this.jdField_a_of_type_Ydp, false);
        }
        ydp.a(this.jdField_a_of_type_Ydp, paramString, paramStGetFollowRcmdRsp.extInfo, true);
        zaj.b("auth_follow", "blank_exp", 0, 0, new String[0]);
        return;
      }
    } while ((bool) || (this.jdField_a_of_type_Ydp.getItemCount() != 0));
    ydp.b(this.jdField_a_of_type_Ydp, true);
    this.jdField_a_of_type_Ydp.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydq
 * JD-Core Version:    0.7.0.1
 */