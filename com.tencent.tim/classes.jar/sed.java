import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class sed
  implements aebf
{
  public sed(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public ColorNote getColorNote()
  {
    if ((this.a.a == null) || (this.a.mExtraTypeInfo == null))
    {
      QLog.e("SubscribeBaseFragment", 1, "initColorNote, shareInfoBean is null");
      return null;
    }
    byte[] arrayOfByte = shd.b(new SubscribeColorNoteReserveBean(this.a.a.toByteArray(), this.a.mExtraTypeInfo.pageType));
    san localsan = new san();
    localsan.mFeed = this.a.a;
    localsan.mExtraTypeInfo = this.a.mExtraTypeInfo;
    String str1 = "";
    String str3 = localsan.getShareTitle();
    String str2 = localsan.nr();
    String str4 = localsan.ns();
    switch (localsan.mExtraTypeInfo.pageType)
    {
    }
    while (TextUtils.isEmpty(str1))
    {
      return null;
      str2 = localsan.nt();
      str1 = "" + localsan.mFeed.id.get();
      continue;
      str1 = "" + localsan.mFeed.poster.id.get();
    }
    return new ColorNote.a().a(16908291).a(str1).b(str3).c(str2).d(str4).a(arrayOfByte).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sed
 * JD-Core Version:    0.7.0.1
 */