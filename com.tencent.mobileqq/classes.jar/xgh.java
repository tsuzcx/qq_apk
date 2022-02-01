import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class xgh
  extends xfu
{
  public ImageView a;
  private xgj jdField_a_of_type_Xgj;
  private zdn jdField_a_of_type_Zdn;
  
  public xgh(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    ykq.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380988));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new xgk(this, null));
    this.jdField_a_of_type_Xgj = new xgj(this, null);
    this.jdField_a_of_type_Zdn = new zdn(a(), this.jdField_a_of_type_Xgj);
    this.jdField_a_of_type_Zdn.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgh
 * JD-Core Version:    0.7.0.1
 */