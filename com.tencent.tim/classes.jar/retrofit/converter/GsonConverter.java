package retrofit.converter;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import retrofit.mime.TypedOutput;

public class GsonConverter
  implements Converter
{
  private String charset;
  private final Gson gson;
  
  public GsonConverter(Gson paramGson)
  {
    this(paramGson, "UTF-8");
  }
  
  public GsonConverter(Gson paramGson, String paramString)
  {
    this.gson = paramGson;
    this.charset = paramString;
  }
  
  /* Error */
  public Object fromBody(retrofit.mime.TypedInput paramTypedInput, java.lang.reflect.Type paramType)
    throws ConversionException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	retrofit/converter/GsonConverter:charset	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: astore 4
    //   8: aload_1
    //   9: invokeinterface 42 1 0
    //   14: ifnull +15 -> 29
    //   17: aload_1
    //   18: invokeinterface 42 1 0
    //   23: aload_3
    //   24: invokestatic 48	retrofit/mime/MimeUtil:parseCharset	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 4
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore 5
    //   34: new 50	java/io/InputStreamReader
    //   37: dup
    //   38: aload_1
    //   39: invokeinterface 54 1 0
    //   44: aload 4
    //   46: invokespecial 57	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_1
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 26	retrofit/converter/GsonConverter:gson	Lcom/google/gson/Gson;
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 63	com/google/gson/Gson:fromJson	(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   61: astore_2
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 66	java/io/InputStreamReader:close	()V
    //   70: aload_2
    //   71: areturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_3
    //   77: new 32	retrofit/converter/ConversionException
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 69	retrofit/converter/ConversionException:<init>	(Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_1
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 66	java/io/InputStreamReader:close	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: aload 5
    //   100: astore_3
    //   101: new 32	retrofit/converter/ConversionException
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 69	retrofit/converter/ConversionException:<init>	(Ljava/lang/Throwable;)V
    //   109: athrow
    //   110: astore_1
    //   111: goto -24 -> 87
    //   114: astore_1
    //   115: aload_2
    //   116: areturn
    //   117: astore_2
    //   118: goto -23 -> 95
    //   121: astore_2
    //   122: aload_1
    //   123: astore_3
    //   124: aload_2
    //   125: astore_1
    //   126: goto -25 -> 101
    //   129: astore_2
    //   130: goto -55 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	GsonConverter
    //   0	133	1	paramTypedInput	retrofit.mime.TypedInput
    //   0	133	2	paramType	java.lang.reflect.Type
    //   4	120	3	localObject1	Object
    //   6	39	4	localObject2	Object
    //   32	67	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   34	50	72	java/io/IOException
    //   52	62	86	finally
    //   77	86	86	finally
    //   34	50	97	com/google/gson/JsonParseException
    //   34	50	110	finally
    //   101	110	110	finally
    //   66	70	114	java/io/IOException
    //   91	95	117	java/io/IOException
    //   52	62	121	com/google/gson/JsonParseException
    //   52	62	129	java/io/IOException
  }
  
  public TypedOutput toBody(Object paramObject)
  {
    try
    {
      paramObject = new JsonTypedOutput(this.gson.toJson(paramObject).getBytes(this.charset), this.charset);
      return paramObject;
    }
    catch (UnsupportedEncodingException paramObject)
    {
      throw new AssertionError(paramObject);
    }
  }
  
  static class JsonTypedOutput
    implements TypedOutput
  {
    private final byte[] jsonBytes;
    private final String mimeType;
    
    JsonTypedOutput(byte[] paramArrayOfByte, String paramString)
    {
      this.jsonBytes = paramArrayOfByte;
      this.mimeType = ("application/json; charset=" + paramString);
    }
    
    public String fileName()
    {
      return null;
    }
    
    public long length()
    {
      return this.jsonBytes.length;
    }
    
    public String mimeType()
    {
      return this.mimeType;
    }
    
    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(this.jsonBytes);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.converter.GsonConverter
 * JD-Core Version:    0.7.0.1
 */