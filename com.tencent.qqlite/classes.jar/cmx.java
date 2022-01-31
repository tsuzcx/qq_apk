import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.ArrayList;

public class cmx
  extends BaseAdapter
{
  private cmx(SelectMemberActivity paramSelectMemberActivity) {}
  
  public int getCount()
  {
    return this.a.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.c.size())) {
      return this.a.c.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SelectMemberActivity.ResultRecord localResultRecord = (SelectMemberActivity.ResultRecord)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903214, null);
    }
    paramViewGroup.setTag(localResultRecord);
    paramView = this.a.app.b(localResultRecord.jdField_a_of_type_JavaLangString);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131296439);
    localImageView.setImageDrawable(paramView);
    if (localResultRecord.jdField_a_of_type_Int == 4)
    {
      paramInt = 11;
      paramView = this.a.a.a(paramInt, localResultRecord.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        break label169;
      }
      this.a.a.a(localResultRecord.jdField_a_of_type_JavaLangString, paramInt, true);
      paramView = this.a.b;
    }
    label169:
    for (;;)
    {
      localImageView.setImageBitmap(paramView);
      localImageView.setContentDescription(localResultRecord.b + " 已选中");
      return paramViewGroup;
      paramInt = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmx
 * JD-Core Version:    0.7.0.1
 */