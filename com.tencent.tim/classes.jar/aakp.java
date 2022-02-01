import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper.1;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class aakp
{
  public static CopyOnWriteArrayList<aakp.a> D = new CopyOnWriteArrayList();
  private boolean aci;
  private MqqHandler b;
  protected int chs = 1008;
  private Runnable fb = new RecentPubAccHelper.1(this);
  private Activity mActivity;
  private arhz n;
  
  public aakp(MqqHandler paramMqqHandler, Activity paramActivity)
  {
    this.b = paramMqqHandler;
    this.mActivity = paramActivity;
    init();
  }
  
  private void Ga(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.mActivity, paramInt, 0).show();
  }
  
  private void a(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    aqiy.bk(null, " pubAcc_follow_cancel", paramRecentBaseData.qx());
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow->UIN: " + paramRecentBaseData.qx());
    }
    showProgressBar(true);
    Object localObject = (acja)paramQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((acja)localObject).a(paramRecentBaseData.qx());; localObject = null)
    {
      if ((localObject != null) && (ocp.getAccountType(((AccountDetail)localObject).accountFlag) == -4))
      {
        localObject = new NewIntent(this.mActivity, kbs.class);
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramRecentBaseData.qx()));
        localUnFollowRequest.account_type.set(getAccountType());
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new aakq(this, paramRecentBaseData, paramQQAppInterface));
        paramQQAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        ocp.n(paramQQAppInterface, paramRecentBaseData.qx());
        if (QLog.isColorLevel()) {
          QLog.d("RecentPubAccHelper", 2, "unfollow exit");
        }
        return;
        localObject = new adai(new aakr(this, paramRecentBaseData, paramQQAppInterface), paramQQAppInterface);
        paramQQAppInterface.removeObserver((acci)localObject);
        paramQQAppInterface.addObserver((acci)localObject);
        adam.a(paramQQAppInterface, false, paramRecentBaseData.qx(), 0);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 4;
    if (paramInt2 > 0) {
      switch (paramInt1)
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, new Object[] { "reportUserClickPubAccEnterAIO --pUin: " + paramString1 + ", pName: " + paramString2 + ", unReadNum: " + paramInt2, ", unReadFlag: " + i + ", from: " + paramInt3 });
      }
      anot.a(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A31", "0X8009A31", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --pUin: " + paramString1 + ", pName: " + paramString2 + ", time: " + paramLong);
    }
    anot.a(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A32", "0X8009A32", 0, 0, String.valueOf(paramLong), "", paramString2, "");
  }
  
  private void a(AccountDetail paramAccountDetail, QQAppInterface paramQQAppInterface)
  {
    if (paramAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "deleteAccount");
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.remove(paramAccountDetail);
    paramQQAppInterface.close();
  }
  
  private void aAt()
  {
    if ((this.n != null) && (this.n.isShowing())) {
      this.n.dismiss();
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new RecentPubAccHelper.4(this, paramQQAppInterface, paramRecentBaseData), 10L);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 4;
    if (paramInt2 > 0) {
      switch (paramInt1)
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, "reportUserDelPublicAcc --pUin: " + paramString1 + ", pName: " + paramString2 + ", unReadNum: " + paramInt2 + ", unReadFlag: " + i + ", from: " + paramInt3);
      }
      anot.a(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A33", "0X8009A33", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  public static void bJ(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --mPubAccEnterList.size: " + D.size());
    }
    if (D.size() > 0)
    {
      Iterator localIterator = D.iterator();
      while (localIterator.hasNext())
      {
        aakp.a locala = (aakp.a)localIterator.next();
        long l = System.currentTimeMillis() - locala.enterTime;
        if (l <= 3600000L) {
          a(paramQQAppInterface, locala.puin, l, locala.pName);
        }
      }
    }
    D.clear();
  }
  
  private void c(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = null;
    int i = -1;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      localRecentUser = localRecentUserBaseData.a();
      i = localRecentUserBaseData.mPosition;
    }
    if (localRecentUser != null)
    {
      aakz.a(paramQQAppInterface, paramRecentBaseData, localRecentUser);
      aalb.a(paramQQAppInterface, localRecentUser, i);
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserUnfollowPublicAcc --pUin: " + paramString1 + ", pName: " + paramString2);
    }
    anot.a(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A34", "0X8009A34", 0, 0, "", "", paramString2, "");
  }
  
  private int getAccountType()
  {
    return 1;
  }
  
  private int getTitleBarHeight()
  {
    return this.mActivity.getResources().getDimensionPixelSize(2131299627);
  }
  
  public static boolean iO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return false;
            localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          } while (localObject == null);
          localObject = (acja)((QQAppInterface)localObject).getManager(56);
        } while (localObject == null);
        localAccountDetail = ((acja)localObject).b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))) || ((localAccountDetail != null) && ("2173223560".equals(paramString))));
      if (((acja)localObject).c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void init() {}
  
  private void oh(int paramInt)
  {
    Toast.makeText(this.mActivity, paramInt, 0).show();
  }
  
  public void a(Activity paramActivity, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    ausj localausj = ausj.b(paramActivity);
    localausj.setMainTitle(String.format(paramActivity.getResources().getString(2131697482), new Object[] { paramRecentBaseData.mTitleName }));
    localausj.addButton(2131698678, 3);
    localausj.addCancelButton(2131721058);
    localausj.setOnDismissListener(new aaks(this));
    localausj.a(new aakt(this, paramQQAppInterface, paramRecentBaseData, localausj));
    if (!localausj.isShowing())
    {
      this.aci = false;
      localausj.show();
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    D.clear();
  }
  
  public void onDestroy()
  {
    if (this.n != null) {
      this.n.dismiss();
    }
    this.n = null;
    if (this.b != null) {
      this.b.removeCallbacks(this.fb);
    }
    D.clear();
  }
  
  public void showProgressBar(boolean paramBoolean)
  {
    if (this.n == null)
    {
      this.n = new arhz(this.mActivity, getTitleBarHeight());
      this.n.setMessage(2131697481);
      this.n.setCanceledOnTouchOutside(true);
    }
    if (this.n != null)
    {
      if ((!paramBoolean) || (this.n.isShowing())) {
        break label120;
      }
      this.n.show();
      this.b.postDelayed(this.fb, 1000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, "showProgressBar->show:" + paramBoolean);
      }
      return;
      label120:
      if ((!paramBoolean) && (this.n.isShowing())) {
        this.n.dismiss();
      }
    }
  }
  
  static class a
  {
    long enterTime;
    String pName;
    String puin;
    
    public a(String paramString1, String paramString2, long paramLong)
    {
      this.puin = paramString1;
      this.pName = paramString2;
      this.enterTime = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakp
 * JD-Core Version:    0.7.0.1
 */