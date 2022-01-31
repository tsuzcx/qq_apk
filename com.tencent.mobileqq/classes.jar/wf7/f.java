package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class f
  extends JceStruct
{
  static ArrayList<d> an = new ArrayList();
  static ArrayList<d> ao;
  public String V = "";
  public ArrayList<d> ak = null;
  public boolean al = true;
  public ArrayList<d> am = null;
  
  static
  {
    d locald = new d();
    an.add(locald);
    ao = new ArrayList();
    locald = new d();
    ao.add(locald);
  }
  
  public JceStruct newInit()
  {
    return new f();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ak = ((ArrayList)paramJceInputStream.read(an, 0, false));
    this.al = paramJceInputStream.read(this.al, 1, false);
    this.am = ((ArrayList)paramJceInputStream.read(ao, 2, false));
    this.V = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ak != null) {
      paramJceOutputStream.write(this.ak, 0);
    }
    paramJceOutputStream.write(this.al, 1);
    if (this.am != null) {
      paramJceOutputStream.write(this.am, 2);
    }
    if (this.V != null) {
      paramJceOutputStream.write(this.V, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.f
 * JD-Core Version:    0.7.0.1
 */