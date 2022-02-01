import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.share.watchword.RIJWatchWordShareManager.Companion.instance.2;
import com.tencent.biz.pubaccount.share.watchword.RIJWatchWordShareManager.getClipWording.1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/RIJWatchWordShareManager;", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/IRIJReadWatchWordShareContract$IView;", "()V", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "privateTopicWatchWord", "getPrivateTopicWatchWord", "()Ljava/lang/String;", "privateVideoWatchWord", "getPrivateVideoWatchWord", "publicTopicWatchWord", "getPublicTopicWatchWord", "publicVideoWatchWord", "getPublicVideoWatchWord", "readPresenter", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/RIJReadWatchWordPresenter;", "watchWordCount", "", "getWatchWordCount", "()I", "clearClipBoard", "", "getAppearCount", "pattern", "master", "getClipWording", "watchWord", "isPrivate", "", "type", "title", "getJumpUrlFromWatchWord", "getTextFromClipBoard", "callback", "Lkotlin/Function1;", "getWatchWordFromText", "text", "isRIJShareWatchWord", "jumpAction", "jumpUrl", "jumpToTargetPage", "userInfo", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "videoInfo", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "topicInfo", "Lcom/tencent/biz/pubaccount/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "onAppForeground", "reportClick", "popupType", "rowkey", "columnId", "uin", "", "clickType", "reportExpose", "saveWatchWord2JumpUrl", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nyw
  implements nyx.b
{
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJWatchWordShareManager.Companion.instance.2.INSTANCE);
  public static final nyw.a a;
  private final nza jdField_a_of_type_Nza = new nza((nyx.a)new nyz());
  private final int bdh = 50;
  private final LinkedHashMap<String, String> map = new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_Nyw$a = new nyw.a(null);
  }
  
  public nyw()
  {
    this.jdField_a_of_type_Nza.a((nyx.b)this);
  }
  
  private final String kU()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_public_topic_text", kxm.getString(2131718569));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_word_public_topic_text))");
    return str;
  }
  
  private final String kV()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_private_topic_text", kxm.getString(2131718567));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…word_private_topic_text))");
    return str;
  }
  
  private final String kW()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_public_video_text", kxm.getString(2131718570));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_word_public_video_text))");
    return str;
  }
  
  private final String kX()
  {
    String str = Aladdin.getConfig(296).getString("watch_word_private_video_text", kxm.getString(2131718568));
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…word_private_video_text))");
    return str;
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, boolean paramBoolean, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "watchWord");
    Intrinsics.checkParameterIsNotNull(paramString2, "title");
    paramString1 = new RIJWatchWordShareManager.getClipWording.1(paramString2, paramString1);
    if (paramInt == 1)
    {
      if (paramBoolean) {
        return paramString1.invoke(kX());
      }
      return paramString1.invoke(kW());
    }
    if (paramBoolean) {
      return paramString1.invoke(kV());
    }
    return paramString1.invoke(kU());
  }
  
  public final void bR(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "watchWord");
    Intrinsics.checkParameterIsNotNull(paramString2, "jumpUrl");
    if (this.map.size() >= 50) {
      this.map.remove(((Map.Entry)((Map)this.map).entrySet().iterator().next()).getKey());
    }
    ((Map)this.map).put(paramString1, paramString2);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/share/watchword/RIJWatchWordShareManager$Companion;", "", "()V", "CLIP_TAG", "", "TAG", "WATCH_WORD_COUNT", "", "instance", "Lcom/tencent/biz/pubaccount/share/watchword/RIJWatchWordShareManager;", "getInstance", "()Lcom/tencent/biz/pubaccount/share/watchword/RIJWatchWordShareManager;", "instance$delegate", "Lkotlin/Lazy;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    @NotNull
    public final nyw a()
    {
      Lazy localLazy = nyw.a();
      a locala = nyw.a;
      return (nyw)localLazy.getValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyw
 * JD-Core Version:    0.7.0.1
 */