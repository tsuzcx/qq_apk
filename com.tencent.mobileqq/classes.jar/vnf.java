import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import java.util.List;

public class vnf
  extends xrg
{
  public static final String KEY = "PlayerCommentEmptySegment";
  private View jdField_a_of_type_AndroidViewView;
  private vmu jdField_a_of_type_Vmu;
  public weh a;
  private boolean b = true;
  
  public vnf(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Vmu == null) || (this.jdField_a_of_type_Vmu.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Weh == null) || (this.jdField_a_of_type_Weh.a(b()).size() == 0))) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return paramwph.a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "PlayerCommentEmptySegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561517, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131369774);
    if (QQStoryContext.a()) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166396));
    }
    return new wph(paramViewGroup);
  }
  
  public void a(vmu paramvmu)
  {
    this.jdField_a_of_type_Vmu = paramvmu;
  }
  
  public void a(weh paramweh)
  {
    this.jdField_a_of_type_Weh = paramweh;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnf
 * JD-Core Version:    0.7.0.1
 */