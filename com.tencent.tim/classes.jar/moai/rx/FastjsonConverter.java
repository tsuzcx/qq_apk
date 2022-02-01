package moai.rx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.OutputStream;
import retrofit.converter.Converter;
import retrofit.mime.TypedOutput;

public class FastjsonConverter
  implements Converter
{
  private static final String ERR_CODE_KEY = "errcode";
  private static final String ERR_MSG_KEY = "errmsg";
  
  /* Error */
  public Object fromBody(retrofit.mime.TypedInput paramTypedInput, java.lang.reflect.Type paramType)
    throws retrofit.converter.ConversionException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   6: lstore 4
    //   8: aload_1
    //   9: invokeinterface 47 1 0
    //   14: astore_1
    //   15: aload_1
    //   16: astore 6
    //   18: aload_1
    //   19: invokestatic 53	moai/io/Caches:toString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   22: astore 8
    //   24: aload_1
    //   25: astore 6
    //   27: aload 8
    //   29: invokevirtual 59	java/lang/String:length	()I
    //   32: istore_3
    //   33: iload_3
    //   34: sipush 256
    //   37: if_icmpge +16 -> 53
    //   40: aload_1
    //   41: astore 6
    //   43: new 11	moai/rx/FastjsonConverter$CommonErrorProcessor
    //   46: dup
    //   47: aconst_null
    //   48: invokespecial 62	moai/rx/FastjsonConverter$CommonErrorProcessor:<init>	(Lmoai/rx/FastjsonConverter$1;)V
    //   51: astore 7
    //   53: aload_1
    //   54: astore 6
    //   56: aload_2
    //   57: instanceof 64
    //   60: ifeq +148 -> 208
    //   63: aload_1
    //   64: astore 6
    //   66: aload_2
    //   67: checkcast 64	java/lang/reflect/ParameterizedType
    //   70: astore 9
    //   72: aload_1
    //   73: astore 6
    //   75: aload 9
    //   77: invokeinterface 68 1 0
    //   82: iconst_0
    //   83: aaload
    //   84: astore 9
    //   86: aload_1
    //   87: astore 6
    //   89: aload 9
    //   91: instanceof 70
    //   94: ifeq +95 -> 189
    //   97: aload_1
    //   98: astore 6
    //   100: aload 8
    //   102: aload 9
    //   104: checkcast 72	java/lang/Class
    //   107: invokestatic 78	com/alibaba/fastjson/JSON:parseArray	(Ljava/lang/String;Ljava/lang/Class;)Ljava/util/List;
    //   110: astore_2
    //   111: aload_2
    //   112: astore 8
    //   114: aload 7
    //   116: ifnull +165 -> 281
    //   119: aload_1
    //   120: astore 6
    //   122: aload_2
    //   123: astore 8
    //   125: aload 7
    //   127: getfield 82	moai/rx/FastjsonConverter$CommonErrorProcessor:errCode	I
    //   130: iconst_m1
    //   131: if_icmpeq +150 -> 281
    //   134: aload_1
    //   135: astore 6
    //   137: new 84	moai/rx/ServiceException
    //   140: dup
    //   141: aload 7
    //   143: getfield 87	moai/rx/FastjsonConverter$CommonErrorProcessor:errMsg	Ljava/lang/String;
    //   146: aload 7
    //   148: getfield 82	moai/rx/FastjsonConverter$CommonErrorProcessor:errCode	I
    //   151: invokespecial 90	moai/rx/ServiceException:<init>	(Ljava/lang/String;I)V
    //   154: athrow
    //   155: astore_2
    //   156: aload_1
    //   157: astore 6
    //   159: new 84	moai/rx/ServiceException
    //   162: dup
    //   163: aload_2
    //   164: invokevirtual 94	com/alibaba/fastjson/JSONException:getMessage	()Ljava/lang/String;
    //   167: iconst_m1
    //   168: invokespecial 90	moai/rx/ServiceException:<init>	(Ljava/lang/String;I)V
    //   171: athrow
    //   172: astore_2
    //   173: aload_1
    //   174: astore 6
    //   176: aload_2
    //   177: getfield 98	moai/rx/FastjsonConverter$CommonErrorException:serviceException	Lmoai/rx/ServiceException;
    //   180: athrow
    //   181: astore_1
    //   182: aload 6
    //   184: invokestatic 104	com/google/common/io/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   187: aload_1
    //   188: athrow
    //   189: aload_1
    //   190: astore 6
    //   192: aload 8
    //   194: aload_2
    //   195: aload 7
    //   197: iconst_0
    //   198: anewarray 106	com/alibaba/fastjson/parser/Feature
    //   201: invokestatic 110	com/alibaba/fastjson/JSON:parseObject	(Ljava/lang/String;Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/parser/deserializer/ParseProcess;[Lcom/alibaba/fastjson/parser/Feature;)Ljava/lang/Object;
    //   204: astore_2
    //   205: goto -94 -> 111
    //   208: aload_1
    //   209: astore 6
    //   211: aload 8
    //   213: aload_2
    //   214: aload 7
    //   216: iconst_0
    //   217: anewarray 106	com/alibaba/fastjson/parser/Feature
    //   220: invokestatic 110	com/alibaba/fastjson/JSON:parseObject	(Ljava/lang/String;Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/parser/deserializer/ParseProcess;[Lcom/alibaba/fastjson/parser/Feature;)Ljava/lang/Object;
    //   223: astore_2
    //   224: aload_2
    //   225: astore 8
    //   227: aload 7
    //   229: ifnull +52 -> 281
    //   232: aload_1
    //   233: astore 6
    //   235: aload_2
    //   236: astore 8
    //   238: aload 7
    //   240: getfield 82	moai/rx/FastjsonConverter$CommonErrorProcessor:errCode	I
    //   243: iconst_m1
    //   244: if_icmpeq +37 -> 281
    //   247: aload_1
    //   248: astore 6
    //   250: new 84	moai/rx/ServiceException
    //   253: dup
    //   254: aload 7
    //   256: getfield 87	moai/rx/FastjsonConverter$CommonErrorProcessor:errMsg	Ljava/lang/String;
    //   259: aload 7
    //   261: getfield 82	moai/rx/FastjsonConverter$CommonErrorProcessor:errCode	I
    //   264: invokespecial 90	moai/rx/ServiceException:<init>	(Ljava/lang/String;I)V
    //   267: athrow
    //   268: astore_2
    //   269: aload_1
    //   270: astore 6
    //   272: new 31	retrofit/converter/ConversionException
    //   275: dup
    //   276: aload_2
    //   277: invokespecial 113	retrofit/converter/ConversionException:<init>	(Ljava/lang/Throwable;)V
    //   280: athrow
    //   281: aload_1
    //   282: invokestatic 104	com/google/common/io/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   285: ldc 115
    //   287: new 117	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   294: ldc 120
    //   296: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload_3
    //   300: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc 129
    //   305: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   311: lload 4
    //   313: lsub
    //   314: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: ldc 134
    //   319: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 142	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: aload 8
    //   331: areturn
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 6
    //   336: goto -154 -> 182
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_1
    //   342: goto -73 -> 269
    //   345: astore_2
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -175 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	FastjsonConverter
    //   0	351	1	paramTypedInput	retrofit.mime.TypedInput
    //   0	351	2	paramType	java.lang.reflect.Type
    //   32	268	3	i	int
    //   6	306	4	l	long
    //   16	319	6	localTypedInput	retrofit.mime.TypedInput
    //   1	259	7	localCommonErrorProcessor	CommonErrorProcessor
    //   22	308	8	localObject1	Object
    //   70	33	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   75	86	155	com/alibaba/fastjson/JSONException
    //   89	97	155	com/alibaba/fastjson/JSONException
    //   100	111	155	com/alibaba/fastjson/JSONException
    //   125	134	155	com/alibaba/fastjson/JSONException
    //   137	155	155	com/alibaba/fastjson/JSONException
    //   192	205	155	com/alibaba/fastjson/JSONException
    //   18	24	172	moai/rx/FastjsonConverter$CommonErrorException
    //   27	33	172	moai/rx/FastjsonConverter$CommonErrorException
    //   43	53	172	moai/rx/FastjsonConverter$CommonErrorException
    //   56	63	172	moai/rx/FastjsonConverter$CommonErrorException
    //   66	72	172	moai/rx/FastjsonConverter$CommonErrorException
    //   75	86	172	moai/rx/FastjsonConverter$CommonErrorException
    //   89	97	172	moai/rx/FastjsonConverter$CommonErrorException
    //   100	111	172	moai/rx/FastjsonConverter$CommonErrorException
    //   125	134	172	moai/rx/FastjsonConverter$CommonErrorException
    //   137	155	172	moai/rx/FastjsonConverter$CommonErrorException
    //   159	172	172	moai/rx/FastjsonConverter$CommonErrorException
    //   192	205	172	moai/rx/FastjsonConverter$CommonErrorException
    //   211	224	172	moai/rx/FastjsonConverter$CommonErrorException
    //   238	247	172	moai/rx/FastjsonConverter$CommonErrorException
    //   250	268	172	moai/rx/FastjsonConverter$CommonErrorException
    //   18	24	181	finally
    //   27	33	181	finally
    //   43	53	181	finally
    //   56	63	181	finally
    //   66	72	181	finally
    //   75	86	181	finally
    //   89	97	181	finally
    //   100	111	181	finally
    //   125	134	181	finally
    //   137	155	181	finally
    //   159	172	181	finally
    //   176	181	181	finally
    //   192	205	181	finally
    //   211	224	181	finally
    //   238	247	181	finally
    //   250	268	181	finally
    //   272	281	181	finally
    //   18	24	268	java/io/IOException
    //   27	33	268	java/io/IOException
    //   43	53	268	java/io/IOException
    //   56	63	268	java/io/IOException
    //   66	72	268	java/io/IOException
    //   75	86	268	java/io/IOException
    //   89	97	268	java/io/IOException
    //   100	111	268	java/io/IOException
    //   125	134	268	java/io/IOException
    //   137	155	268	java/io/IOException
    //   159	172	268	java/io/IOException
    //   192	205	268	java/io/IOException
    //   211	224	268	java/io/IOException
    //   238	247	268	java/io/IOException
    //   250	268	268	java/io/IOException
    //   8	15	332	finally
    //   8	15	339	java/io/IOException
    //   8	15	345	moai/rx/FastjsonConverter$CommonErrorException
  }
  
  public void test() {}
  
  public TypedOutput toBody(Object paramObject)
  {
    return new JsonTypedOutput(JSON.toJSONString(paramObject, new FastjsonConverter.1(this), new SerializerFeature[0]).getBytes(), "UTF-8");
  }
  
  static class CommonErrorException
    extends RuntimeException
  {
    final ServiceException serviceException;
    
    private CommonErrorException(ServiceException paramServiceException)
    {
      this.serviceException = paramServiceException;
    }
  }
  
  static class CommonErrorProcessor
    implements ExtraProcessor
  {
    int errCode = -1;
    String errMsg = null;
    
    public void processExtra(Object paramObject1, String paramString, Object paramObject2)
    {
      if (paramObject2 != null)
      {
        if ("errcode".equals(paramString)) {
          this.errCode = TypeUtils.castToInt(paramObject2).intValue();
        }
        while ((this.errCode != -1) && (this.errMsg != null))
        {
          throw new FastjsonConverter.CommonErrorException(new ServiceException(this.errMsg, this.errCode), null);
          if ("errmsg".equals(paramString)) {
            this.errMsg = TypeUtils.castToString(paramObject2);
          }
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.FastjsonConverter
 * JD-Core Version:    0.7.0.1
 */