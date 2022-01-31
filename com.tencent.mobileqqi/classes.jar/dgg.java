import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicAccountActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class dgg
  extends FacePreloadBaseAdapter
{
  public dgg(PublicAccountActivity paramPublicAccountActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public PublicAccountInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.a.size())) {
      return (PublicAccountInfo)this.a.a.get(paramInt);
    }
    return null;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = a(paramInt).getUin();
    return localFaceInfo;
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PublicAccountInfo localPublicAccountInfo;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130903321, paramViewGroup, false);
      paramViewGroup = new dgi();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232077));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231395));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232075));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131232074));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131232076));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131231396));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.a);
      localPublicAccountInfo = a(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = localPublicAccountInfo.getUin();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountInfo;
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localPublicAccountInfo.name);
      if (localPublicAccountInfo.certifiedGrade <= 0L) {
        break label323;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838179);
    }
    for (;;)
    {
      paramViewGroup.d.setText(localPublicAccountInfo.summary);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localPublicAccountInfo.getUin()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.b.setVisibility(8);
      paramView.setContentDescription(localPublicAccountInfo.name + "简介:" + localPublicAccountInfo.summary);
      return paramView;
      paramViewGroup = (dgi)paramView.getTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label323:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgg
 * JD-Core Version:    0.7.0.1
 */