import android.text.TextUtils;

public class atbv
  extends atbo
{
  public atbi a()
  {
    if (TextUtils.isEmpty(this.a.EF())) {}
    for (String str = this.a.getNickName();; str = this.a.EF()) {
      return new atbi(str, EG(), getSignature());
    }
  }
  
  public void aaj(int paramInt)
  {
    if (paramInt != 1001)
    {
      aac(0);
      aad(1);
      bQ(false, 2);
      bR(false, 3);
      bS(false, 4);
      bT(false, 5);
      kN(17, 6);
      bU(false, 7);
      bV(false, 8);
      bW(false, 9);
      aag(10);
      kN(18, 11);
      aah(12);
    }
  }
  
  public String rn(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.a.getNickName();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbv
 * JD-Core Version:    0.7.0.1
 */