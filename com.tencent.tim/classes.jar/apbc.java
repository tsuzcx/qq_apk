import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.WindowManager.BadTokenException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic;
import com.tencent.mobileqq.troop.logic.TroopSearchLogic.a;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class apbc
  implements Manager
{
  public ArrayList<TroopSearchLogic.a> BN;
  Timer J;
  Dialog Z;
  protected accd a;
  public apbc.d a;
  TroopSearchLogic a;
  public String aZO = "DEFAULT";
  public QQAppInterface app;
  acnd jdField_b_of_type_Acnd = new apbf(this);
  apbc.c jdField_b_of_type_Apbc$c;
  int dSU = 0;
  WeakReference<Activity> mActivity;
  public int mFrom = 0;
  
  public apbc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Apbc$d = new apbc.d();
    this.jdField_a_of_type_Accd = new apbg(this);
    this.app = paramQQAppInterface;
  }
  
  private void CA()
  {
    if (this.Z != null)
    {
      if (this.Z.isShowing()) {
        this.Z.dismiss();
      }
      this.Z = null;
    }
  }
  
  private boolean au(List<ResultRecord> paramList)
  {
    Object localObject = paramList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((ResultRecord)((Iterator)localObject).next()).uin.equals(this.app.getCurrentAccountUin())) {
        break label111;
      }
      i = 1;
    }
    label111:
    for (;;)
    {
      break;
      if (i == 0)
      {
        localObject = new ResultRecord();
        ((ResultRecord)localObject).uin = this.app.getCurrentUin();
        ((ResultRecord)localObject).type = 0;
        ((ResultRecord)localObject).name = aqgv.e(this.app, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).type);
        paramList.add(localObject);
      }
      return i == 0;
    }
  }
  
  private void dN(String paramString)
  {
    Object localObject = (Activity)this.mActivity.get();
    if (!(localObject instanceof BaseActivity)) {}
    do
    {
      BaseActivity localBaseActivity;
      do
      {
        do
        {
          return;
        } while ((this.Z != null) && (this.Z.isShowing()));
        localBaseActivity = (BaseActivity)localObject;
      } while (localBaseActivity.isFinishing());
      localObject = new arhz((Context)localObject, localBaseActivity.getTitleBarHeight());
      ((arhz)localObject).setMessage(paramString);
      ((arhz)localObject).setCancelable(false);
      ((arhz)localObject).setOnDismissListener(new apbh(this));
      this.Z = ((Dialog)localObject);
      try
      {
        this.Z.show();
        return;
      }
      catch (WindowManager.BadTokenException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("TroopCreateLogic", 2, paramString.getMessage());
  }
  
  public static String u(ArrayList<String> paramArrayList)
  {
    Collections.sort(paramArrayList, new apbi());
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramArrayList = (String)localIterator.next();
      if (i <= 2) {
        break label91;
      }
    }
    label91:
    int k;
    int j;
    for (;;)
    {
      if (localStringBuffer.toString().endsWith("、")) {
        localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
      }
      return localStringBuffer.toString();
      if ((paramArrayList == null) || ("".equals(paramArrayList))) {
        break label324;
      }
      try
      {
        k = localStringBuffer.toString().getBytes("utf-8").length;
        j = paramArrayList.getBytes("utf-8").length;
        k = 30 - k;
        if (k > 0) {
          if (i == 0) {
            if (j > 20)
            {
              while (j >= 14)
              {
                paramArrayList = paramArrayList.substring(0, paramArrayList.length() - 1);
                j = paramArrayList.getBytes("utf-8").length;
              }
              localStringBuffer.append(paramArrayList).append("…").append("、");
            }
            else
            {
              localStringBuffer.append(paramArrayList).append("、");
            }
          }
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
    }
    label222:
    Object localObject2;
    if (k < 3)
    {
      k = 3;
      if (k >= j) {
        break label334;
      }
      Object localObject1 = paramArrayList;
      int n = 0;
      int m = j;
      for (j = n;; j = 1)
      {
        localObject2 = localObject1;
        if (k >= m + 3) {
          break;
        }
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        m = ((String)localObject1).getBytes("utf-8").length;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        localStringBuffer.append((String)localObject2).append("…").append("、");
      }
      else
      {
        localStringBuffer.append(paramArrayList).append("、");
        break label327;
        break label222;
        label324:
        break label331;
      }
      label327:
      i += 1;
      label331:
      break;
      label334:
      j = 0;
      localObject2 = paramArrayList;
    }
  }
  
  public void SH(String paramString)
  {
    if (this.jdField_b_of_type_Apbc$c != null) {
      this.jdField_b_of_type_Apbc$c.Bb(paramString);
    }
  }
  
  public final apbc.d a()
  {
    return this.jdField_a_of_type_Apbc$d;
  }
  
  public String a(ResultRecord paramResultRecord, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = aqgv.a(this.app, paramResultRecord.uin, paramString, 1, 0);
      if (!TextUtils.equals(paramString, paramResultRecord.uin)) {
        return paramString;
      }
    }
    if (((acff)this.app.getManager(51)).isFriend(paramResultRecord.uin)) {
      return aqgv.t(this.app, paramResultRecord.uin);
    }
    if (this.app.getCurrentAccountUin().equals(paramResultRecord.uin)) {
      return paramResultRecord.name;
    }
    if (paramResultRecord.type == 1)
    {
      paramString = ((TroopManager)this.app.getManager(52)).b(paramResultRecord.QD, paramResultRecord.uin);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.friendnick))) {
        return paramString.friendnick;
      }
    }
    else if (paramResultRecord.type == 2)
    {
      paramString = ((acdu)this.app.getManager(53)).a(paramResultRecord.QD, paramResultRecord.uin);
      if (paramString != null)
      {
        if (!TextUtils.isEmpty(paramString.memberName)) {
          return paramString.memberName;
        }
        return paramString.inteRemark;
      }
    }
    return paramResultRecord.uin + "";
  }
  
  public void a(apbc.c paramc)
  {
    if (this.jdField_b_of_type_Apbc$c == paramc) {
      this.jdField_b_of_type_Apbc$c = null;
    }
  }
  
  public void a(apbc.c paramc, BaseActivity paramBaseActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!localResultRecord.uin.equals(this.app.getCurrentAccountUin()))
        {
          apbc.a locala = new apbc.a();
          locala.name = localResultRecord.name;
          locala.pinyin = ChnToSpell.aJ(localResultRecord.name, 2);
          localArrayList.add(locala);
        }
      }
      Collections.sort(localArrayList);
      au(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic = new TroopSearchLogic();
      }
      this.mActivity = new WeakReference(paramBaseActivity);
      this.jdField_b_of_type_Apbc$c = paramc;
      this.jdField_a_of_type_Apbc$d.HD = Collections.synchronizedList(paramArrayList);
      dN(acfp.m(2131715640));
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic.a(paramArrayList, new apbd(this, localArrayList, paramBaseActivity, paramc, paramArrayList));
    }
  }
  
  public void a(apbc.c paramc, BaseActivity paramBaseActivity, List<ResultRecord> paramList)
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131696272, 0).show();
      dYx();
      return;
    }
    if ((this.jdField_a_of_type_Apbc$d == null) || (this.jdField_a_of_type_Apbc$d.a == null))
    {
      dYx();
      return;
    }
    if (paramBaseActivity != null) {
      this.mActivity = new WeakReference(paramBaseActivity);
    }
    Object localObject;
    if (paramList != null)
    {
      au(paramList);
      if (paramList.size() > 0)
      {
        if (this.jdField_a_of_type_Apbc$d.HD != paramList) {
          this.jdField_a_of_type_Apbc$d.HD = Collections.synchronizedList(paramList);
        }
        paramBaseActivity = new ArrayList();
        paramList = this.jdField_a_of_type_Apbc$d.HD.iterator();
        while (paramList.hasNext())
        {
          localObject = a((ResultRecord)paramList.next(), null);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBaseActivity.add(localObject);
          }
        }
        this.jdField_a_of_type_Apbc$d.name = u(paramBaseActivity);
      }
    }
    int i;
    long l1;
    long l2;
    try
    {
      l3 = Long.parseLong(this.app.getCurrentAccountUin());
      paramList = (accc)this.app.getBusinessHandler(22);
      localObject = this.jdField_a_of_type_Apbc$d.location.split("\\|");
      i = 0;
      l1 = 0L;
      l2 = 0L;
      paramBaseActivity = "";
      if (localObject.length != 4) {
        break label448;
      }
    }
    catch (NumberFormatException paramc)
    {
      long l3;
      float f;
      label293:
      dYx();
      return;
    }
    try
    {
      i = Integer.parseInt(localObject[0]);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      l1 = 0L;
      i = 0;
      break label293;
    }
    try
    {
      f = Float.valueOf(localObject[1]).floatValue();
      l1 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      l1 = 0L;
      break label293;
    }
    try
    {
      f = Float.valueOf(localObject[2]).floatValue();
      l2 = (f * 1000000.0F);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      break label293;
    }
    paramBaseActivity = localObject[3];
    for (;;)
    {
      int k = this.jdField_a_of_type_Apbc$d.troopType;
      int j = k;
      if (k == 2) {
        j = k + 1;
      }
      this.app.addObserver(this.jdField_a_of_type_Accd);
      localObject = this.jdField_a_of_type_Apbc$d.a;
      this.jdField_b_of_type_Apbc$c = paramc;
      paramList.a(((apbb)localObject).troopUin, ((apbb)localObject).groupSize, l3, this.jdField_a_of_type_Apbc$d.verifyType, this.jdField_a_of_type_Apbc$d.name, this.jdField_a_of_type_Apbc$d.cnO, this.jdField_a_of_type_Apbc$d.classify, j, l1, l2, i, paramBaseActivity, ((apbb)localObject).gp, this.mFrom);
      dN(acfp.m(2131715639));
      return;
      label448:
      l2 = 0L;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "startCreateTroopSession: from=" + paramInt + ", type=" + paramString);
    }
    this.mFrom = paramInt;
    this.aZO = paramString;
    dYx();
    switch (this.mFrom)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.mFrom) }));
      }
      aoyd.at(paramBaseActivity, this.mFrom);
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.mFrom) }));
      }
      aoyd.fp(paramBaseActivity);
      return;
    }
    if (("1".equals(this.aZO)) || ("0".equals(this.aZO)) || ("2".equals(this.aZO)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering create troop session, From type: %s, Troop type: %s...", new Object[] { Integer.valueOf(this.mFrom), this.aZO }));
      }
      aoyd.cg(paramBaseActivity, this.aZO);
    }
    for (;;)
    {
      paramBaseActivity.finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopCreate_Log", 2, String.format("Entering default create troop session, From type: %s...", new Object[] { Integer.valueOf(this.mFrom) }));
      }
      aoyd.fp(paramBaseActivity);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, apbc.c paramc)
  {
    if (this.mActivity == null)
    {
      this.mActivity = new WeakReference(paramBaseActivity);
      this.jdField_b_of_type_Apbc$c = paramc;
    }
    paramBaseActivity = (BaseActivity)this.mActivity.get();
    if (paramBaseActivity == null)
    {
      dYx();
      return;
    }
    if ((this.jdField_a_of_type_Apbc$d == null) || (this.jdField_a_of_type_Apbc$d.HD == null) || (this.jdField_b_of_type_Apbc$c == null))
    {
      dYx();
      return;
    }
    a(this.jdField_b_of_type_Apbc$c, paramBaseActivity, this.jdField_a_of_type_Apbc$d.HD);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, apbc.b paramb)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      au(paramArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic = new TroopSearchLogic();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopSearchLogic.a(paramArrayList, new apbe(this, paramb));
    }
  }
  
  public void aS(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((this.jdField_a_of_type_Apbc$d != null) && (paramString.equals(this.jdField_a_of_type_Apbc$d.troopUin))) {}
    MessageForGrayTips localMessageForGrayTips;
    do
    {
      return;
      localMessageForGrayTips = (MessageForGrayTips)anbi.d(2024);
      localMessageForGrayTips.frienduin = paramString;
      Object localObject = BaseApplicationImpl.getApplication().getResources();
      String str1 = ((Resources)localObject).getString(2131699514);
      String str2 = ((Resources)localObject).getString(2131699512);
      localObject = ((Resources)localObject).getString(2131699513);
      localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, str1, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      localMessageForGrayTips.setTextGravity(17);
      paramString = new Bundle();
      paramString.putInt("key_action", 7);
      int i = str1.indexOf(str2);
      localMessageForGrayTips.addHightlightItem(i, str2.length() + i, paramString);
      paramString = new Bundle();
      paramString.putInt("key_action", 6);
      i = str1.indexOf((String)localObject);
      localMessageForGrayTips.addHightlightItem(i, ((String)localObject).length() + i, paramString);
    } while (achp.a(paramQQAppInterface, localMessageForGrayTips, false));
    paramQQAppInterface.b().b(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public void b(apbc.c paramc)
  {
    a(paramc, null, null);
  }
  
  public boolean bM(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    if ((this.jdField_a_of_type_Apbc$d != null) && (paramString1.equals(this.jdField_a_of_type_Apbc$d.troopUin)) && (this.jdField_a_of_type_Apbc$d.HD != null))
    {
      paramString1 = this.jdField_a_of_type_Apbc$d.HD.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.equals(((ResultRecord)paramString1.next()).uin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void ch(Context paramContext, String paramString)
  {
    Intent localIntent = wja.a(new Intent(paramContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_Apbc$d.name);
    localIntent.putExtra("isBack2Root", true);
    if ((paramContext instanceof Application)) {
      localIntent.setFlags(268435456);
    }
    localIntent.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    paramContext.startActivity(localIntent);
  }
  
  public void d(BaseActivity paramBaseActivity, int paramInt)
  {
    a(paramBaseActivity, paramInt, "DEFAULT");
  }
  
  public final void dYx()
  {
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Accd);
    }
    CA();
    this.jdField_b_of_type_Apbc$c = null;
    this.mActivity = null;
    this.J = null;
    this.dSU = 0;
    if (this.jdField_a_of_type_Apbc$d != null) {
      this.jdField_a_of_type_Apbc$d.reset();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "terminateLogic");
    }
  }
  
  public final void gi(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Apbc$d.reset();
    this.jdField_a_of_type_Apbc$d.SI(paramString);
    this.jdField_a_of_type_Apbc$d.dYy();
    this.mFrom = paramInt;
  }
  
  public void hT(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      break label8;
    }
    label8:
    label150:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Apbc$d != null) && (paramString1.equals(this.jdField_a_of_type_Apbc$d.troopUin)) && (this.jdField_a_of_type_Apbc$d.HD != null))
      {
        Iterator localIterator = this.jdField_a_of_type_Apbc$d.HD.iterator();
        ResultRecord localResultRecord;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localResultRecord = (ResultRecord)localIterator.next();
        } while (!paramString2.equals(localResultRecord.uin));
        for (;;)
        {
          if (localResultRecord == null) {
            break label150;
          }
          this.jdField_a_of_type_Apbc$d.HD.remove(localResultRecord);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopCreateLogic", 2, "deleteInInviteList troopUin:" + paramString1 + "  memberUin:" + paramString2);
          return;
          localResultRecord = null;
        }
      }
    }
  }
  
  public void j(String paramString1, boolean paramBoolean, String paramString2)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)anbi.d(2024);
    localMessageForGrayTips.frienduin = paramString1;
    if ((paramBoolean) && ((this.jdField_a_of_type_Apbc$d.HD == null) || (this.jdField_a_of_type_Apbc$d.HD.size() == 0))) {}
    do
    {
      return;
      l2 = 0L;
      if ((this.jdField_a_of_type_Apbc$d == null) || (!paramString1.equals(this.jdField_a_of_type_Apbc$d.troopUin))) {
        break;
      }
    } while (this.jdField_a_of_type_Apbc$d.cPH);
    this.jdField_a_of_type_Apbc$d.cPH = true;
    long l2 = this.jdField_a_of_type_Apbc$d.aqQ;
    long l1 = l2;
    if (QLog.isColorLevel()) {
      QLog.d("TroopCreatGrayTip", 2, "addCreateNewTroopGrayTips troopMaxMsgseq:" + l2);
    }
    String str;
    StringBuffer localStringBuffer;
    for (;;)
    {
      str = acfp.m(2131715637);
      if (!paramBoolean) {
        break label438;
      }
      paramString2 = acfp.m(2131715635);
      localStringBuffer = new StringBuffer();
      Iterator localIterator = this.jdField_a_of_type_Apbc$d.HD.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ResultRecord)localIterator.next();
        if (!((ResultRecord)localObject).uin.equals(this.app.getCurrentAccountUin()))
        {
          localObject = a((ResultRecord)localObject, paramString1);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localStringBuffer.append((String)localObject).append("、");
          }
        }
      }
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopCreatGrayTip", 2, "addCreateNewTroopGrayTips createInfo is null. troopUin = " + paramString1);
        l1 = l2;
      }
      l2 = l1;
    }
    localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
    paramString2 = String.format(paramString2, new Object[] { localStringBuffer.toString() });
    for (;;)
    {
      localMessageForGrayTips.init(this.app.getCurrentAccountUin(), paramString1, paramString1, paramString2, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      localMessageForGrayTips.shmsgseq = l2;
      paramString1 = new Bundle();
      paramString1.putInt("key_action", 25);
      int i = paramString2.indexOf(str);
      localMessageForGrayTips.addHightlightItem(i, str.length() + i, paramString1);
      if (achp.a(this.app, localMessageForGrayTips, false)) {
        break;
      }
      this.app.b().b(localMessageForGrayTips, this.app.getCurrentAccountUin());
      return;
      label438:
      if (!TextUtils.isEmpty(paramString2)) {
        paramString2 = String.format(acfp.m(2131715634), new Object[] { paramString2 });
      } else {
        paramString2 = acfp.m(2131715636);
      }
    }
  }
  
  public void onDestroy()
  {
    dYx();
  }
  
  class a
    implements Comparable<a>
  {
    public String name;
    public String pinyin;
    
    a() {}
    
    public int a(@NonNull a parama)
    {
      return this.pinyin.compareTo(parama.pinyin);
    }
  }
  
  public static abstract interface b
  {
    public abstract void eX(ArrayList<Entity> paramArrayList);
  }
  
  public static abstract interface c
  {
    public abstract void Bb(String paramString);
    
    public abstract void bE(int paramInt, String paramString);
    
    public abstract void bF(int paramInt, String paramString);
  }
  
  public static class d
  {
    public List<ResultRecord> HD = Collections.synchronizedList(new ArrayList());
    public apbb a;
    public long aqQ;
    public boolean cPF;
    public boolean cPG;
    public boolean cPH;
    public int classify;
    public String cnM;
    public String cnN;
    public String cnO;
    public int createFrom = 0;
    public String location;
    public String name;
    public int troopType;
    public String troopUin;
    public int verifyType;
    
    public d()
    {
      reset();
    }
    
    public void SI(String paramString)
    {
      boolean bool = true;
      try
      {
        paramString = new JSONObject(paramString);
        this.classify = paramString.optInt("classify", 0);
        this.verifyType = paramString.optInt("verifyType", 2);
        this.cnM = paramString.optString("classificationInfo", "");
        this.name = paramString.optString("name", "");
        this.cnO = paramString.optString("introduction", "");
        this.location = paramString.optString("location", "");
        this.troopType = paramString.optInt("group_type", -1);
        if (paramString.optInt("isJumpAio") == 1) {}
        for (;;)
        {
          this.cPG = bool;
          this.createFrom = paramString.optInt("create_source", 0);
          return;
          bool = false;
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public void dYy()
    {
      this.a = new apbb();
      this.a.groupSize = 1;
      this.a.gp = new byte[0];
    }
    
    public void reset()
    {
      this.classify = 0;
      this.verifyType = 0;
      this.cnM = "";
      this.name = "";
      this.cnO = "";
      this.location = "";
      this.a = null;
      this.troopType = -1;
      this.cPF = false;
      if (this.HD != null) {
        this.HD.clear();
      }
      this.cPH = false;
      this.cPG = false;
      this.aqQ = 0L;
    }
  }
  
  public static class e
  {
    public int resultCode = -1;
    
    public static int jG(int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      if ((paramInt == 70) || (paramInt == 7)) {
        return 2131698354;
      }
      if ((paramInt == 97) || (paramInt == 9)) {
        return 2131698349;
      }
      if ((paramInt == 98) || (paramInt == 10)) {
        return 2131698353;
      }
      if ((paramInt == 101) || (paramInt == 11) || (paramInt == 102) || (paramInt == 103) || (paramInt == 14)) {
        return 2131698351;
      }
      if ((paramInt == 105) || (paramInt == 16)) {
        return 2131698350;
      }
      if (paramInt == 21) {
        return 2131698348;
      }
      return 2131698352;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbc
 * JD-Core Version:    0.7.0.1
 */