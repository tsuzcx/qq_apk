package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_audio
  extends JceStruct
{
  static ArrayList<s_audio> cache_audio = new ArrayList();
  public ArrayList<s_audio> audio;
  
  static
  {
    s_audio locals_audio = new s_audio();
    cache_audio.add(locals_audio);
  }
  
  public cell_audio() {}
  
  public cell_audio(ArrayList<s_audio> paramArrayList)
  {
    this.audio = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.audio = ((ArrayList)paramJceInputStream.read(cache_audio, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.audio != null) {
      paramJceOutputStream.write(this.audio, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_audio
 * JD-Core Version:    0.7.0.1
 */