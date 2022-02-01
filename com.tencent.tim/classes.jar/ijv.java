import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class ijv
  extends EffectConfigBase<FaceItem>
  implements ijt.a, ijy.a
{
  public static final String Nm = igg.gu() + 176 + File.separator;
  private String Nn;
  private String No;
  private MagicFaceDataEntity jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
  ijv.b jdField_a_of_type_Ijv$b = new ijv.b();
  private ijy.b jdField_a_of_type_Ijy$b;
  private ikb jdField_a_of_type_Ikb = new ikb();
  private ArrayList<String> il = new ArrayList();
  private ArrayList<ijv.a> im = new ArrayList();
  private boolean mIsSend;
  private ikt mSupportManager;
  private Queue<MagicFaceDataEntity> queue = new ArrayBlockingQueue(8);
  
  public ijv(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private MagicFaceDataEntity a(FaceItem paramFaceItem, String paramString, boolean paramBoolean, int paramInt)
  {
    String str1 = null;
    String str2;
    if (paramFaceItem != null)
    {
      igd.aJ(this.TAG, String.format("createMagicEntity: id=%s, senderType%s.", new Object[] { paramFaceItem.getId(), Integer.valueOf(paramInt) }));
      str1 = paramFaceItem.getId();
      str2 = paramFaceItem.getType();
      if (!"multi_result".equalsIgnoreCase(paramFaceItem.getAttr())) {
        break label100;
      }
      paramString = new ijx(this.mApp, str1, str2, paramString, paramBoolean, paramInt);
    }
    for (;;)
    {
      paramFaceItem.lastPositionIndex = paramString.cq(paramFaceItem.lastPositionIndex);
      str1 = paramString;
      return str1;
      label100:
      if ("huanlian".equalsIgnoreCase(paramFaceItem.getAttr())) {
        paramString = new iwk(this.mApp, str1, str2, paramString, paramBoolean, paramInt);
      } else {
        paramString = new MagicFaceDataEntity(this.mApp, str1, str2, paramString, paramBoolean, paramInt);
      }
    }
  }
  
  private MagicFaceDataEntity a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    paramString = (FaceItem)a(paramString);
    if (paramString != null)
    {
      Object localObject = b(paramString);
      localObject = new File((String)localObject + "config.json");
      if (((File)localObject).exists())
      {
        localObject = aqhq.readFileContent((File)localObject);
        if (!this.mApp.b().b().PT) {
          bool = true;
        }
        if (paramBoolean) {}
        for (;;)
        {
          return a(paramString, (String)localObject, bool, i);
          i = 2;
        }
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add("config.json");
      this.jdField_a_of_type_Ijr.a(paramString, a(paramString), b(paramString), localArrayList, false);
      igd.aL(this.TAG, "prepareEntity FILE not exist: " + ((File)localObject).getPath());
    }
    return null;
  }
  
  private void a(long paramLong, MagicFaceDataEntity paramMagicFaceDataEntity, ijy.b paramb)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = paramMagicFaceDataEntity;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null)
    {
      FaceItem localFaceItem = (FaceItem)a(paramMagicFaceDataEntity.getId());
      if (localFaceItem != null)
      {
        String str = b(localFaceItem);
        if (!TextUtils.isEmpty(str))
        {
          if ((localFaceItem.isSameType("voicesticker")) || (localFaceItem.isSameType("face"))) {
            irk.a().pause(2);
          }
          this.jdField_a_of_type_Ikb.a(paramLong, str, paramMagicFaceDataEntity, paramb, this);
        }
      }
    }
  }
  
  private boolean al(long paramLong)
  {
    if (this.queue.size() > 0)
    {
      MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.queue.remove();
      if (AudioHelper.aCz()) {
        QLog.w(this.TAG, 1, "playItemFromQueueHead, id[" + localMagicFaceDataEntity + "], seq[" + paramLong + "]");
      }
      a(paramLong, localMagicFaceDataEntity, this.jdField_a_of_type_Ijy$b);
      d(paramLong, localMagicFaceDataEntity.getId());
      if (localMagicFaceDataEntity.isPersistent())
      {
        a(paramLong, 6102, null, null);
        this.Nn = null;
      }
      return true;
    }
    return false;
  }
  
  private void iH(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "sendStartCreativeCopMsg, id[" + paramString + "]");
    }
    VideoController localVideoController = this.mApp.b();
    AVFunChat.AVFunChatMessage localAVFunChatMessage = new AVFunChat.AVFunChatMessage();
    localAVFunChatMessage.uint64_type.set(14L);
    localAVFunChatMessage.enum_operator.set(1);
    PBStringField localPBStringField = localAVFunChatMessage.str_msg;
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    localPBStringField.set(str);
    localVideoController.a(14, localAVFunChatMessage);
  }
  
  private void iI(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "sendStopCreativeCopMsg, id[" + paramString + "]");
    }
    VideoController localVideoController = this.mApp.b();
    AVFunChat.AVFunChatMessage localAVFunChatMessage = new AVFunChat.AVFunChatMessage();
    localAVFunChatMessage.uint64_type.set(14L);
    localAVFunChatMessage.enum_operator.set(0);
    PBStringField localPBStringField = localAVFunChatMessage.str_msg;
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    localPBStringField.set(str);
    localVideoController.a(14, localAVFunChatMessage);
  }
  
  private void iJ(String paramString)
  {
    paramString = (FaceItem)a(paramString);
    int i;
    if (paramString != null)
    {
      if (!paramString.isInteract()) {
        break label90;
      }
      i = 3;
      if (!paramString.isSameType("voicesticker")) {
        break label63;
      }
      paramString = "VSTART_" + paramString.getId();
    }
    for (;;)
    {
      i(i, paramString);
      return;
      label63:
      paramString = "START_" + paramString.getId();
      continue;
      label90:
      i = 1;
      paramString = paramString.getId();
    }
  }
  
  private void iK(String paramString)
  {
    int j = 3;
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "START_0";
      i = 3;
      paramString = (FaceItem)a(paramString);
      if (paramString == null) {
        break label93;
      }
      if (!paramString.isInteract()) {
        break label82;
      }
      str = "STOP" + paramString.getId();
      i = j;
    }
    label82:
    label93:
    for (;;)
    {
      i(i, str);
      return;
      str = "0";
      i = 1;
      break;
      str = paramString.getId();
      i = 1;
    }
  }
  
  private int kQ()
  {
    int j = 0;
    VideoController localVideoController = this.mApp.b();
    iiv localiiv = localVideoController.b();
    int i = localVideoController.getPeerTerminalType(localiiv.peerUin);
    if ((i == 2) || (i == 3) || (i == 4))
    {
      i = 1;
      if (i != 0) {
        break label59;
      }
      i = 1;
    }
    label59:
    int k;
    do
    {
      return i;
      i = 0;
      break;
      k = localVideoController.getPeerSdkVersion(localiiv.peerUin);
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "checkPeerCreativeSupport peerSharpVersion:=" + k);
      }
      i = j;
    } while (k > 105);
    return 2;
  }
  
  public void U(String paramString, boolean paramBoolean)
  {
    super.U(paramString, paramBoolean);
    if ((paramBoolean) && (paramString.equals(this.mApp.b().b().peerUin))) {
      this.Nn = null;
    }
  }
  
  public void Y(int paramInt, String paramString)
  {
    long l = AudioHelper.hG();
    boolean bool;
    if (paramInt == 3003) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 2, "MuteByOthers, seq[" + l + "], fromMuteKey[" + paramInt + "], data[" + paramString + "], mute[" + bool + "]");
      }
      if (bool)
      {
        this.mApp.l(new Object[] { Integer.valueOf(134) });
        a(0, null, true);
        if (this.queue != null) {
          this.queue.clear();
        }
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
        this.No = null;
        d(l, null);
        if (this.jdField_a_of_type_Ikb.isPlaying()) {
          this.jdField_a_of_type_Ikb.anm();
        }
      }
      return;
      if (paramInt == 3002) {
        bool = false;
      } else if (paramInt == 3001) {
        bool = true;
      } else if (paramInt == 3004) {
        bool = true;
      } else if (paramInt == 3005) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public FaceItem a()
  {
    if ((this.b != null) && (((FaceItem)this.b).isSameType("creativecop"))) {
      return (FaceItem)this.b;
    }
    return null;
  }
  
  public FaceItem a(String paramString)
  {
    List localList = y("voicesticker");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if (((FaceItem)localList.get(i)).voice_text != null)
        {
          int j = 0;
          while (j < ((FaceItem)localList.get(i)).voice_text.length)
          {
            if (TextUtils.equals(paramString, ((FaceItem)localList.get(i)).voice_text[j])) {
              return (FaceItem)localList.get(i);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public ijv.b a()
  {
    return this.jdField_a_of_type_Ijv$b;
  }
  
  public Class<?> a()
  {
    return FaceItem.class;
  }
  
  public List<FaceItem> a(int paramInt, String paramString)
  {
    int j = 0;
    int i = 0;
    try
    {
      Object localObject1 = new JSONObject(paramString);
      Object localObject2;
      if (paramInt == 176)
      {
        if ((QLog.isColorLevel()) && (((JSONObject)localObject1).has("version"))) {
          QLog.d(this.TAG, 2, "parseConfig： version=" + ((JSONObject)localObject1).getString("version"));
        }
        if (((JSONObject)localObject1).has("black_list"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("black_list");
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getString(i);
            this.il.add(localObject2);
            i += 1;
          }
        }
      }
      else if (paramInt == 370)
      {
        if (((JSONObject)localObject1).has("blessingTips"))
        {
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
          ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT+8"));
          JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("blessingTips");
          i = j;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            ijv.a locala = new ijv.a();
            locala.id = localJSONObject.optString("id");
            if (localJSONObject.has("start_date")) {
              locala.lu = ((SimpleDateFormat)localObject2).parse(localJSONObject.optString("start_date")).getTime();
            }
            if (localJSONObject.has("end_date")) {
              locala.lv = ((SimpleDateFormat)localObject2).parse(localJSONObject.optString("end_date")).getTime();
            }
            if (localJSONObject.has("text")) {
              locala.text = localJSONObject.getString("text");
            }
            if (localJSONObject.has("image_url")) {
              locala.imageUrl = localJSONObject.getString("image_url");
            }
            if (localJSONObject.has("call_time_len")) {
              locala.anP = localJSONObject.getInt("call_time_len");
            }
            if (localJSONObject.has("show_time_len")) {
              locala.anQ = localJSONObject.getInt("show_time_len");
            }
            this.im.add(locala);
            QLog.w(this.TAG, 1, "parseConfig, blessingTips[" + locala + "]");
            i += 1;
          }
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("triggerTips");
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Ijv$b.anR = ((JSONObject)localObject1).optInt("exposure_show_time_len", 5);
          this.jdField_a_of_type_Ijv$b.anS = ((JSONObject)localObject1).optInt("exposure_call_time", 2);
          this.jdField_a_of_type_Ijv$b.anT = ((JSONObject)localObject1).optInt("click_call_time", 2);
          this.jdField_a_of_type_Ijv$b.anU = ((JSONObject)localObject1).optInt("click_show_time_len", 5);
          this.jdField_a_of_type_Ijv$b.Np = ((JSONObject)localObject1).optString("exposure_show_text", this.jdField_a_of_type_Ijv$b.Np);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return super.a(paramInt, paramString);
  }
  
  protected void a(long paramLong, int paramInt, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "notifyEvent, event[" + paramInt + "], value[" + paramObject1 + "], value2[" + paramObject2 + "], seq[" + paramLong + "]");
    }
    this.mApp.l(new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      a(paramLong, 6101, null, Boolean.valueOf(false));
      new iya.f(paramLong, "onSessionStatusChanged", 5, null).n(this.mApp);
      ijw.a(this.mApp, paramString1);
      ijw.Z(2, paramString1);
      ijw.stop(2);
      return;
    }
    a(paramLong, 6101, null, Boolean.valueOf(false));
  }
  
  void a(MagicFaceDataEntity paramMagicFaceDataEntity)
  {
    if (paramMagicFaceDataEntity == null) {
      return;
    }
    Iterator localIterator = this.queue.iterator();
    MagicFaceDataEntity localMagicFaceDataEntity;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localMagicFaceDataEntity = (MagicFaceDataEntity)localIterator.next();
    } while (!localMagicFaceDataEntity.isPersistent());
    for (;;)
    {
      this.queue.offer(paramMagicFaceDataEntity);
      if (localMagicFaceDataEntity != null)
      {
        this.queue.remove(localMagicFaceDataEntity);
        if (!paramMagicFaceDataEntity.isPersistent()) {
          this.queue.offer(localMagicFaceDataEntity);
        }
      }
      iG("addItemToQueue");
      return;
      localMagicFaceDataEntity = null;
    }
  }
  
  public boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "stop, id[" + paramString + "], reason[" + paramInt + "], isSender[" + paramBoolean + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.getId();
      if ((TextUtils.isEmpty(paramString)) || (str.equalsIgnoreCase(paramString)))
      {
        this.queue.clear();
        igd.aL(this.TAG, "stop dequeue" + paramString);
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
        if (paramBoolean) {
          iK(paramString);
        }
        d(l, null);
        if (this.jdField_a_of_type_Ikb.isPlaying())
        {
          this.jdField_a_of_type_Ikb.anm();
          igd.aL(this.TAG, "stop " + paramString + ", mStopType =" + paramInt);
        }
      }
    }
    if ((this.No != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity == null) && ((TextUtils.isEmpty(paramString)) || (this.No.equalsIgnoreCase(paramString))))
    {
      if (paramBoolean) {
        iI(null);
      }
      d(l, null);
      this.No = null;
    }
    return true;
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem)
  {
    boolean bool2 = super.a(paramLong, paramFaceItem);
    Object localObject;
    int j;
    boolean bool1;
    int i;
    if ((paramFaceItem != null) && (paramFaceItem.isSameType("creativecop")))
    {
      localObject = c(paramFaceItem);
      ((FaceItem)this.b).setDesc((String)localObject);
      anot.a(null, "CliOper", "", "", "0X800A74C", "0X800A74C", 0, 0, "", "", paramFaceItem.getId(), "");
      j = kQ();
      if (this.mSupportManager.k(3, "creative") != 1) {
        break label282;
      }
      bool1 = true;
      i = 0;
      if (j == 0) {
        break label296;
      }
      if (j != 2) {
        break label288;
      }
      i = 2131697630;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "setCurrentItem , TYPE_STR_INTERACTIVE_VIDEO seq[" + paramLong + "]" + (String)localObject + "[peerPowerSupport:=" + bool1 + "],[peerVersionSupport:=" + j);
      }
      if (i != 0) {
        iwu.b(this.mApp, 1010, i);
      }
      if (bool2)
      {
        this.ar.obtainMessage(101, this.b).sendToTarget();
        if (paramFaceItem != null)
        {
          paramFaceItem = paramFaceItem.getType();
          if ((!paramFaceItem.equalsIgnoreCase("face")) && (!paramFaceItem.equalsIgnoreCase("voicesticker")))
          {
            localObject = (ijt)this.mApp.a(12);
            if (localObject != null) {
              ((ijt)localObject).X(3003, paramFaceItem);
            }
          }
        }
      }
      return bool2;
      label282:
      bool1 = false;
      break;
      label288:
      i = 2131697629;
      continue;
      label296:
      if (!bool1) {
        i = 2131697629;
      }
    }
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem, String paramString, boolean paramBoolean, ijy.b paramb)
  {
    boolean bool2 = true;
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "start, id[" + paramString + "], curData[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity + "], isSender[" + paramBoolean + "], queue[" + this.queue.size() + "], isPlaying[" + this.jdField_a_of_type_Ikb.isPlaying() + "], mLastPendantId[" + this.Nn + "], seq[" + paramLong + "]");
    }
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (this.queue.size() >= 8) || ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.getId()))) || ((this.No != null) && (this.No.equalsIgnoreCase(paramString))))
    {
      bool1 = false;
      return bool1;
    }
    boolean bool3 = paramFaceItem.isSameType("creativecop");
    if (bool3)
    {
      this.No = paramString;
      this.mIsSend = paramBoolean;
      this.jdField_a_of_type_Ijy$b = paramb;
      if ((this.jdField_a_of_type_Ikb == null) || (!this.jdField_a_of_type_Ikb.isPlaying())) {
        break label461;
      }
      if (bool3) {
        break label547;
      }
      paramFaceItem = a(paramString, paramBoolean);
      a(paramFaceItem);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ikb.anm();
      for (;;)
      {
        label269:
        Object localObject;
        int i;
        if ((paramFaceItem != null) || (bool3))
        {
          paramb = this.Nn;
          d(paramLong, paramString);
          if ((paramFaceItem == null) || (!paramFaceItem.ty())) {
            break label505;
          }
          paramFaceItem = (ikl)this.mApp.a(2);
          localObject = (PendantItem)paramFaceItem.a();
          if ((localObject == null) || (!((PendantItem)localObject).isShow()) || (TextUtils.isEmpty(((PendantItem)localObject).getId()))) {
            break label499;
          }
          this.Nn = ((PendantItem)localObject).getId();
          localObject = (FaceItem)a();
          paramFaceItem.d(paramLong, null);
          i = 1;
        }
        for (;;)
        {
          QLog.w(this.TAG, 1, "start, step[" + i + "], mLastPendantId[" + paramb + "->" + this.Nn + "]");
          if ((!paramBoolean) || (bool3)) {
            break label516;
          }
          iJ(paramString);
          return true;
          this.No = null;
          break;
          label461:
          if (bool3) {
            break label542;
          }
          localObject = a(paramString, paramBoolean);
          paramFaceItem = (FaceItem)localObject;
          if (localObject == null) {
            break label269;
          }
          a(paramLong, (MagicFaceDataEntity)localObject, paramb);
          paramFaceItem = (FaceItem)localObject;
          break label269;
          label499:
          i = 2;
          continue;
          label505:
          i = 3;
          this.Nn = null;
        }
        label516:
        bool1 = bool2;
        if (!paramBoolean) {
          break;
        }
        bool1 = bool2;
        if (!bool3) {
          break;
        }
        iH(paramString);
        return true;
        label542:
        paramFaceItem = null;
      }
      label547:
      paramFaceItem = null;
    }
  }
  
  public ArrayList<ijv.a> aR()
  {
    return this.im;
  }
  
  public void aS(String paramString1, String paramString2)
  {
    FaceItem localFaceItem = a();
    if (localFaceItem == null) {}
    long l;
    do
    {
      return;
      l = AudioHelper.hG();
      if (AudioHelper.aCz()) {
        QLog.w(this.TAG, 1, "stop, id[" + paramString2 + "], reason[" + paramString1 + "], seq[" + l + "]");
      }
      a(l, 6101, localFaceItem.getId(), Boolean.valueOf(true));
      ijw.Z(4, paramString2);
      ijw.stop(4);
    } while (!this.mApp.ch(13));
    ((ikd)this.mApp.a(13)).o(l, "stopInteractiveVideo");
  }
  
  public void ai(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.mApp.l(new Object[] { Integer.valueOf(168), paramMessage.obj });
  }
  
  public void c(long paramLong, String paramString, boolean paramBoolean) {}
  
  protected boolean cs(String paramString)
  {
    if (iop.uR()) {
      iop.g(this.mApp);
    }
    return true;
  }
  
  public void f(long paramLong, String paramString, int paramInt)
  {
    Object localObject = (MagicFaceDataEntity)this.queue.peek();
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.getId().equalsIgnoreCase(paramString)) && (localObject != null))
    {
      bool2 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a((ijz)localObject);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.queue.size() < 8) {
          a(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity);
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (AudioHelper.aCz()) {
        QLog.w(this.TAG, 1, "onEndMagicPlay, id[" + paramString + "], reason[" + paramInt + "], cur[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity + "], next[" + localObject + "], size[" + this.queue.size() + "], needBeRestore[" + bool1 + "], mLastPendantId[" + this.Nn + "], seq[" + paramLong + "]");
      }
      iG("onEndMagicPlay.1");
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
      localObject = (FaceItem)a(paramString);
      if ((localObject != null) && ((((FaceItem)localObject).isSameType("voicesticker")) || (((FaceItem)localObject).isSameType("face")))) {
        irk.a().resume(2);
      }
      bool1 = al(paramLong);
      iG("onEndMagicPlay.2_" + bool1);
      if (!bool1)
      {
        a(paramLong, 6101, paramString, Boolean.valueOf(false));
        if (!TextUtils.isEmpty(this.Nn))
        {
          ((ikl)this.mApp.a(2)).d(paramLong, this.Nn);
          a(paramLong, 6102, null, null);
          this.Nn = null;
        }
      }
      a(paramLong, 165, Integer.valueOf(3), null);
      return;
    }
  }
  
  public String gL()
  {
    return "resources";
  }
  
  public int getConfigID()
  {
    return 176;
  }
  
  public int h(int paramInt, String paramString)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onReceivedMessageOfPeer, type[" + paramInt + "], seq[" + l + "], info[" + paramString + "]");
    String str1;
    if (paramInt == 3)
    {
      paramInt = paramString.indexOf('_');
      if (paramInt == -1) {
        return -1;
      }
      str1 = paramString.substring(0, paramInt);
      String str2 = paramString.substring(paramInt + 1, paramString.length());
      boolean bool1 = "START".equals(str1);
      boolean bool2 = "VSTART".equals(str1);
      if ((bool1) || (bool2)) {
        if ((!"0".equalsIgnoreCase(str2)) && (!"0_iOS".equalsIgnoreCase(str2)))
        {
          if (bool1) {
            a(l, 6104, paramString, null);
          }
          new iya.e(l, str2, false, 4).n(this.mApp);
          a(l, 164, Integer.valueOf(0), null);
        }
      }
    }
    for (;;)
    {
      return 0;
      a(l, 6101, null, Boolean.valueOf(false));
      continue;
      if ("STOP".equals(str1))
      {
        continue;
        if (paramInt == 1) {
          new iya.e(l, paramString, false, 4).n(this.mApp);
        }
      }
    }
  }
  
  void iG(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      paramString = paramString + "\n";
      paramString = paramString + "size :" + this.queue.size() + "\n";
      Iterator localIterator = this.queue.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)localIterator.next();
        paramString = paramString + i + ":" + localMagicFaceDataEntity + "\n";
        i += 1;
      }
      paramString = paramString + "\ncur :" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
      paramString = paramString + "\nmLastPendantId :" + this.Nn;
      QLog.w(this.TAG, 1, "printQueue, " + paramString);
    }
  }
  
  public boolean isSender()
  {
    return ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.isSender())) || ((this.No != null) && (this.mIsSend));
  }
  
  public void m(long paramLong, String paramString)
  {
    a(paramLong, 165, Integer.valueOf(2), null);
  }
  
  public void n(long paramLong, String paramString) {}
  
  public void onCreate()
  {
    super.onCreate();
    ijt localijt = (ijt)this.mApp.a(12);
    if (localijt != null) {
      localijt.a(3003, this);
    }
    this.mSupportManager = ((ikt)this.mApp.a(5));
  }
  
  public List<FaceItem> y(String paramString)
  {
    List localList = super.y(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          FaceItem localFaceItem = (FaceItem)localList.get(i);
          if (localFaceItem.isSameType(paramString)) {
            localArrayList.add(localFaceItem);
          }
          i += 1;
        }
      }
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public static class a
  {
    public int anP = 30;
    public int anQ = 3;
    public String id;
    public String imageUrl = "";
    public long lu;
    public long lv;
    public String text = "";
    
    public String toString()
    {
      return "id[" + this.id + "], text[" + this.text + "], date[" + this.lu + "->" + this.lv + "], imageUrl[" + this.imageUrl + "], callTimeLen[" + this.anP + "], showTimeLen[" + this.anQ + "]";
    }
  }
  
  public static class b
  {
    public String Np = acfp.m(2131705751);
    public int anR = 5000;
    public int anS = 2;
    public int anT = 2;
    public int anU = 5000;
    
    public String dj(String paramString)
    {
      return this.Np.replace("voicesticker", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijv
 * JD-Core Version:    0.7.0.1
 */