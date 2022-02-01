package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class FileBatchControlReq
  extends JceStruct
{
  static Map<String, FileControlReq> cache_control_req = new HashMap();
  public Map<String, FileControlReq> control_req = null;
  
  static
  {
    FileControlReq localFileControlReq = new FileControlReq();
    cache_control_req.put("", localFileControlReq);
  }
  
  public FileBatchControlReq() {}
  
  public FileBatchControlReq(Map<String, FileControlReq> paramMap)
  {
    this.control_req = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.control_req = ((Map)paramJceInputStream.read(cache_control_req, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.control_req, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SLICE_UPLOAD.FileBatchControlReq
 * JD-Core Version:    0.7.0.1
 */