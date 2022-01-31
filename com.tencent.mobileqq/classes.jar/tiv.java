import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import java.util.List;

public class tiv
  extends tbg<tff>
{
  protected ImageView a;
  protected TextView a;
  protected RotateCircleImageView a;
  protected ImageView b;
  protected TextView b;
  protected ImageView c = (ImageView)a(2131374983);
  
  public tiv(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView = ((RotateCircleImageView)a(2131364212));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367384));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131376769));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377350));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131374984));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderStyle(RotateCircleImageView.BorderStyle.STILL);
    int[] arrayOfInt = new int[paramInt1];
    int i = 0;
    if (i < paramInt1)
    {
      if (i < paramInt1 - paramInt2) {
        arrayOfInt[i] = Color.parseColor("#DEDFE0");
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt[i] = Color.parseColor("#19D7FD");
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView.setBorderColors(arrayOfInt);
  }
  
  public void a(tff paramtff)
  {
    if ((paramtff.a != null) && (!paramtff.a.isEmpty())) {
      a(paramtff.a.size(), paramtff.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tiv
 * JD-Core Version:    0.7.0.1
 */