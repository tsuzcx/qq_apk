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

public class wva
  implements wsp
{
  public static wuz a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<wvd> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public wuz b;
  private boolean b;
  
  public static wuz a()
  {
    return jdField_a_of_type_Wuz;
  }
  
  public void a()
  {
    yuk.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull wuz paramwuz, wvg paramwvg, wvf paramwvf)
  {
    yuk.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramwuz.jdField_a_of_type_Int), Integer.valueOf(paramwuz.b), Integer.valueOf(paramwuz.c), paramwvg);
    WeakReference localWeakReference = new WeakReference(paramwvf);
    if (paramwvg == null) {
      paramwvf = wvg.a();
    }
    for (;;)
    {
      yuk.b("LbsManager", "requestPoiList");
      paramwvg = wnu.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramwvf.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramwvf.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramwuz.c);
      localReqGetPOIList.count.set(paramwvf.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramwvf.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramwvf.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramwuz.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramwuz.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramwuz = new Bundle();
      wow.a().a(new xcg(paramwvg, localReqGetPOIList, paramwuz), new wvc(this, localWeakReference, paramwvf));
      return;
      paramwvf = paramwvg;
      if (!TextUtils.isEmpty(paramwvg.jdField_a_of_type_JavaLangString))
      {
        paramwvg.jdField_b_of_type_Boolean = false;
        paramwvf = paramwvg;
      }
    }
  }
  
  public void a(@NonNull wvd paramwvd)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramwvd))
    {
      yuk.a("LbsManager", "registerLbsListener:%s", paramwvd.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramwvd);
    }
  }
  
  public void a(boolean paramBoolean, wuz paramwuz)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wvd)localIterator.next()).a(paramBoolean, paramwuz);
    }
  }
  
  public wuz b()
  {
    return this.jdField_b_of_type_Wuz;
  }
  
  public void b()
  {
    yuk.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull wvd paramwvd)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramwvd))
    {
      yuk.a("LbsManager", "unregisterLbsListener:%s", paramwvd.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramwvd);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      yuk.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        yuk.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    yuk.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new wvb(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wva
 * JD-Core Version:    0.7.0.1
 */