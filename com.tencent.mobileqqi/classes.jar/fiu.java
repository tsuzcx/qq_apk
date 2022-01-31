import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.data.HornDetail;
import java.util.Iterator;
import java.util.List;

public class fiu
  implements Runnable
{
  public fiu(NearHornHandler paramNearHornHandler, String paramString) {}
  
  public void run()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = (List)this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.b);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
    }
    if ((localObject1 != null) && (localObject1.size() > 0))
    {
      localObject2 = localObject1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        HornDetail localHornDetail = (HornDetail)((Iterator)localObject2).next();
        if (localHornDetail.hornKey.equals(this.jdField_a_of_type_JavaLangString)) {
          localObject1.remove(localHornDetail);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.c = localObject1;
      NearHornHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler, this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.c, this.jdField_a_of_type_ComTencentMobileqqAppNearHornHandler.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fiu
 * JD-Core Version:    0.7.0.1
 */