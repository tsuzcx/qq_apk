package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRspBindUin
  extends JceStruct
{
  static ArrayList cache_vecResult;
  public ArrayList vecResult = null;
  
  public SvcRspBindUin() {}
  
  public SvcRspBindUin(ArrayList paramArrayList)
  {
    this.vecResult = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResult == null)
    {
      cache_vecResult = new ArrayList();
      BindUinResult localBindUinResult = new BindUinResult();
      cache_vecResult.add(localBindUinResult);
    }
    this.vecResult = ((ArrayList)paramJceInputStream.read(cache_vecResult, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResult, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRspBindUin
 * JD-Core Version:    0.7.0.1
 */