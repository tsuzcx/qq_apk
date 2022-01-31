import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class wus
{
  private static final Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private static final Set<Integer> b = new HashSet();
  private static final Set<Integer> c = new HashSet();
  private static final Set<Integer> d = new HashSet();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private bhdp jdField_a_of_type_Bhdp;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Map<Integer, wug> jdField_a_of_type_JavaUtilMap;
  private Set<Integer> e;
  
  static
  {
    b.add(Integer.valueOf(131072));
    b.add(Integer.valueOf(196608));
    b.add(Integer.valueOf(262144));
    b.add(Integer.valueOf(327680));
    b.add(Integer.valueOf(393216));
    b.add(Integer.valueOf(458752));
    b.add(Integer.valueOf(524288));
    b.add(Integer.valueOf(589824));
    b.add(Integer.valueOf(655360));
    b.add(Integer.valueOf(786432));
    c.add(Integer.valueOf(131072));
    c.add(Integer.valueOf(196608));
    c.add(Integer.valueOf(262144));
    c.add(Integer.valueOf(327680));
    c.add(Integer.valueOf(393216));
    c.add(Integer.valueOf(458752));
    c.add(Integer.valueOf(524288));
    c.add(Integer.valueOf(589824));
    c.add(Integer.valueOf(786432));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(131072));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(196608));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(262144));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(327680));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(393216));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(458752));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(524288));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(589824));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(786432));
    d.add(Integer.valueOf(131072));
    d.add(Integer.valueOf(262144));
    d.add(Integer.valueOf(327680));
    d.add(Integer.valueOf(393216));
    d.add(Integer.valueOf(458752));
    if (bgxl.a())
    {
      jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(720896));
      b.add(Integer.valueOf(720896));
      c.add(Integer.valueOf(720896));
    }
  }
  
  public wus(Activity paramActivity, AppInterface paramAppInterface, View paramView, bhcw parambhcw)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bhdp = parambhcw;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
    if ((bgww.b.a(i)) || (i == bgww.t.a()) || (bjeg.a(i))) {
      this.e = b;
    }
    for (;;)
    {
      a();
      return;
      if (bgww.d.a(i)) {
        this.e = c;
      } else if ((bgww.w.a(i)) || (bgww.v.a(i))) {
        this.e = d;
      } else {
        this.e = jdField_a_of_type_JavaUtilSet;
      }
    }
  }
  
  private int a(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (paramInt >> 16 == localInteger.intValue() >> 16) {
        return localInteger.intValue();
      }
    }
    return 65536;
  }
  
  private void a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
      return;
      localObject = new wrc(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wqq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wtw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wuh(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wut(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wsa(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wta(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wti(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wru(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wsj(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new wrj(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
    }
  }
  
  private <T> T b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bhdp;
  }
  
  private void b(int paramInt, Object... paramVarArgs) {}
  
  public bgxx a(int paramInt)
  {
    paramInt = a(paramInt);
    wug localwug = (wug)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localwug instanceof wqq)) {
      return ((wqq)localwug).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    wug localwug = (wug)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localwug != null) {
      return localwug.a(paramInt, paramVarArgs);
    }
    return b(paramInt, paramVarArgs);
  }
  
  protected void a()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      a(((Integer)localIterator.next()).intValue());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int i = a(paramInt);
    wug localwug = (wug)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localwug != null)
    {
      localwug.a(paramInt, paramVarArgs);
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (wug)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).b();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).i();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((wug)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wus
 * JD-Core Version:    0.7.0.1
 */