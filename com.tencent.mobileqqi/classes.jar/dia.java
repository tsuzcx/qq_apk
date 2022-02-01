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
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class dia
  extends FacePreloadBaseAdapter
{
  public dia(SetTroopAdminsActivity paramSetTroopAdminsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
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
      paramViewGroup = this.a.getLayoutInflater().inflate(2130904015, SetTroopAdminsActivity.a(this.a), false);
      paramView = new die(null);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131234588));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231410));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131234589));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131234590));
      paramViewGroup.setTag(paramView);
    }
    paramView = (die)paramViewGroup.getTag();
    SetTroopAdminsActivity.TroopAdmin localTroopAdmin = (SetTroopAdminsActivity.TroopAdmin)SetTroopAdminsActivity.a(this.a).get(paramInt);
    paramView.jdField_a_of_type_JavaLangString = localTroopAdmin.jdField_a_of_type_JavaLangString;
    paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localTroopAdmin.jdField_a_of_type_JavaLangString));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopAdmin.b);
    paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramView.b.setVisibility(4);
    if (paramInt == 0)
    {
      paramView.jdField_c_of_type_AndroidWidgetTextView.setText(2131562580);
      paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return paramViewGroup;
    }
    paramView.b.setText(2131561758);
    paramView.b.setVisibility(0);
    paramView.b.setOnClickListener(new dib(this, localTroopAdmin));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dia
 * JD-Core Version:    0.7.0.1
 */