import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abfy
  extends abeg
{
  XListView K;
  abfy.a a;
  protected String aZM;
  QQAppInterface app;
  protected TroopManager b;
  protected boolean bCi;
  Context context;
  protected View.OnClickListener eL = new abga(this);
  acnd j = new abfz(this);
  protected List<abfy.b> vH = new ArrayList();
  protected List<Entity> vV = new ArrayList();
  List<ShowExternalTroop> vW;
  protected boolean xv;
  
  public abfy(Context paramContext, QQAppInterface paramQQAppInterface, abfy.a parama, XListView paramXListView, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.app = paramQQAppInterface;
    this.a = parama;
    this.context = paramContext;
    this.K = paramXListView;
    this.xv = paramBoolean;
    this.aZM = paramString;
    this.b = ((TroopManager)paramQQAppInterface.getManager(52));
    paramQQAppInterface.addObserver(this.j);
  }
  
  public void destroy()
  {
    this.app.removeObserver(this.j);
    super.destroy();
  }
  
  public int getCount()
  {
    return this.vH.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.vH.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((!this.xv) && (!this.bCi) && (this.vH.size() == 0))
    {
      localView = LayoutInflater.from(this.context).inflate(2131560790, null);
      paramView = localView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      abfy.b localb = (abfy.b)getItem(paramInt);
      if (localb == null)
      {
        localView = null;
      }
      else
      {
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getTag() != null) {}
        }
        else
        {
          localView = joa.a(this.context, paramViewGroup, 5, false, 1);
          localView.setOnClickListener(this.eL);
        }
        paramView = (aozz.a)localView.getTag();
        paramView.type = 4;
        ShowExternalTroop localShowExternalTroop = localb.a;
        joa.a(localView, this.context, localShowExternalTroop);
        paramView.aar.setVisibility(8);
        paramView.uin = localb.a.troopUin;
        paramView.pQ.setImageBitmap(a(4, localShowExternalTroop.troopUin));
        paramView = localView;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    if (this.vW != null)
    {
      this.vH.clear();
      if (!this.vW.isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.vW.iterator();
        while (localIterator.hasNext())
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localIterator.next();
          this.vH.add(new abfy.b(1, localShowExternalTroop));
        }
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void setData(List<ShowExternalTroop> paramList)
  {
    this.bCi = true;
    if (paramList != null)
    {
      this.vW = paramList;
      notifyDataSetChanged();
    }
  }
  
  public static abstract interface a
  {
    public abstract void zn(String paramString);
  }
  
  public static class b
  {
    public ShowExternalTroop a;
    public int itemType;
    
    public b(int paramInt, ShowExternalTroop paramShowExternalTroop)
    {
      this.itemType = paramInt;
      this.a = paramShowExternalTroop;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfy
 * JD-Core Version:    0.7.0.1
 */