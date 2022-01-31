import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dov.com.qq.im.AECamera.View.AEBeautyProviderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class wrn
  extends RecyclerView.Adapter<wrr>
  implements wrt
{
  public static bgya a;
  public static bgya b;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bgxh jdField_a_of_type_Bgxh;
  private bgxx jdField_a_of_type_Bgxx;
  private bhcw jdField_a_of_type_Bhcw;
  private String jdField_a_of_type_JavaLangString = "";
  private List<bgya> jdField_a_of_type_JavaUtilList;
  private Map<String, wrr> jdField_a_of_type_JavaUtilMap;
  private wrq jdField_a_of_type_Wrq;
  private wsi jdField_a_of_type_Wsi;
  private wus jdField_a_of_type_Wus;
  
  public wrn(@NonNull Context paramContext, @NonNull wus paramwus, @NonNull wrq paramwrq, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Wus = paramwus;
    this.jdField_a_of_type_Bhcw = ((bhcw)this.jdField_a_of_type_Wus.a(65537, new Object[0]));
    this.jdField_a_of_type_Bgxh = this.jdField_a_of_type_Bhcw.a();
    this.jdField_a_of_type_Wrq = paramwrq;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a().c(18));
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(@NonNull bgya parambgya)
  {
    if (parambgya.jdField_e_of_type_Int == 0)
    {
      b = parambgya;
      new StringBuilder().append(bjin.jdField_a_of_type_JavaLangString).append(parambgya.jdField_e_of_type_JavaLangString).toString();
      this.jdField_a_of_type_Bgxh.a(parambgya);
      i = AEBeautyProviderView.a();
      this.jdField_a_of_type_Bgxh.a(i);
      i = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bgxh.b(i);
      this.jdField_a_of_type_Wus.a(393218, new Object[] { parambgya });
    }
    while ((parambgya.jdField_e_of_type_Int != 4) && (parambgya.jdField_e_of_type_Int != 5) && (parambgya.jdField_e_of_type_Int != 6) && (parambgya.jdField_e_of_type_Int != 7))
    {
      int i;
      return;
    }
    b = null;
    this.jdField_a_of_type_Wus.a(655361, new Object[] { parambgya });
  }
  
  private void a(String paramString, wrr paramwrr)
  {
    try
    {
      Iterator localIterator = wtt.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          wtt.a().b(paramString, paramwrr);
        }
      }
      return;
    }
    finally {}
  }
  
  private void a(String paramString, wts paramwts)
  {
    try
    {
      Iterator localIterator = wtt.a().a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramString != null) && (paramString.equals(localEntry.getKey()))) {
          wtt.a().a(paramString, paramwts);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return b != null;
  }
  
  private void b(@NonNull bgya parambgya)
  {
    if ((parambgya.jdField_e_of_type_Boolean) || (TextUtils.isEmpty(parambgya.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if ((parambgya.b == 3) && (badq.b(this.jdField_a_of_type_AndroidContentContext)))
    {
      c(parambgya);
      return;
    }
    d(parambgya);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilMap.get(paramString) == null);
      paramString = (wrr)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while ((paramString == null) || (paramString.jdField_a_of_type_Bgya == null) || (!paramString.jdField_a_of_type_Bgya.jdField_e_of_type_Boolean));
    a(paramString.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void c(@NonNull bgya parambgya)
  {
    parambgya = babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131644036)).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131632581)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131629116), new wrp(this, parambgya)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131625035), new wro(this));
    if (parambgya != null) {}
    try
    {
      if (!parambgya.isShowing()) {
        parambgya.show();
      }
      return;
    }
    catch (Throwable parambgya) {}
  }
  
  private void d(@NonNull bgya parambgya)
  {
    wrr localwrr = (wrr)this.jdField_a_of_type_JavaUtilMap.get(parambgya.jdField_a_of_type_JavaLangString);
    if (localwrr != null) {
      localwrr.b();
    }
    bhcs.a("AEPlayShowGridAdapter", 1, "【Play Item】onDownloadStart :" + parambgya.jdField_a_of_type_JavaLangString);
    wtt.a().a(parambgya.jdField_a_of_type_JavaLangString, localwrr);
    wtt.a().a(this.jdField_a_of_type_Wus, this.jdField_a_of_type_Bgxx, parambgya);
  }
  
  private void e(@NonNull bgya parambgya)
  {
    this.jdField_a_of_type_Wus.a(655362, new Object[] { parambgya });
  }
  
  private void f(@NonNull bgya parambgya)
  {
    this.jdField_a_of_type_Wus.a(655363, new Object[] { parambgya });
  }
  
  public wrr a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131492953, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131492954, paramViewGroup, false)) {
      return new wrr(paramViewGroup, this.jdField_a_of_type_Wrq, this, this.jdField_a_of_type_Int);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() < 1)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          localObject = (String)((Map.Entry)localObject).getKey();
          if (localObject != null) {
            b((String)localObject);
          }
        }
      }
    }
  }
  
  public void a(View paramView, @NonNull bgya parambgya, int paramInt)
  {
    if (bhcp.a(paramView)) {}
    label144:
    label191:
    do
    {
      return;
      if (paramInt < 0)
      {
        Integer.toString(paramInt);
        bhcm.a().b(paramInt);
        bhcm.a().e("3");
        bhcm.a().c(parambgya.jdField_e_of_type_Int);
        jdField_a_of_type_Bgya = parambgya;
        bhcs.a("AEPlayShowGridAdapter", 1, "【Play Material OnClick】playShowType:" + parambgya.jdField_e_of_type_Int);
        bhcs.a("AEPlayShowGridAdapter", 1, "【Play Material OnClick】id:" + parambgya.jdField_a_of_type_JavaLangString);
        if (!bgya.b(parambgya)) {
          break label191;
        }
        if (!parambgya.d) {
          break label144;
        }
        a(parambgya);
      }
      for (;;)
      {
        bhci.a().b(parambgya.jdField_a_of_type_JavaLangString);
        return;
        paramInt += 1;
        break;
        if (!badq.a())
        {
          jdField_a_of_type_Bgya = null;
          b = null;
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131652572), 0).a();
        }
        else
        {
          b(parambgya);
        }
      }
      if (parambgya.jdField_e_of_type_Int == 2)
      {
        e(parambgya);
        bhci.a().b(parambgya.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (parambgya.jdField_e_of_type_Int != 3);
    f(parambgya);
    bhci.a().b(parambgya.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<bgya> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    notifyDataSetChanged();
  }
  
  public void a(wrr paramwrr)
  {
    super.onViewAttachedToWindow(paramwrr);
    if ((paramwrr.jdField_a_of_type_Bgya != null) && (!TextUtils.isEmpty(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString)) && (bgya.b(paramwrr.jdField_a_of_type_Bgya)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, paramwrr);
      paramwrr.a();
      a(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, paramwrr);
    }
  }
  
  public void a(wrr paramwrr, int paramInt)
  {
    bgya localbgya = (bgya)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramwrr.a(localbgya, paramInt);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbgya.h)))
    {
      bhcm.a().c(paramwrr.jdField_a_of_type_Bgya.jdField_e_of_type_Int);
      bhcm.a().b(paramInt + 1);
      bhci.a().e(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      wtt.a().b((String)localEntry.getKey(), (wts)localEntry.getValue());
    }
  }
  
  public void b(wrr paramwrr)
  {
    super.onViewDetachedFromWindow(paramwrr);
    if ((paramwrr.jdField_a_of_type_Bgya != null) && (!TextUtils.isEmpty(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString)) && (bgya.b(paramwrr.jdField_a_of_type_Bgya)))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString);
      paramwrr.a();
      a(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString, paramwrr);
      b(paramwrr.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrn
 * JD-Core Version:    0.7.0.1
 */