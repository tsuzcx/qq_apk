import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class alis
{
  long agI;
  QQAppInterface app;
  int duE = 0;
  int[] mH = new int[2];
  int[] mI = new int[2];
  long refreshDuration;
  
  public alis(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong)
  {
    this.mI[0] = paramInt1;
    this.mI[1] = paramInt2;
    this.refreshDuration = paramLong;
    this.app = paramQQAppInterface;
    dGl();
  }
  
  private void dGl()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + this.app.getCurrentUin(), 0);
    this.mH[0] = localSharedPreferences.getInt("avaliableflowxg", this.mI[0]);
    this.mH[1] = localSharedPreferences.getInt("avaliableflowifi", this.mI[1]);
    this.agI = localSharedPreferences.getLong("lastdaymillion", 0L);
    if (QLog.isDevelopLevel()) {
      QLog.d("PttPreSendManager", 4, "PttPreFlowController.loadCfg, lastDayMillion " + this.agI);
    }
  }
  
  public void N(boolean paramBoolean, long paramLong)
  {
    int i;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i = 1;
      arrayOfInt = this.mH;
      arrayOfInt[i] = ((int)(arrayOfInt[i] + paramLong));
      arrayOfInt = this.mH;
      if (this.mH[i] <= this.mI[i]) {
        break label128;
      }
    }
    label128:
    for (int j = this.mI[i];; j = this.mH[i])
    {
      arrayOfInt[i] = j;
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "doOnRealSend : guess hit, give back  " + paramLong + ", avaliableFlow " + this.mH[i] + ", iswifi " + paramBoolean);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public boolean bg(boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label249;
      }
      j = 10000;
      label14:
      long l = System.currentTimeMillis();
      if ((this.agI <= 0L) || (l <= this.agI) || (l - this.agI >= this.refreshDuration))
      {
        this.mH[0] = this.mI[0];
        this.mH[1] = this.mI[1];
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "check flow : refresh flow avalia， limitation xg: " + this.mI[0] + ", wifi: " + this.mI[1]);
        }
        this.agI = l;
        BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + this.app.getCurrentUin(), 0).edit().putLong("lastdaymillion", this.agI).commit();
      }
      if (this.mH[i] < j) {
        break label256;
      }
    }
    label256:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PttPreSendManager", 2, "check flow : support ? " + bool + " iswifi : " + paramBoolean);
      }
      return bool;
      i = 0;
      break;
      label249:
      j = 4000;
      break label14;
    }
  }
  
  public boolean c(boolean paramBoolean, long paramLong)
  {
    boolean bool = true;
    int i;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i = 1;
      arrayOfInt = this.mH;
      arrayOfInt[i] = ((int)(arrayOfInt[i] - paramLong));
      if (this.mH[i] < 0) {
        break label143;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "flow consume result : " + bool + " flow " + paramLong + ", avaliableFlow " + this.mH[i] + ", iswifi " + paramBoolean);
      }
      i = this.duE + 1;
      this.duE = i;
      if (i >= 3)
      {
        dGm();
        this.duE = 0;
      }
      return bool;
      i = 0;
      break;
      label143:
      arrayOfInt = this.mH;
      arrayOfInt[i] = ((int)(arrayOfInt[i] + paramLong));
      bool = false;
    }
  }
  
  public void dGm()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + this.app.getCurrentUin(), 0).edit().putInt("avaliableflowxg", this.mH[0]).putInt("avaliableflowifi", this.mH[1]).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alis
 * JD-Core Version:    0.7.0.1
 */