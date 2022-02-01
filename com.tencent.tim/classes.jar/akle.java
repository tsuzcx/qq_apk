import android.app.PendingIntent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/AudioRoomScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "modifyAudioRoomScheme", "", "scheme", "needCustomJump", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class akle
  extends akky
{
  public static final akle.a a = new akle.a(null);
  
  private final String mv(String paramString)
  {
    QLog.d("AudioRoomScheme", 2, "before modify scheme: " + paramString);
    String str = StringsKt.replace$default(paramString, "mqqapi://now/audioroom", "mqqapi://now/openroom", false, 4, null);
    paramString = str;
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"src_type", false, 2, null)) {
      paramString = str + "&src_type=app";
    }
    str = paramString;
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"version", false, 2, null)) {
      str = paramString + "&version=1";
    }
    paramString = str;
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"fromid", false, 2, null)) {
      paramString = str + "&fromid=10026";
    }
    str = paramString;
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"roomtype", false, 2, null)) {
      str = paramString + "&roomtype=10001";
    }
    QLog.d("AudioRoomScheme", 2, "after modify: " + str);
    return str;
  }
  
  @NotNull
  protected PendingIntent a(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    if (StringsKt.startsWith$default(paramaklc.wV, "mqqapi://now/audioroom", false, 2, null)) {
      paramaklc.wV = mv(paramaklc.wV);
    }
    return e(paramaklc);
  }
  
  protected boolean arV()
  {
    return true;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/AudioRoomScheme$Companion;", "", "()V", "TAG", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akle
 * JD-Core Version:    0.7.0.1
 */