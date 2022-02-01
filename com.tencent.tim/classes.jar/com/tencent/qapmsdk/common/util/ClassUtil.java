package com.tencent.qapmsdk.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/ClassUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ClassUtil
{
  public static final Companion Companion = new Companion(null);
  
  @JvmStatic
  public static final boolean classAvailable(@NotNull String paramString)
  {
    return Companion.classAvailable(paramString);
  }
  
  @JvmStatic
  public static final boolean objectIsInstanceClass(@Nullable Object paramObject, @NotNull String paramString)
  {
    return Companion.objectIsInstanceClass(paramObject, paramString);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/ClassUtil$Companion;", "", "()V", "classAvailable", "", "className", "", "objectIsInstanceClass", "obj", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @JvmStatic
    public final boolean classAvailable(@NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "className");
      try
      {
        Class.forName(paramString);
        return true;
      }
      catch (ClassNotFoundException paramString) {}
      return false;
    }
    
    @JvmStatic
    public final boolean objectIsInstanceClass(@Nullable Object paramObject, @NotNull String paramString)
    {
      boolean bool = false;
      Intrinsics.checkParameterIsNotNull(paramString, "className");
      if (paramObject != null) {}
      try
      {
        bool = Class.forName(paramString).isInstance(paramObject);
        return bool;
      }
      catch (ClassNotFoundException paramObject) {}
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ClassUtil
 * JD-Core Version:    0.7.0.1
 */