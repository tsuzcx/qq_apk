import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import java.util.ArrayList;

public class wqv
  extends PinnedDividerListView.DividerAdapter
{
  private wqv(ContactListView paramContactListView) {}
  
  public int a()
  {
    return 2130969165;
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.a.a == null) || (this.a.a.isEmpty()) || (paramInt < 0) || (paramInt >= this.a.a.size())) {
      return;
    }
    PhoneContact localPhoneContact2 = (PhoneContact)this.a.a.get(paramInt);
    PhoneContact localPhoneContact1 = localPhoneContact2;
    if (localPhoneContact2 == null) {
      localPhoneContact1 = (PhoneContact)this.a.a.get(paramInt + 1);
    }
    ((TextView)paramView).setText(localPhoneContact1.pinyinFirst);
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 1;
  }
  
  public int getCount()
  {
    if (this.a.a != null) {
      return this.a.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.a.a.get(paramInt) == null) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(this.a.getContext()).inflate(a(), paramViewGroup, false);
      }
      a(localView, paramInt);
      return localView;
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.a();
      paramViewGroup.setOnClickListener(this.a);
    }
    paramView = (PhoneContact)this.a.a.get(paramInt);
    this.a.a(paramViewGroup, paramView, false);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqv
 * JD-Core Version:    0.7.0.1
 */