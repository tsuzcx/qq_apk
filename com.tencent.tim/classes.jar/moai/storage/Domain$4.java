package moai.storage;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import moai.proxy.JavaBeanProxy;

final class Domain$4
  implements PropertyPreFilter
{
  public boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString)
  {
    return JavaBeanProxy.has(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Domain.4
 * JD-Core Version:    0.7.0.1
 */