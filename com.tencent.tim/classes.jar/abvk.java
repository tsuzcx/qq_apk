import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class abvk
  implements abrn
{
  public static boolean bFW;
  abrc a;
  private boolean bDz;
  private boolean bFV;
  private int ctc = 1;
  
  public abvk(abrc paramabrc)
  {
    this.a = paramabrc;
  }
  
  private void cFK()
  {
    if (!this.bDz) {}
    Object localObject;
    abhe localabhe;
    abhh localabhh;
    do
    {
      do
      {
        return;
        this.bDz = false;
        localObject = this.a.getApp();
      } while (localObject == null);
      localabhe = (abhe)((QQAppInterface)localObject).getManager(211);
      localabhh = (abhh)((QQAppInterface)localObject).getManager(153);
      localObject = null;
      if (localabhe.a != null) {
        localObject = localabhe.a.a();
      }
    } while ((localObject == null) || ((((DrawerPushItem)localObject).msg_type != 7) && (((DrawerPushItem)localObject).msg_type != 9) && (((DrawerPushItem)localObject).msg_type != 2) && (((DrawerPushItem)localObject).msg_type != 10)));
    QLog.i("ApolloBubbleLogic", 1, "checkIfPanelBubble remove panel bubble");
    localabhh.a((DrawerPushItem)localObject);
    localabhe.a.cFJ();
  }
  
  private void ch(QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_";
    String str1 = (String)localObject1 + ApolloUtil.rt();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    if (((SharedPreferences)localObject2).contains(str1)) {
      localEditor.putInt(str1, ((SharedPreferences)localObject2).getInt(str1, 0) + 1);
    }
    for (;;)
    {
      localEditor.commit();
      ci(paramQQAppInterface);
      return;
      Object localObject3 = ((SharedPreferences)localObject2).getAll();
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          String str2 = (String)localEntry.getKey();
          if ((str2 != null) && (str2.startsWith((String)localObject1))) {
            ((List)localObject2).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEditor.remove((String)((Iterator)localObject1).next());
        }
      }
      localEditor.putInt(str1, 1);
    }
  }
  
  public static void ci(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtil.rt(), 0) >= localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3)) {
        bool = true;
      }
      bFW = bool;
    }
  }
  
  public void HV(int paramInt)
  {
    this.ctc = paramInt;
    switch (paramInt)
    {
    }
    label304:
    for (;;)
    {
      return;
      cFK();
      return;
      QQAppInterface localQQAppInterface = this.a.getApp();
      if ((localQQAppInterface != null) && (this.a.a() != null) && (abrj.a(localQQAppInterface) != null))
      {
        SharedPreferences localSharedPreferences = localQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        int i = localSharedPreferences.getInt(localQQAppInterface.getCurrentAccountUin() + "_aio_bubble_count_" + ApolloUtil.rt(), 0);
        int j = localSharedPreferences.getInt("sp_key_aio_bubble_max_count", 3);
        if (i >= j)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO Bubble show count limited:", Integer.valueOf(j) });
          }
        }
        else if (this.bFV)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "current AIO has play bubble, wait for next time");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, "start play bubble");
          }
          if (X(localQQAppInterface)) {
            paramInt = 2;
          }
          for (;;)
          {
            if (paramInt <= 0) {
              break label304;
            }
            this.bDz = true;
            this.bFV = true;
            ch(localQQAppInterface);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "AIO bubble play type:", Integer.valueOf(paramInt), ",current count:", Integer.valueOf(i), ",maxCount:", Integer.valueOf(j) });
            return;
            if (Y(localQQAppInterface)) {
              paramInt = 3;
            } else {
              paramInt = 0;
            }
          }
        }
      }
    }
  }
  
  public boolean X(QQAppInterface paramQQAppInterface)
  {
    abhe localabhe = (abhe)paramQQAppInterface.getManager(211);
    if (localabhe.a != null) {}
    for (DrawerPushItem localDrawerPushItem = localabhe.a.a();; localDrawerPushItem = null)
    {
      if ((localDrawerPushItem != null) && (localDrawerPushItem.msg_type != 7) && (localabhe.a.g(paramQQAppInterface, this.a.mAioType)))
      {
        if (localDrawerPushItem.reddotGameId > 0)
        {
          localabhe.coA = localDrawerPushItem.reddotGameId;
          localabhe.gA(localDrawerPushItem.reddotGameId, 3);
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_msg_display", ApolloUtil.gi(this.a.mAioType), 3, new String[] { String.valueOf(localDrawerPushItem.reddotGameId), String.valueOf(localDrawerPushItem.reddotRedId) });
          if (QLog.isColorLevel()) {
            QLog.d("ApolloBubbleLogic", 2, new Object[] { "show aio bubble for reddot game, game id=", Integer.valueOf(localDrawerPushItem.reddotGameId) });
          }
        }
        return true;
      }
      return false;
    }
  }
  
  public boolean Y(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    abhe localabhe = (abhe)paramQQAppInterface.getManager(211);
    if (localabhe.a != null) {}
    for (Object localObject = localabhe.a.a();; localObject = null)
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((DrawerPushItem)localObject).msg_type == 7)
        {
          localObject = (abhh)paramQQAppInterface.getManager(153);
          bool1 = bool2;
          if (localabhe.a.g(paramQQAppInterface, this.a.mAioType))
          {
            if (localObject != null) {
              ((abhh)localObject).bCO = true;
            }
            VipUtils.a(null, "cmshow", "Apollo", "peoplebubble", ApolloUtil.gi(this.a.mAioType), 0, new String[] { String.valueOf(1) });
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
  
  public void destroy()
  {
    if (this.a != null)
    {
      abhe localabhe = (abhe)this.a.getApp().getManager(211);
      localabhe.coA = -1;
      localabhe.gA(-1, -1);
    }
    this.a = null;
    this.bFV = false;
  }
  
  public int zT()
  {
    return this.ctc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvk
 * JD-Core Version:    0.7.0.1
 */