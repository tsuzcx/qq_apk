import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class vww
  extends SimpleObserver<List<vxg>>
{
  vww(vwv paramvwv, vxu paramvxu) {}
  
  public void a(List<vxg> paramList)
  {
    super.onNext(paramList);
    vwv.a(this.jdField_a_of_type_Vwv, 0);
    Object localObject = new vwz();
    ((vwz)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((vwz)localObject).jdField_a_of_type_JavaUtilList = paramList;
    wad.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      vwv.a(this.jdField_a_of_type_Vwv, this.jdField_a_of_type_Vxu.a(), this.jdField_a_of_type_Vxu.b());
    }
    long l = System.currentTimeMillis() - vwv.a(this.jdField_a_of_type_Vwv);
    String str = vwv.a(paramList);
    if (this.jdField_a_of_type_Vxu.a())
    {
      localObject = "2";
      ykv.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Vxu.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      ykv.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      ykq.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Vxu, str });
      vwv.a(this.jdField_a_of_type_Vwv, this.jdField_a_of_type_Vxu);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new vwz();
    ((vwz)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((vwz)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    wad.a().dispatch((Dispatcher.Dispatchable)localObject);
    vwv.a(this.jdField_a_of_type_Vwv, 0);
    ykq.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = vwv.a(this.jdField_a_of_type_Vwv);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Vxu.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      ykv.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vww
 * JD-Core Version:    0.7.0.1
 */