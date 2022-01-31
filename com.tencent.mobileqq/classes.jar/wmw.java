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

class wmw
  implements xgu<CertifiedAccountRead.StGetCommentListRsp>
{
  wmw(wmn paramwmn, CertifiedAccountMeta.StFeed paramStFeed, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    wmn.a(this.jdField_a_of_type_Wmn, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), true);
    if (paramStGetCommentListRsp == null)
    {
      QLog.d(wmn.a(), 1, "getCommentSize: rsp is null");
      return;
    }
    if (wmn.a(this.jdField_a_of_type_Wmn).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get()) != null)
    {
      QLog.d(wmn.a(), 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.extInfo.attachInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
      ((ArrayList)wmn.a(this.jdField_a_of_type_Wmn).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())).addAll(this.jdField_a_of_type_Wmn.a(paramStGetCommentListRsp.vecComment.get(), this.jdField_a_of_type_JavaLangString));
    }
    wmn localwmn = this.jdField_a_of_type_Wmn;
    String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get();
    COMM.StCommonExt localStCommonExt = paramStGetCommentListRsp.extInfo;
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      wmn.a(localwmn, str, localStCommonExt, paramBoolean, true);
      stb.a().dispatch(this.jdField_a_of_type_Wmn.a(new Object[] { Integer.valueOf(9), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(this.jdField_a_of_type_Wmn.hashCode()), this.jdField_a_of_type_JavaLangString }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wmw
 * JD-Core Version:    0.7.0.1
 */