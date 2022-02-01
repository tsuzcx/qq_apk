import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class seg
  implements aebf
{
  public seg(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
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
      arrayOfByte = shd.b(new SubscribeColorNoteReserveBean(SubscribeHybirdFragment.a(this.a).toByteArray(), SubscribeHybirdFragment.a(this.a).pageType));
      localObject = new san();
      ((san)localObject).mFeed = SubscribeHybirdFragment.a(this.a);
      ((san)localObject).mExtraTypeInfo = SubscribeHybirdFragment.a(this.a);
      str1 = SubscribeHybirdFragment.a(this.a).id.get();
      str2 = ((san)localObject).getShareTitle();
      ((san)localObject).nr();
      str3 = ((san)localObject).ns();
      localObject = ((san)localObject).nt();
    } while (TextUtils.isEmpty(str1));
    return new ColorNote.a().a(16908291).a(str1).b(str2).c((String)localObject).d(str3).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     seg
 * JD-Core Version:    0.7.0.1
 */