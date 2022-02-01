package com.tencent.biz.pubaccount.readinjoy.engine;

import aajt;
import acbn;
import achq;
import acxw;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import aqgs;
import aqhu;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kbp;
import kgw;
import kxm;
import lbv;
import lbw;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import noq;
import ocp;
import org.json.JSONObject;
import wja;

public class KandianSubscribeManager
  implements Manager
{
  public static final String TAG = KandianSubscribeManager.class.getSimpleName();
  private MsgBoxSetTopInfo a;
  QQAppInterface app;
  private achq b = new lbv(this);
  ReadInJoyUserInfoModule.a c = new lbw(this);
  private List<a> hf = new LinkedList();
  
  public KandianSubscribeManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.a = ((MsgBoxSetTopInfo)kxm.a(paramQQAppInterface, "kandian_subscribe_settop_info_key", true));
    QLog.d(TAG, 1, "read settop info from sp. " + this.a);
  }
  
  public static void P(Context paramContext, int paramInt)
  {
    e(paramContext, paramInt, -1);
  }
  
  public static Drawable a(Drawable paramDrawable, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.b();
    if (localObject1 == null) {}
    for (;;)
    {
      return paramDrawable;
      Object localObject2 = ((QQMessageFacade)localObject1).d(acbn.blO, 1008);
      if ((localObject2 != null) && (!((MessageRecord)localObject2).isread) && (((MessageRecord)localObject2).msgtype == -2011)) {
        try
        {
          localObject1 = BaseApplicationImpl.getApplication().getResources();
          localObject2 = (MessageForStructing)localObject2;
          if (!((MessageForStructing)localObject2).mIsParsed) {
            ((MessageForStructing)localObject2).parse();
          }
          if ((((MessageForStructing)localObject2).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject2).structingMsg.mExtraData)))
          {
            localObject2 = new JSONObject(((MessageForStructing)localObject2).structingMsg.mExtraData).optString("uin", "");
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramQQAppInterface = paramQQAppInterface.a(1, "kd_dt_" + (String)localObject2, (byte)1, 0, 100, true);
              Object localObject3 = (noq)aqgs.a(paramQQAppInterface);
              if (localObject3 != null)
              {
                QLog.d(TAG, 2, "getMergeIcon From cache ! key : " + paramQQAppInterface + ", tipUin : " + (String)localObject2);
                return localObject3;
              }
              localObject3 = aqhu.g(paramDrawable);
              if (localObject3 != null)
              {
                localObject1 = new noq((Bitmap)localObject3, wja.dp2px(50.0F, (Resources)localObject1), (Resources)localObject1, (String)localObject2, 1);
                aqgs.a(paramQQAppInterface, (Sizeable)localObject1);
                return localObject1;
              }
            }
          }
        }
        catch (OutOfMemoryError paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          QLog.d(TAG, 2, "get merge icon has error : " + paramQQAppInterface);
          return paramDrawable;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          QLog.d(TAG, 2, "get merge icon has error : " + paramQQAppInterface);
        }
      }
    }
    return paramDrawable;
  }
  
  private static void a(MessageRecord paramMessageRecord, String paramString1, long paramLong, String paramString2)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = acbn.blO;
    paramMessageRecord.senderuin = acbn.blO;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString1;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.extLong = 0;
    paramMessageRecord.extStr = paramString2;
    paramMessageRecord.createMessageUniseq();
  }
  
  private void aJa()
  {
    ThreadManager.getUIHandler().post(new KandianSubscribeManager.1(this));
  }
  
  public static void e(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = kgw.b(paramContext, paramInt2, 70);
    KandianRedDotInfo localKandianRedDotInfo = f();
    if (localKandianRedDotInfo != null) {
      localIntent.putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
    }
    localIntent.putExtra("kandian_subscribe_launch_from", paramInt2);
    if (!(paramContext instanceof BaseActivity)) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static KandianRedDotInfo f()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    MessageRecord localMessageRecord = localQQAppInterface.b().d(acbn.blO, 1008);
    if (localMessageRecord == null) {
      return null;
    }
    if ((localMessageRecord instanceof MessageForStructing))
    {
      kxm.b(acbn.blO, localQQAppInterface);
      return KandianRedDotInfo.createRedDotFromMessageRecord(localMessageRecord, "kandian_dt_red_dot_info");
    }
    return null;
  }
  
  public boolean BF()
  {
    MessageRecord localMessageRecord = this.app.b().d(acbn.blO, 1008);
    return ((localMessageRecord instanceof MessageForStructing)) && (!localMessageRecord.isread);
  }
  
  public void L(int paramInt1, int paramInt2, int paramInt3)
  {
    MsgBoxSetTopInfo localMsgBoxSetTopInfo = new MsgBoxSetTopInfo();
    localMsgBoxSetTopInfo.setTopStartTime = paramInt1;
    localMsgBoxSetTopInfo.setTopPosition = paramInt2;
    if (paramInt3 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localMsgBoxSetTopInfo.allowSettop = bool;
      if (this.a != null) {
        localMsgBoxSetTopInfo.lastSetTopTimeMillis = this.a.lastSetTopTimeMillis;
      }
      kxm.b("kandian_subscribe_settop_info_key", localMsgBoxSetTopInfo, true);
      this.a = localMsgBoxSetTopInfo;
      QLog.d(TAG, 1, "update settop info : " + localMsgBoxSetTopInfo);
      return;
    }
  }
  
  public achq a()
  {
    return this.b;
  }
  
  public void a(@NonNull a parama)
  {
    if (!this.hf.contains(parama)) {
      this.hf.add(parama);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, long paramLong)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str = ocp.a(paramArticleInfo, this.c);
    if (paramArticleInfo.msgBoxBriefPreFixType == 2) {}
    for (paramArticleInfo = paramArticleInfo.msgBoxBriefPreFix; (TextUtils.isEmpty(str)) || (this.app == null); paramArticleInfo = null)
    {
      QLog.d(TAG, 2, "brief is empty, give up insert !");
      return;
    }
    ThreadManager.post(new KandianSubscribeManager.4(this, str, paramLong, paramArticleInfo), 10, null, false);
  }
  
  public void aJb()
  {
    if (this.a != null) {
      this.a.tryToSetTop();
    }
  }
  
  public void b(a parama)
  {
    this.hf.remove(parama);
  }
  
  public void onDestroy() {}
  
  public static class MsgBoxSetTopInfo
    implements Serializable
  {
    public static final String SP_KEY = "kandian_subscribe_settop_info_key";
    public boolean allowSettop;
    public long lastSetTopTimeMillis;
    public int setTopPosition;
    public int setTopStartTime;
    
    private boolean BG()
    {
      if (!this.allowSettop) {}
      long l;
      do
      {
        return false;
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(11, 0);
        localCalendar.set(12, 0);
        localCalendar.set(13, 0);
        l = localCalendar.getTimeInMillis() / 1000L;
      } while ((System.currentTimeMillis() / 1000L - l < this.setTopStartTime) || (this.lastSetTopTimeMillis > l * 1000L));
      return true;
    }
    
    private Pair<Integer, Long> c(int paramInt)
    {
      Pair localPair = new Pair(Integer.valueOf(-1), Long.valueOf(-1L));
      int j = kxm.aMt;
      Object localObject1 = new ArrayList();
      label300:
      label331:
      label334:
      for (;;)
      {
        int i;
        Object localObject3;
        try
        {
          Object localObject2 = aajt.a().fl;
          if (localObject2 == null) {
            return localPair;
          }
          ((List)localObject1).addAll((Collection)localObject2);
          localObject2 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RecentBaseData)((Iterator)localObject2).next();
            if (!(localObject3 instanceof RecentUserBaseData))
            {
              ((Iterator)localObject2).remove();
              break label334;
            }
            if (!acbn.blO.equals(((RecentBaseData)localObject3).qx())) {
              break label331;
            }
            i = 1;
            break label334;
          }
          if ((i == 0) || (((List)localObject1).isEmpty()))
          {
            QLog.d(KandianSubscribeManager.TAG, 2, "has not kandian subscribe recent user, give settop");
            return localPair;
          }
          int k = ((List)localObject1).size();
          i = 0;
          if (i < k)
          {
            localObject2 = (RecentBaseData)((List)localObject1).get(i);
            localObject3 = (RecentUserBaseData)localObject2;
            if (TextUtils.equals(((RecentUserBaseData)localObject3).qx(), acbn.blO))
            {
              if (i < j)
              {
                QLog.d(KandianSubscribeManager.TAG, 2, "subscribePos is in screen, give up setTop");
                return localPair;
              }
              if (paramInt != 0)
              {
                QLog.d(KandianSubscribeManager.TAG, 2, "settop pos is > ori pos, give up");
                return localPair;
              }
            }
            else
            {
              if (paramInt != 0) {
                break label300;
              }
              localObject1 = new Pair(Integer.valueOf(i), Long.valueOf(1L + ((RecentBaseData)localObject2).mDisplayTime));
              return localObject1;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.d(KandianSubscribeManager.TAG, 2, "get settop info has error " + localException);
        }
        return localPair;
        long l = ((RecentUserBaseData)localObject3).a().showUpTime;
        if (l == 0L) {
          paramInt -= 1;
        }
        for (;;)
        {
          i += 1;
          break;
        }
      }
    }
    
    public String toString()
    {
      return "MsgBoxSetTopInfo{setTopStartTime=" + this.setTopStartTime + ", setTopPosition=" + this.setTopPosition + ", lastSetTopTimeMillis=" + this.lastSetTopTimeMillis + ", allowSettop=" + this.allowSettop + '}';
    }
    
    public void tryToSetTop()
    {
      if (!BG()) {}
      Pair localPair;
      QQAppInterface localQQAppInterface;
      acxw localacxw;
      RecentUser localRecentUser;
      do
      {
        do
        {
          do
          {
            return;
            localPair = c(this.setTopPosition);
          } while ((((Integer)localPair.first).intValue() < 0) || (((Long)localPair.second).longValue() < 0L));
          localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
          localObject = localQQAppInterface.b().d(acbn.blO, 1008);
        } while ((localObject == null) || (((MessageRecord)localObject).isread));
        localacxw = localQQAppInterface.a().a();
        localRecentUser = localacxw.b(acbn.blO, 1008);
      } while (localRecentUser == null);
      localRecentUser.lastmsgtime = ((Long)localPair.second).longValue();
      ((MessageRecord)localObject).time = ((Long)localPair.second).longValue();
      localQQAppInterface.b().a(acbn.blO, 1008, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(((MessageRecord)localObject).time));
      localacxw.e(localRecentUser);
      Object localObject = localQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      this.lastSetTopTimeMillis = System.currentTimeMillis();
      kxm.b("kandian_subscribe_settop_info_key", this, true);
      QLog.d(KandianSubscribeManager.TAG, 1, "settop successful! pos : " + localPair.first + ", msgtime : " + localPair.second);
      kbp.a(localQQAppInterface, "CliOper", "", "", "0X80097D5", "0X80097D5", 0, 1, String.valueOf(localPair.first), null, null, null, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aCv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager
 * JD-Core Version:    0.7.0.1
 */