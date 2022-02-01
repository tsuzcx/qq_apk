public class aeen
{
  long VP;
  long VQ;
  long VR;
  boolean bTt;
  int cMl;
  long groupUin;
  
  public aeen(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    this.groupUin = paramLong1;
    this.VP = paramLong2;
    this.cMl = paramInt;
    this.bTt = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof aeen))
    {
      paramObject = (aeen)paramObject;
      bool1 = bool2;
      if (paramObject.VP == this.VP)
      {
        bool1 = bool2;
        if (paramObject.groupUin == this.groupUin) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeen
 * JD-Core Version:    0.7.0.1
 */