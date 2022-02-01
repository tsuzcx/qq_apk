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

class zfw
  implements zhn
{
  zfw(zfs paramzfs, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(zfs.a(), 1, "onCommentSend()");
    if (zfs.a(this.jdField_a_of_type_Zfs) == null)
    {
      QLog.d(zfs.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = zfs.a(this.jdField_a_of_type_Zfs).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(zfs.m(this.jdField_a_of_type_Zfs), zfs.n(this.jdField_a_of_type_Zfs).getString(2131692095), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(zfs.o(this.jdField_a_of_type_Zfs)))
    {
      QQToast.a(zfs.p(this.jdField_a_of_type_Zfs), 1, zfs.q(this.jdField_a_of_type_Zfs).getString(2131694073), 0).a();
      return;
    }
    Object localObject = zfs.a(this.jdField_a_of_type_Zfs);
    if (localObject == null)
    {
      QLog.e(zfs.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (zfs.a(this.jdField_a_of_type_Zfs) == null) {
        zfs.a(this.jdField_a_of_type_Zfs, zfs.a(this.jdField_a_of_type_Zfs, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      zfs.a(this.jdField_a_of_type_Zfs).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(zfs.a(this.jdField_a_of_type_Zfs));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(zfs.a(), 1, "feed is null");
        return;
      }
      if (zfs.a(this.jdField_a_of_type_Zfs).targetUser != null) {
        zfs.a(this.jdField_a_of_type_Zfs).put(Long.valueOf(zfs.a(this.jdField_a_of_type_Zfs)), zfs.a(this.jdField_a_of_type_Zfs).targetUser);
      }
      zfs.b(this.jdField_a_of_type_Zfs, zfs.a(this.jdField_a_of_type_Zfs).a(zfs.a(this.jdField_a_of_type_Zfs), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      zfs.c(this.jdField_a_of_type_Zfs, true);
      zfs.d(this.jdField_a_of_type_Zfs, true);
      if (zfs.b(this.jdField_a_of_type_Zfs) != null) {
        zfs.b(this.jdField_a_of_type_Zfs).put(Long.valueOf(zfs.a(this.jdField_a_of_type_Zfs)), zfs.a(this.jdField_a_of_type_Zfs));
      }
      zfs.a(this.jdField_a_of_type_Zfs, null);
      if (zfs.a(this.jdField_a_of_type_Zfs) != null)
      {
        zfs.a(this.jdField_a_of_type_Zfs).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        zfs.a(this.jdField_a_of_type_Zfs).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      zfs.a(this.jdField_a_of_type_Zfs).a("");
      zfs.a(this.jdField_a_of_type_Zfs).b(null);
      zfs.a(this.jdField_a_of_type_Zfs).dismiss();
      return;
      if (zfs.a(this.jdField_a_of_type_Zfs) == null) {
        zfs.a(this.jdField_a_of_type_Zfs, zfs.b(this.jdField_a_of_type_Zfs, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      zfs.a(this.jdField_a_of_type_Zfs).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(zfs.a(this.jdField_a_of_type_Zfs));
      zfs.a(this.jdField_a_of_type_Zfs).a(zfs.a(this.jdField_a_of_type_Zfs), (CertifiedAccountMeta.StComment)localObject);
      zfs.c(this.jdField_a_of_type_Zfs, true);
      zfs.d(this.jdField_a_of_type_Zfs, true);
      zfs.a(this.jdField_a_of_type_Zfs, null);
      if (zfs.a(this.jdField_a_of_type_Zfs) != null)
      {
        zfs.a(this.jdField_a_of_type_Zfs).a(0, (CertifiedAccountMeta.StComment)localObject);
        zfs.a(this.jdField_a_of_type_Zfs).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Zfs.a != null)
      {
        QLog.d(zfs.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Zfs.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfw
 * JD-Core Version:    0.7.0.1
 */