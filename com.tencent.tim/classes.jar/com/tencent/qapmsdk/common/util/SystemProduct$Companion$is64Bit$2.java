package com.tencent.qapmsdk.common.util;

import android.os.Process;
import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class SystemProduct$Companion$is64Bit$2
  extends Lambda
  implements Function0<Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  SystemProduct$Companion$is64Bit$2()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    if (AndroidVersion.Companion.isN()) {
      return Process.is64Bit();
    }
    try
    {
      String str = System.getProperty("ro.product.cpu.abilist");
      Intrinsics.checkExpressionValueIsNotNull(str, "System.getProperty(\"ro.product.cpu.abilist\")");
      boolean bool = StringsKt.contains$default((CharSequence)str, (CharSequence)"64", false, 2, null);
      return bool;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_common_SystemProduct", (Throwable)localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.SystemProduct.Companion.is64Bit.2
 * JD-Core Version:    0.7.0.1
 */