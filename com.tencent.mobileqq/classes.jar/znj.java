import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class znj
  extends zua
{
  public View a(Context paramContext, View paramView, blpw paramblpw, int paramInt)
  {
    paramblpw.a = new blpx[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      paramblpw.a[paramInt] = new blpx();
      paramblpw.a[paramInt].jdField_a_of_type_Int = -1;
      paramblpw.a[paramInt].c = 0;
      paramblpw.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    paramblpw.g = paramView.findViewById(2131369629);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, blpx[] paramArrayOfblpx)
  {
    paramArrayOfblpx[0].jdField_a_of_type_Int = 0;
    paramArrayOfblpx[0].b = 0;
    paramArrayOfblpx[1].jdField_a_of_type_Int = -1;
    paramArrayOfblpx[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfblpx[1].jdField_a_of_type_Int = 1;
      paramArrayOfblpx[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, blpx paramblpx, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(paramblpx.c, paramblpx.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = paramblpx.c;
      localLayoutParams.height = paramblpx.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znj
 * JD-Core Version:    0.7.0.1
 */