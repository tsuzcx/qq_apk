import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.ReqBody;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.TopicReqBody;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.VideoReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/mvp/RIJWriteWatchWordModel;", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;", "()V", "failedToast", "", "getFailedToast", "()Ljava/lang/String;", "successToast", "getSuccessToast", "copyToClipboard", "", "watchWord", "url", "title", "isOpen", "", "type", "", "fetchTopicWatchWord", "topicId", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "fetchVideoWatchWord", "rowkey", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nzb
  implements nyy.a
{
  public static final nzb.a a = new nzb.a(null);
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, @NotNull String paramString4, @Nullable Function3<? super String, ? super String, ? super Boolean, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowkey");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    Intrinsics.checkParameterIsNotNull(paramString4, "title");
    QLog.i("RIJWriteWatchWordModel", 1, "fetch Video WatchWord rowkey: " + paramString1 + " url: " + paramString2 + " topicId: " + paramString3 + " title: " + paramString4);
    paramString4 = new cmd0xe5c.ReqBody();
    cmd0xe5c.VideoReqBody localVideoReqBody = new cmd0xe5c.VideoReqBody();
    localVideoReqBody.rowkey.set(paramString1);
    localVideoReqBody.url.set(paramString2);
    if (paramString3 != null) {
      if (((CharSequence)paramString3).length() <= 0) {
        break label194;
      }
    }
    label194:
    for (int i = 1;; i = 0)
    {
      if (i == 1) {
        localVideoReqBody.topic_id.set(paramString3);
      }
      paramString4.videoReqBody.set((MessageMicro)localVideoReqBody, true);
      paramString4.type.set(1);
      paramString1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "BaseApplicationImpl.getApplication()");
      paramString1 = paramString1.getRuntime();
      if (paramString1 != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
    jnm.a((AppRuntime)paramString1, (jnm.d)new nzd(paramFunction3), paramString4.toByteArray(), "OidbSvc.0xe5c", 3676, 1, new Bundle(), 5000L);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @Nullable Function3<? super String, ? super String, ? super Boolean, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "topicId");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    Intrinsics.checkParameterIsNotNull(paramString3, "title");
    QLog.i("RIJWriteWatchWordModel", 1, "fetch Topic WatchWord url: " + paramString2 + " topicId: " + paramString1 + " title: " + paramString3);
    paramString3 = new cmd0xe5c.ReqBody();
    cmd0xe5c.TopicReqBody localTopicReqBody = new cmd0xe5c.TopicReqBody();
    localTopicReqBody.url.set(paramString2);
    localTopicReqBody.topic_id.set(paramString1);
    paramString3.topicReqBody.set((MessageMicro)localTopicReqBody, true);
    paramString3.type.set(1);
    paramString1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "BaseApplicationImpl.getApplication()");
    paramString1 = paramString1.getRuntime();
    if (paramString1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
    jnm.a((AppRuntime)paramString1, (jnm.d)new nzc(paramFunction3), paramString3.toByteArray(), "OidbSvc.0xe5c", 3676, 1, new Bundle(), 5000L);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "watchWord");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    Intrinsics.checkParameterIsNotNull(paramString3, "title");
    paramString2 = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
    if (paramString2 != null)
    {
      paramString1 = ClipData.newPlainText((CharSequence)"RIJShareClip", (CharSequence)nyw.a.a().a(paramString1, paramBoolean, paramInt, paramString3));
      alkw.a(paramString2, paramString1);
      paramString2.setPrimaryClip(paramString1);
    }
  }
  
  @NotNull
  public String kY()
  {
    String str = kxm.getString(2131718382);
    Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoyUtils.getString…_copy_watch_word_success)");
    return str;
  }
  
  @NotNull
  public String kZ()
  {
    String str = kxm.getString(2131718381);
    Intrinsics.checkExpressionValueIsNotNull(str, "ReadInJoyUtils.getString…y_copy_watch_word_failed)");
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/mvp/RIJWriteWatchWordModel$Companion;", "", "()V", "TAG", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzb
 * JD-Core Version:    0.7.0.1
 */