import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class vne
  extends xrg
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private final int jdField_a_of_type_Int;
  private wph jdField_a_of_type_Wph;
  
  public vne(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    return paramwph.a();
  }
  
  public String a()
  {
    return "EmptyPlaceHolderSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (QQStoryContext.a()) {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166396));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wph = new wph(paramViewGroup);
      return this.jdField_a_of_type_Wph;
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165508));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vne
 * JD-Core Version:    0.7.0.1
 */