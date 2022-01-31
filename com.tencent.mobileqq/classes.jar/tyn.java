import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import java.util.List;

public class tyn
  extends wco
{
  public static final String KEY = "PlayerCommentEmptySegment";
  private View jdField_a_of_type_AndroidViewView;
  private tyc jdField_a_of_type_Tyc;
  public upp a;
  private boolean b = true;
  
  public tyn(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Tyc == null) || (this.jdField_a_of_type_Tyc.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Upp == null) || (this.jdField_a_of_type_Upp.a(b()).size() == 0))) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return paramvap.a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "PlayerCommentEmptySegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561327, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131369512);
    if (QQStoryContext.a()) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
    }
    return new vap(paramViewGroup);
  }
  
  public void a(tyc paramtyc)
  {
    this.jdField_a_of_type_Tyc = paramtyc;
  }
  
  public void a(upp paramupp)
  {
    this.jdField_a_of_type_Upp = paramupp;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyn
 * JD-Core Version:    0.7.0.1
 */