package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class JSONMessageCodec
  implements MessageCodec<Object>
{
  public static final JSONMessageCodec INSTANCE = new JSONMessageCodec();
  
  public Object decodeMessage(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      paramByteBuffer = null;
    }
    for (;;)
    {
      return paramByteBuffer;
      try
      {
        JSONTokener localJSONTokener = new JSONTokener(StringCodec.INSTANCE.decodeMessage(paramByteBuffer));
        paramByteBuffer = localJSONTokener.nextValue();
        if (!localJSONTokener.more()) {
          continue;
        }
        throw new IllegalArgumentException("Invalid JSON");
      }
      catch (JSONException paramByteBuffer)
      {
        throw new IllegalArgumentException("Invalid JSON", paramByteBuffer);
      }
    }
  }
  
  public ByteBuffer encodeMessage(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    paramObject = JSONUtil.wrap(paramObject);
    if ((paramObject instanceof String)) {
      return StringCodec.INSTANCE.encodeMessage(JSONObject.quote((String)paramObject));
    }
    return StringCodec.INSTANCE.encodeMessage(paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.common.JSONMessageCodec
 * JD-Core Version:    0.7.0.1
 */