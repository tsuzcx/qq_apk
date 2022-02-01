import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ApolloHelper.3;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class wuq
  implements wvs, wwf
{
  private long ID;
  private long IE;
  private aqju R;
  private BaseChatPie a;
  private QQAppInterface app;
  private Activity mActivity;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  public wuq(wvm paramwvm, BaseChatPie paramBaseChatPie)
  {
    this.app = paramBaseChatPie.app;
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.a = paramBaseChatPie;
    this.sessionInfo = paramBaseChatPie.sessionInfo;
    this.ID = aqgz.hK();
    this.IE = aqgz.hL();
    paramwvm.a(this);
  }
  
  private void doOnDestroy()
  {
    if ((this.R != null) && (this.R.isShowing())) {
      this.R.dismiss();
    }
  }
  
  public int[] C()
  {
    return new int[] { 13, 6, 18, 4 };
  }
  
  public void Ck(int paramInt)
  {
    int i = 1;
    long l;
    switch (paramInt)
    {
    default: 
      return;
    case 13: 
      doOnDestroy();
      return;
    case 6: 
      abyy.Df("aio_pre");
      return;
    case 18: 
      l = aqgz.i(true);
      if ((this.ID != l) && (this.ID != this.IE)) {
        QLog.d("ApolloHelper", 1, new Object[] { "[doOnConfigurationChanged] screenWidth:", Long.valueOf(l), ",mLastScreenWidth:", Long.valueOf(this.ID), ",mLastScreenHeight:", Long.valueOf(this.IE) });
      }
      break;
    }
    for (paramInt = i;; paramInt = 0)
    {
      this.ID = l;
      this.IE = aqgz.hL();
      if (paramInt == 0) {
        break;
      }
      abqt localabqt = abrj.a(this.app);
      if (localabqt != null) {
        localabqt.d(this.ID, this.IE, abrj.zO(), abrj.zN());
      }
      if ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.Dj(this.app.getCurrentAccountUin());
      return;
      abyy.clear();
      if (QLog.isColorLevel()) {
        QLog.i("ChatPieApolloViewController", 1, "START");
      }
      if (this.a == null) {
        break;
      }
      if (this.a.jdField_a_of_type_Abin == null) {
        this.a.jdField_a_of_type_Abin = new abin();
      }
      this.a.jdField_a_of_type_Abin.k(this.a);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
    {
      localObject = anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localObject != null) {}
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          String str = paramIntent.getStringExtra("uin");
          paramInt1 = paramIntent.getIntExtra("uintype", -1);
          paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
          aqmf.a(this.app, str, paramInt1, (AbsStructMsg)localObject, null);
          VipUtils.a(this.app, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.gi(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
          return;
          if (paramInt1 == 9999)
          {
            if (this.app != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, "isActionBack");
              }
              ((aqrb)this.app.getBusinessHandler(71)).ag(this.app.getCurrentAccountUin(), 128, "apolloPanel");
            }
          }
          else if (paramInt1 == 14003)
          {
            if (this.app != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, "check slave");
              }
              ((abhh)this.app.getManager(153)).a().b(null);
            }
          }
          else if (paramInt1 == 14004) {
            try
            {
              if (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
              {
                this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.cGE();
                return;
              }
            }
            catch (Throwable paramIntent)
            {
              QLog.e("ApolloHelper", 1, paramIntent, new Object[0]);
              return;
            }
          }
        }
      } while ((paramInt1 != 14006) && (paramInt1 != 14005));
      localObject = abmt.a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).runRenderTask(new ApolloHelper.3(this, (ApolloSurfaceView)localObject, paramInt1, paramInt2, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wuq
 * JD-Core Version:    0.7.0.1
 */