import java.util.ArrayList;
import java.util.List;

public class ukd
{
  private static String jdField_a_of_type_JavaLangString = "0123456789bcdefghjkmnpqrstuvwxyz";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
  
  public static String a(double paramDouble1, double paramDouble2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d5 = 90.0D;
    double d3 = -90.0D;
    double d2 = 0.0D;
    double d6 = 180.0D;
    double d4 = -180.0D;
    double d1 = 0.0D;
    int i = 1;
    int k = 0;
    while (k < paramInt)
    {
      int m = 0;
      int n = 0;
      int j = i;
      i = n;
      if (m < 5)
      {
        double d8;
        double d7;
        if (j != 0)
        {
          i <<= 1;
          if (paramDouble2 >= d1)
          {
            d8 = (d6 + d1) / 2.0D;
            i += 1;
            d4 = d6;
            d7 = d2;
            d2 = d3;
            d6 = d5;
            d5 = d7;
            d3 = d1;
            d1 = d8;
            label131:
            if (j != 0) {
              break label309;
            }
          }
        }
        label309:
        for (j = 1;; j = 0)
        {
          m += 1;
          d7 = d6;
          d8 = d2;
          d2 = d5;
          d6 = d4;
          d4 = d3;
          d3 = d8;
          d5 = d7;
          break;
          d8 = (d1 + d4) / 2.0D;
          d6 = d3;
          d7 = d5;
          d3 = d4;
          d4 = d1;
          d1 = d8;
          d5 = d2;
          d2 = d6;
          d6 = d7;
          break label131;
          i <<= 1;
          if (paramDouble1 >= d2)
          {
            d3 = (d5 + d2) / 2.0D;
            i += 1;
            d7 = d5;
            d5 = d3;
            d3 = d4;
            d4 = d6;
            d6 = d7;
            break label131;
          }
          d5 = (d2 + d3) / 2.0D;
          d7 = d2;
          d2 = d3;
          d3 = d4;
          d4 = d6;
          d6 = d7;
          break label131;
        }
      }
      localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[i]);
      k += 1;
      i = j;
    }
    return localStringBuilder.toString();
  }
  
  public static List<uke> a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new Error("Invalid geoHash");
    }
    paramString = paramString.toLowerCase();
    int i = 1;
    double d3 = -90.0D;
    double d4 = 90.0D;
    double d1 = -180.0D;
    double d2 = 180.0D;
    int j = 0;
    while (j < paramString.length())
    {
      int k = paramString.charAt(j);
      int m = jdField_a_of_type_JavaLangString.indexOf(k);
      if (m == -1) {
        throw new Error("Invalid geoHash");
      }
      k = 4;
      if (k >= 0)
      {
        double d6 = m >> k & 0x1;
        double d5;
        if (i != 0)
        {
          d5 = (d1 + d2) / 2.0D;
          if (d6 == 1.0D)
          {
            d1 = d5;
            label135:
            if (i != 0) {
              break label190;
            }
          }
        }
        label190:
        for (i = 1;; i = 0)
        {
          k -= 1;
          break;
          d2 = d5;
          break label135;
          d5 = (d3 + d4) / 2.0D;
          if (d6 == 1.0D)
          {
            d3 = d5;
            break label135;
          }
          d4 = d5;
          break label135;
        }
      }
      j += 1;
    }
    paramString = new uke(d3, d1);
    uke localuke = new uke(d4, d2);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(paramString);
    localArrayList.add(localuke);
    return localArrayList;
  }
  
  public static uke a(String paramString)
  {
    Object localObject = a(paramString);
    uke localuke = (uke)((List)localObject).get(0);
    localObject = (uke)((List)localObject).get(1);
    double d3 = uke.a(localuke);
    double d1 = uke.b(localuke);
    double d4 = uke.a((uke)localObject);
    double d2 = uke.b((uke)localObject);
    d3 = (d3 + d4) / 2.0D;
    d1 = (d2 + d1) / 2.0D;
    localuke = new uke(d3, d1);
    wxe.a("Q.qqstory.recommendAlbum.logic.decodeGeoHash", " geoHash=%s, lat=%s, lon=%s", paramString, Double.valueOf(d3), Double.valueOf(d1));
    return localuke;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukd
 * JD-Core Version:    0.7.0.1
 */