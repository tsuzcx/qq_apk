import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Calendar;

public class mgk
{
  private static mgk a;
  public static int aRi = 1;
  private SparseArray<mgk.a> ak = new SparseArray();
  
  private mgk.a a(int paramInt)
  {
    mgk.a locala2 = (mgk.a)this.ak.get(paramInt);
    mgk.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = mgl.a(paramInt);
      this.ak.put(paramInt, locala1);
    }
    return locala1;
  }
  
  public static mgk a()
  {
    try
    {
      if (a == null) {
        a = new mgk();
      }
      mgk localmgk = a;
      return localmgk;
    }
    finally {}
  }
  
  public static String getDateString()
  {
    Calendar localCalendar = Calendar.getInstance();
    if (localCalendar == null) {
      return "";
    }
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return String.valueOf(i) + j + k;
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, int paramInt, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    mgk.a locala = a(paramInt);
    if (locala == null) {
      return "";
    }
    return locala.a(paramBaseArticleInfo, paramTemplateBean, paramViewBase);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    mgk.a locala = a(paramInt);
    if (locala == null) {
      return;
    }
    locala.a(paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean, int paramInt)
  {
    mgk.a locala = a(paramInt);
    if (locala == null) {
      return false;
    }
    return locala.a(paramBaseArticleInfo, paramBoolean);
  }
  
  public void e(Object paramObject, int paramInt)
  {
    mgk.a locala = a(paramInt);
    if (locala == null) {
      return;
    }
    locala.T(paramObject);
  }
  
  public static abstract interface a
  {
    public abstract void T(Object paramObject);
    
    public abstract String a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase);
    
    public abstract void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgk
 * JD-Core Version:    0.7.0.1
 */