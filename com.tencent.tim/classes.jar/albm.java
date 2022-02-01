import android.text.TextUtils;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.qphone.base.util.QLog;

public class albm
  extends acfd
{
  public albm(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onUpdateFriendInfo refresh UI uin:" + paramString + " suc:" + paramBoolean);
    }
    if ((paramBoolean) && (TextUtils.equals(PersonalityLabelGalleryActivity.a(this.this$0), paramString)) && (!PersonalityLabelGalleryActivity.a(this.this$0)))
    {
      PersonalityLabelGalleryActivity.a(this.this$0, aqgv.s(this.this$0.app, PersonalityLabelGalleryActivity.a(this.this$0)));
      if (!TextUtils.equals(PersonalityLabelGalleryActivity.a(this.this$0), PersonalityLabelGalleryActivity.b(this.this$0))) {
        PersonalityLabelGalleryActivity.d(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albm
 * JD-Core Version:    0.7.0.1
 */