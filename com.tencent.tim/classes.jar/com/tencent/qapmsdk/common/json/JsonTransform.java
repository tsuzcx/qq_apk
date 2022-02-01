package com.tencent.qapmsdk.common.json;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/json/JsonTransform;", "", "toJSON", "", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface JsonTransform
{
  @NotNull
  public abstract String toJSON();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls
  {
    @NotNull
    public static String toJSON(JsonTransform paramJsonTransform)
    {
      paramJsonTransform = new Gson().toJson(paramJsonTransform);
      Intrinsics.checkExpressionValueIsNotNull(paramJsonTransform, "Gson().toJson(this)");
      return paramJsonTransform;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.json.JsonTransform
 * JD-Core Version:    0.7.0.1
 */