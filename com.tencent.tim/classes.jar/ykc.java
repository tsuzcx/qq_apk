import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ykc
  implements Manager
{
  private aebo.a a = new yke(this);
  private final QQAppInterface app;
  private final MqqHandler b = new MqqHandler(ThreadManager.getSubThreadLooper(), new ykd(this));
  protected ConcurrentHashMap<String, ColorNote> cZ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> da = new ConcurrentHashMap();
  
  public ykc(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.app.a().a().a(this.a);
  }
  
  private boolean TL()
  {
    return true;
  }
  
  private void a(Context paramContext, UpComingMsgModel paramUpComingMsgModel)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, "[handleClickFromMulti], model:" + paramUpComingMsgModel);
    }
    if (paramUpComingMsgModel.type == 1)
    {
      b(paramContext, paramUpComingMsgModel);
      anot.a(null, "dc00898", "", "", "0X800AE90", "0X800AE90", 1, 0, "", "", "", "");
    }
    while (paramUpComingMsgModel.type != 2) {
      return;
    }
    c(paramContext, paramUpComingMsgModel);
  }
  
  private void a(ColorNote paramColorNote, int paramInt)
  {
    if (paramColorNote != null) {}
    switch (paramInt)
    {
    default: 
    case 1001: 
      do
      {
        return;
        long l2 = System.currentTimeMillis();
        for (long l1 = ykf.a(paramColorNote); bz(l1); l1 += 1L) {}
        this.da.put(paramColorNote.getSubType(), Long.valueOf(l1));
        boolean bool = aebs.i(paramColorNote);
        if (QLog.isDevelopLevel()) {
          QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "currentTime = " + l2 + ", mindTime = " + l1 + ", needNowNotify = " + bool + ", note.ServiceType = " + paramColorNote.getServiceType());
        }
        if (((aebs.j(paramColorNote)) && (l2 < l1)) || (bool))
        {
          Message localMessage = Message.obtain();
          localMessage.what = paramInt;
          localMessage.obj = paramColorNote;
          this.cZ.put(paramColorNote.getSubType(), paramColorNote);
          paramColorNote = this.b;
          if (l2 < l1) {}
          for (l1 -= l2;; l1 = 0L)
          {
            paramColorNote.sendMessageDelayed(localMessage, l1);
            return;
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "handleListener() CALLED.currentTime higher mindTime.");
      return;
    }
    c(paramColorNote);
    this.da.remove(paramColorNote.getSubType());
  }
  
  private void b(Context paramContext, UpComingMsgModel paramUpComingMsgModel)
  {
    long l = ((Long)paramUpComingMsgModel.uniseq.get(0)).longValue();
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    wja.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", paramUpComingMsgModel.frienduin);
    localIntent.putExtra("uintype", paramUpComingMsgModel.istroop);
    localIntent.putExtra("key_uniseq", l);
    localIntent.putExtra("troop_uin", paramUpComingMsgModel.troopUin);
    if (!TextUtils.isEmpty(paramUpComingMsgModel.nickName)) {
      localIntent.putExtra("uinname", paramUpComingMsgModel.nickName);
    }
    paramContext.startActivity(localIntent);
  }
  
  private boolean bz(long paramLong)
  {
    Iterator localIterator = this.da.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((Long)((Map.Entry)localIterator.next()).getValue()).longValue() == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  private void c(Context paramContext, UpComingMsgModel paramUpComingMsgModel)
  {
    if (paramUpComingMsgModel.uniseq.size() > 0)
    {
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      localIntent.putExtra("chat_subType", 4);
      localIntent.putExtra("uin", paramUpComingMsgModel.frienduin);
      localIntent.putExtra("uintype", paramUpComingMsgModel.istroop);
      if (!TextUtils.isEmpty(paramUpComingMsgModel.nickName)) {
        localIntent.putExtra("uinname", paramUpComingMsgModel.nickName);
      }
      localIntent.addFlags(268435456);
      localIntent.putExtra("key_uniseq", paramUpComingMsgModel.uniseq.toArray(new Long[0]));
      paramContext.startActivity(localIntent);
    }
  }
  
  private void c(ColorNote paramColorNote)
  {
    if (this.cZ.containsKey(paramColorNote.getSubType()))
    {
      this.b.removeMessages(1001, this.cZ.get(paramColorNote.getSubType()));
      this.cZ.remove(paramColorNote.getSubType());
    }
  }
  
  private void d(ColorNote paramColorNote)
  {
    if (this.app == null) {
      return;
    }
    if (!aeds.checkPermission(BaseApplicationImpl.getContext()))
    {
      QLog.e("UpComingMsgLogic.UpComingMsgManager", 1, "permission denied, stop notify: " + paramColorNote.toString());
      return;
    }
    this.da.remove(paramColorNote.getSubType());
    if (TL())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, "[notifyComing] is called. isBackground_Pause = " + this.app.isBackground_Pause + ", isBackground_Stop = " + this.app.isBackground_Stop);
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, "[notifyComing], colorNote:" + paramColorNote);
      }
      e(paramColorNote);
      if ((this.app.isBackground_Pause) || (this.app.isBackground_Stop))
      {
        g(paramColorNote);
        anot.a(null, "dc00898", "", "", "0X800AE83", "0X800AE83", 0, 0, "", "", "", "");
      }
      Context localContext = this.app.getApp().getApplicationContext();
      Intent localIntent = new Intent(localContext, ColorNoteSmallScreenService.class);
      localIntent.putExtra("key_upcoming_notify", 2);
      localIntent.putExtra("key_upcoming_color_note", paramColorNote);
      localContext.startService(localIntent);
    }
    anot.a(null, "dc00898", "", "", "0X800AE82", "0X800AE82", 0, 0, "", "", "", "");
  }
  
  private void e(ColorNote paramColorNote)
  {
    if (paramColorNote != null) {
      this.app.a().a().e(paramColorNote);
    }
  }
  
  public void a(Context paramContext, ColorNote paramColorNote)
  {
    String str = new String(paramColorNote.getReserve());
    UpComingMsgModel localUpComingMsgModel = new UpComingMsgModel();
    localUpComingMsgModel.parseFromJson(str);
    a(paramContext, localUpComingMsgModel);
    if (aebs.i(paramColorNote)) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800AE8F", "0X800AE8F", i, localUpComingMsgModel.reportType, "", "", "", "");
      return;
    }
  }
  
  public void a(Context paramContext, ChatMessage paramChatMessage, String paramString)
  {
    long l = paramChatMessage.uniseq;
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    wja.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", paramChatMessage.frienduin);
    localIntent.putExtra("uintype", paramChatMessage.istroop);
    localIntent.putExtra("key_uniseq", l);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("uinname", paramString);
    }
    paramContext.startActivity(localIntent);
    anot.a(null, "dc00898", "", "", "0X800AE90", "0X800AE90", 2, 0, "", "", "", "");
  }
  
  public void f(ColorNote paramColorNote)
  {
    if (this.cZ.containsKey(paramColorNote.getSubType()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "onColorNoteLoadFromLocal() CALLED.has marked.");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpComingMsgLogic.UpComingMsgManager", 4, "onColorNoteLoadFromLocal() CALLED.colorNote = " + paramColorNote);
    }
    a(paramColorNote, 1001);
  }
  
  protected void g(ColorNote paramColorNote)
  {
    if (BaseApplicationImpl.getApplication().getRuntime().isLogin())
    {
      Object localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("KEY_CMD_SHOW_LIST", 1);
      ((Intent)localObject).putExtra("flag_open_up_coming_list", true);
      ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).addFlags(335544320);
      ((Intent)localObject).setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      ((Intent)localObject).putExtra("param_notifyid", 3000529);
      if (QLog.isColorLevel()) {
        QLog.d("UpComingMsgLogic.UpComingMsgManager", 2, "showNotification intent = " + localObject.hashCode());
      }
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130842267).setAutoCancel(true).setOngoing(false).setWhen(System.currentTimeMillis());
      localBuilder.setContentText("收到待办提醒: " + paramColorNote.getMainTitle()).setContentIntent((PendingIntent)localObject);
      paramColorNote = localBuilder.build();
      QQNotificationManager.getInstance().notify("UpComingMsgLogic.UpComingMsgManager", 3000529, paramColorNote);
    }
  }
  
  public void onDestroy()
  {
    this.cZ.clear();
    this.da.clear();
    this.app.a().a().b(this.a);
    this.b.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykc
 * JD-Core Version:    0.7.0.1
 */