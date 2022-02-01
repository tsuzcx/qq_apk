import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class yme
{
  private final int jdField_a_of_type_Int = 20;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = "";
  private List<ymk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yak jdField_a_of_type_Yak;
  private final ymh jdField_a_of_type_Ymh;
  private ymk jdField_a_of_type_Ymk;
  private int b = 1;
  
  public yme(ymh paramymh, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Ymh = paramymh;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public static List<ymk> a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new ymk((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List<ymk> paramList)
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
      paramEntityManager.persistOrReplace(((ymk)paramList.next()).a());
    }
    paramEntityManager.getTransaction().commit();
    paramEntityManager.getTransaction().end();
  }
  
  public List<ymk> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public ymk a()
  {
    return this.jdField_a_of_type_Ymk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Yak = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Ymk = null;
  }
  
  public void a(List<ymk> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nonnull yak paramyak)
  {
    xvv.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramyak);
    this.jdField_a_of_type_Yak = paramyak;
    if (paramyak.jdField_a_of_type_Boolean) {}
    for (paramyak = new wfb(paramyak.jdField_a_of_type_Int, paramyak.jdField_a_of_type_Long, "", 20);; paramyak = new wfb("", 20))
    {
      vqn.a().a(paramyak, new ymf(this));
      return;
    }
  }
  
  public void a(ymk paramymk)
  {
    this.jdField_a_of_type_Ymk = paramymk;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(yak paramyak)
  {
    if (this.jdField_a_of_type_Yak != null) {
      if (this.jdField_a_of_type_Yak.equals(paramyak)) {}
    }
    while (paramyak != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull yak paramyak)
  {
    xvv.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramyak);
    this.jdField_a_of_type_Yak = paramyak;
    if (paramyak.jdField_a_of_type_Boolean) {}
    for (paramyak = new wfb(paramyak.jdField_a_of_type_Int, paramyak.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramyak = new wfb(this.jdField_a_of_type_JavaLangString, 20))
    {
      vqn.a().a(paramyak, new ymg(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yme
 * JD-Core Version:    0.7.0.1
 */