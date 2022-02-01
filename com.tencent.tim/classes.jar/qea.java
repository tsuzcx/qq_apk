import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.notification.StoryMsgNotification.2;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class qea
{
  public static final SparseIntArray E;
  private static qea a;
  public static SparseArray<StoryPushMsg> aJ = new SparseArray();
  public static final String awW = plr.asY + acfp.m(2131714949);
  public static final String awX = plr.asY + acfp.m(2131714950);
  private ArrayList<URLDrawable> mX = new ArrayList();
  
  static
  {
    E = new SparseIntArray();
    E.put(1, 246);
    E.put(2, 246);
    E.put(3, 247);
    E.put(4, 248);
    E.put(5, 249);
    E.put(6, 250);
    E.put(7, 251);
    E.put(8, 252);
    E.put(9, 253);
    E.put(10, 254);
    E.put(11, 255);
    E.put(12, 246);
    E.put(13, 246);
    E.put(37, 247);
    E.put(38, 256);
    E.put(39, 257);
    E.put(40, 247);
    E.put(41, 258);
    E.put(42, 259);
    E.put(47, 260);
    E.put(46, 261);
  }
  
  public static qea a()
  {
    if (a == null) {
      a = new qea();
    }
    return a;
  }
  
  public void T(Context paramContext, int paramInt)
  {
    int i = dS(paramInt);
    aJ.remove(i);
    QQNotificationManager.getInstance().cancel("StoryMsgNotification", E.get(paramInt));
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "readPushMsgs type = " + paramInt);
    }
  }
  
  protected String a(StoryPushMsg paramStoryPushMsg)
  {
    String str = awW;
    int i = dS(paramStoryPushMsg.type);
    int j = dT(i);
    switch (i)
    {
    }
    do
    {
      do
      {
        return str;
        if (j > 100) {
          return String.format(awX, new Object[] { "99+" });
        }
      } while (j <= 1);
      return String.format(awX, new Object[] { String.valueOf(j) });
    } while (TextUtils.isEmpty(paramStoryPushMsg.axa));
    return paramStoryPushMsg.axa;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, StoryPushMsg paramStoryPushMsg)
  {
    if ((paramQQAppInterface == null) || (paramStoryPushMsg == null)) {}
    int i;
    do
    {
      return;
      i = E.get(paramStoryPushMsg.type);
    } while (i == 0);
    c(paramStoryPushMsg);
    Object localObject1 = "";
    if ((paramStoryPushMsg.type == 3) || (paramStoryPushMsg.type == 9)) {
      localObject1 = String.valueOf(paramStoryPushMsg.uin);
    }
    if (TextUtils.isEmpty(paramStoryPushMsg.subType)) {}
    for (Object localObject2 = "9999";; localObject2 = paramStoryPushMsg.subType)
    {
      rar.a("notice_msg", "push_suc_all", 0, 0, new String[] { localObject2, localObject1, "", "" });
      if (!qec.u(paramQQAppInterface)) {
        break label139;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.qqstory.protocol", 2, "showQQStoryMsgNotification QQIsForeground return--------");
      return;
    }
    label139:
    if (TextUtils.isEmpty(paramStoryPushMsg.subType)) {}
    NotificationCompat.Builder localBuilder;
    for (localObject2 = "9999";; localObject2 = paramStoryPushMsg.subType)
    {
      rar.a("notice_msg", "push_suc", 0, 0, new String[] { localObject2, localObject1, "", "" });
      qec.a(paramInt, paramQQAppInterface);
      String str = a(paramStoryPushMsg);
      localObject2 = paramStoryPushMsg.awY;
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "showQQStoryMsgNotification line1 = " + str + ", line2 = " + (String)localObject2);
      }
      localBuilder = new NotificationCompat.Builder(paramQQAppInterface.getApp());
      localObject1 = localObject2;
      if (aofy.Z((String)localObject2)) {
        localObject1 = new aofr(anbk.nn((String)localObject2), 3, 16).AE();
      }
      localBuilder.setSmallIcon(2130842267).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText((CharSequence)localObject1).setPriority(2).setStyle(new NotificationCompat.BigTextStyle().bigText((CharSequence)localObject1));
      if (TextUtils.isEmpty(paramStoryPushMsg.mThumbUrl)) {
        break label511;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject1 = URLDrawable.getDrawable(paramStoryPushMsg.mThumbUrl, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setURLDrawableListener(new qeb(this, localBuilder, paramQQAppInterface, paramStoryPushMsg, i));
      if (((URLDrawable)localObject1).getStatus() != 1) {
        break;
      }
      localObject1 = aqhu.f(((URLDrawable)localObject1).getCurrDrawable(), 200, 200);
      localObject2 = jqg.b((Bitmap)localObject1, 1);
      localBuilder.setLargeIcon((Bitmap)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + ((Bitmap)localObject2).getHeight() + ", " + ((Bitmap)localObject2).getWidth());
      }
      a(paramQQAppInterface, paramStoryPushMsg, i, localBuilder);
      ((Bitmap)localObject1).recycle();
      return;
    }
    ((URLDrawable)localObject1).startDownload();
    this.mX.add(localObject1);
    return;
    label511:
    a(paramQQAppInterface, paramStoryPushMsg, i, localBuilder);
  }
  
  public void a(QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt, NotificationCompat.Builder paramBuilder)
  {
    Intent localIntent1 = new Intent("com.tencent.biz.qqstory.notification.qqstory_jump_activity_notify");
    localIntent1.putExtra("storyPushMsg", paramStoryPushMsg);
    localIntent1.setPackage(MobileQQ.getContext().getPackageName());
    localIntent1.putExtra("param_notifyid", paramInt);
    paramBuilder.setContentIntent(PendingIntent.getBroadcast(paramQQAppInterface.getApp(), paramInt, localIntent1, 1207959552));
    paramBuilder = paramBuilder.build();
    paramBuilder.flags = 16;
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    Intent localIntent2 = new Intent("com.tencent.biz.qqstory.notification.qqstory_delete_notify");
    localIntent1.putExtra("param_notifyid", paramInt);
    localIntent2.setPackage(MobileQQ.getContext().getPackageName());
    localIntent2.putExtra("push_type", paramStoryPushMsg.type);
    paramBuilder.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), paramInt, localIntent2, 134217728);
    auqw.setMIUI6Badge(paramQQAppInterface.getApp(), 0, paramBuilder);
    localQQNotificationManager.notify("StoryMsgNotification", paramInt, paramBuilder);
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "showQQStoryMsgNotification pushMsg: " + paramStoryPushMsg);
    }
  }
  
  protected void c(StoryPushMsg paramStoryPushMsg)
  {
    if (paramStoryPushMsg == null) {}
    ptf localptf;
    do
    {
      int i;
      do
      {
        return;
        i = dS(paramStoryPushMsg.type);
        paramStoryPushMsg.mUnreadNum = (dT(i) + 1);
        aJ.put(i, paramStoryPushMsg);
      } while (i != 3);
      localptf = (ptf)psx.a(2);
    } while (localptf.b(paramStoryPushMsg.getUid()) != null);
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.uid = paramStoryPushMsg.getUid();
    localQQUserUIItem.setUnionId(paramStoryPushMsg.unionId);
    localptf.a(localQQUserUIItem);
  }
  
  public void cA(Context paramContext)
  {
    ThreadManager.post(new StoryMsgNotification.2(this), 8, null, true);
  }
  
  protected int dS(int paramInt)
  {
    int i;
    if ((paramInt != 1) && (paramInt != 12))
    {
      i = paramInt;
      if (paramInt != 13) {}
    }
    else
    {
      i = 2;
    }
    return i;
  }
  
  public int dT(int paramInt)
  {
    StoryPushMsg localStoryPushMsg = (StoryPushMsg)aJ.get(paramInt);
    if (localStoryPushMsg == null) {
      return 0;
    }
    return localStoryPushMsg.mUnreadNum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qea
 * JD-Core Version:    0.7.0.1
 */