import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class tlt
  extends vpv
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private final int jdField_a_of_type_Int;
  private unw jdField_a_of_type_Unw;
  
  public tlt(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    return paramunw.a();
  }
  
  public String a()
  {
    return "EmptyPlaceHolderSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (QQStoryContext.a()) {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100756));
    }
    for (;;)
    {
      this.jdField_a_of_type_Unw = new unw(paramViewGroup);
      return this.jdField_a_of_type_Unw;
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099888));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlt
 * JD-Core Version:    0.7.0.1
 */