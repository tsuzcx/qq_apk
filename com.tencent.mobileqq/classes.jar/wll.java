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

public class wll
  implements wja
{
  public static wlk a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<wlo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public wlk b;
  private boolean b;
  
  public static wlk a()
  {
    return jdField_a_of_type_Wlk;
  }
  
  public void a()
  {
    ykq.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull wlk paramwlk, wlr paramwlr, wlq paramwlq)
  {
    ykq.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramwlk.jdField_a_of_type_Int), Integer.valueOf(paramwlk.b), Integer.valueOf(paramwlk.c), paramwlr);
    WeakReference localWeakReference = new WeakReference(paramwlq);
    if (paramwlr == null) {
      paramwlq = wlr.a();
    }
    for (;;)
    {
      ykq.b("LbsManager", "requestPoiList");
      paramwlr = weg.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramwlq.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramwlq.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramwlk.c);
      localReqGetPOIList.count.set(paramwlq.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramwlq.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramwlq.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramwlk.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramwlk.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramwlk = new Bundle();
      wfi.a().a(new wsr(paramwlr, localReqGetPOIList, paramwlk), new wln(this, localWeakReference, paramwlq));
      return;
      paramwlq = paramwlr;
      if (!TextUtils.isEmpty(paramwlr.jdField_a_of_type_JavaLangString))
      {
        paramwlr.jdField_b_of_type_Boolean = false;
        paramwlq = paramwlr;
      }
    }
  }
  
  public void a(@NonNull wlo paramwlo)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramwlo))
    {
      ykq.a("LbsManager", "registerLbsListener:%s", paramwlo.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramwlo);
    }
  }
  
  public void a(boolean paramBoolean, wlk paramwlk)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wlo)localIterator.next()).a(paramBoolean, paramwlk);
    }
  }
  
  public wlk b()
  {
    return this.jdField_b_of_type_Wlk;
  }
  
  public void b()
  {
    ykq.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull wlo paramwlo)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramwlo))
    {
      ykq.a("LbsManager", "unregisterLbsListener:%s", paramwlo.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramwlo);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      ykq.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ykq.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    ykq.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.startLocation(new wlm(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wll
 * JD-Core Version:    0.7.0.1
 */