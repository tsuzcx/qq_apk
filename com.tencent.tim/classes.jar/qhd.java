import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class qhd
  extends SimpleObserver<List<qej>>
{
  qhd(qhc.b paramb, qgz.c.a parama) {}
  
  public void dJ(List<qej> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    qgy.d locald = new qgy.d(qhc.b.a(this.a));
    locald.nv = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      qej localqej = (qej)localIterator.next();
      String str = localqej.feedId;
      locald.fR.put(localqej.vid, str);
      locald.nv.add(localqej.vid);
    }
    paramList = qhc.a(paramList);
    if ((paramList != null) && (!qhc.b.a(this.a).JC())) {
      locald.axq = paramList.vid;
    }
    localArrayList.add(locald);
    paramList = this.b;
    if (!qhc.b.a(this.a).JC()) {}
    for (boolean bool = true;; bool = false)
    {
      paramList.C(localArrayList, bool);
      return;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    int i = 0;
    if ((paramError instanceof ErrorMessage)) {
      i = ((ErrorMessage)paramError).errorCode;
    }
    paramError = new ArrayList();
    paramError.add(qhc.b.a(this.a));
    this.b.b(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhd
 * JD-Core Version:    0.7.0.1
 */