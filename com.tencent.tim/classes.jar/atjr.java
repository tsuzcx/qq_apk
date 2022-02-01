import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class atjr
  extends atjv
{
  public static atiw a;
  private static int[] aq = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299263), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299264) };
  public static atiw b;
  public static atiw c;
  public static atiw d;
  public static atiw e;
  public static atiw f;
  public static atiw g;
  public static atiw h;
  public static atiw i;
  public static atiw j;
  public static atiw k;
  public static atiw l;
  private atjr.a a;
  protected auve b;
  private View.OnClickListener fR = new atjs(this);
  protected int mode = 0;
  
  static
  {
    jdField_a_of_type_Atiw = new atiw(0, 2131364769, 2131691636, 2130839768);
    jdField_b_of_type_Atiw = new atiw(0, 2131364767, 2131691606, 2130839769);
    c = new atiw(0, 2131364770, 2131691642, 2130839770);
    d = new atiw(0, 2131364768, 2131691631, 2130839768);
    e = new atiw(1, 2131364772, 2131691655, 2130839768);
    f = new atiw(0, 2131364774, 2131691639, 2130839768);
    g = new atiw(1, 2131364775, 2131691640, 2130839768);
    h = new atiw(0, 2131364773, 2131691638, 2130839770);
    i = new atiw(1, 2131364771, 2131691637, 2130839768);
    j = new atiw(0, 2131364764, 2131691633, 2130839768);
    k = new atiw(1, 2131364766, 2131691635, 2130839768);
    l = new atiw(1, 2131364765, 2131691634, 2130839768);
  }
  
  public atjr(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  private auve a()
  {
    if (this.jdField_b_of_type_Auve != null) {
      return this.jdField_b_of_type_Auve;
    }
    ArrayList localArrayList = new ArrayList(gt());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Atiw);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int m = 0;
    while (m < localArrayList.size())
    {
      atiw localatiw = (atiw)localArrayList.get(m);
      arrayOfInt1[m] = localatiw.hF();
      arrayOfInt2[m] = localatiw.KB();
      arrayOfInt3[m] = localatiw.KC();
      arrayOfInt4[m] = localatiw.KA();
      m += 1;
    }
    this.jdField_b_of_type_Auve = new atjt(this, localArrayList.size(), 2, aq, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_b_of_type_Auve;
  }
  
  private void c(atiu paramatiu)
  {
    ausj localausj = (ausj)auss.a(this.context, null);
    List localList = a(paramatiu);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      atiw localatiw = (atiw)localIterator.next();
      localausj.addButton(this.context.getResources().getString(localatiw.KB()), 1);
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new atju(this, localList, paramatiu, localausj));
    localausj.show();
  }
  
  public final View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, atdt.a parama, boolean paramBoolean3, int paramInt2)
  {
    auve localauve = a();
    if (paramView == null)
    {
      paramView = new auvd.a();
      paramViewGroup = a(paramInt1, paramatiu, paramView.Lz, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localauve.a(this.context, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localauve.a(this.context, paramView, paramInt1, paramatiu, paramViewGroup, this.fR);
      paramView.setEnabled(false);
      return paramView;
      parama = (auvd.a)paramView.getTag();
      a(paramInt1, paramatiu, parama.Lz, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = parama;
    }
  }
  
  public abstract View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
  
  public abstract List<atiw> a(atiu paramatiu);
  
  public void a(atjr.a parama)
  {
    this.jdField_a_of_type_Atjr$a = parama;
  }
  
  public abstract List<atiw> gt();
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, atiu paramatiu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjr
 * JD-Core Version:    0.7.0.1
 */