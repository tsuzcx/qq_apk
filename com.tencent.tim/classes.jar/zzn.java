import Wallet.PfaFriend;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.TopayManager.1;
import com.tencent.mobileqq.activity.qwallet.TopayManager.2;
import com.tencent.mobileqq.activity.qwallet.TopayManager.5;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class zzn
{
  public static int EP;
  public static PfaFriendRsp a;
  protected static ackf a;
  public static int bGQ;
  public static String bbQ;
  public static String bbR;
  public static int cfI = -1;
  public static WeakReference<zzn.a> eK;
  protected static WeakReference<QWalletPayProgressDialog> eL;
  public static Handler mHandler;
  
  static
  {
    bbQ = "recommend";
    bbR = "tips";
    mHandler = new zzo(Looper.myLooper());
    jdField_a_of_type_Ackf = new ackf(mHandler);
  }
  
  protected static void BZ(boolean paramBoolean)
  {
    if (eK != null)
    {
      zzn.a locala = (zzn.a)eK.get();
      if (locala != null) {
        locala.xh(paramBoolean);
      }
    }
  }
  
  public static HashMap<String, Object> a(zzn.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    eK = new WeakReference(parama);
    if ((paramInt1 != EP) || (paramInt2 != bGQ))
    {
      jdField_a_of_type_WalletPfaFriendRsp = null;
      cfI = -1;
      EP = paramInt1;
      bGQ = paramInt2;
    }
    parama = new HashMap();
    if (jdField_a_of_type_WalletPfaFriendRsp == null)
    {
      parama.put(bbQ, cc());
      if (cfI == -1)
      {
        cfI = 1;
        ThreadManager.getFileThreadHandler().post(new TopayManager.1(paramInt1, paramInt2, paramBoolean));
        return parama;
      }
    }
    else
    {
      if (jdField_a_of_type_WalletPfaFriendRsp.use_default != 1) {
        break label142;
      }
      parama.put(bbQ, cc());
    }
    for (;;)
    {
      parama.put(bbR, jdField_a_of_type_WalletPfaFriendRsp.vecPfaMsg);
      if (!paramBoolean) {
        break;
      }
      gk(paramInt1, paramInt2);
      return parama;
      label142:
      parama.put(bbQ, jdField_a_of_type_WalletPfaFriendRsp.vecRec);
    }
  }
  
  private static void a(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    if (paramList1.size() == 1)
    {
      Intent localIntent = wja.a(new Intent(paramActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", (String)paramList1.get(0));
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", (String)paramList2.get(0));
      localIntent.setFlags(335544320);
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
      if (paramList1.size() > 1)
      {
        paramList1 = new Intent(paramActivity, SplashActivity.class);
        paramList1.putExtra("tab_index", MainFragment.bIk);
        paramList1.setFlags(67108864);
        paramActivity.startActivity(paramList1);
      }
    }
  }
  
  public static void a(SelectMemberActivity paramSelectMemberActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramSelectMemberActivity == null) || (paramSelectMemberActivity.isFinishing()) || (paramSelectMemberActivity.getIntent() == null) || (paramSelectMemberActivity.getIntent().getExtras() == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = acfp.m(2131715396);
    Object localObject1 = localObject2;
    int i;
    label57:
    ResultRecord localResultRecord;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      i = 0;
      if (i < paramArrayList.size())
      {
        localResultRecord = (ResultRecord)paramArrayList.get(i);
        localObject2 = localObject1;
        if (localResultRecord != null)
        {
          localObject2 = localObject1;
          if (localResultRecord.type == 0)
          {
            localObject2 = localObject1;
            if (localResultRecord.uin != null)
            {
              localArrayList.add(localResultRecord);
              if (TextUtils.isEmpty(localResultRecord.name)) {
                break label188;
              }
              localObject1 = (String)localObject1 + localResultRecord.name;
              label147:
              if (i >= paramArrayList.size() - 1) {
                break label369;
              }
            }
          }
        }
      }
    }
    label188:
    label369:
    for (localObject2 = (String)localObject1 + "、";; localObject2 = localObject1)
    {
      i += 1;
      localObject1 = localObject2;
      break label57;
      localObject1 = (String)localObject1 + localResultRecord.uin;
      break label147;
      if ((localArrayList == null) || (localArrayList.size() <= 0))
      {
        QQToast.a(paramSelectMemberActivity, paramSelectMemberActivity.getString(2131721226), 0).show();
        return;
      }
      paramArrayList = new zzp(new WeakReference(paramSelectMemberActivity), localArrayList);
      localObject2 = paramSelectMemberActivity.getIntent().getExtras();
      paramSelectMemberActivity = aqha.a(paramSelectMemberActivity, (String)localObject1, ((Bundle)localObject2).getString("choose_friend_content"), ((Bundle)localObject2).getString("choose_friend_subcontent"), paramSelectMemberActivity.ss, null, paramArrayList, paramArrayList, 36, false);
      anot.a(aagd.getQQAppInterface(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.windowshow", 0, 0, "", "", "", "");
      paramSelectMemberActivity = paramSelectMemberActivity.getTitleTextView();
      if (paramSelectMemberActivity == null) {
        break;
      }
      paramSelectMemberActivity.setSingleLine(false);
      paramSelectMemberActivity.setMaxLines(2);
      paramSelectMemberActivity.setEllipsize(TextUtils.TruncateAt.END);
      paramSelectMemberActivity.setGravity(3);
      return;
    }
  }
  
  public static void a(SelectMemberActivity paramSelectMemberActivity, ArrayList<ResultRecord> paramArrayList, aqla paramaqla)
  {
    if ((paramSelectMemberActivity == null) || (paramSelectMemberActivity.isFinishing()) || (paramSelectMemberActivity.getIntent() == null) || (paramSelectMemberActivity.getIntent().getExtras() == null)) {}
    ResultReceiver localResultReceiver;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    label136:
    label174:
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramArrayList == null) || (paramArrayList.size() <= 0));
        localResultReceiver = (ResultReceiver)paramSelectMemberActivity.getIntent().getParcelableExtra("aapay_result_recevier");
      } while (localResultReceiver == null);
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        localArrayList1.add(localResultRecord.uin);
        if (localResultRecord.SB == null)
        {
          paramArrayList = "";
          localArrayList2.add(paramArrayList);
          if (localResultRecord.name != null) {
            break label174;
          }
        }
        for (paramArrayList = "";; paramArrayList = localResultRecord.name)
        {
          localArrayList3.add(paramArrayList);
          break;
          paramArrayList = localResultRecord.SB;
          break label136;
        }
      }
    } while (localArrayList1.size() <= 0);
    paramArrayList = new Bundle();
    paramArrayList.putStringArrayList("choose_friend_uins", localArrayList1);
    paramArrayList.putStringArrayList("choose_friend_phones", localArrayList2);
    paramArrayList.putStringArrayList("choose_friend_names", localArrayList3);
    if (paramaqla != null) {
      paramArrayList.putString("choose_friend_feedback", paramaqla.getInputValue());
    }
    paramaqla = new TopayManager.5(null, new WeakReference(paramSelectMemberActivity), localResultReceiver, localArrayList1, localArrayList3);
    a(paramSelectMemberActivity, true);
    paramSelectMemberActivity = Parcel.obtain();
    paramaqla.writeToParcel(paramSelectMemberActivity, 0);
    paramSelectMemberActivity.setDataPosition(0);
    paramaqla = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramSelectMemberActivity);
    paramSelectMemberActivity.recycle();
    paramArrayList.putParcelable("callback", paramaqla);
    localResultReceiver.send(0, paramArrayList);
  }
  
  private static void a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing())) {}
    do
    {
      return;
      Object localObject = null;
      if (paramBoolean)
      {
        paramBaseActivity = new QWalletPayProgressDialog(paramBaseActivity);
        eL = new WeakReference(paramBaseActivity);
        paramBaseActivity.show();
        return;
      }
      paramBaseActivity = localObject;
      if (eL != null) {
        paramBaseActivity = (QWalletPayProgressDialog)eL.get();
      }
    } while ((paramBaseActivity == null) || (!paramBaseActivity.isShowing()));
    paramBaseActivity.dismiss();
  }
  
  public static void a(boolean paramBoolean1, PfaFriendRsp paramPfaFriendRsp, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && ((!paramBoolean1) || (paramPfaFriendRsp == null) || ((paramPfaFriendRsp != null) && (paramPfaFriendRsp.ret != 0)))) {
      return;
    }
    if ((!paramBoolean2) && (jdField_a_of_type_WalletPfaFriendRsp != null) && (paramPfaFriendRsp != null) && ((paramPfaFriendRsp.vecPfaMsg == null) || (paramPfaFriendRsp.vecPfaMsg.size() <= 0)))
    {
      jdField_a_of_type_WalletPfaFriendRsp.vecRec = paramPfaFriendRsp.vecRec;
      jdField_a_of_type_WalletPfaFriendRsp.use_default = paramPfaFriendRsp.use_default;
      jdField_a_of_type_WalletPfaFriendRsp.vecSpfaRec = paramPfaFriendRsp.vecSpfaRec;
      label85:
      if (paramBoolean2) {
        break label127;
      }
    }
    label127:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      BZ(paramBoolean1);
      if ((paramBoolean2) || (jdField_a_of_type_WalletPfaFriendRsp == null)) {
        break;
      }
      ThreadManager.getFileThreadHandler().post(new TopayManager.2());
      return;
      jdField_a_of_type_WalletPfaFriendRsp = paramPfaFriendRsp;
      break label85;
    }
  }
  
  private static void b(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    zzr localzzr = new zzr(paramActivity);
    paramList1 = new zzs(paramActivity, paramList1, paramList2);
    paramActivity = aqha.a(paramActivity, 230, null, acfp.m(2131715397), acfp.m(2131715395), "留在QQ", paramList1, localzzr);
    paramActivity.setCancelable(false);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.show();
  }
  
  public static void bA(QQAppInterface paramQQAppInterface)
  {
    cfI = -1;
    jdField_a_of_type_WalletPfaFriendRsp = null;
    if (eK != null)
    {
      eK.clear();
      eK = null;
    }
    if (eL != null)
    {
      eL.clear();
      eL = null;
    }
    if (paramQQAppInterface != null) {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Ackf);
    }
  }
  
  public static ArrayList<PfaFriend> cc()
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {}
    do
    {
      do
      {
        return null;
        localObject1 = localQQAppInterface.a().a();
      } while (localObject1 == null);
      localObject2 = ((acxw)localObject1).q(true);
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1006) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 1) && ((localRecentUser.getType() != 0) || (!jqs.d(localQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000))
      {
        PfaFriend localPfaFriend = new PfaFriend();
        localPfaFriend.uin = localRecentUser.uin;
        ((ArrayList)localObject1).add(localPfaFriend);
      }
    }
    return localObject1;
  }
  
  public static void gk(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.addObserver(jdField_a_of_type_Ackf);
    PfaFriendRqt localPfaFriendRqt = new PfaFriendRqt();
    localPfaFriendRqt.mqq_version = aqgz.bd(BaseApplicationImpl.getContext());
    if (jdField_a_of_type_WalletPfaFriendRsp != null)
    {
      localPfaFriendRqt.pfa_msg_edition = jdField_a_of_type_WalletPfaFriendRsp.pfa_msg_edition;
      TicketManager localTicketManager = (TicketManager)localQQAppInterface.getManager(2);
      if (localTicketManager != null) {
        localPfaFriendRqt.skey = localTicketManager.getSkey(localQQAppInterface.getCurrentAccountUin());
      }
      localPfaFriendRqt.pfa_sub_type = 0;
      if (paramInt1 == 1)
      {
        if (paramInt2 != 1) {
          break label124;
        }
        localPfaFriendRqt.pfa_sub_type = 1;
      }
    }
    for (;;)
    {
      ((acke)localQQAppInterface.getBusinessHandler(42)).a(localPfaFriendRqt);
      return;
      localPfaFriendRqt.pfa_msg_edition = "0";
      break;
      label124:
      if (paramInt2 == 2) {
        localPfaFriendRqt.pfa_sub_type = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzn
 * JD-Core Version:    0.7.0.1
 */