import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.2;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.3;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.5;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.6;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.7;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.9;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.pb.emosm.PicSearchSvr.ImgInfo;
import com.tencent.pb.emosm.PicSearchSvr.ReqBody;
import com.tencent.pb.emosm.PicSearchSvr.RspBody;
import com.tencent.pb.emosm.PicSearchWordsSvr.RspBody;
import com.tencent.pb.emosm.PicSearchWordsSvr.WordsMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lyhl;>;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class yhf
  implements Manager
{
  private static Integer O;
  private static Boolean ae;
  private File V;
  private File W;
  private File X;
  private File Y;
  private ajdg jdField_a_of_type_Ajdg;
  private BloomFilter jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ygv jdField_a_of_type_Ygv;
  private yhc jdField_a_of_type_Yhc;
  private yhf.a jdField_a_of_type_Yhf$a;
  private HashSet<String> aG;
  private Card jdField_b_of_type_ComTencentMobileqqDataCard;
  private final yhf.a jdField_b_of_type_Yhf$a = new yhg(this);
  private int bYY = 6;
  private boolean bmE = true;
  private volatile boolean hasInit;
  private QQAppInterface mApp;
  private volatile String mCurrentText = "";
  private List<ygm> sB;
  private List<ygl> sC = new CopyOnWriteArrayList();
  private MqqHandler y = ThreadManager.getFileThreadHandler();
  
  public yhf(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_Ajdg = ((ajdg)paramQQAppInterface.getManager(14));
    bl(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    cio();
    if (this.sB != null) {
      this.sB.clear();
    }
    a(new yhe(paramQQAppInterface));
    this.jdField_a_of_type_Ygv = new ygv(paramQQAppInterface);
    a(this.jdField_a_of_type_Ygv);
    this.jdField_a_of_type_Yhc = new yhc(paramQQAppInterface);
    a(this.jdField_a_of_type_Yhc);
  }
  
  private void A(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      localHashMap.put("initTimeCost", paramLong + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "StickerRecInitCost", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private PicSearchSvr.ReqBody a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, List<String> paramList)
  {
    PicSearchSvr.ReqBody localReqBody;
    try
    {
      localReqBody = new PicSearchSvr.ReqBody();
      localReqBody.setHasFlag(true);
      localReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(paramString1));
      localReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
      localReqBody.uint32_src_term.set(paramInt1);
      localReqBody.uint32_aio_type.set(paramInt2);
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString3));
      if (paramList != null)
      {
        paramString1 = new ArrayList();
        paramString2 = paramList.iterator();
        while (paramString2.hasNext()) {
          paramString1.add(ByteStringMicro.copyFromUtf8((String)paramString2.next()));
        }
        localReqBody.bytes_key_word.set(paramString1);
      }
    }
    finally {}
    if (this.jdField_b_of_type_ComTencentMobileqqDataCard != null) {
      localReqBody.uint32_age.set(this.jdField_b_of_type_ComTencentMobileqqDataCard.age);
    }
    for (;;)
    {
      return localReqBody;
      localReqBody.uint32_age.set(0);
    }
  }
  
  private List<ygl> a(List<ygl> paramList, StickerRecommendSortEntity paramStickerRecommendSortEntity)
  {
    int i2 = 0;
    int j;
    int m;
    label105:
    int k;
    label123:
    int i;
    int n;
    label205:
    int i1;
    if (paramStickerRecommendSortEntity != null)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort clicked=" + paramStickerRecommendSortEntity.clicked + " exposed=" + paramStickerRecommendSortEntity.exposed + " noExpose=" + paramStickerRecommendSortEntity.noExpose);
        }
        if (paramStickerRecommendSortEntity.clickedList == null) {
          break label441;
        }
        j = paramStickerRecommendSortEntity.clickedList.size();
        if (paramStickerRecommendSortEntity.noExposeList == null) {
          break label435;
        }
        m = paramStickerRecommendSortEntity.noExposeList.size();
        if (paramStickerRecommendSortEntity.exposedList == null) {
          break label429;
        }
        k = paramStickerRecommendSortEntity.exposedList.size();
        i3 = paramList.size();
        i = j + m + k;
        if (i3 != i)
        {
          if (!QLog.isColorLevel()) {
            break label447;
          }
          QLog.i("StickerRecManager", 2, "sort data:length is not equals. size=" + i3 + " sortSize=" + i);
          break label447;
        }
        arrayOfygl = new ygl[i3];
        n = 0;
        i = 0;
        if (n >= j) {
          break label458;
        }
        i1 = ((Integer)paramStickerRecommendSortEntity.clickedList.get(n)).intValue();
        if ((i1 >= i3) || (i >= i3)) {
          break label426;
        }
        arrayOfygl[i] = ((ygl)paramList.get(i1));
        i += 1;
      }
      catch (Throwable paramList)
      {
        int i3;
        ygl[] arrayOfygl;
        label266:
        QLog.e("StickerRecManager", 1, "sortData:", paramList);
      }
      j = i;
      i1 = i2;
      if (n < m)
      {
        j = ((Integer)paramStickerRecommendSortEntity.noExposeList.get(n)).intValue();
        if ((j >= i3) || (i >= i3)) {
          break label423;
        }
        arrayOfygl[i] = ((ygl)paramList.get(j));
        i += 1;
        break label464;
      }
    }
    for (;;)
    {
      if (i1 < k)
      {
        i = ((Integer)paramStickerRecommendSortEntity.exposedList.get(i1)).intValue();
        if ((i < i3) && (j < i3))
        {
          arrayOfygl[j] = ((ygl)paramList.get(i));
          i = j + 1;
          break label473;
        }
      }
      else
      {
        paramList = Arrays.asList(arrayOfygl);
        return paramList;
        return null;
      }
      i = j;
      break label473;
      label423:
      break label464;
      label426:
      break label449;
      label429:
      k = 0;
      break label123;
      label435:
      m = 0;
      break label105;
      label441:
      j = 0;
      break;
      label447:
      return null;
      label449:
      n += 1;
      break label205;
      label458:
      n = 0;
      break label266;
      label464:
      n += 1;
      break label266;
      label473:
      i1 += 1;
      j = i;
    }
  }
  
  public static yhf a(QQAppInterface paramQQAppInterface)
  {
    return (yhf)paramQQAppInterface.getManager(314);
  }
  
  private void a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "cache pics in DB");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
    {
      StickerRecommendEntity localStickerRecommendEntity = new StickerRecommendEntity();
      localStickerRecommendEntity.usrMessage = paramString;
      localStickerRecommendEntity.recList = Base64.encodeToString(paramArrayOfByte, 0);
      localStickerRecommendEntity.cachedTime = System.currentTimeMillis();
      localStickerRecommendEntity.recommendType = paramInt;
      this.y.post(new StickerRecManager.6(this, localStickerRecommendEntity));
    }
  }
  
  private void a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean, StickerRecommendSortEntity paramStickerRecommendSortEntity, int paramInt)
  {
    PicSearchSvr.RspBody localRspBody;
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "handlePullPics from : " + paramString2 + " | RecType=" + paramInt);
      }
      localRspBody = new PicSearchSvr.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.int32_result.get() != 0)
      {
        if (!QLog.isColorLevel()) {
          break label722;
        }
        QLog.d("StickerRecManager", 2, "handleResponse response code error,result:" + localRspBody.int32_result.get() + " message : " + localRspBody.bytes_fail_msg.get());
        return;
      }
      localObject = localRspBody.rpt_msg_img_info.get();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label230;
      }
      if ("network".equals(paramString2)) {
        cim();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
        this.y.post(new StickerRecManager.7(this, paramInt, paramString1));
      }
      if (!QLog.isColorLevel()) {
        break label722;
      }
      QLog.d("StickerRecManager", 2, "handleResponse imgInfos is null or empty");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (!QLog.isColorLevel()) {
        break label722;
      }
    }
    QLog.d("StickerRecManager", 2, aurp.getStackTraceAsString(paramArrayOfByte));
    return;
    label230:
    paramArrayOfByte = new ArrayList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      PicSearchSvr.ImgInfo localImgInfo = (PicSearchSvr.ImgInfo)((List)localObject).get(i);
      ygz localygz = new ygz();
      localygz.setIndex(i);
      localygz.gi(localImgInfo.uint64_img_size.get());
      localygz.DW(localImgInfo.uint32_img_width.get());
      localygz.DX(localImgInfo.uint32_img_height.get());
      localygz.yE(localImgInfo.bytes_img_md5.get().toStringUtf8());
      localygz.setImgUrl(localImgInfo.bytes_img_down_url.get().toStringUtf8());
      localygz.gj(localImgInfo.uint64_thumb_size.get());
      localygz.DZ(localImgInfo.uint32_thumb_img_height.get());
      localygz.DY(localImgInfo.uint32_thumb_img_width.get());
      localygz.setThumbUrl(localImgInfo.bytes_thumb_down_url.get().toStringUtf8());
      localygz.yF(localImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
      localygz.nA(localImgInfo.uint32_src_type.get());
      localygz.setSource(localImgInfo.bytes_src_desc.get().toStringUtf8());
      localygz.setWebUrl(localImgInfo.bytes_web_url.get().toStringUtf8());
      localygz.setIconUrl("");
      localygz.setPackageName(localImgInfo.bytes_pack_name.get().toStringUtf8());
      localygz.Ea(localImgInfo.uint32_pack_id.get());
      localygz.DU(paramInt);
      paramArrayOfByte.add(localygz);
      i += 1;
    }
    paramStickerRecommendSortEntity = a(paramArrayOfByte, paramStickerRecommendSortEntity);
    if (paramStickerRecommendSortEntity != null)
    {
      paramArrayOfByte = paramStickerRecommendSortEntity;
      if ((this.sC != null) && (!this.sC.isEmpty()))
      {
        paramArrayOfByte = new ArrayList(paramArrayOfByte);
        paramArrayOfByte.addAll(0, this.sC);
        this.sC.clear();
        label597:
        if (!"network".equals(paramString2)) {
          break label723;
        }
      }
    }
    label722:
    label723:
    for (paramString2 = localRspBody.bytes_rsp_other.get().toStringUtf8();; paramString2 = "999")
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Yhf$a.a(paramArrayOfByte, paramString1, paramString2, 0, null);
        return;
      }
      if (this.jdField_a_of_type_Yhf$a != null)
      {
        localRspBody = null;
        paramStickerRecommendSortEntity = localRspBody;
        if (paramInt == 1)
        {
          paramStickerRecommendSortEntity = localRspBody;
          if (this.mApp != null)
          {
            localObject = ScenesRecommendManager.a(this.mApp).a(paramString1);
            paramStickerRecommendSortEntity = localRspBody;
            if (localObject != null) {
              paramStickerRecommendSortEntity = ((yho)localObject).getTitle();
            }
          }
        }
        this.jdField_a_of_type_Yhf$a.a(paramArrayOfByte, paramString1, paramString2, paramInt, paramStickerRecommendSortEntity);
        return;
        break label597;
        break;
      }
      return;
    }
  }
  
  private boolean a(File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
  {
    if (f(paramFile1, paramString))
    {
      if (paramBoolean)
      {
        if (d(paramFile1, paramFile2))
        {
          paramFile1.delete();
          return true;
        }
      }
      else
      {
        e(paramFile1, paramFile2);
        return true;
      }
    }
    else
    {
      paramFile1.delete();
      if (QLog.isColorLevel()) {
        QLog.e("StickerRecManager", 2, "downloadFile zip md5 is wrong");
      }
    }
    return false;
  }
  
  public static boolean a(ygl paramygl)
  {
    return paramygl.Tz();
  }
  
  private void aj(boolean paramBoolean, String paramString)
  {
    this.sC.clear();
    ArrayList localArrayList = new ArrayList();
    if ((paramBoolean) && (this.sB != null))
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = this.sB.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ygm)localIterator.next();
        if (((ygm)localObject).s(this.mApp, paramString))
        {
          localObject = ((ygm)localObject).ad(paramString);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            localArrayList.addAll((Collection)localObject);
          }
        }
      }
      paramString = ygn.b(this.mApp, localArrayList);
      if ((paramString != null) && (!paramString.isEmpty())) {
        this.sC.addAll(paramString);
      }
      paramString = this.sC.iterator();
      while (paramString.hasNext()) {
        ((ygl)paramString.next()).be(this.mApp);
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "handleLocalEmoticon time = " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  private void am(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new PicSearchWordsSvr.RspBody();
      ((PicSearchWordsSvr.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((PicSearchWordsSvr.RspBody)localObject).int32_result.get() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "handlePullWords response code error,result:" + ((PicSearchWordsSvr.RspBody)localObject).int32_result.get() + " message : " + ((PicSearchWordsSvr.RspBody)localObject).bytes_fail_msg.get());
        }
      }
      else
      {
        paramArrayOfByte = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_version.get().toStringUtf8();
        String str1 = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_md5.get().toStringUtf8();
        String str2 = ((PicSearchWordsSvr.RspBody)localObject).words_msg.bytes_words_url.get().toStringUtf8();
        int i = ((PicSearchWordsSvr.RspBody)localObject).words_msg.uint32_words_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "pull words resp:version=" + paramArrayOfByte + " wordsMd5=" + str1 + " wordsUrl=" + str2 + " wordsType=" + i);
        }
        localObject = aqmj.m(this.mApp.getApp(), "words_version_key805_gray_one", this.mApp.getCurrentUin());
        if ((!((String)localObject).equals(paramArrayOfByte)) || (!this.X.exists()))
        {
          d(str2, str1, i, paramArrayOfByte);
          return;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("StickerRecManager", 2, aurp.getStackTraceAsString(paramArrayOfByte));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "not need pull words: localVersion=" + (String)localObject + " server version=" + paramArrayOfByte);
        }
      }
    }
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (ae == null) {
      ae = Boolean.valueOf(paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getBoolean("RECOMMENDED_STICKER_SWITCH" + paramString, paramBoolean));
    }
    return ae.booleanValue();
  }
  
  public static boolean b(ygl paramygl)
  {
    return !a(paramygl);
  }
  
  public static int c(Context paramContext, String paramString, int paramInt)
  {
    if (O == null) {
      O = Integer.valueOf(paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + paramString, paramInt));
    }
    return 6;
  }
  
  public static boolean c(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isStickerPics());
  }
  
  private void cim()
  {
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "StickerRecEmptyImg", false, 0L, 0L, null, "");
  }
  
  public static void cip()
  {
    Object localObject = new File(ygy.aXI);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "updateWords fail: url is null.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "start download words");
    }
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Object localObject = this.V.getParentFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = new aoll();
        ((aoll)localObject).f = new yhh(this, paramString2, bool, paramString3);
        ((aoll)localObject).bZ = paramString1;
        ((aoll)localObject).mHttpMethod = 0;
        ((aoll)localObject).atY = this.Y.getAbsolutePath();
        ((aoll)localObject).mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        try
        {
          paramString2 = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramString2)) {
            break;
          }
          ((QQAppInterface)paramString2).getNetEngine(0).a((aomg)localObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("StickerRecManager", 2, "start download words, url: " + paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("StickerRecManager", 1, "download follow words error", paramString1);
          return;
        }
      }
    }
  }
  
  private boolean d(File paramFile1, File paramFile2)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(paramFile2.getParent() + File.separator + "temp");
      jqp.b(paramFile1, localFile.getAbsolutePath() + File.separator);
      paramFile1 = localFile.listFiles();
      int j = paramFile1.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramFile1[i];
        String str = localFile.getName();
        if ((localFile.isFile()) && (str.endsWith("json"))) {
          e(localFile, paramFile2);
        }
        i += 1;
      }
      bool = true;
    }
    catch (Exception paramFile1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StickerRecManager", 2, "uncompress template zip file error", paramFile1);
    }
    return bool;
    return false;
  }
  
  private void e(File paramFile1, File paramFile2)
  {
    if (paramFile2.exists()) {
      paramFile2.delete();
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      aqhq.copyFile(paramFile1, paramFile2);
      paramFile1.delete();
    }
  }
  
  public static File f(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = new File(ygy.aXI + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private boolean f(File paramFile, String paramString)
  {
    boolean bool = true;
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("StickerRecManager", 2, "downloadFile zip file not exists");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramFile = aqhq.px(paramFile.getPath());
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramFile))) {
          break label72;
        }
        return bool;
      }
      catch (UnsatisfiedLinkError paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("StickerRecManager", 1, "calculate follow capture template zip md5 error", paramFile);
      return false;
      label72:
      bool = false;
    }
  }
  
  private int fn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private String getDataDir()
  {
    return this.mApp.getApp().getFilesDir().getAbsolutePath() + File.separator + this.mApp.getCurrentUin() + File.separator + "qstorage" + File.separator + "objs" + File.separator + "sticker_recommend";
  }
  
  public static String hF(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      localStringBuffer.append("\\u" + Integer.toHexString(j));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String hG(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = ygy.aXI + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void j(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_VERSION" + paramQQAppInterface.getCurrentAccountUin(), paramInt).apply();
  }
  
  public static void l(Context paramContext, String paramString, int paramInt)
  {
    O = Integer.valueOf(paramInt);
    paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + paramString, paramInt).apply();
  }
  
  /* Error */
  private Object n(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 832	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 5
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: new 1034	java/io/ObjectInputStream
    //   18: dup
    //   19: new 1036	java/io/BufferedInputStream
    //   22: dup
    //   23: new 1038	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 1039	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 1042	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 1043	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: invokevirtual 1046	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: ifnull -39 -> 13
    //   55: aload_3
    //   56: invokevirtual 1049	java/io/ObjectInputStream:close	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_1
    //   62: aload_2
    //   63: areturn
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +46 -> 119
    //   76: aload_3
    //   77: astore_2
    //   78: ldc_w 306
    //   81: iconst_2
    //   82: new 158	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 1051
    //   92: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_1
    //   96: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 1053
    //   102: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 4
    //   107: invokevirtual 1054	java/lang/Exception:toString	()Ljava/lang/String;
    //   110: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload 5
    //   121: astore_1
    //   122: aload_3
    //   123: ifnull -110 -> 13
    //   126: aload_3
    //   127: invokevirtual 1049	java/io/ObjectInputStream:close	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_1
    //   133: aconst_null
    //   134: areturn
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: astore_2
    //   140: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +15 -> 158
    //   146: aload_3
    //   147: astore_2
    //   148: ldc_w 306
    //   151: iconst_2
    //   152: ldc_w 1056
    //   155: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 5
    //   160: astore_1
    //   161: aload_3
    //   162: ifnull -149 -> 13
    //   165: aload_3
    //   166: invokevirtual 1049	java/io/ObjectInputStream:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_1
    //   172: aconst_null
    //   173: areturn
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_2
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 1049	java/io/ObjectInputStream:close	()V
    //   185: aload_1
    //   186: athrow
    //   187: astore_2
    //   188: goto -3 -> 185
    //   191: astore_1
    //   192: goto -15 -> 177
    //   195: astore_1
    //   196: goto -58 -> 138
    //   199: astore 4
    //   201: goto -133 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	yhf
    //   0	204	1	paramString	String
    //   39	143	2	localObject1	Object
    //   187	1	2	localIOException	java.io.IOException
    //   37	129	3	localObjectInputStream	java.io.ObjectInputStream
    //   44	3	4	localObject2	Object
    //   64	42	4	localException1	Exception
    //   199	1	4	localException2	Exception
    //   1	158	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	59	61	java/io/IOException
    //   15	38	64	java/lang/Exception
    //   126	130	132	java/io/IOException
    //   15	38	135	java/lang/OutOfMemoryError
    //   165	169	171	java/io/IOException
    //   15	38	174	finally
    //   181	185	187	java/io/IOException
    //   40	46	191	finally
    //   70	76	191	finally
    //   78	119	191	finally
    //   140	146	191	finally
    //   148	158	191	finally
    //   40	46	195	java/lang/OutOfMemoryError
    //   40	46	199	java/lang/Exception
  }
  
  public static void p(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str = paramQQAppInterface.getCurrentUin();
    ae = Boolean.valueOf(paramBoolean);
    if (ae.booleanValue()) {
      a(paramQQAppInterface).cin();
    }
    localBaseApplication.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putBoolean("RECOMMENDED_STICKER_SWITCH" + str, paramBoolean).apply();
  }
  
  public static int t(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_VERSION" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  /* Error */
  private void t(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 832	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 1070	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 1072	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 1074	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 1075	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 1078	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 1079	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload 4
    //   37: aload_2
    //   38: invokevirtual 1083	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokevirtual 1086	java/io/ObjectOutputStream:flush	()V
    //   49: aload 4
    //   51: ifnull -44 -> 7
    //   54: aload 4
    //   56: invokevirtual 1087	java/io/ObjectOutputStream:close	()V
    //   59: return
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 1088	java/io/IOException:printStackTrace	()V
    //   65: return
    //   66: astore 5
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +46 -> 121
    //   78: aload_2
    //   79: astore_3
    //   80: ldc_w 306
    //   83: iconst_2
    //   84: new 158	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 1090
    //   94: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 1053
    //   104: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: invokevirtual 1054	java/lang/Exception:toString	()Ljava/lang/String;
    //   112: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_2
    //   122: ifnull -115 -> 7
    //   125: aload_2
    //   126: invokevirtual 1087	java/io/ObjectOutputStream:close	()V
    //   129: return
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 1088	java/io/IOException:printStackTrace	()V
    //   135: return
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 1087	java/io/ObjectOutputStream:close	()V
    //   147: aload_1
    //   148: athrow
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 1088	java/io/IOException:printStackTrace	()V
    //   154: goto -7 -> 147
    //   157: astore_1
    //   158: goto -19 -> 139
    //   161: astore 5
    //   163: aload 4
    //   165: astore_2
    //   166: goto -96 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	yhf
    //   0	169	1	paramString	String
    //   0	169	2	paramObject	Object
    //   34	110	3	localObject	Object
    //   30	134	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   66	42	5	localException1	Exception
    //   161	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   54	59	60	java/io/IOException
    //   8	32	66	java/lang/Exception
    //   125	129	130	java/io/IOException
    //   8	32	136	finally
    //   143	147	149	java/io/IOException
    //   35	41	157	finally
    //   44	49	157	finally
    //   72	78	157	finally
    //   80	121	157	finally
    //   35	41	161	java/lang/Exception
    //   44	49	161	java/lang/Exception
  }
  
  public boolean TC()
  {
    return this.bmE;
  }
  
  /* Error */
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 158	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 1097	android/os/SystemClock:uptimeMillis	()J
    //   16: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 7
    //   24: aload_0
    //   25: aload 7
    //   27: aload_1
    //   28: iload_2
    //   29: iload_3
    //   30: aload 4
    //   32: aload 5
    //   34: invokespecial 1099	yhf:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)Lcom/tencent/pb/emosm/PicSearchSvr$ReqBody;
    //   37: invokevirtual 1103	com/tencent/pb/emosm/PicSearchSvr$ReqBody:toByteArray	()[B
    //   40: astore 8
    //   42: aload 8
    //   44: arraylength
    //   45: iconst_4
    //   46: iadd
    //   47: invokestatic 1109	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   50: astore 9
    //   52: aload 9
    //   54: aload 8
    //   56: arraylength
    //   57: iconst_4
    //   58: iadd
    //   59: invokevirtual 1111	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   62: aload 8
    //   64: invokevirtual 1114	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   67: pop
    //   68: aload 9
    //   70: invokevirtual 1117	java/nio/ByteBuffer:array	()[B
    //   73: astore 9
    //   75: new 1119	mqq/app/NewIntent
    //   78: dup
    //   79: aload_0
    //   80: getfield 80	yhf:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   83: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   86: ldc_w 1121
    //   89: invokespecial 1124	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   92: astore 8
    //   94: aload 8
    //   96: ldc_w 1126
    //   99: aload 9
    //   101: invokevirtual 1130	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   104: pop
    //   105: aload 8
    //   107: ldc_w 1132
    //   110: ldc_w 1134
    //   113: invokevirtual 1137	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   116: pop
    //   117: aload 5
    //   119: iconst_0
    //   120: invokeinterface 353 2 0
    //   125: checkcast 267	java/lang/String
    //   128: astore 5
    //   130: aload 8
    //   132: ldc_w 1139
    //   135: aload 5
    //   137: invokevirtual 1137	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   140: pop
    //   141: iload_2
    //   142: iconst_4
    //   143: if_icmpne +118 -> 261
    //   146: iconst_1
    //   147: istore 6
    //   149: aload 8
    //   151: ldc_w 1141
    //   154: iload 6
    //   156: invokevirtual 1144	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   159: pop
    //   160: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +86 -> 249
    //   166: ldc_w 306
    //   169: iconst_2
    //   170: new 158	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 1146
    //   180: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 7
    //   185: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc_w 1148
    //   191: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_1
    //   195: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 1150
    //   201: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload_2
    //   205: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 1152
    //   211: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_3
    //   215: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc_w 1154
    //   221: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 4
    //   226: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 1156
    //   232: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 5
    //   237: invokestatic 1158	yhf:hF	(Ljava/lang/String;)Ljava/lang/String;
    //   240: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: getfield 80	yhf:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   253: aload 8
    //   255: invokevirtual 1162	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   258: aload_0
    //   259: monitorexit
    //   260: return
    //   261: iconst_0
    //   262: istore 6
    //   264: goto -115 -> 149
    //   267: astore_1
    //   268: aload_0
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	yhf
    //   0	272	1	paramString1	String
    //   0	272	2	paramInt1	int
    //   0	272	3	paramInt2	int
    //   0	272	4	paramString2	String
    //   0	272	5	paramList	List<String>
    //   147	116	6	bool	boolean
    //   22	162	7	str	String
    //   40	214	8	localObject1	Object
    //   50	50	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	141	267	finally
    //   149	249	267	finally
    //   249	258	267	finally
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, yho paramyho)
  {
    if (paramyho != null) {}
    for (;;)
    {
      try
      {
        String str = paramyho.pC();
        if (str == null) {
          return;
        }
        str = paramString1 + SystemClock.uptimeMillis();
        Object localObject1 = a(str, paramString1, paramInt1, paramInt2, paramString2, paramyho.cO()).toByteArray();
        Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
        ((ByteBuffer)localObject2).putInt(localObject1.length + 4).put((byte[])localObject1);
        localObject2 = ((ByteBuffer)localObject2).array();
        localObject1 = new NewIntent(this.mApp.getApp(), yhk.class);
        ((NewIntent)localObject1).putExtra("key_body", (byte[])localObject2);
        ((NewIntent)localObject1).putExtra("key_cmd", "SceneFaceRec.PullFaces");
        paramyho = paramyho.pC();
        ((NewIntent)localObject1).putExtra("REQUEST_SCENES_ID", paramyho);
        ((NewIntent)localObject1).putExtra("USER_KEYWORD", paramyho);
        boolean bool;
        if (paramInt1 == 4)
        {
          bool = true;
          ((NewIntent)localObject1).putExtra("fromQzone", bool);
          if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "send pull pics args:sessionId = " + str + " uin=" + paramString1 + " termType=" + paramInt1 + " aioType : " + paramInt2 + " toUin : " + paramString2 + "  scenesID: " + paramyho);
          }
          this.mApp.startServlet((NewIntent)localObject1);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public void a(List<yhl> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    label22:
    Object localObject3;
    String str1;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    Object localObject5;
    while (localIterator.hasNext())
    {
      localObject3 = (yhl)localIterator.next();
      if (localObject3 != null)
      {
        str1 = ((yhl)localObject3).keyword;
        paramList = ((yhl)localObject3).exposedList;
        localObject4 = new StringBuilder();
        localObject2 = new StringBuilder();
        localObject1 = null;
        localObject5 = paramList.iterator();
        label91:
        while (((Iterator)localObject5).hasNext())
        {
          paramList = (ygl)((Iterator)localObject5).next();
          if (paramList.pz() != null)
          {
            String str2 = paramList.pA();
            if (!TextUtils.isEmpty(str2)) {
              ((StringBuilder)localObject4).append(str2);
            }
            ((StringBuilder)localObject4).append(paramList.pz());
            ((StringBuilder)localObject4).append(";");
            if (paramList.getImgUrl() != null)
            {
              ((StringBuilder)localObject2).append(paramList.getImgUrl());
              ((StringBuilder)localObject2).append(";");
            }
            if (!paramList.isClicked()) {
              break label653;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramList;
      break label91;
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = ((StringBuilder)localObject2).toString();
      paramList = "";
      label240:
      long l;
      if (paramBoolean)
      {
        if (paramInt == 0) {
          paramList = "c2c";
        }
      }
      else
      {
        l = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
        if (((yhl)localObject3).recommendType != 1) {
          break label581;
        }
        localObject2 = new yhn();
        ((yhn)localObject2).dcId = "dc05550";
        ((yhn)localObject2).scene = str1;
        ((yhn)localObject2).uin = String.valueOf(l);
        ((yhn)localObject2).aXT = paramString;
        ((yhn)localObject2).aXN = paramList;
      }
      for (paramList = (List<yhl>)localObject2;; paramList = (List<yhl>)localObject2)
      {
        paramList.aXS = ((yhl)localObject3).aXF;
        paramList.appid = String.valueOf(AppSetting.getAppId());
        if (localObject1 != null)
        {
          localObject3 = ((ygl)localObject1).pz();
          str1 = ((ygl)localObject1).pA();
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str1)) {
            localObject2 = str1 + (String)localObject3;
          }
          paramList.aXR = ((String)localObject2);
          paramList.click_url = ((ygl)localObject1).getImgUrl();
        }
        paramList.aXP = ((String)localObject4);
        paramList.aXQ = ((String)localObject5);
        paramList.mobile_type = "android";
        localObject1 = paramList.V();
        localObject2 = new NewIntent(this.mApp.getApp(), yhk.class);
        ((NewIntent)localObject2).putExtra("key_cmd", "MQInference.CommonReport");
        ((NewIntent)localObject2).putExtra("key_body", aqnv.I(((JSONObject)localObject1).toString().getBytes()));
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "report StickerRecReport content:" + paramList.V().toString());
        }
        this.mApp.startServlet((NewIntent)localObject2);
        break label22;
        break;
        if (paramInt == 1)
        {
          paramList = "group";
          break label240;
        }
        if (paramInt == 3000)
        {
          paramList = "discuss";
          break label240;
        }
        if (paramInt == 11000)
        {
          paramList = "qzone";
          break label240;
        }
        paramList = "other";
        break label240;
        label581:
        localObject2 = new yhi();
        ((yhi)localObject2).dcId = "dc04577";
        ((yhi)localObject2).keyword = str1;
        if (QLog.isColorLevel()) {
          ((yhi)localObject2).keyword = hF(((yhi)localObject2).keyword);
        }
        ((yhi)localObject2).user_id = String.valueOf(l);
        ((yhi)localObject2).aXO = paramString;
        ((yhi)localObject2).aXN = paramList;
      }
      label653:
      paramList = (List<yhl>)localObject1;
    }
  }
  
  public void a(ygm paramygm)
  {
    if (paramygm == null) {}
    do
    {
      return;
      if (this.sB == null) {
        this.sB = new ArrayList();
      }
    } while (this.sB.contains(paramygm));
    this.sB.add(paramygm);
  }
  
  public void a(yhf.a parama)
  {
    this.jdField_a_of_type_Yhf$a = parama;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    return a(paramString1, paramInt, paramString2, paramBoolean, false);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!hasInit())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "can't analyze, has not init");
      }
      return false;
    }
    try
    {
      String str1 = hD(paramString1);
      if ((TextUtils.isEmpty(str1)) || (str1.length() > this.bYY))
      {
        if (!QLog.isColorLevel()) {
          break label254;
        }
        QLog.d("StickerRecManager", 2, "userTxt over maxMatchLength or empty");
        break label254;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.contains(str1);
      String str2 = hF(str1);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, "word : " + str2 + " miss dict");
        }
        if ((!paramBoolean2) || (this.jdField_a_of_type_Yhf$a == null)) {
          break label256;
        }
        ThreadManager.getSubThreadHandler().post(new StickerRecManager.2(this, paramString1, paramBoolean2));
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "word : " + str2 + " in dict");
      }
      this.y.post(new StickerRecManager.3(this, paramBoolean2, paramString1, str1, paramBoolean1, paramInt, paramString2));
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecManager", 2, aurp.getStackTraceAsString(paramString1));
        }
      }
    }
    return true;
    label254:
    return false;
    label256:
    return false;
  }
  
  protected void bl(Context paramContext, String paramString)
  {
    try
    {
      this.bmE = aqmj.aS(paramContext, paramString);
      return;
    }
    catch (NullPointerException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public Collection<String> c()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = ((afhc)this.mApp.getManager(333)).ez();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (!TextUtils.isEmpty(localCameraEmotionData.strContext))) {
          localHashSet.add(hE(localCameraEmotionData.strContext));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "loadKeywordForCameraEmotion size: " + localHashSet.size());
    }
    return localHashSet;
  }
  
  public void cin()
  {
    if (!b(this.mApp.getApp(), this.mApp.getCurrentUin(), false)) {
      return;
    }
    cio();
    ThreadManager.excute(new StickerRecManager.5(this), 128, null, true);
  }
  
  public void cio()
  {
    try
    {
      File localFile = new File(getDataDir(), "words");
      this.Y = new File(getDataDir(), "words.zip");
      this.V = new File(localFile, "words.json");
      this.X = new File(localFile, "encodedBloom.bin");
      this.W = new File(localFile, "local_words.bin");
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void ciq()
  {
    if (this.jdField_a_of_type_Ygv == null) {
      return;
    }
    this.jdField_a_of_type_Ygv.cii();
  }
  
  public void cir()
  {
    if (this.jdField_a_of_type_Yhc == null) {
      return;
    }
    this.jdField_a_of_type_Yhc.cii();
  }
  
  public Collection<String> e()
  {
    HashSet localHashSet = new HashSet();
    ajdg localajdg = (ajdg)this.mApp.getManager(14);
    Object localObject1 = ((afhu)this.mApp.getManager(149)).ez();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        if (("isUpdate".equals(((CustomEmotionData)localObject2).RomaingType)) || ("needDownload".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow".equals(((CustomEmotionData)localObject2).RomaingType)) || ("overflow_downloaded".equals(((CustomEmotionData)localObject2).RomaingType))) {
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).modifyWord))
          {
            localHashSet.add(hE(((CustomEmotionData)localObject2).modifyWord));
          }
          else if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).ocrWord))
          {
            localHashSet.add(hE(((CustomEmotionData)localObject2).ocrWord));
          }
          else if (((CustomEmotionData)localObject2).isMarkFace)
          {
            localObject2 = localajdg.a(((CustomEmotionData)localObject2).emoPath, ((CustomEmotionData)localObject2).eId);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((Emoticon)localObject2).name))) {
              localHashSet.add(((Emoticon)localObject2).name);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "loadKeywordForFavEmotion size: " + localHashSet.size());
    }
    return localHashSet;
  }
  
  /* Error */
  public void e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	yhf:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 1457	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody
    //   19: dup
    //   20: invokespecial 1458	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: iconst_1
    //   28: invokevirtual 1459	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:setHasFlag	(Z)V
    //   31: new 158	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokestatic 1097	android/os/SystemClock:uptimeMillis	()J
    //   45: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 6
    //   53: invokestatic 1242	com/tencent/common/config/AppSetting:getAppId	()I
    //   56: invokestatic 1244	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   59: astore 7
    //   61: aload_0
    //   62: getfield 80	yhf:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   68: invokestatic 1465	aewh:getVersionName	(Landroid/content/Context;)Ljava/lang/String;
    //   71: astore 8
    //   73: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +83 -> 159
    //   79: ldc_w 306
    //   82: iconst_2
    //   83: new 158	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 1467
    //   93: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 6
    //   98: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 1148
    //   104: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 1150
    //   114: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload_2
    //   118: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc_w 1469
    //   124: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 7
    //   129: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 1471
    //   135: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 8
    //   140: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 1473
    //   146: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload_3
    //   150: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 5
    //   161: getfield 1474	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_session_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   164: aload 6
    //   166: invokestatic 212	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   169: invokevirtual 218	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   172: aload 5
    //   174: getfield 1475	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   177: aload_1
    //   178: invokestatic 228	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   181: invokevirtual 233	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   184: aload 5
    //   186: getfield 1476	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_src_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: iload_2
    //   190: invokevirtual 242	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   193: aload 5
    //   195: getfield 1479	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: aload 7
    //   200: invokestatic 212	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   203: invokevirtual 218	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   206: aload 5
    //   208: getfield 1482	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:bytes_version	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: aload 8
    //   213: invokestatic 212	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   216: invokevirtual 218	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   219: aload 5
    //   221: getfield 1485	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uin32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   224: iload_3
    //   225: invokevirtual 242	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   228: aload 5
    //   230: getfield 1486	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   233: iload 4
    //   235: invokevirtual 242	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   238: aload 5
    //   240: invokevirtual 1487	com/tencent/pb/emosm/PicSearchWordsSvr$ReqBody:toByteArray	()[B
    //   243: astore_1
    //   244: aload_1
    //   245: arraylength
    //   246: iconst_4
    //   247: iadd
    //   248: invokestatic 1109	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   251: astore 5
    //   253: aload 5
    //   255: aload_1
    //   256: arraylength
    //   257: iconst_4
    //   258: iadd
    //   259: invokevirtual 1111	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   262: aload_1
    //   263: invokevirtual 1114	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   266: pop
    //   267: aload 5
    //   269: invokevirtual 1117	java/nio/ByteBuffer:array	()[B
    //   272: astore_1
    //   273: new 1119	mqq/app/NewIntent
    //   276: dup
    //   277: aload_0
    //   278: getfield 80	yhf:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   281: invokevirtual 105	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: ldc_w 1121
    //   287: invokespecial 1124	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   290: astore 5
    //   292: aload 5
    //   294: ldc_w 1126
    //   297: aload_1
    //   298: invokevirtual 1130	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   301: pop
    //   302: aload 5
    //   304: ldc_w 1132
    //   307: ldc_w 1489
    //   310: invokevirtual 1137	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   313: pop
    //   314: aload_0
    //   315: getfield 80	yhf:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: aload 5
    //   320: invokevirtual 1162	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   323: goto -310 -> 13
    //   326: astore_1
    //   327: aload_0
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	yhf
    //   0	331	1	paramString	String
    //   0	331	2	paramInt1	int
    //   0	331	3	paramInt2	int
    //   0	331	4	paramInt3	int
    //   6	313	5	localObject	Object
    //   51	114	6	str1	String
    //   59	140	7	str2	String
    //   71	141	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   2	8	326	finally
    //   16	159	326	finally
    //   159	323	326	finally
  }
  
  public void f(Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()) || (this.aG == null)) {
      return;
    }
    try
    {
      this.aG.addAll(paramCollection);
      t(this.W.getAbsolutePath(), this.aG);
      return;
    }
    finally {}
  }
  
  public void gA(List<StickerRecCacheEntity> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return;
    }
    this.y.post(new StickerRecManager.9(this, paramList));
  }
  
  public void gB(List<yhl> paramList)
  {
    Iterator localIterator = new ArrayList(paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (yhl)localIterator.next();
      if (localObject1 != null)
      {
        Object localObject2 = ((yhl)localObject1).keyword;
        int i = ((yhl)localObject1).recommendType;
        label103:
        Object localObject3;
        if (i == 1)
        {
          paramList = (StickerRecommendSortEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[] { localObject2 });
          if (paramList == null) {
            break label383;
          }
          paramList.convertToList();
          localObject1 = ((yhl)localObject1).exposedList.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (ygl)((Iterator)localObject1).next();
          } while (((ygl)localObject2).Tz());
          localObject2 = (ygz)localObject2;
          localObject3 = Integer.valueOf(((ygz)localObject2).getIndex());
          if (!((ygz)localObject2).isClicked()) {
            break label224;
          }
          if (paramList.clickedList.contains(localObject3)) {
            paramList.removeClicked((Integer)localObject3);
          }
          paramList.addClicked((Integer)localObject3);
        }
        for (;;)
        {
          paramList.removeNoExpose((Integer)localObject3);
          break label103;
          paramList = (StickerRecommendSortEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[] { localObject2 });
          break;
          label224:
          if (!paramList.exposedList.contains(localObject3)) {
            paramList.addExposed((Integer)localObject3);
          }
        }
        paramList.exposedList.removeAll(paramList.clickedList);
        if ((paramList.noExposeList != null) && (paramList.noExposeList.size() == 0))
        {
          localObject1 = paramList.noExposeList;
          paramList.noExposeList = paramList.exposedList;
          paramList.exposedList = ((List)localObject1);
        }
        paramList.convertToString();
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort clicked=" + paramList.clicked + " exposed=" + paramList.exposed + " noExpose=" + paramList.noExpose);
        }
        paramList.recommendType = i;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramList);
        continue;
        label383:
        paramList = new StickerRecommendSortEntity((String)localObject2);
        localObject2 = ((yhl)localObject1).exposedList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ygl)((Iterator)localObject2).next();
          if (!((ygl)localObject3).Tz())
          {
            localObject3 = (ygz)localObject3;
            if (((ygz)localObject3).isClicked()) {
              paramList.addClicked(Integer.valueOf(((ygz)localObject3).getIndex()));
            } else {
              paramList.addExposed(Integer.valueOf(((ygz)localObject3).getIndex()));
            }
          }
        }
        localObject1 = ((yhl)localObject1).sE.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ygl)((Iterator)localObject1).next();
          if (!((ygl)localObject2).Tz()) {
            paramList.addNoExpose(Integer.valueOf(((ygz)localObject2).getIndex()));
          }
        }
        if ((paramList.noExposeList != null) && (paramList.noExposeList.size() == 0))
        {
          localObject1 = paramList.noExposeList;
          paramList.noExposeList = paramList.exposedList;
          paramList.exposedList = ((List)localObject1);
        }
        paramList.convertToString();
        if (QLog.isColorLevel()) {
          QLog.i("StickerRecManager", 2, "updateSort new SortEntity clicked=" + paramList.clicked + " exposed=" + paramList.exposed + " noExpose=" + paramList.noExpose);
        }
        paramList.recommendType = i;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramList);
      }
    }
  }
  
  public String getCurrentText()
  {
    try
    {
      String str = this.mCurrentText;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    label238:
    for (;;)
    {
      return;
      Object localObject;
      String str;
      try
      {
        if (paramFromServiceMsg.getResultCode() != 1000) {
          break label238;
        }
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        aqoj.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramFromServiceMsg.putWupBuffer((byte[])localObject);
        localObject = paramFromServiceMsg.getServiceCmd();
        str = paramIntent.getStringExtra("USER_KEYWORD");
        try
        {
          paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
          if (paramFromServiceMsg == null) {
            continue;
          }
          if (!"PicSearchWordsSvr.PullWords".equals(localObject)) {
            break label123;
          }
          am(paramFromServiceMsg);
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StickerRecManager", 2, aurp.getStackTraceAsString(paramIntent));
        continue;
      }
      finally {}
      label123:
      if ("PicSearchSvr.PullPics".equals(localObject))
      {
        a(paramFromServiceMsg, str, 0);
        a(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 0);
      }
      else if ("BreakIceSvr.Pull".equals(localObject))
      {
        ((alur)this.mApp.getManager(285)).bq(paramFromServiceMsg);
      }
      else if ("SceneFaceRec.PullFaces".equals(localObject))
      {
        a(paramFromServiceMsg, str, 1);
        a(paramFromServiceMsg, str, "network", paramIntent.getBooleanExtra("fromQzone", false), null, 1);
        continue;
        QLog.d("StickerRecManager", 1, String.format("result_code = %s, cmd = %s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()), paramFromServiceMsg.getServiceCmd() }));
      }
    }
  }
  
  public String hD(String paramString)
  {
    return aofy.ok(aqmr.toSemiAngleString(aofy.oe(paramString)).toLowerCase());
  }
  
  public String hE(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return aofy.ok(aqmr.toSemiAngleString(aofy.oe(paramString)));
  }
  
  public boolean hX(String paramString)
  {
    if ((paramString == null) || (this.aG == null)) {
      return false;
    }
    return this.aG.contains(paramString);
  }
  
  public boolean hasInit()
  {
    try
    {
      boolean bool = this.hasInit;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void init()
  {
    if (hasInit())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "init has executed");
      }
      return;
    }
    try
    {
      l1 = SystemClock.elapsedRealtime();
      try
      {
        if (aqhq.fileExists(this.X.getAbsolutePath())) {
          break label119;
        }
        throw new IllegalStateException("words file not exist");
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        long l2;
        Object localObject1;
        Object localObject2;
        List localList;
        long l1 = 0L;
      }
    }
    this.hasInit = false;
    if (QLog.isColorLevel())
    {
      QLog.d("StickerRecManager", 2, aurp.getStackTraceAsString(localException1));
      QLog.d("StickerRecManager", 2, "StickerRecManager error init time cost : " + (SystemClock.elapsedRealtime() - l1));
    }
    A(false, SystemClock.elapsedRealtime() - l1);
    return;
    label119:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = ((BloomFilter)n(this.X.getAbsolutePath()));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter == null) {
      throw new IllegalStateException("words file read error");
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "init bloomFilter, version : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter.version);
    }
    l2 = aqmj.x(this.mApp.getApp(), this.mApp.getCurrentUin());
    if ((!aqhq.fileExists(this.W.getAbsolutePath())) || ((l2 != 0L) && (System.currentTimeMillis() - l2 >= 86400000L)))
    {
      aqmj.B(this.mApp.getApp(), this.mApp.getCurrentUin(), 0L);
      localObject1 = new HashSet();
      localObject2 = this.jdField_a_of_type_Ajdg.fB();
      localList = this.jdField_a_of_type_Ajdg.CR;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Emoticon localEmoticon = (Emoticon)((Iterator)localObject2).next();
          if (localList.isEmpty()) {
            ((HashSet)localObject1).add(localEmoticon.name);
          } else if (localList.contains(localEmoticon.epId)) {
            ((HashSet)localObject1).add(localEmoticon.name);
          }
        }
      }
      if (!((HashSet)localObject1).isEmpty())
      {
        ahbj.deleteFile(this.W.getAbsolutePath());
        t(this.W.getAbsolutePath(), localObject1);
      }
      this.aG = ((HashSet)localObject1);
    }
    for (;;)
    {
      ciq();
      cir();
      this.bYY = c(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), 6);
      localObject1 = (acff)this.mApp.getManager(51);
      if (localObject1 != null) {
        this.jdField_b_of_type_ComTencentMobileqqDataCard = ((acff)localObject1).b(this.mApp.getCurrentAccountUin());
      }
      this.hasInit = true;
      l2 = SystemClock.elapsedRealtime() - l1;
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecManager", 2, "StickerRecManager init time cost : " + l2);
      }
      A(true, l2);
      return;
      this.aG = ((HashSet)n(this.W.getAbsolutePath()));
      if (this.aG == null) {
        ahbj.deleteFile(this.W.getAbsolutePath());
      }
    }
  }
  
  public void onDestroy() {}
  
  public void unInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecManager", 2, "unInit executed");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedBloomFilter = null;
    this.bYY = 6;
    this.jdField_b_of_type_ComTencentMobileqqDataCard = null;
    this.hasInit = false;
    this.aG = null;
  }
  
  public void yG(String paramString)
  {
    try
    {
      this.mCurrentText = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void zY(boolean paramBoolean)
  {
    this.bmE = paramBoolean;
    aqmj.C(BaseApplication.getContext(), this.mApp.getCurrentUin(), paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<ygl> paramList, String paramString1, String paramString2, int paramInt, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhf
 * JD-Core Version:    0.7.0.1
 */