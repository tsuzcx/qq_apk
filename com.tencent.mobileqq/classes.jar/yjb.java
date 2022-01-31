import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class yjb
  implements aocf
{
  public yjb(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public ColorNote getColorNote()
  {
    if ((this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null))
    {
      QLog.e("SubscribeBaseFragment", 1, "initColorNote, shareInfoBean is null");
      return null;
    }
    byte[] arrayOfByte = yly.a(new SubscribeColorNoteReserveBean(this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray(), this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType));
    ydo localydo = new ydo();
    localydo.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    localydo.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
    String str1 = "";
    String str3 = localydo.c();
    String str2 = localydo.d();
    String str4 = localydo.e();
    switch (localydo.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    }
    while (TextUtils.isEmpty(str1))
    {
      return null;
      str2 = localydo.f();
      str1 = "" + localydo.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get();
      continue;
      str1 = "" + localydo.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    return new aocl().a(16908291).a(str1).b(str3).c(str2).d(str4).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjb
 * JD-Core Version:    0.7.0.1
 */