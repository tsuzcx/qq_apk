import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.widget.QQToast;

public class wcr
  extends achq
{
  public wcr(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void L(boolean paramBoolean, String paramString)
  {
    this.this$0.aL(2130840113, this.this$0.getString(2131720219));
  }
  
  protected void M(boolean paramBoolean, String paramString)
  {
    this.this$0.aL(2130840113, this.this$0.getString(2131720204));
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l2 = anze.a().hf();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        this.this$0.ath();
        if (anzf.a(anze.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4)) {
          this.this$0.finish();
        }
        return;
      }
      this.this$0.ath();
      this.this$0.finish();
      anzf.a(anze.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  protected void iv(String paramString)
  {
    this.this$0.ath();
    paramString = this.this$0.getString(2131720702);
    QQToast.a(this.this$0, 1, paramString, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcr
 * JD-Core Version:    0.7.0.1
 */