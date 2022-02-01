import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class vsu<T>
{
  public Context a;
  private HashMap<String, vsu> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<T> jdField_a_of_type_JavaUtilList;
  private vsu jdField_a_of_type_Vsu;
  protected vsv a;
  protected vsw a;
  private boolean jdField_a_of_type_Boolean;
  public View b;
  
  public vsu(Context paramContext, int paramInt)
  {
    this.b = LayoutInflater.from(paramContext).inflate(paramInt, null, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public vsu(Context paramContext, View paramView)
  {
    this.b = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public vsu a()
  {
    return this.jdField_a_of_type_Vsu;
  }
  
  public vsu a(String paramString)
  {
    return (vsu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public abstract vsv a();
  
  public abstract vsw a();
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((vsu)this.jdField_a_of_type_JavaUtilHashMap.get(str)).a();
    }
  }
  
  public abstract void a(Context paramContext, View paramView);
  
  public void a(String paramString, vsu paramvsu)
  {
    paramvsu.jdField_a_of_type_Vsu = this;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramvsu);
  }
  
  public abstract void a(List<T> paramList);
  
  public void a(vsw paramvsw)
  {
    this.jdField_a_of_type_Vsw = paramvsw;
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
    if (this.jdField_a_of_type_Vsw == null) {
      this.jdField_a_of_type_Vsw = a();
    }
    if (this.jdField_a_of_type_Vsv == null) {
      this.jdField_a_of_type_Vsv = a();
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
        ((vsu)this.jdField_a_of_type_JavaUtilHashMap.get(str)).l();
      }
      break;
      if (this.jdField_a_of_type_Vsv != null) {
        this.jdField_a_of_type_Vsv.a();
      } else {
        a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsu
 * JD-Core Version:    0.7.0.1
 */