import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class bmy
  extends BizTroopObserver
{
  public bmy(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 != 0L) {}
    this.a.jdField_a_of_type_Long = paramLong2;
    this.a.b = paramLong3;
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    this.a.k();
    if (!paramBoolean) {
      if (TextUtils.isEmpty(paramString)) {}
    }
    for (;;)
    {
      QQToast.a(this.a, paramString, 1).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
      switch ((int)paramLong)
      {
      default: 
        paramString = this.a.getString(2131363888);
        break;
      case 1281: 
        paramString = this.a.getString(2131362659);
        break;
      case 1282: 
        paramString = this.a.getString(2131362660);
        break;
      case 1283: 
        paramString = this.a.getString(2131362661);
        continue;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r == 3) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r == 2))
        {
          paramString = DialogUtil.a(this.a, 230);
          paramString.setTitle(null);
          paramString.setMessage(this.a.getString(2131362671));
          paramString.setPositiveButton(this.a.getString(2131362670), new bmz(this, paramString));
          paramString.setPositiveButtonContentDescription(this.a.getString(2131362670));
          paramString.show();
          return;
        }
        paramString = this.a.getString(2131363887);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bmy
 * JD-Core Version:    0.7.0.1
 */