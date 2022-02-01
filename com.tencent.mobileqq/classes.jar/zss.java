import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zss
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private List<zsv> jdField_a_of_type_JavaUtilList;
  private Map<String, zsv> jdField_a_of_type_JavaUtilMap;
  private zsu jdField_a_of_type_Zsu;
  private boolean jdField_a_of_type_Boolean;
  private Map<String, zsv> jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean;
  
  public zss(@NonNull SegmentList paramSegmentList, @NonNull zsu paramzsu)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
    this.jdField_a_of_type_Zsu = paramzsu;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    super.registerDataSetObserver(new zst(this));
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((zsv)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
      i -= ((zsv)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).d();
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
    znw.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zsv)localIterator.next()).T_();
    }
  }
  
  public int a(zsv paramzsv, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilList.indexOf(paramzsv);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i += ((zsv)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d();
      paramInt += 1;
    }
    return i;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = (StringBuilder)yos.a.get();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      zsv localzsv = (zsv)((Iterator)localObject).next();
      localStringBuilder.append(localzsv.a()).append(":").append(localzsv.d()).append("(").append(localzsv.b()).append(")||");
    }
    localObject = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return localObject;
  }
  
  public <T extends zsv> T a(String paramString)
  {
    try
    {
      paramString = (zsv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    catch (ClassCastException paramString)
    {
      yuk.b("Q.qqstory.SegmentManager", "Cast Exception %s", paramString.getMessage());
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zsv)localIterator.next()).b();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zsv)localIterator.next()).h_(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zsv)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (yqw)paramView.getTag();
    if (paramView != null)
    {
      zsv localzsv = a(paramView.jdField_a_of_type_JavaLangString);
      if (localzsv != null) {
        localzsv.c(paramView);
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
    if (!nny.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
    {
      this.jdField_a_of_type_Zsu.a(this.jdField_a_of_type_Int, SegmentList.d);
      return;
    }
    if (paramString.a_(true))
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramString.a(), paramString);
      return;
    }
    b(0);
    this.jdField_a_of_type_Zsu.a(this.jdField_a_of_type_Int);
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
      this.jdField_a_of_type_Zsu.a(this.jdField_a_of_type_Int, SegmentList.e);
    }
    for (;;)
    {
      b(0);
      return;
      label61:
      this.jdField_a_of_type_Zsu.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(@NonNull zsv paramzsv)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() >= 99) {
      throw new IllegalStateException("SegmentView did not support too many segment!");
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramzsv.a())) {
      throw new IllegalStateException("SegmentList is already have segment which key is :" + paramzsv.a() + ".It is not allow add twice");
    }
    paramzsv.a(this, this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList);
    this.jdField_a_of_type_JavaUtilMap.put(paramzsv.a(), paramzsv);
    this.jdField_a_of_type_JavaUtilList.add(paramzsv);
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
      if (!nny.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
      {
        this.jdField_a_of_type_Zsu.a(this.jdField_a_of_type_Int, SegmentList.d);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        zsv localzsv = (zsv)localIterator.next();
        if (localzsv.a_(paramBoolean)) {
          this.jdField_b_of_type_JavaUtilMap.put(localzsv.a(), localzsv);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilMap.isEmpty());
    b(0);
    this.jdField_a_of_type_Zsu.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zsv)localIterator.next()).e();
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    zsv localzsv;
    do
    {
      do
      {
        return;
        paramView = (yqw)paramView.getTag();
      } while (paramView == null);
      localzsv = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localzsv == null);
    localzsv.a_(paramView);
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zsv)localIterator.next()).V_();
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {}
    zsv localzsv;
    do
    {
      do
      {
        return;
        paramView = (yqw)paramView.getTag();
      } while (paramView == null);
      localzsv = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localzsv == null);
    localzsv.b_(paramView);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zsv)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((zsv)localIterator.next()).k();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zsv localzsv = (zsv)localIterator.next();
      long l = System.currentTimeMillis();
      localzsv.c();
      yuk.a("Q.qqstory.home.position", "initOnBackground take time:%s, %s", Long.valueOf(System.currentTimeMillis() - l), localzsv.a());
    }
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((zsv)this.jdField_a_of_type_JavaUtilList.get(i)).d();
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
        zsv localzsv = (zsv)this.jdField_a_of_type_JavaUtilList.get(k);
        m = localzsv.d();
        i1 = localzsv.h_();
        if (m < 0) {
          throw new IllegalStateException(localzsv.a() + " getCount=" + m);
        }
        if (paramInt < m + j)
        {
          paramInt = localzsv.a(paramInt - j);
          if (paramInt < 0) {
            throw new IllegalStateException(localzsv.a() + " getViewType=" + paramInt);
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
    blqm.a("SegmentManager.getView");
    int i = getItemViewType(paramInt);
    int j = a(paramInt);
    int k = a(j, paramInt);
    if (this.jdField_a_of_type_JavaUtilList.size() < j + 1) {
      throw new IllegalStateException("getView error! segmentIndex=" + j);
    }
    zsv localzsv = (zsv)this.jdField_a_of_type_JavaUtilList.get(j);
    if (localzsv == null) {
      throw new IllegalStateException("getView error! segment is null! segmentIndex=" + j);
    }
    blqm.a("Segment.newView");
    if (paramView != null)
    {
      yqw localyqw = (yqw)paramView.getTag();
      if (localyqw != null)
      {
        localObject = localyqw;
        if (localyqw.jdField_a_of_type_Int == i) {
          break label172;
        }
      }
    }
    for (Object localObject = localzsv.a(k, paramViewGroup);; localObject = localzsv.a(k, paramViewGroup))
    {
      label172:
      blqm.a();
      if (localObject != null) {
        break;
      }
      throw new QQStoryIllegalException(localzsv.a() + ": newView return null !");
    }
    ((yqw)localObject).jdField_a_of_type_Int = i;
    ((yqw)localObject).b = k;
    ((yqw)localObject).c = paramInt;
    ((yqw)localObject).jdField_a_of_type_JavaLangString = localzsv.a();
    localObject = localzsv.a(k, (yqw)localObject, paramViewGroup);
    blqm.a();
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
      zsv localzsv = (zsv)localIterator.next();
      j = localzsv.h_();
      if (j <= 0) {
        throw new IllegalStateException(localzsv.a() + " viewTypeCount=" + j);
      }
      i += j;
    }
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.b()))
    {
      yuk.e("Q.qqstory.SegmentManager", "notifyDataSetChanged but have not set adapter");
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
      yoq.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##", str1 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        yoq.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##" });
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zss
 * JD-Core Version:    0.7.0.1
 */