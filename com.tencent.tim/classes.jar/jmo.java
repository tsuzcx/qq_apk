import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.biz.JoinGroupHandler.2;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;

public class jmo
{
  protected String Th;
  protected acnd a;
  protected jmo.a a;
  protected int aBI;
  protected Runnable cq = new JoinGroupHandler.2(this);
  public arhz g;
  protected QQAppInterface mApp;
  protected Context mContext;
  protected long qp;
  protected long qr;
  
  public jmo(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, jmo.a parama)
  {
    this.jdField_a_of_type_Acnd = new jmq(this);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.aBI = paramInt;
    this.Th = paramString;
    this.jdField_a_of_type_Jmo$a = parama;
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.mContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.aBI, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.Th, null);
      this.mContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_Jmo$a.success();
      return;
    }
    cf(2131721390, 1);
    this.jdField_a_of_type_Jmo$a.error();
  }
  
  private void atg()
  {
    try
    {
      if (this.g == null)
      {
        this.g = new arhz(this.mContext, this.mContext.getResources().getDimensionPixelSize(2131299627));
        this.g.setMessage(2131696693);
        this.g.setBackAndSearchFilter(false);
        this.g.setOnDismissListener(new jmp(this));
      }
      this.g.show();
      this.qr = System.currentTimeMillis();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void cf(int paramInt1, int paramInt2)
  {
    new arie(this.mContext).V(paramInt1, this.mContext.getResources().getDimensionPixelSize(2131299627), 0, paramInt2);
  }
  
  private void ef(long paramLong)
  {
    try
    {
      acms localacms = (acms)this.mApp.getBusinessHandler(20);
      this.qp = paramLong;
      localacms.aA(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      cf(2131720702, 0);
      this.jdField_a_of_type_Jmo$a.error();
    }
  }
  
  private void lp(boolean paramBoolean)
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing()))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.qr;
        if ((!paramBoolean) && (l1 - l2 < 1000L))
        {
          ThreadManager.getUIHandlerV2().postDelayed(this.cq, 500L);
          return;
        }
        this.g.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onCreate()
  {
    this.mApp.addObserver(this.jdField_a_of_type_Acnd);
  }
  
  public void onDestory()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_Acnd);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.cq);
    lp(true);
  }
  
  public void start(long paramLong)
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      cf(2131696270, 0);
      this.jdField_a_of_type_Jmo$a.error();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_Jmo$a.error();
      return;
    }
    this.qp = paramLong;
    atg();
    ef(paramLong);
  }
  
  public static abstract interface a
  {
    public abstract void ayk();
    
    public abstract void error();
    
    public abstract void success();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmo
 * JD-Core Version:    0.7.0.1
 */