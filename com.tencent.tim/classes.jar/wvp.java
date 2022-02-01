import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class wvp
  implements wvs
{
  private BaseChatPie a;
  
  wvp(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public int[] C()
  {
    return new int[] { 9, 6 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 9: 
    case 6: 
      for (;;)
      {
        return;
        ((AvatarPendantManager)this.a.app.getManager(46)).clear();
        yfy.fC(this.a.cL);
        return;
        if (!xla.bhy) {}
        try
        {
          System.loadLibrary("sonic");
          xla.bhy = true;
          label81:
          aqjh.SE(xla.bhy);
          aqjh.eA(this.a.app);
          xla.bhD = this.a.app.getApp().getSharedPreferences("check_update_sp_key", 0).getBoolean("businessinfo_ptt_slice_to_text_" + this.a.app.getCurrentAccountUin(), false);
          localaemd = (aemd)aeif.a().o(442);
        }
        catch (Throwable localThrowable)
        {
          try
          {
            aemd localaemd;
            if (!xla.bhA) {
              if ((int)(Long.valueOf(this.a.app.getCurrentAccountUin()).longValue() / 1000L % 1000L) <= localaemd.Cq()) {
                break label303;
              }
            }
            label303:
            for (xla.bhB = true; QLog.isColorLevel(); xla.bhB = false)
            {
              QLog.d("PttAutoChange", 2, "pttAutoChangeTxt =" + xla.bhz + " hasAddGrayTip =" + xla.bhA + " grayTipPerThousandStatus=" + xla.bhB);
              return;
              localThrowable = localThrowable;
              if (QLog.isColorLevel()) {
                QLog.d("sonic", 2, "load error:" + localThrowable.toString());
              }
              xla.bhy = false;
              break label81;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PttAutoChange", 2, "error=" + localException.toString());
              }
            }
          }
        }
      }
    }
    ShortVideoItemBuilder.cec();
    ShortVideoRealItemBuilder.cec();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvp
 * JD-Core Version:    0.7.0.1
 */