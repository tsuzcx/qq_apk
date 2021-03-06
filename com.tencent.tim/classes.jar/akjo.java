import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tencent.im.oidb.redInfo.RedInfo;

public class akjo
  implements akjx
{
  WeakReference<akjp> aQ;
  QQAppInterface app;
  
  public akjo(QQAppInterface paramQQAppInterface, akjp paramakjp)
  {
    this.aQ = new WeakReference(paramakjp);
    this.app = paramQQAppInterface;
  }
  
  public static String eE(int paramInt)
  {
    return "file_redpoint_handler_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + paramInt;
  }
  
  public akjp a()
  {
    if (this.aQ == null) {
      return null;
    }
    return (akjp)this.aQ.get();
  }
  
  public void a(RedTouchItem paramRedTouchItem, int paramInt)
  {
    boolean bool1 = true;
    if ((paramInt == 10016) || (paramInt == 10015)) {
      if (!akka.bg(this.app))
      {
        bool1 = true;
        paramRedTouchItem.isClosed = bool1;
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      if (paramInt == 100601)
      {
        if (!akka.bh(this.app)) {}
        for (;;)
        {
          paramRedTouchItem.isClosed = bool1;
          return;
          bool1 = false;
        }
      }
    } while (!akjv.kJ(paramInt));
    Object localObject1 = "";
    Object localObject2;
    Object localObject4;
    boolean bool2;
    if (paramRedTouchItem.extMsgs.size() > 0)
    {
      RedTouchItemExtMsg localRedTouchItemExtMsg2 = (RedTouchItemExtMsg)paramRedTouchItem.extMsgs.get(0);
      if ((localRedTouchItemExtMsg2.bytesData == null) || (localRedTouchItemExtMsg2.bytesData.length <= 0)) {
        break label455;
      }
      try
      {
        localObject2 = new redInfo.RedInfo();
      }
      catch (Throwable localThrowable1)
      {
        label192:
        localObject2 = null;
      }
    }
    try
    {
      ((redInfo.RedInfo)localObject2).mergeFrom(localRedTouchItemExtMsg2.bytesData);
      localObject4 = localObject2;
      if ((localObject4 == null) || (!localObject4.uint64_from_uin.has())) {
        break label445;
      }
      localObject2 = localObject4.uint64_from_uin.get() + "";
      bool2 = true;
    }
    catch (Throwable localThrowable2)
    {
      break label340;
      bool2 = false;
      localObject2 = localObject1;
      break label192;
    }
    localObject1 = localObject2;
    bool1 = bool2;
    if (localRedTouchItemExtMsg2.bytesData.length > 102400)
    {
      QLog.d("DefaultRedPointPrePostHandler", 1, String.format("onPreHandle() id=[%d] msgs.size=%d bytes_data.len=%d too large !!", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramRedTouchItem.extMsgs.size()), Integer.valueOf(localRedTouchItemExtMsg2.bytesData.length) }));
      bool1 = bool2;
      localObject1 = localObject2;
    }
    for (;;)
    {
      RedTouchItemExtMsg localRedTouchItemExtMsg1 = localRedTouchItemExtMsg2;
      localObject2 = localObject1;
      bool2 = bool1;
      label340:
      Object localObject3;
      if (paramRedTouchItem.extMsgs.size() > 1)
      {
        paramInt = paramRedTouchItem.extMsgs.size() - 1;
        for (;;)
        {
          localRedTouchItemExtMsg1 = localRedTouchItemExtMsg2;
          localObject2 = localObject1;
          bool2 = bool1;
          if (paramInt <= 0) {
            break;
          }
          paramRedTouchItem.extMsgs.remove(paramInt);
          paramInt -= 1;
        }
        localObject4 = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("DefaultRedPointPrePostHandler", 2, localThrowable1.getMessage(), localThrowable1);
        localObject4 = localObject2;
        break;
        localObject3 = null;
        bool2 = false;
        localObject2 = localObject1;
      }
      if (bool2) {
        aqhq.y(eE(-4), localObject3);
      }
      for (;;)
      {
        QLog.d("DefaultRedPointPrePostHandler", 1, new Object[] { "isQQSettingMeBubbleMsg show=", Boolean.valueOf(bool2), " uin=", aqmr.getSimpleUinForPrint((String)localObject2) });
        return;
        paramRedTouchItem.count = 0;
      }
      label445:
      label455:
      bool1 = false;
    }
  }
  
  public void lE(List<RedTouchItem> paramList)
  {
    akjp localakjp = a();
    if ((paramList == null) || (localakjp == null)) {
      return;
    }
    Object localObject2 = null;
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = localObject2;
      if (((RedTouchItem)((Iterator)localObject3).next()).taskId == 10005) {
        localObject1 = "0X800761B";
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        anot.a(this.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        localObject2 = localObject1;
      }
    }
    localObject3 = localakjp.a(10015);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (paramList.contains(localObject3))
      {
        localObject1 = "0X8007391";
        anot.a(this.app, "dc00898", "", "", "0X8007391", "0X8007391", 0, 0, "", "", "", "");
        ((MedalWallMng)this.app.getManager(250)).dvP();
      }
    }
    localObject2 = localakjp.a(10016);
    if ((localObject2 != null) && (paramList.contains(localObject2)) && (((RedTouchItem)localObject2).bytes != null) && (((RedTouchItem)localObject2).bytes.length > 0)) {}
    for (;;)
    {
      try
      {
        int i = new JSONObject(new String(((RedTouchItem)localObject2).bytes, "utf-8")).optInt("type", 1);
        switch (i)
        {
        default: 
          localObject2 = localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DefaultRedPointPrePostHandler", 2, localException, new Object[0]);
        localObject2 = localObject1;
        continue;
        paramList.a((RedTouchItem)localObject1);
      }
      if (localObject2 != null) {
        anot.a(this.app, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
      }
      localObject1 = localakjp.a(10018);
      if ((localObject1 == null) || (!paramList.contains(localObject1)) || (((RedTouchItem)localObject1).extMsgs == null) || (((RedTouchItem)localObject1).extMsgs.size() <= 0) || (!((RedTouchItem)localObject1).unReadFlag)) {
        break;
      }
      paramList = (aegs)this.app.getManager(269);
      localObject2 = paramList.a();
      if ((localObject2 != null) && (((aegp)localObject2).agF())) {
        continue;
      }
      ((RedTouchItem)localObject1).unReadFlag = false;
      localakjp.dBz();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("DefaultRedPointPrePostHandler", 2, "onPostDealReachedRedPoints frdRecMsgSwitch is off");
      return;
      localObject2 = "0X8007396";
      continue;
      localObject2 = "0X80073B5";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjo
 * JD-Core Version:    0.7.0.1
 */