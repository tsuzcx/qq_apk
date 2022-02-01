package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SCPullConchs
  extends JceStruct
{
  static ArrayList<ConchTask> cache_conchTaskList = new ArrayList();
  public ArrayList<ConchTask> conchTaskList;
  public int result;
  
  static
  {
    ConchTask localConchTask = new ConchTask();
    cache_conchTaskList.add(localConchTask);
  }
  
  public JceStruct newInit()
  {
    return new SCPullConchs();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, false);
    this.conchTaskList = ((ArrayList)paramJceInputStream.read(cache_conchTaskList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.result != 0) {
      paramJceOutputStream.write(this.result, 0);
    }
    if (this.conchTaskList != null) {
      paramJceOutputStream.write(this.conchTaskList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MConch.SCPullConchs
 * JD-Core Version:    0.7.0.1
 */