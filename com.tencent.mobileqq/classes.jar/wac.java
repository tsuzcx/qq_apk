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

class wac
  implements vze
{
  wac(vzz paramvzz, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(vzz.a(), 1, "onCommentSend()");
    if (vzz.a(this.jdField_a_of_type_Vzz) == null)
    {
      QLog.d(vzz.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = vzz.a(this.jdField_a_of_type_Vzz).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      bbmy.a(vzz.m(this.jdField_a_of_type_Vzz), vzz.n(this.jdField_a_of_type_Vzz).getString(2131626778), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(vzz.o(this.jdField_a_of_type_Vzz)))
    {
      bbmy.a(vzz.p(this.jdField_a_of_type_Vzz), 1, vzz.q(this.jdField_a_of_type_Vzz).getString(2131628956), 0).a();
      return;
    }
    Object localObject = vzz.a(this.jdField_a_of_type_Vzz);
    if (localObject == null)
    {
      QLog.e(vzz.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (vzz.a(this.jdField_a_of_type_Vzz) == null) {
        vzz.a(this.jdField_a_of_type_Vzz, vzz.a(this.jdField_a_of_type_Vzz, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      vzz.a(this.jdField_a_of_type_Vzz).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(vzz.a(this.jdField_a_of_type_Vzz));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(vzz.a(), 1, "feed is null");
        return;
      }
      if (vzz.a(this.jdField_a_of_type_Vzz).targetUser != null) {
        vzz.a(this.jdField_a_of_type_Vzz).put(Long.valueOf(vzz.a(this.jdField_a_of_type_Vzz)), vzz.a(this.jdField_a_of_type_Vzz).targetUser);
      }
      vzz.b(this.jdField_a_of_type_Vzz, vzz.a(this.jdField_a_of_type_Vzz).a(vzz.a(this.jdField_a_of_type_Vzz), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      vzz.b(this.jdField_a_of_type_Vzz, true);
      vzz.c(this.jdField_a_of_type_Vzz, true);
      if (vzz.b(this.jdField_a_of_type_Vzz) != null) {
        vzz.b(this.jdField_a_of_type_Vzz).put(Long.valueOf(vzz.a(this.jdField_a_of_type_Vzz)), vzz.a(this.jdField_a_of_type_Vzz));
      }
      vzz.a(this.jdField_a_of_type_Vzz, null);
      if (vzz.a(this.jdField_a_of_type_Vzz) != null)
      {
        vzz.a(this.jdField_a_of_type_Vzz).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        vzz.a(this.jdField_a_of_type_Vzz).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      vzz.a(this.jdField_a_of_type_Vzz).a("");
      vzz.a(this.jdField_a_of_type_Vzz).b(null);
      vzz.a(this.jdField_a_of_type_Vzz).dismiss();
      return;
      if (vzz.a(this.jdField_a_of_type_Vzz) == null) {
        vzz.a(this.jdField_a_of_type_Vzz, vzz.b(this.jdField_a_of_type_Vzz, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      vzz.a(this.jdField_a_of_type_Vzz).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(vzz.a(this.jdField_a_of_type_Vzz));
      vzz.a(this.jdField_a_of_type_Vzz).a(vzz.a(this.jdField_a_of_type_Vzz), (CertifiedAccountMeta.StComment)localObject);
      vzz.b(this.jdField_a_of_type_Vzz, true);
      vzz.c(this.jdField_a_of_type_Vzz, true);
      vzz.a(this.jdField_a_of_type_Vzz, null);
      if (vzz.a(this.jdField_a_of_type_Vzz) != null)
      {
        vzz.a(this.jdField_a_of_type_Vzz).a(0, (CertifiedAccountMeta.StComment)localObject);
        vzz.a(this.jdField_a_of_type_Vzz).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Vzz.a != null) {
        this.jdField_a_of_type_Vzz.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wac
 * JD-Core Version:    0.7.0.1
 */