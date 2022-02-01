import android.content.Intent;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import java.util.ArrayList;

public class weq
  extends acnd
{
  public weq(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((!aqft.equalsWithNullCheck(String.valueOf(paramLong), this.this$0.mTroopUin)) || (!aqft.equalsWithNullCheck(paramString1, this.this$0.app.getCurrentAccountUin()))) {
      return;
    }
    this.this$0.bbR = false;
    if (paramBoolean)
    {
      if (this.this$0.a != null) {
        this.this$0.a.dismiss();
      }
      paramString1 = (TroopManager)this.this$0.app.getManager(52);
      paramString3 = paramString1.b(paramLong + "");
      if (paramString3 != null)
      {
        paramString3.dwAdditionalFlag = 0L;
        paramString1.i(paramString3);
      }
      paramString1 = new Intent();
      paramString1.putExtra("isNeedFinish", true);
      paramString1.putExtra("fin_tip_msg", this.this$0.getString(2131721336));
      paramString1.putExtra("uin", paramString2);
      this.this$0.setResult(-1, paramString1);
      this.this$0.finish();
      return;
    }
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
      paramString1 = this.this$0.getString(2131721322);
    }
    for (;;)
    {
      if (this.this$0.a == null) {
        this.this$0.a = new arib(this.this$0);
      }
      this.this$0.a.aa(2, paramString1, 1500);
      return;
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 7) || (paramInt == 16) || (paramInt == 19))
      {
        paramString1 = this.this$0.getString(2131721324);
      }
      else if ((paramInt == 5) || (paramInt == 17) || (paramInt == 18))
      {
        paramString1 = this.this$0.getString(2131721323);
      }
      else
      {
        if (paramInt == 12)
        {
          if (this.this$0.a != null) {
            this.this$0.a.dismiss();
          }
          paramString1 = aqha.a(this.this$0, 230);
          paramString1.setTitle(this.this$0.getString(2131698449));
          paramString1.setMessage(this.this$0.getString(2131698450));
          paramString1.setNegativeButton(this.this$0.getString(2131698394), new wer(this, paramString1));
          paramString1.setPositiveButton(this.this$0.getString(2131720227), new wes(this, paramString1));
          paramString1.show();
          return;
        }
        paramString1 = this.this$0.getString(2131721323);
      }
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.this$0.cU(paramArrayList);
    }
  }
  
  protected void c(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.this$0.cU(paramArrayList);
    }
  }
  
  protected void e(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.this$0.cU(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     weq
 * JD-Core Version:    0.7.0.1
 */