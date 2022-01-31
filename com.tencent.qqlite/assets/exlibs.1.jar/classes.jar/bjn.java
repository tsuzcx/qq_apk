import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;

public class bjn
  extends FacePreloadBaseAdapter
{
  public bjn(SetTroopAdminsActivity paramSetTroopAdminsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = ((SetTroopAdminsActivity.TroopAdmin)getItem(paramInt)).jdField_a_of_type_JavaLangString;
    localFaceInfo.jdField_a_of_type_Int = 1;
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (SetTroopAdminsActivity.a(this.a) == null) {
      return 0;
    }
    return SetTroopAdminsActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return SetTroopAdminsActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return super.getItemId(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903678, SetTroopAdminsActivity.a(this.a), false);
      paramView = new bjp(null);
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298900));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296879));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131298898);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem = ((TroopMemberListSlideItem)paramViewGroup);
      paramView.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131298901);
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_b_of_type_AndroidViewView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.setTag(paramView);
    }
    paramView = (bjp)paramViewGroup.getTag();
    SetTroopAdminsActivity.TroopAdmin localTroopAdmin = (SetTroopAdminsActivity.TroopAdmin)SetTroopAdminsActivity.a(this.a).get(paramInt);
    paramView.jdField_a_of_type_JavaLangString = localTroopAdmin.jdField_a_of_type_JavaLangString;
    paramView.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localTroopAdmin.jdField_a_of_type_JavaLangString));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopAdmin.b);
    paramView.jdField_b_of_type_AndroidViewView.setTag(Integer.valueOf(paramInt));
    paramView.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(paramInt));
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setClickable(true);
      if (this.a.jdField_a_of_type_JavaUtilHashSet.contains(localTroopAdmin.jdField_a_of_type_JavaLangString))
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
        return paramViewGroup;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      return paramViewGroup;
    }
    paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setClickable(false);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjn
 * JD-Core Version:    0.7.0.1
 */