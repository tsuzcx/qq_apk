import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amvk
  implements amwd<ampt>
{
  amvg a;
  QQAppInterface app;
  private boolean cEq;
  boolean cancel;
  int fromType;
  private boolean isInited;
  
  public amvk(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.fromType = paramInt;
    this.a = new amvg(paramQQAppInterface, 10002, 5, null);
  }
  
  public List<ampt> a(amwt paramamwt)
  {
    long l1 = System.currentTimeMillis();
    this.cancel = false;
    if ((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) {
      return null;
    }
    Object localObject2 = paramamwt.keyword.split("\\s+");
    if (localObject2.length < 2) {
      return null;
    }
    if (!this.isInited)
    {
      this.a.init();
      this.isInited = true;
    }
    Object localObject1 = new ArrayList();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      if (this.cancel) {
        return null;
      }
      localObject3 = new amwt((String)localObject3);
      localObject3 = this.a.a((amwt)localObject3);
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
    }
    if (((List)localObject1).size() < 2) {
      return null;
    }
    int m = ((List)localObject1).size();
    Object localObject3 = new ArrayList();
    Object localObject4 = ((List)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (List)((Iterator)localObject4).next();
      localObject1 = localObject2;
      if (((List)localObject2).size() > m) {
        localObject1 = ((List)localObject2).subList(0, m);
      }
      ((List)localObject3).add(localObject1);
    }
    localObject2 = new HashMap();
    localObject1 = new HashMap();
    localObject4 = ((List)localObject3).iterator();
    i = 0;
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((List)((Iterator)localObject4).next()).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (ampt)((Iterator)localObject5).next();
        if (!((Map)localObject2).containsKey(((ampt)localObject6).getUin()))
        {
          ((Map)localObject2).put(((ampt)localObject6).getUin(), Integer.valueOf(i));
          ((Map)localObject1).put(Integer.valueOf(i), ((ampt)localObject6).getUin());
          i += 1;
        }
      }
    }
    localObject4 = (long[][])Array.newInstance(Long.TYPE, new int[] { m, i });
    j = 0;
    while (j < ((List)localObject3).size())
    {
      int k = 0;
      while (k < ((List)((List)localObject3).get(j)).size())
      {
        localObject5 = (Integer)((Map)localObject2).get(((ampt)((List)((List)localObject3).get(j)).get(k)).getUin());
        if (localObject5 != null) {
          localObject4[j][localObject5.intValue()] = ((ampt)((List)((List)localObject3).get(j)).get(k)).gN();
        }
        k += 1;
      }
      j += 1;
    }
    localObject2 = amxc.a((long[][])localObject4, m, i);
    localObject4 = new ArrayList();
    i = localObject2.length - 1;
    while (i >= 0)
    {
      if (localObject2[i] != -1)
      {
        localObject6 = (List)((List)localObject3).get(i);
        localObject5 = (String)((Map)localObject1).get(Integer.valueOf(localObject2[i]));
        localObject6 = ((List)localObject6).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          ampt localampt = (ampt)((Iterator)localObject6).next();
          if ((localObject5 != null) && (((String)localObject5).equals(localampt.getUin()))) {
            ((List)localObject4).add(localampt);
          }
        }
      }
      i -= 1;
    }
    if (((List)localObject4).size() < 2) {
      return null;
    }
    paramamwt = new amoh(this.app, this.fromType, paramamwt.keyword, (List)localObject4);
    localObject1 = new ArrayList();
    ((List)localObject1).add(paramamwt);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CreateDiscussionSearchEngine", 2, "Create discussion search cost time = " + (l2 - l1));
    }
    if (!this.cEq)
    {
      this.cEq = true;
      anot.a(this.app, "CliOper", "", "", "0X800635E", "0X800635E", 0, 0, "", "", "", "");
    }
    return localObject1;
  }
  
  public void a(amwt paramamwt, amwe<ampt> paramamwe) {}
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void destroy() {}
  
  public void init() {}
  
  public void pause() {}
  
  public void resume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvk
 * JD-Core Version:    0.7.0.1
 */