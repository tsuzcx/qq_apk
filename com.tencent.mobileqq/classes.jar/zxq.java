import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class zxq
  implements zpx<Object>
{
  public zxq(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4) && (this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack != null)) {
      this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack.onReceive(null, ((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (CertifiedAccountRead.StGetMainPageRsp)paramVarArgs[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxq
 * JD-Core Version:    0.7.0.1
 */