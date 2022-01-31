import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Map;

class vzn
  implements wxx<CertifiedAccountRead.StGetCommentListRsp>
{
  vzn(vzf paramvzf, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    vzf.a(this.jdField_a_of_type_Vzf, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), true);
    if (paramStGetCommentListRsp == null)
    {
      QLog.d(vzf.a(), 1, "getCommentSize: rsp is null");
      return;
    }
    if (vzf.a(this.jdField_a_of_type_Vzf).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get()) != null)
    {
      QLog.d(vzf.a(), 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.extInfo.attachInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
      ((ArrayList)vzf.a(this.jdField_a_of_type_Vzf).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())).addAll(paramStGetCommentListRsp.vecComment.get());
    }
    vzf localvzf = this.jdField_a_of_type_Vzf;
    String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get();
    COMM.StCommonExt localStCommonExt = paramStGetCommentListRsp.extInfo;
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      vzf.a(localvzf, str, localStCommonExt, paramBoolean, true);
      sgi.a().dispatch(this.jdField_a_of_type_Vzf.a(new Object[] { Integer.valueOf(9), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(this.jdField_a_of_type_Vzf.hashCode()) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vzn
 * JD-Core Version:    0.7.0.1
 */