import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class rtt
{
  public int bizType;
  public int bvq;
  public int flag;
  public ArrayList<rtt.a> nP;
  public int version;
  
  public rtt()
  {
    this.nP = new ArrayList();
  }
  
  public rtt(String paramString)
    throws Exception
  {
    sK(paramString);
  }
  
  public static rtt a(int paramInt, String paramString)
  {
    long l;
    byte[] arrayOfByte;
    Object localObject;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      if (paramString != null)
      {
        l = Long.parseLong(paramString);
        paramString = new rtt();
        paramString.version = 1;
        paramString.bvq = 1;
        paramString.bizType = paramInt;
        paramString.flag = 0;
        paramString.nP = new ArrayList();
        arrayOfByte = rwt.longToBytes(l);
        localObject = ByteBuffer.allocate(4);
        ((ByteBuffer)localObject).put(arrayOfByte, 4, 4);
        ((ByteBuffer)localObject).flip();
        arrayOfByte = new byte[((ByteBuffer)localObject).limit()];
        ((ByteBuffer)localObject).get(arrayOfByte);
        if (paramInt != 2) {
          break label145;
        }
        paramInt = 2;
      }
    }
    for (;;)
    {
      localObject = new rtt.a(paramInt, (short)4, arrayOfByte);
      paramString.nP.add(localObject);
      return paramString;
      l = 0L;
      break;
      label145:
      if (paramInt == 3)
      {
        paramInt = 7;
        continue;
        return null;
      }
      else
      {
        paramInt = 1;
      }
    }
  }
  
  public rtt.a a()
  {
    if ((this.nP != null) && (!this.nP.isEmpty())) {
      return (rtt.a)this.nP.get(0);
    }
    return null;
  }
  
  public String ng()
  {
    if (this.nP != null)
    {
      localObject1 = this.nP.iterator();
      for (int i = 4;; i = ((rtt.a)((Iterator)localObject1).next()).tZ() + i)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      }
    }
    int j = 4;
    Object localObject1 = ByteBuffer.allocate(j);
    ((ByteBuffer)localObject1).put((byte)this.version);
    ((ByteBuffer)localObject1).put((byte)this.bvq);
    ((ByteBuffer)localObject1).put((byte)this.bizType);
    ((ByteBuffer)localObject1).put((byte)this.flag);
    if ((this.nP != null) && (!this.nP.isEmpty()))
    {
      ((ByteBuffer)localObject1).put((byte)this.nP.size());
      localObject2 = this.nP.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        rtt.a locala = (rtt.a)((Iterator)localObject2).next();
        ((ByteBuffer)localObject1).put((byte)locala.type);
        ((ByteBuffer)localObject1).putShort(locala.length);
        ((ByteBuffer)localObject1).put(locala.value);
      }
    }
    ((ByteBuffer)localObject1).flip();
    Object localObject2 = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get((byte[])localObject2);
    return aqhs.bytes2HexStr((byte[])localObject2);
  }
  
  public void sK(String paramString)
    throws Exception
  {
    Object localObject = aqhs.hexStr2Bytes(paramString);
    paramString = ByteBuffer.allocate(localObject.length);
    paramString.put((byte[])localObject);
    paramString.flip();
    this.version = paramString.get();
    this.bvq = paramString.get();
    this.bizType = paramString.get();
    this.flag = paramString.get();
    int j = paramString.get();
    this.nP = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localObject = new rtt.a();
      ((rtt.a)localObject).type = paramString.get();
      byte[] arrayOfByte = new byte[2];
      paramString.get(arrayOfByte);
      ((rtt.a)localObject).length = rwt.bytesToShort(arrayOfByte);
      arrayOfByte = new byte[((rtt.a)localObject).length];
      paramString.get(arrayOfByte);
      ((rtt.a)localObject).value = arrayOfByte;
      this.nP.add(localObject);
      i += 1;
    }
  }
  
  public int tY()
  {
    if (this.nP != null) {
      return this.nP.size();
    }
    return 0;
  }
  
  public static class a
  {
    short length = 0;
    int type = 0;
    byte[] value = null;
    
    public a() {}
    
    public a(int paramInt, short paramShort, byte[] paramArrayOfByte)
    {
      this.type = paramInt;
      this.value = paramArrayOfByte;
      this.length = paramShort;
    }
    
    public long getLongValue()
      throws Exception
    {
      return rwt.bytesToLong(this.value);
    }
    
    public String getStringValue()
    {
      return new String(this.value);
    }
    
    public int tZ()
    {
      return this.value.length + 4;
    }
    
    public String toString()
    {
      return String.format("{t: %s, l: %s, v: %s}", new Object[] { Integer.valueOf(this.type), Short.valueOf(this.length), this.value });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     rtt
 * JD-Core Version:    0.7.0.1
 */