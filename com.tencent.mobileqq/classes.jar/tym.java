import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class tym
  extends wco
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private final int jdField_a_of_type_Int;
  private vap jdField_a_of_type_Vap;
  
  public tym(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    return paramvap.a();
  }
  
  public String a()
  {
    return "EmptyPlaceHolderSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (QQStoryContext.a()) {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
    }
    for (;;)
    {
      this.jdField_a_of_type_Vap = new vap(paramViewGroup);
      return this.jdField_a_of_type_Vap;
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165473));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tym
 * JD-Core Version:    0.7.0.1
 */