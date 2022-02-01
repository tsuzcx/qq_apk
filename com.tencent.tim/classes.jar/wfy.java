import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity.HiBoomTemplateView;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class wfy
  extends VasQuickUpdateManager.CallBacker
{
  public wfy(VipProfileCardDiyActivity.HiBoomTemplateView paramHiBoomTemplateView, VipProfileCardDiyActivity paramVipProfileCardDiyActivity) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if (VipProfileCardDiyActivity.b(paramLong, paramString1, this.c.mFontId))
    {
      if (paramInt1 != 0) {
        break label87;
      }
      this.c.bMP = 2;
      this.c.this$0.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager.removeCallBacker(this);
    }
    for (;;)
    {
      paramString1 = this.c.this$0.jdField_a_of_type_Auru.obtainMessage(5, paramInt1, 0);
      paramString1.obj = this.c.vR;
      this.c.this$0.jdField_a_of_type_Auru.sendMessage(paramString1);
      return;
      label87:
      this.c.bMP = 0;
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (VipProfileCardDiyActivity.b(paramLong1, paramString1, this.c.mFontId))
    {
      paramString1 = this.c.this$0.jdField_a_of_type_Auru.obtainMessage(4);
      paramString1.arg1 = ((int)(paramLong2 / paramLong3 * this.c.getHeight()));
      paramString1.obj = this.c.vR;
      this.c.this$0.jdField_a_of_type_Auru.sendMessage(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wfy
 * JD-Core Version:    0.7.0.1
 */