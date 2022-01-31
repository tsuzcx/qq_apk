import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ay
  extends BaseAdapter
{
  private az jdField_a_of_type_Az;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131361837, 2130837696 };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.d };
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131363160, 2130837690 };
  private final int[][] jdField_b_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.d, this.e };
  private final int[] jdField_c_of_type_ArrayOfInt = { 2131361838, 2130837700 };
  private int[][] jdField_c_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt;
  private final int[] d = { 2131361839, 2130837698 };
  private final int[] e = { 2131361840, 2130837691 };
  
  private ay(LiteActivity paramLiteActivity) {}
  
  public int[][] a()
  {
    return this.jdField_c_of_type_Array2dOfInt;
  }
  
  public int getCount()
  {
    return this.jdField_c_of_type_Array2dOfInt.length;
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
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getLayoutInflater().inflate(2130903159, null);
    }
    this.jdField_a_of_type_Az = ((az)paramViewGroup.getTag());
    if (this.jdField_a_of_type_Az == null)
    {
      this.jdField_a_of_type_Az = new az(this, null);
      this.jdField_a_of_type_Az.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296763));
      this.jdField_a_of_type_Az.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296764));
    }
    this.jdField_a_of_type_Az.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_Array2dOfInt[paramInt][0]);
    paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(this.jdField_c_of_type_Array2dOfInt[paramInt][1]);
    this.jdField_a_of_type_Az.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
    paramViewGroup.setTag(this.jdField_a_of_type_Az);
    return paramViewGroup;
  }
  
  public void notifyDataSetChanged()
  {
    if ((((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(9)).a() != 0) && (NetworkUtil.g(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity))) {}
    for (this.jdField_c_of_type_Array2dOfInt = this.jdField_b_of_type_Array2dOfInt;; this.jdField_c_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt)
    {
      super.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ay
 * JD-Core Version:    0.7.0.1
 */