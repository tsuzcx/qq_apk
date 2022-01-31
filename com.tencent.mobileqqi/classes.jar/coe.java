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

public class coe
  extends BaseAdapter
{
  private FriendsManagerImp jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = null;
  
  public coe(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp = ((FriendsManagerImp)paramDiscussionInfoCardActivity.b.getManager(8));
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
    if (paramInt > DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size()) {
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
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2130903119, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.setFocusable(false);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131231000);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131230940);
    if ((paramInt == getCount() - 1) && ((DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == 0) || (DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == 3000)))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131562251);
      localTextView.setText(paramView);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131362073));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130837784);
      localImageView.setTag(paramView);
    }
    for (;;)
    {
      localImageView.setContentDescription(localTextView.getText());
      localImageView.setOnClickListener(new cof(this));
      return paramViewGroup;
      if (paramInt > getCount() - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130838693);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131362070));
        HashMap localHashMap = (HashMap)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt);
        String str = (String)localHashMap.get("memberUin");
        Object localObject = (String)localHashMap.get("memberName");
        if (TextUtils.isEmpty(str))
        {
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localTextView.setText(paramView);
          localImageView.setImageDrawable(ImageUtil.a());
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
          if (localHashMap.containsKey("faceId")) {
            ((Short)localHashMap.get("faceId")).shortValue();
          }
          localImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.b.b(str));
          localImageView.setTag(str);
          localImageView.setTag(2131230924, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     coe
 * JD-Core Version:    0.7.0.1
 */