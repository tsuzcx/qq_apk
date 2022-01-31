import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class cuj
  implements AdapterView.OnItemSelectedListener
{
  public cuj(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a_(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    this.a.jdField_a_of_type_AndroidViewView = paramView;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(paramInt);
    this.a.a(paramAdapterView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cuj
 * JD-Core Version:    0.7.0.1
 */