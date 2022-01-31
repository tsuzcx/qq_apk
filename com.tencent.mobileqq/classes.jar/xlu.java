import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class xlu
  extends xsl
{
  public View a(Context paramContext, View paramView, bhxb parambhxb, int paramInt)
  {
    parambhxb.a = new bhxc[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      parambhxb.a[paramInt] = new bhxc();
      parambhxb.a[paramInt].jdField_a_of_type_Int = -1;
      parambhxb.a[paramInt].c = 0;
      parambhxb.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    parambhxb.g = paramView.findViewById(2131369129);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, bhxc[] paramArrayOfbhxc)
  {
    paramArrayOfbhxc[0].jdField_a_of_type_Int = 0;
    paramArrayOfbhxc[0].b = 0;
    paramArrayOfbhxc[1].jdField_a_of_type_Int = -1;
    paramArrayOfbhxc[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfbhxc[1].jdField_a_of_type_Int = 1;
      paramArrayOfbhxc[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, bhxc parambhxc, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(parambhxc.c, parambhxc.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambhxc.c;
      localLayoutParams.height = parambhxc.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xlu
 * JD-Core Version:    0.7.0.1
 */