import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData;", "", "event", "", "script", "", "leftSecond", "(ILjava/lang/String;I)V", "getEvent", "()I", "getLeftSecond", "getScript", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tif
{
  public static final tif.a a = new tif.a(null);
  @NotNull
  private final String aJs;
  private final int aqA;
  private final int bBx;
  
  public tif(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    this.aqA = paramInt1;
    this.aJs = paramString;
    this.bBx = paramInt2;
  }
  
  public final int component1()
  {
    return this.aqA;
  }
  
  @NotNull
  public final String component2()
  {
    return this.aJs;
  }
  
  public final int component3()
  {
    return this.bBx;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof tif))
      {
        paramObject = (tif)paramObject;
        if ((this.aqA != paramObject.aqA) || (!Intrinsics.areEqual(this.aJs, paramObject.aJs)) || (this.bBx != paramObject.bBx)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.aqA;
    String str = this.aJs;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0) {
      return (i + j * 31) * 31 + this.bBx;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "MotiveBrowsingData(event=" + this.aqA + ", script=" + this.aJs + ", leftSecond=" + this.bBx + ")";
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData$Companion;", "", "()V", "EVENT_CALL_BACK_JS", "", "EVENT_COUNT_DOWN", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tif
 * JD-Core Version:    0.7.0.1
 */