import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class puq
  extends SimpleObserver<List<qej>>
{
  ArrayList<String> list = new ArrayList();
  
  puq(pum parampum) {}
  
  public void dJ(List<qej> paramList)
  {
    ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onNext()");
    super.onNext(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      qej localqej = (qej)paramList.get(i);
      if (!localqej.aBR) {
        this.list.add(localqej.vid);
      }
      i += 1;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onComplete()
  {
    ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onComplete()");
    super.onComplete();
    this.this$0.ec(this.list);
  }
  
  public void onError(@NonNull Error paramError)
  {
    ram.d("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onError()");
    super.onError(paramError);
    this.this$0.ec(this.list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puq
 * JD-Core Version:    0.7.0.1
 */