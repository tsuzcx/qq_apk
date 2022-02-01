import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/ISuperMaskRes$SuperMaskJson;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getJson", "()Lorg/json/JSONObject;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tuy
{
  @Nullable
  private final JSONObject a;
  
  public tuy(@Nullable JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
  }
  
  @Nullable
  public final JSONObject a()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof tuy))
      {
        paramObject = (tuy)paramObject;
        if (!Intrinsics.areEqual(this.a, paramObject.a)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    JSONObject localJSONObject = this.a;
    if (localJSONObject != null) {
      return localJSONObject.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return "SuperMaskJson(json=" + this.a + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tuy
 * JD-Core Version:    0.7.0.1
 */