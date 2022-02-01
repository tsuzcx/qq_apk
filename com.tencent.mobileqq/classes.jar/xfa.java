import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import java.util.List;

public class xfa
  extends zgz
{
  public static final String KEY = "PlayerCommentEmptySegment";
  private View jdField_a_of_type_AndroidViewView;
  private xep jdField_a_of_type_Xep;
  public xwc a;
  private boolean b = true;
  
  public xfa(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Xep == null) || (this.jdField_a_of_type_Xep.a());
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Xwc == null) || (this.jdField_a_of_type_Xwc.a(b()).size() == 0))) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return paramyhc.a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "PlayerCommentEmptySegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561757, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131370478);
    if (QQStoryContext.a()) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509));
    }
    return new yhc(paramViewGroup);
  }
  
  public void a(xep paramxep)
  {
    this.jdField_a_of_type_Xep = paramxep;
  }
  
  public void a(xwc paramxwc)
  {
    this.jdField_a_of_type_Xwc = paramxwc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfa
 * JD-Core Version:    0.7.0.1
 */