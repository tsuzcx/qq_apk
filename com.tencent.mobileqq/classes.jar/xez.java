import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.widget.AbsListView.LayoutParams;

public class xez
  extends zgz
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private final int jdField_a_of_type_Int;
  private yhc jdField_a_of_type_Yhc;
  
  public xez(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    return paramyhc.a();
  }
  
  public String a()
  {
    return "EmptyPlaceHolderSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (QQStoryContext.a()) {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509));
    }
    for (;;)
    {
      this.jdField_a_of_type_Yhc = new yhc(paramViewGroup);
      return this.jdField_a_of_type_Yhc;
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165559));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xez
 * JD-Core Version:    0.7.0.1
 */