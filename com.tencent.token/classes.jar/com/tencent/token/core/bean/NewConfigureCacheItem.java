package com.tencent.token.core.bean;

import com.tencent.token.ba;
import com.tencent.token.fp;
import java.io.Serializable;
import java.util.ArrayList;

public class NewConfigureCacheItem
  implements Serializable
{
  private static final long serialVersionUID = 1072983214720279022L;
  public int mClickVersion = 0;
  public int mClientVersion = 0;
  public ArrayList mConfIDs = new ArrayList();
  public String mConfKey;
  
  public NewConfigureCacheItem(String paramString)
  {
    this.mConfKey = paramString;
  }
  
  public final void a()
  {
    if (this.mClickVersion == this.mClientVersion) {
      return;
    }
    this.mClickVersion = this.mClientVersion;
    if (this.mConfIDs != null) {
      this.mConfIDs.clear();
    }
    ba.a().h.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.NewConfigureCacheItem
 * JD-Core Version:    0.7.0.1
 */