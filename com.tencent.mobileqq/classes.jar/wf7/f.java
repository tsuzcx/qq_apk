package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    Object localObject = this.ak;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    paramJceOutputStream.write(this.al, 1);
    localObject = this.am;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.V;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.f
 * JD-Core Version:    0.7.0.1
 */