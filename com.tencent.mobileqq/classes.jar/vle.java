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

public class vle
{
  public static SparseArray<StoryPushMsg> a;
  public static final SparseIntArray a;
  public static final String a;
  private static vle jdField_a_of_type_Vle;
  public static final String b;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = ulg.jdField_a_of_type_JavaLangString + alud.a(2131714923);
    jdField_b_of_type_JavaLangString = ulg.jdField_a_of_type_JavaLangString + alud.a(2131714924);
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 247);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(4, 248);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(5, 249);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(6, 250);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(7, 251);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 252);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(9, 253);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10, 254);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 255);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(12, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(13, 246);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(37, 247);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(38, 256);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(39, 257);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(40, 247);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(41, 258);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(42, 259);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(47, 260);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(46, 261);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static vle a()
  {
    if (jdField_a_of_type_Vle == null) {
      jdField_a_of_type_Vle = new vle();
    }
    return jdField_a_of_type_Vle;
  }
  
  protected int a(int paramInt)
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
  
  protected String a(StoryPushMsg paramStoryPushMsg)
  {
    String str = jdField_a_of_type_JavaLangString;
    int i = a(paramStoryPushMsg.jdField_a_of_type_Int);
    int j = b(i);
    switch (i)
    {
    }
    do
    {
      do
      {
        return str;
        if (j > 100) {
          return String.format(jdField_b_of_type_JavaLangString, new Object[] { "99+" });
        }
      } while (j <= 1);
      return String.format(jdField_b_of_type_JavaLangString, new Object[] { String.valueOf(j) });
    } while (TextUtils.isEmpty(paramStoryPushMsg.h));
    return paramStoryPushMsg.h;
  }
  
  public void a(Context paramContext)
  {
    ThreadManager.post(new StoryMsgNotification.2(this), 8, null, true);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    int i = a(paramInt);
    jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    QQNotificationManager.getInstance().cancel("StoryMsgNotification", jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt));
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "readPushMsgs type = " + paramInt);
    }
  }
  
  protected void a(StoryPushMsg paramStoryPushMsg)
  {
    if (paramStoryPushMsg == null) {}
    uwm localuwm;
    do
    {
      int i;
      do
      {
        return;
        i = a(paramStoryPushMsg.jdField_a_of_type_Int);
        paramStoryPushMsg.jdField_b_of_type_Int = (b(i) + 1);
        jdField_a_of_type_AndroidUtilSparseArray.put(i, paramStoryPushMsg);
      } while (i != 3);
      localuwm = (uwm)uwa.a(2);
    } while (localuwm.b(paramStoryPushMsg.a()) != null);
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.uid = paramStoryPushMsg.a();
    localQQUserUIItem.setUnionId(paramStoryPushMsg.c);
    localuwm.a(localQQUserUIItem);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, StoryPushMsg paramStoryPushMsg)
  {
    if ((paramQQAppInterface == null) || (paramStoryPushMsg == null)) {}
    int i;
    do
    {
      return;
      i = jdField_a_of_type_AndroidUtilSparseIntArray.get(paramStoryPushMsg.jdField_a_of_type_Int);
    } while (i == 0);
    a(paramStoryPushMsg);
    Object localObject1 = "";
    if ((paramStoryPushMsg.jdField_a_of_type_Int == 3) || (paramStoryPushMsg.jdField_a_of_type_Int == 9)) {
      localObject1 = String.valueOf(paramStoryPushMsg.jdField_a_of_type_Long);
    }
    if (TextUtils.isEmpty(paramStoryPushMsg.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject2 = "9999";; localObject2 = paramStoryPushMsg.jdField_a_of_type_JavaLangString)
    {
      wxj.a("notice_msg", "push_suc_all", 0, 0, new String[] { localObject2, localObject1, "", "" });
      if (!vlg.a(paramQQAppInterface)) {
        break label139;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.qqstory.protocol", 2, "showQQStoryMsgNotification QQIsForeground return--------");
      return;
    }
    label139:
    if (TextUtils.isEmpty(paramStoryPushMsg.jdField_a_of_type_JavaLangString)) {}
    NotificationCompat.Builder localBuilder;
    for (localObject2 = "9999";; localObject2 = paramStoryPushMsg.jdField_a_of_type_JavaLangString)
    {
      wxj.a("notice_msg", "push_suc", 0, 0, new String[] { localObject2, localObject1, "", "" });
      vlg.a(paramInt, paramQQAppInterface);
      String str = a(paramStoryPushMsg);
      localObject2 = paramStoryPushMsg.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.w("zivonchen", 2, "showQQStoryMsgNotification line1 = " + str + ", line2 = " + (String)localObject2);
      }
      localBuilder = new NotificationCompat.Builder(paramQQAppInterface.getApp());
      localObject1 = localObject2;
      if (banh.a((String)localObject2)) {
        localObject1 = new bamz(azah.b((String)localObject2), 3, 16).a();
      }
      localBuilder.setSmallIcon(2130841131).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText((CharSequence)localObject1).setPriority(2).setStyle(new NotificationCompat.BigTextStyle().bigText((CharSequence)localObject1));
      if (TextUtils.isEmpty(paramStoryPushMsg.g)) {
        break label511;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject1 = URLDrawable.getDrawable(paramStoryPushMsg.g, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setURLDrawableListener(new vlf(this, localBuilder, paramQQAppInterface, paramStoryPushMsg, i));
      if (((URLDrawable)localObject1).getStatus() != 1) {
        break;
      }
      localObject1 = bdhj.a(((URLDrawable)localObject1).getCurrDrawable(), 200, 200);
      localObject2 = ndi.b((Bitmap)localObject1, 1);
      localBuilder.setLargeIcon((Bitmap)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + ((Bitmap)localObject2).getHeight() + ", " + ((Bitmap)localObject2).getWidth());
      }
      a(paramQQAppInterface, paramStoryPushMsg, i, localBuilder);
      ((Bitmap)localObject1).recycle();
      return;
    }
    ((URLDrawable)localObject1).startDownload();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
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
    localIntent2.putExtra("push_type", paramStoryPushMsg.jdField_a_of_type_Int);
    paramBuilder.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), paramInt, localIntent2, 134217728);
    bhsc.a(paramQQAppInterface.getApp(), 0, paramBuilder);
    localQQNotificationManager.notify("StoryMsgNotification", paramInt, paramBuilder);
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "showQQStoryMsgNotification pushMsg: " + paramStoryPushMsg);
    }
  }
  
  public int b(int paramInt)
  {
    StoryPushMsg localStoryPushMsg = (StoryPushMsg)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localStoryPushMsg == null) {
      return 0;
    }
    return localStoryPushMsg.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vle
 * JD-Core Version:    0.7.0.1
 */