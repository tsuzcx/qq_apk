package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BoutiqueGameConfig
  extends JceStruct
{
  static ArrayList<String> cache_pkgList = new ArrayList();
  public ArrayList<String> pkgList = null;
  
  static
  {
    cache_pkgList.add("");
  }
  
  public BoutiqueGameConfig() {}
  
  public BoutiqueGameConfig(ArrayList<String> paramArrayList)
  {
    this.pkgList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pkgList = ((ArrayList)paramJceInputStream.read(cache_pkgList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.BoutiqueGameConfig
 * JD-Core Version:    0.7.0.1
 */