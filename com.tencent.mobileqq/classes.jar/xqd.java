import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class xqd
  extends xwu
{
  public View a(Context paramContext, View paramView, bibi parambibi, int paramInt)
  {
    parambibi.a = new bibj[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      parambibi.a[paramInt] = new bibj();
      parambibi.a[paramInt].jdField_a_of_type_Int = -1;
      parambibi.a[paramInt].c = 0;
      parambibi.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    parambibi.g = paramView.findViewById(2131369147);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, bibj[] paramArrayOfbibj)
  {
    paramArrayOfbibj[0].jdField_a_of_type_Int = 0;
    paramArrayOfbibj[0].b = 0;
    paramArrayOfbibj[1].jdField_a_of_type_Int = -1;
    paramArrayOfbibj[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfbibj[1].jdField_a_of_type_Int = 1;
      paramArrayOfbibj[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, bibj parambibj, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(parambibj.c, parambibj.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambibj.c;
      localLayoutParams.height = parambibj.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqd
 * JD-Core Version:    0.7.0.1
 */