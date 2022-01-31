import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.HashMap;
import java.util.List;

public class ajh
  extends BaseAdapter
{
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = null;
  
  public ajh(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)paramDiscussionInfoCardActivity.app.getManager(8));
  }
  
  public int getCount()
  {
    switch (DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity))
    {
    default: 
      return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size();
    case 0: 
      return 2;
    }
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size()) {
      return null;
    }
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2130903098, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.setFocusable(false);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131296458);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131296456);
    if ((paramInt == getCount() - 1) && ((DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == 0) || (DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == 3000)))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131363649);
      localTextView.setText(paramView);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131427472));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130837722);
      localImageView.setTag(paramView);
    }
    for (;;)
    {
      localImageView.setContentDescription(localTextView.getText());
      localImageView.setOnClickListener(new aji(this));
      return paramViewGroup;
      if (paramInt > getCount() - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130838651);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131427469));
        paramView = (HashMap)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt);
        String str = (String)paramView.get("memberUin");
        Object localObject = (String)paramView.get("memberName");
        if (TextUtils.isEmpty(str))
        {
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localTextView.setText(paramView);
          localImageView.setImageDrawable(ImageUtil.b());
        }
        else
        {
          paramView = (View)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramView = (View)localObject;
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp != null)
            {
              Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.c(str);
              paramView = (View)localObject;
              if (localFriends != null)
              {
                paramView = (View)localObject;
                if (localFriends.isFriend()) {
                  paramView = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.b(str);
                }
              }
            }
          }
          localObject = paramView;
          if (TextUtils.isEmpty(paramView)) {
            localObject = str;
          }
          localTextView.setText((CharSequence)localObject);
          localImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.b(str));
          localImageView.setTag(str);
          localImageView.setTag(2131296421, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ajh
 * JD-Core Version:    0.7.0.1
 */