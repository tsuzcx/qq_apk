import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomSingleChoiceDialog;

public class eva
  extends BaseAdapter
{
  public eva(QQCustomSingleChoiceDialog paramQQCustomSingleChoiceDialog) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangCharSequence != null) {
      return this.a.jdField_a_of_type_ArrayOfJavaLangCharSequence.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.a.inflater == null) {
      this.a.inflater = ((LayoutInflater)this.a.getContext().getSystemService("layout_inflater"));
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.inflater.inflate(2130903137, null);
      paramView = new evc(this.a, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296920));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131296921));
      paramViewGroup.setTag(paramView);
    }
    paramView = (evc)paramViewGroup.getTag();
    if (paramView.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_ArrayOfJavaLangCharSequence[paramInt]);
      if (this.a.jdField_a_of_type_Int == paramInt) {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
    else
    {
      return paramViewGroup;
    }
    paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eva
 * JD-Core Version:    0.7.0.1
 */