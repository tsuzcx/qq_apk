package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class l
  extends JceStruct
{
  static ArrayList<t> b = new ArrayList();
  public ArrayList<t> a = null;
  
  static
  {
    t localt = new t();
    b.add(localt);
  }
  
  public final JceStruct newInit()
  {
    return new l();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(b, 0, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.l
 * JD-Core Version:    0.7.0.1
 */