import com.tencent.util.Pair;
import java.util.Comparator;

class tsi
  implements Comparator<Pair<String, Float>>
{
  tsi(tsh paramtsh) {}
  
  public int a(Pair<String, Float> paramPair1, Pair<String, Float> paramPair2)
  {
    float f1 = ((Float)paramPair1.second).floatValue();
    float f2 = ((Float)paramPair2.second).floatValue();
    if (f2 > f1) {
      return 1;
    }
    if (f1 > f2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsi
 * JD-Core Version:    0.7.0.1
 */