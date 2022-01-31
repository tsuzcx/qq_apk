import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import java.util.ArrayList;

public class cgy
  extends PinnedDividerListView.DividerAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  private cgy(ContactListView paramContactListView) {}
  
  public int a()
  {
    return 2130903259;
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.a.a == null) || (this.a.a.size() <= 0)) {}
    PhoneContact localPhoneContact1;
    do
    {
      return;
      PhoneContact localPhoneContact2 = (PhoneContact)this.a.a.get(paramInt);
      localPhoneContact1 = localPhoneContact2;
      if (localPhoneContact2 == null) {
        localPhoneContact1 = (PhoneContact)this.a.a.get(paramInt + 1);
      }
      paramView = (TextView)paramView;
      paramView.setText(localPhoneContact1.pinyinFirst);
      if (localPhoneContact1.pinyinFirst.equals("手机联系人")) {
        paramView.setContentDescription("手机联系人");
      }
      if (localPhoneContact1.pinyinFirst.equals("QQ好友")) {
        paramView.setContentDescription("QQ好友");
      }
    } while (!localPhoneContact1.pinyinFirst.equals("未启用通讯录的联系人"));
    paramView.setContentDescription("未启用通讯录的联系人");
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 1;
  }
  
  public int getCount()
  {
    return this.a.l;
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
    if ((this.a.a == null) || (this.a.a.size() <= 0)) {}
    while (this.a.a.get(paramInt) == null) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(a(), null);
      }
      a(paramViewGroup, paramInt);
      return paramViewGroup;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgy
 * JD-Core Version:    0.7.0.1
 */