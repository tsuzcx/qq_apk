package com.tencent.qapmsdk.base.config;

import com.tencent.qapmsdk.common.logger.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/WhiteUrl;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class WhiteUrl
{
  public static final Companion Companion = new Companion(null);
  private static final String TAG = "QAPM_base_WhiteUrl";
  @JvmField
  @NotNull
  public static final ArrayList<String> whiteHttpHosts = new ArrayList((Collection)CollectionsKt.listOf(new String[] { "sngapm.qq.com", "ten.sngapm.qq.com", "qapm.qq.com" }));
  
  @JvmStatic
  public static final void addWhiteHost(@NotNull String paramString)
  {
    Companion.addWhiteHost(paramString);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/WhiteUrl$Companion;", "", "()V", "TAG", "", "whiteHttpHosts", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "addWhiteHost", "", "url", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @JvmStatic
    public final void addWhiteHost(@NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "url");
      try
      {
        paramString = new URL(paramString);
        WhiteUrl.whiteHttpHosts.add(paramString.getHost());
        return;
      }
      catch (Exception paramString)
      {
        Logger.INSTANCE.exception("QAPM_base_WhiteUrl", (Throwable)paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.WhiteUrl
 * JD-Core Version:    0.7.0.1
 */