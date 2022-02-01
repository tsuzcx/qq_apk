import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class zle
{
  private final int jdField_a_of_type_Int = 20;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = "";
  private List<zlk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yzb jdField_a_of_type_Yzb;
  private final zlh jdField_a_of_type_Zlh;
  private zlk jdField_a_of_type_Zlk;
  private int b = 1;
  
  public zle(zlh paramzlh, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Zlh = paramzlh;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public static List<zlk> a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new zlk((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List<zlk> paramList)
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
      paramEntityManager.persistOrReplace(((zlk)paramList.next()).a());
    }
    paramEntityManager.getTransaction().commit();
    paramEntityManager.getTransaction().end();
  }
  
  public List<zlk> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public zlk a()
  {
    return this.jdField_a_of_type_Zlk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Yzb = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Zlk = null;
  }
  
  public void a(List<zlk> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nonnull yzb paramyzb)
  {
    yuk.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramyzb);
    this.jdField_a_of_type_Yzb = paramyzb;
    if (paramyzb.jdField_a_of_type_Boolean) {}
    for (paramyzb = new xdl(paramyzb.jdField_a_of_type_Int, paramyzb.jdField_a_of_type_Long, "", 20);; paramyzb = new xdl("", 20))
    {
      wow.a().a(paramyzb, new zlf(this));
      return;
    }
  }
  
  public void a(zlk paramzlk)
  {
    this.jdField_a_of_type_Zlk = paramzlk;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(yzb paramyzb)
  {
    if (this.jdField_a_of_type_Yzb != null) {
      if (this.jdField_a_of_type_Yzb.equals(paramyzb)) {}
    }
    while (paramyzb != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull yzb paramyzb)
  {
    yuk.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramyzb);
    this.jdField_a_of_type_Yzb = paramyzb;
    if (paramyzb.jdField_a_of_type_Boolean) {}
    for (paramyzb = new xdl(paramyzb.jdField_a_of_type_Int, paramyzb.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramyzb = new xdl(this.jdField_a_of_type_JavaLangString, 20))
    {
      wow.a().a(paramyzb, new zlg(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zle
 * JD-Core Version:    0.7.0.1
 */