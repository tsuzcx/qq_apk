package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SerializationUtils
{
  /* Error */
  public static <T extends Serializable> T clone(T paramT)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_1
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: new 20	java/io/ByteArrayInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokestatic 24	org/apache/commons/lang3/SerializationUtils:serialize	(Ljava/io/Serializable;)[B
    //   18: invokespecial 27	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: astore_1
    //   22: new 6	org/apache/commons/lang3/SerializationUtils$ClassLoaderAwareObjectInputStream
    //   25: dup
    //   26: aload_1
    //   27: aload_0
    //   28: invokevirtual 31	java/lang/Object:getClass	()Ljava/lang/Class;
    //   31: invokevirtual 37	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   34: invokespecial 40	org/apache/commons/lang3/SerializationUtils$ClassLoaderAwareObjectInputStream:<init>	(Ljava/io/InputStream;Ljava/lang/ClassLoader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 44	org/apache/commons/lang3/SerializationUtils$ClassLoaderAwareObjectInputStream:readObject	()Ljava/lang/Object;
    //   44: checkcast 46	java/io/Serializable
    //   47: astore_2
    //   48: aload_2
    //   49: astore_0
    //   50: aload_1
    //   51: ifnull -43 -> 8
    //   54: aload_1
    //   55: invokevirtual 49	org/apache/commons/lang3/SerializationUtils$ClassLoaderAwareObjectInputStream:close	()V
    //   58: aload_2
    //   59: areturn
    //   60: astore_0
    //   61: new 51	org/apache/commons/lang3/SerializationException
    //   64: dup
    //   65: ldc 53
    //   67: aload_0
    //   68: invokespecial 56	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: athrow
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: new 51	org/apache/commons/lang3/SerializationException
    //   78: dup
    //   79: ldc 58
    //   81: aload_2
    //   82: invokespecial 56	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_2
    //   87: aload_0
    //   88: astore_1
    //   89: aload_2
    //   90: astore_0
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 49	org/apache/commons/lang3/SerializationUtils$ClassLoaderAwareObjectInputStream:close	()V
    //   99: aload_0
    //   100: athrow
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_0
    //   104: new 51	org/apache/commons/lang3/SerializationException
    //   107: dup
    //   108: ldc 60
    //   110: aload_2
    //   111: invokespecial 56	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: athrow
    //   115: astore_0
    //   116: new 51	org/apache/commons/lang3/SerializationException
    //   119: dup
    //   120: ldc 53
    //   122: aload_0
    //   123: invokespecial 56	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: athrow
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: goto -39 -> 91
    //   133: astore_2
    //   134: aload_1
    //   135: astore_0
    //   136: goto -32 -> 104
    //   139: astore_2
    //   140: aload_1
    //   141: astore_0
    //   142: goto -67 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramT	T
    //   1	140	1	localObject1	Object
    //   47	12	2	localSerializable	Serializable
    //   72	10	2	localClassNotFoundException1	ClassNotFoundException
    //   86	4	2	localObject2	Object
    //   101	10	2	localIOException1	IOException
    //   133	1	2	localIOException2	IOException
    //   139	1	2	localClassNotFoundException2	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   54	58	60	java/io/IOException
    //   22	38	72	java/lang/ClassNotFoundException
    //   40	48	86	finally
    //   75	86	86	finally
    //   104	115	86	finally
    //   22	38	101	java/io/IOException
    //   95	99	115	java/io/IOException
    //   22	38	127	finally
    //   40	48	133	java/io/IOException
    //   40	48	139	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public static <T> T deserialize(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 68	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 70
    //   10: invokespecial 73	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aconst_null
    //   15: astore_2
    //   16: aconst_null
    //   17: astore_1
    //   18: aconst_null
    //   19: astore_3
    //   20: new 75	java/io/ObjectInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 78	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 79	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: astore_2
    //   36: aload_0
    //   37: ifnull +7 -> 44
    //   40: aload_0
    //   41: invokevirtual 80	java/io/ObjectInputStream:close	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_0
    //   50: astore_1
    //   51: new 51	org/apache/commons/lang3/SerializationException
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 83	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: astore_0
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 80	java/io/ObjectInputStream:close	()V
    //   69: aload_0
    //   70: athrow
    //   71: astore_0
    //   72: aload_3
    //   73: astore_1
    //   74: new 51	org/apache/commons/lang3/SerializationException
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 83	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   82: athrow
    //   83: new 51	org/apache/commons/lang3/SerializationException
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 83	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   91: athrow
    //   92: astore_0
    //   93: aload_2
    //   94: areturn
    //   95: astore_1
    //   96: goto -27 -> 69
    //   99: astore_2
    //   100: aload_0
    //   101: astore_1
    //   102: aload_2
    //   103: astore_0
    //   104: goto -21 -> 83
    //   107: astore_2
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: astore_0
    //   112: goto -38 -> 74
    //   115: astore_2
    //   116: goto -67 -> 49
    //   119: astore_0
    //   120: goto -59 -> 61
    //   123: astore_0
    //   124: aload_2
    //   125: astore_1
    //   126: goto -43 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramInputStream	InputStream
    //   17	57	1	localObject1	Object
    //   95	1	1	localIOException1	IOException
    //   101	25	1	localObject2	Object
    //   15	30	2	localObject3	Object
    //   46	48	2	localClassCastException1	java.lang.ClassCastException
    //   99	4	2	localIOException2	IOException
    //   107	4	2	localClassNotFoundException	ClassNotFoundException
    //   115	10	2	localClassCastException2	java.lang.ClassCastException
    //   19	54	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	46	java/lang/ClassCastException
    //   31	36	60	finally
    //   51	60	60	finally
    //   20	29	71	java/lang/ClassNotFoundException
    //   40	44	92	java/io/IOException
    //   65	69	95	java/io/IOException
    //   31	36	99	java/io/IOException
    //   31	36	107	java/lang/ClassNotFoundException
    //   31	36	115	java/lang/ClassCastException
    //   20	29	119	finally
    //   74	83	119	finally
    //   83	92	119	finally
    //   20	29	123	java/io/IOException
  }
  
  public static <T> T deserialize(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("The byte[] must not be null");
    }
    return deserialize(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static <T extends Serializable> T roundtrip(T paramT)
  {
    return (Serializable)deserialize(serialize(paramT));
  }
  
  /* Error */
  public static void serialize(Serializable paramSerializable, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 68	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 96
    //   10: invokespecial 73	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: new 98	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 101	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 105	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: aload_2
    //   31: ifnull +7 -> 38
    //   34: aload_2
    //   35: invokevirtual 106	java/io/ObjectOutputStream:close	()V
    //   38: return
    //   39: astore_0
    //   40: aconst_null
    //   41: astore_1
    //   42: new 51	org/apache/commons/lang3/SerializationException
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 83	org/apache/commons/lang3/SerializationException:<init>	(Ljava/lang/Throwable;)V
    //   50: athrow
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 106	java/io/ObjectOutputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: astore_0
    //   63: return
    //   64: astore_1
    //   65: goto -5 -> 60
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_1
    //   71: goto -19 -> 52
    //   74: astore_0
    //   75: aload_2
    //   76: astore_1
    //   77: goto -35 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramSerializable	Serializable
    //   0	80	1	paramOutputStream	java.io.OutputStream
    //   22	54	2	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   14	23	39	java/io/IOException
    //   25	30	51	finally
    //   42	51	51	finally
    //   34	38	62	java/io/IOException
    //   56	60	64	java/io/IOException
    //   14	23	68	finally
    //   25	30	74	java/io/IOException
  }
  
  public static byte[] serialize(Serializable paramSerializable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    serialize(paramSerializable, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  static class ClassLoaderAwareObjectInputStream
    extends ObjectInputStream
  {
    private static final Map<String, Class<?>> primitiveTypes = new HashMap();
    private final ClassLoader classLoader;
    
    public ClassLoaderAwareObjectInputStream(InputStream paramInputStream, ClassLoader paramClassLoader)
      throws IOException
    {
      super();
      this.classLoader = paramClassLoader;
      primitiveTypes.put("byte", Byte.TYPE);
      primitiveTypes.put("short", Short.TYPE);
      primitiveTypes.put("int", Integer.TYPE);
      primitiveTypes.put("long", Long.TYPE);
      primitiveTypes.put("float", Float.TYPE);
      primitiveTypes.put("double", Double.TYPE);
      primitiveTypes.put("boolean", Boolean.TYPE);
      primitiveTypes.put("char", Character.TYPE);
      primitiveTypes.put("void", Void.TYPE);
    }
    
    protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
      throws IOException, ClassNotFoundException
    {
      Object localObject = paramObjectStreamClass.getName();
      try
      {
        paramObjectStreamClass = Class.forName((String)localObject, false, this.classLoader);
        return paramObjectStreamClass;
      }
      catch (ClassNotFoundException paramObjectStreamClass)
      {
        do
        {
          try
          {
            paramObjectStreamClass = Class.forName((String)localObject, false, Thread.currentThread().getContextClassLoader());
            return paramObjectStreamClass;
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            localObject = (Class)primitiveTypes.get(localObject);
            paramObjectStreamClass = (ObjectStreamClass)localObject;
          }
        } while (localObject != null);
        throw localClassNotFoundException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.SerializationUtils
 * JD-Core Version:    0.7.0.1
 */