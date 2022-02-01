import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.tts.SilkStreamPlayer;
import com.tencent.mobileqq.tts.SilkStreamPlayer.a;
import com.tencent.mobileqq.widget.QQToast;
import mqq.manager.TicketManager;

public class apzp
  implements Handler.Callback
{
  private apzp.a jdField_a_of_type_Apzp$a;
  protected arhz a;
  private SilkStreamPlayer.a jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a;
  private SilkStreamPlayer jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer;
  private Context mCtx;
  private Handler mHandler;
  private TicketManager ticketManager;
  
  public apzp(AppInterface paramAppInterface, Context paramContext)
  {
    this.mCtx = paramContext;
    this.ticketManager = ((TicketManager)paramAppInterface.getManager(2));
    this.mHandler = new auru(this);
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a = new apzq(this);
  }
  
  private void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  private void showProgressDialog()
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.mCtx, this.mCtx.getResources().getDimensionPixelSize(2131299627));
    }
    if (!((Activity)this.mCtx).isFinishing()) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  public void a(apzp.a parama)
  {
    this.jdField_a_of_type_Apzp$a = parama;
  }
  
  public void bf(String paramString1, String paramString2, String paramString3)
  {
    if (!aqiw.isNetworkAvailable(this.mCtx)) {
      QQToast.a(this.mCtx, acfp.m(2131716189), 1).show();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer = new SilkStreamPlayer(this.mCtx, paramString1, paramString2, this.ticketManager.getSkey(paramString2));
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.a(this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.Uh(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.start();
    } while (this.jdField_a_of_type_Apzp$a == null);
    this.jdField_a_of_type_Apzp$a.onStart();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      showProgressDialog();
      continue;
      hideProgressDialog();
    }
  }
  
  public boolean isPlaying()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.isPlaying();
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.onDestroy();
    }
    this.jdField_a_of_type_Apzp$a = null;
    this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer$a = null;
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTtsSilkStreamPlayer.stop();
    }
    if (this.jdField_a_of_type_Apzp$a != null) {
      this.jdField_a_of_type_Apzp$a.onStop();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onStart();
    
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzp
 * JD-Core Version:    0.7.0.1
 */