import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.data.RecommendContactMsg;
import com.tencent.mobileqq.widget.MotionViewSetter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.HashMap;
import java.util.List;

public class efa
  extends BaseAdapter
{
  public int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = (LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.getContext().getSystemService("layout_inflater");
  private MotionViewSetter jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = null;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  HashMap b = new HashMap();
  
  private efa(RecommendListView paramRecommendListView)
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      ((ImageView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).setImageDrawable(paramDrawable);
      return;
    }
    notifyDataSetChanged();
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendContactMsg localRecommendContactMsg;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903932, paramViewGroup, false);
      paramViewGroup = new efb();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231772));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233361));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131232839));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131234361));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131234362));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131230987));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131230988));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataRecommendContactMsg = ((RecommendContactMsg)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_JavaUtilList.get(paramInt));
      localRecommendContactMsg = paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataRecommendContactMsg;
      if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView) == 0)
      {
        if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView) == null) {
          RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView, new eez(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView));
        }
        paramView.setOnClickListener(RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView));
      }
      if ((localRecommendContactMsg.source == null) || (localRecommendContactMsg.source.length() <= 0)) {
        break label508;
      }
      RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView, paramViewGroup, localRecommendContactMsg.uin, 0, 1);
      paramViewGroup.b.setText(localRecommendContactMsg.source);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendContactMsg.nickName);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_JavaLangString = localRecommendContactMsg.uin;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_a_of_type_Long = localRecommendContactMsg.timeStamp;
      }
      if (paramInt > this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_b_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_b_of_type_JavaLangString = localRecommendContactMsg.uin;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.jdField_b_of_type_Long = localRecommendContactMsg.timeStamp;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView;
        ((RecommendListView)localObject).jdField_a_of_type_Int += 1;
      }
      if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView) != 0) {
        break label706;
      }
      if (localRecommendContactMsg.isRead) {
        paramView.setBackgroundResource(2130837850);
      }
      label385:
      if (localRecommendContactMsg.friendStatus != 2) {
        break label726;
      }
      paramViewGroup.d.setVisibility(4);
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText(2131561611);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != paramInt) {
        break label804;
      }
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.b();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter.setMotionView(paramView, paramInt);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = (efb)paramView.getTag();
      break;
      label508:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localRecommendContactMsg.mobileNo))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(localRecommendContactMsg.mobileNo, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView);
        this.b.put(Integer.valueOf(paramView.getId()), localRecommendContactMsg.mobileNo);
      }
      for (;;)
      {
        localObject = localRecommendContactMsg.nationCode + localRecommendContactMsg.mobileCode;
        RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView, paramViewGroup, (String)localObject, 0, 11);
        paramViewGroup.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.getContext().getResources().getString(2131558943));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendContactMsg.contactName);
        break;
        if (this.b.containsKey(Integer.valueOf(paramView.getId())))
        {
          localObject = (String)this.b.get(Integer.valueOf(paramView.getId()));
          if ((localObject != null) && (!((String)localObject).equals(localRecommendContactMsg.mobileNo))) {
            this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
          }
        }
      }
      label706:
      if (RecommendListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView) != 1) {
        break label385;
      }
      paramView.setBackgroundResource(2130837850);
      break label385;
      label726:
      if (localRecommendContactMsg.friendStatus == 1)
      {
        paramViewGroup.d.setVisibility(4);
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(2131561687);
      }
      else
      {
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setTag(localRecommendContactMsg);
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.d.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
      }
    }
    label804:
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.c();
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(null);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efa
 * JD-Core Version:    0.7.0.1
 */