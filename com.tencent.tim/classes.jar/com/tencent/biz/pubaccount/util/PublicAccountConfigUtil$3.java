package com.tencent.biz.pubaccount.util;

import com.tencent.commonsdk.cache.QQHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import obt;
import obt.a;

public final class PublicAccountConfigUtil$3
  extends QQHashMap<Integer, obt.a>
{
  public PublicAccountConfigUtil$3(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void clearMemory()
  {
    clear();
    obt.access$000().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.3
 * JD-Core Version:    0.7.0.1
 */