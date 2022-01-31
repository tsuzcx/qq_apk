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

public class xrd
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private List<xrg> jdField_a_of_type_JavaUtilList;
  private Map<String, xrg> jdField_a_of_type_JavaUtilMap;
  private xrf jdField_a_of_type_Xrf;
  private boolean jdField_a_of_type_Boolean;
  private Map<String, xrg> jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean;
  
  public xrd(@NonNull SegmentList paramSegmentList, @NonNull xrf paramxrf)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
    this.jdField_a_of_type_Xrf = paramxrf;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    super.registerDataSetObserver(new xre(this));
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((xrg)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
      i -= ((xrg)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).d();
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
    xmh.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).Z_();
    }
  }
  
  public int a(xrg paramxrg, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilList.indexOf(paramxrg);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i += ((xrg)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d();
      paramInt += 1;
    }
    return i;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = (StringBuilder)wnd.a.get();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xrg localxrg = (xrg)((Iterator)localObject).next();
      localStringBuilder.append(localxrg.a()).append(":").append(localxrg.d()).append("(").append(localxrg.b()).append(")||");
    }
    localObject = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return localObject;
  }
  
  public <T extends xrg> T a(String paramString)
  {
    try
    {
      paramString = (xrg)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    catch (ClassCastException paramString)
    {
      wsv.b("Q.qqstory.SegmentManager", "Cast Exception %s", paramString.getMessage());
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).b();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).i_(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (wph)paramView.getTag();
    if (paramView != null)
    {
      xrg localxrg = a(paramView.jdField_a_of_type_JavaLangString);
      if (localxrg != null) {
        localxrg.c(paramView);
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
    if (!ndk.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
    {
      this.jdField_a_of_type_Xrf.a(this.jdField_a_of_type_Int, SegmentList.d);
      return;
    }
    if (paramString.a_(true))
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramString.a(), paramString);
      return;
    }
    b(0);
    this.jdField_a_of_type_Xrf.a(this.jdField_a_of_type_Int);
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
      this.jdField_a_of_type_Xrf.a(this.jdField_a_of_type_Int, SegmentList.e);
    }
    for (;;)
    {
      b(0);
      return;
      label61:
      this.jdField_a_of_type_Xrf.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(@NonNull xrg paramxrg)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() >= 99) {
      throw new IllegalStateException("SegmentView did not support too many segment!");
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramxrg.a())) {
      throw new IllegalStateException("SegmentList is already have segment which key is :" + paramxrg.a() + ".It is not allow add twice");
    }
    paramxrg.a(this, this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList);
    this.jdField_a_of_type_JavaUtilMap.put(paramxrg.a(), paramxrg);
    this.jdField_a_of_type_JavaUtilList.add(paramxrg);
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
      if (!ndk.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
      {
        this.jdField_a_of_type_Xrf.a(this.jdField_a_of_type_Int, SegmentList.d);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        xrg localxrg = (xrg)localIterator.next();
        if (localxrg.a_(paramBoolean)) {
          this.jdField_b_of_type_JavaUtilMap.put(localxrg.a(), localxrg);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilMap.isEmpty());
    b(0);
    this.jdField_a_of_type_Xrf.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).e();
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    xrg localxrg;
    do
    {
      do
      {
        return;
        paramView = (wph)paramView.getTag();
      } while (paramView == null);
      localxrg = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localxrg == null);
    localxrg.a_(paramView);
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).ab_();
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {}
    xrg localxrg;
    do
    {
      do
      {
        return;
        paramView = (wph)paramView.getTag();
      } while (paramView == null);
      localxrg = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localxrg == null);
    localxrg.b_(paramView);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((xrg)localIterator.next()).k();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xrg localxrg = (xrg)localIterator.next();
      long l = System.currentTimeMillis();
      localxrg.c();
      wsv.a("Q.qqstory.home.position", "initOnBackground take time:%s, %s", Long.valueOf(System.currentTimeMillis() - l), localxrg.a());
    }
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((xrg)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
        xrg localxrg = (xrg)this.jdField_a_of_type_JavaUtilList.get(k);
        m = localxrg.d();
        i1 = localxrg.f_();
        if (m < 0) {
          throw new IllegalStateException(localxrg.a() + " getCount=" + m);
        }
        if (paramInt < m + j)
        {
          paramInt = localxrg.a(paramInt - j);
          if (paramInt < 0) {
            throw new IllegalStateException(localxrg.a() + " getViewType=" + paramInt);
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
    bhxr.a("SegmentManager.getView");
    int i = getItemViewType(paramInt);
    int j = a(paramInt);
    int k = a(j, paramInt);
    if (this.jdField_a_of_type_JavaUtilList.size() < j + 1) {
      throw new IllegalStateException("getView error! segmentIndex=" + j);
    }
    xrg localxrg = (xrg)this.jdField_a_of_type_JavaUtilList.get(j);
    if (localxrg == null) {
      throw new IllegalStateException("getView error! segment is null! segmentIndex=" + j);
    }
    bhxr.a("Segment.newView");
    if (paramView != null)
    {
      wph localwph = (wph)paramView.getTag();
      if (localwph != null)
      {
        paramView = localwph;
        if (localwph.jdField_a_of_type_Int == i) {
          break label170;
        }
      }
    }
    for (paramView = localxrg.a(k, paramViewGroup);; paramView = localxrg.a(k, paramViewGroup))
    {
      label170:
      bhxr.a();
      if (paramView != null) {
        break;
      }
      throw new QQStoryIllegalException(localxrg.a() + ": newView return null !");
    }
    paramView.jdField_a_of_type_Int = i;
    paramView.b = k;
    paramView.c = paramInt;
    paramView.jdField_a_of_type_JavaLangString = localxrg.a();
    paramView = localxrg.a(k, paramView, paramViewGroup);
    bhxr.a();
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
      xrg localxrg = (xrg)localIterator.next();
      j = localxrg.f_();
      if (j <= 0) {
        throw new IllegalStateException(localxrg.a() + " viewTypeCount=" + j);
      }
      i += j;
    }
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.b()))
    {
      wsv.e("Q.qqstory.SegmentManager", "notifyDataSetChanged but have not set adapter");
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
      wnb.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##", str1 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wnb.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##" });
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xrd
 * JD-Core Version:    0.7.0.1
 */