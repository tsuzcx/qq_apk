package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class StateByPass
  extends JceStruct
{
  static stRishState cache_oRishState;
  public stRishState oRishState;
  
  public StateByPass() {}
  
  public StateByPass(stRishState paramstRishState)
  {
    this.oRishState = paramstRishState;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oRishState == null) {
      cache_oRishState = new stRishState();
    }
    this.oRishState = ((stRishState)paramJceInputStream.read(cache_oRishState, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oRishState, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     PersonalState.StateByPass
 * JD-Core Version:    0.7.0.1
 */