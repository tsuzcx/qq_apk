package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map;

class Tables$TransformedTable$3
  implements Function<Map<R, V1>, Map<R, V2>>
{
  Tables$TransformedTable$3(Tables.TransformedTable paramTransformedTable) {}
  
  public Map<R, V2> apply(Map<R, V1> paramMap)
  {
    return Maps.transformValues(paramMap, this.this$0.function);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Tables.TransformedTable.3
 * JD-Core Version:    0.7.0.1
 */