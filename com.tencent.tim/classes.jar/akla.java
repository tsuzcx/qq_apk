import android.app.Notification;
import android.app.PendingIntent;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver.onPushReceived.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Forward;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Image;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.MsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/OnlineModulePushReceiver;", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "convertPacket", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "msgBody", "Ltencent/im/s2c/msgtype0x210/submsgtype0x135/ModulePushPb$MsgBody;", "createSystemNotification", "", "pushComponent", "notification", "Landroid/app/Notification;", "handleMsgBytes", "vProtobuf", "", "onPushReceived", "revokePush", "sendPush", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class akla
{
  private final QQAppInterface app;
  
  public akla(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private final void a(aklc paramaklc, Notification paramNotification)
  {
    QQNotificationManager.getInstance().notify("OnlineModulePushReceiver", paramaklc.dny, paramNotification);
    this.app.cLD();
    ((Map)aklb.v()).put(Integer.valueOf(paramaklc.dny), Integer.valueOf(paramaklc.dnv));
    anot.a(null, "dc00898", "", "", "0X800AE73", "0X800AE73", paramaklc.dnv, 0, String.valueOf(paramaklc.dnw), String.valueOf(paramaklc.dnx), "", "");
  }
  
  private final void b(aklc paramaklc)
  {
    Object localObject = aklh.a.a(paramaklc).b(paramaklc);
    localObject = akkz.a.a((PendingIntent)localObject, paramaklc);
    boolean bool = aklb.bj(this.app);
    if (aklb.bk(this.app)) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineModulePushReceiver", 2, "sendPush: called. push need shield");
      }
    }
    do
    {
      return;
      if ((paramaklc.csK) && (paramaklc.csJ))
      {
        a(paramaklc, (Notification)localObject);
        return;
      }
      if ((paramaklc.csK) && (bool))
      {
        a(paramaklc, (Notification)localObject);
        return;
      }
      if ((paramaklc.csJ) && (!bool))
      {
        a(paramaklc, (Notification)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineModulePushReceiver", 2, new Object[] { "sendPush: called. ", "no need send push. isBackground: " + bool });
  }
  
  private final void c(aklc paramaklc)
  {
    QQNotificationManager.getInstance().cancel("OnlineModulePushReceiver", paramaklc.dny);
  }
  
  @NotNull
  public final aklc a(@NotNull ModulePushPb.MsgBody paramMsgBody)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramMsgBody, "msgBody");
    aklc localaklc = new aklc();
    String str = paramMsgBody.msg_content.str_title.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.str_title.get()");
    localaklc.title = str;
    str = paramMsgBody.msg_content.msg_image.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.msg_image.str_url.get()");
    localaklc.iconUrl = str;
    str = paramMsgBody.msg_content.str_desc.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.str_desc.get()");
    localaklc.contentText = str;
    str = paramMsgBody.msg_content.msg_forward.str_url.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.msg_content.msg_forward.str_url.get()");
    localaklc.wV = str;
    label214:
    int i;
    if (paramMsgBody.msg_content.msg_forward.uint32_type.get() == 0)
    {
      bool1 = true;
      localaklc.csH = bool1;
      localaklc.dnv = paramMsgBody.int32_service_id.get();
      localaklc.dnw = paramMsgBody.int32_sub_service_id.get();
      localaklc.dny = paramMsgBody.int32_notify_id.get();
      localaklc.dnx = paramMsgBody.int32_push_id.get();
      if (paramMsgBody.int32_recall_flag.get() != 1) {
        break label301;
      }
      bool1 = true;
      localaklc.csI = bool1;
      i = paramMsgBody.int32_type.get();
      if ((i != 1) && (i != 2)) {
        break label306;
      }
    }
    label301:
    label306:
    for (boolean bool1 = true;; bool1 = false)
    {
      localaklc.csJ = bool1;
      if (i != 0)
      {
        bool1 = bool2;
        if (i != 2) {}
      }
      else
      {
        bool1 = true;
      }
      localaklc.csK = bool1;
      paramMsgBody = paramMsgBody.msg_content.bytes_ext_data.get().toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(paramMsgBody, "msgBody.msg_content.byte…_data.get().toByteArray()");
      localaklc.eU = paramMsgBody;
      return localaklc;
      bool1 = false;
      break;
      bool1 = false;
      break label214;
    }
  }
  
  public final void a(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    if (QLog.isColorLevel()) {
      QLog.d("OnlineModulePushReceiver", 2, new Object[] { "onPushReceived: called. ", "pushComponent: " + paramaklc });
    }
    if (!paramaklc.arW())
    {
      QLog.d("OnlineModulePushReceiver", 1, new Object[] { "onPushReceived: called. ", "invalid notify id. pushComponent: " + paramaklc });
      return;
    }
    if (paramaklc.csI)
    {
      c(paramaklc);
      return;
    }
    aklb.a((Function0)new OnlineModulePushReceiver.onPushReceived.1(this, paramaklc));
  }
  
  public final void bo(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "vProtobuf");
    ModulePushPb.MsgBody localMsgBody = new ModulePushPb.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      a(a(localMsgBody));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineModulePushReceiver", 2, "handleMsgBytes: failed. ", (Throwable)paramArrayOfByte);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akla
 * JD-Core Version:    0.7.0.1
 */