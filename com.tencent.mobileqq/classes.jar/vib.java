import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class vib
  extends SimpleObserver<List<vil>>
{
  vib(via paramvia, viz paramviz) {}
  
  public void a(List<vil> paramList)
  {
    super.onNext(paramList);
    via.a(this.jdField_a_of_type_Via, 0);
    Object localObject = new vie();
    ((vie)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((vie)localObject).jdField_a_of_type_JavaUtilList = paramList;
    vli.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      via.a(this.jdField_a_of_type_Via, this.jdField_a_of_type_Viz.a(), this.jdField_a_of_type_Viz.b());
    }
    long l = System.currentTimeMillis() - via.a(this.jdField_a_of_type_Via);
    String str = via.a(paramList);
    if (this.jdField_a_of_type_Viz.a())
    {
      localObject = "2";
      xwa.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Viz.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      xwa.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Viz, str });
      via.a(this.jdField_a_of_type_Via, this.jdField_a_of_type_Viz);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new vie();
    ((vie)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((vie)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    vli.a().dispatch((Dispatcher.Dispatchable)localObject);
    via.a(this.jdField_a_of_type_Via, 0);
    xvv.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = via.a(this.jdField_a_of_type_Via);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Viz.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      xwa.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vib
 * JD-Core Version:    0.7.0.1
 */