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

public class wrf
  implements wou
{
  public static wre a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<wri> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public wre b;
  private boolean b;
  
  public static wre a()
  {
    return jdField_a_of_type_Wre;
  }
  
  public void a()
  {
    yqp.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull wre paramwre, wrl paramwrl, wrk paramwrk)
  {
    yqp.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramwre.jdField_a_of_type_Int), Integer.valueOf(paramwre.b), Integer.valueOf(paramwre.c), paramwrl);
    WeakReference localWeakReference = new WeakReference(paramwrk);
    if (paramwrl == null) {
      paramwrk = wrl.a();
    }
    for (;;)
    {
      yqp.b("LbsManager", "requestPoiList");
      paramwrl = wjz.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramwrk.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramwrk.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramwre.c);
      localReqGetPOIList.count.set(paramwrk.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramwrk.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramwrk.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramwre.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramwre.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramwre = new Bundle();
      wlb.a().a(new wyl(paramwrl, localReqGetPOIList, paramwre), new wrh(this, localWeakReference, paramwrk));
      return;
      paramwrk = paramwrl;
      if (!TextUtils.isEmpty(paramwrl.jdField_a_of_type_JavaLangString))
      {
        paramwrl.jdField_b_of_type_Boolean = false;
        paramwrk = paramwrl;
      }
    }
  }
  
  public void a(@NonNull wri paramwri)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramwri))
    {
      yqp.a("LbsManager", "registerLbsListener:%s", paramwri.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramwri);
    }
  }
  
  public void a(boolean paramBoolean, wre paramwre)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wri)localIterator.next()).a(paramBoolean, paramwre);
    }
  }
  
  public wre b()
  {
    return this.jdField_b_of_type_Wre;
  }
  
  public void b()
  {
    yqp.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull wri paramwri)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramwri))
    {
      yqp.a("LbsManager", "unregisterLbsListener:%s", paramwri.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramwri);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      yqp.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        yqp.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    yqp.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new wrg(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrf
 * JD-Core Version:    0.7.0.1
 */