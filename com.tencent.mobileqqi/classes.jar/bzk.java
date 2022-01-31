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

public class bzk
  implements AdapterView.OnItemClickListener
{
  public bzk(AddFriendActivity paramAddFriendActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (Visitor)this.a.a.get(paramInt);
    paramAdapterView = (FriendManager)this.a.b.getManager(8);
    String str = String.valueOf(paramView.uin);
    if (paramAdapterView.b(str)) {}
    for (paramAdapterView = new ProfileActivity.AllInOne(str, 1);; paramAdapterView = new ProfileActivity.AllInOne(str, 4))
    {
      paramAdapterView.g = paramView.name;
      ProfileActivity.a(this.a, paramAdapterView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bzk
 * JD-Core Version:    0.7.0.1
 */