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

class ygk
  implements ucm
{
  ygk(ygg paramygg, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(ygg.a(), 1, "onCommentSend()");
    if (ygg.a(this.jdField_a_of_type_Ygg) == null)
    {
      QLog.d(ygg.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = ygg.a(this.jdField_a_of_type_Ygg).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(ygg.m(this.jdField_a_of_type_Ygg), ygg.n(this.jdField_a_of_type_Ygg).getString(2131692457), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(ygg.o(this.jdField_a_of_type_Ygg)))
    {
      QQToast.a(ygg.p(this.jdField_a_of_type_Ygg), 1, ygg.q(this.jdField_a_of_type_Ygg).getString(2131694779), 0).a();
      return;
    }
    Object localObject = ygg.a(this.jdField_a_of_type_Ygg);
    if (localObject == null)
    {
      QLog.e(ygg.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (ygg.a(this.jdField_a_of_type_Ygg) == null) {
        ygg.a(this.jdField_a_of_type_Ygg, ygg.a(this.jdField_a_of_type_Ygg, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      ygg.a(this.jdField_a_of_type_Ygg).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(ygg.a(this.jdField_a_of_type_Ygg));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(ygg.a(), 1, "feed is null");
        return;
      }
      if (ygg.a(this.jdField_a_of_type_Ygg).targetUser != null) {
        ygg.a(this.jdField_a_of_type_Ygg).put(Long.valueOf(ygg.a(this.jdField_a_of_type_Ygg)), ygg.a(this.jdField_a_of_type_Ygg).targetUser);
      }
      ygg.b(this.jdField_a_of_type_Ygg, ygg.a(this.jdField_a_of_type_Ygg).a(ygg.a(this.jdField_a_of_type_Ygg), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      ygg.c(this.jdField_a_of_type_Ygg, true);
      ygg.d(this.jdField_a_of_type_Ygg, true);
      if (ygg.b(this.jdField_a_of_type_Ygg) != null) {
        ygg.b(this.jdField_a_of_type_Ygg).put(Long.valueOf(ygg.a(this.jdField_a_of_type_Ygg)), ygg.a(this.jdField_a_of_type_Ygg));
      }
      ygg.a(this.jdField_a_of_type_Ygg, null);
      if (ygg.a(this.jdField_a_of_type_Ygg) != null)
      {
        ygg.a(this.jdField_a_of_type_Ygg).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        ygg.a(this.jdField_a_of_type_Ygg).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      ygg.a(this.jdField_a_of_type_Ygg).a("");
      ygg.a(this.jdField_a_of_type_Ygg).b(null);
      ygg.a(this.jdField_a_of_type_Ygg).dismiss();
      return;
      if (ygg.a(this.jdField_a_of_type_Ygg) == null) {
        ygg.a(this.jdField_a_of_type_Ygg, ygg.b(this.jdField_a_of_type_Ygg, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      ygg.a(this.jdField_a_of_type_Ygg).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(ygg.a(this.jdField_a_of_type_Ygg));
      ygg.a(this.jdField_a_of_type_Ygg).a(ygg.a(this.jdField_a_of_type_Ygg), (CertifiedAccountMeta.StComment)localObject);
      ygg.c(this.jdField_a_of_type_Ygg, true);
      ygg.d(this.jdField_a_of_type_Ygg, true);
      ygg.a(this.jdField_a_of_type_Ygg, null);
      if (ygg.a(this.jdField_a_of_type_Ygg) != null)
      {
        ygg.a(this.jdField_a_of_type_Ygg).a(0, (CertifiedAccountMeta.StComment)localObject);
        ygg.a(this.jdField_a_of_type_Ygg).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Ygg.a != null)
      {
        QLog.d(ygg.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_Ygg.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygk
 * JD-Core Version:    0.7.0.1
 */