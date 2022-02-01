import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class afhu
  extends affx<CustomEmotionData>
{
  private boolean bYc;
  
  public afhu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private CustomEmotionData a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    CustomEmotionData localCustomEmotionData = null;
    Object localObject = localCustomEmotionData;
    if (paramString1 != null)
    {
      localObject = localCustomEmotionData;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.app != null) {
          break label36;
        }
        localObject = localCustomEmotionData;
      }
    }
    label36:
    String str1;
    afib localafib;
    String str2;
    do
    {
      do
      {
        do
        {
          return localObject;
          str1 = this.app.getCurrentAccountUin();
          localafib = new afib(paramString1);
          localObject = localCustomEmotionData;
        } while (TextUtils.isEmpty(localafib.resid));
        str2 = localafib.flag;
        localObject = localCustomEmotionData;
      } while (str2 == null);
      localObject = localCustomEmotionData;
    } while ("".equals(str2));
    localCustomEmotionData = new CustomEmotionData();
    if (str2.equals("1"))
    {
      localCustomEmotionData.isMarkFace = true;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = localafib.epId;
      localCustomEmotionData.eId = localafib.eId;
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.url = afhs.B(paramString1, paramString2, str1);
      localCustomEmotionData.emoId = paramInt;
      localCustomEmotionData.isAPNG = paramBoolean;
      localCustomEmotionData.checkMarketFace("createCustomEmotionDataByResId");
    }
    while (!str2.equals("0"))
    {
      localObject = localCustomEmotionData;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavroamingDBManager", 2, "createCustomEmotionDataByResIdList : emotionData = " + localCustomEmotionData + ", emotion name:" + paramString1);
      return localCustomEmotionData;
    }
    localObject = localafib.eId;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!((String)localObject).contains("qto@")) {
        break label397;
      }
      localObject = ((String)localObject).replace("qto@", "qto_");
      localCustomEmotionData.eId = ((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "download funnyPic name.original->" + (String)localObject);
      }
    }
    for (;;)
    {
      localCustomEmotionData.isMarkFace = false;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = afhs.kC(paramString1);
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.md5 = localafib.md5;
      localCustomEmotionData.url = afhs.B(paramString1, paramString2, str1);
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.emoId = paramInt;
      break;
      label397:
      if (((String)localObject).contains("diydoutu@"))
      {
        localCustomEmotionData.eId = localafib.epId;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 2, "download diyemoji name.original->" + paramString1);
        }
      }
    }
  }
  
  private void a(List<String> paramList, String paramString, List<Integer> paramList1, int paramInt, List<CustomEmotionData> paramList2, List<CustomEmotionData> paramList3)
  {
    if (paramList != null)
    {
      List localList = ez();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      if (paramInt < paramList.size())
      {
        String str = (String)paramList.get(paramInt);
        CustomEmotionData localCustomEmotionData2 = a(localList, str);
        boolean bool1;
        label107:
        CustomEmotionData localCustomEmotionData1;
        if (localCustomEmotionData2 == null)
        {
          boolean bool2 = false;
          bool1 = bool2;
          if (paramList1 != null)
          {
            bool1 = bool2;
            if (paramInt <= paramList1.size())
            {
              if (((Integer)paramList1.get(paramInt)).intValue() != 2) {
                break label151;
              }
              bool1 = true;
            }
          }
          j = i + 1;
          localCustomEmotionData1 = a(str, paramString, "needDownload", j, bool1);
        }
        for (;;)
        {
          paramList3.add(localCustomEmotionData1);
          paramInt += 1;
          i = j;
          break;
          label151:
          bool1 = false;
          break label107;
          localCustomEmotionData1 = localCustomEmotionData2;
          j = i;
          if (paramList2 != null)
          {
            if ("init".equals(localCustomEmotionData2.RomaingType)) {
              localCustomEmotionData2.RomaingType = "isUpdate";
            }
            if ((TextUtils.isEmpty(localCustomEmotionData2.url)) && (this.app != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("FavroamingDBManager", 2, "url is null because of old db data exception, fix it");
              }
              localCustomEmotionData2.url = afhs.B(str, paramString, this.app.getCurrentAccountUin());
            }
            paramList2.remove(localCustomEmotionData2);
            localCustomEmotionData1 = localCustomEmotionData2;
            j = i;
          }
        }
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "localNew=" + paramList2.size());
      }
      paramList3.addAll(paramList2);
    }
  }
  
  private int b(List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2)
  {
    int i = 0;
    if (paramList1 != null)
    {
      i = paramList1.size() - 1;
      while (i >= 0)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList1.get(i);
        if ((localCustomEmotionData != null) && (!paramList2.contains(localCustomEmotionData))) {
          paramList1.remove(i);
        }
        i -= 1;
      }
      i = paramList1.size();
    }
    return i;
  }
  
  @NotNull
  private List<CustomEmotionData> ba(List<CustomEmotionData> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > afhs.cQW) {
      localObject = paramList.subList(0, afhs.cQW);
    }
    int i = 0;
    if (i < ((List)localObject).size())
    {
      paramList = (CustomEmotionData)((List)localObject).get(i);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "local emo: " + paramList);
      }
      if (i <= afhs.cQV) {
        if (paramList.RomaingType != null) {
          if (paramList.RomaingType.equals("overflow_downloaded")) {
            paramList.RomaingType = "isUpdate";
          }
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramList.url)) && (paramList.url.startsWith("http://"))) {
          paramList.url = paramList.url.replace("http://", "https://");
        }
        i += 1;
        break;
        if ((!paramList.RomaingType.equals("isUpdate")) && (!paramList.RomaingType.equals("init")) && (!paramList.RomaingType.equals("needUpload")) && (!paramList.RomaingType.equals("failed")))
        {
          paramList.RomaingType = "needDownload";
          continue;
          paramList.RomaingType = "needDownload";
          continue;
          if (i <= afhs.cQW) {
            if (paramList.RomaingType != null)
            {
              if (paramList.RomaingType.equals("isUpdate")) {
                paramList.RomaingType = "overflow_downloaded";
              } else if ((!paramList.RomaingType.equals("overflow_downloaded")) && (!paramList.RomaingType.equals("init")) && (!paramList.RomaingType.equals("needUpload")) && (!paramList.RomaingType.equals("failed"))) {
                paramList.RomaingType = "overflow";
              }
            }
            else {
              paramList.RomaingType = "overflow";
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private void kh(List<String> paramList)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = ez();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CustomEmotionData localCustomEmotionData = a(localList, (String)paramList.next());
        if (localCustomEmotionData != null) {
          localArrayList.add(localCustomEmotionData);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "deleDatas=" + localArrayList.size());
      }
      jT(localArrayList);
    }
  }
  
  private int r(List<CustomEmotionData> paramList)
  {
    int j;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 1;
      j = i;
      if (!paramList.hasNext()) {
        break label55;
      }
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList.next();
      if (i >= localCustomEmotionData.emoId) {
        break label57;
      }
      i = localCustomEmotionData.emoId;
    }
    label55:
    label57:
    for (;;)
    {
      break;
      j = 1;
      return j;
    }
  }
  
  public affy<CustomEmotionData> a()
  {
    return (afhv)this.app.getManager(103);
  }
  
  public afmi a(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData.isMarkFace)
    {
      localObject1 = new afpu(this.app.getCurrentAccountUin());
      ((afpu)localObject1).type = 6;
      localObject2 = paramCustomEmotionData.eId;
      String str = paramCustomEmotionData.emoPath;
      ((afpu)localObject1).isAPNG = paramCustomEmotionData.isAPNG;
      ((afpu)localObject1).e = ((ajdg)this.app.getManager(14)).a(str, (String)localObject2);
      ((afpu)localObject1).src_type = 2;
      ((afpu)localObject1).bDZ = paramCustomEmotionData.RomaingType;
      ((afpu)localObject1).emoId = paramCustomEmotionData.emoId;
      return localObject1;
    }
    Object localObject1 = ((afim)this.app.getManager(141)).al();
    Object localObject2 = new afpg();
    ((afpg)localObject2).type = 4;
    ((afpg)localObject2).path = a(paramCustomEmotionData);
    ((afpg)localObject2).src_type = 2;
    ((afpg)localObject2).eId = paramCustomEmotionData.eId;
    ((afpg)localObject2).url = paramCustomEmotionData.url;
    if (localObject1 != null) {
      ((afpg)localObject2).actionData = afpg.c((Map)localObject1, paramCustomEmotionData.md5);
    }
    ((afpg)localObject2).bDZ = paramCustomEmotionData.RomaingType;
    ((afpg)localObject2).emoId = paramCustomEmotionData.emoId;
    ((afpg)localObject2).bnT = paramCustomEmotionData.resid;
    return localObject2;
  }
  
  public CustomEmotionData a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateUpload.");
    }
    CustomEmotionData localCustomEmotionData = a(ez(), paramString);
    if (localCustomEmotionData != null)
    {
      localCustomEmotionData.resid = paramString;
      localCustomEmotionData.RomaingType = "isUpdate";
      b(localCustomEmotionData);
    }
    return localCustomEmotionData;
  }
  
  public CustomEmotionData a(List<CustomEmotionData> paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramList == null) || (paramList.size() < 1)) {
      return null;
    }
    int j = paramList.size();
    int i = 0;
    CustomEmotionData localCustomEmotionData;
    for (;;)
    {
      if (i < j)
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        if ((localCustomEmotionData == null) || ((localCustomEmotionData.RomaingType != null) && (localCustomEmotionData.RomaingType.equals("needUpload"))) || ((localCustomEmotionData.RomaingType != null) && (localCustomEmotionData.RomaingType.equals("failed")))) {
          label98:
          i += 1;
        } else if ((!TextUtils.isEmpty(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(paramString))) {
          paramList = localCustomEmotionData;
        }
      }
    }
    for (;;)
    {
      label131:
      return paramList;
      Object localObject = new afib(paramString);
      if (!((afib)localObject).ajo())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FavroamingDBManager", 2, "res id is not valid:" + paramString);
        return null;
      }
      if (localCustomEmotionData.isMarkFace)
      {
        str = ((afib)localObject).epId;
        localObject = ((afib)localObject).eId;
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!str.equals(localCustomEmotionData.emoPath)) || (!((String)localObject).equals(localCustomEmotionData.eId))) {
          break label98;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        continue;
      }
      localObject = ((afib)localObject).md5;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label98;
      }
      if (!TextUtils.isEmpty(localCustomEmotionData.md5)) {}
      for (String str = localCustomEmotionData.md5;; str = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = str;
        if (!((String)localObject).equals(str)) {
          break;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        break label131;
      }
      paramList = null;
    }
  }
  
  public String a(CustomEmotionData paramCustomEmotionData)
  {
    Object localObject1;
    if (paramCustomEmotionData == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) {
        return paramCustomEmotionData.emoPath;
      }
      localObject1 = acbn.bmd;
      localObject2 = (afim)this.app.getManager(141);
      if ((localObject2 != null) && (((afim)localObject2).a(paramCustomEmotionData)))
      {
        if ((!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) && (paramCustomEmotionData.emoPath.startsWith(acbn.bmd))) {
          return paramCustomEmotionData.emoPath;
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.md5)) {
          return ((afim)localObject2).getFilePath(paramCustomEmotionData.md5);
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.resid)) {
          return (String)localObject1 + aczs.jH(paramCustomEmotionData.resid);
        }
        return (String)localObject1 + paramCustomEmotionData.url.substring(paramCustomEmotionData.url.lastIndexOf("/") + 1);
      }
      if ((paramCustomEmotionData.url != null) && (paramCustomEmotionData.url.contains("qto_"))) {
        return (String)localObject1 + acfi.jj(paramCustomEmotionData.url);
      }
      if (TextUtils.isEmpty(acfi.jj(paramCustomEmotionData.eId))) {
        break;
      }
      localObject2 = (String)localObject1 + paramCustomEmotionData.eId;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("FavroamingDBManager", 2, "emotion is FunnyPic path download from server->" + paramCustomEmotionData.eId);
    return localObject2;
    return (String)localObject1 + paramCustomEmotionData.resid;
  }
  
  public List<CustomEmotionData> a(List<String> paramList1, List<String> paramList2, String paramString, List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = j(paramList1, paramList2);
    if ((localList != null) && (localList.size() > 0))
    {
      localArrayList.addAll(localList);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "localUpdatedNotInServerList=" + localList.size());
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      localArrayList.addAll(paramList1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-1.");
    }
    kh(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-2.");
    }
    paramList1 = ez();
    int i = r(paramList1);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-3.");
    }
    localArrayList = new ArrayList();
    a(paramList2, paramString, paramList, i, paramList1, localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingDBManager", 1, "mergeSize=" + localArrayList.size());
    }
    paramList2 = ba(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
    }
    paramString = ez();
    i = 0;
    if (paramString != null)
    {
      i = paramString.size();
      jT(paramString);
    }
    this.zz.clear();
    this.zz.addAll(paramList2);
    S(paramList2, 1);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
    }
    paramString = (acef)this.app.getBusinessHandler(72);
    if (paramList2.size() > 0) {
      paramString.Q(paramList2, 2);
    }
    int j = b(paramList1, paramList2);
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingDBManager", 2, "updateFavEmotionsInLocalEx final cache size: " + paramList2.size() + ",delete size:" + i + ",upload size:" + j);
    }
    return paramList1;
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {}
    while (!"needDel".equals(paramCustomEmotionData.RomaingType)) {
      return false;
    }
    if (paramInt <= afhs.cQV) {}
    for (Object localObject = "isUpdate";; localObject = "overflow_downloaded")
    {
      paramCustomEmotionData.RomaingType = ((String)localObject);
      b(paramCustomEmotionData);
      localObject = (afhv)a();
      if (localObject != null) {
        ((afhv)localObject).d(paramCustomEmotionData);
      }
      return true;
    }
  }
  
  public void cZs()
  {
    if (!this.bYc)
    {
      this.bYc = true;
      afht.p(false, 8, 0);
    }
  }
  
  public List<afmi> eA()
  {
    aqmq.track("AIO_EmoticonPanel_Refresh", null);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from getFavEmotionInfoShowedInPanel.");
    }
    List localList = ez();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      Object localObject1;
      Object localObject2;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          localObject1 = (CustomEmotionData)localList.get(i);
          if ("needDel".equals(((CustomEmotionData)localObject1).RomaingType))
          {
            QLog.d("FavroamingDBManager", 1, "data need delete, do not need display -> resId:" + ((CustomEmotionData)localObject1).resid);
          }
          else
          {
            localObject2 = a((CustomEmotionData)localObject1);
            if ((localObject2 instanceof afpu))
            {
              localObject2 = (afpu)localObject2;
              if (((afpu)localObject2).e != null) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
        aqmq.track(null, "AIO_EmoticonPanel_Refresh");
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "getFavEmotionInfoShowedInPanel, display size:" + localArrayList.size());
      }
      return localArrayList;
      QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + ((CustomEmotionData)localObject1).toString());
      break label322;
      if ((localObject2 instanceof afpg))
      {
        localObject1 = (afpg)localObject2;
        if ((TextUtils.isEmpty(((afpg)localObject1).path)) && (TextUtils.isEmpty(((afpg)localObject1).url))) {
          QLog.e("FavroamingDBManager", 1, "path and url is null! " + ((afpg)localObject1).toString());
        } else {
          localArrayList.add(localObject1);
        }
      }
      label322:
      i -= 1;
    }
  }
  
  protected List<afmi> eB()
  {
    Map localMap = ((afim)this.app.getManager(141)).al();
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from syncGetCustomEmotionInfoShowedInPreview.");
    }
    List localList = ez();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      CustomEmotionData localCustomEmotionData;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          localCustomEmotionData = (CustomEmotionData)localList.get(i);
          if (!"isUpdate".equals(localCustomEmotionData.RomaingType))
          {
            QLog.d("FavroamingDBManager", 1, "data need hidden, do not need display -> resId:" + localCustomEmotionData.resid);
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            localObject = new afpu(this.app.getCurrentAccountUin());
            ((afpu)localObject).type = 6;
            String str1 = localCustomEmotionData.eId;
            String str2 = localCustomEmotionData.emoPath;
            ((afpu)localObject).isAPNG = localCustomEmotionData.isAPNG;
            ((afpu)localObject).e = ((ajdg)this.app.getManager(14)).a(str2, str1);
            ((afpu)localObject).src_type = 2;
            if (((afpu)localObject).e != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPreview, display size:" + localArrayList.size());
      }
      return localArrayList;
      QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + localCustomEmotionData.toString());
      break label471;
      Object localObject = new afpg();
      ((afpg)localObject).type = 4;
      ((afpg)localObject).path = a(localCustomEmotionData);
      ((afpg)localObject).src_type = 2;
      ((afpg)localObject).eId = localCustomEmotionData.eId;
      ((afpg)localObject).url = localCustomEmotionData.url;
      ((afpg)localObject).actionData = afpg.c(localOutOfMemoryError, localCustomEmotionData.md5);
      ((afpg)localObject).bDZ = localCustomEmotionData.RomaingType;
      ((afpg)localObject).emoId = localCustomEmotionData.emoId;
      ((afpg)localObject).bnT = localCustomEmotionData.resid;
      if ((TextUtils.isEmpty(((afpg)localObject).path)) && (TextUtils.isEmpty(((afpg)localObject).url))) {
        QLog.e("FavroamingDBManager", 1, "path and url is null! " + ((afpg)localObject).toString());
      } else {
        localArrayList.add(localObject);
      }
      label471:
      i -= 1;
    }
  }
  
  /* Error */
  public List<CustomEmotionData> eH()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: new 248	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 249	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 24	afhu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: ifnonnull +10 -> 29
    //   22: aload 8
    //   24: astore 9
    //   26: aload 9
    //   28: areturn
    //   29: aload_0
    //   30: getfield 24	afhu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 511	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   36: invokevirtual 517	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore 11
    //   41: aload 11
    //   43: ifnull +379 -> 422
    //   46: aload 11
    //   48: aload_0
    //   49: invokevirtual 521	afhu:h	()Ljava/lang/Class;
    //   52: iconst_0
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 527	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   62: astore 9
    //   64: ldc_w 529
    //   67: aload_0
    //   68: getfield 24	afhu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: invokevirtual 532	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   74: invokestatic 536	aczs:D	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: iconst_1
    //   78: if_icmpge +335 -> 413
    //   81: aload 11
    //   83: invokevirtual 540	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   86: astore 10
    //   88: aload 9
    //   90: ifnonnull +156 -> 246
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: iconst_1
    //   97: isub
    //   98: istore 5
    //   100: iconst_0
    //   101: istore_1
    //   102: iload 5
    //   104: iconst_m1
    //   105: if_icmple +271 -> 376
    //   108: iload_1
    //   109: istore_2
    //   110: iload_1
    //   111: istore 4
    //   113: aload 9
    //   115: iload 5
    //   117: invokeinterface 170 2 0
    //   122: checkcast 52	com/tencent/mobileqq/data/CustomEmotionData
    //   125: astore 8
    //   127: iload_1
    //   128: istore_2
    //   129: iload_1
    //   130: istore 4
    //   132: aload 8
    //   134: getfield 69	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   137: new 109	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   144: getstatic 369	acbn:bmd	Ljava/lang/String;
    //   147: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 8
    //   152: getfield 74	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   155: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +93 -> 257
    //   167: iload_1
    //   168: istore_2
    //   169: iload_1
    //   170: istore 4
    //   172: aload 8
    //   174: new 109	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   181: getstatic 369	acbn:bmd	Ljava/lang/String;
    //   184: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 8
    //   189: getfield 74	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   192: invokestatic 380	aczs:jH	(Ljava/lang/String;)Ljava/lang/String;
    //   195: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: putfield 69	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   204: iload_1
    //   205: istore_3
    //   206: iload_1
    //   207: ifne +15 -> 222
    //   210: iload_1
    //   211: istore_2
    //   212: iload_1
    //   213: istore 4
    //   215: aload 10
    //   217: invokevirtual 545	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   220: iconst_1
    //   221: istore_3
    //   222: iload_3
    //   223: istore_2
    //   224: iload_3
    //   225: istore 4
    //   227: aload 11
    //   229: aload 8
    //   231: invokevirtual 549	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   234: pop
    //   235: iload_3
    //   236: istore_1
    //   237: iload 5
    //   239: iconst_1
    //   240: isub
    //   241: istore 5
    //   243: goto -141 -> 102
    //   246: aload 9
    //   248: invokeinterface 166 1 0
    //   253: istore_1
    //   254: goto -159 -> 95
    //   257: iload_1
    //   258: istore_2
    //   259: iload_1
    //   260: istore 4
    //   262: aload 8
    //   264: getfield 69	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   267: new 109	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   274: getstatic 369	acbn:bmd	Ljava/lang/String;
    //   277: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 8
    //   282: getfield 63	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   285: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 551
    //   291: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokevirtual 554	java/lang/String:matches	(Ljava/lang/String;)Z
    //   300: ifeq +399 -> 699
    //   303: iload_1
    //   304: istore_2
    //   305: iload_1
    //   306: istore 4
    //   308: aload 8
    //   310: getfield 63	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   313: astore 12
    //   315: iload_1
    //   316: istore_2
    //   317: iload_1
    //   318: istore 4
    //   320: aload 8
    //   322: aload 8
    //   324: getfield 69	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   327: aload 12
    //   329: aload 12
    //   331: invokestatic 380	aczs:jH	(Ljava/lang/String;)Ljava/lang/String;
    //   334: invokevirtual 141	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   337: putfield 69	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   340: iload_1
    //   341: istore_3
    //   342: iload_1
    //   343: ifne +15 -> 358
    //   346: iload_1
    //   347: istore_2
    //   348: iload_1
    //   349: istore 4
    //   351: aload 10
    //   353: invokevirtual 545	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   356: iconst_1
    //   357: istore_3
    //   358: iload_3
    //   359: istore_2
    //   360: iload_3
    //   361: istore 4
    //   363: aload 11
    //   365: aload 8
    //   367: invokevirtual 549	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   370: pop
    //   371: iload_3
    //   372: istore_1
    //   373: goto -136 -> 237
    //   376: iload_1
    //   377: ifeq +13 -> 390
    //   380: iload_1
    //   381: istore_2
    //   382: iload_1
    //   383: istore 4
    //   385: aload 10
    //   387: invokevirtual 557	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   390: iload_1
    //   391: ifeq +8 -> 399
    //   394: aload 10
    //   396: invokevirtual 560	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   399: ldc_w 529
    //   402: aload_0
    //   403: getfield 24	afhu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   406: invokevirtual 532	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   409: iconst_1
    //   410: invokestatic 564	aczs:J	(Ljava/lang/String;Ljava/lang/String;I)V
    //   413: aload 11
    //   415: invokevirtual 567	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   418: aload 9
    //   420: astore 8
    //   422: iload 7
    //   424: istore_2
    //   425: aload 8
    //   427: ifnull +182 -> 609
    //   430: iload 7
    //   432: istore_2
    //   433: aload 8
    //   435: invokeinterface 166 1 0
    //   440: ifle +169 -> 609
    //   443: new 248	java/util/ArrayList
    //   446: dup
    //   447: invokespecial 249	java/util/ArrayList:<init>	()V
    //   450: astore 9
    //   452: aload 8
    //   454: invokeinterface 253 1 0
    //   459: astore 10
    //   461: iload 6
    //   463: istore_1
    //   464: iload_1
    //   465: istore_2
    //   466: aload 10
    //   468: invokeinterface 258 1 0
    //   473: ifeq +136 -> 609
    //   476: aload 10
    //   478: invokeinterface 262 1 0
    //   483: checkcast 52	com/tencent/mobileqq/data/CustomEmotionData
    //   486: astore 11
    //   488: aload 11
    //   490: getfield 77	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   493: invokestatic 20	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifeq +74 -> 570
    //   499: aload 11
    //   501: ldc 187
    //   503: putfield 77	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   506: aload 9
    //   508: aload 11
    //   510: invokeinterface 185 2 0
    //   515: pop
    //   516: iconst_1
    //   517: istore_1
    //   518: aload_0
    //   519: aload 11
    //   521: iconst_1
    //   522: invokevirtual 570	afhu:b	(Lcom/tencent/mobileqq/data/CustomEmotionBase;I)V
    //   525: goto -61 -> 464
    //   528: astore 8
    //   530: iconst_0
    //   531: istore 4
    //   533: iload 4
    //   535: istore_2
    //   536: aload 8
    //   538: invokevirtual 573	java/lang/Exception:printStackTrace	()V
    //   541: iload 4
    //   543: ifeq -144 -> 399
    //   546: aload 10
    //   548: invokevirtual 560	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   551: goto -152 -> 399
    //   554: astore 8
    //   556: iconst_0
    //   557: istore_2
    //   558: iload_2
    //   559: ifeq +8 -> 567
    //   562: aload 10
    //   564: invokevirtual 560	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   567: aload 8
    //   569: athrow
    //   570: aload 11
    //   572: getfield 77	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   575: ldc 238
    //   577: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   580: ifeq -62 -> 518
    //   583: aload 11
    //   585: ldc 240
    //   587: putfield 77	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   590: aload 9
    //   592: aload 11
    //   594: invokeinterface 185 2 0
    //   599: pop
    //   600: aload_0
    //   601: invokevirtual 575	afhu:cZs	()V
    //   604: iconst_1
    //   605: istore_1
    //   606: goto -88 -> 518
    //   609: aload_0
    //   610: invokevirtual 578	afhu:trimCache	()V
    //   613: iload_2
    //   614: ifeq +10 -> 624
    //   617: aload_0
    //   618: aload 8
    //   620: iconst_2
    //   621: invokevirtual 433	afhu:S	(Ljava/util/List;I)V
    //   624: aload 8
    //   626: ifnonnull +67 -> 693
    //   629: new 248	java/util/ArrayList
    //   632: dup
    //   633: invokespecial 249	java/util/ArrayList:<init>	()V
    //   636: astore 8
    //   638: aload 8
    //   640: astore 9
    //   642: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq -619 -> 26
    //   648: ldc 107
    //   650: iconst_2
    //   651: new 109	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 580
    //   661: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 8
    //   666: invokeinterface 166 1 0
    //   671: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   680: aload 8
    //   682: areturn
    //   683: astore 8
    //   685: goto -127 -> 558
    //   688: astore 8
    //   690: goto -157 -> 533
    //   693: goto -55 -> 638
    //   696: goto -459 -> 237
    //   699: iload 5
    //   701: ifne -5 -> 696
    //   704: goto -328 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	afhu
    //   94	512	1	i	int
    //   109	505	2	j	int
    //   205	167	3	k	int
    //   111	431	4	m	int
    //   98	602	5	n	int
    //   4	458	6	i1	int
    //   1	430	7	i2	int
    //   13	440	8	localObject1	Object
    //   528	9	8	localException1	java.lang.Exception
    //   554	71	8	localList	List
    //   636	45	8	localArrayList	ArrayList
    //   683	1	8	localObject2	Object
    //   688	1	8	localException2	java.lang.Exception
    //   24	617	9	localObject3	Object
    //   86	477	10	localObject4	Object
    //   39	554	11	localObject5	Object
    //   313	17	12	str	String
    // Exception table:
    //   from	to	target	type
    //   246	254	528	java/lang/Exception
    //   246	254	554	finally
    //   113	127	683	finally
    //   132	167	683	finally
    //   172	204	683	finally
    //   215	220	683	finally
    //   227	235	683	finally
    //   262	303	683	finally
    //   308	315	683	finally
    //   320	340	683	finally
    //   351	356	683	finally
    //   363	371	683	finally
    //   385	390	683	finally
    //   536	541	683	finally
    //   113	127	688	java/lang/Exception
    //   132	167	688	java/lang/Exception
    //   172	204	688	java/lang/Exception
    //   215	220	688	java/lang/Exception
    //   227	235	688	java/lang/Exception
    //   262	303	688	java/lang/Exception
    //   308	315	688	java/lang/Exception
    //   320	340	688	java/lang/Exception
    //   351	356	688	java/lang/Exception
    //   363	371	688	java/lang/Exception
    //   385	390	688	java/lang/Exception
  }
  
  public List<CustomEmotionData> ez()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.zz.size() <= 0) {
        break label112;
      }
      Iterator localIterator = this.zz.iterator();
      while (localIterator.hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
        if (localCustomEmotionData != null) {
          localArrayList.add(localCustomEmotionData);
        }
      }
      if (!QLog.isColorLevel()) {
        break label108;
      }
    }
    finally {}
    QLog.d("FavroamingDBManager", 2, "getEmoticonDataList from cache: data size = " + localList.size());
    for (;;)
    {
      label108:
      return localList;
      label112:
      List localList1 = eH();
    }
  }
  
  public Class h()
  {
    return CustomEmotionData.class;
  }
  
  public List<String> j(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return null;
      } while ((paramList1 != null) && (paramList1.size() < 1));
      localArrayList = new ArrayList();
      if (paramList1 != null) {
        localArrayList.addAll(paramList1);
      }
      if (paramList2 != null) {
        localArrayList.addAll(paramList2);
      }
      paramList2 = ar("isUpdate");
    } while (paramList2 == null);
    paramList1 = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      String str = (String)paramList2.next();
      if (!localArrayList.contains(str)) {
        paramList1.add(str);
      }
    }
    return paramList1;
  }
  
  public void kf(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    jT(paramList);
  }
  
  public void kg(List<String> paramList)
  {
    if (paramList == null) {}
    List localList;
    do
    {
      return;
      localList = as("needDel");
    } while (localList == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      int j = 0;
      while (j < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        if ((localCustomEmotionData.resid != null) && (!"".equals(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(str)))
        {
          b(localCustomEmotionData, 4);
          localArrayList.add(localCustomEmotionData);
        }
        j += 1;
      }
      i += 1;
    }
    S(localArrayList, 4);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    afht.a.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhu
 * JD-Core Version:    0.7.0.1
 */