import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.SearchViewHolder;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import java.util.List;

public class dxu
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public dxu(TroopMemberListActivity paramTroopMemberListActivity, List paramList)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemberListActivity.a, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localATroopMember != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
    }
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopMemberListActivity.ATroopMember localATroopMember;
    if (paramView == null)
    {
      paramView = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).inflate(2130904036, paramViewGroup, false);
      paramViewGroup = new TroopMemberListActivity.SearchViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232618));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231565));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231567));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231411));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131234625));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131234626));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131234623));
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup, (Button)paramView.findViewById(2131234627));
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup, (RelativeLayout)paramView.findViewById(2131234622));
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup, (ShaderAnimLayout)paramView.findViewById(2131230987));
      paramView.setTag(paramViewGroup);
      localATroopMember = (TroopMemberListActivity.ATroopMember)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localATroopMember.jdField_a_of_type_JavaLangString));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localATroopMember.b);
      paramViewGroup.jdField_a_of_type_JavaLangString = localATroopMember.jdField_a_of_type_JavaLangString;
      paramViewGroup.b.setText("");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.h != 1) {
        break label546;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131562357) + paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup).setTag(localATroopMember.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localATroopMember.jdField_a_of_type_JavaLangString);
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup).setOnClickListener(new dxv(this, localATroopMember));
      if ((TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == null) || (localATroopMember.jdField_a_of_type_JavaLangString.equals(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).ownerUin))) {
        break label496;
      }
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup).setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131561927));
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131561860));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
      if ((TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == 0L) || (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != Long.parseLong(localATroopMember.jdField_a_of_type_JavaLangString))) {
        break label508;
      }
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup).b();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839713);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.c = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      return paramView;
      paramViewGroup = (TroopMemberListActivity.SearchViewHolder)paramView.getTag();
      break;
      label496:
      TroopMemberListActivity.SearchViewHolder.a(paramViewGroup).setVisibility(8);
    }
    label508:
    if (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) == 0L) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.c = null;
    }
    TroopMemberListActivity.SearchViewHolder.a(paramViewGroup).c();
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839712);
    return paramView;
    label546:
    if (localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j))
    {
      paramViewGroup.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131562580));
      paramViewGroup.d.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) {
      if ((localATroopMember.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j)) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j)) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.j != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k.contains(localATroopMember.jdField_a_of_type_JavaLangString))))
      {
        paramViewGroup.d.clearAnimation();
        paramViewGroup.d.setVisibility(8);
      }
    }
    for (;;)
    {
      paramViewGroup.d.setTag(localATroopMember.jdField_a_of_type_JavaLangString);
      paramViewGroup.d.setOnClickListener(new dxw(this, localATroopMember));
      return paramView;
      paramViewGroup.d.setVisibility(0);
      continue;
      paramViewGroup.d.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxu
 * JD-Core Version:    0.7.0.1
 */