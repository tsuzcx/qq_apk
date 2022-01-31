import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ListView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ycb
  implements tzy
{
  ycb(ybx paramybx, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(ybx.a(), 1, "onCommentSend()");
    if (ybx.a(this.jdField_a_of_type_Ybx) == null)
    {
      QLog.d(ybx.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = ybx.a(this.jdField_a_of_type_Ybx).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(ybx.m(this.jdField_a_of_type_Ybx), ybx.n(this.jdField_a_of_type_Ybx).getString(2131692456), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(ybx.o(this.jdField_a_of_type_Ybx)))
    {
      QQToast.a(ybx.p(this.jdField_a_of_type_Ybx), 1, ybx.q(this.jdField_a_of_type_Ybx).getString(2131694777), 0).a();
      return;
    }
    Object localObject = ybx.a(this.jdField_a_of_type_Ybx);
    if (localObject == null)
    {
      QLog.e(ybx.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (ybx.a(this.jdField_a_of_type_Ybx) == null) {
        ybx.a(this.jdField_a_of_type_Ybx, ybx.a(this.jdField_a_of_type_Ybx, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      ybx.a(this.jdField_a_of_type_Ybx).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(ybx.a(this.jdField_a_of_type_Ybx));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(ybx.a(), 1, "feed is null");
        return;
      }
      if (ybx.a(this.jdField_a_of_type_Ybx).targetUser != null) {
        ybx.a(this.jdField_a_of_type_Ybx).put(Long.valueOf(ybx.a(this.jdField_a_of_type_Ybx)), ybx.a(this.jdField_a_of_type_Ybx).targetUser);
      }
      ybx.b(this.jdField_a_of_type_Ybx, ybx.a(this.jdField_a_of_type_Ybx).a(ybx.a(this.jdField_a_of_type_Ybx), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      ybx.c(this.jdField_a_of_type_Ybx, true);
      ybx.d(this.jdField_a_of_type_Ybx, true);
      if (ybx.b(this.jdField_a_of_type_Ybx) != null) {
        ybx.b(this.jdField_a_of_type_Ybx).put(Long.valueOf(ybx.a(this.jdField_a_of_type_Ybx)), ybx.a(this.jdField_a_of_type_Ybx));
      }
      ybx.a(this.jdField_a_of_type_Ybx, null);
      if (ybx.a(this.jdField_a_of_type_Ybx) != null)
      {
        ybx.a(this.jdField_a_of_type_Ybx).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        ybx.a(this.jdField_a_of_type_Ybx).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      ybx.a(this.jdField_a_of_type_Ybx).a("");
      ybx.a(this.jdField_a_of_type_Ybx).b(null);
      ybx.a(this.jdField_a_of_type_Ybx).dismiss();
      return;
      if (ybx.a(this.jdField_a_of_type_Ybx) == null) {
        ybx.a(this.jdField_a_of_type_Ybx, ybx.b(this.jdField_a_of_type_Ybx, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      ybx.a(this.jdField_a_of_type_Ybx).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(ybx.a(this.jdField_a_of_type_Ybx));
      ybx.a(this.jdField_a_of_type_Ybx).a(ybx.a(this.jdField_a_of_type_Ybx), (CertifiedAccountMeta.StComment)localObject);
      ybx.c(this.jdField_a_of_type_Ybx, true);
      ybx.d(this.jdField_a_of_type_Ybx, true);
      ybx.a(this.jdField_a_of_type_Ybx, null);
      if (ybx.a(this.jdField_a_of_type_Ybx) != null)
      {
        ybx.a(this.jdField_a_of_type_Ybx).a(0, (CertifiedAccountMeta.StComment)localObject);
        ybx.a(this.jdField_a_of_type_Ybx).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Ybx.a != null)
      {
        QLog.d(ybx.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Ybx.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ycb
 * JD-Core Version:    0.7.0.1
 */