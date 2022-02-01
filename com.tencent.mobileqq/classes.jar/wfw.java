import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class wfw
  extends SimpleObserver<List<wgg>>
{
  wfw(wfv paramwfv, wgu paramwgu) {}
  
  public void a(List<wgg> paramList)
  {
    super.onNext(paramList);
    wfv.a(this.jdField_a_of_type_Wfv, 0);
    Object localObject = new wfz();
    ((wfz)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((wfz)localObject).jdField_a_of_type_JavaUtilList = paramList;
    wjj.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      wfv.a(this.jdField_a_of_type_Wfv, this.jdField_a_of_type_Wgu.a(), this.jdField_a_of_type_Wgu.b());
    }
    long l = System.currentTimeMillis() - wfv.a(this.jdField_a_of_type_Wfv);
    String str = wfv.a(paramList);
    if (this.jdField_a_of_type_Wgu.a())
    {
      localObject = "2";
      yup.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Wgu.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      yup.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Wgu, str });
      wfv.a(this.jdField_a_of_type_Wfv, this.jdField_a_of_type_Wgu);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new wfz();
    ((wfz)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((wfz)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    wjj.a().dispatch((Dispatcher.Dispatchable)localObject);
    wfv.a(this.jdField_a_of_type_Wfv, 0);
    yuk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = wfv.a(this.jdField_a_of_type_Wfv);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Wgu.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      yup.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfw
 * JD-Core Version:    0.7.0.1
 */