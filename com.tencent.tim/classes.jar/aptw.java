import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.UinRange;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.1;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.3;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.6;
import com.tencent.mobileqq.troop.utils.TroopRobotManager.7;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934.ReqBody;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class aptw
  implements Manager
{
  static Object sLock = new Object();
  protected ArrayList<String> Cq;
  protected List<aptw.c> Im = new ArrayList(5);
  protected List<String> In = new ArrayList(5);
  protected List<String> Io = new ArrayList(5);
  protected List<String> Ip = new ArrayList(5);
  List<oidb_0x496.RobotSubscribeCategory> Iq = new ArrayList();
  private acfd a;
  public boolean cSn;
  private boolean cSo;
  protected String cro;
  public String crp;
  public String crq;
  public String crr;
  public String crs;
  private String crt = "";
  private String cru = "";
  private String crv;
  protected int dVX = 60000;
  public WeakReference<aptw.b> ij;
  protected AppInterface mApp;
  protected Handler mUIHandler = new Handler(Looper.getMainLooper());
  protected ArrayMap<Long, ArrayList<aptv>> n = new ArrayMap(20);
  protected ArrayMap<Long, ArrayList<aptv>> o = new ArrayMap(50);
  protected HashMap<Long, MessageForUniteGrayTip> oE = new HashMap();
  private HashMap<String, ArrayList<String>> oF = new HashMap();
  HashMap<String, Long> oG = new HashMap();
  protected ArrayMap<Long, Integer> p = new ArrayMap(50);
  
  public aptw(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.Io.add(acfp.m(2131716116));
    this.Ip.add(acfp.m(2131716102));
    ThreadManager.post(new TroopRobotManager.1(this), 5, null, true);
    ebM();
  }
  
  private void Sh(boolean paramBoolean)
  {
    this.cSn = paramBoolean;
    this.mUIHandler.post(new TroopRobotManager.3(this));
  }
  
  private void TX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = null;
      if ((this.mApp instanceof QQAppInterface)) {
        localQQAppInterface = (QQAppInterface)this.mApp;
      }
    } while (localQQAppInterface == null);
    aqmj.f(localQQAppInterface.getApplication(), localQQAppInterface.getCurrentUin(), paramString, false);
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    be(paramMessageRecord.frienduin, paramString1, paramString2);
    b(Long.parseLong(paramMessageRecord.frienduin), Long.parseLong(paramString1), paramString3, new apub(this, paramString3));
  }
  
  public static boolean a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    String str1 = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
    if (!TextUtils.isEmpty(str1))
    {
      paramTextView.setText(paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description"));
      paramTextView.append("\r\n");
      String str2 = acfp.m(2131716104);
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new apty(str1, paramMessageRecord), 0, str2.length(), 33);
      paramTextView.append(localSpannableString);
      bool = true;
    }
    return bool;
  }
  
  public static void aI(MessageRecord paramMessageRecord)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.msg))
    {
      Object localObject = aqjb.WEB_URL.matcher(paramMessageRecord.msg);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group(0);
        int i = paramMessageRecord.msg.indexOf((String)localObject);
        if (i >= 0)
        {
          String str = paramMessageRecord.msg.substring(0, i);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_url", (String)localObject);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_description", str);
          paramMessageRecord.saveExtInfoToExtStr("robot_processed", "true");
        }
      }
    }
  }
  
  public static boolean bg(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public static boolean bi(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_processed");
    return (!TextUtils.isEmpty(paramMessageRecord)) && (paramMessageRecord.equals("true"));
  }
  
  private void ebM()
  {
    if ((this.a != null) || (this.mApp == null) || (!(this.mApp instanceof QQAppInterface))) {
      return;
    }
    this.a = new aptz(this);
    this.mApp.addObserver(this.a);
  }
  
  private void ebN()
  {
    if ((this.a != null) && (this.mApp != null))
    {
      this.mApp.removeObserver(this.a);
      this.a = null;
    }
  }
  
  private void ebP()
  {
    Object localObject1 = aqmj.W(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        this.oF.clear();
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 != null)
          {
            String str = ((JSONObject)localObject3).optString("robotUin");
            localObject3 = ((JSONObject)localObject3).optJSONArray("barItem");
            if ((!TextUtils.isEmpty(str)) && (localObject3 != null))
            {
              ArrayList localArrayList = new ArrayList(((JSONArray)localObject3).length());
              int j = 0;
              while (j < ((JSONArray)localObject3).length())
              {
                localArrayList.add(((JSONArray)localObject3).optString(j));
                j += 1;
              }
              this.oF.put(str, localArrayList);
            }
          }
          i += 1;
        }
        localObject2 = aqmj.X(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.crt = ((JSONObject)localObject2).optString("userTail");
      this.cru = ((JSONObject)localObject2).optString("robotTail");
      localObject2 = aesq.a();
      if (localObject2 != null) {
        aR(((aesq)localObject2).ahz(), ((aesq)localObject2).tK());
      }
      return;
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
  
  private void ep(QQAppInterface paramQQAppInterface)
  {
    synchronized (sLock)
    {
      if (this.Cq == null)
      {
        QLog.d("TroopRobotManager", 2, "initRobotRedInRedList ");
        this.Cq = aprg.k(paramQQAppInterface);
        if (this.Cq == null) {
          this.Cq = new ArrayList();
        }
      }
      return;
    }
  }
  
  private void f(MessageRecord paramMessageRecord, String paramString)
  {
    SharedPreferences localSharedPreferences = this.mApp.getApp().getSharedPreferences("robot_subcribmsg_timestamp", 0);
    long l;
    if (!this.oG.containsKey(paramString))
    {
      l = localSharedPreferences.getLong(paramString, 0L);
      this.oG.put(paramString, Long.valueOf(l));
    }
    for (;;)
    {
      if (paramMessageRecord.shmsgseq > ((Long)this.oG.get(paramString)).longValue())
      {
        localSharedPreferences.edit().putLong(paramString, paramMessageRecord.shmsgseq).commit();
        this.oG.put(paramString, Long.valueOf(paramMessageRecord.shmsgseq));
      }
      return;
      l = Math.max(((Long)this.oG.get(paramString)).longValue(), localSharedPreferences.getLong(paramString, 0L));
      localSharedPreferences.edit().putLong(paramString, l).commit();
      this.oG.put(paramString, Long.valueOf(l));
    }
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(null, "dc00899", "Grp_robot", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static String x(MessageRecord paramMessageRecord)
  {
    if (bg(paramMessageRecord))
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMessageRecord))) {
        return paramMessageRecord + acfp.m(2131716112);
      }
    }
    return null;
  }
  
  public aptu a(long paramLong)
  {
    aptu localaptu = new aptu();
    localaptu.Co = q(paramLong);
    localaptu.Cp = r(paramLong);
    localaptu.dVT = af(paramLong);
    return localaptu;
  }
  
  public oidb_0x496.RobotSubscribeCategory a(int paramInt)
  {
    Iterator localIterator = this.Iq.iterator();
    while (localIterator.hasNext())
    {
      oidb_0x496.RobotSubscribeCategory localRobotSubscribeCategory = (oidb_0x496.RobotSubscribeCategory)localIterator.next();
      if (localRobotSubscribeCategory.id.get() == paramInt) {
        return localRobotSubscribeCategory;
      }
    }
    return null;
  }
  
  public String a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    return "";
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, aptw.a parama)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt1, true);
    localReqBody.version.set(paramInt2, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.robot_uin.set(paramLong2);
    jnm.a((QQAppInterface)this.mApp, new apuc(this, parama), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString, aptw.a parama)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.keyword.set(paramString, true);
    localReqBody.robot_uin.set(paramLong2);
    jnm.a((QQAppInterface)this.mApp, new apud(this, parama), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void a(long paramLong, int paramInt, aptw.a parama)
  {
    a(4, 0L, paramLong, paramInt, parama);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, aptw.a parama)
  {
    a(1, paramLong1, paramLong2, paramInt, parama);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, aptw.a parama)
  {
    a(3, paramLong1, paramLong2, paramString, parama);
  }
  
  public void a(long paramLong, String paramString, aptw.a parama)
  {
    a(Long.valueOf("1").longValue(), paramLong, paramString, parama);
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, EditText paramEditText, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString)
  {
    String str = aqgv.h(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
    paramEditText = appb.a(paramQQAppInterface, paramContext, paramSessionInfo.aTl, paramChatMessage.senderuin, str, false, paramEditText, true, true);
    paramContext = new ArrayList();
    paramEditText = appb.a(paramEditText, paramContext);
    paramSessionInfo = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    try
    {
      int i = Integer.parseInt(paramSessionInfo);
      paramBaseChatPie.b(paramEditText + " " + paramString, paramContext, i);
      new anov(paramQQAppInterface).a("dc00899").b("Grp_robot").c("sub_page").d("next_msg_clk").a(new String[] { paramChatMessage.frienduin, paramSessionInfo }).report();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopRobotManager", 2, "parse robotNewTipsClsId error");
    }
  }
  
  public void a(aptw.b paramb)
  {
    if (paramb == null)
    {
      this.ij = null;
      return;
    }
    this.ij = new WeakReference(paramb);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, ArrayList<String> paramArrayList)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo cacheTime" + paramLong);
    }
    ep(paramQQAppInterface);
    ArrayList localArrayList;
    int i;
    label184:
    String str;
    label274:
    int j;
    synchronized (sLock)
    {
      localArrayList = aprg.l(paramQQAppInterface);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          this.Cq.clear();
          aprg.b(paramQQAppInterface, this.Cq);
          aprg.Z(paramQQAppInterface, false);
          aprg.ab(paramQQAppInterface, false);
          return;
        }
        QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo historyList " + localArrayList.size() + " uinList: " + paramArrayList.size() + " red:" + this.Cq.size());
        try
        {
          i = this.Cq.size() - 1;
          if (i >= 0)
          {
            str = (String)this.Cq.get(i);
            if (paramArrayList.contains(str)) {
              break label533;
            }
            this.Cq.remove(i);
            QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo remove red newing " + str + " index: " + i);
            break label533;
          }
          i = paramArrayList.size() - 1;
          j = k;
          if (i < 0) {
            break label407;
          }
          str = (String)paramArrayList.get(i);
          if (localArrayList.contains(str))
          {
            paramArrayList.remove(i);
            QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo remove red uinList " + str + " index: " + i);
          }
          else
          {
            localArrayList.add(str);
          }
        }
        catch (Exception paramQQAppInterface)
        {
          QLog.e("TroopRobotManager", 2, "onGetRobotRedInfo REMOVE EXCEPTION" + paramQQAppInterface.toString());
        }
        label397:
        return;
      }
    }
    for (;;)
    {
      label407:
      if (j < paramArrayList.size())
      {
        str = (String)paramArrayList.get(j);
        if (!this.Cq.contains(str))
        {
          this.Cq.add(str);
          QLog.d("TroopRobotManager", 2, "onGetRobotRedInfo add red uinList " + str + " index: " + j);
        }
      }
      else
      {
        aprg.b(paramQQAppInterface, this.Cq);
        aprg.c(paramQQAppInterface, localArrayList);
        if (paramArrayList.size() <= 0) {
          break label397;
        }
        aprg.Z(paramQQAppInterface, true);
        aprg.ab(paramQQAppInterface, true);
        break label397;
        break;
        i -= 1;
        break label184;
        i -= 1;
        break label274;
      }
      label533:
      j += 1;
    }
  }
  
  public void a(oidb_0x496.Robot paramRobot)
  {
    try
    {
      int i;
      if (paramRobot.uin_range.has())
      {
        this.Im.clear();
        i = 0;
        while ((i < paramRobot.uin_range.size()) && (i < 5))
        {
          oidb_0x496.UinRange localUinRange = (oidb_0x496.UinRange)paramRobot.uin_range.get(i);
          aptw.c localc = new aptw.c();
          localc.asd = localUinRange.start_uin.get();
          localc.ase = localUinRange.end_uin.get();
          this.Im.add(localc);
          i += 1;
        }
      }
      if (paramRobot.fire_keywords.has())
      {
        this.In.clear();
        i = 0;
        while ((i < paramRobot.fire_keywords.size()) && (i < 5))
        {
          this.In.add(paramRobot.fire_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.start_keywords.has())
      {
        this.Io.clear();
        i = 0;
        while ((i < paramRobot.start_keywords.size()) && (i < 5))
        {
          this.Io.add(paramRobot.start_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.end_keywords.has())
      {
        this.Ip.clear();
        i = 0;
        while ((i < paramRobot.end_keywords.size()) && (i < 5))
        {
          this.Ip.add(paramRobot.end_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.session_timeout.has()) {
        this.dVX = paramRobot.session_timeout.get();
      }
      if (paramRobot.subscribe_categories.has())
      {
        this.Iq.clear();
        this.Iq.addAll(paramRobot.subscribe_categories.get());
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopRobotManager", 2, "setRobotConfig " + this.Im.toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, cmd0x934.RspBody paramRspBody)
  {
    ThreadManager.post(new TroopRobotManager.7(this, paramString1, paramString2, paramRspBody), 5, null, true);
  }
  
  public boolean aBy()
  {
    return this.cSn;
  }
  
  public boolean aBz()
  {
    return this.cSo;
  }
  
  public void aL(long paramLong1, long paramLong2)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)this.oE.remove(Long.valueOf(paramLong1));
    if (localMessageForUniteGrayTip != null)
    {
      localMessageForUniteGrayTip.shmsgseq = paramLong2;
      ahwb.a((QQAppInterface)this.mApp, localMessageForUniteGrayTip);
    }
  }
  
  public void aR(boolean paramBoolean, String paramString)
  {
    this.cSo = paramBoolean;
    this.crv = paramString;
  }
  
  public int af(long paramLong)
  {
    int i = 0;
    if (this.p != null) {
      synchronized (this.p)
      {
        if (this.p.containsKey(Long.valueOf(paramLong))) {
          i = ((Integer)this.p.get(Long.valueOf(paramLong))).intValue();
        }
        return i;
      }
    }
    return 0;
  }
  
  public byte[] ay()
  {
    return aqhq.fileToBytes(BaseApplication.getContext().getFileStreamPath("troop_robot_config"));
  }
  
  public void b(int paramInt, long paramLong1, long paramLong2, String paramString, aptw.a parama)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.keyword.set(paramString, true);
    localReqBody.robot_uin.set(paramLong2);
    jnm.a((QQAppInterface)this.mApp, new aptx(this, parama), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void b(long paramLong1, long paramLong2, String paramString, aptw.a parama)
  {
    b(2, paramLong1, paramLong2, paramString, parama);
  }
  
  public void b(long paramLong, String paramString, aptw.a parama)
  {
    b(2, Long.valueOf("1").longValue(), paramLong, paramString, parama);
  }
  
  public void b(oidb_0x496.Robot paramRobot)
  {
    ThreadManager.post(new TroopRobotManager.6(this, paramRobot), 5, null, true);
  }
  
  public void bP(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("robot_aio_bar");
    if (localJSONArray != null) {
      aqmj.S(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), localJSONArray.toString());
    }
    paramJSONObject = paramJSONObject.optJSONObject("robot_voice_tail");
    if (paramJSONObject != null) {
      aqmj.T(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramJSONObject.toString());
    }
    ebP();
  }
  
  public void ba(QQAppInterface paramQQAppInterface, String paramString)
  {
    ep(paramQQAppInterface);
    synchronized (sLock)
    {
      if ((this.Cq != null) && (this.Cq.contains(paramString))) {
        this.Cq.remove(paramString);
      }
      aprg.b(paramQQAppInterface, this.Cq);
      QLog.d("TroopRobotManager", 2, "removeRobotRedUinInRed " + paramString);
      return;
    }
  }
  
  public void bd(String paramString1, String paramString2, String paramString3)
  {
    if ((this.crq == null) || (!TextUtils.isEmpty(paramString1))) {}
    try
    {
      b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new apua(this, paramString3));
      ebO();
      this.mUIHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        QLog.e("TroopRobotManager", 2, "release exception, troopuin:" + paramString1 + " robotuin:" + paramString2);
      }
    }
  }
  
  public void be(String paramString1, String paramString2, String paramString3)
  {
    this.crp = paramString2;
    this.crq = paramString3;
    this.crr = paramString1;
    Sh(true);
  }
  
  public boolean bf(MessageRecord paramMessageRecord)
  {
    boolean bool3 = true;
    int j = 0;
    boolean bool2 = false;
    boolean bool1;
    if ((!qY(paramMessageRecord.frienduin)) || (paramMessageRecord.mRobotFlag == -1)) {
      bool1 = false;
    }
    Object localObject;
    label187:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramMessageRecord.mRobotFlag == 1);
              localObject = ((HotChatManager)this.mApp.getManager(60)).a(paramMessageRecord.frienduin);
              if ((localObject == null) || (!((HotChatInfo)localObject).isRobotHotChat)) {
                break label187;
              }
              if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForReplyText)) || ((paramMessageRecord instanceof MessageForPtt))) {
                break;
              }
              bool1 = bool3;
            } while (!(paramMessageRecord instanceof MessageForMixedMsg));
            bool1 = bool3;
          } while (paramMessageRecord.atInfoList == null);
          bool1 = bool3;
        } while (paramMessageRecord.atInfoList.size() <= 0);
        i = 0;
        for (;;)
        {
          bool1 = bool2;
          if (i < paramMessageRecord.atInfoList.size())
          {
            if (cR(((MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin)) {
              bool1 = true;
            }
          }
          else {
            return bool1;
          }
          i += 1;
        }
        if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForReplyText)) && (!(paramMessageRecord instanceof MessageForPtt)) && (!(paramMessageRecord instanceof MessageForMixedMsg))) {
          break label1098;
        }
        if (this.crq == null) {
          break;
        }
        bool1 = bool3;
      } while (paramMessageRecord.atInfoList == null);
      bool1 = bool3;
    } while (paramMessageRecord.atInfoList.size() <= 0);
    int i = 0;
    for (;;)
    {
      bool1 = bool3;
      if (i >= paramMessageRecord.atInfoList.size()) {
        break;
      }
      if (cR(((MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i)).uin))
      {
        bool1 = bool3;
        if ((paramMessageRecord instanceof MessageForPtt)) {
          break;
        }
        bool1 = bool3;
        if ((paramMessageRecord instanceof MessageForMixedMsg)) {
          break;
        }
        localObject = paramMessageRecord.msg.replace("@" + this.crq + " ", "").replace("@" + this.crq, "");
        i = j;
        for (;;)
        {
          bool1 = bool3;
          if (i >= this.Ip.size()) {
            break;
          }
          if (((String)localObject).equals(((String)this.Ip.get(i)).replace("$ROBOTNICK$", this.crq)))
          {
            bd(paramMessageRecord.frienduin, this.crp, (String)this.Ip.get(i));
            return true;
          }
          i += 1;
        }
      }
      i += 1;
    }
    String str1;
    if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
    {
      i = 0;
      for (;;)
      {
        if (i >= paramMessageRecord.atInfoList.size()) {
          break label880;
        }
        localObject = (MessageForText.AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i);
        if (cR(((MessageForText.AtTroopMemberInfo)localObject).uin))
        {
          this.cro = (((MessageForText.AtTroopMemberInfo)localObject).uin + "");
          str1 = aqgv.h((QQAppInterface)this.mApp, paramMessageRecord.frienduin, "" + ((MessageForText.AtTroopMemberInfo)localObject).uin);
          BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).edit().putString("troopuin_" + paramMessageRecord.frienduin, str1).commit();
          bool1 = bool3;
          if ((paramMessageRecord instanceof MessageForPtt)) {
            break;
          }
          bool1 = bool3;
          if ((paramMessageRecord instanceof MessageForMixedMsg)) {
            break;
          }
          String str2 = paramMessageRecord.msg.replace("@" + str1 + " ", "").replace("@" + str1, "");
          j = 0;
          for (;;)
          {
            bool1 = bool3;
            if (j >= this.Io.size()) {
              break;
            }
            if (str2.equals(((String)this.Io.get(j)).replace("$ROBOTNICK$", str1)))
            {
              a(paramMessageRecord, "" + ((MessageForText.AtTroopMemberInfo)localObject).uin, str1, (String)this.Io.get(j));
              anot.a((QQAppInterface)this.mApp, "dc00899", "Grp_robot", "", "msg", "conti_dialog_msg", 0, 0, paramMessageRecord.frienduin, this.cro, (String)this.Io.get(i), "");
              return true;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    label880:
    if (((paramMessageRecord instanceof MessageForPtt)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
      return false;
    }
    i = 0;
    while (i < this.In.size())
    {
      localObject = BaseApplication.getContext().getSharedPreferences("troop_robot_nickname", 0).getString("troopuin_" + paramMessageRecord.frienduin, this.crq);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((String)localObject).toUpperCase().replaceAll(" ", ""))
      {
        localObject = ((String)this.In.get(i)).replace("$ROBOTNICK$", (CharSequence)localObject);
        str1 = paramMessageRecord.msg.toUpperCase().replaceAll(" ", "");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!str1.contains((CharSequence)localObject))) {
          break;
        }
        anot.a((QQAppInterface)this.mApp, "dc00899", "Grp_robot", "", "msg", "keyword_msg", 0, 0, paramMessageRecord.frienduin, this.cro, (String)this.In.get(i), "");
        return true;
      }
      i += 1;
    }
    label1098:
    return false;
  }
  
  public boolean bh(MessageRecord paramMessageRecord)
  {
    if (!gM(paramMessageRecord.senderuin)) {}
    String str;
    do
    {
      return false;
      str = w(paramMessageRecord);
    } while (TextUtils.isEmpty(str));
    f(paramMessageRecord, str);
    if (paramMessageRecord.shmsgseq == ((Long)this.oG.get(str)).longValue()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void c(long paramLong, ArrayList<aptv> arg3, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetAllRobot ").append(paramLong).append(" ");
      if (??? != null) {
        break label138;
      }
      ??? = "null";
    }
    for (;;)
    {
      QLog.d("TroopRobotManager", 2, (String)??? + " " + paramInt);
      if ((??? != null) && (this.o != null)) {}
      synchronized (this.o)
      {
        this.o.put(Long.valueOf(paramLong), ???);
        if (this.p == null) {}
      }
      synchronized (this.p)
      {
        this.p.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
        return;
        label138:
        ??? = ???.toString();
        continue;
        ??? = finally;
        throw ???;
      }
    }
  }
  
  public boolean c(Context paramContext, String paramString, long paramLong)
  {
    if (cR(paramLong))
    {
      aprg.H(paramContext, paramString, String.valueOf(paramLong));
      return true;
    }
    return false;
  }
  
  public boolean cR(long paramLong)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.Im.size())
      {
        aptw.c localc = (aptw.c)this.Im.get(i);
        if ((localc != null) && (paramLong >= localc.asd) && (paramLong <= localc.ase)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (!aprg.X(paramQQAppInterface, paramString2))
    {
      QLog.d("TroopRobotManager", 2, "isRobotUinNeedShowRed RobotRed ：" + paramString1 + " role not show red in troop:" + paramString2);
      return false;
    }
    ep(paramQQAppInterface);
    paramQQAppInterface = sLock;
    boolean bool1 = bool2;
    try
    {
      if (this.Cq != null)
      {
        bool1 = bool2;
        if (this.Cq.contains(paramString1)) {
          bool1 = true;
        }
      }
      QLog.d("TroopRobotManager", 2, "isRobotUinNeedShowRed RobotRed ：" + paramString1 + " " + bool1);
      return bool1;
    }
    finally {}
  }
  
  public void ebO()
  {
    this.crp = null;
    this.crq = null;
    this.crr = null;
    Sh(false);
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public int g(ChatMessage paramChatMessage)
  {
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("robot_news_class_id");
    int i = 0;
    if (!TextUtils.isEmpty(paramChatMessage)) {}
    try
    {
      i = Integer.parseInt(paramChatMessage);
      return i;
    }
    catch (Exception paramChatMessage) {}
    return 0;
  }
  
  public boolean gM(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return cR(l);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopRobotManager", 2, QLog.getStackTraceString(paramString));
      }
    }
    return false;
  }
  
  public byte[] i(String paramString1, String paramString2)
  {
    return aqhq.fileToBytes(BaseApplication.getContext().getFileStreamPath("troop_robot_panel_data_" + paramString1 + "_" + paramString2));
  }
  
  public void ie(String paramString1, String paramString2)
  {
    be("1", paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "TroopRobotManager: onDestroy");
    }
    ebN();
  }
  
  public void p(long paramLong, ArrayList<aptv> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetAddedRobot ").append(paramLong).append(" ");
      if (paramArrayList != null) {
        break label94;
      }
      ??? = "null";
    }
    for (;;)
    {
      QLog.d("TroopRobotManager", 2, (String)???);
      if ((paramArrayList != null) && (this.o != null)) {}
      synchronized (this.n)
      {
        this.n.put(Long.valueOf(paramLong), paramArrayList);
        return;
        label94:
        ??? = paramArrayList.toString();
      }
    }
  }
  
  public ArrayList<aptv> q(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    if (this.o != null) {
      synchronized (this.o)
      {
        if (this.o.containsKey(Long.valueOf(paramLong)))
        {
          Iterator localIterator = ((ArrayList)this.o.get(Long.valueOf(paramLong))).iterator();
          while (localIterator.hasNext())
          {
            aptv localaptv = (aptv)localIterator.next();
            if (localaptv.isAdded()) {
              localArrayList.add(localaptv);
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public boolean qY(String paramString)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.mApp.getManager(60)).a(paramString);
    if (localHotChatInfo != null) {
      return localHotChatInfo.isRobotHotChat;
    }
    paramString = ((TroopManager)this.mApp.getManager(52)).b(paramString);
    return (paramString != null) && ((paramString.dwAppPrivilegeFlag & 0x10000000) != 0L);
  }
  
  public ArrayList<aptv> r(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    if (this.o != null) {
      synchronized (this.o)
      {
        if (this.o.containsKey(Long.valueOf(paramLong)))
        {
          Iterator localIterator = ((ArrayList)this.o.get(Long.valueOf(paramLong))).iterator();
          while (localIterator.hasNext())
          {
            aptv localaptv = (aptv)localIterator.next();
            if (!localaptv.isAdded()) {
              localArrayList.add(localaptv);
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void s(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotManager", 2, "onSetTroopRobot troopuin:" + paramLong1 + " robotuin:" + paramLong2 + " status:" + paramInt);
    }
    if (this.o != null) {
      for (;;)
      {
        synchronized (this.o)
        {
          if (this.o.containsKey(Long.valueOf(paramLong1)))
          {
            ArrayList localArrayList = (ArrayList)this.o.get(Long.valueOf(paramLong1));
            Object localObject4 = null;
            Object localObject1 = localArrayList.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label245;
            }
            aptv localaptv = (aptv)((Iterator)localObject1).next();
            if (localaptv.getUin() != paramLong2) {
              continue;
            }
            localObject1 = localObject4;
            if (!localaptv.isAdded())
            {
              localObject1 = localObject4;
              if (paramInt == 1) {
                localObject1 = localaptv;
              }
            }
            localaptv.setStatus(paramInt);
            if (localObject1 != null)
            {
              localArrayList.remove(localObject1);
              localArrayList.add(0, localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("TroopRobotManager", 2, "onSetTroopRobot move position " + ((aptv)localObject1).getUin());
              }
            }
          }
          return;
        }
        label245:
        Object localObject3 = null;
      }
    }
  }
  
  public String tK()
  {
    return this.crv;
  }
  
  public String w(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
    return paramMessageRecord.frienduin + "_" + str;
  }
  
  public boolean x(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    paramString2 = aqgv.h((QQAppInterface)this.mApp, paramString3, "" + paramString2);
    paramString1 = paramString1.replace("@" + paramString2 + " ", "").replace("@" + paramString2, "");
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.Io.size())
      {
        if (paramString1.equals(((String)this.Io.get(i)).replace("$ROBOTNICK$", paramString2))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean y(String paramString1, String paramString2, String paramString3)
  {
    if ((!aBy()) || (this.crq == null)) {}
    for (;;)
    {
      return false;
      paramString1 = paramString1.replace("@" + this.crq + " ", "").replace("@" + this.crq, "");
      int i = 0;
      while (i < this.Ip.size())
      {
        if (paramString1.equals(((String)this.Ip.get(i)).replace("$ROBOTNICK$", this.crq))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, cmd0x934.RspBody paramRspBody);
  }
  
  public static abstract interface b
  {
    public abstract void V(String paramString1, String paramString2, boolean paramBoolean);
  }
  
  public static class c
  {
    public long asd;
    public long ase;
    
    public String toString()
    {
      return " s:" + this.asd + " e:" + this.ase;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptw
 * JD-Core Version:    0.7.0.1
 */