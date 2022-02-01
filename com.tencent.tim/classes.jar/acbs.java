import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.oidb.cmd0x77d.oidb_cmd0x77d.ReqBody;
import tencent.im.oidb.cmd0x8db.oidb_0x8db.ReqBody;
import tencent.im.oidb.cmd0x8db.oidb_0x8db.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.RewardInfo;

public class acbs
  extends accg
  implements aolm.a, aolm.b
{
  private static String bnP;
  private static String bnQ;
  private SharedPreferences I;
  private long Pe = -1L;
  private int aYE = -1;
  private Bundle aw;
  private boolean bGR;
  public HashMap<String, String[]> gs;
  private SharedPreferences pref;
  public ArrayList<String> sS;
  public String zipMd5;
  public String zipUrl;
  
  public acbs(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    Object localObject = paramQQAppInterface.getApp().getExternalFilesDir(null);
    if (localObject != null) {}
    for (localObject = ((File)localObject).getParent();; localObject = paramQQAppInterface.getApp().getFilesDir().getAbsolutePath())
    {
      bnQ = (String)localObject + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "babyQIconRes";
      bnP = bnQ + File.separator + "babyQIconRes.zip";
      try
      {
        this.pref = paramQQAppInterface.getApp().getSharedPreferences("pref_babyq" + paramQQAppInterface.getCurrentAccountUin(), 0);
        this.I = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
        this.zipMd5 = this.I.getString("babyq_pluspanel_config_zipMd5", "");
        this.zipUrl = this.I.getString("babyq_pluspanel_config_zipUrl", "");
        paramQQAppInterface = this.I.getString("babyq_profile_config_Url", "");
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          aqft.csE = paramQQAppInterface;
        }
        cGY();
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          QLog.i("Q.BabyQ", 1, "init plusPanelItems error!" + paramQQAppInterface);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "BabyQHandler | Utils.sBabyQProfileUrl :" + aqft.csE);
      }
      return;
    }
  }
  
  private void G(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.BabyQ", 2, "downloadIconRes | tryTimes : " + paramInt);
    }
    if (paramInt > 2) {
      return;
    }
    aolm localaolm = this.app.getNetEngine(0);
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.a = this;
    localaoll.bZ = paramString1;
    localaoll.atY = bnP;
    localaoll.mHttpMethod = 0;
    localaoll.dPo = 1;
    localaoll.bw(new acbs.a(paramInt + 1, paramString1, paramString2));
    localaolm.a(localaoll);
  }
  
  private void a(SharedPreferences paramSharedPreferences, ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    do
    {
      return;
      paramArrayList.clear();
      paramSharedPreferences = paramSharedPreferences.getString(paramString, "");
    } while (paramSharedPreferences.length() <= 0);
    int j;
    for (int i = 0;; i = j + 1)
    {
      j = paramSharedPreferences.indexOf(",", i);
      if (j == -1) {
        break;
      }
      paramArrayList.add(paramSharedPreferences.substring(i, j));
    }
    paramArrayList.add(paramSharedPreferences.substring(i));
  }
  
  private boolean at(String paramString1, String paramString2)
  {
    try
    {
      aqhq.W(paramString1, paramString2, false);
      return true;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.BabyQ", 2, "unZipResource : delete and uncompress Exception=>", paramString1);
      }
    }
    return false;
  }
  
  private void bf(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    oidb_0x8db.RspBody localRspBody;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend success = " + bool);
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      localRspBody = new oidb_0x8db.RspBody();
      paramFromServiceMsg = new Bundle();
      if (paramObject == null) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          int i = paramToServiceMsg.uint32_result.get();
          paramFromServiceMsg.putInt("ad_bbq_code", i);
          if (i != 0) {
            break label349;
          }
          bool = true;
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (localRspBody != null)
            {
              paramToServiceMsg = localRspBody.bytes_welcome_msg.get().toStringUtf8();
              paramFromServiceMsg.putString("ad_bbq_message", paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend result = " + i + " msg = " + paramToServiceMsg);
              }
              ((FriendListHandler)this.app.getBusinessHandler(1)).a(acbn.blz, 0, 3999, "", true, false, -1L);
              notifyUI(4, bool, paramFromServiceMsg);
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend false ");
          }
          notifyUI(4, false, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "BabyQ funcall handleAddBabyQAsFriend exception =" + paramToServiceMsg.getStackTrace());
        }
        notifyUI(4, false, paramFromServiceMsg);
        return;
      }
      paramToServiceMsg = "";
      continue;
      continue;
      bool = false;
      break;
      label349:
      bool = false;
    }
  }
  
  private void cGY()
  {
    if (this.sS == null) {
      this.sS = new ArrayList();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(this.I, localArrayList2, "babyq_pluspanel_config_reds");
    a(this.I, this.sS, "babyq_pluspanel_config_titles");
    a(this.I, localArrayList1, "babyq_pluspanel_config_codes");
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "BabyQHandler | titleList :" + this.sS + " | codeList : " + localArrayList1 + " | redList : " + localArrayList2 + " | zipMd5 : " + this.zipMd5 + " | zipUrl : " + this.zipUrl);
    }
    if ((this.sS.size() != localArrayList1.size()) || (localArrayList1.size() != localArrayList2.size()) || (this.sS.size() != localArrayList2.size())) {}
    for (;;)
    {
      return;
      if (this.gs == null) {
        this.gs = new HashMap();
      }
      int i = 0;
      while (i < this.sS.size())
      {
        this.gs.put(this.sS.get(i), new String[] { (String)localArrayList1.get(i), (String)localArrayList2.get(i) });
        i += 1;
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    String str = "";
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      if (paramInt2 == 1)
      {
        str = "0X800724C";
        if (paramInt1 != 1) {
          break label76;
        }
      }
    }
    for (;;)
    {
      label34:
      if (!TextUtils.isEmpty(str)) {
        anot.a(paramQQAppInterface, "dc00898", "", "", str, str, i, 0, "", "", "", "");
      }
      label76:
      label101:
      label120:
      while (!QLog.isColorLevel())
      {
        return;
        str = "0X800724D";
        break;
        i = 2;
        break label34;
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          if (paramInt2 == 1)
          {
            str = "0X800724E";
            if (paramInt1 != 3) {
              break label120;
            }
          }
          for (i = j;; i = 2)
          {
            break;
            str = "0X800724F";
            break label101;
          }
        }
        if (paramInt1 != 5) {
          break label196;
        }
        if (paramInt2 == 1) {}
        for (str = "0X8007250";; str = "0X8007251")
        {
          i = 0;
          break;
        }
      }
      QLog.d("Q.BabyQ", 2, "reportRewardAction error type:" + paramInt1 + " action:" + paramInt2);
      return;
      label196:
      i = 0;
    }
  }
  
  public static void go(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      paramView.setVisibility(8);
      paramView.clearAnimation();
    }
  }
  
  public static void k(Context paramContext, View paramView)
  {
    paramView.setVisibility(0);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772298);
    paramContext.setAnimationListener(new acbt(paramView));
    paramView.startAnimation(paramContext);
  }
  
  public void Dn(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    label9:
    do
    {
      ArrayList localArrayList;
      do
      {
        do
        {
          break label9;
          do
          {
            return;
          } while ((this.gs == null) || (this.gs.isEmpty()));
          localObject = (String[])this.gs.get(paramString);
        } while ((localObject == null) || (localObject.length != 2));
        localObject[1] = "0";
        this.gs.put(paramString, localObject);
        if (this.I == null) {
          this.I = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
        }
        localArrayList = new ArrayList();
        localObject = new ArrayList();
        a(this.I, localArrayList, "babyq_pluspanel_config_titles");
        a(this.I, (ArrayList)localObject, "babyq_pluspanel_config_reds");
      } while (localArrayList.size() != ((ArrayList)localObject).size());
      for (;;)
      {
        if (i < localArrayList.size())
        {
          if (paramString.equalsIgnoreCase((String)localArrayList.get(i))) {
            ((ArrayList)localObject).set(i, "0");
          }
        }
        else
        {
          paramString = new StringBuilder();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.append((String)((Iterator)localObject).next()).append(",");
          }
        }
        i += 1;
      }
    } while (paramString.length() <= 1);
    paramString.deleteCharAt(paramString.length() - 1);
    Object localObject = this.I.edit();
    ((SharedPreferences.Editor)localObject).putString("babyq_pluspanel_config_reds", paramString.toString());
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void Do(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "BabyQ funcall addBabyQGreetingMsg error for empty greeting");
      }
    }
    do
    {
      return;
      ahwa localahwa = new ahwa(acbn.blz, this.app.getCurrentAccountUin(), paramString, 9002, -5040, 655362, anaz.gQ());
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.initGrayTipMsg(this.app, localahwa);
      ahwb.a(this.app, localMessageForUniteGrayTip);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "BabyQ funcall addBabyQGreetingMsg success greeting =" + paramString);
  }
  
  public void ID(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "handleBabyQGuide handleType:" + paramInt);
    }
    if (this.pref == null) {
      this.pref = this.app.getApp().getSharedPreferences("pref_babyq" + this.app.getCurrentAccountUin(), 0);
    }
    if (this.pref.getBoolean("Key_Guide_" + paramInt, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "handleBabyQGuide return");
      }
      return;
    }
    if (this.aYE != -1) {
      cGZ();
    }
    this.aYE = paramInt;
    this.pref.edit().putBoolean("Key_Guide_" + paramInt, true).commit();
    notifyUI(2, true, Integer.valueOf(paramInt));
  }
  
  public boolean O(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "babyq_pluspanel_auto_show", false);
  }
  
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaomg instanceof aoll));
      paramaomg = (aoll)paramaomg;
      paramaomg.apS += paramaomh.apW;
      paramaomh.apW = 0L;
      paramaomh = "bytes=" + paramaomg.apS + "-";
      paramaomg.u.put("Range", paramaomh);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "fixReq|mWrittenBlockLen : " + paramaomg.apS);
  }
  
  public void a(SubMsgType0x6f.ForwardBody paramForwardBody)
  {
    Object localObject = (SubMsgType0x6f.RewardInfo)paramForwardBody.msg_babyq_reward_info.get();
    paramForwardBody = new Bundle();
    if (((SubMsgType0x6f.RewardInfo)localObject).uint32_type.has()) {
      paramForwardBody.putInt("rewardType", ((SubMsgType0x6f.RewardInfo)localObject).uint32_type.get());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_name.has()) {
      paramForwardBody.putByteArray("rewardName", ((SubMsgType0x6f.RewardInfo)localObject).bytes_name.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_url.has()) {
      paramForwardBody.putByteArray("rewardUrl", ((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_url.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_cookies.has()) {
      paramForwardBody.putByteArray("rewardCookie", ((SubMsgType0x6f.RewardInfo)localObject).bytes_cookies.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_wording.has()) {
      paramForwardBody.putByteArray("rewardJupWording", ((SubMsgType0x6f.RewardInfo)localObject).bytes_jmp_wording.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_wording.has()) {
      paramForwardBody.putByteArray("rewardOptWording", ((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_wording.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_url.has()) {
      paramForwardBody.putByteArray("rewardOptUrl", ((SubMsgType0x6f.RewardInfo)localObject).bytes_opt_url.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).uint64_face_addon_id.has()) {
      paramForwardBody.putLong("rewardFaceId", ((SubMsgType0x6f.RewardInfo)localObject).uint64_face_addon_id.get());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_icon_url.has()) {
      paramForwardBody.putByteArray("rewardIconUrl", ((SubMsgType0x6f.RewardInfo)localObject).bytes_icon_url.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).bytes_toast_wording.has()) {
      paramForwardBody.putByteArray("rewardToastWording", ((SubMsgType0x6f.RewardInfo)localObject).bytes_toast_wording.get().toByteArray());
    }
    if (((SubMsgType0x6f.RewardInfo)localObject).uint32_report_type.has()) {
      paramForwardBody.putInt("rewardReportType", ((SubMsgType0x6f.RewardInfo)localObject).uint32_report_type.get());
    }
    if (this.bGR)
    {
      this.aw = paramForwardBody;
      return;
    }
    localObject = new Intent(BaseActivity.sTopActivity, RewardNoticeActivity.class);
    ((Intent)localObject).putExtras(paramForwardBody);
    BaseActivity.sTopActivity.startActivity((Intent)localObject);
  }
  
  public void au(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        if (this.pref == null) {
          this.pref = this.app.getApp().getSharedPreferences("pref_babyq" + this.app.getCurrentAccountUin(), 0);
        }
        paramArrayOfByte = (babyq_cookie.BabyQCookie)new babyq_cookie.BabyQCookie().mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.uint64_client_ability.has())
        {
          long l2 = paramArrayOfByte.uint64_client_ability.get();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.BabyQ", 2, "decodePBMsgElems, babyQ ability:" + l2);
            l1 = l2;
          }
          this.pref.edit().putLong("Key_Ability", l1).commit();
          this.Pe = l1;
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.BabyQ", 2, "setAbility " + paramArrayOfByte.toString());
        return;
      }
      long l1 = 0L;
    }
  }
  
  public void av(byte[] paramArrayOfByte)
  {
    oidb_cmd0x77d.ReqBody localReqBody = new oidb_cmd0x77d.ReqBody();
    localReqBody.bytes_reward_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    if (QLog.isColorLevel()) {
      QLog.i("Q.BabyQ", 2, "getReward");
    }
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0x77d_0", 1917, 0, localReqBody.toByteArray());
    paramArrayOfByte.extraData.putBoolean("req_pb_protocol_flag", true);
    send(paramArrayOfByte);
  }
  
  void be(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = false;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "handleGetReward success=" + bool1);
      }
      if (!bool1) {
        break label383;
      }
      bool3 = bool1;
      bool4 = bool1;
    }
    label383:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        bool3 = bool1;
        bool4 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool2 = true;
        bool3 = bool2;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          bool3 = bool2;
          bool4 = bool2;
          QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool2);
        }
        bool1 = bool5;
        if (bool2)
        {
          bool1 = bool5;
          bool3 = bool2;
          bool4 = bool2;
          if (paramToServiceMsg.bytes_bodybuffer.has())
          {
            bool3 = bool2;
            bool4 = bool2;
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get();
            bool1 = bool5;
            if (paramToServiceMsg != null) {
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool1);
          bool2 = bool1;
        }
      }
      catch (Exception paramToServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.BabyQ", 2, "handleGetReward ex", paramToServiceMsg);
          }
          boolean bool2 = bool3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool3);
          bool2 = bool3;
          continue;
        }
        finally
        {
          bool4 = bool3;
        }
        paramToServiceMsg = finally;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.BabyQ", 2, "handleGetReward result=" + bool4);
      }
      notifyUI(1, bool2, null);
      return;
      bool1 = false;
      break;
      bool2 = false;
    }
  }
  
  public void bs(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.BabyQ", 2, "checkDownloadIconRes | isConfigChanged : " + paramBoolean1 + ", isMD5Changed : " + paramBoolean2);
    }
    if (this.I == null) {
      this.I = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
    }
    if (TextUtils.isEmpty(this.I.getString("babyq_pluspanel_config_titles", ""))) {}
    label110:
    Object localObject;
    File localFile;
    do
    {
      String str1;
      String str2;
      do
      {
        do
        {
          do
          {
            break label110;
            break label110;
            do
            {
              return;
            } while (TextUtils.isEmpty(this.I.getString("babyq_pluspanel_config_codes", "")));
            str1 = this.I.getString("babyq_pluspanel_config_zipMd5", "");
          } while (TextUtils.isEmpty(str1));
          str2 = this.I.getString("babyq_pluspanel_config_zipUrl", "");
        } while (TextUtils.isEmpty(str2));
        if (paramBoolean2)
        {
          aqhq.delete(bnQ, false);
          G(str2, str1, 1);
          return;
        }
        localObject = new File(bnQ);
        localFile = new File(bnP);
        if (!((File)localObject).exists())
        {
          G(str2, str1, 1);
          return;
        }
      } while (!((File)localObject).isDirectory());
      localObject = ((File)localObject).listFiles();
      if ((localObject == null) || (localObject.length == 0))
      {
        G(str2, str1, 1);
        return;
      }
    } while ((localObject.length != 1) || (!localFile.exists()));
    notifyUI(5, at(bnP, bnQ), null);
  }
  
  public void c(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "babyq_pluspanel_auto_show", paramBoolean);
    paramContext.commit();
  }
  
  public void cGZ()
  {
    this.aYE = -1;
    notifyUI(3, true, null);
  }
  
  public void cHa()
  {
    if ((this.bGR) && (this.aw != null))
    {
      Intent localIntent = new Intent(BaseActivity.sTopActivity, RewardNoticeActivity.class);
      localIntent.putExtras(this.aw);
      BaseActivity.sTopActivity.startActivity(localIntent);
      this.aw = null;
      this.bGR = false;
    }
  }
  
  public void cHb()
  {
    if (this.I == null) {
      this.I = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin() + "_" + "babyQ_pluspanel_config_sp_name", 0);
    }
    SharedPreferences.Editor localEditor = this.I.edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public void de(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("from_babyq", false))
    {
      this.bGR = true;
      this.app.b().uz("babyq_add_friend");
      anot.a(this.app, "dc00898", "", "", "0X8007242", "0X8007242", 0, 0, "", "", "", "");
    }
  }
  
  public long eQ()
  {
    try
    {
      if (this.pref == null) {
        this.pref = this.app.getApp().getSharedPreferences("pref_babyq" + this.app.getCurrentAccountUin(), 0);
      }
      if (this.Pe == -1L)
      {
        this.Pe = this.pref.getLong("Key_Ability", 0L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "getAbility " + this.Pe);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "getAbility error e:" + localException.toString());
        }
      }
    }
    return this.Pe;
  }
  
  public void gR(int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_0x8db.ReqBody();
    ((oidb_0x8db.ReqBody)localObject).uint32_user_type.set(paramInt1);
    ((oidb_0x8db.ReqBody)localObject).uint32_from_type.set(paramInt2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("BabyQ funcall addBabyQAsFreind ");
      localStringBuilder.append(" userType = ").append(paramInt1);
      localStringBuilder.append(" fromType = ").append(paramInt2);
      localStringBuilder.append("\n");
      QLog.i("Q.BabyQ", 2, localStringBuilder.toString());
    }
    localObject = makeOIDBPkg("OidbSvc.0x8db_0", 2267, 0, ((oidb_0x8db.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    send((ToServiceMsg)localObject);
  }
  
  public boolean io(int paramInt)
  {
    return this.aYE == paramInt;
  }
  
  public boolean jR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.gs == null) || (this.gs.isEmpty())) {
      return false;
    }
    String[] arrayOfString = (String[])this.gs.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "babyQPlusPanelShowRed codeAndRed.length: " + arrayOfString.length);
    }
    if ((arrayOfString == null) || (arrayOfString.length != 2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "babyQPlusPanelShowRed title: " + paramString + ", showRed : " + arrayOfString[1]);
    }
    return "1".equalsIgnoreCase(arrayOfString[1]);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x77d_0");
      this.allowCmdSet.add("OidbSvc.0x8db_0");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void o(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "babyq_pluspanel_config_version", paramInt);
    paramContext.commit();
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acbw.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x77d_0".equals(paramFromServiceMsg.getServiceCmd())) {
      be(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"OidbSvc.0x8db_0".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    bf(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onResp is downloading...");
      }
    }
    do
    {
      return;
      localObject1 = paramaomh.b.U();
    } while ((localObject1 == null) || (!(localObject1 instanceof acbs.a)));
    Object localObject1 = (acbs.a)localObject1;
    int i;
    label57:
    Object localObject2;
    if (paramaomh.mResult == 0)
    {
      i = 1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onResp|download ");
        if (i == 0) {
          break label204;
        }
      }
    }
    label204:
    for (paramaomh = "success";; paramaomh = "failed")
    {
      QLog.d("Q.BabyQ", 2, paramaomh);
      if (i == 0) {
        break label229;
      }
      paramaomh = new File(bnP);
      localObject2 = alab.getFileMD5String(paramaomh.getAbsolutePath());
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).equalsIgnoreCase(((acbs.a)localObject1).zipMd5))) {
        break label211;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.BabyQ", 2, "onResp|Md5 error，fileMD5 = " + (String)localObject2 + ", configMD5 = " + ((acbs.a)localObject1).zipMd5);
      aqhq.delete(bnQ, false);
      return;
      i = 0;
      break label57;
    }
    label211:
    notifyUI(5, at(paramaomh.getAbsolutePath(), bnQ), null);
    return;
    label229:
    G(((acbs.a)localObject1).zipUrl, ((acbs.a)localObject1).zipMd5, ((acbs.a)localObject1).cuw);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "onUpdateProgeress|curOffset : " + paramLong1 + ", totalLen : " + paramLong2);
    }
  }
  
  public void p(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "babyq_pluspanel_config_appid", paramInt);
    paramContext.commit();
  }
  
  public int t(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "babyq_pluspanel_config_version", 0);
  }
  
  public int u(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "babyq_pluspanel_config_appid", 0);
  }
  
  public Drawable w(int paramInt)
  {
    String str = bnQ + File.separator + "babyq_" + paramInt + ".png";
    if (QLog.isColorLevel()) {
      QLog.d("Q.BabyQ", 2, "getBabyQPlusPanelIcon iconPath: " + str);
    }
    if (aqhq.fileExistsAndNotEmpty(str)) {
      return new BitmapDrawable(this.app.getApplication().getResources(), str);
    }
    return null;
  }
  
  class a
  {
    public int cuw;
    public String zipMd5;
    public String zipUrl;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.cuw = paramInt;
      this.zipUrl = paramString1;
      this.zipMd5 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbs
 * JD-Core Version:    0.7.0.1
 */