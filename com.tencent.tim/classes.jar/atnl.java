import android.content.Intent;

class atnl
  extends acfd
{
  atnl(atnk paramatnk) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = aqgv.c(atnk.a(this.a), paramString, false);
      if ((str != null) && (!str.equalsIgnoreCase(paramString)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("_uin_", paramString);
        localIntent.putExtra("_nick_", str);
        atni.K(4, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnl
 * JD-Core Version:    0.7.0.1
 */