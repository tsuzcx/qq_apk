import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zgw
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private List<zgz> jdField_a_of_type_JavaUtilList;
  private Map<String, zgz> jdField_a_of_type_JavaUtilMap;
  private zgy jdField_a_of_type_Zgy;
  private boolean jdField_a_of_type_Boolean;
  private Map<String, zgz> jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean;
  
  public zgw(@NonNull SegmentList paramSegmentList, @NonNull zgy paramzgy)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
    this.jdField_a_of_type_Zgy = paramzgy;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    super.registerDataSetObserver(new zgx(this));
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((zgz)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
      i -= ((zgz)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).d();
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
    zdl.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zgz)localIterator.next()).P_();
    }
  }
  
  public int a(zgz paramzgz, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilList.indexOf(paramzgz);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i += ((zgz)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d();
      paramInt += 1;
    }
    return i;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = (StringBuilder)yey.a.get();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      zgz localzgz = (zgz)((Iterator)localObject).next();
      localStringBuilder.append(localzgz.a()).append(":").append(localzgz.d()).append("(").append(localzgz.b()).append(")||");
    }
    localObject = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return localObject;
  }
  
  public <T extends zgz> T a(String paramString)
  {
    try
    {
      paramString = (zgz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    catch (ClassCastException paramString)
    {
      ykq.b("Q.qqstory.SegmentManager", "Cast Exception %s", paramString.getMessage());
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zgz)localIterator.next()).b();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zgz)localIterator.next()).i_(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zgz)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (yhc)paramView.getTag();
    if (paramView != null)
    {
      zgz localzgz = a(paramView.jdField_a_of_type_JavaLangString);
      if (localzgz != null) {
        localzgz.c(paramView);
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
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
    {
      this.jdField_a_of_type_Zgy.a(this.jdField_a_of_type_Int, SegmentList.d);
      return;
    }
    if (paramString.a_(true))
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramString.a(), paramString);
      return;
    }
    b(0);
    this.jdField_a_of_type_Zgy.a(this.jdField_a_of_type_Int);
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
      this.jdField_a_of_type_Zgy.a(this.jdField_a_of_type_Int, SegmentList.e);
    }
    for (;;)
    {
      b(0);
      return;
      label61:
      this.jdField_a_of_type_Zgy.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(@NonNull zgz paramzgz)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() >= 99) {
      throw new IllegalStateException("SegmentView did not support too many segment!");
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramzgz.a())) {
      throw new IllegalStateException("SegmentList is already have segment which key is :" + paramzgz.a() + ".It is not allow add twice");
    }
    paramzgz.a(this, this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList);
    this.jdField_a_of_type_JavaUtilMap.put(paramzgz.a(), paramzgz);
    this.jdField_a_of_type_JavaUtilList.add(paramzgz);
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
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
      {
        this.jdField_a_of_type_Zgy.a(this.jdField_a_of_type_Int, SegmentList.d);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        zgz localzgz = (zgz)localIterator.next();
        if (localzgz.a_(paramBoolean)) {
          this.jdField_b_of_type_JavaUtilMap.put(localzgz.a(), localzgz);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilMap.isEmpty());
    b(0);
    this.jdField_a_of_type_Zgy.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zgz)localIterator.next()).e();
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    zgz localzgz;
    do
    {
      do
      {
        return;
        paramView = (yhc)paramView.getTag();
      } while (paramView == null);
      localzgz = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localzgz == null);
    localzgz.a_(paramView);
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zgz)localIterator.next()).R_();
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {}
    zgz localzgz;
    do
    {
      do
      {
        return;
        paramView = (yhc)paramView.getTag();
      } while (paramView == null);
      localzgz = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localzgz == null);
    localzgz.b_(paramView);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zgz)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((zgz)localIterator.next()).k();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zgz localzgz = (zgz)localIterator.next();
      long l = System.currentTimeMillis();
      localzgz.c();
      ykq.a("Q.qqstory.home.position", "initOnBackground take time:%s, %s", Long.valueOf(System.currentTimeMillis() - l), localzgz.a());
    }
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((zgz)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
        zgz localzgz = (zgz)this.jdField_a_of_type_JavaUtilList.get(k);
        m = localzgz.d();
        i1 = localzgz.f_();
        if (m < 0) {
          throw new IllegalStateException(localzgz.a() + " getCount=" + m);
        }
        if (paramInt < m + j)
        {
          paramInt = localzgz.a(paramInt - j);
          if (paramInt < 0) {
            throw new IllegalStateException(localzgz.a() + " getViewType=" + paramInt);
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
    blfz.a("SegmentManager.getView");
    int i = getItemViewType(paramInt);
    int j = a(paramInt);
    int k = a(j, paramInt);
    if (this.jdField_a_of_type_JavaUtilList.size() < j + 1) {
      throw new IllegalStateException("getView error! segmentIndex=" + j);
    }
    zgz localzgz = (zgz)this.jdField_a_of_type_JavaUtilList.get(j);
    if (localzgz == null) {
      throw new IllegalStateException("getView error! segment is null! segmentIndex=" + j);
    }
    blfz.a("Segment.newView");
    if (paramView != null)
    {
      yhc localyhc = (yhc)paramView.getTag();
      if (localyhc != null)
      {
        localObject = localyhc;
        if (localyhc.jdField_a_of_type_Int == i) {
          break label172;
        }
      }
    }
    for (Object localObject = localzgz.a(k, paramViewGroup);; localObject = localzgz.a(k, paramViewGroup))
    {
      label172:
      blfz.a();
      if (localObject != null) {
        break;
      }
      throw new QQStoryIllegalException(localzgz.a() + ": newView return null !");
    }
    ((yhc)localObject).jdField_a_of_type_Int = i;
    ((yhc)localObject).b = k;
    ((yhc)localObject).c = paramInt;
    ((yhc)localObject).jdField_a_of_type_JavaLangString = localzgz.a();
    localObject = localzgz.a(k, (yhc)localObject, paramViewGroup);
    blfz.a();
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
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
      zgz localzgz = (zgz)localIterator.next();
      j = localzgz.f_();
      if (j <= 0) {
        throw new IllegalStateException(localzgz.a() + " viewTypeCount=" + j);
      }
      i += j;
    }
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.b()))
    {
      ykq.e("Q.qqstory.SegmentManager", "notifyDataSetChanged but have not set adapter");
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
      yew.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##", str1 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        yew.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##" });
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgw
 * JD-Core Version:    0.7.0.1
 */