import android.os.Bundle;

public class aqdq
{
  public long Tb;
  public Bundle br;
  public String csq;
  public int iType;
  public Object obj;
  public String strKey;
  
  public aqdq() {}
  
  public aqdq(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    this.iType = paramInt;
    this.strKey = paramString1;
    this.csq = paramString2;
    this.obj = paramObject;
    this.br = paramBundle;
  }
  
  public boolean aBW()
  {
    if ((this.iType < 1) || (this.iType > 4)) {}
    while ((this.strKey == null) || ("".equals(this.strKey.trim())) || ((this.iType == 3) && ((this.csq == null) || ("".equals(this.csq))) && ((this.obj == null) || ("".equals(this.obj))))) {
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof aqdq))
    {
      paramObject = (aqdq)paramObject;
      if ((paramObject.iType == this.iType) && (aqft.equalsWithNullCheck(this.strKey, paramObject.strKey)) && ((3 != this.iType) || ((aqft.equalsWithNullCheck(this.csq, paramObject.csq)) && (aqft.equalsWithNullCheck(this.obj, paramObject.obj)) && (aqft.equalsWithNullCheck(this.br, paramObject.br))))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.iType;
    int i;
    int j;
    label27:
    int k;
    if (this.strKey == null)
    {
      i = 0;
      if (this.csq != null) {
        break label66;
      }
      j = 0;
      if (this.obj != null) {
        break label77;
      }
      k = 0;
      label36:
      if (this.br != null) {
        break label88;
      }
    }
    for (;;)
    {
      return k + (n + i + j) + m;
      i = this.strKey.hashCode();
      break;
      label66:
      j = this.csq.hashCode();
      break label27;
      label77:
      k = this.obj.hashCode();
      break label36;
      label88:
      m = this.br.hashCode();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[iType = ").append(this.iType).append(", strKey = ").append(this.strKey).append(", strSubKey = ").append(this.csq).append(", obj = ").append(this.obj).append(", extraUpdateTargetParams = ").append(this.br).append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdq
 * JD-Core Version:    0.7.0.1
 */