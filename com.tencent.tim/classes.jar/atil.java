import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class atil
  extends auve
  implements View.OnClickListener
{
  private static int[] aq = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299263), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299264) };
  private List<atiw> Kz;
  private atil.b a;
  private final BaseAdapter adapter;
  
  private atil(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, List<atiw> paramList, BaseAdapter paramBaseAdapter)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
    this.Kz = paramList;
    this.adapter = paramBaseAdapter;
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, auvd.a parama)
  {
    return super.a(paramContext, paramView, paramInt, paramObject, parama, this);
  }
  
  public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
  {
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {}
    for (;;)
    {
      return;
      if (this.Kz != null)
      {
        if (this.a != null) {
          this.a.a(paramInt, paramObject, Collections.unmodifiableList(this.Kz));
        }
        int i = 0;
        paramInt = 0;
        int j = paramInt;
        if (i < this.Kz.size())
        {
          if ((i < paramArrayOfb.length) && (((atiw)this.Kz.get(i)).isVisible()))
          {
            paramArrayOfb[paramInt].dOf = i;
            paramArrayOfb[paramInt].dOe = 0;
            j = paramInt + 1;
          }
          for (;;)
          {
            ((atiw)this.Kz.get(i)).setVisible(true);
            i += 1;
            paramInt = j;
            break;
            j = paramInt;
            if (i >= paramArrayOfb.length)
            {
              j = paramInt;
              if (QLog.isColorLevel())
              {
                QLog.i(this.TAG, 2, "menuList and menu array misMatch");
                j = paramInt;
              }
            }
          }
        }
        while (j < paramArrayOfb.length)
        {
          paramArrayOfb[j].dOf = -1;
          paramArrayOfb[j].dOe = -1;
          j += 1;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(-1);
    Object localObject2 = paramView.getTag(-2);
    int i = ((Integer)localObject1).intValue();
    ((Integer)localObject2).intValue();
    localObject1 = this.adapter.getItem(i);
    localObject2 = this.Kz.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      atiw localatiw = (atiw)((Iterator)localObject2).next();
      if ((paramView.getId() == localatiw.hF()) && (localatiw.a() != null)) {
        localatiw.a().b(i, localObject1, paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static class a
  {
    private static String TAG = a.class.getSimpleName();
    private List<atiw> Kz;
    private BaseAdapter adapter;
    
    public a(List<atiw> paramList, BaseAdapter paramBaseAdapter)
    {
      if (paramList != null) {}
      for (this.Kz = paramList;; this.Kz = new ArrayList())
      {
        this.adapter = paramBaseAdapter;
        return;
      }
    }
    
    public a a(atiw.a parama)
    {
      if (this.Kz == null) {
        this.Kz = new ArrayList();
      }
      int i = 0;
      while (i < this.Kz.size())
      {
        if (((atiw)this.Kz.get(i)).hF() == 2131364767)
        {
          ((atiw)this.Kz.get(i)).a(parama);
          return this;
        }
        i += 1;
      }
      atiw localatiw = new atiw(0, 2131364767, 2131691606, 2130839769);
      localatiw.a(parama);
      this.Kz.add(localatiw);
      return this;
    }
    
    public atil a()
    {
      int[] arrayOfInt1 = new int[this.Kz.size()];
      int[] arrayOfInt2 = new int[this.Kz.size()];
      int[] arrayOfInt3 = new int[this.Kz.size()];
      int i = 0;
      while (i < this.Kz.size())
      {
        atiw localatiw = (atiw)this.Kz.get(i);
        arrayOfInt1[i] = localatiw.hF();
        arrayOfInt2[i] = localatiw.KB();
        arrayOfInt3[i] = localatiw.KC();
        i += 1;
      }
      return new atil(this.Kz.size(), 2, atil.p(), -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, this.Kz, this.adapter, null);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, Object paramObject, List<atiw> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atil
 * JD-Core Version:    0.7.0.1
 */