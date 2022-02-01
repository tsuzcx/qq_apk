import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "", "adId", "", "adSource", "resVersion", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAdId", "()Ljava/lang/String;", "getAdSource", "getResVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvp
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final String b;
  
  public tvp(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof tvp))
      {
        paramObject = (tvp)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.b, paramObject.b)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.b;
      if (str != null) {
        j = str.hashCode();
      }
      return (i * 31 + j) * 31 + this.jdField_a_of_type_Int;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "AdResCheckInfo(adId=" + this.jdField_a_of_type_JavaLangString + ", adSource=" + this.b + ", resVersion=" + this.jdField_a_of_type_Int + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvp
 * JD-Core Version:    0.7.0.1
 */