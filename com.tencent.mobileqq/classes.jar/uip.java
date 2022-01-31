import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class uip
  extends SimpleObserver<List<uiz>>
{
  uip(uio paramuio, ujn paramujn) {}
  
  public void a(List<uiz> paramList)
  {
    super.onNext(paramList);
    uio.a(this.jdField_a_of_type_Uio, 0);
    Object localObject = new uis();
    ((uis)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((uis)localObject).jdField_a_of_type_JavaUtilList = paramList;
    umc.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      uio.a(this.jdField_a_of_type_Uio, this.jdField_a_of_type_Ujn.a(), this.jdField_a_of_type_Ujn.b());
    }
    long l = System.currentTimeMillis() - uio.a(this.jdField_a_of_type_Uio);
    String str = uio.a(paramList);
    if (this.jdField_a_of_type_Ujn.a())
    {
      localObject = "2";
      wxj.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Ujn.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      wxj.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Ujn, str });
      uio.a(this.jdField_a_of_type_Uio, this.jdField_a_of_type_Ujn);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new uis();
    ((uis)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((uis)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    umc.a().dispatch((Dispatcher.Dispatchable)localObject);
    uio.a(this.jdField_a_of_type_Uio, 0);
    wxe.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = uio.a(this.jdField_a_of_type_Uio);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Ujn.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      wxj.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uip
 * JD-Core Version:    0.7.0.1
 */