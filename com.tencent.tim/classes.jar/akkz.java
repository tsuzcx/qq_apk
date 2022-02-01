import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/NotificationBuilder;", "", "()V", "build", "Landroid/app/Notification;", "contentIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class akkz
{
  public static final akkz a = new akkz();
  
  @RequiresApi(16)
  @NotNull
  public final Notification a(@Nullable PendingIntent paramPendingIntent, @NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
    localBigTextStyle.bigText((CharSequence)paramaklc.contentText);
    paramPendingIntent = new NotificationCompat.Builder((Context)BaseApplication.context).setSmallIcon(2130842268).setAutoCancel(true).setContentText((CharSequence)paramaklc.contentText).setWhen(System.currentTimeMillis()).setTicker((CharSequence)paramaklc.contentText).setContentIntent(paramPendingIntent).setPriority(2).setStyle((NotificationCompat.Style)localBigTextStyle);
    if (!TextUtils.isEmpty((CharSequence)paramaklc.title)) {
      paramPendingIntent.setContentTitle((CharSequence)paramaklc.title);
    }
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      paramPendingIntent.setChannelId("CHANNEL_ID_OTHER");
    }
    paramaklc = akld.a.H(paramaklc.iconUrl);
    if (paramaklc != null) {
      paramPendingIntent.setLargeIcon(paramaklc);
    }
    paramPendingIntent = paramPendingIntent.build();
    Intrinsics.checkExpressionValueIsNotNull(paramPendingIntent, "notifyBuilder.build()");
    return paramPendingIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkz
 * JD-Core Version:    0.7.0.1
 */