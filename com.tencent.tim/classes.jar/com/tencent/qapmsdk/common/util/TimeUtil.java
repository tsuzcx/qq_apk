package com.tencent.qapmsdk.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/TimeUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class TimeUtil
{
  public static final Companion Companion = new Companion(null);
  
  @NotNull
  public static final String getFormatDateByZone()
  {
    return Companion.getFormatDateByZone();
  }
  
  @NotNull
  public static final String getFormatDateMs()
  {
    return Companion.getFormatDateMs();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/TimeUtil$Companion;", "", "()V", "formatDateByZone", "", "formatDateByZone$annotations", "getFormatDateByZone", "()Ljava/lang/String;", "formatDateMs", "formatDateMs$annotations", "getFormatDateMs", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @NotNull
    public final String getFormatDateByZone()
    {
      String str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date());
      Intrinsics.checkExpressionValueIsNotNull(str, "SimpleDateFormat(\"yyyy-M…Locale.US).format(Date())");
      return str;
    }
    
    @NotNull
    public final String getFormatDateMs()
    {
      String str = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.ms", Locale.US).format(new Date());
      Intrinsics.checkExpressionValueIsNotNull(str, "SimpleDateFormat(\"yyyy-M…Locale.US).format(Date())");
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.TimeUtil
 * JD-Core Version:    0.7.0.1
 */