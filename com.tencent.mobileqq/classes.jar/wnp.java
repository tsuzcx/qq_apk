import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ListView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class wnp
  implements wmp
{
  wnp(wnl paramwnl, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(wnl.a(), 1, "onCommentSend()");
    if (wnl.a(this.jdField_a_of_type_Wnl) == null)
    {
      QLog.d(wnl.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = wnl.a(this.jdField_a_of_type_Wnl).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      bcpw.a(wnl.m(this.jdField_a_of_type_Wnl), wnl.n(this.jdField_a_of_type_Wnl).getString(2131692380), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(wnl.o(this.jdField_a_of_type_Wnl)))
    {
      bcpw.a(wnl.p(this.jdField_a_of_type_Wnl), 1, wnl.q(this.jdField_a_of_type_Wnl).getString(2131694620), 0).a();
      return;
    }
    Object localObject = wnl.a(this.jdField_a_of_type_Wnl);
    if (localObject == null)
    {
      QLog.e(wnl.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (wnl.a(this.jdField_a_of_type_Wnl) == null) {
        wnl.a(this.jdField_a_of_type_Wnl, wnl.a(this.jdField_a_of_type_Wnl, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      wnl.a(this.jdField_a_of_type_Wnl).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(wnl.a(this.jdField_a_of_type_Wnl));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(wnl.a(), 1, "feed is null");
        return;
      }
      if (wnl.a(this.jdField_a_of_type_Wnl).targetUser != null) {
        wnl.a(this.jdField_a_of_type_Wnl).put(Long.valueOf(wnl.a(this.jdField_a_of_type_Wnl)), wnl.a(this.jdField_a_of_type_Wnl).targetUser);
      }
      wnl.b(this.jdField_a_of_type_Wnl, wnl.a(this.jdField_a_of_type_Wnl).a(wnl.a(this.jdField_a_of_type_Wnl), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      wnl.c(this.jdField_a_of_type_Wnl, true);
      wnl.d(this.jdField_a_of_type_Wnl, true);
      if (wnl.b(this.jdField_a_of_type_Wnl) != null) {
        wnl.b(this.jdField_a_of_type_Wnl).put(Long.valueOf(wnl.a(this.jdField_a_of_type_Wnl)), wnl.a(this.jdField_a_of_type_Wnl));
      }
      wnl.a(this.jdField_a_of_type_Wnl, null);
      if (wnl.a(this.jdField_a_of_type_Wnl) != null)
      {
        wnl.a(this.jdField_a_of_type_Wnl).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        wnl.a(this.jdField_a_of_type_Wnl).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      wnl.a(this.jdField_a_of_type_Wnl).a("");
      wnl.a(this.jdField_a_of_type_Wnl).b(null);
      wnl.a(this.jdField_a_of_type_Wnl).dismiss();
      return;
      if (wnl.a(this.jdField_a_of_type_Wnl) == null) {
        wnl.a(this.jdField_a_of_type_Wnl, wnl.b(this.jdField_a_of_type_Wnl, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      wnl.a(this.jdField_a_of_type_Wnl).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(wnl.a(this.jdField_a_of_type_Wnl));
      wnl.a(this.jdField_a_of_type_Wnl).a(wnl.a(this.jdField_a_of_type_Wnl), (CertifiedAccountMeta.StComment)localObject);
      wnl.c(this.jdField_a_of_type_Wnl, true);
      wnl.d(this.jdField_a_of_type_Wnl, true);
      wnl.a(this.jdField_a_of_type_Wnl, null);
      if (wnl.a(this.jdField_a_of_type_Wnl) != null)
      {
        wnl.a(this.jdField_a_of_type_Wnl).a(0, (CertifiedAccountMeta.StComment)localObject);
        wnl.a(this.jdField_a_of_type_Wnl).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Wnl.a != null)
      {
        QLog.d(wnl.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Wnl.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnp
 * JD-Core Version:    0.7.0.1
 */