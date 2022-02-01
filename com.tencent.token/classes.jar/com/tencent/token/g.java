package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class g
  extends JceStruct
{
  static ArrayList<f> b = new ArrayList();
  public ArrayList<f> a = null;
  
  static
  {
    f localf = new f();
    b.add(localf);
  }
  
  public final JceStruct newInit()
  {
    return new g();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(b, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.g
 * JD-Core Version:    0.7.0.1
 */