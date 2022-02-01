package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class aqi
  extends JceStruct
{
  static ArrayList<aqj> c = new ArrayList();
  public ArrayList<aqj> a = null;
  public int b = 0;
  
  static
  {
    aqj localaqj = new aqj();
    c.add(localaqj);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(c, 0, true));
    this.b = paramJceInputStream.read(this.b, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    int i = this.b;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqi
 * JD-Core Version:    0.7.0.1
 */