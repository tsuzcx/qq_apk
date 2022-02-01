import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;

public class ahda
{
  public static final int[] lq = { 1, 5 };
  protected QFileSendBottomView a;
  protected Bundle be;
  protected boolean cgf;
  protected QQAppInterface mApp;
  protected Context mContext;
  
  public ahda(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.a = paramQFileSendBottomView;
  }
  
  public static ahda a(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView, Bundle paramBundle)
  {
    int i = paramBundle.getInt("qfile_search_param_exparams_busi_type");
    paramBundle.getInt("qfile_search_param_exparams_peer_type");
    if (i == 1) {
      paramQQAppInterface = new agxr(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    }
    for (;;)
    {
      paramQQAppInterface.cD(paramBundle);
      return paramQQAppInterface;
      if (i == 5) {
        paramQQAppInterface = new agxo(paramQQAppInterface, paramContext, paramQFileSendBottomView);
      } else {
        paramQQAppInterface = new ahdb(paramQQAppInterface, paramContext, paramQFileSendBottomView);
      }
    }
  }
  
  protected void J(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
    {
      paramIntent.putExtra("qfile_send_bottom_bar_finish_result_code", -1);
      Activity localActivity = (Activity)this.mContext;
      localActivity.setResult(paramInt, paramIntent);
      localActivity.finish();
      return;
    }
  }
  
  public void cD(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.be = paramBundle;
      this.cgf = true;
      return;
    }
    this.cgf = false;
  }
  
  public void dko() {}
  
  public void dmz() {}
  
  protected void ds(Intent paramIntent)
  {
    J(-1, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahda
 * JD-Core Version:    0.7.0.1
 */