import android.util.SparseArray;

public class anax
  extends anbl
{
  private SparseArray<Object> U;
  public long akr;
  public boolean cEC;
  public boolean cED;
  public boolean cEE;
  public boolean cEF;
  public boolean cEG;
  public boolean cEH;
  public boolean cEI;
  public int dEN;
  public int dEO;
  public int friendType;
  public boolean isRead;
  public long msgTime;
  public boolean og = true;
  public long senderUin;
  public long vipBubbleID;
  public int vipSubBubbleId;
  
  public anax(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.akr = paramLong1;
    this.friendUin = paramLong2;
    this.isRead = paramBoolean1;
    this.cEC = paramBoolean2;
    this.cED = paramBoolean3;
    this.cEE = paramBoolean4;
  }
  
  public void G(int paramInt, Object paramObject)
  {
    if (this.U == null) {
      this.U = new SparseArray();
    }
    this.U.put(paramInt, paramObject);
  }
  
  public Object getTag(int paramInt)
  {
    if (this.U != null) {
      return this.U.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anax
 * JD-Core Version:    0.7.0.1
 */