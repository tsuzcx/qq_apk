package com.tencent.token.core.bean;

import com.tencent.token.aaz;
import com.tencent.token.ti;
import java.io.Serializable;
import java.util.ArrayList;

public class NewConfigureCacheItem
  implements Serializable
{
  private static final long serialVersionUID = 1072983214720279022L;
  public int mClickVersion = 0;
  public int mClientVersion = 0;
  public ArrayList<Integer> mConfIDs = new ArrayList();
  public String mConfKey;
  
  public NewConfigureCacheItem(String paramString)
  {
    this.mConfKey = paramString;
  }
  
  public final void a()
  {
    int i = this.mClickVersion;
    int j = this.mClientVersion;
    if (i == j) {
      return;
    }
    this.mClickVersion = j;
    ArrayList localArrayList = this.mConfIDs;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    ti.a().h.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.NewConfigureCacheItem
 * JD-Core Version:    0.7.0.1
 */