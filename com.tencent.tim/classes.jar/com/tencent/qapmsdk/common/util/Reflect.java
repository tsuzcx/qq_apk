package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/Reflect;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class Reflect
{
  public static final Companion Companion = new Companion(null);
  private static final String TAG = "QAPM_common_Reflect";
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/Reflect$Companion;", "", "()V", "TAG", "", "getInstancePrivateField", "instance", "filedName", "getThreadPrivateField", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @Nullable
    public final Object getInstancePrivateField(@NotNull Object paramObject, @NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "instance");
      Intrinsics.checkParameterIsNotNull(paramString, "filedName");
      try
      {
        Field localField = paramObject.getClass().getDeclaredField(paramString);
        Intrinsics.checkExpressionValueIsNotNull(localField, "field");
        localField.setAccessible(true);
        paramObject = localField.get(paramObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        Logger.INSTANCE.d(new String[] { "QAPM_common_Reflect", "getInstancePrivateField " + paramString, paramObject.toString() });
      }
      return null;
    }
    
    @Nullable
    public final Object getThreadPrivateField(@NotNull Object paramObject, @NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "instance");
      Intrinsics.checkParameterIsNotNull(paramString, "filedName");
      try
      {
        Field localField = Thread.class.getDeclaredField(paramString);
        Intrinsics.checkExpressionValueIsNotNull(localField, "field");
        localField.setAccessible(true);
        paramObject = localField.get(paramObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        Logger.INSTANCE.d(new String[] { "QAPM_common_Reflect", "getThreadPrivateField " + paramString, paramObject.toString() });
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.Reflect
 * JD-Core Version:    0.7.0.1
 */