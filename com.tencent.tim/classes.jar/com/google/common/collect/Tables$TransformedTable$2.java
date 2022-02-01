package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map;

class Tables$TransformedTable$2
  implements Function<Map<C, V1>, Map<C, V2>>
{
  Tables$TransformedTable$2(Tables.TransformedTable paramTransformedTable) {}
  
  public Map<C, V2> apply(Map<C, V1> paramMap)
  {
    return Maps.transformValues(paramMap, this.this$0.function);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Tables.TransformedTable.2
 * JD-Core Version:    0.7.0.1
 */