package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniLoginCheckRsp
  extends JceStruct
{
  static ArrayList<HamletCheck> cache_stHamletList = new ArrayList();
  static GetUsrKeyWordInfoRsp cache_stKeyWord = new GetUsrKeyWordInfoRsp();
  public String errmsg = "";
  public int ret;
  public ArrayList<HamletCheck> stHamletList;
  public GetUsrKeyWordInfoRsp stKeyWord;
  
  static
  {
    HamletCheck localHamletCheck = new HamletCheck();
    cache_stHamletList.add(localHamletCheck);
  }
  
  public UniLoginCheckRsp() {}
  
  public UniLoginCheckRsp(int paramInt, String paramString, ArrayList<HamletCheck> paramArrayList, GetUsrKeyWordInfoRsp paramGetUsrKeyWordInfoRsp)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.stHamletList = paramArrayList;
    this.stKeyWord = paramGetUsrKeyWordInfoRsp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.stHamletList = ((ArrayList)paramJceInputStream.read(cache_stHamletList, 2, false));
    this.stKeyWord = ((GetUsrKeyWordInfoRsp)paramJceInputStream.read(cache_stKeyWord, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.stHamletList != null) {
      paramJceOutputStream.write(this.stHamletList, 2);
    }
    if (this.stKeyWord != null) {
      paramJceOutputStream.write(this.stKeyWord, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.UniLoginCheckRsp
 * JD-Core Version:    0.7.0.1
 */