package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="JvmClassMappingKt")
public final class JvmClassMappingKt
{
  @NotNull
  public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$annotationClass");
    paramT = paramT.annotationType();
    Intrinsics.checkExpressionValueIsNotNull(paramT, "(this as java.lang.annot…otation).annotationType()");
    paramT = getKotlinClass(paramT);
    if (paramT == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
    return paramT;
  }
  
  @NotNull
  public static final <T> Class<T> getJavaClass(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$javaClass");
    paramT = paramT.getClass();
    if (paramT == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
    return paramT;
  }
  
  @JvmName(name="getJavaClass")
  @NotNull
  public static final <T> Class<T> getJavaClass(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$java");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (paramKClass == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
    return paramKClass;
  }
  
  @NotNull
  public static final <T> Class<T> getJavaObjectType(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaObjectType");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    Object localObject;
    if (!paramKClass.isPrimitive())
    {
      localObject = paramKClass;
      if (paramKClass == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
      }
    }
    else
    {
      localObject = paramKClass.getName();
      if (localObject == null) {}
      for (;;)
      {
        localObject = paramKClass;
        if (paramKClass != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        switch (((String)localObject).hashCode())
        {
        default: 
          break;
        case -1325958191: 
          if (((String)localObject).equals("double")) {
            paramKClass = Double.class;
          }
          break;
        case 64711720: 
          if (((String)localObject).equals("boolean")) {
            paramKClass = Boolean.class;
          }
          break;
        case 3625364: 
          if (((String)localObject).equals("void")) {
            paramKClass = Void.class;
          }
          break;
        case 3039496: 
          if (((String)localObject).equals("byte")) {
            paramKClass = Byte.class;
          }
          break;
        case 3052374: 
          if (((String)localObject).equals("char")) {
            paramKClass = Character.class;
          }
          break;
        case 109413500: 
          if (((String)localObject).equals("short")) {
            paramKClass = Short.class;
          }
          break;
        case 97526364: 
          if (((String)localObject).equals("float")) {
            paramKClass = Float.class;
          }
          break;
        case 104431: 
          if (((String)localObject).equals("int")) {
            paramKClass = Integer.class;
          }
          break;
        case 3327612: 
          if (((String)localObject).equals("long")) {
            paramKClass = Long.class;
          }
          break;
        }
      }
    }
    return localObject;
  }
  
  @Nullable
  public static final <T> Class<T> getJavaPrimitiveType(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaPrimitiveType");
    Class localClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (localClass.isPrimitive())
    {
      paramKClass = localClass;
      if (localClass == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
      }
    }
    else
    {
      paramKClass = localClass.getName();
      if (paramKClass != null) {
        break label52;
      }
    }
    label52:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        paramKClass = null;
                        return paramKClass;
                        switch (paramKClass.hashCode())
                        {
                        }
                      }
                    } while (!paramKClass.equals("java.lang.Integer"));
                    return Integer.TYPE;
                  } while (!paramKClass.equals("java.lang.Float"));
                  return Float.TYPE;
                } while (!paramKClass.equals("java.lang.Void"));
                return Void.TYPE;
              } while (!paramKClass.equals("java.lang.Character"));
              return Character.TYPE;
            } while (!paramKClass.equals("java.lang.Long"));
            return Long.TYPE;
          } while (!paramKClass.equals("java.lang.Double"));
          return Double.TYPE;
        } while (!paramKClass.equals("java.lang.Short"));
        return Short.TYPE;
      } while (!paramKClass.equals("java.lang.Boolean"));
      return Boolean.TYPE;
    } while (!paramKClass.equals("java.lang.Byte"));
    return Byte.TYPE;
  }
  
  @JvmName(name="getKotlinClass")
  @NotNull
  public static final <T> KClass<T> getKotlinClass(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "$this$kotlin");
    return Reflection.getOrCreateKotlinClass(paramClass);
  }
  
  @JvmName(name="getRuntimeClassOfKClassInstance")
  @NotNull
  public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaClass");
    paramKClass = ((Object)paramKClass).getClass();
    if (paramKClass == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
    }
    return paramKClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.JvmClassMappingKt
 * JD-Core Version:    0.7.0.1
 */