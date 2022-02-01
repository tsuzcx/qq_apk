package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MarkUinInfoBeforeUpload
  extends JceStruct
{
  static ArrayList<MarkUinInPhoto> cache_marks = new ArrayList();
  public ArrayList<MarkUinInPhoto> marks = null;
  
  static
  {
    MarkUinInPhoto localMarkUinInPhoto = new MarkUinInPhoto();
    cache_marks.add(localMarkUinInPhoto);
  }
  
  public MarkUinInfoBeforeUpload() {}
  
  public MarkUinInfoBeforeUpload(ArrayList<MarkUinInPhoto> paramArrayList)
  {
    this.marks = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.marks = ((ArrayList)paramJceInputStream.read(cache_marks, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.marks != null) {
      paramJceOutputStream.write(this.marks, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     FileUpload.MarkUinInfoBeforeUpload
 * JD-Core Version:    0.7.0.1
 */