import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class ueg
  extends SimpleObserver<List<ueq>>
{
  ueg(uef paramuef, ufe paramufe) {}
  
  public void a(List<ueq> paramList)
  {
    super.onNext(paramList);
    uef.a(this.jdField_a_of_type_Uef, 0);
    Object localObject = new uej();
    ((uej)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((uej)localObject).jdField_a_of_type_JavaUtilList = paramList;
    uht.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      uef.a(this.jdField_a_of_type_Uef, this.jdField_a_of_type_Ufe.a(), this.jdField_a_of_type_Ufe.b());
    }
    long l = System.currentTimeMillis() - uef.a(this.jdField_a_of_type_Uef);
    String str = uef.a(paramList);
    if (this.jdField_a_of_type_Ufe.a())
    {
      localObject = "2";
      wta.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Ufe.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      wta.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      wsv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Ufe, str });
      uef.a(this.jdField_a_of_type_Uef, this.jdField_a_of_type_Ufe);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new uej();
    ((uej)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((uej)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    uht.a().dispatch((Dispatcher.Dispatchable)localObject);
    uef.a(this.jdField_a_of_type_Uef, 0);
    wsv.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = uef.a(this.jdField_a_of_type_Uef);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Ufe.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      wta.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ueg
 * JD-Core Version:    0.7.0.1
 */