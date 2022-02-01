import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qphone.base.util.QLog;

public class afug
  extends afsr
{
  public afug(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  protected void as(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (ExtendFriendCampusFragment.a(this.this$0) != null)) {
      ExtendFriendCampusFragment.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afug
 * JD-Core Version:    0.7.0.1
 */