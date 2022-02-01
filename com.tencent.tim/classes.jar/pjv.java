import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class pjv
  extends SimpleObserver<List<pkd>>
{
  pjv(pju parampju, pkm parampkm) {}
  
  public void dJ(List<pkd> paramList)
  {
    super.onNext(paramList);
    pju.a(this.jdField_a_of_type_Pju, 0);
    Object localObject = new pju.a();
    ((pju.a)localObject).b = new ErrorMessage();
    ((pju.a)localObject).lP = paramList;
    pmi.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      pju.a(this.jdField_a_of_type_Pju, this.jdField_a_of_type_Pkm.dC(), this.jdField_a_of_type_Pkm.dD());
    }
    long l = System.currentTimeMillis() - pju.a(this.jdField_a_of_type_Pju);
    String str = pju.r(paramList);
    if (this.jdField_a_of_type_Pkm.Ih())
    {
      localObject = "2";
      rar.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Pkm.Ih()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      rar.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Pkm, str });
      pju.a(this.jdField_a_of_type_Pju, this.jdField_a_of_type_Pkm);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new pju.a();
    ((pju.a)localObject).b = ((ErrorMessage)paramError);
    ((pju.a)localObject).lP = new ArrayList();
    pmi.a().dispatch((Dispatcher.Dispatchable)localObject);
    pju.a(this.jdField_a_of_type_Pju, 0);
    ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = pju.a(this.jdField_a_of_type_Pju);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Pkm.Ih()) {}
    for (paramError = "2";; paramError = "1")
    {
      rar.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjv
 * JD-Core Version:    0.7.0.1
 */