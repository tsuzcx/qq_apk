import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;

class aipf
  implements aiod
{
  aipf(aipd paramaipd) {}
  
  public void Lk(boolean paramBoolean)
  {
    int i = this.this$0.a.des;
    String str3 = this.this$0.a.bPp;
    this.this$0.df(i, str3);
    ListenTogetherManager.a(this.this$0.app).r(i, str3, paramBoolean);
    if ((i == 2) && (!TextUtils.isEmpty(str3))) {
      anot.a(null, "dc00899", "c2c_AIO", "", "music_tab", "close_tab", 0, 0, str3, "", "", "");
    }
    while ((i != 1) || (TextUtils.isEmpty(str3))) {
      return;
    }
    String str2 = "2";
    TroopInfo localTroopInfo = ((TroopManager)this.this$0.app.getManager(52)).b(str3);
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.this$0.app.getCurrentUin())) {
        break label180;
      }
      str1 = "0";
    }
    for (;;)
    {
      anot.a(null, "dc00899", "Grp_AIO", "", "music_tab", "close_tab", 0, 0, str3, "", str1, "");
      return;
      label180:
      str1 = str2;
      if (localTroopInfo.isAdmin()) {
        str1 = "1";
      }
    }
  }
  
  public void onCancel() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipf
 * JD-Core Version:    0.7.0.1
 */