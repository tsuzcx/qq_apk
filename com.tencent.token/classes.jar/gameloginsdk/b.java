package gameloginsdk;

class b
{
  byte[] a = null;
  
  public b(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  private boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2) {}
    for (;;)
    {
      return true;
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
        return false;
      }
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return false;
      }
      int j = paramArrayOfByte1.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      return a(this.a, paramObject.a);
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      return a(this.a, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.b
 * JD-Core Version:    0.7.0.1
 */