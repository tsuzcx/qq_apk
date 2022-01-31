import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

public class vvk
  extends PublicAccountObserver
{
  public vvk(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(int paramInt)
  {
    this.a.y(paramInt);
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0)
    {
      if ((paramPublicAccountInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramPublicAccountInfo.getUin()))) {
        this.a.b(1);
      }
    }
    else {
      return;
    }
    this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    if ((paramBoolean) && (!PublicAccountChatPie.b(this.a)))
    {
      localObject = (PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localObject == null) {
        break label102;
      }
    }
    label102:
    for (Object localObject = ((PublicAccountDataManager)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      if ((localObject != null) && (this.a.o != null) && (!PublicAccountChatPie.c(this.a))) {
        this.a.aZ();
      }
      return;
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.c(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */