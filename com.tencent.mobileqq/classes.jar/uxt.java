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

public class uxt
  implements uvi
{
  public static uxs a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<uxw> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public uxs b;
  private boolean b;
  
  public static uxs a()
  {
    return jdField_a_of_type_Uxs;
  }
  
  public void a()
  {
    wxe.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull uxs paramuxs, uxz paramuxz, uxy paramuxy)
  {
    wxe.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramuxs.jdField_a_of_type_Int), Integer.valueOf(paramuxs.b), Integer.valueOf(paramuxs.c), paramuxz);
    WeakReference localWeakReference = new WeakReference(paramuxy);
    if (paramuxz == null) {
      paramuxy = uxz.a();
    }
    for (;;)
    {
      wxe.b("LbsManager", "requestPoiList");
      paramuxz = uqn.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramuxy.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramuxy.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramuxs.c);
      localReqGetPOIList.count.set(paramuxy.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramuxy.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramuxy.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramuxs.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramuxs.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramuxs = new Bundle();
      urp.a().a(new vez(paramuxz, localReqGetPOIList, paramuxs), new uxv(this, localWeakReference, paramuxy));
      return;
      paramuxy = paramuxz;
      if (!TextUtils.isEmpty(paramuxz.jdField_a_of_type_JavaLangString))
      {
        paramuxz.jdField_b_of_type_Boolean = false;
        paramuxy = paramuxz;
      }
    }
  }
  
  public void a(@NonNull uxw paramuxw)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramuxw))
    {
      wxe.a("LbsManager", "registerLbsListener:%s", paramuxw.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramuxw);
    }
  }
  
  public void a(boolean paramBoolean, uxs paramuxs)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uxw)localIterator.next()).a(paramBoolean, paramuxs);
    }
  }
  
  public uxs b()
  {
    return this.jdField_b_of_type_Uxs;
  }
  
  public void b()
  {
    wxe.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull uxw paramuxw)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramuxw))
    {
      wxe.a("LbsManager", "unregisterLbsListener:%s", paramuxw.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramuxw);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      wxe.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        wxe.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    wxe.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new uxu(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxt
 * JD-Core Version:    0.7.0.1
 */