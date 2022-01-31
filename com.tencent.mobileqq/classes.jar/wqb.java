import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class wqb
  implements amgv
{
  public wqb(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public ColorNote getColorNote()
  {
    if ((SubscribeHybirdFragment.a(this.a) == null) || (SubscribeHybirdFragment.a(this.a) == null)) {
      QLog.e("SubscribeHybirdFragment", 1, "initColorNote, shareInfoBean is null");
    }
    byte[] arrayOfByte;
    Object localObject;
    String str1;
    String str2;
    String str3;
    do
    {
      return null;
      arrayOfByte = wst.a(new SubscribeColorNoteReserveBean(SubscribeHybirdFragment.a(this.a).toByteArray(), SubscribeHybirdFragment.a(this.a).pageType));
      localObject = new wkm();
      ((wkm)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = SubscribeHybirdFragment.a(this.a);
      ((wkm)localObject).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = SubscribeHybirdFragment.a(this.a);
      str1 = SubscribeHybirdFragment.a(this.a).id.get();
      str2 = ((wkm)localObject).c();
      ((wkm)localObject).d();
      str3 = ((wkm)localObject).e();
      localObject = ((wkm)localObject).f();
    } while (TextUtils.isEmpty(str1));
    return new amhb().a(16908291).a(str1).b(str2).c((String)localObject).d(str3).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqb
 * JD-Core Version:    0.7.0.1
 */