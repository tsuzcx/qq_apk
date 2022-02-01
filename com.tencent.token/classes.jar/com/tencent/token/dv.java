package com.tencent.token;

import android.util.Base64;
import java.util.List;

public final class dv
{
  final String a;
  final String b;
  final String c;
  final List<List<byte[]>> d;
  final int e;
  final String f;
  
  public dv(String paramString1, String paramString2, String paramString3, List<List<byte[]>> paramList)
  {
    this.a = ((String)ei.a(paramString1));
    this.b = ((String)ei.a(paramString2));
    this.c = ((String)ei.a(paramString3));
    this.d = ((List)ei.a(paramList));
    this.e = 0;
    paramString1 = new StringBuilder(this.a);
    paramString1.append("-");
    paramString1.append(this.b);
    paramString1.append("-");
    paramString1.append(this.c);
    this.f = paramString1.toString();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder("FontRequest {mProviderAuthority: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", mProviderPackage: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", mQuery: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mCertificates:");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    int i = 0;
    while (i < this.d.size())
    {
      localStringBuilder.append(" [");
      localObject = (List)this.d.get(i);
      int j = 0;
      while (j < ((List)localObject).size())
      {
        localStringBuilder.append(" \"");
        localStringBuilder.append(Base64.encodeToString((byte[])((List)localObject).get(j), 0));
        localStringBuilder.append("\"");
        j += 1;
      }
      localStringBuilder.append(" ]");
      i += 1;
    }
    localStringBuilder.append("}");
    localObject = new StringBuilder("mCertificatesArray: ");
    ((StringBuilder)localObject).append(this.e);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dv
 * JD-Core Version:    0.7.0.1
 */