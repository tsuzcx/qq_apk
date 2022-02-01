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

class sda
  implements peo.a
{
  sda(scw paramscw, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void biG()
  {
    QLog.d(scw.access$700(), 1, "onCommentSend()");
    if (scw.a(this.this$0) == null) {
      QLog.d(scw.access$700(), 1, "onCommentSend(): mCommentInputPopupWindow null");
    }
    String str;
    do
    {
      return;
      str = scw.a(this.this$0).getText();
    } while (TextUtils.isEmpty(str.trim()));
    if (!NetworkUtils.isNetworkAvailable(scw.m(this.this$0)))
    {
      QQToast.a(scw.n(this.this$0), 1, scw.o(this.this$0).getString(2131696284), 0).show();
      return;
    }
    Object localObject = scw.a(this.this$0);
    if (localObject == null)
    {
      QLog.e(scw.access$700(), 1, "feed is null");
      return;
    }
    if (this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (scw.a(this.this$0) == null) {
        scw.a(this.this$0, scw.a(this.this$0, this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      scw.a(this.this$0).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(scw.a(this.this$0));
      if (this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(scw.access$700(), 1, "feed is null");
        return;
      }
      if (scw.a(this.this$0).targetUser != null) {
        scw.a(this.this$0).put(Long.valueOf(scw.a(this.this$0)), scw.a(this.this$0).targetUser);
      }
      scw.b(this.this$0, scw.a(this.this$0).a(scw.a(this.this$0), this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      scw.c(this.this$0, true);
      scw.d(this.this$0, true);
      if (scw.b(this.this$0) != null) {
        scw.b(this.this$0).put(Long.valueOf(scw.a(this.this$0)), scw.a(this.this$0));
      }
      scw.a(this.this$0, null);
      if (scw.a(this.this$0) != null)
      {
        scw.a(this.this$0).a(this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        scw.a(this.this$0).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      scw.a(this.this$0).setText("");
      scw.a(this.this$0).qG(null);
      scw.a(this.this$0).dismiss();
      return;
      if (scw.a(this.this$0) == null) {
        scw.a(this.this$0, scw.b(this.this$0, this.jdField_d_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      scw.a(this.this$0).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(scw.a(this.this$0));
      scw.a(this.this$0).a(scw.a(this.this$0), (CertifiedAccountMeta.StComment)localObject);
      scw.c(this.this$0, true);
      scw.d(this.this$0, true);
      scw.a(this.this$0, null);
      if (scw.a(this.this$0) != null)
      {
        scw.a(this.this$0).a(0, (CertifiedAccountMeta.StComment)localObject);
        scw.a(this.this$0).notifyDataSetChanged();
      }
      if (this.this$0.l != null)
      {
        QLog.d(scw.access$700(), 1, "mNeedShowCommentList1");
        this.this$0.l.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sda
 * JD-Core Version:    0.7.0.1
 */