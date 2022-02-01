import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QueryTask.a;
import java.util.ArrayList;
import java.util.List;

class afqe
  implements QueryTask.a<Void, List<afom>>
{
  afqe(afqc paramafqc) {}
  
  public List<afom> a(Void paramVoid)
  {
    paramVoid = ((ajdg)this.this$0.app.getManager(14)).a(false, afqc.a(this.this$0), false);
    ArrayList localArrayList = new ArrayList();
    if (paramVoid != null) {
      localArrayList.addAll(paramVoid);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqe
 * JD-Core Version:    0.7.0.1
 */