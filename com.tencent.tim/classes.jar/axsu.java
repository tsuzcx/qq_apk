import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.qq.im.capture.paster.PasterDataManager.1;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class axsu
  extends axpm
  implements IEventReceiver, psc.a<pth.a>, pub.c
{
  public static AtomicBoolean eL = new AtomicBoolean(false);
  private axsu.a a;
  protected ayfw.d a;
  public aykn.e a;
  public CopyOnWriteArrayList<aymz> aA;
  public boolean aGP;
  protected ayna b;
  protected aynd b;
  private pth b;
  public pub.d b;
  protected Handler bn = new Handler(Looper.getMainLooper());
  protected Runnable du = new PasterDataManager.1(this);
  private boolean dwv;
  private Context mContext;
  
  public axsu()
  {
    this.jdField_b_of_type_Pub$d = null;
    this.jdField_a_of_type_Aykn$e = new axsv(this);
  }
  
  private void YY(boolean paramBoolean)
  {
    a(null, paramBoolean);
  }
  
  private static void a(ayne paramayne, DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramayne.name = paramDoodleEmojiItem.name;
    paramayne.logoUrl = paramDoodleEmojiItem.icon;
    paramayne.aAD = paramDoodleEmojiItem.download_icon;
    paramayne.aAG = paramDoodleEmojiItem.getLocalEmojiFolderPath();
    paramayne.cXe = paramDoodleEmojiItem.download_wording;
    paramayne.dzZ = "1".equals(paramDoodleEmojiItem.random_position);
    paramayne.sz(paramDoodleEmojiItem.config);
    paramayne.hide = paramDoodleEmojiItem.hide;
    paramayne.mask = paramDoodleEmojiItem.mask;
  }
  
  private void a(Map<String, Map<String, ayna.a>> paramMap, String paramString, ayna.c paramc)
  {
    if (paramc.a() != null) {
      paramc.a().eOL();
    }
    Map localMap = (Map)paramMap.get(paramc.resId);
    if (localMap != null)
    {
      paramMap = (ayna.a)localMap.get(paramString);
      if (paramMap != null) {
        break label94;
      }
      paramMap = (ayna.a)localMap.get("default");
    }
    label94:
    for (;;)
    {
      if (paramMap != null)
      {
        paramc.resName = paramMap.resname;
        paramc.resUrl = paramMap.resurl;
        paramc.tT = paramMap.md5;
      }
      return;
    }
  }
  
  private void a(pth.a parama)
  {
    if (parama != null)
    {
      this.jdField_b_of_type_Ayna.blH = parama.temperature;
      if (parama.auX != null)
      {
        parama = parama.auX.split("\\|");
        if ((parama != null) && (parama.length == 2))
        {
          this.jdField_b_of_type_Ayna.awD = parama[0];
          this.jdField_b_of_type_Ayna.cXf = parama[1];
        }
        parama = this.jdField_b_of_type_Ayna.items.iterator();
        while (parama.hasNext())
        {
          ayna.c localc = (ayna.c)parama.next();
          if (localc.eKF == 6)
          {
            localc.auX = this.jdField_b_of_type_Ayna.awD;
            localc.cXi = this.jdField_b_of_type_Ayna.cXf;
            localc.temperature = this.jdField_b_of_type_Ayna.blH;
          }
        }
      }
    }
  }
  
  private void a(pua parampua, boolean paramBoolean)
  {
    ram.d("PasterDataManager", "requestPoiList");
    pub localpub = (pub)psx.a(9);
    pua localpua = parampua;
    if (parampua == null) {
      localpua = pub.a();
    }
    if (paramBoolean)
    {
      localpub.a(localpua, null, this);
      return;
    }
    localpub.a(localpua, this.jdField_b_of_type_Pub$d, this);
  }
  
  private void af(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 != null) && (this.jdField_b_of_type_Ayna != null) && (!paramString1.equals(this.jdField_b_of_type_Ayna.awA))) {
      this.jdField_b_of_type_Ayna.awA = paramString1;
    }
    if ((paramString2 != null) && (this.jdField_b_of_type_Aynd != null) && (!paramString2.equals(this.jdField_b_of_type_Aynd.poiName))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_b_of_type_Aynd != null) && (i != 0))
      {
        this.jdField_b_of_type_Aynd.poiName = paramString2;
        paramString1 = this.jdField_b_of_type_Aynd.items.iterator();
        while (paramString1.hasNext()) {
          ((aynd.a)paramString1.next()).name = paramString2;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Ayfw$d.a(this.jdField_b_of_type_Aynd);
        }
      }
      if (this.jdField_b_of_type_Ayna != null)
      {
        if (i != 0)
        {
          this.jdField_b_of_type_Ayna.poiName = paramString2;
          paramString1 = this.jdField_b_of_type_Ayna.items.iterator();
          while (paramString1.hasNext())
          {
            ayna.c localc = (ayna.c)paramString1.next();
            if (localc.dAb) {
              localc.location = paramString2;
            }
          }
        }
        paramString1 = this.jdField_b_of_type_Ayna.items.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (ayna.c)paramString1.next();
          if ((paramString2.eKF == 7) && (!this.jdField_b_of_type_Ayna.awA.equals(paramString2.city)) && (this.jdField_b_of_type_Ayna.mCityRes != null)) {
            a(this.jdField_b_of_type_Ayna.mCityRes, this.jdField_b_of_type_Ayna.awA, paramString2);
          }
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Ayfw$d.a(this.jdField_b_of_type_Ayna);
        }
      }
      return;
    }
  }
  
  private void initData()
  {
    Object localObject = (aykn)psx.a(39);
    ((aykn)localObject).eSq();
    String str;
    if (this.jdField_b_of_type_Aynd == null)
    {
      this.jdField_b_of_type_Aynd = new aynd("0");
      this.jdField_b_of_type_Aynd.aIg = true;
      str = aykn.c((aykn)localObject, "0");
      localObject = aykn.a((aykn)localObject, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!aqiw.isNetworkAvailable(this.mContext))) {
        break label113;
      }
      this.jdField_b_of_type_Aynd.logoUrl = ((String)localObject);
    }
    for (;;)
    {
      this.jdField_b_of_type_Aynd.sz(str);
      if (this.jdField_b_of_type_Ayna == null) {
        this.jdField_b_of_type_Ayna = new ayna("2001");
      }
      return;
      label113:
      this.jdField_b_of_type_Aynd.C = this.mContext.getResources().getDrawable(2130847475);
    }
  }
  
  public String If()
  {
    if (this.jdField_b_of_type_Aynd != null) {
      return this.jdField_b_of_type_Aynd.poiName;
    }
    return null;
  }
  
  public ayfw.d a()
  {
    return this.jdField_a_of_type_Ayfw$d;
  }
  
  public aymz a(String paramString)
  {
    return this.jdField_a_of_type_Ayfw$d.b(paramString);
  }
  
  public void a(int paramInt, pub.d paramd, List<TroopBarPOI> paramList)
  {
    ram.d("PasterDataManager", "onPOIListRequestResult." + paramInt);
    if ((paramInt == 0) && (paramd != null))
    {
      this.jdField_b_of_type_Pub$d = paramd;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramd = ((TroopBarPOI)paramList.get(0)).AU();
        if (QLog.isColorLevel()) {
          QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + paramd);
        }
        String str = ShortVideoUtils.ns(QQStoryContext.c().getCurrentAccountUin());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          if (((TroopBarPOI)localIterator.next()).AU().equals(str)) {
            paramd = str;
          }
        }
      }
    }
    for (;;)
    {
      af(((TroopBarPOI)paramList.get(0)).cnF, paramd, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean, pth.a parama)
  {
    if (paramBoolean) {
      a(parama);
    }
  }
  
  public void adn(String paramString)
  {
    af(null, paramString, false);
  }
  
  public void c(pua parampua)
  {
    this.jdField_b_of_type_Pth = ((pth)((psd)psx.a(20)).a(0));
    Object localObject = this.jdField_b_of_type_Pth.a();
    if (localObject != null)
    {
      ram.d("PasterDataManager", "get weather from cache.");
      a((pth.a)localObject);
      return;
    }
    ram.d("PasterDataManager", "get weather from net.");
    localObject = parampua;
    if (parampua == null) {
      localObject = pub.a();
    }
    this.jdField_b_of_type_Pth.a(this);
    this.jdField_b_of_type_Pth.b((pua)localObject);
  }
  
  public void c(boolean paramBoolean, Activity paramActivity)
  {
    if ((this.dwv) && (this.jdField_b_of_type_Ayna != null) && (!"default".equals(this.jdField_b_of_type_Ayna.awA)) && (!"--".equals(this.jdField_b_of_type_Ayna.awD))) {
      return;
    }
    new alxd(paramActivity, new axsw(this, paramBoolean)).Qj();
  }
  
  public void clear()
  {
    this.dwv = false;
  }
  
  public void eIC()
  {
    this.mContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Ayfw$d = new ayfw.d();
    initData();
    this.jdField_a_of_type_Axsu$a = new axsu.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Axsu$a);
    if (QLog.isDevelopLevel()) {
      QLog.d("PasterDataManager", 4, "initPasterConfig");
    }
  }
  
  public List<aymz> hU()
  {
    return y(false);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Axsu$a != null)
    {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Axsu$a);
      this.jdField_a_of_type_Axsu$a = null;
    }
    if (this.jdField_b_of_type_Pth != null) {
      this.jdField_b_of_type_Pth.b(this);
    }
  }
  
  @NonNull
  public List<aymz> y(boolean paramBoolean)
  {
    for (;;)
    {
      DoodleEmojiItem localDoodleEmojiItem;
      Object localObject3;
      try
      {
        if ((this.aA != null) && (this.aA.size() != 0)) {
          break label750;
        }
        Object localObject1 = ((aykn)psx.a(39)).cd();
        this.aA = new CopyOnWriteArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject1).next();
        if (localDoodleEmojiItem.type == 1)
        {
          localObject3 = new ayne(localDoodleEmojiItem.pack_id);
          a((ayne)localObject3, localDoodleEmojiItem);
          if (("1".equals(((ayne)localObject3).id)) && (!aqiw.isNetworkAvailable(this.mContext))) {
            ((ayne)localObject3).C = this.mContext.getResources().getDrawable(2130847332);
          }
          this.aA.add(localObject3);
          continue;
        }
        if (localDoodleEmojiItem.type != 2) {
          break label396;
        }
      }
      finally {}
      this.jdField_b_of_type_Aynd.name = localDoodleEmojiItem.name;
      if ((!TextUtils.isEmpty(localDoodleEmojiItem.icon)) && (aqiw.isNetworkAvailable(this.mContext))) {
        this.jdField_b_of_type_Aynd.logoUrl = localDoodleEmojiItem.icon;
      }
      Object localObject4;
      while (localDoodleEmojiItem.mItemList != null)
      {
        this.jdField_b_of_type_Aynd.items = localDoodleEmojiItem.mItemList;
        if (localDoodleEmojiItem.mItemList == null) {
          break;
        }
        ram.d("PasterDataManager", "add doodle emoji location item name = " + this.jdField_b_of_type_Aynd.poiName);
        localObject3 = localDoodleEmojiItem.mItemList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (aynd.a)((Iterator)localObject3).next();
          ((aynd.a)localObject4).packageName = this.jdField_b_of_type_Aynd.name;
          ((aynd.a)localObject4).name = this.jdField_b_of_type_Aynd.poiName;
        }
        this.jdField_b_of_type_Aynd.C = this.mContext.getResources().getDrawable(2130847475);
      }
      this.jdField_b_of_type_Aynd.dzZ = "1".equals(localDoodleEmojiItem.random_position);
      this.jdField_b_of_type_Aynd.hide = localDoodleEmojiItem.hide;
      this.jdField_b_of_type_Aynd.mask = localDoodleEmojiItem.mask;
      this.aA.add(this.jdField_b_of_type_Aynd);
      continue;
      label396:
      if (localDoodleEmojiItem.type == 3)
      {
        if (this.jdField_b_of_type_Ayna == null) {
          this.jdField_b_of_type_Ayna = new ayna(localDoodleEmojiItem.pack_id);
        }
        for (;;)
        {
          this.jdField_b_of_type_Ayna.name = localDoodleEmojiItem.name;
          this.jdField_b_of_type_Ayna.items = localDoodleEmojiItem.mInfoItemList;
          this.jdField_b_of_type_Ayna.sz(localDoodleEmojiItem.config);
          this.jdField_b_of_type_Ayna.hide = localDoodleEmojiItem.hide;
          this.jdField_b_of_type_Ayna.awA = "default";
          this.jdField_b_of_type_Ayna.blH = -999;
          this.jdField_b_of_type_Ayna.awD = "--";
          this.jdField_b_of_type_Ayna.cXf = "default";
          if (this.jdField_b_of_type_Ayna.items == null) {
            break;
          }
          localObject3 = this.jdField_b_of_type_Ayna.items.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (ayna.c)((Iterator)localObject3).next();
            ((ayna.c)localObject4).packageName = this.jdField_b_of_type_Ayna.name;
            if (aynb.oB(((ayna.c)localObject4).eKF)) {
              ((ayna.c)localObject4).location = this.jdField_b_of_type_Ayna.poiName;
            }
            if ((localDoodleEmojiItem.mCityRes != null) && (((ayna.c)localObject4).eKF == 7)) {
              a(localDoodleEmojiItem.mCityRes, this.jdField_b_of_type_Ayna.awA, (ayna.c)localObject4);
            }
            if (((ayna.c)localObject4).eKF == 6)
            {
              ((ayna.c)localObject4).temperature = this.jdField_b_of_type_Ayna.blH;
              ((ayna.c)localObject4).auX = this.jdField_b_of_type_Ayna.awD;
              ((ayna.c)localObject4).cXi = this.jdField_b_of_type_Ayna.cXf;
            }
          }
          this.jdField_b_of_type_Ayna.id = localDoodleEmojiItem.pack_id;
        }
        this.aA.add(this.jdField_b_of_type_Ayna);
        this.jdField_b_of_type_Ayna.mCityRes = localDoodleEmojiItem.mCityRes;
      }
    }
    ram.d("PasterDataManager", "getDoodleFacePackages, size = " + this.aA.size());
    eL.set(true);
    label750:
    if (paramBoolean)
    {
      StaticStickerProviderView.j(this.aA);
      eL.set(true);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.aA;
    return localCopyOnWriteArrayList;
  }
  
  public static class a
    extends QQUIEventReceiver<axsu, aykn.a>
  {
    public a(@NonNull axsu paramaxsu)
    {
      super();
    }
    
    public void a(@NonNull axsu paramaxsu, @NonNull aykn.a parama)
    {
      paramaxsu = paramaxsu.a;
      if (paramaxsu != null)
      {
        Object localObject = paramaxsu.b(parama.b.pack_id);
        if (!(localObject instanceof ayne))
        {
          ram.w(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parama.b.pack_id);
          return;
        }
        localObject = (ayne)localObject;
        if (parama.mErrorCode == 0)
        {
          if (parama.aBq)
          {
            ram.d(this.TAG, "notify ui we finish downloading");
            ((ayne)localObject).isDownloading = false;
            ((ayne)localObject).aAG = parama.b.getLocalEmojiFolderPath();
            ((ayne)localObject).brW = 0;
            ((ayne)localObject).brX = 0;
            paramaxsu.a((aymz)localObject);
            return;
          }
          ram.d(this.TAG, "notify ui we new progress : " + parama.Ca + " / " + parama.BZ);
          ((ayne)localObject).isDownloading = true;
          ((ayne)localObject).aAG = null;
          ((ayne)localObject).brW = ((int)parama.BZ);
          ((ayne)localObject).brX = ((int)parama.Ca);
          paramaxsu.a((aymz)localObject);
          return;
        }
        if (parama.bkR)
        {
          axsu.b((ayne)localObject, parama.b);
          ((ayne)localObject).oT.clear();
          paramaxsu.a((aymz)localObject);
          return;
        }
        ((ayne)localObject).isDownloading = false;
        ((ayne)localObject).aAG = null;
        ((ayne)localObject).brW = 0;
        ((ayne)localObject).brX = 0;
        paramaxsu.a((aymz)localObject);
        ram.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parama.mErrorCode);
        ras.so("0X80076C9");
        ras.sp("0X80075DE");
        return;
      }
      ram.d(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
    }
    
    public Class acceptEventClass()
    {
      return aykn.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsu
 * JD-Core Version:    0.7.0.1
 */