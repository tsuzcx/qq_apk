import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class xto
  implements sxm
{
  public static final Object bR = new Object();
  public static final Object bS = new Object();
  int AS;
  int Zw;
  public xud a = new xud();
  private String aWl;
  int bWV = -1;
  int bWW;
  boolean bjh = false;
  boolean bji = false;
  boolean bjj = false;
  public boolean bjk = false;
  xuf e;
  xuf f;
  int index;
  private Calendar l;
  int mColumnCount = 0;
  boolean mUpdated = false;
  List<xuf> sj = new ArrayList();
  List<xuf> sk = new ArrayList();
  List<xuf> sl = new ArrayList();
  List<Object> sm = new ArrayList();
  
  public xto(boolean paramBoolean)
  {
    this.bjj = paramBoolean;
  }
  
  private void a(int paramInt, String paramString, AIOFilePicData paramAIOFilePicData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      case 17: 
      case 19: 
      default: 
        return;
      case 18: 
        paramAIOFilePicData.bim = true;
        return;
      case 20: 
        paramAIOFilePicData.bin = true;
        return;
      }
      paramAIOFilePicData.bio = true;
      return;
    }
    switch (paramInt)
    {
    case 17: 
    case 19: 
    default: 
      return;
    case 16: 
      paramAIOFilePicData.aVW = paramString;
      return;
    case 18: 
      paramAIOFilePicData.aVX = paramString;
      return;
    }
    paramAIOFilePicData.aVY = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOImageData paramAIOImageData)
  {
    if ("I:E".equals(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      paramAIOImageData.bim = true;
      return;
      paramAIOImageData.bin = true;
      return;
      paramAIOImageData.bio = true;
      return;
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return;
      case 1: 
        paramAIOImageData.aVW = paramString;
        return;
      case 2: 
        paramAIOImageData.aVX = paramString;
      }
    } while ((paramAIOImageData.bjf) || (!new File(paramAIOImageData.aVW + "_hd").exists()));
    paramAIOImageData.aVW += "_hd";
    return;
    paramAIOImageData.aVY = paramString;
    return;
    paramAIOImageData.aVZ = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOShortVideoData paramAIOShortVideoData)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        paramAIOShortVideoData.bio = true;
        return;
      }
      paramAIOShortVideoData.bjB = true;
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAIOShortVideoData.aWo = paramString;
      return;
    }
    paramAIOShortVideoData.aWp = paramString;
  }
  
  public void Du(int paramInt)
  {
    this.Zw = paramInt;
  }
  
  public void Dv(int paramInt)
  {
    this.AS = paramInt;
  }
  
  public void Dw(int paramInt)
  {
    this.mColumnCount = paramInt;
  }
  
  public void Dx(int paramInt)
  {
    this.bWW = paramInt;
    Object localObject = j(paramInt);
    if (!xuf.class.isInstance(localObject)) {
      return;
    }
    this.f = ((xuf)localObject);
    this.index = this.sk.indexOf(this.f);
  }
  
  public boolean SK()
  {
    return this.a.f(this.sm, this.mColumnCount);
  }
  
  public boolean SL()
  {
    if (!this.bji) {}
    int i;
    do
    {
      return false;
      i = this.sl.size();
    } while (i <= 0);
    this.Zw += i;
    this.AS = (i + this.AS);
    this.sj.addAll(0, this.sl);
    List localList = aF(this.sl);
    x(false, localList);
    if (this.bjh)
    {
      Collections.reverse(localList);
      this.sk.addAll(localList);
    }
    for (;;)
    {
      this.sl.clear();
      return true;
      this.index += localList.size();
      this.sk.addAll(0, localList);
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    List localList;
    int i;
    label14:
    Object localObject;
    if (paramBoolean)
    {
      localList = this.sm;
      i = 0;
      if (i >= localList.size()) {
        break label235;
      }
      localObject = localList.get(i);
      if ((!paramBoolean) || (xuf.class.isInstance(localObject))) {
        break label70;
      }
    }
    label70:
    label209:
    do
    {
      do
      {
        do
        {
          do
          {
            i += 1;
            break label14;
            localList = this.sk;
            break;
            localObject = ((xuf)localObject).e;
            if (!AIOImageData.class.isInstance(localObject)) {
              break label129;
            }
            localObject = (AIOImageData)localObject;
          } while ((((AIOImageData)localObject).id != paramLong) || (((AIOImageData)localObject).subId != paramInt1));
          a(paramInt2, paramString, (AIOImageData)localObject);
          return i;
          if (!AIOShortVideoData.class.isInstance(localObject)) {
            break label169;
          }
          localObject = (AIOShortVideoData)localObject;
        } while (((AIOShortVideoData)localObject).id != paramLong);
        a(paramInt2, paramString, (AIOShortVideoData)localObject);
        return i;
        if (!AIOFilePicData.class.isInstance(localObject)) {
          break label209;
        }
        localObject = (AIOFilePicData)localObject;
      } while (((AIOFilePicData)localObject).id != paramLong);
      a(paramInt2, paramString, (AIOFilePicData)localObject);
      return i;
    } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).id != paramLong));
    label129:
    label169:
    return i;
    label235:
    return -1;
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public xuf a(int paramInt)
  {
    if ((paramInt < this.sk.size()) && (paramInt >= 0)) {
      return (xuf)this.sk.get(paramInt);
    }
    return null;
  }
  
  public xuf a(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.sk.iterator();
        if (localIterator.hasNext())
        {
          xuf localxuf = (xuf)localIterator.next();
          if (localxuf.e.id != paramLong) {
            continue;
          }
          if (localxuf != null)
          {
            this.sj.remove(localxuf);
            this.sk.remove(localxuf);
            x(true, this.sj);
          }
          return localxuf;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public boolean a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIORichMediaData.length - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if ((this.e == null) || (this.f == null))
      {
        localObject = new xuf((AIORichMediaData)localObject);
        this.f = ((xuf)localObject);
        this.e = ((xuf)localObject);
      }
    }
    i = 0;
    if (i < paramArrayOfAIORichMediaData.length)
    {
      localObject = paramArrayOfAIORichMediaData[i];
      if (this.mUpdated) {
        localArrayList.add(new xuf((AIORichMediaData)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.e.e.id == ((AIORichMediaData)localObject).id) && (this.e.e.subId == ((AIORichMediaData)localObject).subId))
        {
          this.e.isEnterImage = true;
          if (this.e == this.f) {
            this.bji = true;
          }
          localArrayList.add(this.e);
        }
        else if ((this.f.e.id == ((AIORichMediaData)localObject).id) && (this.f.e.subId == ((AIORichMediaData)localObject).subId))
        {
          localArrayList.add(this.f);
        }
        else
        {
          localArrayList.add(new xuf((AIORichMediaData)localObject));
        }
      }
    }
    if (((paramInt < 0) || (paramInt < paramArrayOfAIORichMediaData.length)) || (this.mUpdated)) {
      this.sl.addAll(0, localArrayList);
    }
    while (!this.bji) {
      return false;
    }
    this.sj = localArrayList;
    this.sk = aF(localArrayList);
    if (this.bjh) {
      Collections.reverse(this.sk);
    }
    if (this.e != null) {
      this.index = this.sk.indexOf(this.e);
    }
    if ((this.index < 0) || (this.index >= this.sk.size())) {
      this.index = this.sj.indexOf(this.e);
    }
    x(true, this.sj);
    this.mUpdated = true;
    return true;
  }
  
  public List<xuf> aF(List<xuf> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.bjj)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        xuf localxuf = (xuf)paramList.next();
        if (!AIOImageProviderService.a(localxuf.e)) {
          localArrayList.add(localxuf);
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public List<xuf> be()
  {
    return this.sk;
  }
  
  public xuf c()
  {
    return this.f;
  }
  
  public void ceL()
  {
    if ((this.sm.size() == 0) && (this.sj.size() > 0))
    {
      x(false, this.sj);
      this.bWW = this.sm.indexOf(this.f);
    }
  }
  
  public void ceM()
  {
    x(true, this.sj);
  }
  
  public xuf d()
  {
    return this.e;
  }
  
  public void g(xuf paramxuf)
  {
    this.sj.clear();
    this.sk.clear();
    this.index = 0;
    this.f = paramxuf;
    this.f.isEnterImage = true;
    this.e = this.f;
    this.sj.add(paramxuf);
    this.sk.add(paramxuf);
    x(false, this.sj);
  }
  
  public int getCount()
  {
    if (this.sk != null) {
      return this.sk.size();
    }
    return 0;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.Zw;
  }
  
  public int getLastVisiblePosition()
  {
    return this.AS;
  }
  
  public int getSelectedIndex()
  {
    return this.index;
  }
  
  public void h(xuf paramxuf)
  {
    this.sj.remove(paramxuf);
    this.sk.remove(paramxuf);
    x(true, this.sj);
  }
  
  public Object j(int paramInt)
  {
    return this.sm.get(paramInt);
  }
  
  public void setReverse(boolean paramBoolean)
  {
    if (this.bjh != paramBoolean)
    {
      this.bjh = paramBoolean;
      Collections.reverse(this.sk);
      this.index = (this.sk.size() - 1 - this.index);
    }
  }
  
  public void setSelectedIndex(int paramInt)
  {
    this.index = paramInt;
    this.f = a(paramInt);
    this.bWW = this.sm.indexOf(this.f);
  }
  
  public int ws()
  {
    if (this.sj != null) {
      return this.sj.size();
    }
    return 0;
  }
  
  public int wt()
  {
    return this.bWW;
  }
  
  public int wu()
  {
    return this.sm.size();
  }
  
  public int wv()
  {
    return wu() + this.a.wx();
  }
  
  public void x(boolean paramBoolean, List<xuf> paramList)
  {
    boolean bool = false;
    if (this.mColumnCount == 0) {
      return;
    }
    int i;
    if (paramBoolean)
    {
      this.sm.clear();
      this.bWV = -1;
      this.aWl = null;
      if (this.l == null)
      {
        this.l = Calendar.getInstance();
        this.l.setTimeInMillis(anaz.gQ() * 1000L);
      }
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label284;
      }
      localObject = (xuf)paramList.get(i);
      String str = a(this.l, ((xuf)localObject).e.time);
      if (!str.equals(this.aWl))
      {
        this.aWl = str;
        if (this.bWV != -1)
        {
          int k = this.bWV % this.mColumnCount;
          if (k > 0)
          {
            j = 0;
            for (;;)
            {
              if (j < this.mColumnCount - k)
              {
                this.sm.add(bS);
                j += 1;
                continue;
                this.a.J(this.sm, this.mColumnCount);
                break;
              }
            }
          }
        }
        this.bWV = 0;
        this.sm.add(str);
        int j = 0;
        while (j < this.mColumnCount - 1)
        {
          this.sm.add(bR);
          j += 1;
        }
      }
      this.sm.add(localObject);
      this.bWV += 1;
      i -= 1;
    }
    label284:
    Object localObject = this.a;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (!paramList.isEmpty()) {}
    }
    else
    {
      paramBoolean = true;
    }
    ((xud)localObject).e(paramBoolean, this.mColumnCount, this.sm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xto
 * JD-Core Version:    0.7.0.1
 */