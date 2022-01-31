import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cannon.Visitor;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import java.util.List;

public class wk
  implements AdapterView.OnItemClickListener
{
  public wk(AddFriendActivity paramAddFriendActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (Visitor)this.a.a.get(paramInt);
    paramAdapterView = (FriendManager)this.a.app.getManager(8);
    String str = String.valueOf(paramView.uin);
    if (paramAdapterView.b(str)) {}
    for (paramAdapterView = new ProfileActivity.AllInOne(str, 1);; paramAdapterView = new ProfileActivity.AllInOne(str, 4))
    {
      paramAdapterView.h = paramView.name;
      ProfileActivity.b(this.a, paramAdapterView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wk
 * JD-Core Version:    0.7.0.1
 */