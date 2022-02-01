import android.os.Build;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/CodecReuseHelper;", "", "()V", "cacheDebugText", "", "codecJson", "getDebugText", "isCodecReuseEnable", "", "setCodecJson", "", "setMediaCodecInfo", "mediaCodecInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPMediaCodecInfo;", "Companion", "OnCodecReuseInfoUpdateCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mrs
{
  public static final mrs.a a = new mrs.a(null);
  private String ajJ = "";
  private String ajK = "";
  
  public final boolean DZ()
  {
    boolean bool2 = false;
    int j = Aladdin.getConfig(309).getIntegerFromString("video_codec_reuse_enable", 0);
    Object localObject = Aladdin.getConfig(309).getString("black_hardware_os_list", "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "blackHardWareList");
    localObject = StringsKt.split$default((CharSequence)localObject, new String[] { "," }, false, 0, 6, null).iterator();
    String str;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      str = (String)((Iterator)localObject).next();
    } while ((!TextUtils.equals((CharSequence)str, (CharSequence)Build.MODEL)) || (TextUtils.isEmpty((CharSequence)str)));
    for (int i = 1;; i = 0)
    {
      boolean bool1 = bool2;
      if (1 == j)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public final void a(@Nullable TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo)
  {
    if (paramTPMediaCodecInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("CodecReuseHelper", 2, "parseAndSetMediaCodecInfo failed for mediaCodecInfo is null.");
      }
    }
    while ((paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) || (paramTPMediaCodecInfo.mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)) {
      return;
    }
    paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
    Intrinsics.checkExpressionValueIsNotNull(paramTPMediaCodecInfo, "mediaCodecInfo.msg");
    nN(paramTPMediaCodecInfo);
  }
  
  @NotNull
  public final String hl()
  {
    if (TextUtils.isEmpty((CharSequence)this.ajK)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.ajJ);
      if (localJSONObject.optBoolean("isVideo", false))
      {
        boolean bool1 = localJSONObject.optBoolean("isReuse", false);
        boolean bool2 = localJSONObject.optBoolean("reuseEnable", false);
        int i = localJSONObject.optInt("totalCodec", -1);
        this.ajK = ("isReuse:" + bool1 + " reuseEnable:" + bool2 + "\ntotalCodec:" + i);
      }
      return this.ajK;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.w("CodecReuseHelper", 1, "getDebugText error for parse Json:" + this.ajJ);
      }
    }
  }
  
  public final void nN(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "codecJson");
    if (TextUtils.equals((CharSequence)this.ajJ, (CharSequence)paramString)) {
      return;
    }
    this.ajJ = paramString;
    this.ajK = "";
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/CodecReuseHelper$Companion;", "", "()V", "BLACK_LIST_SEPARATOR", "", "DEFAULT_VIDEO_CODEC_REUSE_ENABLE", "", "TAG", "VIDEO_CODEC_REUSE_ENABLE", "setToReportData", "", "mediaCodecInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPMediaCodecInfo;", "reportData", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;", "setToReportDataByExtraObject", "extraObject", "Ljava/lang/Object;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public final void a(@NotNull TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo, @NotNull mhu parammhu)
    {
      Intrinsics.checkParameterIsNotNull(paramTPMediaCodecInfo, "mediaCodecInfo");
      Intrinsics.checkParameterIsNotNull(parammhu, "reportData");
      if ((paramTPMediaCodecInfo.mediaType == TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO) && (paramTPMediaCodecInfo.infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY))
      {
        paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
        parammhu.videoCodecJson = paramTPMediaCodecInfo;
      }
      try
      {
        paramTPMediaCodecInfo = new JSONObject(paramTPMediaCodecInfo);
        parammhu.videoCodecEnable = paramTPMediaCodecInfo.optBoolean("reuseEnable");
        parammhu.videoCodecReused = paramTPMediaCodecInfo.optBoolean("isReuse");
        parammhu.videoTotalCodecDuration = paramTPMediaCodecInfo.optInt("totalCodec");
        return;
      }
      catch (Throwable paramTPMediaCodecInfo)
      {
        LogUtil.e("CodecReuseHelper", "onCodecReuseInfo error:" + paramTPMediaCodecInfo.getMessage());
      }
    }
    
    public final void a(@NotNull Object paramObject, @NotNull mhu parammhu)
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "extraObject");
      Intrinsics.checkParameterIsNotNull(parammhu, "reportData");
      if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
      {
        paramObject = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
        ((a)this).a(paramObject, parammhu);
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/CodecReuseHelper$OnCodecReuseInfoUpdateCallback;", "", "onCodecReuseInfoUpdate", "", "debugInfo", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface b
  {
    public abstract void nO(@NotNull String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrs
 * JD-Core Version:    0.7.0.1
 */