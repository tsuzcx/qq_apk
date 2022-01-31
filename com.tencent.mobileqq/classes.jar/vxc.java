import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class vxc
  extends wdt
{
  public View a(Context paramContext, View paramView, bfwe parambfwe, int paramInt)
  {
    parambfwe.a = new bfwf[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      parambfwe.a[paramInt] = new bfwf();
      parambfwe.a[paramInt].jdField_a_of_type_Int = -1;
      parambfwe.a[paramInt].c = 0;
      parambfwe.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    parambfwe.g = paramView.findViewById(2131368899);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, bfwf[] paramArrayOfbfwf)
  {
    paramArrayOfbfwf[0].jdField_a_of_type_Int = 0;
    paramArrayOfbfwf[0].b = 0;
    paramArrayOfbfwf[1].jdField_a_of_type_Int = -1;
    paramArrayOfbfwf[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfbfwf[1].jdField_a_of_type_Int = 1;
      paramArrayOfbfwf[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, bfwf parambfwf, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(parambfwf.c, parambfwf.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambfwf.c;
      localLayoutParams.height = parambfwf.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxc
 * JD-Core Version:    0.7.0.1
 */