import android.support.annotation.NonNull;
import com.tencent.util.Pair;
import cooperation.qqreader.net.BusinessTask;

public final class avop
{
  public static final Pair<Integer, Integer> p = new Pair(Integer.valueOf(1154), Integer.valueOf(1));
  public static final Pair<Integer, Integer> q = new Pair(Integer.valueOf(1529), Integer.valueOf(2));
  public static final Pair<Integer, Integer> r = new Pair(Integer.valueOf(1201), Integer.valueOf(1));
  
  public static void a(@NonNull Pair<Integer, Integer> paramPair, @NonNull avni paramavni)
  {
    a(paramPair, paramavni, false);
  }
  
  public static void a(@NonNull Pair<Integer, Integer> paramPair, @NonNull avni paramavni, boolean paramBoolean)
  {
    paramPair = new BusinessTask("ZzConfigDataTask", paramPair);
    paramPair.a(paramavni, paramBoolean);
    paramPair.execute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avop
 * JD-Core Version:    0.7.0.1
 */