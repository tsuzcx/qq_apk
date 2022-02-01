import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class xot
  extends zsv
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private final int jdField_a_of_type_Int;
  private yqw jdField_a_of_type_Yqw;
  
  public xot(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    return paramyqw.a();
  }
  
  public String a()
  {
    return "EmptyPlaceHolderSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (QQStoryContext.a()) {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166476));
    }
    for (;;)
    {
      this.jdField_a_of_type_Yqw = new yqw(paramViewGroup);
      return this.jdField_a_of_type_Yqw;
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165545));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xot
 * JD-Core Version:    0.7.0.1
 */