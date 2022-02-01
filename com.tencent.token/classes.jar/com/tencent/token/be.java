package com.tencent.token;

import java.util.HashMap;

public final class be<K, V>
  extends bf<K, V>
{
  public HashMap<K, bf.c<K, V>> a = new HashMap();
  
  protected final bf.c<K, V> a(K paramK)
  {
    return (bf.c)this.a.get(paramK);
  }
  
  public final V a(K paramK, V paramV)
  {
    bf.c localc = a(paramK);
    if (localc != null) {
      return localc.b;
    }
    this.a.put(paramK, b(paramK, paramV));
    return null;
  }
  
  public final V b(K paramK)
  {
    Object localObject = super.b(paramK);
    this.a.remove(paramK);
    return localObject;
  }
  
  public final boolean c(K paramK)
  {
    return this.a.containsKey(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.be
 * JD-Core Version:    0.7.0.1
 */