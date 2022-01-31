import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class wcl
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private List<wco> jdField_a_of_type_JavaUtilList;
  private Map<String, wco> jdField_a_of_type_JavaUtilMap;
  private wcn jdField_a_of_type_Wcn;
  private boolean jdField_a_of_type_Boolean;
  private Map<String, wco> jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean;
  
  public wcl(@NonNull SegmentList paramSegmentList, @NonNull wcn paramwcn)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
    this.jdField_a_of_type_Wcn = paramwcn;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    super.registerDataSetObserver(new wcm(this));
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((wco)this.jdField_a_of_type_JavaUtilList.get(i)).d();
      if (paramInt < j) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      i -= ((wco)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).d();
      paramInt2 += 1;
    }
    return i;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (this.jdField_a_of_type_Int)
    {
    }
  }
  
  private void g()
  {
    vxp.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wco)localIterator.next()).R_();
    }
  }
  
  public int a(wco paramwco, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilList.indexOf(paramwco);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i += ((wco)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d();
      paramInt += 1;
    }
    return i;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = (StringBuilder)uyl.a.get();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      wco localwco = (wco)((Iterator)localObject).next();
      localStringBuilder.append(localwco.a()).append(":").append(localwco.d()).append("(").append(localwco.b()).append(")||");
    }
    localObject = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return localObject;
  }
  
  public <T extends wco> T a(String paramString)
  {
    try
    {
      paramString = (wco)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    catch (ClassCastException paramString)
    {
      ved.b("Q.qqstory.SegmentManager", "Cast Exception %s", paramString.getMessage());
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wco)localIterator.next()).b();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wco)localIterator.next()).g_(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wco)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (vap)paramView.getTag();
    if (paramView != null)
    {
      wco localwco = a(paramView.jdField_a_of_type_JavaLangString);
      if (localwco != null) {
        localwco.c(paramView);
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    b(3);
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_Boolean = false;
    if (!nao.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
    {
      this.jdField_a_of_type_Wcn.a(this.jdField_a_of_type_Int, SegmentList.d);
      return;
    }
    if (paramString.a_(true))
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramString.a(), paramString);
      return;
    }
    b(0);
    this.jdField_a_of_type_Wcn.a(this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilMap.remove(paramString);
    if (!paramBoolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty())
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label61;
      }
      this.jdField_a_of_type_Wcn.a(this.jdField_a_of_type_Int, SegmentList.e);
    }
    for (;;)
    {
      b(0);
      return;
      label61:
      this.jdField_a_of_type_Wcn.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(@NonNull wco paramwco)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() >= 99) {
      throw new IllegalStateException("SegmentView did not support too many segment!");
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramwco.a())) {
      throw new IllegalStateException("SegmentList is already have segment which key is :" + paramwco.a() + ".It is not allow add twice");
    }
    paramwco.a(this, this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList);
    this.jdField_a_of_type_JavaUtilMap.put(paramwco.a(), paramwco);
    this.jdField_a_of_type_JavaUtilList.add(paramwco);
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 3;
      b(i);
      this.jdField_b_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext() != null) {
        break label41;
      }
    }
    label41:
    do
    {
      return;
      i = 1;
      break;
      if (!nao.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
      {
        this.jdField_a_of_type_Wcn.a(this.jdField_a_of_type_Int, SegmentList.d);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        wco localwco = (wco)localIterator.next();
        if (localwco.a_(paramBoolean)) {
          this.jdField_b_of_type_JavaUtilMap.put(localwco.a(), localwco);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilMap.isEmpty());
    b(0);
    this.jdField_a_of_type_Wcn.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wco)localIterator.next()).e();
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    wco localwco;
    do
    {
      do
      {
        return;
        paramView = (vap)paramView.getTag();
      } while (paramView == null);
      localwco = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localwco == null);
    localwco.a_(paramView);
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wco)localIterator.next()).T_();
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {}
    wco localwco;
    do
    {
      do
      {
        return;
        paramView = (vap)paramView.getTag();
      } while (paramView == null);
      localwco = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localwco == null);
    localwco.b_(paramView);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wco)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((wco)localIterator.next()).k();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      wco localwco = (wco)localIterator.next();
      long l = System.currentTimeMillis();
      localwco.c();
      ved.a("Q.qqstory.home.position", "initOnBackground take time:%s, %s", Long.valueOf(System.currentTimeMillis() - l), localwco.a());
    }
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((wco)this.jdField_a_of_type_JavaUtilList.get(i)).d();
      i += 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int n = 0;
    int k = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int m = n;
      int i1;
      if (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        wco localwco = (wco)this.jdField_a_of_type_JavaUtilList.get(k);
        m = localwco.d();
        i1 = localwco.f_();
        if (m < 0) {
          throw new IllegalStateException(localwco.a() + " getCount=" + m);
        }
        if (paramInt < m + j)
        {
          paramInt = localwco.a(paramInt - j);
          if (paramInt < 0) {
            throw new IllegalStateException(localwco.a() + " getViewType=" + paramInt);
          }
          m = i + paramInt;
        }
      }
      else
      {
        return m;
      }
      i += i1;
      j += m;
      k += 1;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bfwu.a("SegmentManager.getView");
    int i = getItemViewType(paramInt);
    int j = a(paramInt);
    int k = a(j, paramInt);
    if (this.jdField_a_of_type_JavaUtilList.size() < j + 1) {
      throw new IllegalStateException("getView error! segmentIndex=" + j);
    }
    wco localwco = (wco)this.jdField_a_of_type_JavaUtilList.get(j);
    if (localwco == null) {
      throw new IllegalStateException("getView error! segment is null! segmentIndex=" + j);
    }
    bfwu.a("Segment.newView");
    if (paramView != null)
    {
      vap localvap = (vap)paramView.getTag();
      if (localvap != null)
      {
        paramView = localvap;
        if (localvap.jdField_a_of_type_Int == i) {
          break label170;
        }
      }
    }
    for (paramView = localwco.a(k, paramViewGroup);; paramView = localwco.a(k, paramViewGroup))
    {
      label170:
      bfwu.a();
      if (paramView != null) {
        break;
      }
      throw new QQStoryIllegalException(localwco.a() + ": newView return null !");
    }
    paramView.jdField_a_of_type_Int = i;
    paramView.b = k;
    paramView.c = paramInt;
    paramView.jdField_a_of_type_JavaLangString = localwco.a();
    paramView = localwco.a(k, paramView, paramViewGroup);
    bfwu.a();
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      j = 1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      wco localwco = (wco)localIterator.next();
      j = localwco.f_();
      if (j <= 0) {
        throw new IllegalStateException(localwco.a() + " viewTypeCount=" + j);
      }
      i += j;
    }
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.b()))
    {
      ved.e("Q.qqstory.SegmentManager", "notifyDataSetChanged but have not set adapter");
      return;
    }
    g();
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = new RuntimeException("getStackTrace").getStackTrace();
      String str2 = arrayOfStackTraceElement[1].toString();
      String str1 = str2;
      if (arrayOfStackTraceElement.length >= 3) {
        str1 = str2 + arrayOfStackTraceElement[2].toString();
      }
      uyj.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##", str1 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        uyj.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##" });
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wcl
 * JD-Core Version:    0.7.0.1
 */