import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class vom
  extends vnz
{
  public ImageView a;
  private voo jdField_a_of_type_Voo;
  private xmj jdField_a_of_type_Xmj;
  
  public vom(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    wsv.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379721));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new vop(this, null));
    this.jdField_a_of_type_Voo = new voo(this, null);
    this.jdField_a_of_type_Xmj = new xmj(a(), this.jdField_a_of_type_Voo);
    this.jdField_a_of_type_Xmj.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vom
 * JD-Core Version:    0.7.0.1
 */