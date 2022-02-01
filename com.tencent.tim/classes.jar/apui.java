import android.text.TextUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

final class apui
  implements apzg.a
{
  apui(TroopInfoData paramTroopInfoData) {}
  
  public void cc(int paramInt, boolean paramBoolean)
  {
    String str1;
    if (this.c.isMember)
    {
      str1 = "";
      switch (paramInt)
      {
      }
    }
    while (TextUtils.isEmpty(str1))
    {
      return;
      str1 = "share_circle";
      continue;
      str1 = "share_qq";
      continue;
      str1 = "share_qzone";
      continue;
      str1 = "share_wechat";
    }
    String str3 = this.c.troopUin;
    String str4 = aqfr.a(this.c);
    if (paramBoolean) {}
    for (String str2 = "0";; str2 = "1")
    {
      aqfr.b("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, str4, str2 });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apui
 * JD-Core Version:    0.7.0.1
 */