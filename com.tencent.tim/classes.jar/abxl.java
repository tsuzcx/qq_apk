import com.tencent.mobileqq.data.ApolloFavActionData;
import java.util.Comparator;

class abxl
  implements Comparator<ApolloFavActionData>
{
  abxl(abxk paramabxk) {}
  
  public int a(ApolloFavActionData paramApolloFavActionData1, ApolloFavActionData paramApolloFavActionData2)
  {
    if (paramApolloFavActionData2.favId == paramApolloFavActionData1.favId) {
      return 0;
    }
    if (paramApolloFavActionData2.favId > paramApolloFavActionData1.favId) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxl
 * JD-Core Version:    0.7.0.1
 */