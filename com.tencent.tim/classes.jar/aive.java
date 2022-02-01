import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

class aive
  implements arle
{
  aqju ay;
  boolean clU = false;
  
  aive(aivd paramaivd, BaseActivity paramBaseActivity, LocationRoom.b paramb) {}
  
  public boolean MM()
  {
    if ((this.this$0.app.isBackground_Pause) || (this.this$0.app.isBackground_Stop)) {
      aivd.a(this.this$0, this.val$activity, this.c);
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
      return true;
      if (!this.clU)
      {
        this.ay = airk.a(this.c.getSessionType(), this.c.xc());
        this.clU = true;
        if (this.ay != null) {
          this.ay.setOnDismissListener(new aivf(this));
        }
      }
    }
  }
  
  public boolean ap(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    LocationShareFragment.c(this.val$activity, this.c.getSessionType(), this.c.xc(), 4);
    aiur.duH();
    if (this.ay != null) {}
    try
    {
      this.ay.dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aive
 * JD-Core Version:    0.7.0.1
 */