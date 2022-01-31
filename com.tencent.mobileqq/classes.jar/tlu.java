import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import java.util.List;

public class tlu
  extends vpv
{
  public static final String KEY = "PlayerCommentEmptySegment";
  private View jdField_a_of_type_AndroidViewView;
  private tlj jdField_a_of_type_Tlj;
  public ucw a;
  private boolean b = true;
  
  public tlu(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Tlj == null) || (this.jdField_a_of_type_Tlj.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Ucw == null) || (this.jdField_a_of_type_Ucw.a(b()).size() == 0))) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return paramunw.a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "PlayerCommentEmptySegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495737, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131303838);
    if (QQStoryContext.a()) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100756));
    }
    return new unw(paramViewGroup);
  }
  
  public void a(tlj paramtlj)
  {
    this.jdField_a_of_type_Tlj = paramtlj;
  }
  
  public void a(ucw paramucw)
  {
    this.jdField_a_of_type_Ucw = paramucw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlu
 * JD-Core Version:    0.7.0.1
 */