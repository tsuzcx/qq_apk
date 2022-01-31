import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.util.FaceDrawable;

public class vuz
  extends FriendListObserver
{
  public vuz(PublicAccountChatPie paramPublicAccountChatPie, ImageView paramImageView) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a().a))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a, paramString, (byte)3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuz
 * JD-Core Version:    0.7.0.1
 */