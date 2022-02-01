import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryTask.a;

class ajdj
  implements QueryTask.a<Pair<String, Integer>, EmoticonPackage>
{
  ajdj(ajdg paramajdg) {}
  
  public EmoticonPackage a(Pair<String, Integer> paramPair)
  {
    return this.this$0.c((String)paramPair.first, ((Integer)paramPair.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdj
 * JD-Core Version:    0.7.0.1
 */