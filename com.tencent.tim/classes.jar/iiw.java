import com.tencent.qphone.base.util.QLog;

public class iiw
  extends ihv.a
{
  protected int anD;
  protected long roomId;
  
  public void bP(long paramLong)
  {
    QLog.i("SessionInfoBase", 1, "setRoomId old room id[" + this.roomId + "], new room id[" + paramLong + "].");
    this.roomId = paramLong;
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
      paramObject = (iiw)paramObject;
    } while (this.roomId == paramObject.roomId);
    return false;
  }
  
  public long getRoomId()
  {
    return this.roomId;
  }
  
  public int hashCode()
  {
    return (int)(this.roomId ^ this.roomId >>> 32);
  }
  
  public void kG(int paramInt)
  {
    this.anD = paramInt;
  }
  
  public int kO()
  {
    return this.anD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iiw
 * JD-Core Version:    0.7.0.1
 */