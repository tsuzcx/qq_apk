import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class eka
  extends FriendListObserver
{
  public eka(RecommendListView paramRecommendListView) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (!RecommendListView.a(this.a)) {}
    while (!paramBoolean) {
      return;
    }
    RecommendListView.a(this.a);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!RecommendListView.a(this.a)) {}
    while (!paramBoolean) {
      return;
    }
    this.a.jdField_a_of_type_Eke.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!RecommendListView.a(this.a)) {}
    while (!paramBoolean1) {
      return;
    }
    RecommendListView.a(this.a);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (!RecommendListView.a(this.a)) {}
    while ((!paramBoolean) || (paramString == null)) {
      return;
    }
    Drawable localDrawable = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, (byte)3);
    this.a.jdField_a_of_type_Eke.a(paramString, localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eka
 * JD-Core Version:    0.7.0.1
 */