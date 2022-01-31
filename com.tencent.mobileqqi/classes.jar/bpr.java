import android.widget.ImageView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class bpr
  extends FriendListObserver
{
  public bpr(AccountDetailActivity paramAccountDetailActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.a.b))) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpr
 * JD-Core Version:    0.7.0.1
 */