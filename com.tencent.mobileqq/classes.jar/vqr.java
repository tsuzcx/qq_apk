import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleRedPointEvent;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleHandler;
import com.tencent.biz.qqcircle.redpoint.EeveeRedPointManagerDelegate.1;
import com.tencent.biz.qqcircle.redpoint.EeveeRedPointManagerDelegate.2;
import com.tencent.biz.qqcircle.redpoint.EeveeRedPointManagerDelegate.3;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleCounter.CountInfoRsp;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class vqr
  implements vqt, zwr
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private QQCircleCounter.CountInfoRsp jdField_a_of_type_QqcircleQQCircleCounter$CountInfoRsp;
  private QQCircleCounter.CountInfoRsp b;
  
  public vqr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    zwp.a().a(this);
  }
  
  private QQCircleCounter.RedPointInfo a(String paramString, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCountInfoRsp == null)) {
      return null;
    }
    paramCountInfoRsp = paramCountInfoRsp.rptRedPoint.get();
    if ((paramCountInfoRsp != null) && (paramCountInfoRsp.size() > 0))
    {
      paramCountInfoRsp = paramCountInfoRsp.iterator();
      while (paramCountInfoRsp.hasNext())
      {
        QQCircleCounter.RedPointInfo localRedPointInfo = (QQCircleCounter.RedPointInfo)paramCountInfoRsp.next();
        if (paramString.equals(localRedPointInfo.appid.get())) {
          return localRedPointInfo;
        }
      }
    }
    return null;
  }
  
  private void a()
  {
    ??? = viy.a().a(101);
    Object localObject2 = new StringBuilder().append("loadLocalSmallRedPointRspFromDataBase ");
    if (??? != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("EeveeRedPointManagerDelegate", 1, bool);
      if (??? != null) {
        break;
      }
      return;
    }
    try
    {
      localObject2 = new QQCircleCounter.CountInfoRsp();
      ((QQCircleCounter.CountInfoRsp)localObject2).mergeFrom((byte[])???);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_QqcircleQQCircleCounter$CountInfoRsp = ((QQCircleCounter.CountInfoRsp)localObject2);
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      QLog.e("EeveeRedPointManagerDelegate", 1, "loadLocalSmallRedPointRspFromDataBase error! ", localInvalidProtocolBufferMicroException);
    }
  }
  
  private void a(int paramInt, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    if (paramCountInfoRsp != null)
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.3(this, paramInt, paramCountInfoRsp));
      }
    }
    else {
      return;
    }
    b(paramInt, paramCountInfoRsp);
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        ??? = viy.a().a(102);
        Object localObject2 = new StringBuilder().append("loadLocalNumRedPointRspFromDataBase ");
        if (??? != null)
        {
          bool = true;
          QLog.d("EeveeRedPointManagerDelegate", 1, bool);
          if (??? == null) {
            return;
          }
          localObject2 = new QQCircleCounter.CountInfoRsp();
          ((QQCircleCounter.CountInfoRsp)localObject2).mergeFrom((byte[])???);
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.b = ((QQCircleCounter.CountInfoRsp)localObject2);
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("EeveeRedPointManagerDelegate", 1, "loadLocalNumRedPointRspFromDataBase error! ", localThrowable);
        return;
      }
    }
  }
  
  private void b(int paramInt, QQCircleCounter.CountInfoRsp paramCountInfoRsp)
  {
    QLog.d("EeveeRedPointManagerDelegate", 1, "saveRedPointRspToDataBase redPointMainMsgType: " + paramInt);
    if (paramCountInfoRsp != null) {}
    try
    {
      viy.a().a(paramInt, paramCountInfoRsp.toByteArray());
      return;
    }
    catch (Throwable paramCountInfoRsp)
    {
      QLog.e("EeveeRedPointManagerDelegate", 1, "saveRedPointRspToDataBase error! ", paramCountInfoRsp);
    }
  }
  
  public QQCircleCounter.CountInfoRsp a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_QqcircleQQCircleCounter$CountInfoRsp != null)
        {
          QQCircleCounter.CountInfoRsp localCountInfoRsp = this.jdField_a_of_type_QqcircleQQCircleCounter$CountInfoRsp;
          return localCountInfoRsp;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.1(this));
          return null;
        }
      }
      a();
    }
  }
  
  public QQCircleCounter.RedPointInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramString, a(paramString, a()));
  }
  
  protected QQCircleCounter.RedPointInfo a(String paramString, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1;
    if (paramRedPointInfo != null)
    {
      localObject1 = localObject3;
      if ("circle_entrance".equals(paramString)) {
        switch (paramRedPointInfo.redType.get())
        {
        default: 
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramRedPointInfo == null)
      {
        QLog.d("EeveeRedPointManagerDelegate", 1, "filterInvalidRedPointInfo reddot has been filtered! ");
        localObject2 = localObject1;
      }
      return localObject2;
      long l1 = paramRedPointInfo.lastVisitTime.get();
      long l2 = vqs.b();
      QLog.d("EeveeRedPointManagerDelegate", 1, "filterInvalidRedPointInfo SmallRedPoint, redDotLastVisitTime: " + l1 + ", followTabFeedListLastRspTimestamp: " + l2);
      localObject1 = localObject3;
      if (l1 >= l2)
      {
        localObject1 = paramRedPointInfo;
        continue;
        l1 = paramRedPointInfo.lastVisitTime.get();
        l2 = vqs.a();
        QLog.d("EeveeRedPointManagerDelegate", 1, "filterInvalidRedPointInfo NumRedPoint, redDotLastVisitTime " + l1 + ", noticeFeedListLastRspTimestamp: " + l2);
        localObject1 = localObject3;
        if (l1 >= l2) {
          localObject1 = paramRedPointInfo;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.d("EeveeRedPointManagerDelegate", 1, "setSmallRedPointReaded appid: " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQCircleCounter.CountInfoRsp localCountInfoRsp = a();
    if (localCountInfoRsp == null)
    {
      QLog.e("EeveeRedPointManagerDelegate", 1, "setSmallRedPointReaded failed. countInfoRsp is null");
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localCountInfoRsp.rptRedPoint.clear();
        ??? = localCountInfoRsp.rptRedPoint.get();
        if (??? != null)
        {
          i = ((List)???).size() - 1;
          if (i >= 0)
          {
            if (!paramString.equals(((QQCircleCounter.RedPointInfo)((List)???).get(i)).appid.get())) {
              break label145;
            }
            ((List)???).remove(i);
          }
        }
        a(101, localCountInfoRsp);
        return;
      }
      label145:
      i -= 1;
    }
  }
  
  public void a(String paramString, vqv paramvqv, boolean paramBoolean)
  {
    if (paramvqv == null) {
      return;
    }
    Object localObject = b(paramString);
    int i = 0;
    Iterator localIterator = null;
    paramString = localIterator;
    if (localObject != null)
    {
      i = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
      localObject = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
      if (localObject == null) {
        break label114;
      }
      paramString = new ArrayList();
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        paramString.add(((QQCircleCounter.RedDisplayInfo)localIterator.next()).headImg.get());
      }
    }
    for (;;)
    {
      paramvqv.a(paramString, i);
      return;
      label114:
      paramString = localIterator;
    }
  }
  
  public void a(String paramString, vqw paramvqw)
  {
    QLog.d("EeveeRedPointManagerDelegate", 1, "onSmallRedPointClick appid: " + paramString);
    a(paramString);
  }
  
  public QQCircleCounter.CountInfoRsp b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.b != null)
        {
          QQCircleCounter.CountInfoRsp localCountInfoRsp = this.b;
          return localCountInfoRsp;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.2(this));
          return null;
        }
      }
      b();
    }
  }
  
  public QQCircleCounter.RedPointInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramString, a(paramString, b()));
  }
  
  public void b(String paramString)
  {
    QLog.d("EeveeRedPointManagerDelegate", 1, "setNumRedPointReaded appid: " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQCircleCounter.CountInfoRsp localCountInfoRsp = b();
    if (localCountInfoRsp == null)
    {
      QLog.e("EeveeRedPointManagerDelegate", 1, "setNumRedPointReaded failed. countInfoRsp is null");
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localCountInfoRsp.rptRedPoint.clear();
        ??? = localCountInfoRsp.rptRedPoint.get();
        if (??? != null)
        {
          i = ((List)???).size() - 1;
          if (i >= 0)
          {
            if (!paramString.equals(((QQCircleCounter.RedPointInfo)((List)???).get(i)).appid.get())) {
              break label147;
            }
            ((List)???).remove(i);
          }
        }
        a(102, localCountInfoRsp);
        return;
      }
      label147:
      i -= 1;
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleRedPointEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int i = 1;
    if ((paramSimpleBaseEvent instanceof QCircleRedPointEvent))
    {
      ??? = (QCircleRedPointEvent)paramSimpleBaseEvent;
      paramSimpleBaseEvent = ((QCircleRedPointEvent)???).mCountInfoRsp;
      if (paramSimpleBaseEvent != null)
      {
        QLog.d("EeveeRedPointManagerDelegate", 1, "on receive repoint. redPointMainMsgType: " + ((QCircleRedPointEvent)???).mRedPointMainMsgType);
        switch (((QCircleRedPointEvent)???).mRedPointMainMsgType)
        {
        default: 
          i = 0;
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (vqu.a()))
      {
        paramSimpleBaseEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramSimpleBaseEvent != null) {
          ((QCircleHandler)paramSimpleBaseEvent.a(183)).updateRedPoint();
        }
      }
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_QqcircleQQCircleCounter$CountInfoRsp = paramSimpleBaseEvent;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.b = paramSimpleBaseEvent;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqr
 * JD-Core Version:    0.7.0.1
 */