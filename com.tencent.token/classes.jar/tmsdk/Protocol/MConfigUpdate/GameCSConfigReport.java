package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GameCSConfigReport
  extends JceStruct
{
  static ArrayList<GameConfigReport> by = new ArrayList();
  public ArrayList<GameConfigReport> vecReport = null;
  
  static
  {
    GameConfigReport localGameConfigReport = new GameConfigReport();
    by.add(localGameConfigReport);
  }
  
  public JceStruct newInit()
  {
    return new GameCSConfigReport();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecReport = ((ArrayList)paramJceInputStream.read(by, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReport, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.GameCSConfigReport
 * JD-Core Version:    0.7.0.1
 */