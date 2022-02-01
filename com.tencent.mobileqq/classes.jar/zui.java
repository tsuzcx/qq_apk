import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;

class zui
  implements zpx<Object>
{
  zui(zug paramzug, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack.onReceive(null, ((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (CertifiedAccountRead.StGetFeedDetailRsp)paramVarArgs[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zui
 * JD-Core Version:    0.7.0.1
 */