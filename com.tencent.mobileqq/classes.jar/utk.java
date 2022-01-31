import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.lbs.LbsManager.2;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class utk
  implements uqz
{
  public static utj a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<utn> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public utj b;
  private boolean b;
  
  public static utj a()
  {
    return jdField_a_of_type_Utj;
  }
  
  public void a()
  {
    wsv.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull utj paramutj, utq paramutq, utp paramutp)
  {
    wsv.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramutj.jdField_a_of_type_Int), Integer.valueOf(paramutj.b), Integer.valueOf(paramutj.c), paramutq);
    WeakReference localWeakReference = new WeakReference(paramutp);
    if (paramutq == null) {
      paramutp = utq.a();
    }
    for (;;)
    {
      wsv.b("LbsManager", "requestPoiList");
      paramutq = ume.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramutp.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramutp.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramutj.c);
      localReqGetPOIList.count.set(paramutp.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramutp.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramutp.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramutj.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramutj.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramutj = new Bundle();
      ung.a().a(new vaq(paramutq, localReqGetPOIList, paramutj), new utm(this, localWeakReference, paramutp));
      return;
      paramutp = paramutq;
      if (!TextUtils.isEmpty(paramutq.jdField_a_of_type_JavaLangString))
      {
        paramutq.jdField_b_of_type_Boolean = false;
        paramutp = paramutq;
      }
    }
  }
  
  public void a(@NonNull utn paramutn)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramutn))
    {
      wsv.a("LbsManager", "registerLbsListener:%s", paramutn.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramutn);
    }
  }
  
  public void a(boolean paramBoolean, utj paramutj)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((utn)localIterator.next()).a(paramBoolean, paramutj);
    }
  }
  
  public utj b()
  {
    return this.jdField_b_of_type_Utj;
  }
  
  public void b()
  {
    wsv.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull utn paramutn)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramutn))
    {
      wsv.a("LbsManager", "unregisterLbsListener:%s", paramutn.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramutn);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      wsv.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        wsv.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    wsv.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new utl(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     utk
 * JD-Core Version:    0.7.0.1
 */