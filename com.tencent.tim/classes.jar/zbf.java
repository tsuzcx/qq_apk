import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

public class zbf
  extends acje
{
  public zbf(PublicAccountFragment paramPublicAccountFragment) {}
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUnfollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.this$0.refreshData();
    }
  }
  
  public void aH(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onUpdateUserFollowList errCode: " + paramInt + " isFinish:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (PublicAccountFragment.a(this.this$0))
      {
        if (PublicAccountFragment.a(this.this$0) != null) {
          PublicAccountFragment.b(this.this$0).d(this.this$0.xZ(), true, null);
        }
        PublicAccountFragment.a(this.this$0, false);
      }
      this.this$0.refreshData();
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "onFollowPublicAccount errCode: " + paramInt);
    }
    if (paramInt == 0) {
      this.this$0.refreshData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbf
 * JD-Core Version:    0.7.0.1
 */