import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "", "event", "", "jsFunction", "", "jsParams", "bgUrl", "arkLoadState", "arkHeight", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getArkHeight", "()I", "getArkLoadState", "getBgUrl", "()Ljava/lang/String;", "getEvent", "getJsFunction", "getJsParams", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class abdl
{
  public static final abdl.a a = new abdl.a(null);
  @NotNull
  private final String aGm;
  private final int aqA;
  @NotNull
  private final String bfq;
  @NotNull
  private final String bgUrl;
  private final int cnJ;
  private final int cnK;
  
  public abdl(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt2, int paramInt3)
  {
    this.aqA = paramInt1;
    this.bfq = paramString1;
    this.aGm = paramString2;
    this.bgUrl = paramString3;
    this.cnK = paramInt2;
    this.cnJ = paramInt3;
  }
  
  public final int component1()
  {
    return this.aqA;
  }
  
  @NotNull
  public final String component2()
  {
    return this.bfq;
  }
  
  @NotNull
  public final String component3()
  {
    return this.aGm;
  }
  
  @NotNull
  public final String component4()
  {
    return this.bgUrl;
  }
  
  public final int component5()
  {
    return this.cnK;
  }
  
  public final int component6()
  {
    return this.cnJ;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof abdl))
      {
        paramObject = (abdl)paramObject;
        if ((this.aqA != paramObject.aqA) || (!Intrinsics.areEqual(this.bfq, paramObject.bfq)) || (!Intrinsics.areEqual(this.aGm, paramObject.aGm)) || (!Intrinsics.areEqual(this.bgUrl, paramObject.bgUrl)) || (this.cnK != paramObject.cnK) || (this.cnJ != paramObject.cnJ)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.aqA;
    String str = this.bfq;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.aGm;
      if (str == null) {
        break label98;
      }
    }
    label98:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.bgUrl;
      if (str != null) {
        k = str.hashCode();
      }
      return (((j + (i + m * 31) * 31) * 31 + k) * 31 + this.cnK) * 31 + this.cnJ;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "WebPageData(event=" + this.aqA + ", jsFunction=" + this.bfq + ", jsParams=" + this.aGm + ", bgUrl=" + this.bgUrl + ", arkLoadState=" + this.cnK + ", arkHeight=" + this.cnJ + ")";
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData$Companion;", "", "()V", "EVENT_ARK_LOAD_STATE", "", "EVENT_CHANGE_PAGE_BG", "EVENT_JS_CALL", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdl
 * JD-Core Version:    0.7.0.1
 */