import android.os.Bundle;

class aifi
  implements skj.a
{
  aifi(aifh paramaifh) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      aifh.a(this.a, paramBundle.getInt("state"));
      aifh.a(this.a, aifh.a(this.a), aifh.b(this.a));
    }
    while (i != 91) {
      return;
    }
    i = paramBundle.getInt("errCode");
    paramBundle = paramBundle.getString("desc");
    aifh.a(this.a, i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aifi
 * JD-Core Version:    0.7.0.1
 */