import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import java.util.List;

public class xou
  extends zsv
{
  public static final String KEY = "PlayerCommentEmptySegment";
  private View jdField_a_of_type_AndroidViewView;
  private xoj jdField_a_of_type_Xoj;
  public yfw a;
  private boolean b = true;
  
  public xou(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Xoj == null) || (this.jdField_a_of_type_Xoj.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Yfw == null) || (this.jdField_a_of_type_Yfw.a(b()).size() == 0))) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return paramyqw.a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "PlayerCommentEmptySegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561811, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131370331);
    if (QQStoryContext.a()) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166476));
    }
    return new yqw(paramViewGroup);
  }
  
  public void a(xoj paramxoj)
  {
    this.jdField_a_of_type_Xoj = paramxoj;
  }
  
  public void a(yfw paramyfw)
  {
    this.jdField_a_of_type_Yfw = paramyfw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xou
 * JD-Core Version:    0.7.0.1
 */