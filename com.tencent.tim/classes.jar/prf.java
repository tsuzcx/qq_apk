import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class prf<T>
{
  private prf a;
  protected prg a;
  protected prh a;
  private boolean aBm;
  private HashMap<String, prf> fh = new HashMap();
  public Context mContext;
  private List<T> mData;
  public View mParentView;
  
  public prf(Context paramContext, int paramInt)
  {
    this.mParentView = LayoutInflater.from(paramContext).inflate(paramInt, null, true);
    this.mContext = paramContext;
  }
  
  public prf(Context paramContext, View paramView)
  {
    this.mParentView = paramView;
    this.mContext = paramContext;
  }
  
  public boolean IG()
  {
    return this.aBm;
  }
  
  public prf a()
  {
    return this.jdField_a_of_type_Prf;
  }
  
  public prf a(String paramString)
  {
    return (prf)this.fh.get(paramString);
  }
  
  public abstract prg a();
  
  public abstract prh a();
  
  public void a(String paramString, prf paramprf)
  {
    paramprf.jdField_a_of_type_Prf = this;
    this.fh.put(paramString, paramprf);
  }
  
  public void a(prh paramprh)
  {
    this.jdField_a_of_type_Prh = paramprh;
  }
  
  public void bmA()
  {
    if (this.aBm) {
      return;
    }
    this.aBm = true;
    if (this.mParentView != null) {
      this.mParentView.setVisibility(0);
    }
    if (this.jdField_a_of_type_Prh == null) {
      this.jdField_a_of_type_Prh = a();
    }
    if (this.jdField_a_of_type_Prg == null) {
      this.jdField_a_of_type_Prg = a();
    }
    g(this.mContext, this.mParentView);
    showLoading();
    if (this.mData != null) {
      dX(this.mData);
    }
    for (;;)
    {
      Iterator localIterator = this.fh.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((prf)this.fh.get(str)).bmA();
      }
      break;
      if (this.jdField_a_of_type_Prg != null) {
        this.jdField_a_of_type_Prg.bmm();
      } else {
        dX(null);
      }
    }
  }
  
  public abstract void dX(List<T> paramList);
  
  public void dY(List<T> paramList)
  {
    this.mData = paramList;
  }
  
  public void dZ(List<T> paramList)
  {
    if (!this.aBm) {
      return;
    }
    if (this.mParentView != null) {
      this.mParentView.setVisibility(0);
    }
    this.mData = paramList;
    dX(paramList);
  }
  
  public abstract void g(Context paramContext, View paramView);
  
  public void hide()
  {
    if (this.mParentView != null) {
      this.mParentView.setVisibility(8);
    }
  }
  
  public void onDestory()
  {
    Iterator localIterator = this.fh.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((prf)this.fh.get(str)).onDestory();
    }
  }
  
  public abstract void showLoading();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prf
 * JD-Core Version:    0.7.0.1
 */