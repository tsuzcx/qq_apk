import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MQQCampusNotify;

public class aeam
  implements Manager
{
  RecentItemNoticeData a;
  MessageForText b;
  int cLR = 1000;
  QQAppInterface mApp;
  final ArrayList<Integer> vg = new ArrayList();
  
  public aeam(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public MessageForText a()
  {
    if (this.a == null) {
      return null;
    }
    RecentItemNoticeData localRecentItemNoticeData = this.a;
    if (this.b == null)
    {
      this.b = ((MessageForText)anbi.d(-1000));
      this.b.msgtype = -1000;
      this.b.istroop = 1030;
      this.b.isread = false;
      this.b.selfuin = this.mApp.getCurrentAccountUin();
      this.b.senderuin = acbn.blH;
      this.b.frienduin = acbn.blH;
      this.b.msg = localRecentItemNoticeData.wording;
      this.b.time = localRecentItemNoticeData.time;
    }
    if ((this.b.msg == null) || (!this.b.msg.equals(localRecentItemNoticeData.mTitleName))) {
      this.b.msg = localRecentItemNoticeData.mTitleName;
    }
    if (this.b.time != localRecentItemNoticeData.time) {
      this.b.time = localRecentItemNoticeData.time;
    }
    return this.b;
  }
  
  /* Error */
  public void a(int paramInt, long paramLong, String arg4, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 105	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore 9
    //   5: aload 9
    //   7: invokestatic 111	aqlr:isScreenLocked	(Landroid/content/Context;)Z
    //   10: istore 7
    //   12: aload_0
    //   13: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: getfield 114	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   19: ifne +18 -> 37
    //   22: aload_0
    //   23: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: getfield 117	com/tencent/mobileqq/app/QQAppInterface:isBackground_Stop	Z
    //   29: ifne +8 -> 37
    //   32: iload 7
    //   34: ifeq +412 -> 446
    //   37: aload_0
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 24	aeam:cLR	I
    //   43: iconst_1
    //   44: iadd
    //   45: istore_1
    //   46: aload_0
    //   47: iload_1
    //   48: putfield 24	aeam:cLR	I
    //   51: aload_0
    //   52: monitorexit
    //   53: new 119	android/content/Intent
    //   56: dup
    //   57: aload_0
    //   58: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   64: ldc 124
    //   66: invokespecial 127	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   69: astore 8
    //   71: aload 8
    //   73: ldc 129
    //   75: iconst_1
    //   76: invokevirtual 133	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   79: pop
    //   80: aload 8
    //   82: ldc 135
    //   84: iconst_4
    //   85: invokevirtual 133	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   88: pop
    //   89: aload 8
    //   91: ldc 136
    //   93: invokevirtual 140	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   96: pop
    //   97: aload 8
    //   99: ldc 142
    //   101: iconst_3
    //   102: invokevirtual 133	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   105: pop
    //   106: aload 8
    //   108: ldc 144
    //   110: aload 5
    //   112: invokevirtual 147	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   115: pop
    //   116: aload 8
    //   118: ldc 149
    //   120: ldc 151
    //   122: invokevirtual 147	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   125: pop
    //   126: aload 8
    //   128: ldc 153
    //   130: sipush 1030
    //   133: invokevirtual 133	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   136: pop
    //   137: aload 8
    //   139: ldc 155
    //   141: lload_2
    //   142: invokestatic 159	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   145: invokevirtual 147	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   148: pop
    //   149: aload 8
    //   151: ldc 161
    //   153: ldc 163
    //   155: invokevirtual 147	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   158: pop
    //   159: aload 8
    //   161: ldc 165
    //   163: iload_1
    //   164: invokevirtual 133	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   167: pop
    //   168: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +35 -> 206
    //   174: ldc 173
    //   176: iconst_2
    //   177: iconst_4
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: ldc 175
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: iload_1
    //   189: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: ldc 182
    //   197: aastore
    //   198: dup
    //   199: iconst_3
    //   200: aload 5
    //   202: aastore
    //   203: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   206: aload_0
    //   207: getfield 35	aeam:a	Lcom/tencent/mobileqq/activity/recent/data/RecentItemNoticeData;
    //   210: ifnull +12 -> 222
    //   213: aload_0
    //   214: getfield 35	aeam:a	Lcom/tencent/mobileqq/activity/recent/data/RecentItemNoticeData;
    //   217: aload 8
    //   219: invokevirtual 189	com/tencent/mobileqq/activity/recent/data/RecentItemNoticeData:updateIntent	(Landroid/content/Intent;)V
    //   222: new 191	com/tencent/qphone/base/remote/ToServiceMsg
    //   225: dup
    //   226: ldc 193
    //   228: aload_0
    //   229: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   232: invokevirtual 61	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   235: ldc 195
    //   237: invokespecial 198	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   240: astore 5
    //   242: aload 5
    //   244: getfield 202	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   247: ldc 204
    //   249: iconst_3
    //   250: anewarray 94	java/lang/String
    //   253: dup
    //   254: iconst_0
    //   255: aload 4
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload 6
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: aload 4
    //   267: aastore
    //   268: invokevirtual 210	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   271: aload 5
    //   273: getfield 202	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   276: ldc 212
    //   278: aload 8
    //   280: invokevirtual 216	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   283: aload 5
    //   285: getfield 202	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   288: ldc 218
    //   290: aconst_null
    //   291: invokevirtual 216	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   294: aload_0
    //   295: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   298: aload 5
    //   300: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   303: aload_0
    //   304: getfield 29	aeam:vg	Ljava/util/ArrayList;
    //   307: astore 4
    //   309: aload 4
    //   311: monitorenter
    //   312: aload_0
    //   313: getfield 29	aeam:vg	Ljava/util/ArrayList;
    //   316: iload_1
    //   317: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: invokevirtual 225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   323: pop
    //   324: aload 4
    //   326: monitorexit
    //   327: aload 8
    //   329: astore 4
    //   331: iload 7
    //   333: ifeq +97 -> 430
    //   336: aload_0
    //   337: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   340: bipush 72
    //   342: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   345: checkcast 231	aizf
    //   348: astore 5
    //   350: aload 9
    //   352: aload_0
    //   353: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   356: invokevirtual 61	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   359: aload 9
    //   361: ldc 232
    //   363: invokevirtual 238	android/content/Context:getString	(I)Ljava/lang/String;
    //   366: ldc 240
    //   368: iconst_1
    //   369: invokestatic 246	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   372: ifeq +44 -> 416
    //   375: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +11 -> 389
    //   381: ldc 173
    //   383: iconst_2
    //   384: ldc 248
    //   386: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: aload 5
    //   391: aload_0
    //   392: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   395: getstatic 70	acbn:blH	Ljava/lang/String;
    //   398: sipush 1030
    //   401: iconst_0
    //   402: getstatic 70	acbn:blH	Ljava/lang/String;
    //   405: sipush 1030
    //   408: aload 4
    //   410: invokestatic 256	aizb:a	(Ljava/lang/String;ILandroid/content/Intent;)I
    //   413: invokevirtual 259	aizf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IZI)V
    //   416: aload_0
    //   417: getfield 31	aeam:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   420: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   423: aload_0
    //   424: invokevirtual 265	aeam:b	()Lcom/tencent/mobileqq/activity/recent/RecentBaseData;
    //   427: invokevirtual 271	com/tencent/imcore/message/QQMessageFacade:notifyObservers	(Ljava/lang/Object;)V
    //   430: return
    //   431: astore 4
    //   433: aload_0
    //   434: monitorexit
    //   435: aload 4
    //   437: athrow
    //   438: astore 5
    //   440: aload 4
    //   442: monitorexit
    //   443: aload 5
    //   445: athrow
    //   446: aconst_null
    //   447: astore 4
    //   449: goto -118 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	aeam
    //   0	452	1	paramInt	int
    //   0	452	2	paramLong	long
    //   0	452	5	paramString2	String
    //   0	452	6	paramString3	String
    //   10	322	7	bool	boolean
    //   69	259	8	localIntent	android.content.Intent
    //   3	357	9	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   39	53	431	finally
    //   433	435	431	finally
    //   312	327	438	finally
    //   440	443	438	finally
  }
  
  public void a(QQNotificationManager arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "setReaded seq: %d", new Object[] { Integer.valueOf(this.cLR) }));
    }
    this.a = null;
    QQNotificationManager localQQNotificationManager = ???;
    if (??? == null) {}
    try
    {
      BaseApplicationImpl.getContext();
      localQQNotificationManager = QQNotificationManager.getInstance();
      synchronized (this.vg)
      {
        Iterator localIterator = this.vg.iterator();
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          if (localInteger != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "cancel campus_notice [%d, %s]", new Object[] { localInteger, "campus_notification_tag" }));
            }
            localQQNotificationManager.cancelUseTag("CampusNoticeManager_removeNotification", "campus_notification_tag", localInteger.intValue());
          }
        }
      }
      this.vg.clear();
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 2, "setReaded", ???);
      }
      return;
    }
  }
  
  public void a(SubMsgType0x27.MQQCampusNotify paramMQQCampusNotify)
  {
    if (paramMQQCampusNotify == null) {
      return;
    }
    int i = paramMQQCampusNotify.uint32_type.get();
    long l1 = paramMQQCampusNotify.uint64_from_uin.get();
    if (paramMQQCampusNotify.str_wording.has()) {}
    for (String str3 = paramMQQCampusNotify.str_wording.get();; str3 = null)
    {
      String str1;
      if (paramMQQCampusNotify.str_target.has())
      {
        str1 = paramMQQCampusNotify.str_target.get();
        if (TextUtils.isEmpty(str1)) {}
      }
      for (;;)
      {
        Object localObject;
        long l2;
        try
        {
          str1 = new String(ajnj.decode(str1), "UTF-8");
          if (!paramMQQCampusNotify.str_source.has()) {
            break label378;
          }
          paramMQQCampusNotify = paramMQQCampusNotify.str_source.get();
          localObject = paramMQQCampusNotify;
          if (paramMQQCampusNotify == null) {
            localObject = "";
          }
          if (QLog.isColorLevel()) {
            QLog.i("CampusNoticeManager", 2, String.format(Locale.getDefault(), "onReceiveNotice [type: %d uin: %d wording: %s url: %s from: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), str3, str1, localObject }));
          }
          if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1))) {
            break;
          }
          paramMQQCampusNotify = new anop.a();
          paramMQQCampusNotify.Ur = "0X800923D";
          paramMQQCampusNotify.Uq = "收到Push协议";
          anop.a(str1, paramMQQCampusNotify);
          anop.a(this.mApp, paramMQQCampusNotify);
          l2 = anaz.gQ();
          if (this.a == null)
          {
            paramMQQCampusNotify = new RecentUser();
            paramMQQCampusNotify.uin = acbn.blH;
            paramMQQCampusNotify.msgType = 1030;
            paramMQQCampusNotify.setType(1030);
            this.a = new RecentItemNoticeData(paramMQQCampusNotify);
            this.a.a(i, l1, str3, str1, (String)localObject, l2);
            a(i, l1, str3, str1, (String)localObject);
            return;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CampusNoticeManager", 2, "decode url fail ", localException);
          }
          str2 = null;
          continue;
        }
        if (this.a.a(i, l1, str3, str2, (String)localObject, l2)) {
          break;
        }
        this.a.a(i, l1, str3, str2, (String)localObject, l2);
        a(i, l1, str3, str2, (String)localObject);
        return;
        label378:
        paramMQQCampusNotify = null;
        continue;
        continue;
        String str2 = null;
      }
    }
  }
  
  public RecentBaseData b()
  {
    return this.a;
  }
  
  public int getUnreadCount()
  {
    if (this.a == null) {
      return 0;
    }
    return 1;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeam
 * JD-Core Version:    0.7.0.1
 */