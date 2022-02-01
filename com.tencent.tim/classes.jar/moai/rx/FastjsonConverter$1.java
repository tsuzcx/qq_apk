package moai.rx;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import moai.proxy.JavaBeanProxy;

class FastjsonConverter$1
  implements PropertyPreFilter
{
  FastjsonConverter$1(FastjsonConverter paramFastjsonConverter) {}
  
  public boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString)
  {
    return JavaBeanProxy.has(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.FastjsonConverter.1
 * JD-Core Version:    0.7.0.1
 */