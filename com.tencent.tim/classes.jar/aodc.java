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

public abstract class aodc
  extends aodg
{
  public static aoeg a;
  private static int[] aq = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299263), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299264) };
  public static aoeg b;
  public static aoeg c;
  private aodc.a a;
  protected auve b;
  private View.OnClickListener fR = new aodd(this);
  protected int mode = 0;
  
  static
  {
    jdField_a_of_type_Aoeg = new aoeg(0, 2131364769, 2131691636, 2130839768);
    jdField_b_of_type_Aoeg = new aoeg(0, 2131364767, 2131691606, 2130839769);
    c = new aoeg(0, 2131364773, 2131691638, 2130839770);
  }
  
  public aodc(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
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
      localArrayList.add(0, jdField_a_of_type_Aoeg);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      aoeg localaoeg = (aoeg)localArrayList.get(i);
      arrayOfInt1[i] = localaoeg.hF();
      arrayOfInt2[i] = localaoeg.KB();
      arrayOfInt3[i] = localaoeg.KC();
      arrayOfInt4[i] = localaoeg.KA();
      i += 1;
    }
    this.jdField_b_of_type_Auve = new aode(this, localArrayList.size(), 2, aq, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_b_of_type_Auve;
  }
  
  private void a(aoef paramaoef)
  {
    ausj localausj = (ausj)auss.a(this.context, null);
    List localList = a(paramaoef);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      aoeg localaoeg = (aoeg)localIterator.next();
      localausj.addButton(this.context.getResources().getString(localaoeg.KB()), 1);
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new aodf(this, localList, paramaoef, localausj));
    localausj.show();
  }
  
  public final View a(int paramInt1, aoef paramaoef, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    auve localauve = a();
    if (paramView == null)
    {
      paramView = new auvd.a();
      paramViewGroup = b(paramInt1, paramaoef, paramView.Lz, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localauve.a(this.context, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localauve.a(this.context, paramView, paramInt1, paramaoef, paramViewGroup, this.fR);
      paramView.setEnabled(false);
      return paramView;
      auvd.a locala = (auvd.a)paramView.getTag();
      b(paramInt1, paramaoef, locala.Lz, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = locala;
    }
  }
  
  public abstract List<aoeg> a(aoef paramaoef);
  
  public void a(aodc.a parama)
  {
    this.jdField_a_of_type_Aodc$a = parama;
  }
  
  public abstract View b(int paramInt1, aoef paramaoef, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
  
  public abstract List<aoeg> gt();
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, aoef paramaoef);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodc
 * JD-Core Version:    0.7.0.1
 */