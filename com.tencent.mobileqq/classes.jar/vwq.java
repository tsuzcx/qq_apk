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

public class vwq
  implements vuf
{
  public static vwp a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<vwt> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  protected boolean a;
  public vwp b;
  private boolean b;
  
  public static vwp a()
  {
    return jdField_a_of_type_Vwp;
  }
  
  public void a()
  {
    xvv.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull vwp paramvwp, vww paramvww, vwv paramvwv)
  {
    xvv.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramvwp.jdField_a_of_type_Int), Integer.valueOf(paramvwp.b), Integer.valueOf(paramvwp.c), paramvww);
    WeakReference localWeakReference = new WeakReference(paramvwv);
    if (paramvww == null) {
      paramvwv = vww.a();
    }
    for (;;)
    {
      xvv.b("LbsManager", "requestPoiList");
      paramvww = vpl.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramvwv.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramvwv.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramvwp.c);
      localReqGetPOIList.count.set(paramvwv.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramvwv.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramvwv.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramvwp.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramvwp.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramvwp = new Bundle();
      vqn.a().a(new wdw(paramvww, localReqGetPOIList, paramvwp), new vws(this, localWeakReference, paramvwv));
      return;
      paramvwv = paramvww;
      if (!TextUtils.isEmpty(paramvww.jdField_a_of_type_JavaLangString))
      {
        paramvww.jdField_b_of_type_Boolean = false;
        paramvwv = paramvww;
      }
    }
  }
  
  public void a(@NonNull vwt paramvwt)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramvwt))
    {
      xvv.a("LbsManager", "registerLbsListener:%s", paramvwt.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramvwt);
    }
  }
  
  public void a(boolean paramBoolean, vwp paramvwp)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vwt)localIterator.next()).a(paramBoolean, paramvwp);
    }
  }
  
  public vwp b()
  {
    return this.jdField_b_of_type_Vwp;
  }
  
  public void b()
  {
    xvv.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull vwt paramvwt)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramvwt))
    {
      xvv.a("LbsManager", "unregisterLbsListener:%s", paramvwt.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramvwt);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      xvv.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        xvv.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    xvv.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.startLocation(new vwr(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwq
 * JD-Core Version:    0.7.0.1
 */