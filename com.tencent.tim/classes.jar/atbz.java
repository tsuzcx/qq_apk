import android.text.TextUtils;

public class atbz
  extends atbo
{
  public atbi a()
  {
    Object localObject = this.a.EF();
    String str1 = this.a.getNickName();
    String str2 = this.a.ED();
    if (!TextUtils.isEmpty(str2)) {
      localObject = str2;
    }
    for (;;)
    {
      return new atbi((String)localObject, EG(), getSignature());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = str1;
      }
    }
  }
  
  public void aaj(int paramInt)
  {
    if (paramInt != 1001)
    {
      aab(0);
      aac(1);
      aad(2);
      aae(3);
      aaf(4);
      kN(17, 5);
      bQ(false, 6);
      bR(false, 7);
      bS(false, 8);
      bT(false, 9);
      kN(18, 10);
      bU(false, 11);
      bV(false, 12);
      bW(false, 13);
      aag(14);
      kN(19, 15);
      aah(16);
    }
  }
  
  public String rn(String paramString)
  {
    String str = this.a.ED();
    if (!TextUtils.isEmpty(str)) {}
    do
    {
      return str;
      str = paramString;
    } while (!TextUtils.isEmpty(paramString));
    return this.a.getNickName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbz
 * JD-Core Version:    0.7.0.1
 */