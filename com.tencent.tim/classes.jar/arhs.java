import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileViewOnClickListener.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class arhs
  implements View.OnClickListener
{
  private final WeakReference<ProfileCardMoreInfoView> mRef;
  
  public arhs(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this.mRef = new WeakReference(paramProfileCardMoreInfoView);
  }
  
  public void eiB()
  {
    Object localObject = (ProfileCardMoreInfoView)this.mRef.get();
    if (localObject == null) {}
    BaseActivity localBaseActivity;
    QQAppInterface localQQAppInterface;
    alcn localalcn;
    do
    {
      return;
      localBaseActivity = ((ProfileCardMoreInfoView)localObject).mActivity;
      localQQAppInterface = ((ProfileCardMoreInfoView)localObject).app;
      localalcn = ((ProfileCardMoreInfoView)localObject).a;
    } while ((localBaseActivity == null) || (localQQAppInterface == null) || (localalcn == null));
    Intent localIntent = new Intent(localBaseActivity, QQBrowserActivity.class);
    boolean bool;
    label80:
    int j;
    int i;
    if (localalcn.e.pa == 0)
    {
      bool = true;
      if (bool) {
        break label206;
      }
      localObject = localalcn.e.uin;
      j = 2;
      i = MedalWallMng.dhq;
    }
    for (;;)
    {
      localIntent.putExtra("url", ((MedalWallMng)localQQAppInterface.getManager(250)).b(bool, (String)localObject, i));
      localBaseActivity.startActivityForResult(localIntent, 1027);
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800738D", "0X800738D", j, 0, "", "", "", "");
      if (!bool) {
        break;
      }
      localalcn.d.iNewCount = 0;
      localalcn.d.iUpgradeCount = 0;
      ThreadManager.excute(new ProfileViewOnClickListener.1(this, localQQAppInterface), 16, null, true);
      return;
      bool = false;
      break label80;
      label206:
      localObject = localQQAppInterface.getCurrentAccountUin();
      j = ((akjp)localQQAppInterface.getManager(160)).GR();
      i = MedalWallMng.dhp;
      if (localalcn.d.iNewCount > 0)
      {
        j = 4;
        i = MedalWallMng.dhr;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    Object localObject1 = (ProfileCardMoreInfoView)this.mRef.get();
    if (localObject1 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseActivity localBaseActivity = ((ProfileCardMoreInfoView)localObject1).mActivity;
      QQAppInterface localQQAppInterface = ((ProfileCardMoreInfoView)localObject1).app;
      localObject1 = ((ProfileCardMoreInfoView)localObject1).a;
      if ((localBaseActivity == null) || (localQQAppInterface == null) || (localObject1 != null))
      {
        Object localObject2 = paramView.getTag();
        if ((localObject2 instanceof albb)) {
          switch (((albb)localObject2).nType)
          {
          default: 
            break;
          case 66: 
            aqep.a((alcn)localObject1, localQQAppInterface, localBaseActivity);
            int i = j;
            if (((alcn)localObject1).e != null)
            {
              i = j;
              if (((alcn)localObject1).e.pa == 0) {
                i = 1;
              }
            }
            anot.a(localQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
            break;
          case 91: 
            eiB();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhs
 * JD-Core Version:    0.7.0.1
 */