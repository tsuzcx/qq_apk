import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class wcb
  extends SimpleObserver<List<wcl>>
{
  wcb(wca paramwca, wcz paramwcz) {}
  
  public void a(List<wcl> paramList)
  {
    super.onNext(paramList);
    wca.a(this.jdField_a_of_type_Wca, 0);
    Object localObject = new wce();
    ((wce)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((wce)localObject).jdField_a_of_type_JavaUtilList = paramList;
    wfo.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      wca.a(this.jdField_a_of_type_Wca, this.jdField_a_of_type_Wcz.a(), this.jdField_a_of_type_Wcz.b());
    }
    long l = System.currentTimeMillis() - wca.a(this.jdField_a_of_type_Wca);
    String str = wca.a(paramList);
    if (this.jdField_a_of_type_Wcz.a())
    {
      localObject = "2";
      yqu.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Wcz.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      yqu.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      yqp.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Wcz, str });
      wca.a(this.jdField_a_of_type_Wca, this.jdField_a_of_type_Wcz);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new wce();
    ((wce)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((wce)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    wfo.a().dispatch((Dispatcher.Dispatchable)localObject);
    wca.a(this.jdField_a_of_type_Wca, 0);
    yqp.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = wca.a(this.jdField_a_of_type_Wca);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Wcz.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      yqu.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcb
 * JD-Core Version:    0.7.0.1
 */