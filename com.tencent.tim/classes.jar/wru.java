import android.graphics.Rect;
import java.util.List;

public class wru
{
  private byte[] mBuffer;
  private int mLength;
  private int mPos = -1;
  
  public wru(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mBuffer = new byte[paramInt];
      this.mPos = 0;
      this.mLength = paramInt;
    }
  }
  
  private final void CK(int paramInt)
  {
    d(wre.intToBytes(paramInt), false);
  }
  
  private void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    while (this.mBuffer == null) {
      return;
    }
    int j = paramArrayOfByte.length;
    int i = j;
    if (paramBoolean) {
      i = j + 4;
    }
    if (this.mBuffer.length > this.mPos + i)
    {
      if (paramBoolean) {
        CK(paramArrayOfByte.length);
      }
      System.arraycopy(paramArrayOfByte, 0, this.mBuffer, this.mPos, paramArrayOfByte.length);
      this.mPos += paramArrayOfByte.length;
      return;
    }
    byte[] arrayOfByte = new byte[i + this.mBuffer.length * 2];
    System.arraycopy(this.mBuffer, 0, arrayOfByte, 0, this.mPos);
    this.mBuffer = arrayOfByte;
    this.mLength = arrayOfByte.length;
    if (paramBoolean) {
      CK(paramArrayOfByte.length);
    }
    System.arraycopy(paramArrayOfByte, 0, this.mBuffer, this.mPos, paramArrayOfByte.length);
    this.mPos += paramArrayOfByte.length;
  }
  
  private int wb()
  {
    if ((this.mBuffer != null) && (this.mPos + 4 <= this.mLength))
    {
      int i = wre.bytesToInt(this.mBuffer, this.mPos);
      this.mPos += 4;
      return i;
    }
    return -1;
  }
  
  public final <T> Object a(wrv.a<T> parama)
  {
    wb();
    return parama.a(this);
  }
  
  public wru.a a()
  {
    wru.a locala = new wru.a();
    locala.bRu = this.mPos;
    locala.mData = this.mBuffer;
    this.mBuffer = null;
    this.mPos = -1;
    return locala;
  }
  
  public final <T> void a(List<T> paramList, wrv.a<T> parama)
  {
    int k = paramList.size();
    int m = wb();
    int j = 0;
    int i = j;
    if (j < k)
    {
      i = j;
      if (j < m)
      {
        if (wb() != 0) {
          paramList.set(j, parama.a(this));
        }
        for (;;)
        {
          j += 1;
          break;
          paramList.set(j, null);
        }
      }
    }
    j = i;
    if (i < m)
    {
      if (wb() != 0) {
        paramList.add(parama.a(this));
      }
      for (;;)
      {
        i += 1;
        break;
        paramList.add(null);
      }
    }
    while (j < k)
    {
      paramList.remove(m);
      j += 1;
    }
  }
  
  public final void a(wrv paramwrv)
  {
    if (paramwrv != null)
    {
      int i = this.mPos;
      CK(0);
      paramwrv.a(this, 0);
      int j = this.mPos;
      if (this.mBuffer != null) {
        System.arraycopy(wre.intToBytes(j - i - 4), 0, this.mBuffer, i, 4);
      }
    }
  }
  
  public final void g(Rect paramRect)
  {
    if (paramRect == null)
    {
      CK(-1);
      return;
    }
    byte[] arrayOfByte1 = new byte[16];
    byte[] arrayOfByte2 = wre.intToBytes(paramRect.left);
    byte[] arrayOfByte3 = wre.intToBytes(paramRect.top);
    byte[] arrayOfByte4 = wre.intToBytes(paramRect.right);
    paramRect = wre.intToBytes(paramRect.bottom);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte1, 4, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte1, 8, 4);
    System.arraycopy(paramRect, 0, arrayOfByte1, 12, 4);
    d(arrayOfByte1, true);
  }
  
  public Rect r()
  {
    int i = wb();
    if (i == -1) {}
    while ((this.mBuffer == null) || (this.mPos + 16 > this.mLength) || (i != 16)) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = wre.bytesToInt(this.mBuffer, this.mPos);
    this.mPos += 4;
    localRect.top = wre.bytesToInt(this.mBuffer, this.mPos);
    this.mPos += 4;
    localRect.right = wre.bytesToInt(this.mBuffer, this.mPos);
    this.mPos += 4;
    localRect.bottom = wre.bytesToInt(this.mBuffer, this.mPos);
    this.mPos += 4;
    return localRect;
  }
  
  public float readFloat()
  {
    int i = wb();
    if ((this.mBuffer != null) && (this.mLength >= this.mPos + 4) && (i == 4))
    {
      i = wre.bytesToInt(this.mBuffer, this.mPos);
      this.mPos += 4;
      return Float.intBitsToFloat(i);
    }
    return -1.0F;
  }
  
  public int readInt()
  {
    int i = wb();
    if ((this.mBuffer != null) && (this.mPos + 4 <= this.mLength) && (i == 4))
    {
      i = wre.bytesToInt(this.mBuffer, this.mPos);
      this.mPos += 4;
      return i;
    }
    return -1;
  }
  
  public long readLong()
  {
    int i = wb();
    if ((this.mBuffer != null) && (this.mLength >= this.mPos + 8) && (i == 8))
    {
      long l = wre.bytes2Long(this.mBuffer, this.mPos);
      this.mPos += 8;
      return l;
    }
    return -1L;
  }
  
  public void unmarshall(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.mBuffer = paramArrayOfByte;
    this.mPos = paramInt1;
    this.mLength = paramInt2;
  }
  
  public final void writeFloat(float paramFloat)
  {
    d(wre.intToBytes(Float.floatToIntBits(paramFloat)), true);
  }
  
  public final void writeInt(int paramInt)
  {
    d(wre.intToBytes(paramInt), true);
  }
  
  public final void writeLong(long paramLong)
  {
    d(wre.d(paramLong), true);
  }
  
  public final <T extends wrv> void writeTypedList(List<T> paramList)
  {
    if (paramList == null)
    {
      CK(-1);
      return;
    }
    int j = paramList.size();
    CK(j);
    int i = 0;
    label24:
    if (i < j)
    {
      wrv localwrv = (wrv)paramList.get(i);
      if (localwrv == null) {
        break label67;
      }
      CK(1);
      localwrv.a(this, 0);
    }
    for (;;)
    {
      i += 1;
      break label24;
      break;
      label67:
      CK(0);
    }
  }
  
  public class a
  {
    public int bRu = 0;
    public byte[] mData;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wru
 * JD-Core Version:    0.7.0.1
 */