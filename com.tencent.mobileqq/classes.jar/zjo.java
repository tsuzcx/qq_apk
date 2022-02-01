import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class zjo
  extends zqf
{
  public View a(Context paramContext, View paramView, bkot parambkot, int paramInt)
  {
    parambkot.a = new bkou[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      parambkot.a[paramInt] = new bkou();
      parambkot.a[paramInt].jdField_a_of_type_Int = -1;
      parambkot.a[paramInt].c = 0;
      parambkot.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    parambkot.g = paramView.findViewById(2131369536);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, bkou[] paramArrayOfbkou)
  {
    paramArrayOfbkou[0].jdField_a_of_type_Int = 0;
    paramArrayOfbkou[0].b = 0;
    paramArrayOfbkou[1].jdField_a_of_type_Int = -1;
    paramArrayOfbkou[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfbkou[1].jdField_a_of_type_Int = 1;
      paramArrayOfbkou[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, bkou parambkou, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(parambkou.c, parambkou.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambkou.c;
      localLayoutParams.height = parambkou.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjo
 * JD-Core Version:    0.7.0.1
 */