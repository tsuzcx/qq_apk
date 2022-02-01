import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class zhj
{
  private final int jdField_a_of_type_Int = 20;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = "";
  private List<zhp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yvg jdField_a_of_type_Yvg;
  private final zhm jdField_a_of_type_Zhm;
  private zhp jdField_a_of_type_Zhp;
  private int b = 1;
  
  public zhj(zhm paramzhm, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Zhm = paramzhm;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public static List<zhp> a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new zhp((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List<zhp> paramList)
  {
    try
    {
      Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramEntityManager.remove(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramEntityManager.getTransaction().end();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramEntityManager.persistOrReplace(((zhp)paramList.next()).a());
    }
    paramEntityManager.getTransaction().commit();
    paramEntityManager.getTransaction().end();
  }
  
  public List<zhp> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public zhp a()
  {
    return this.jdField_a_of_type_Zhp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Yvg = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Zhp = null;
  }
  
  public void a(List<zhp> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nonnull yvg paramyvg)
  {
    yqp.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramyvg);
    this.jdField_a_of_type_Yvg = paramyvg;
    if (paramyvg.jdField_a_of_type_Boolean) {}
    for (paramyvg = new wzq(paramyvg.jdField_a_of_type_Int, paramyvg.jdField_a_of_type_Long, "", 20);; paramyvg = new wzq("", 20))
    {
      wlb.a().a(paramyvg, new zhk(this));
      return;
    }
  }
  
  public void a(zhp paramzhp)
  {
    this.jdField_a_of_type_Zhp = paramzhp;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(yvg paramyvg)
  {
    if (this.jdField_a_of_type_Yvg != null) {
      if (this.jdField_a_of_type_Yvg.equals(paramyvg)) {}
    }
    while (paramyvg != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull yvg paramyvg)
  {
    yqp.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramyvg);
    this.jdField_a_of_type_Yvg = paramyvg;
    if (paramyvg.jdField_a_of_type_Boolean) {}
    for (paramyvg = new wzq(paramyvg.jdField_a_of_type_Int, paramyvg.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramyvg = new wzq(this.jdField_a_of_type_JavaLangString, 20))
    {
      wlb.a().a(paramyvg, new zhl(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhj
 * JD-Core Version:    0.7.0.1
 */