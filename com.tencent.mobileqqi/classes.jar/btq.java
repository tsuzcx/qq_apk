import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cannon.Visitor;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class btq
  extends BaseAdapter
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new btr(this);
  
  public btq(AddFriendActivity paramAddFriendActivity)
  {
    if (paramAddFriendActivity.a.size() > 8)
    {
      Random localRandom = new Random();
      ArrayList localArrayList = new ArrayList(8);
      int i = 0;
      while (i < 8)
      {
        int j = localRandom.nextInt(paramAddFriendActivity.a.size());
        localArrayList.add(paramAddFriendActivity.a.get(j));
        paramAddFriendActivity.a.remove(j);
        i += 1;
      }
      paramAddFriendActivity.a = localArrayList;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity.a.get(paramInt);
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
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity.getLayoutInflater().inflate(2130903933, null);
      paramView = new bts(null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131232909));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131232911));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    paramView = (bts)paramViewGroup.getTag();
    Visitor localVisitor = (Visitor)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity.a.get(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity.b.b(localVisitor.uin + ""));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localVisitor.name);
    paramView.jdField_a_of_type_Int = paramInt;
    paramViewGroup.setContentDescription("该联系人的昵称为" + localVisitor.name);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     btq
 * JD-Core Version:    0.7.0.1
 */