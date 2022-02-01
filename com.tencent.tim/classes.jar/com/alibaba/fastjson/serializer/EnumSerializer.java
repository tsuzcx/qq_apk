package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

class EnumSerializer
  implements ObjectSerializer
{
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
    throws IOException
  {
    paramJSONSerializer = paramJSONSerializer.out;
    if ((paramJSONSerializer.features & SerializerFeature.WriteEnumUsingToString.mask) != 0)
    {
      paramObject1 = ((Enum)paramObject1).toString();
      if ((paramJSONSerializer.features & SerializerFeature.UseSingleQuotes.mask) != 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramJSONSerializer.writeStringWithSingleQuote(paramObject1);
        return;
      }
      paramJSONSerializer.writeStringWithDoubleQuote(paramObject1, '\000', false);
      return;
    }
    paramJSONSerializer.writeInt(((Enum)paramObject1).ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.EnumSerializer
 * JD-Core Version:    0.7.0.1
 */