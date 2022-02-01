package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class SystemProduct$Companion$isYunOS$2
  extends Lambda
  implements Function0<Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  SystemProduct$Companion$isYunOS$2()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    Object localObject1 = (String)null;
    String str4 = (String)null;
    Object localObject2 = localObject1;
    Object localObject3 = localObject1;
    Object localObject4 = localObject1;
    Object localObject5 = localObject1;
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject5 = localObject1;
      Object localObject7 = localMethod.invoke(null, new Object[] { "ro.yunos.version" });
      Object localObject6 = localObject7;
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject5 = localObject1;
      if (!(localObject7 instanceof String)) {
        localObject6 = null;
      }
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject5 = localObject1;
      localObject1 = (String)localObject6;
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject5 = localObject1;
      localObject7 = localMethod.invoke(null, new Object[] { "java.vm.name" });
      localObject6 = localObject7;
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject5 = localObject1;
      if (!(localObject7 instanceof String)) {
        localObject6 = null;
      }
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject5 = localObject1;
      localObject6 = (String)localObject6;
      localObject2 = localObject6;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        Logger.INSTANCE.exception("QAPM_common_SystemProduct", (Throwable)localNoSuchMethodException);
        localObject2 = str4;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localObject1 = localNoSuchMethodException;
        Logger.INSTANCE.exception("QAPM_common_SystemProduct", (Throwable)localClassNotFoundException);
        String str1 = str4;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localObject1 = localObject4;
        Logger.INSTANCE.exception("QAPM_common_SystemProduct", (Throwable)localIllegalAccessException);
        String str2 = str4;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localObject1 = localObject5;
        Logger.INSTANCE.exception("QAPM_common_SystemProduct", (Throwable)localInvocationTargetException);
        str3 = str4;
      }
      String str3 = str3.toLowerCase(localNoSuchMethodException);
      Intrinsics.checkExpressionValueIsNotNull(str3, "(this as java.lang.String).toLowerCase(locale)");
      if (str3 == null) {
        break label476;
      }
      boolean bool = StringsKt.contains$default((CharSequence)str3, (CharSequence)"lemur", false, 2, null);
      if (bool) {
        break label537;
      }
      if (localObject1 == null) {
        break label546;
      }
      localObject1 = (CharSequence)localObject1;
      int j = ((CharSequence)localObject1).length() - 1;
      int i = 0;
      int k = 0;
      label433:
      if (k > j) {
        break label506;
      }
      if (i != 0) {
        break label482;
      }
      int m = k;
      label445:
      if (((CharSequence)localObject1).charAt(m) > ' ') {
        break label488;
      }
      m = 1;
      label462:
      if (i != 0) {
        break label501;
      }
      if (m != 0) {
        break label494;
      }
      i = 1;
      for (;;)
      {
        break label433;
        label476:
        bool = false;
        break;
        label482:
        m = j;
        break label445;
        label488:
        m = 0;
        break label462;
        label494:
        k += 1;
      }
      label501:
      if (m != 0) {
        break label539;
      }
      label506:
      localObject1 = ((CharSequence)localObject1).subSequence(k, j + 1).toString();
      if (localObject1 == null) {
        break label546;
      }
      label537:
      label539:
      label546:
      for (i = ((String)localObject1).length();; i = 0)
      {
        if (i <= 0) {
          break label551;
        }
        return true;
        j -= 1;
        break;
      }
    }
    if (localObject2 != null)
    {
      localObject3 = Locale.US;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "Locale.US");
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    label551:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.SystemProduct.Companion.isYunOS.2
 * JD-Core Version:    0.7.0.1
 */