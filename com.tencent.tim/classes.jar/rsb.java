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

public class rsb
  extends BaseAdapter
{
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private rsb.a jdField_a_of_type_Rsb$a;
  private boolean aJA;
  private boolean aJz;
  private int buM = 0;
  private Map<String, rsd> gn;
  private Map<String, rsd> go;
  private List<rsd> nQ;
  
  public rsb(@NonNull SegmentList paramSegmentList, @NonNull rsb.a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
    this.jdField_a_of_type_Rsb$a = parama;
    this.nQ = new ArrayList();
    this.gn = new HashMap();
    this.go = new HashMap();
    super.registerDataSetObserver(new rsc(this));
  }
  
  private int aa(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      i -= ((rsd)this.nQ.get(paramInt2)).getItemCount();
      paramInt2 += 1;
    }
    return i;
  }
  
  private void bwc()
  {
    rom.bvK();
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      ((rsd)localIterator.next()).bqo();
    }
  }
  
  private int el(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.nQ.size())
    {
      j += ((rsd)this.nQ.get(i)).getItemCount();
      if (paramInt < j) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void tl(int paramInt)
  {
    this.buM = paramInt;
    switch (this.buM)
    {
    }
  }
  
  public int a(rsd paramrsd, int paramInt)
  {
    int k = this.nQ.indexOf(paramrsd);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i += ((rsd)this.nQ.get(paramInt)).getItemCount();
      paramInt += 1;
    }
    return i;
  }
  
  public <T extends rsd> T a(String paramString)
  {
    try
    {
      paramString = (rsd)this.gn.get(paramString);
      return paramString;
    }
    catch (ClassCastException paramString)
    {
      ram.d("Q.qqstory.SegmentManager", "Cast Exception %s", paramString.getMessage());
    }
    return null;
  }
  
  public void a(@NonNull rsd paramrsd)
  {
    if (this.nQ.size() >= 99) {
      throw new IllegalStateException("SegmentView did not support too many segment!");
    }
    if (this.gn.containsKey(paramrsd.getKey())) {
      throw new IllegalStateException("SegmentList is already have segment which key is :" + paramrsd.getKey() + ".It is not allow add twice");
    }
    paramrsd.a(this, this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList);
    this.gn.put(paramrsd.getKey(), paramrsd);
    this.nQ.add(paramrsd);
  }
  
  public void aC(String paramString, boolean paramBoolean)
  {
    this.go.remove(paramString);
    if (!paramBoolean) {
      this.aJA = true;
    }
    if (this.go.isEmpty())
    {
      if (!this.aJA) {
        break label61;
      }
      this.jdField_a_of_type_Rsb$a.eu(this.buM, SegmentList.buK);
    }
    for (;;)
    {
      tl(0);
      return;
      label61:
      this.jdField_a_of_type_Rsb$a.xT(this.buM);
    }
  }
  
  public void bqO()
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext())
    {
      rsd localrsd = (rsd)localIterator.next();
      long l = System.currentTimeMillis();
      localrsd.bqO();
      ram.b("Q.qqstory.home.position", "initOnBackground take time:%s, %s", Long.valueOf(System.currentTimeMillis() - l), localrsd.getKey());
    }
  }
  
  public void bwb()
  {
    if (this.aJz)
    {
      this.aJz = false;
      Iterator localIterator = this.nQ.iterator();
      while (localIterator.hasNext()) {
        ((rsd)localIterator.next()).brN();
      }
    }
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    while (i < this.nQ.size())
    {
      j += ((rsd)this.nQ.get(i)).getItemCount();
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
      if (k < this.nQ.size())
      {
        rsd localrsd = (rsd)this.nQ.get(k);
        m = localrsd.getItemCount();
        i1 = localrsd.getViewTypeCount();
        if (m < 0) {
          throw new IllegalStateException(localrsd.getKey() + " getCount=" + m);
        }
        if (paramInt < m + j)
        {
          paramInt = localrsd.J(paramInt - j);
          if (paramInt < 0) {
            throw new IllegalStateException(localrsd.getKey() + " getViewType=" + paramInt);
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
    auvk.traceBegin("SegmentManager.getView");
    int i = getItemViewType(paramInt);
    int j = el(paramInt);
    int k = aa(j, paramInt);
    if (this.nQ.size() < j + 1) {
      throw new IllegalStateException("getView error! segmentIndex=" + j);
    }
    rsd localrsd = (rsd)this.nQ.get(j);
    if (localrsd == null) {
      throw new IllegalStateException("getView error! segment is null! segmentIndex=" + j);
    }
    auvk.traceBegin("Segment.newView");
    if (paramView != null)
    {
      qyd localqyd = (qyd)paramView.getTag();
      if (localqyd != null)
      {
        localObject = localqyd;
        if (localqyd.type == i) {
          break label171;
        }
      }
    }
    for (Object localObject = localrsd.a(k, paramViewGroup);; localObject = localrsd.a(k, paramViewGroup))
    {
      label171:
      auvk.traceEnd();
      if (localObject != null) {
        break;
      }
      throw new QQStoryIllegalException(localrsd.getKey() + ": newView return null !");
    }
    ((qyd)localObject).type = i;
    ((qyd)localObject).position = k;
    ((qyd)localObject).bov = paramInt;
    ((qyd)localObject).azf = localrsd.getKey();
    localObject = localrsd.a(k, (qyd)localObject, paramViewGroup);
    auvk.traceEnd();
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    int j;
    if (this.nQ.size() == 0)
    {
      j = 1;
      return j;
    }
    Iterator localIterator = this.nQ.iterator();
    int i = 0;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      rsd localrsd = (rsd)localIterator.next();
      j = localrsd.getViewTypeCount();
      if (j <= 0) {
        throw new IllegalStateException(localrsd.getKey() + " viewTypeCount=" + j);
      }
      i += j;
    }
  }
  
  public String nd()
  {
    StringBuilder localStringBuilder = (StringBuilder)qwr.o.get();
    Object localObject = this.nQ.iterator();
    while (((Iterator)localObject).hasNext())
    {
      rsd localrsd = (rsd)((Iterator)localObject).next();
      localStringBuilder.append(localrsd.getKey()).append(":").append(localrsd.getItemCount()).append("(").append(localrsd.ne()).append(")||");
    }
    localObject = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return localObject;
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.LZ()))
    {
      ram.e("Q.qqstory.SegmentManager", "notifyDataSetChanged but have not set adapter");
      return;
    }
    bwc();
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = new RuntimeException("getStackTrace").getStackTrace();
      String str2 = arrayOfStackTraceElement[1].toString();
      String str1 = str2;
      if (arrayOfStackTraceElement.length >= 3) {
        str1 = str2 + arrayOfStackTraceElement[2].toString();
      }
      qwp.w("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##", str1 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        qwp.w("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##" });
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      ((rsd)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate()
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      ((rsd)localIterator.next()).onCreate();
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      ((rsd)localIterator.next()).onDestroy();
    }
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    paramView = (qyd)paramView.getTag();
    if (paramView != null)
    {
      rsd localrsd = a(paramView.azf);
      if (localrsd != null) {
        localrsd.e(paramView);
      }
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      ((rsd)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      ((rsd)localIterator.next()).onResume();
    }
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    if (paramView == null) {}
    rsd localrsd;
    do
    {
      do
      {
        return;
        paramView = (qyd)paramView.getTag();
      } while (paramView == null);
      localrsd = a(paramView.azf);
    } while (localrsd == null);
    localrsd.g(paramView);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    if (paramView == null) {}
    rsd localrsd;
    do
    {
      do
      {
        return;
        paramView = (qyd)paramView.getTag();
      } while (paramView == null);
      localrsd = a(paramView.azf);
    } while (localrsd == null);
    localrsd.h(paramView);
  }
  
  public void sk(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    tl(3);
    this.go.clear();
    this.aJA = false;
    if (!jqi.isNetworkAvailable(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
    {
      this.jdField_a_of_type_Rsb$a.eu(this.buM, SegmentList.buJ);
      return;
    }
    if (paramString.Z(true))
    {
      this.go.put(paramString.getKey(), paramString);
      return;
    }
    tl(0);
    this.jdField_a_of_type_Rsb$a.xT(this.buM);
  }
  
  public void tO(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 3;
      tl(i);
      this.go.clear();
      this.aJA = false;
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
      if (!jqi.isNetworkAvailable(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
      {
        this.jdField_a_of_type_Rsb$a.eu(this.buM, SegmentList.buJ);
        return;
      }
      Iterator localIterator = this.nQ.iterator();
      while (localIterator.hasNext())
      {
        rsd localrsd = (rsd)localIterator.next();
        if (localrsd.Z(paramBoolean)) {
          this.go.put(localrsd.getKey(), localrsd);
        }
      }
    } while (!this.go.isEmpty());
    tl(0);
    this.jdField_a_of_type_Rsb$a.xT(this.buM);
  }
  
  public void wG(int paramInt)
  {
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext()) {
      ((rsd)localIterator.next()).wG(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eu(int paramInt1, int paramInt2);
    
    public abstract void xT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsb
 * JD-Core Version:    0.7.0.1
 */