import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class amch
{
  public static List<aexe> a(long paramLong1, long paramLong2, aeey paramaeey, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (paramConcurrentHashMap != null) {
      return a(a(paramConcurrentHashMap, paramLong2), paramaeey);
    }
    return null;
  }
  
  public static List<aexe> a(long paramLong, List<DanmuItemBean> paramList, aeey paramaeey, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramaeey == null)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildPictureDanmakuList list is null");
    }
    do
    {
      return null;
      paramConcurrentHashMap = a(paramLong, paramList, paramConcurrentHashMap);
    } while ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.isEmpty()));
    paramList = new ArrayList();
    paramConcurrentHashMap = paramConcurrentHashMap.iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      aexe localaexe = paramaeey.a(new aefd((DanmuItemBean)paramConcurrentHashMap.next()));
      if (localaexe != null)
      {
        localaexe.Mm(5000);
        localaexe.HA(true);
        paramList.add(localaexe);
      }
    }
    return paramList;
  }
  
  public static List<aexe> a(long paramLong1, List<DanmuItemBean> paramList, aeey paramaeey, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap, long paramLong2)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildVideoDanmakuList list is null");
      return null;
    }
    return a(a(paramLong1, paramList, paramConcurrentHashMap, paramLong2), paramaeey);
  }
  
  private static List<DanmuItemBean> a(long paramLong, List<DanmuItemBean> paramList, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    Object localObject = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      localObject = new ArraySet();
      ((Set)localObject).addAll(paramList);
      paramConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
      return paramList;
    }
    paramConcurrentHashMap.clear();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramList.next();
      if (!((Set)localObject).contains(localDanmuItemBean)) {
        localArrayList.add(localDanmuItemBean);
      }
    }
    ((Set)localObject).addAll(localArrayList);
    paramConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
    return localArrayList;
  }
  
  private static List<DanmuItemBean> a(long paramLong1, List<DanmuItemBean> paramList, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap, long paramLong2)
  {
    Set localSet = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong1));
    Object localObject = new ArraySet();
    ((Set)localObject).addAll(paramList);
    if (localSet == null)
    {
      paramConcurrentHashMap.put(Long.valueOf(paramLong1), localObject);
      return a((Set)localObject, paramLong2);
    }
    paramConcurrentHashMap.clear();
    paramList = new ArraySet();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
      if (!localSet.contains(localDanmuItemBean)) {
        paramList.add(localDanmuItemBean);
      }
    }
    localSet.addAll(paramList);
    paramConcurrentHashMap.put(Long.valueOf(paramLong1), localSet);
    return a(paramList, paramLong2);
  }
  
  private static List<aexe> a(List<DanmuItemBean> paramList, aeey paramaeey)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramaeey != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (DanmuItemBean)paramList.next();
        aefd localaefd = new aefd((DanmuItemBean)localObject);
        aexe localaexe = paramaeey.a(localaefd);
        if (localaexe != null)
        {
          localaexe.setTime(((DanmuItemBean)localObject).VU);
          if (!TextUtils.isEmpty(localaefd.uin))
          {
            localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localaefd.uin))) {
              localaexe.HA(true);
            }
          }
          localArrayList.add(localaexe);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private static List<DanmuItemBean> a(Set<DanmuItemBean> paramSet, long paramLong)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramSet.next();
        if (localDanmuItemBean.VU + 1000L >= paramLong) {
          localArrayList.add(localDanmuItemBean);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (!aeew.agy()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldShowDanmakuBtn, paramsManager.isFromMultiMsg() = ").append(amcj.a().avB());
      localStringBuilder.append(" , paramsManager.getmCurType() = ").append(amcj.a().Iz());
      localStringBuilder.append(" , paramsManager.getSourceEntrance() = ").append(amcj.a().IB());
      localStringBuilder.append(" , paramsManager.isReplyMsgFromSameSession() = ").append(amcj.a().avG());
      localStringBuilder.append(" , paramsManager.isMixedMsg = ").append(amcj.a().cCi);
      localStringBuilder.append(" , paramsManager.isReplySrcMsgExist = ").append(amcj.a().cCj);
      if ((paramRichMediaBrowserInfo != null) && ((paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)))
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
        localStringBuilder.append(", galleryInfo.mData.isInMixedMsg = ").append(localAIOBrowserBaseData.isInMixedMsg).append(" isMsgSeqReady = ").append(localAIOBrowserBaseData.bjq);
      }
      QLog.d("BrowserDanmakuUtils", 2, localStringBuilder.toString());
    }
    return (!amcj.a().avB()) && (amcj.a().Iz() == 1) && (amcj.a().IB() != 4) && (amcj.a().avG()) && (amcj.a().cCj) && ((paramRichMediaBrowserInfo == null) || (!(paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (!((AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData).isInMixedMsg)) && ((paramRichMediaBrowserInfo == null) || (!(paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (((AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData).bjq));
  }
  
  public static boolean avy()
  {
    return (aeew.agy()) && (amcj.a().Iz() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amch
 * JD-Core Version:    0.7.0.1
 */