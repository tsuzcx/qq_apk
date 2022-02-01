import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.3;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.4;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamPicInfo;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionExpRoamTryUp;

public class afhv
  extends affy<CustomEmotionData>
{
  private afhf.a jdField_a_of_type_Afhf$a;
  private afko jdField_a_of_type_Afko = new afhz(this);
  public aooi a;
  protected aook a;
  boolean bYg = false;
  private boolean bYh;
  public AtomicInteger bj = new AtomicInteger(0);
  protected AtomicInteger bk = new AtomicInteger(0);
  private aceg c;
  public afkn c;
  public int cQX;
  protected int cQY;
  private ConcurrentHashMap<Integer, String> fh = new ConcurrentHashMap();
  WeakReference<aool> gH;
  protected Map<String, ArrayList<CustomEmotionData>> kg = new HashMap();
  
  public afhv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aook = new afhw(this, ThreadManager.getSubThreadLooper());
    this.jdField_c_of_type_Aceg = new afhx(this);
    this.jdField_c_of_type_Afkn = new afhy(this);
    this.jdField_a_of_type_Aooi = paramQQAppInterface.a();
    if (!TextUtils.isEmpty(this.uin))
    {
      int i = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("fav_roaming_max" + this.uin, 144);
      if (i > 144) {
        afhs.cQV = i;
      }
    }
  }
  
  public static afhv a(QQAppInterface paramQQAppInterface)
  {
    return (afhv)paramQQAppInterface.getManager(103);
  }
  
  private void a(String paramString, afhf.a parama)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (afhu)localQQAppInterface.getManager(149);
    List localList = ((afhu)localObject).ez();
    if (localList != null)
    {
      int j = 0;
      for (int i = 1;; i = k)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int m = localCustomEmotionData.emoId;
        if ((str != null) && (str.equals(localCustomEmotionData.md5)))
        {
          if ("needDel".equals(localCustomEmotionData.RomaingType))
          {
            ((afhu)localObject).a(localCustomEmotionData, j);
            if (parama != null) {
              parama.ck(0, str);
            }
          }
          while (parama == null) {
            return;
          }
          parama.ck(1, str);
          return;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = localQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    ((CustomEmotionData)localObject).eId = str;
    paramString = new afhf(localQQAppInterface, null, (CustomEmotionData)localObject, null, 2);
    paramString.a(parama);
    this.gH = new WeakReference(b((CustomEmotionData)localObject, paramString));
  }
  
  private void cZC()
  {
    int j = this.bj.get();
    this.bj.set(0);
    this.cQX = 0;
    int i = 0;
    while (i < this.Z.size())
    {
      if (this.Z.get(i) != null)
      {
        afic localafic = (afic)((WeakReference)this.Z.get(i)).get();
        if (localafic != null) {
          localafic.Ms(j);
        }
      }
      i += 1;
    }
    cZF();
  }
  
  private String kE(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return String.format(BaseApplicationImpl.getApplication().getString(2131693054), new Object[] { str });
  }
  
  protected int CR()
  {
    return 9;
  }
  
  public void HV(String paramString)
  {
    if (paramString == null) {
      return;
    }
    afkd.a().a(this.jdField_a_of_type_Afko);
    ((afke)this.mApp.getManager(43)).a(paramString, afke.cRu, null, false);
  }
  
  protected acdd<CustomEmotionData> a()
  {
    return (acef)this.mApp.getBusinessHandler(72);
  }
  
  protected affx<CustomEmotionData> a()
  {
    return (afhu)this.mApp.getManager(149);
  }
  
  public aool a(CustomEmotionData paramCustomEmotionData, akyf paramakyf)
  {
    if (paramCustomEmotionData == null) {}
    while (!aqiw.isNetSupport(BaseApplication.getContext())) {
      return null;
    }
    if ((!this.bYg) && (this.jdField_a_of_type_Aook != null) && (this.jdField_a_of_type_Aooi != null))
    {
      this.jdField_a_of_type_Aook.addFilter(new Class[] { aojg.class });
      this.jdField_a_of_type_Aooi.a(this.jdField_a_of_type_Aook);
      this.bYg = true;
    }
    aool localaool = new aool();
    localaool.mFileType = 24;
    localaool.dOM = 9;
    localaool.ckW = "scbqmanyou";
    localaool.mSelfUin = this.uin;
    localaool.mPeerUin = this.uin;
    localaool.cNy = true;
    if (paramakyf != null) {
      localaool.b = paramakyf;
    }
    if (paramCustomEmotionData.isMarkFace)
    {
      b(paramCustomEmotionData, localaool);
      return localaool;
    }
    a(paramCustomEmotionData, localaool);
    return localaool;
  }
  
  public String a(Integer paramInteger)
  {
    if (paramInteger == null) {
      return kE("");
    }
    return kE((String)this.fh.get(paramInteger));
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseClickNum();
    a().b(paramCustomEmotionData);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, aool paramaool)
  {
    int j = 1;
    int i = 1;
    if ((paramCustomEmotionData == null) || (paramaool == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadNoMarkFace " + paramCustomEmotionData);
    }
    cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
    Object localObject = acfi.jj(paramCustomEmotionData.emoPath);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("qto_")))
    {
      localObject = ((String)localObject).replace("qto_", "qto@");
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "upload FunnyPic name.replace->" + (String)localObject);
      }
      j = acfi.cq(paramCustomEmotionData.eId);
      if (j != 0) {
        break label353;
      }
    }
    for (;;)
    {
      localExpRoamPicInfo.uint32_pkg_id.set(i);
      for (;;)
      {
        localExpRoamPicInfo.uint32_shop_flag.set(0);
        localObject = new ArrayList();
        ((List)localObject).add(localExpRoamPicInfo);
        localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set((List)localObject);
        paramaool.gb = localExtensionExpRoamTryUp.toByteArray();
        paramaool.mUniseq = paramCustomEmotionData.emoId;
        paramaool.dQ = paramCustomEmotionData.emoPath;
        if (this.jdField_a_of_type_Aooi == null) {
          break;
        }
        this.jdField_a_of_type_Aooi.a(paramaool);
        return;
        localObject = acdx.jh(paramCustomEmotionData.emoPath);
        if (!((String)localObject).equals("")) {
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
        }
        try
        {
          i = Integer.parseInt(paramCustomEmotionData.eId);
          localExpRoamPicInfo.uint32_pkg_id.set(i);
          continue;
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom("0".getBytes()));
          localExpRoamPicInfo.uint32_pkg_id.set(0);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
      label353:
      i = j;
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, afke paramafke)
  {
    ArrayList localArrayList = (ArrayList)this.kg.get(paramEmoticonPackage.epId);
    int i;
    CustomEmotionData localCustomEmotionData;
    Emoticon localEmoticon;
    if (localArrayList != null) {
      if (paramEmoticonPackage.jobType == 0)
      {
        i = 0;
        if (i >= localArrayList.size()) {
          break label366;
        }
        localCustomEmotionData = (CustomEmotionData)localArrayList.get(i);
        if (localCustomEmotionData == null) {}
        for (;;)
        {
          i += 1;
          break;
          localEmoticon = new Emoticon();
          if (this.mApp != null) {
            break label100;
          }
          QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|app null");
          onFileDone(localCustomEmotionData, false);
        }
        label100:
        ajdg localajdg = (ajdg)this.mApp.getManager(14);
        if (localajdg == null) {
          break label367;
        }
        localEmoticon = localajdg.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
      }
    }
    label366:
    label367:
    for (;;)
    {
      if (localEmoticon == null)
      {
        QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|cannot find emoticon: epId:" + paramEmoticonPackage.epId + "，eid=" + localCustomEmotionData.eId);
        localCustomEmotionData.RomaingType = "needDel";
        ((afhu)this.mApp.getManager(149)).b(localCustomEmotionData);
        onFileDone((CustomEmotionData)localArrayList.get(i), false);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "downloadAIOEmoticon|taskvalue:" + 14 + "，epid:" + localEmoticon.epId + "，eid=" + localEmoticon.eId);
      }
      if (paramafke.a(localEmoticon, 14))
      {
        onFileDone((CustomEmotionData)localArrayList.get(i), true);
        break;
      }
      onFileDone((CustomEmotionData)localArrayList.get(i), false);
      break;
      if ((paramEmoticonPackage.jobType == 3) || (paramEmoticonPackage.jobType == 5))
      {
        afkd.a().a(this.jdField_c_of_type_Afkn);
        paramafke.a(paramEmoticonPackage, false);
      }
      return;
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, afke paramafke, ArrayList<Emoticon> paramArrayList, afkz paramafkz)
  {
    if ((!paramafkz.bYL) && (paramEmoticonPackage.jobType != 4))
    {
      int i = 0;
      int j;
      do
      {
        paramafkz.bDO = null;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
        }
        paramafke.a(paramEmoticonPackage.epId, paramArrayList, paramafkz);
        j = i + 1;
        if (paramafkz.bYL) {
          break;
        }
        i = j;
      } while (j < 3);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + paramafkz.bYL);
      }
    }
  }
  
  public void a(List<String> paramList, afhv.a parama)
  {
    if (paramList == null) {}
    int i;
    do
    {
      return;
      i = paramList.size();
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FavroamingManager", 2, "addCustomEmotions pathList is empty");
    return;
    this.bYh = false;
    ThreadManager.excute(new FavroamingManager.8(this, i, parama, paramList), 64, null, true);
  }
  
  public boolean ajn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadCount:" + this.bj.get() + ", needDownloadCount" + this.cQX + "uploadCount:" + this.bk.get() + ", needUploadCount" + this.cQY);
    }
    return (this.bj.get() == this.cQX) && (this.bk.get() == this.cQY);
  }
  
  public aool b(CustomEmotionData paramCustomEmotionData, akyf paramakyf)
  {
    return a(paramCustomEmotionData, paramakyf);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseExposeNum();
    a().b(paramCustomEmotionData);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData, aool paramaool)
  {
    if ((paramCustomEmotionData == null) || (paramaool == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadMarkFace favEmoticon.epid=" + paramCustomEmotionData.emoPath + " and eid=" + paramCustomEmotionData.eId);
    }
    if (!paramCustomEmotionData.checkMarketFace("uploadMarkFace"))
    {
      QLog.e("FavroamingManager", 1, "uploadMarkFace: marketFace is invalid");
      return;
    }
    try
    {
      cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
      cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(paramCustomEmotionData.eId.getBytes()));
      localExpRoamPicInfo.uint32_pkg_id.set(Integer.parseInt(paramCustomEmotionData.emoPath));
      localExpRoamPicInfo.uint32_shop_flag.set(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localExpRoamPicInfo);
      localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set(localArrayList);
      paramaool.gb = localExtensionExpRoamTryUp.toByteArray();
      paramaool.mUniseq = paramCustomEmotionData.getId();
      paramCustomEmotionData = afke.a(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId, false);
      paramaool.dQ = paramCustomEmotionData[1];
      ThreadManager.post(new FavroamingManager.7(this, paramCustomEmotionData, paramaool), 5, null, true);
      return;
    }
    catch (Exception paramCustomEmotionData)
    {
      QLog.e("FavroamingManager", 1, new Object[] { "uploadMarkFace error =", paramCustomEmotionData.getMessage() });
    }
  }
  
  public void b(CustomEmotionData paramCustomEmotionData, String paramString)
  {
    if ((this.mApp == null) || (paramCustomEmotionData == null)) {}
    acef localacef;
    do
    {
      return;
      localacef = (acef)a();
    } while (localacef == null);
    localacef.a(paramCustomEmotionData, paramString);
  }
  
  public void c(CustomEmotionData paramCustomEmotionData)
  {
    if ((this.mApp == null) || (paramCustomEmotionData == null)) {
      return;
    }
    a().b(paramCustomEmotionData);
    yhf.a(this.mApp).cir();
  }
  
  public void cZB()
  {
    int i = 0;
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      this.cR.set(false);
    }
    Object localObject2;
    Object localObject3;
    label197:
    do
    {
      do
      {
        return;
      } while (this.mApp == null);
      Object localObject1 = (afhu)this.mApp.getManager(149);
      localObject2 = ((afhu)localObject1).as("needDownload");
      localObject3 = ((afhu)localObject1).as("overflow");
      localObject1 = new ArrayList();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject3);
      }
      CustomEmotionData localCustomEmotionData;
      if (((List)localObject1).size() > 0)
      {
        this.bj.set(0);
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        if (i >= ((List)localObject1).size()) {
          continue;
        }
        localCustomEmotionData = (CustomEmotionData)((List)localObject1).get(i);
        if (!localCustomEmotionData.isMarkFace) {
          break label197;
        }
        ((List)localObject3).add(localCustomEmotionData);
      }
      for (;;)
      {
        i += 1;
        break;
        cZF();
        return;
        ((List)localObject2).add(localCustomEmotionData);
      }
    } while (this.mApp == null);
    this.cQX = ((List)localObject3).size();
    if (this.cQX == 0) {
      cZF();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "markFace size: " + ((List)localObject3).size() + ", noMarkFace size:" + ((List)localObject2).size());
    }
    ThreadManager.getUIHandler().post(new FavroamingManager.4(this));
    ki((List)localObject3);
  }
  
  public void cZD()
  {
    this.bYh = true;
    if (this.gH != null)
    {
      aool localaool = (aool)this.gH.get();
      if (localaool != null) {
        this.jdField_a_of_type_Aooi.a(localaool);
      }
    }
  }
  
  protected void cZE()
  {
    this.bk.set(0);
    this.cQY = 0;
    int i = 0;
    while (i < this.Z.size())
    {
      if (this.Z.get(i) != null)
      {
        afic localafic = (afic)((WeakReference)this.Z.get(i)).get();
        if (localafic != null) {
          localafic.cZk();
        }
      }
      i += 1;
    }
    cZF();
  }
  
  protected void cZF()
  {
    if (ajn())
    {
      this.cR.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "------------end syncRoaming----------");
      }
      int i = 0;
      while (i < this.Z.size())
      {
        if (this.Z.get(i) != null)
        {
          afic localafic = (afic)((WeakReference)this.Z.get(i)).get();
          if (localafic != null) {
            localafic.cZH();
          }
        }
        i += 1;
      }
    }
  }
  
  public void cZG()
  {
    if (this.mApp == null) {}
    Object localObject;
    ajdg localajdg;
    do
    {
      return;
      localObject = (afhu)this.mApp.getManager(149);
      localajdg = (ajdg)this.mApp.getManager(14);
      localObject = ((afhu)localObject).ez();
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    this.fh.clear();
    Iterator localIterator = ((List)localObject).iterator();
    label68:
    CustomEmotionData localCustomEmotionData;
    String str;
    if (localIterator.hasNext())
    {
      localCustomEmotionData = (CustomEmotionData)localIterator.next();
      str = "";
      if (!localCustomEmotionData.isMarkFace) {
        break label164;
      }
      Emoticon localEmoticon = localajdg.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
      localObject = str;
      if (localEmoticon != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(localEmoticon.name)) {
          localObject = localEmoticon.name;
        }
      }
    }
    for (;;)
    {
      this.fh.put(Integer.valueOf(localCustomEmotionData.emoId), localObject);
      break label68;
      break;
      label164:
      if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {
        str = localCustomEmotionData.modifyWord;
      }
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) {
          localObject = localCustomEmotionData.ocrWord;
        }
      }
    }
  }
  
  public void cZq()
  {
    if (this.mApp == null) {}
    acef localacef;
    do
    {
      return;
      localacef = (acef)this.mApp.getBusinessHandler(72);
    } while (localacef == null);
    this.mApp.addObserver(this.jdField_c_of_type_Aceg);
    ThreadManager.excute(new FavroamingManager.3(this, localacef), 128, null, true);
  }
  
  public void d(CustomEmotionData paramCustomEmotionData)
  {
    b(paramCustomEmotionData, null);
  }
  
  protected void d(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = (ArrayList)this.kg.get(paramEmoticonPackage.epId);
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localArrayList.get(i);
        if (localCustomEmotionData != null) {
          onFileDone(localCustomEmotionData, false);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadAIOEmoticon fail epId:" + paramEmoticonPackage.epId);
    }
  }
  
  public void j(Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    this.fh.remove(paramInteger);
  }
  
  public void ki(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        Object localObject;
        try
        {
          this.kg.clear();
          i = 0;
          if (i < paramList.size())
          {
            localObject = (CustomEmotionData)paramList.get(i);
            if (localObject == null) {
              break label219;
            }
            if (this.kg.containsKey(((CustomEmotionData)localObject).emoPath))
            {
              ((ArrayList)this.kg.get(((CustomEmotionData)localObject).emoPath)).add(localObject);
            }
            else
            {
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject);
              this.kg.put(((CustomEmotionData)localObject).emoPath, localArrayList);
            }
          }
        }
        finally {}
        try
        {
          paramList = this.kg.entrySet().iterator();
          while (paramList.hasNext())
          {
            localObject = (Map.Entry)paramList.next();
            if (localObject != null) {
              HV((String)((Map.Entry)localObject).getKey());
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramList) {}
      }
      QLog.d("FavroamingManager", 2, "downMap exception=" + paramList.toString());
      break;
      label219:
      i += 1;
    }
  }
  
  public void kj(List<CustomEmotionData> paramList)
  {
    if (paramList != null) {
      s(paramList);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aooi != null)
    {
      this.jdField_a_of_type_Aooi.b(this.jdField_a_of_type_Aook);
      this.jdField_a_of_type_Aook = null;
    }
    this.mApp.removeObserver(this.jdField_c_of_type_Aceg);
    afkd.a().b(this.jdField_a_of_type_Afko);
  }
  
  public void onFileDone(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if ((paramCustomEmotionData == null) || (this.mApp == null)) {}
    int i;
    label205:
    label228:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + ",isSuccess = " + paramBoolean + " , roamingType: " + paramCustomEmotionData.RomaingType);
      }
      Object localObject = (afhu)this.mApp.getManager(149);
      if ((localObject != null) && (paramBoolean))
      {
        if (!"needDownload".equals(paramCustomEmotionData.RomaingType)) {
          break label205;
        }
        paramCustomEmotionData.RomaingType = "isUpdate";
        if ("needDel".equals(paramCustomEmotionData.RomaingType)) {
          break label228;
        }
        ((afhu)localObject).b(paramCustomEmotionData);
      }
      for (;;)
      {
        i = 0;
        while (i < this.Z.size())
        {
          if (this.Z.get(i) != null)
          {
            localObject = (afic)((WeakReference)this.Z.get(i)).get();
            if (localObject != null) {
              ((afic)localObject).a(paramCustomEmotionData, this.cQX, this.bj.get());
            }
          }
          i += 1;
        }
        if (!"overflow".equals(paramCustomEmotionData.RomaingType)) {
          break;
        }
        paramCustomEmotionData.RomaingType = "overflow_downloaded";
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + " has been deleted");
        }
      }
      i = this.bj.incrementAndGet();
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "market face : downloadCount: " + i + ",needDownloadCount: " + this.cQX);
      }
    } while (i < this.cQX);
    cZC();
  }
  
  public int s(List<CustomEmotionData> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0) || (!aqiw.isNetSupport(BaseApplication.getContext()))) {
      return 0;
    }
    Object localObject = paramList;
    if (paramList.size() > afhs.cQV)
    {
      j = paramList.size() - afhs.cQV;
      localObject = paramList.subList(j, afhs.cQV + j);
    }
    int k = ((List)localObject).size();
    int j = 0;
    if (j < k)
    {
      paramList = (CustomEmotionData)((List)localObject).get(j);
      if (("needDownload".equals(paramList.RomaingType)) || ("needDel".equals(paramList.RomaingType))) {
        break label161;
      }
      if (!"isUpdate".equals(paramList.RomaingType)) {}
    }
    label161:
    for (;;)
    {
      j += 1;
      break;
      a(paramList, null);
      i += 1;
      continue;
      this.cQY = i;
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat, List<Integer> paramList);
    
    public abstract void hg(List<Integer> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhv
 * JD-Core Version:    0.7.0.1
 */