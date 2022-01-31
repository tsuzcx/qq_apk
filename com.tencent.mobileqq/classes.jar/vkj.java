import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class vkj
  extends vra
{
  public View a(Context paramContext, View paramView, bent parambent, int paramInt)
  {
    parambent.a = new benu[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      parambent.a[paramInt] = new benu();
      parambent.a[paramInt].jdField_a_of_type_Int = -1;
      parambent.a[paramInt].c = 0;
      parambent.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    parambent.g = paramView.findViewById(2131303232);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, benu[] paramArrayOfbenu)
  {
    paramArrayOfbenu[0].jdField_a_of_type_Int = 0;
    paramArrayOfbenu[0].b = 0;
    paramArrayOfbenu[1].jdField_a_of_type_Int = -1;
    paramArrayOfbenu[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfbenu[1].jdField_a_of_type_Int = 1;
      paramArrayOfbenu[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, benu parambenu, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(parambenu.c, parambenu.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambenu.c;
      localLayoutParams.height = parambenu.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkj
 * JD-Core Version:    0.7.0.1
 */