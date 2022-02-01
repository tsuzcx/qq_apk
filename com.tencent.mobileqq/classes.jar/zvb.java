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

class zvb
  implements zws
{
  zvb(zux paramzux, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(zux.a(), 1, "onCommentSend()");
    if (zux.a(this.jdField_a_of_type_Zux) == null)
    {
      QLog.d(zux.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = zux.a(this.jdField_a_of_type_Zux).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(zux.m(this.jdField_a_of_type_Zux), zux.n(this.jdField_a_of_type_Zux).getString(2131692185), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(zux.o(this.jdField_a_of_type_Zux)))
    {
      QQToast.a(zux.p(this.jdField_a_of_type_Zux), 1, zux.q(this.jdField_a_of_type_Zux).getString(2131694264), 0).a();
      return;
    }
    Object localObject = zux.a(this.jdField_a_of_type_Zux);
    if (localObject == null)
    {
      QLog.e(zux.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (zux.a(this.jdField_a_of_type_Zux) == null) {
        zux.a(this.jdField_a_of_type_Zux, zux.a(this.jdField_a_of_type_Zux, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      zux.a(this.jdField_a_of_type_Zux).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(zux.a(this.jdField_a_of_type_Zux));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(zux.a(), 1, "feed is null");
        return;
      }
      if (zux.a(this.jdField_a_of_type_Zux).targetUser != null) {
        zux.a(this.jdField_a_of_type_Zux).put(Long.valueOf(zux.a(this.jdField_a_of_type_Zux)), zux.a(this.jdField_a_of_type_Zux).targetUser);
      }
      zux.b(this.jdField_a_of_type_Zux, zux.a(this.jdField_a_of_type_Zux).a(zux.a(this.jdField_a_of_type_Zux), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      zux.c(this.jdField_a_of_type_Zux, true);
      zux.d(this.jdField_a_of_type_Zux, true);
      if (zux.b(this.jdField_a_of_type_Zux) != null) {
        zux.b(this.jdField_a_of_type_Zux).put(Long.valueOf(zux.a(this.jdField_a_of_type_Zux)), zux.a(this.jdField_a_of_type_Zux));
      }
      zux.a(this.jdField_a_of_type_Zux, null);
      if (zux.a(this.jdField_a_of_type_Zux) != null)
      {
        zux.a(this.jdField_a_of_type_Zux).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        zux.a(this.jdField_a_of_type_Zux).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      zux.a(this.jdField_a_of_type_Zux).a("");
      zux.a(this.jdField_a_of_type_Zux).b(null);
      zux.a(this.jdField_a_of_type_Zux).dismiss();
      return;
      if (zux.a(this.jdField_a_of_type_Zux) == null) {
        zux.a(this.jdField_a_of_type_Zux, zux.b(this.jdField_a_of_type_Zux, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      zux.a(this.jdField_a_of_type_Zux).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(zux.a(this.jdField_a_of_type_Zux));
      zux.a(this.jdField_a_of_type_Zux).a(zux.a(this.jdField_a_of_type_Zux), (CertifiedAccountMeta.StComment)localObject);
      zux.c(this.jdField_a_of_type_Zux, true);
      zux.d(this.jdField_a_of_type_Zux, true);
      zux.a(this.jdField_a_of_type_Zux, null);
      if (zux.a(this.jdField_a_of_type_Zux) != null)
      {
        zux.a(this.jdField_a_of_type_Zux).a(0, (CertifiedAccountMeta.StComment)localObject);
        zux.a(this.jdField_a_of_type_Zux).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Zux.a != null)
      {
        QLog.d(zux.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Zux.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvb
 * JD-Core Version:    0.7.0.1
 */