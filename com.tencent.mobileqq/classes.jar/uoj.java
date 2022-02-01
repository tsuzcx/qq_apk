import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;

public class uoj
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  public uoj(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  private void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    Object localObject = (CertifiedAccountMeta.StUser)paramStGetMainPageRsp.user.get();
    ServiceAccountFolderActivityNew.a(this.a, ((CertifiedAccountMeta.StUser)localObject).id.get());
    localObject = ((CertifiedAccountMeta.StUser)localObject).icon.get();
    if ((!TextUtils.isEmpty(paramStGetMainPageRsp.user.icon.get())) && (URLUtil.isNetworkUrl((String)localObject)))
    {
      ServiceAccountFolderActivityNew.a(this.a).setImageResource(2130840607);
      ServiceAccountFolderActivityNew.a(this.a).setOnClickListener(new uok(this, paramStGetMainPageRsp));
    }
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        ServiceAccountFolderActivityNew.a(this.a, paramStGetMainPageRsp);
        ykq.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage success");
        a(paramStGetMainPageRsp);
        ServiceAccountFolderActivityNew.a(this.a);
        ServiceAccountFolderActivityNew.a(this.a, paramStGetMainPageRsp);
      }
      return;
    }
    ykq.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage error retCode:" + paramLong + ",errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoj
 * JD-Core Version:    0.7.0.1
 */