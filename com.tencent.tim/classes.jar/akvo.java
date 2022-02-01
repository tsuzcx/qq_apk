import com.tencent.mobileqq.persistence.EntityDaoRegister;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akvo
{
  public static akvo a = new akvo();
  
  public static akvo a()
  {
    return a;
  }
  
  public OGAbstractDao getEntityDao(Class paramClass)
  {
    return EntityDaoRegister.getEntityDao(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvo
 * JD-Core Version:    0.7.0.1
 */