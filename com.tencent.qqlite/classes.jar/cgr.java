import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.List;

public class cgr
  extends BaseAdapter
{
  private cgr(ContactListView paramContactListView) {}
  
  public int getCount()
  {
    if (this.a.b == null) {
      return 0;
    }
    return this.a.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.a();
      paramViewGroup.setOnClickListener(this.a);
    }
    paramView = (PhoneContact)this.a.b.get(paramInt);
    ContactListView.a(this.a, paramViewGroup, paramView);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgr
 * JD-Core Version:    0.7.0.1
 */