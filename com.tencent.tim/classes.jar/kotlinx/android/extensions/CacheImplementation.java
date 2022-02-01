package kotlinx.android.extensions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/android/extensions/CacheImplementation;", "", "(Ljava/lang/String;I)V", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "Companion", "kotlin-android-extensions-runtime"}, k=1, mv={1, 1, 16})
public enum CacheImplementation
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  private static final CacheImplementation DEFAULT = HASH_MAP;
  
  static
  {
    CacheImplementation localCacheImplementation1 = new CacheImplementation("SPARSE_ARRAY", 0);
    SPARSE_ARRAY = localCacheImplementation1;
    CacheImplementation localCacheImplementation2 = new CacheImplementation("HASH_MAP", 1);
    HASH_MAP = localCacheImplementation2;
    CacheImplementation localCacheImplementation3 = new CacheImplementation("NO_CACHE", 2);
    NO_CACHE = localCacheImplementation3;
    $VALUES = new CacheImplementation[] { localCacheImplementation1, localCacheImplementation2, localCacheImplementation3 };
  }
  
  private CacheImplementation() {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/android/extensions/CacheImplementation$Companion;", "", "()V", "DEFAULT", "Lkotlinx/android/extensions/CacheImplementation;", "getDEFAULT", "()Lkotlinx/android/extensions/CacheImplementation;", "kotlin-android-extensions-runtime"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @NotNull
    public final CacheImplementation getDEFAULT()
    {
      return CacheImplementation.access$getDEFAULT$cp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlinx.android.extensions.CacheImplementation
 * JD-Core Version:    0.7.0.1
 */