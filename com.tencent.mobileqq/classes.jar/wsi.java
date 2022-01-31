import com.tencent.mobileqq.activity.contacts.base.CardController;
import com.tencent.mobileqq.activity.contacts.base.ExtendFriendController;
import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;

public class wsi
  extends ExtendFriendObserver
{
  public wsi(ExtendFriendController paramExtendFriendController) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      if (!ExtendFriendController.a(this.a).a(0)) {
        ExtendFriendController.a(this.a);
      }
    }
    while (!ExtendFriendController.a(this.a).a(0)) {
      return;
    }
    ExtendFriendController.a(this.a).a(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsi
 * JD-Core Version:    0.7.0.1
 */