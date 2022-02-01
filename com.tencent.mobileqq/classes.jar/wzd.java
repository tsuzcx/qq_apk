import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;
import java.util.List;

public class wzd
  extends wro<wvn>
{
  protected ImageView a;
  protected TextView a;
  protected RotateCircleImageView a;
  protected ImageView b;
  protected TextView b;
  protected ImageView c = (ImageView)a(2131376367);
  
  public wzd(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetRotateCircleImageView = ((RotateCircleImageView)a(2131364534));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367903));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131378306));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378936));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131376368));
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
  
  public void a(wvn paramwvn)
  {
    if ((paramwvn.a != null) && (!paramwvn.a.isEmpty())) {
      a(paramwvn.a.size(), paramwvn.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzd
 * JD-Core Version:    0.7.0.1
 */