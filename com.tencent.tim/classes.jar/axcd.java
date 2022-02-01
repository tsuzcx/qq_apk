import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class axcd
{
  public static final axcd[] a;
  public static final axcd b;
  public static final axcd[] b;
  public static final axcd c;
  public static final axcd d;
  public final boolean aMh;
  public final String bvV;
  public final String description;
  public final int eEA;
  public final int index;
  
  static
  {
    jdField_b_of_type_Axcd = new axcd(-1, "215Config");
    c = new axcd(0, "AEBasePackage", "new_qq_android_native_short_filter_", 83606);
    d = new axcd(1, "AEAdditionalPackage", "new_qq_android_native_ptu_res_", 83604);
    a = new axcd[] { jdField_b_of_type_Axcd, c, d };
    jdField_b_of_type_ArrayOfAxcd = a();
  }
  
  private axcd(int paramInt, String paramString)
  {
    this.index = paramInt;
    this.description = paramString;
    this.bvV = null;
    this.eEA = -1;
    this.aMh = false;
  }
  
  private axcd(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.index = paramInt1;
    this.description = paramString1;
    this.bvV = paramString2;
    this.eEA = paramInt2;
    this.aMh = true;
  }
  
  private static axcd[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    axcd[] arrayOfaxcd = a;
    int j = arrayOfaxcd.length;
    int i = 0;
    while (i < j)
    {
      axcd localaxcd = arrayOfaxcd[i];
      if (localaxcd.aMh) {
        localLinkedList.add(localaxcd);
      }
      i += 1;
    }
    return (axcd[])localLinkedList.toArray(new axcd[0]);
  }
  
  @NonNull
  public String toString()
  {
    return "{index:" + this.index + ", description:" + this.description + ", resPrefix:" + this.bvV + ", resVersion:" + this.eEA + ", isPackage:" + this.aMh + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcd
 * JD-Core Version:    0.7.0.1
 */