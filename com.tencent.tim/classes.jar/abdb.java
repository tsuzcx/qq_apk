import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WaterfallArk;", "", "appName", "", "appMeta", "appVersion", "appView", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppMeta", "()Ljava/lang/String;", "getAppName", "getAppVersion", "getAppView", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdb
{
  @NotNull
  private final String appName;
  @NotNull
  private final String appVersion;
  @NotNull
  private final String appView;
  @NotNull
  private final String bfo;
  
  public abdb(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    this.appName = paramString1;
    this.bfo = paramString2;
    this.appVersion = paramString3;
    this.appView = paramString4;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof abdb))
      {
        paramObject = (abdb)paramObject;
        if ((!Intrinsics.areEqual(this.appName, paramObject.appName)) || (!Intrinsics.areEqual(this.bfo, paramObject.bfo)) || (!Intrinsics.areEqual(this.appVersion, paramObject.appVersion)) || (!Intrinsics.areEqual(this.appView, paramObject.appView))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final String getAppName()
  {
    return this.appName;
  }
  
  @NotNull
  public final String getAppVersion()
  {
    return this.appVersion;
  }
  
  public int hashCode()
  {
    int m = 0;
    String str = this.appName;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.bfo;
      if (str == null) {
        break label95;
      }
      j = str.hashCode();
      label37:
      str = this.appVersion;
      if (str == null) {
        break label100;
      }
    }
    label95:
    label100:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.appView;
      if (str != null) {
        m = str.hashCode();
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  @NotNull
  public final String qP()
  {
    return this.bfo;
  }
  
  @NotNull
  public final String qQ()
  {
    return this.appView;
  }
  
  @NotNull
  public String toString()
  {
    return "WaterfallArk(appName=" + this.appName + ", appMeta=" + this.bfo + ", appVersion=" + this.appVersion + ", appView=" + this.appView + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdb
 * JD-Core Version:    0.7.0.1
 */