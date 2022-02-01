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

class scr
  implements rxc.a<CertifiedAccountRead.StGetCommentListRsp>
{
  scr(sci paramsci, CertifiedAccountMeta.StFeed paramStFeed, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    sci.a(this.a, this.f.id.get(), true);
    if (paramStGetCommentListRsp == null)
    {
      QLog.d(sci.access$200(), 1, "getCommentSize: rsp is null");
      return;
    }
    if (sci.a(this.a).get(this.f.id.get()) != null)
    {
      QLog.d(sci.access$200(), 2, "getCommentSize:" + paramStGetCommentListRsp.vecComment.size() + ", attachInfo:" + paramStGetCommentListRsp.extInfo.attachInfo.get() + "isFinish：" + paramStGetCommentListRsp.isFinish.get());
      ((ArrayList)sci.a(this.a).get(this.f.id.get())).addAll(this.a.a(paramStGetCommentListRsp.vecComment.get(), this.aDH));
    }
    sci localsci = this.a;
    String str = this.f.id.get();
    COMM.StCommonExt localStCommonExt = paramStGetCommentListRsp.extInfo;
    if (paramStGetCommentListRsp.isFinish.get() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      sci.a(localsci, str, localStCommonExt, paramBoolean, true);
      pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(9), Long.valueOf(paramLong), paramString, paramStGetCommentListRsp, Integer.valueOf(this.a.hashCode()), this.aDH }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scr
 * JD-Core Version:    0.7.0.1
 */