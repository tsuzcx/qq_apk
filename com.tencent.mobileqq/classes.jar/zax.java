import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class zax
{
  private final int jdField_a_of_type_Int = 20;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = "";
  private List<zbd> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ypd jdField_a_of_type_Ypd;
  private final zba jdField_a_of_type_Zba;
  private zbd jdField_a_of_type_Zbd;
  private int b = 1;
  
  public zax(zba paramzba, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Zba = paramzba;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public static List<zbd> a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new zbd((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List<zbd> paramList)
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
      paramEntityManager.persistOrReplace(((zbd)paramList.next()).a());
    }
    paramEntityManager.getTransaction().commit();
    paramEntityManager.getTransaction().end();
  }
  
  public List<zbd> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public zbd a()
  {
    return this.jdField_a_of_type_Zbd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Ypd = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Zbd = null;
  }
  
  public void a(List<zbd> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nonnull ypd paramypd)
  {
    ykq.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramypd);
    this.jdField_a_of_type_Ypd = paramypd;
    if (paramypd.jdField_a_of_type_Boolean) {}
    for (paramypd = new wtw(paramypd.jdField_a_of_type_Int, paramypd.jdField_a_of_type_Long, "", 20);; paramypd = new wtw("", 20))
    {
      wfi.a().a(paramypd, new zay(this));
      return;
    }
  }
  
  public void a(zbd paramzbd)
  {
    this.jdField_a_of_type_Zbd = paramzbd;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(ypd paramypd)
  {
    if (this.jdField_a_of_type_Ypd != null) {
      if (this.jdField_a_of_type_Ypd.equals(paramypd)) {}
    }
    while (paramypd != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull ypd paramypd)
  {
    ykq.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramypd);
    this.jdField_a_of_type_Ypd = paramypd;
    if (paramypd.jdField_a_of_type_Boolean) {}
    for (paramypd = new wtw(paramypd.jdField_a_of_type_Int, paramypd.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramypd = new wtw(this.jdField_a_of_type_JavaLangString, 20))
    {
      wfi.a().a(paramypd, new zaz(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zax
 * JD-Core Version:    0.7.0.1
 */