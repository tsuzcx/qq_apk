import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Map;

class zup
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetCommentListRsp>
{
  zup(zug paramzug, CertifiedAccountMeta.StFeed paramStFeed, String paramString) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    zug.a(this.jdField_a_of_type_Zug, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), true);
    if (paramStGetCommentListRsp == null)
    {
      QLog.d(zug.a(), 1, "getCommentSize: rsp is null");
      return;
    }
    if (zug.a(this.jdField_a_of_type_Zug).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get()) != null)
    {
      QLog.d(zug.a(), 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.extInfo.attachInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
      ((ArrayList)zug.a(this.jdField_a_of_type_Zug).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())).addAll(this.jdField_a_of_type_Zug.a(paramStGetCommentListRsp.vecComment.get(), this.jdField_a_of_type_JavaLangString));
    }
    paramVSBaseRequest = this.jdField_a_of_type_Zug;
    String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get();
    COMM.StCommonExt localStCommonExt = paramStGetCommentListRsp.extInfo;
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      zug.a(paramVSBaseRequest, str, localStCommonExt, paramBoolean, true);
      wad.a().dispatch(this.jdField_a_of_type_Zug.a(new Object[] { Integer.valueOf(9), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(this.jdField_a_of_type_Zug.hashCode()), this.jdField_a_of_type_JavaLangString }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zup
 * JD-Core Version:    0.7.0.1
 */