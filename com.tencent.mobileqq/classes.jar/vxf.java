import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class vxf
  extends wdw
{
  public View a(Context paramContext, View paramView, bfvn parambfvn, int paramInt)
  {
    parambfvn.a = new bfvo[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      parambfvn.a[paramInt] = new bfvo();
      parambfvn.a[paramInt].jdField_a_of_type_Int = -1;
      parambfvn.a[paramInt].c = 0;
      parambfvn.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    parambfvn.g = paramView.findViewById(2131368899);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, bfvo[] paramArrayOfbfvo)
  {
    paramArrayOfbfvo[0].jdField_a_of_type_Int = 0;
    paramArrayOfbfvo[0].b = 0;
    paramArrayOfbfvo[1].jdField_a_of_type_Int = -1;
    paramArrayOfbfvo[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfbfvo[1].jdField_a_of_type_Int = 1;
      paramArrayOfbfvo[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, bfvo parambfvo, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(parambfvo.c, parambfvo.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = parambfvo.c;
      localLayoutParams.height = parambfvo.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */