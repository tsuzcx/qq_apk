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

class wnm
  implements wmm
{
  wnm(wni paramwni, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(wni.a(), 1, "onCommentSend()");
    if (wni.a(this.jdField_a_of_type_Wni) == null)
    {
      QLog.d(wni.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = wni.a(this.jdField_a_of_type_Wni).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      bcql.a(wni.m(this.jdField_a_of_type_Wni), wni.n(this.jdField_a_of_type_Wni).getString(2131692380), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(wni.o(this.jdField_a_of_type_Wni)))
    {
      bcql.a(wni.p(this.jdField_a_of_type_Wni), 1, wni.q(this.jdField_a_of_type_Wni).getString(2131694621), 0).a();
      return;
    }
    Object localObject = wni.a(this.jdField_a_of_type_Wni);
    if (localObject == null)
    {
      QLog.e(wni.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (wni.a(this.jdField_a_of_type_Wni) == null) {
        wni.a(this.jdField_a_of_type_Wni, wni.a(this.jdField_a_of_type_Wni, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      wni.a(this.jdField_a_of_type_Wni).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(wni.a(this.jdField_a_of_type_Wni));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(wni.a(), 1, "feed is null");
        return;
      }
      if (wni.a(this.jdField_a_of_type_Wni).targetUser != null) {
        wni.a(this.jdField_a_of_type_Wni).put(Long.valueOf(wni.a(this.jdField_a_of_type_Wni)), wni.a(this.jdField_a_of_type_Wni).targetUser);
      }
      wni.b(this.jdField_a_of_type_Wni, wni.a(this.jdField_a_of_type_Wni).a(wni.a(this.jdField_a_of_type_Wni), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      wni.c(this.jdField_a_of_type_Wni, true);
      wni.d(this.jdField_a_of_type_Wni, true);
      if (wni.b(this.jdField_a_of_type_Wni) != null) {
        wni.b(this.jdField_a_of_type_Wni).put(Long.valueOf(wni.a(this.jdField_a_of_type_Wni)), wni.a(this.jdField_a_of_type_Wni));
      }
      wni.a(this.jdField_a_of_type_Wni, null);
      if (wni.a(this.jdField_a_of_type_Wni) != null)
      {
        wni.a(this.jdField_a_of_type_Wni).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        wni.a(this.jdField_a_of_type_Wni).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      wni.a(this.jdField_a_of_type_Wni).a("");
      wni.a(this.jdField_a_of_type_Wni).b(null);
      wni.a(this.jdField_a_of_type_Wni).dismiss();
      return;
      if (wni.a(this.jdField_a_of_type_Wni) == null) {
        wni.a(this.jdField_a_of_type_Wni, wni.b(this.jdField_a_of_type_Wni, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      wni.a(this.jdField_a_of_type_Wni).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(wni.a(this.jdField_a_of_type_Wni));
      wni.a(this.jdField_a_of_type_Wni).a(wni.a(this.jdField_a_of_type_Wni), (CertifiedAccountMeta.StComment)localObject);
      wni.c(this.jdField_a_of_type_Wni, true);
      wni.d(this.jdField_a_of_type_Wni, true);
      wni.a(this.jdField_a_of_type_Wni, null);
      if (wni.a(this.jdField_a_of_type_Wni) != null)
      {
        wni.a(this.jdField_a_of_type_Wni).a(0, (CertifiedAccountMeta.StComment)localObject);
        wni.a(this.jdField_a_of_type_Wni).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Wni.a != null)
      {
        QLog.d(wni.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Wni.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnm
 * JD-Core Version:    0.7.0.1
 */