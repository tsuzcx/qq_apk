package com.tencent.qapmsdk.base.reporter.proxy;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "key", "", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 15})
final class QAPMUploadProxy$report$1
  extends Lambda
  implements Function1<String, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  QAPMUploadProxy$report$1()
  {
    super(1);
  }
  
  public final boolean invoke(String paramString)
  {
    Object localObject = (Iterable)CollectionsKt.listOf(new String[] { "p_id", "version" });
    if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (Intrinsics.areEqual((String)((Iterator)localObject).next(), paramString)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.proxy.QAPMUploadProxy.report.1
 * JD-Core Version:    0.7.0.1
 */