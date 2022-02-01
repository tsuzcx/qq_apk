import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class zcy
  extends zie
{
  public View a(Context paramContext, View paramView, blfl paramblfl, int paramInt)
  {
    paramblfl.a = new blfm[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      paramblfl.a[paramInt] = new blfm();
      paramblfl.a[paramInt].jdField_a_of_type_Int = -1;
      paramblfl.a[paramInt].c = 0;
      paramblfl.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    paramblfl.g = paramView.findViewById(2131369788);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, blfm[] paramArrayOfblfm)
  {
    paramArrayOfblfm[0].jdField_a_of_type_Int = 0;
    paramArrayOfblfm[0].b = 0;
    paramArrayOfblfm[1].jdField_a_of_type_Int = -1;
    paramArrayOfblfm[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfblfm[1].jdField_a_of_type_Int = 1;
      paramArrayOfblfm[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, blfm paramblfm, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(paramblfm.c, paramblfm.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = paramblfm.c;
      localLayoutParams.height = paramblfm.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcy
 * JD-Core Version:    0.7.0.1
 */