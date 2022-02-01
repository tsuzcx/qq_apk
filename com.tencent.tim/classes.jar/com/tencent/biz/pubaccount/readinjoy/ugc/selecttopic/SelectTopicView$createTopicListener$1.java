package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class SelectTopicView$createTopicListener$1
  extends Lambda
  implements Function1<ColumnInfo, Unit>
{
  SelectTopicView$createTopicListener$1(SelectTopicView paramSelectTopicView)
  {
    super(1);
  }
  
  public final void invoke(@NotNull ColumnInfo paramColumnInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramColumnInfo, "it");
    this.this$0.W(paramColumnInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicView.createTopicListener.1
 * JD-Core Version:    0.7.0.1
 */