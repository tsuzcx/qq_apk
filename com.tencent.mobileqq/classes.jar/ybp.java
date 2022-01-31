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

class ybp
  implements yvn<CertifiedAccountRead.StGetCommentListRsp>
{
  ybp(ybg paramybg, CertifiedAccountMeta.StFeed paramStFeed, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    ybg.a(this.jdField_a_of_type_Ybg, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), true);
    if (paramStGetCommentListRsp == null)
    {
      QLog.d(ybg.a(), 1, "getCommentSize: rsp is null");
      return;
    }
    if (ybg.a(this.jdField_a_of_type_Ybg).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get()) != null)
    {
      QLog.d(ybg.a(), 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.extInfo.attachInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
      ((ArrayList)ybg.a(this.jdField_a_of_type_Ybg).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())).addAll(this.jdField_a_of_type_Ybg.a(paramStGetCommentListRsp.vecComment.get(), this.jdField_a_of_type_JavaLangString));
    }
    ybg localybg = this.jdField_a_of_type_Ybg;
    String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get();
    COMM.StCommonExt localStCommonExt = paramStGetCommentListRsp.extInfo;
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ybg.a(localybg, str, localStCommonExt, paramBoolean, true);
      uht.a().dispatch(this.jdField_a_of_type_Ybg.a(new Object[] { Integer.valueOf(9), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(this.jdField_a_of_type_Ybg.hashCode()), this.jdField_a_of_type_JavaLangString }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybp
 * JD-Core Version:    0.7.0.1
 */