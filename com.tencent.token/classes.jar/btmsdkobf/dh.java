package btmsdkobf;

class dh
  implements Runnable
{
  dh(be parambe, String paramString, int paramInt, ec paramec, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.length() <= 0)) {}
    String str2;
    StringBuilder localStringBuilder;
    do
    {
      return;
      str2 = be.d(this.b);
      String str1 = this.c.getString(str2, null);
      if ((str1 == null) || (this.d)) {
        str1 = "";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("|");
      localStringBuilder.append(this.a);
      localStringBuilder.append("$");
    } while (localStringBuilder.length() > 16384);
    this.c.putString(str2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dh
 * JD-Core Version:    0.7.0.1
 */