import android.view.View;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

class apcf
  implements ausj.a
{
  apcf(apca paramapca, boolean paramBoolean, apbr paramapbr, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.cPS) {
      i = paramInt + 1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.val$sheet.dismiss();
      return;
      TroopFileTransferManager.a(this.this$0.mApp, this.this$0.mTroopUin).c(this.c.Id);
      anot.a(this.this$0.mApp, "CliOper", "", "", "Grp", "Clk_delete_local", 0, 0, "", this.this$0.mTroopUin + "", "", "");
      continue;
      if (apca.a(this.this$0) != 0)
      {
        apsf.a(this.this$0.mApp, this.this$0.mTroopUin).g(this.c);
        anot.a(this.this$0.mApp, "CliOper", "", "", "Grp", "Clk_delete_share", 0, 0, "", this.this$0.mTroopUin + "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apcf
 * JD-Core Version:    0.7.0.1
 */