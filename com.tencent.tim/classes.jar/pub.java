import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.lbs.LbsManager.2;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class pub
  implements psj
{
  public static pua a;
  protected boolean aBE;
  public pua b;
  private Object lock = new Object();
  private boolean mIsTimeout;
  private List<pub.a> mListeners = new CopyOnWriteArrayList();
  
  public static pua a()
  {
    return a;
  }
  
  public void a(@NonNull pua parampua, pub.d paramd, pub.c paramc)
  {
    ram.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(parampua.mLatitude), Integer.valueOf(parampua.mLongitude), Integer.valueOf(parampua.mType), paramd);
    WeakReference localWeakReference = new WeakReference(paramc);
    if (paramd == null) {
      paramc = pub.d.a();
    }
    for (;;)
    {
      ram.d("LbsManager", "requestPoiList");
      paramd = ppf.fQ("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramc.avr)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramc.avr));
      }
      localReqGetPOIList.coordinate.set(parampua.mType);
      localReqGetPOIList.count.set(paramc.PAGE_COUNT);
      if (!TextUtils.isEmpty(paramc.avs)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramc.avs));
      }
      localReqGetPOIList.gps.lat.set(parampua.mLatitude);
      localReqGetPOIList.gps.lng.set(parampua.mLongitude);
      localReqGetPOIList.gps.setHasFlag(true);
      parampua = new Bundle();
      ppv.a().a(new pyl(paramd, localReqGetPOIList, parampua), new pud(this, localWeakReference, paramc));
      return;
      paramc = paramd;
      if (!TextUtils.isEmpty(paramd.avr))
      {
        paramd.aBF = false;
        paramc = paramd;
      }
    }
  }
  
  public void a(@NonNull pub.a parama)
  {
    if (!this.mListeners.contains(parama))
    {
      ram.b("LbsManager", "registerLbsListener:%s", parama.getClass().getName());
      this.mListeners.add(parama);
    }
  }
  
  public void aJK()
  {
    this.mIsTimeout = false;
    if (this.aBE)
    {
      ram.w("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.lock)
    {
      if (this.aBE)
      {
        ram.w("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    ram.d("LbsManager", "requestLbs...");
    this.aBE = true;
    SosoInterface.a(new puc(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
  
  public pua b()
  {
    return this.b;
  }
  
  public void b(@NonNull pub.a parama)
  {
    if (this.mListeners.contains(parama))
    {
      ram.b("LbsManager", "unregisterLbsListener:%s", parama.getClass().getName());
      this.mListeners.remove(parama);
    }
  }
  
  public void b(boolean paramBoolean, pua parampua)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((pub.a)localIterator.next()).a(paramBoolean, parampua);
    }
  }
  
  public void onDestroy()
  {
    ram.d("LbsManager", "onDestroy");
    this.mListeners.clear();
  }
  
  public void onInit()
  {
    ram.d("LbsManager", "onInit");
  }
  
  public void vX(int paramInt)
  {
    aJK();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, pua parampua);
  }
  
  public static abstract class b
    extends SosoInterface.a
  {
    public b(String paramString)
    {
      super(true, false, 300000L, false, false, paramString);
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        pub.a = new pua((int)(paramSosoLbsInfo.a.cd * 1000000.0D), (int)(paramSosoLbsInfo.a.ce * 1000000.0D));
        ram.d("LbsManager", "onLocationFinish success : " + pub.a);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt, pub.d paramd, List<TroopBarPOI> paramList);
  }
  
  public static class d
  {
    final int PAGE_COUNT;
    boolean aBF = true;
    HashSet<String> ag = new HashSet();
    boolean ahL = true;
    String avr = "";
    String avs = "";
    public final Bundle bundle = new Bundle();
    
    public d(int paramInt)
    {
      this.PAGE_COUNT = paramInt;
    }
    
    public static d a()
    {
      return new d(20);
    }
    
    public boolean Cz()
    {
      return this.ahL;
    }
    
    public boolean IZ()
    {
      return this.aBF;
    }
    
    public void bmN()
    {
      this.avr = "";
      this.ag.clear();
      this.aBF = true;
    }
    
    public void rq(String paramString)
    {
      if (!TextUtils.equals(paramString, this.avs))
      {
        this.avs = paramString;
        bmN();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pub
 * JD-Core Version:    0.7.0.1
 */