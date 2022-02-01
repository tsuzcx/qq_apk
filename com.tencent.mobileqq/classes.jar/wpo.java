import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import java.util.List;

public class wpo
  extends wia<wly>
{
  protected ImageView a;
  protected TextView a;
  protected RotateCircleImageView a;
  protected ImageView b;
  protected TextView b;
  protected ImageView c = (ImageView)a(2131376380);
  
  public wpo(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView = ((RotateCircleImageView)a(2131364637));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368071));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131378363));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379001));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131376381));
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
  
  public void a(wly paramwly)
  {
    if ((paramwly.a != null) && (!paramwly.a.isEmpty())) {
      a(paramwly.a.size(), paramwly.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpo
 * JD-Core Version:    0.7.0.1
 */