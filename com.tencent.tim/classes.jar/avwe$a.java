import android.text.TextUtils;

public class avwe$a
{
  public a a;
  public long aAA;
  public final String cOh;
  public final String cOi;
  public final String cOj;
  public final String cOk;
  public final int eyS;
  public final String mMD5;
  public final String mModuleId;
  public final String mUrl;
  public final String mVersion;
  
  public avwe$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong, a parama)
  {
    this.mModuleId = paramString1;
    this.mVersion = paramString2;
    this.cOh = paramString3;
    this.cOj = paramString3;
    this.mUrl = paramString4;
    this.mMD5 = paramString5;
    this.cOi = paramString6;
    this.a = parama;
    this.cOk = paramString7;
    this.eyS = paramInt;
    this.aAA = paramLong;
  }
  
  private static boolean b(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 != null)
    {
      if ((paramObject2 == null) && ((paramObject1 instanceof String)) && (TextUtils.isEmpty((String)paramObject1))) {
        return true;
      }
      return paramObject1.equals(paramObject2);
    }
    return ((paramObject2 instanceof String)) && (TextUtils.isEmpty((String)paramObject2));
  }
  
  public boolean aLL()
  {
    return (this.a != null) && ((!b(this.mVersion, this.a.mVersion)) || (!b(this.cOh, this.a.cOh)) || (!b(this.mUrl, this.a.mUrl)) || (!b(this.mMD5, this.a.mMD5)) || (!b(this.cOi, this.a.cOi)) || (!b(this.cOj, this.a.cOj)) || (!b(this.cOk, this.a.cOk)) || (this.eyS != this.a.eyS));
  }
  
  public a b()
  {
    a locala = this;
    if (this.a != null) {
      locala = this.a;
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avwe.a
 * JD-Core Version:    0.7.0.1
 */