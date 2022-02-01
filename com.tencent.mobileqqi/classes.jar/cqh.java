import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.activity.BaseHornListActivity;
import com.tencent.mobileqq.activity.BaseHornListActivity.BaseHornAdapter;
import com.tencent.mobileqq.activity.HornListActivity;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;

public class cqh
  extends BaseHornListActivity.BaseHornAdapter
{
  private cqh(HornListActivity paramHornListActivity)
  {
    super(paramHornListActivity);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    Object localObject;
    switch (super.getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityHornListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903675, paramViewGroup, false);
        paramViewGroup = new bwo();
        paramView.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)paramView.findViewById(2131233362));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setSpannableFactory(QQText.a);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233363));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131233361));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131233359));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233364));
      }
      for (;;)
      {
        localObject = (HornDetail)super.getItem(paramInt);
        paramViewGroup.jdField_a_of_type_JavaLangString = ((HornDetail)localObject).uin;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(((HornDetail)localObject).content, TextView.BufferType.SPANNABLE);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((HornDetail)localObject).distance + " ").append(((HornDetail)localObject).time);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
        paramViewGroup.b.setText(((HornDetail)localObject).nickName);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("" + ((HornDetail)localObject).commentCnt);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("查看该喇叭评论内容");
        this.jdField_a_of_type_ComTencentMobileqqActivityHornListActivity.jdField_a_of_type_ComTencentMobileqqActivityBaseHornListActivity.a(paramViewGroup.jdField_a_of_type_JavaLangString, 0, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new cqi(this, (HornDetail)localObject));
        return paramView;
        paramViewGroup = (bwo)paramView.getTag();
      }
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityHornListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903283, null);
      paramViewGroup = new bwo();
      paramView.setTag(paramViewGroup);
      paramViewGroup.d = ((TextView)paramView.findViewById(2131231868));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131231066));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231867));
      ((LinearLayout)paramView).setOrientation(0);
      localObject = paramViewGroup.d;
      if (!this.jdField_a_of_type_Boolean) {
        break label487;
      }
      paramInt = 2131562334;
      label427:
      ((TextView)localObject).setText(paramInt);
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label493;
      }
      paramInt = 0;
      label448:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.jdField_c_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label499;
      }
    }
    label487:
    label493:
    label499:
    for (paramInt = i;; paramInt = 0)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramView;
      paramViewGroup = (bwo)paramView.getTag();
      break;
      paramInt = 2131562926;
      break label427;
      paramInt = 8;
      break label448;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqh
 * JD-Core Version:    0.7.0.1
 */