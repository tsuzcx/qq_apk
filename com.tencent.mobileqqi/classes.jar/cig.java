import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import java.util.List;

public class cig
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public cig(DiscussionMemberActivity paramDiscussionMemberActivity, List paramList)
  {
    super(paramDiscussionMemberActivity, paramDiscussionMemberActivity.b, paramDiscussionMemberActivity.a, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    cid localcid = (cid)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localcid != null)
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = localcid.jdField_a_of_type_JavaLangString;
      localFaceInfo.jdField_a_of_type_Int = 1;
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
    cid localcid;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2130903205, paramViewGroup, false);
      paramViewGroup = new cii(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131231568));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231411));
      paramView.setTag(paramViewGroup);
      localcid = (cid)getItem(paramInt);
      if ((localcid.b != null) && (!"".equals(localcid.b.trim()))) {
        break label144;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localcid.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localcid.jdField_a_of_type_JavaLangString;
      paramViewGroup.c.setImageBitmap(a(1, localcid.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (cii)paramView.getTag();
      break;
      label144:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localcid.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cig
 * JD-Core Version:    0.7.0.1
 */