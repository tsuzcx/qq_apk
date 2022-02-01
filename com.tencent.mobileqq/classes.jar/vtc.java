import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleRedPointEvent;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleHandler;
import com.tencent.biz.qqcircle.redpoint.EeveeRedPointManagerDelegate.1;
import com.tencent.biz.qqcircle.redpoint.EeveeRedPointManagerDelegate.2;
import com.tencent.biz.qqcircle.redpoint.EeveeRedPointManagerDelegate.3;
import com.tencent.biz.qqcircle.redpoint.EeveeRedPointManagerDelegate.4;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class vtc
  implements aaam, vte
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private QQCircleCounter.RedPointInfo jdField_a_of_type_QqcircleQQCircleCounter$RedPointInfo;
  private QQCircleCounter.RedPointInfo b;
  private QQCircleCounter.RedPointInfo c;
  
  public vtc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    aaak.a().a(this);
  }
  
  private void a(int paramInt, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    if (paramRedPointInfo != null)
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.4(this, paramInt, paramRedPointInfo));
      }
    }
    else {
      return;
    }
    b(paramInt, paramRedPointInfo);
  }
  
  private void b()
  {
    ??? = vlc.a().a(101);
    Object localObject2 = new StringBuilder().append("loadLocalSmallRedPointFromDataBase ");
    if (??? != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, bool);
      if (??? != null) {
        break;
      }
      return;
    }
    try
    {
      localObject2 = new QQCircleCounter.RedPointInfo();
      ((QQCircleCounter.RedPointInfo)localObject2).mergeFrom((byte[])???);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_QqcircleQQCircleCounter$RedPointInfo = ((QQCircleCounter.RedPointInfo)localObject2);
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "loadLocalSmallRedPointFromDataBase error! ", localInvalidProtocolBufferMicroException);
    }
  }
  
  private void b(int paramInt, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "saveRedPointToDataBase redPointMainMsgType: " + paramInt);
    if (paramRedPointInfo != null) {}
    try
    {
      vlc.a().a(paramInt, paramRedPointInfo.toByteArray());
      return;
    }
    catch (Throwable paramRedPointInfo)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "saveRedPointToDataBase error! ", paramRedPointInfo);
    }
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        ??? = vlc.a().a(106);
        Object localObject2 = new StringBuilder().append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          QLog.d("QCircleEeveeRedPointManagerDelegate", 1, bool);
          if (??? == null) {
            return;
          }
          localObject2 = new QQCircleCounter.RedPointInfo();
          ((QQCircleCounter.RedPointInfo)localObject2).mergeFrom((byte[])???);
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.c = ((QQCircleCounter.RedPointInfo)localObject2);
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "loadLocalNumRedPointInfoFromDataBase error! ", localThrowable);
        return;
      }
    }
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        ??? = vlc.a().a(102);
        Object localObject2 = new StringBuilder().append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          QLog.d("QCircleEeveeRedPointManagerDelegate", 1, bool);
          if (??? == null) {
            return;
          }
          localObject2 = new QQCircleCounter.RedPointInfo();
          ((QQCircleCounter.RedPointInfo)localObject2).mergeFrom((byte[])???);
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.b = ((QQCircleCounter.RedPointInfo)localObject2);
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "loadLocalNumRedPointInfoFromDataBase error! ", localThrowable);
        return;
      }
    }
  }
  
  public QQCircleCounter.RedPointInfo a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_QqcircleQQCircleCounter$RedPointInfo != null)
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = this.jdField_a_of_type_QqcircleQQCircleCounter$RedPointInfo;
          return localRedPointInfo;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.1(this));
          return null;
        }
      }
      b();
    }
  }
  
  public QQCircleCounter.RedPointInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return b();
  }
  
  public void a()
  {
    this.b = new QQCircleCounter.RedPointInfo();
    this.jdField_a_of_type_QqcircleQQCircleCounter$RedPointInfo = new QQCircleCounter.RedPointInfo();
    this.c = new QQCircleCounter.RedPointInfo();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((QCircleHandler)localQQAppInterface.a(183)).updateRedPoint();
    }
  }
  
  public void a(String arg1)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "setSmallRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = a();
    if (localRedPointInfo == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setSmallRedPointReaded return. redPointInfo is null");
      return;
    }
    vtd.d(localRedPointInfo.lastVisitTime.get());
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localRedPointInfo.clear();
      a(101, localRedPointInfo);
      return;
    }
  }
  
  public void a(String arg1, List<Integer> paramList)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "setOuterEntranceRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "[setOuterEntranceRedPointReaded] clearRedTypeList is empty!");
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = b();
    if (localRedPointInfo == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setOuterEntranceRedPointReaded return. redPointInfo is null");
      return;
    }
    long l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label205;
        }
        Integer localInteger = (Integer)paramList.next();
        l &= (1 << localInteger.intValue() ^ 0xFFFFFFFF);
        switch (localInteger.intValue())
        {
        case 1: 
          localRedPointInfo.rptRedInfo.clear();
        }
      }
      localRedPointInfo.redTotalNum.clear();
      continue;
      localRedPointInfo.allPushInfo.wording.clear();
      continue;
      label205:
      localRedPointInfo.outLayerInfo.combineRedTypes.set(l);
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "[setOuterEntranceRedPointReaded] combineRedTypes: " + l);
      a(106, localRedPointInfo);
      return;
    }
  }
  
  public void a(String paramString, vtg paramvtg, boolean paramBoolean)
  {
    if (paramvtg == null) {
      return;
    }
    Object localObject = c(paramString);
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
      paramvtg.a(paramString, i);
      return;
      label114:
      paramString = localIterator;
    }
  }
  
  public void a(String paramString, vth paramvth)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "onSmallRedPointClick appid: " + paramString);
  }
  
  public QQCircleCounter.RedPointInfo b()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.c != null)
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = this.c;
          return localRedPointInfo;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.2(this));
          return null;
        }
      }
      c();
    }
  }
  
  public QQCircleCounter.RedPointInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a();
  }
  
  public void b(String arg1)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "setNumRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = c();
    if (localRedPointInfo == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setNumRedPointReaded return. redPointInfo is null");
      return;
    }
    vtd.e(localRedPointInfo.lastVisitTime.get());
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localRedPointInfo.clear();
      a(102, localRedPointInfo);
      return;
    }
  }
  
  public QQCircleCounter.RedPointInfo c()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.b != null)
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = this.b;
          return localRedPointInfo;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.3(this));
          return null;
        }
      }
      d();
    }
  }
  
  public QQCircleCounter.RedPointInfo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return c();
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
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int i;
    if ((paramSimpleBaseEvent instanceof QCircleRedPointEvent))
    {
      QCircleRedPointEvent localQCircleRedPointEvent = (QCircleRedPointEvent)paramSimpleBaseEvent;
      ??? = localQCircleRedPointEvent.mRedPointInfo;
      paramSimpleBaseEvent = (SimpleBaseEvent)???;
      if (??? == null) {
        paramSimpleBaseEvent = new QQCircleCounter.RedPointInfo();
      }
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "on receive repoint. redPointMainMsgType: " + localQCircleRedPointEvent.mRedPointMainMsgType);
      switch (localQCircleRedPointEvent.mRedPointMainMsgType)
      {
      case 103: 
      case 104: 
      case 105: 
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      if ((i != 0) && (vtf.a()))
      {
        paramSimpleBaseEvent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramSimpleBaseEvent != null) {
          ((QCircleHandler)paramSimpleBaseEvent.a(183)).updateRedPoint();
        }
      }
      return;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_QqcircleQQCircleCounter$RedPointInfo = paramSimpleBaseEvent;
        i = 1;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.b = paramSimpleBaseEvent;
        i = 1;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.c = paramSimpleBaseEvent;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtc
 * JD-Core Version:    0.7.0.1
 */