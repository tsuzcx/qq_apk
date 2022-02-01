package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ModuleNameRetriever
{
  public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
  @JvmField
  @Nullable
  public static Cache cache;
  private static final Cache notOnJava9 = new Cache(null, null, null);
  
  private final Cache buildCache(BaseContinuationImpl paramBaseContinuationImpl)
  {
    try
    {
      paramBaseContinuationImpl = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      cache = paramBaseContinuationImpl;
      return paramBaseContinuationImpl;
    }
    catch (Exception paramBaseContinuationImpl)
    {
      paramBaseContinuationImpl = notOnJava9;
      cache = paramBaseContinuationImpl;
    }
    return paramBaseContinuationImpl;
  }
  
  @Nullable
  public final String getModuleName(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseContinuationImpl, "continuation");
    Object localObject = cache;
    if (localObject != null) {
      if (localObject != notOnJava9) {
        break label32;
      }
    }
    label32:
    do
    {
      Method localMethod;
      do
      {
        do
        {
          do
          {
            return null;
            localObject = buildCache(paramBaseContinuationImpl);
            break;
            localMethod = ((Cache)localObject).getModuleMethod;
          } while (localMethod == null);
          paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl.getClass(), new Object[0]);
        } while (paramBaseContinuationImpl == null);
        localMethod = ((Cache)localObject).getDescriptorMethod;
      } while (localMethod == null);
      paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl, new Object[0]);
    } while (paramBaseContinuationImpl == null);
    localObject = ((Cache)localObject).nameMethod;
    if (localObject != null) {}
    for (paramBaseContinuationImpl = ((Method)localObject).invoke(paramBaseContinuationImpl, new Object[0]);; paramBaseContinuationImpl = null)
    {
      localObject = paramBaseContinuationImpl;
      if (!(paramBaseContinuationImpl instanceof String)) {
        localObject = null;
      }
      return (String)localObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static final class Cache
  {
    @JvmField
    @Nullable
    public final Method getDescriptorMethod;
    @JvmField
    @Nullable
    public final Method getModuleMethod;
    @JvmField
    @Nullable
    public final Method nameMethod;
    
    public Cache(@Nullable Method paramMethod1, @Nullable Method paramMethod2, @Nullable Method paramMethod3)
    {
      this.getModuleMethod = paramMethod1;
      this.getDescriptorMethod = paramMethod2;
      this.nameMethod = paramMethod3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.ModuleNameRetriever
 * JD-Core Version:    0.7.0.1
 */