import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import java.util.List;

public class ajw
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public ajw(DiscussionMemberActivity paramDiscussionMemberActivity, List paramList)
  {
    super(paramDiscussionMemberActivity, paramDiscussionMemberActivity.app, paramDiscussionMemberActivity.a, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    ajt localajt = (ajt)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localajt != null)
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = localajt.jdField_a_of_type_JavaLangString;
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
    ajt localajt;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2130903177, paramViewGroup, false);
      paramViewGroup = new ajy(null);
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131297011));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296876));
      paramView.setTag(paramViewGroup);
      localajt = (ajt)getItem(paramInt);
      if ((localajt.b != null) && (!"".equals(localajt.b.trim()))) {
        break label144;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localajt.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localajt.jdField_a_of_type_JavaLangString;
      paramViewGroup.b.setImageBitmap(a(1, localajt.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (ajy)paramView.getTag();
      break;
      label144:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localajt.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ajw
 * JD-Core Version:    0.7.0.1
 */