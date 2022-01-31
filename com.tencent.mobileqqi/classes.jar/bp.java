import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;

public class bp
  extends BaseAdapter
{
  private bq jdField_a_of_type_Bq;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131558511, 2130837777 };
  private final int[][] jdField_a_of_type_Array2dOfInt = { this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.c, this.d };
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131561737, 2130837772 };
  private int[][] jdField_b_of_type_Array2dOfInt = this.jdField_a_of_type_Array2dOfInt;
  private final int[] c = { 2131558512, 2130837781 };
  private final int[] d = { 2131558513, 2130837779 };
  
  private bp(LiteActivity paramLiteActivity) {}
  
  public int[][] a()
  {
    return this.jdField_b_of_type_Array2dOfInt;
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_Array2dOfInt.length;
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
      paramViewGroup = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getLayoutInflater().inflate(2130903184, null);
    }
    this.jdField_a_of_type_Bq = ((bq)paramViewGroup.getTag());
    if (this.jdField_a_of_type_Bq == null)
    {
      this.jdField_a_of_type_Bq = new bq(this, null);
      this.jdField_a_of_type_Bq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131231293));
      this.jdField_a_of_type_Bq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231294));
    }
    this.jdField_a_of_type_Bq.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_Array2dOfInt[paramInt][0]);
    paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(this.jdField_b_of_type_Array2dOfInt[paramInt][1]);
    this.jdField_a_of_type_Bq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
    paramViewGroup.setTag(this.jdField_a_of_type_Bq);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bp
 * JD-Core Version:    0.7.0.1
 */