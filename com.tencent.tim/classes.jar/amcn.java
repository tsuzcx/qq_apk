import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class amcn
  extends MainBrowserModel
{
  int AS;
  int Zw;
  public RichMediaBrowserInfo a;
  boolean bjh = false;
  boolean bji = false;
  private amcv c;
  boolean mUpdated = false;
  List<RichMediaBrowserInfo> sl = new ArrayList();
  
  public amcn(amcv paramamcv)
  {
    super(paramamcv);
    this.c = paramamcv;
  }
  
  public static boolean a(AIOBrowserBaseData paramAIOBrowserBaseData)
  {
    if (paramAIOBrowserBaseData == null) {}
    while ((paramAIOBrowserBaseData.getType() != 100) && (paramAIOBrowserBaseData.getType() != 101) && (paramAIOBrowserBaseData.getType() != 102) && (paramAIOBrowserBaseData.getType() != 103)) {
      return false;
    }
    return true;
  }
  
  public void P(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.browserDataList != null)
    {
      int j = this.browserDataList.size();
      int i = 0;
      while (i < j)
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData;
        if ((paramLong == localAIOBrowserBaseData.msgId) && (paramInt1 == localAIOBrowserBaseData.subId)) {
          ((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData.updateStatus(paramInt2);
        }
        i += 1;
      }
    }
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
    List localList = aF(this.sl);
    if (this.bjh)
    {
      Collections.reverse(localList);
      this.browserDataList.addAll(localList);
    }
    for (;;)
    {
      this.sl.clear();
      return true;
      this.currentIndex += localList.size();
      this.browserDataList.addAll(0, localList);
    }
  }
  
  public int Z(long paramLong)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)localIterator.next()).baseData;
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.msgId)) {
          return localAIOBrowserBaseData.getType();
        }
      }
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.browserDataList;
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = localList.get(i);
      if (!RichMediaBrowserInfo.class.isInstance(localObject)) {}
      label119:
      do
      {
        do
        {
          do
          {
            do
            {
              i += 1;
              break;
              localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
              if (!AIOPictureData.class.isInstance(localObject)) {
                break label119;
              }
              localObject = (AIOPictureData)localObject;
            } while ((((AIOPictureData)localObject).msgId != paramLong) || (((AIOPictureData)localObject).subId != paramInt1));
            new amcs().a((AIOPictureData)localObject, paramInt2, paramString);
            return i;
            if (!AIOVideoData.class.isInstance(localObject)) {
              break label165;
            }
            localObject = (AIOVideoData)localObject;
          } while (((AIOVideoData)localObject).msgId != paramLong);
          new amct().a((AIOVideoData)localObject, paramInt2, paramString);
          return i;
          if (!AIOFilePictureData.class.isInstance(localObject)) {
            break label211;
          }
          localObject = (AIOFilePictureData)localObject;
        } while (((AIOFilePictureData)localObject).msgId != paramLong);
        new amco().a((AIOFilePictureData)localObject, paramInt2, paramString);
        return i;
      } while ((!AIOFileVideoData.class.isInstance(localObject)) || (((AIOFileVideoData)localObject).msgId != paramLong));
      label165:
      label211:
      return i;
    }
    return -1;
  }
  
  public RichMediaBrowserInfo a()
  {
    return this.a;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        if (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).msgId) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)localRichMediaBrowserInfo.baseData;
        if ((paramLong1 == localAIOBrowserBaseData.msgId) && (paramLong2 == localAIOBrowserBaseData.subId)) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.browserDataList.clear();
    this.currentIndex = 0;
    this.currentBrowserInfo = paramRichMediaBrowserInfo;
    this.currentBrowserInfo.isEnterImage = true;
    this.a = this.currentBrowserInfo;
    this.browserDataList.add(paramRichMediaBrowserInfo);
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, long paramLong)
  {
    if ((b(paramRichMediaBrowserInfo)) && (paramRichMediaBrowserInfo.baseData.getType() == 101)) {
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).aiy = paramLong;
    }
  }
  
  public boolean a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIOBrowserBaseData.length - 1;
    if (i >= 0)
    {
      localAIOBrowserBaseData1 = paramArrayOfAIOBrowserBaseData[i];
      if ((this.a == null) || (this.currentBrowserInfo == null))
      {
        localObject = new RichMediaBrowserInfo();
        ((RichMediaBrowserInfo)localObject).baseData = localAIOBrowserBaseData1;
        this.currentBrowserInfo = ((RichMediaBrowserInfo)localObject);
        this.a = ((RichMediaBrowserInfo)localObject);
      }
    }
    AIOBrowserBaseData localAIOBrowserBaseData1 = (AIOBrowserBaseData)this.a.baseData;
    Object localObject = (AIOBrowserBaseData)this.currentBrowserInfo.baseData;
    i = 0;
    if (i < paramArrayOfAIOBrowserBaseData.length)
    {
      AIOBrowserBaseData localAIOBrowserBaseData2 = paramArrayOfAIOBrowserBaseData[i];
      RichMediaBrowserInfo localRichMediaBrowserInfo;
      if (this.mUpdated)
      {
        localRichMediaBrowserInfo = new RichMediaBrowserInfo();
        localRichMediaBrowserInfo.baseData = localAIOBrowserBaseData2;
        localArrayList.add(localRichMediaBrowserInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localAIOBrowserBaseData1.msgId == localAIOBrowserBaseData2.msgId) && (localAIOBrowserBaseData1.subId == localAIOBrowserBaseData2.subId))
        {
          this.a.isEnterImage = true;
          if (this.a == this.currentBrowserInfo) {
            this.bji = true;
          }
          localArrayList.add(this.a);
        }
        else if ((((AIOBrowserBaseData)localObject).msgId == localAIOBrowserBaseData2.msgId) && (((AIOBrowserBaseData)localObject).subId == localAIOBrowserBaseData2.subId))
        {
          localArrayList.add(this.currentBrowserInfo);
        }
        else
        {
          localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localRichMediaBrowserInfo.baseData = localAIOBrowserBaseData2;
          localArrayList.add(localRichMediaBrowserInfo);
        }
      }
    }
    if (((paramInt < 0) || (paramInt < paramArrayOfAIOBrowserBaseData.length)) || (this.mUpdated)) {
      this.sl.addAll(0, localArrayList);
    }
    while (!this.bji) {
      return false;
    }
    this.browserDataList = aF(localArrayList);
    if (this.bjh) {
      Collections.reverse(this.browserDataList);
    }
    if (this.a != null) {
      this.currentIndex = this.browserDataList.indexOf(this.a);
    }
    if (b(getItem(this.currentIndex))) {
      updateItem(this.currentBrowserInfo, this.currentIndex);
    }
    this.mUpdated = true;
    return true;
  }
  
  public List<RichMediaBrowserInfo> aF(List<RichMediaBrowserInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)paramList.next();
        if (a((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData)) {
          localArrayList.add(localRichMediaBrowserInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public RichMediaBrowserInfo b(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.browserDataList.iterator();
        if (localIterator.hasNext())
        {
          RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
          if (((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).msgId != paramLong) {
            continue;
          }
          if (localRichMediaBrowserInfo != null) {
            this.browserDataList.remove(localRichMediaBrowserInfo);
          }
          return localRichMediaBrowserInfo;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public void b(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (b(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() != 101) {
        break label32;
      }
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).isAutoPlay = true;
    }
    label32:
    while (paramRichMediaBrowserInfo.baseData.getType() != 103) {
      return;
    }
    ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).isAutoPlay = true;
  }
  
  public boolean b(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return (paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && ((paramRichMediaBrowserInfo.baseData.getType() == 101) || (paramRichMediaBrowserInfo.baseData.getType() == 103));
  }
  
  public List<RichMediaBrowserInfo> be()
  {
    return this.browserDataList;
  }
  
  public void c(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (b(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() != 101) {
        break label32;
      }
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).isMutePlay = true;
    }
    label32:
    while (paramRichMediaBrowserInfo.baseData.getType() != 103) {
      return;
    }
    ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).isMutePlay = true;
  }
  
  public int f(long paramLong, int paramInt)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)localIterator.next()).baseData;
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.msgId) && (paramInt == localAIOBrowserBaseData.subId)) {
          return localAIOBrowserBaseData.getType();
        }
      }
    }
    return -1;
  }
  
  public void setReverse(boolean paramBoolean)
  {
    if (this.bjh != paramBoolean)
    {
      this.bjh = paramBoolean;
      Collections.reverse(this.browserDataList);
      this.currentIndex = (this.browserDataList.size() - 1 - this.currentIndex);
    }
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (this.browserDataList != null))
    {
      int j = this.browserDataList.size();
      AIOBrowserBaseData localAIOBrowserBaseData1 = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
      int i = 0;
      while (i < j)
      {
        AIOBrowserBaseData localAIOBrowserBaseData2 = (AIOBrowserBaseData)((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData;
        if ((localAIOBrowserBaseData1.msgId == localAIOBrowserBaseData2.msgId) && (localAIOBrowserBaseData1.subId == localAIOBrowserBaseData2.subId)) {
          this.browserDataList.set(i, paramRichMediaBrowserInfo);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcn
 * JD-Core Version:    0.7.0.1
 */