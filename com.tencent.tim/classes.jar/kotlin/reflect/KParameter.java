package kotlin.reflect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", "", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "Kind", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KParameter
  extends KAnnotatedElement
{
  public abstract int getIndex();
  
  @NotNull
  public abstract Kind getKind();
  
  @Nullable
  public abstract String getName();
  
  @NotNull
  public abstract KType getType();
  
  public abstract boolean isOptional();
  
  public abstract boolean isVararg();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
  public static final class DefaultImpls {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static enum Kind
  {
    static
    {
      Kind localKind1 = new Kind("INSTANCE", 0);
      INSTANCE = localKind1;
      Kind localKind2 = new Kind("EXTENSION_RECEIVER", 1);
      EXTENSION_RECEIVER = localKind2;
      Kind localKind3 = new Kind("VALUE", 2);
      VALUE = localKind3;
      $VALUES = new Kind[] { localKind1, localKind2, localKind3 };
    }
    
    private Kind() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KParameter
 * JD-Core Version:    0.7.0.1
 */