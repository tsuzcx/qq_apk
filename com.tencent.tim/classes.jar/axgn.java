import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class axgn
  extends RecyclerView.Adapter<axgq>
  implements axgq.a
{
  public static axbu h;
  public static axbu k;
  private List<axbu> MB;
  private axgn.a a;
  private axgf b;
  private int bvK;
  private awtq jdField_c_of_type_Awtq;
  private axbr jdField_c_of_type_Axbr;
  private axgi jdField_c_of_type_Axgi;
  private String cUj = "";
  private awwk e;
  private Context mContext;
  private Map<String, axgq> qH;
  
  public axgn(@NonNull Context paramContext, @NonNull axgi paramaxgi, @NonNull axgn.a parama, int paramInt)
  {
    this.mContext = paramContext;
    this.jdField_c_of_type_Axgi = paramaxgi;
    this.jdField_c_of_type_Awtq = ((awtq)this.jdField_c_of_type_Axgi.a(65537, new Object[0]));
    this.e = this.jdField_c_of_type_Awtq.a();
    this.a = parama;
    this.bvK = paramInt;
    this.jdField_c_of_type_Axbr = ((axbr)axov.a().c(18));
    this.b = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
    this.qH = new HashMap();
  }
  
  private void A(@NonNull axbu paramaxbu)
  {
    paramaxbu = aqha.a(this.mContext, 230).setTitle(this.mContext.getString(2131711237)).setMessage(this.mContext.getString(2131700433)).setPositiveButton(this.mContext.getString(2131721079), new axgp(this, paramaxbu)).setNegativeButton(this.mContext.getString(2131721058), new axgo(this));
    if (paramaxbu != null) {}
    try
    {
      if (!paramaxbu.isShowing()) {
        paramaxbu.show();
      }
      return;
    }
    catch (Throwable paramaxbu) {}
  }
  
  private void B(@NonNull axbu paramaxbu)
  {
    axgq localaxgq = (axgq)this.qH.get(paramaxbu.id);
    if (localaxgq != null) {
      localaxgq.onDownloadStart();
    }
    axiy.i("AEPlayShowGridAdapter", "【Play Item】onDownloadStart :" + paramaxbu.id);
    axif.a().a(paramaxbu.id, localaxgq);
    axif.a().a(this.jdField_c_of_type_Axgi, this.jdField_c_of_type_Axbr, paramaxbu);
  }
  
  private void C(@NonNull axbu paramaxbu)
  {
    this.jdField_c_of_type_Axgi.p(655362, new Object[] { paramaxbu });
  }
  
  private void D(@NonNull axbu paramaxbu)
  {
    this.jdField_c_of_type_Axgi.p(655363, new Object[] { paramaxbu });
  }
  
  private void a(String paramString, axgq paramaxgq)
  {
    try
    {
      Iterator localIterator = axif.a().aM().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          axif.a().b(paramString, paramaxgq);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, axie paramaxie)
  {
    try
    {
      Iterator localIterator = axif.a().aM().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          axif.a().a(paramString, paramaxie);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean aOC()
  {
    return k != null;
  }
  
  private void acA(String paramString)
  {
    if (this.qH == null) {}
    do
    {
      do
      {
        return;
      } while (this.qH.get(paramString) == null);
      paramString = (axgq)this.qH.get(paramString);
    } while ((paramString == null) || (paramString.m == null) || (!paramString.m.downloading));
    a(paramString.m.id, paramString);
  }
  
  public static void eJz()
  {
    k = null;
  }
  
  private void y(@NonNull axbu paramaxbu)
  {
    if (paramaxbu.eEy == 0)
    {
      k = paramaxbu;
      new StringBuilder().append(ayzs.bYM).append(paramaxbu.name).toString();
      this.e.b(paramaxbu);
      i = AEBeautyProviderView.QU();
      this.e.setBeautyLevel(i);
      i = AEBeautyProviderView.QV();
      this.e.setSharpFaceLevel(i);
      this.jdField_c_of_type_Axgi.p(393218, new Object[] { paramaxbu });
    }
    while ((paramaxbu.eEy != 4) && (paramaxbu.eEy != 5) && (paramaxbu.eEy != 6) && (paramaxbu.eEy != 7))
    {
      int i;
      return;
    }
    k = null;
    this.jdField_c_of_type_Axgi.p(655361, new Object[] { paramaxbu });
  }
  
  private void z(@NonNull axbu paramaxbu)
  {
    if ((paramaxbu.downloading) || (TextUtils.isEmpty(paramaxbu.id))) {
      return;
    }
    if (aqiw.isMobileNetWork(this.mContext))
    {
      A(paramaxbu);
      return;
    }
    B(paramaxbu);
  }
  
  public axgq a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.bvK == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558573, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131558574, paramViewGroup, false)) {
      return new axgq(paramViewGroup, this.a, this, this.bvK);
    }
  }
  
  public void a(View paramView, @NonNull axbu paramaxbu, int paramInt)
  {
    if (axiw.Y(paramView)) {}
    label140:
    label165:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        axip.a().adX(paramInt);
        axip.a().acU("3");
        axip.a().LB(paramaxbu.eEy);
        h = paramaxbu;
        axiy.i("AEPlayShowGridAdapter", "【Play Material OnClick】playShowType:" + paramaxbu.eEy);
        axiy.i("AEPlayShowGridAdapter", "【Play Material OnClick】id:" + paramaxbu.id);
        if (!axbu.f(paramaxbu)) {
          break label165;
        }
        if (!paramaxbu.usable) {
          break label140;
        }
        y(paramaxbu);
      }
      for (;;)
      {
        axim.a().acK(paramaxbu.id);
        return;
        paramInt += 1;
        break;
        if (!aqiw.isNetworkAvailable())
        {
          h = null;
          k = null;
        }
        else
        {
          z(paramaxbu);
        }
      }
      if (paramaxbu.eEy == 2)
      {
        C(paramaxbu);
        axim.a().acK(paramaxbu.id);
        return;
      }
    } while (paramaxbu.eEy != 3);
    D(paramaxbu);
    axim.a().acK(paramaxbu.id);
  }
  
  public void a(axgq paramaxgq)
  {
    super.onViewAttachedToWindow(paramaxgq);
    if ((paramaxgq.m != null) && (!TextUtils.isEmpty(paramaxgq.m.id)) && (axbu.f(paramaxgq.m)))
    {
      this.qH.put(paramaxgq.m.id, paramaxgq);
      paramaxgq.eJA();
      a(paramaxgq.m.id, paramaxgq);
    }
  }
  
  public void a(axgq paramaxgq, int paramInt)
  {
    axbu localaxbu = (axbu)this.MB.get(paramInt);
    paramaxgq.c(localaxbu, paramInt);
    if ((this.cUj != null) && (this.cUj.equals(localaxbu.Kq)))
    {
      axip.a().LB(paramaxgq.m.eEy);
      axip.a().adX(paramInt + 1);
      axim.a().acN(paramaxgq.m.id);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaxgq, paramInt, getItemId(paramInt));
  }
  
  public void acz(String paramString)
  {
    this.cUj = paramString;
  }
  
  public void b(axgq paramaxgq)
  {
    super.onViewDetachedFromWindow(paramaxgq);
    if ((paramaxgq.m != null) && (!TextUtils.isEmpty(paramaxgq.m.id)) && (axbu.f(paramaxgq.m)))
    {
      this.qH.remove(paramaxgq.m.id);
      paramaxgq.eJA();
      a(paramaxgq.m.id, paramaxgq);
      acA(paramaxgq.m.id);
    }
  }
  
  public void ekV()
  {
    if ((this.qH == null) || (this.qH.size() < 1)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.qH.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          localObject = (String)((Map.Entry)localObject).getKey();
          if (localObject != null) {
            acA((String)localObject);
          }
        }
      }
    }
  }
  
  public int getItemCount()
  {
    return this.MB.size();
  }
  
  public void oB(@NonNull List<axbu> paramList)
  {
    this.MB = paramList;
    if (this.MB.size() == 0) {
      this.qH.clear();
    }
    notifyDataSetChanged();
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.qH.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      axif.a().b((String)localEntry.getKey(), (axie)localEntry.getValue());
    }
  }
  
  public static class a
  {
    public int eEQ;
    public int itemHeight;
    public int itemHorizontalPadding;
    public int itemWidth;
    
    public a() {}
    
    public a(@NonNull a parama)
    {
      this.itemWidth = parama.itemWidth;
      this.itemHeight = parama.itemHeight;
      this.itemHorizontalPadding = parama.itemHorizontalPadding;
      this.eEQ = parama.eEQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgn
 * JD-Core Version:    0.7.0.1
 */