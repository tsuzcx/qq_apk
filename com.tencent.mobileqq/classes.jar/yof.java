import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class yof
  extends ytl
{
  public View a(Context paramContext, View paramView, bjtz parambjtz, int paramInt)
  {
    parambjtz.a = new bjua[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      parambjtz.a[paramInt] = new bjua();
      parambjtz.a[paramInt].jdField_a_of_type_Int = -1;
      parambjtz.a[paramInt].c = 0;
      parambjtz.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    parambjtz.g = paramView.findViewById(2131369619);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, bjua[] paramArrayOfbjua)
  {
    paramArrayOfbjua[0].jdField_a_of_type_Int = 0;
    paramArrayOfbjua[0].b = 0;
    paramArrayOfbjua[1].jdField_a_of_type_Int = -1;
    paramArrayOfbjua[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfbjua[1].jdField_a_of_type_Int = 1;
      paramArrayOfbjua[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, bjua parambjua, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(parambjua.c, parambjua.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambjua.c;
      localLayoutParams.height = parambjua.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yof
 * JD-Core Version:    0.7.0.1
 */