import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class wrd<T>
{
  public Context a;
  private HashMap<String, wrd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<T> jdField_a_of_type_JavaUtilList;
  private wrd jdField_a_of_type_Wrd;
  protected wre a;
  protected wrf a;
  private boolean jdField_a_of_type_Boolean;
  public View b;
  
  public wrd(Context paramContext, int paramInt)
  {
    this.b = LayoutInflater.from(paramContext).inflate(paramInt, null, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public wrd(Context paramContext, View paramView)
  {
    this.b = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public wrd a()
  {
    return this.jdField_a_of_type_Wrd;
  }
  
  public wrd a(String paramString)
  {
    return (wrd)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public abstract wre a();
  
  public abstract wrf a();
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((wrd)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
    }
  }
  
  public abstract void a(Context paramContext, View paramView);
  
  public void a(String paramString, wrd paramwrd)
  {
    paramwrd.jdField_a_of_type_Wrd = this;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramwrd);
  }
  
  public abstract void a(List<T> paramList);
  
  public void a(wrf paramwrf)
  {
    this.jdField_a_of_type_Wrf = paramwrf;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract void b();
  
  public void b(List<T> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void c(List<T> paramList)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(paramList);
  }
  
  public void k()
  {
    if (this.b != null) {
      this.b.setVisibility(8);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.b != null) {
      this.b.setVisibility(0);
    }
    if (this.jdField_a_of_type_Wrf == null) {
      this.jdField_a_of_type_Wrf = a();
    }
    if (this.jdField_a_of_type_Wre == null) {
      this.jdField_a_of_type_Wre = a();
    }
    a(this.jdField_a_of_type_AndroidContentContext, this.b);
    b();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((wrd)this.jdField_a_of_type_JavaUtilHashMap.get(str)).l();
      }
      break;
      if (this.jdField_a_of_type_Wre != null) {
        this.jdField_a_of_type_Wre.a();
      } else {
        a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrd
 * JD-Core Version:    0.7.0.1
 */