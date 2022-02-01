package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;

public final class Challenge
{
  private final String realm;
  private final String scheme;
  
  public Challenge(String paramString1, String paramString2)
  {
    this.scheme = paramString1;
    this.realm = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Challenge)) && (Util.equal(this.scheme, ((Challenge)paramObject).scheme)) && (Util.equal(this.realm, ((Challenge)paramObject).realm));
  }
  
  public String getRealm()
  {
    return this.realm;
  }
  
  public String getScheme()
  {
    return this.scheme;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.realm != null) {}
    for (int i = this.realm.hashCode();; i = 0)
    {
      if (this.scheme != null) {
        j = this.scheme.hashCode();
      }
      return (i + 899) * 31 + j;
    }
  }
  
  public String toString()
  {
    return this.scheme + " realm=\"" + this.realm + "\"";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.Challenge
 * JD-Core Version:    0.7.0.1
 */