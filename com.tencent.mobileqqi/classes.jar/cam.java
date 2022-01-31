import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;

public class cam
  implements View.OnClickListener
{
  public cam(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (FriendManager)this.a.b.getManager(8);
    if (paramView != null) {}
    for (boolean bool = paramView.b(AddRequestActivity.a(this.a));; bool = false)
    {
      if (bool)
      {
        paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 1);
        ProfileActivity.a(this.a, paramView);
        return;
      }
      switch (this.a.d)
      {
      default: 
        paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
        ProfileActivity.a(this.a, paramView);
        return;
      case -1011: 
      case -1006: 
      case 1: 
      case 187: 
        paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
        paramView.g = AddRequestActivity.a(this.a);
        paramView.jdField_c_of_type_JavaLangString = String.valueOf(AddRequestActivity.a(this.a));
        ProfileActivity.a(this.a, paramView);
        return;
      }
      paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
      paramView.g = AddRequestActivity.a(this.a);
      paramView.jdField_c_of_type_JavaLangString = String.valueOf(AddRequestActivity.a(this.a));
      paramView.jdField_c_of_type_Int = 1;
      ProfileActivity.a(this.a, paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cam
 * JD-Core Version:    0.7.0.1
 */