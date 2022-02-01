import androidx.annotation.Nullable;

public class arkf
{
  private int color;
  private Object data;
  private long timeInMillis;
  private int type;
  
  public arkf(int paramInt1, int paramInt2, long paramLong)
  {
    this.type = paramInt1;
    this.color = paramInt2;
    this.timeInMillis = paramLong;
  }
  
  public arkf(int paramInt1, int paramInt2, long paramLong, Object paramObject)
  {
    this.type = paramInt1;
    this.color = paramInt2;
    this.timeInMillis = paramLong;
    this.data = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (arkf)paramObject;
      if (this.color != paramObject.color) {
        return false;
      }
      if (this.timeInMillis != paramObject.timeInMillis) {
        return false;
      }
      if (this.data == null) {
        break;
      }
    } while (this.data.equals(paramObject.data));
    for (;;)
    {
      return false;
      if (paramObject.data == null) {
        break;
      }
    }
  }
  
  @Nullable
  public Object getData()
  {
    return this.data;
  }
  
  public long getTimeInMillis()
  {
    return this.timeInMillis;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    int j = this.color;
    int k = (int)(this.timeInMillis ^ this.timeInMillis >>> 32);
    if (this.data != null) {}
    for (int i = this.data.hashCode();; i = 0) {
      return i + (j * 31 + k) * 31;
    }
  }
  
  public String toString()
  {
    return "Event{type=" + this.type + ", color=" + this.color + ", timeInMillis=" + this.timeInMillis + ", data=" + this.data + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkf
 * JD-Core Version:    0.7.0.1
 */