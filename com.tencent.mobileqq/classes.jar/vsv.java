import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class vsv
  extends vsi
{
  public ImageView a;
  private vsx jdField_a_of_type_Vsx;
  private xqs jdField_a_of_type_Xqs;
  
  public vsv(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    wxe.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379779));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new vsy(this, null));
    this.jdField_a_of_type_Vsx = new vsx(this, null);
    this.jdField_a_of_type_Xqs = new xqs(a(), this.jdField_a_of_type_Vsx);
    this.jdField_a_of_type_Xqs.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsv
 * JD-Core Version:    0.7.0.1
 */