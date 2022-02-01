public class ioa
{
  public String OL = "";
  public boolean Tp;
  public boolean Tq;
  public boolean Tr;
  public boolean Ts;
  public boolean Tt;
  public boolean isRender;
  public long mk = 4L;
  public long uin;
  public int videoSrcType = 0;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof ioa)))
    {
      paramObject = (ioa)paramObject;
      if (this.uin == paramObject.uin) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "Uin[" + this.uin + "], VideoSrcType[" + this.videoSrcType + "], isBig[" + this.Tp + "], isRender[" + this.isRender + "], isNeedRequest[" + this.Tq + "], hasRecvData[" + this.Tr + "], inviteId[" + this.OL + "], isMirror[" + this.Tt + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioa
 * JD-Core Version:    0.7.0.1
 */