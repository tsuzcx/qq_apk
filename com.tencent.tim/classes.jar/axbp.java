import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class axbp
  extends UniPacket
{
  private final String cTv = "compressed";
  
  public axbp(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  /* Error */
  private byte[] R(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 21	java/util/zip/Inflater
    //   9: dup
    //   10: invokespecial 24	java/util/zip/Inflater:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: iconst_0
    //   17: aload_1
    //   18: arraylength
    //   19: invokevirtual 28	java/util/zip/Inflater:setInput	([BII)V
    //   22: sipush 4096
    //   25: newarray byte
    //   27: astore_3
    //   28: new 30	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   35: astore 4
    //   37: aload_2
    //   38: invokevirtual 35	java/util/zip/Inflater:finished	()Z
    //   41: ifne +29 -> 70
    //   44: aload 4
    //   46: aload_3
    //   47: iconst_0
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual 39	java/util/zip/Inflater:inflate	([B)I
    //   53: invokevirtual 42	java/io/ByteArrayOutputStream:write	([BII)V
    //   56: goto -19 -> 37
    //   59: astore_3
    //   60: aload_3
    //   61: invokevirtual 45	java/util/zip/DataFormatException:printStackTrace	()V
    //   64: aload_2
    //   65: invokevirtual 48	java/util/zip/Inflater:end	()V
    //   68: aload_1
    //   69: areturn
    //   70: aload 4
    //   72: invokevirtual 52	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_3
    //   76: aload_2
    //   77: invokevirtual 48	java/util/zip/Inflater:end	()V
    //   80: aload_3
    //   81: areturn
    //   82: astore_1
    //   83: aload_2
    //   84: invokevirtual 48	java/util/zip/Inflater:end	()V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	axbp
    //   0	89	1	paramArrayOfByte	byte[]
    //   13	71	2	localInflater	java.util.zip.Inflater
    //   27	23	3	arrayOfByte1	byte[]
    //   59	2	3	localDataFormatException	java.util.zip.DataFormatException
    //   75	6	3	arrayOfByte2	byte[]
    //   35	36	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	56	59	java/util/zip/DataFormatException
    //   70	76	59	java/util/zip/DataFormatException
    //   37	56	82	finally
    //   60	64	82	finally
    //   70	76	82	finally
  }
  
  private void XZ(boolean paramBoolean) {}
  
  public <T> T getByClass(String paramString, T paramT)
    throws ObjectCreateException
  {
    Object localObject;
    if ((this._data != null) && (this._data.containsKey("compressed")) && (this._data.get("compressed") != null))
    {
      localObject = (byte[])((HashMap)this._data.get("compressed")).get("string");
      if ("true".equalsIgnoreCase(new String((byte[])localObject)))
      {
        localObject = (HashMap)this._data.get(paramString);
        if (localObject != null)
        {
          localObject = ((HashMap)localObject).entrySet().iterator();
          if (((Iterator)localObject).hasNext())
          {
            localObject = (Map.Entry)((Iterator)localObject).next();
            ((Map.Entry)localObject).setValue(R((byte[])((Map.Entry)localObject).getValue()));
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      XZ(bool);
      return super.getByClass(paramString, paramT);
      QLog.e("CompressUniPacket", 1, "not compressed " + new String((byte[])localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbp
 * JD-Core Version:    0.7.0.1
 */