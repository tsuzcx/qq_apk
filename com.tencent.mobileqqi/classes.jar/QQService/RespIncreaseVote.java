package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespIncreaseVote
  extends JceStruct
{
  static RespHead cache_stHeader;
  static ArrayList cache_vVoter;
  public int iVoteIncrement = 0;
  public int lTime = 0;
  public RespHead stHeader = null;
  public ArrayList vVoter = null;
  
  public RespIncreaseVote() {}
  
  public RespIncreaseVote(RespHead paramRespHead, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.stHeader = paramRespHead;
    this.iVoteIncrement = paramInt1;
    this.lTime = paramInt2;
    this.vVoter = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.iVoteIncrement = paramJceInputStream.read(this.iVoteIncrement, 1, true);
    this.lTime = paramJceInputStream.read(this.lTime, 2, true);
    if (cache_vVoter == null)
    {
      cache_vVoter = new ArrayList();
      Visitor localVisitor = new Visitor();
      cache_vVoter.add(localVisitor);
    }
    this.vVoter = ((ArrayList)paramJceInputStream.read(cache_vVoter, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.iVoteIncrement, 1);
    paramJceOutputStream.write(this.lTime, 2);
    if (this.vVoter != null) {
      paramJceOutputStream.write(this.vVoter, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespIncreaseVote
 * JD-Core Version:    0.7.0.1
 */