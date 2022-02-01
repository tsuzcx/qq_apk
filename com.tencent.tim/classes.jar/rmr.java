import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class rmr
{
  private final int SIZE = 20;
  private reh.a jdField_a_of_type_Reh$a;
  private final rmu jdField_a_of_type_Rmu;
  private rmw jdField_a_of_type_Rmw;
  private String avr = "";
  private int blG = 1;
  private EntityManager mEntityManager;
  private List<rmw> nD = new ArrayList();
  
  public rmr(rmu paramrmu, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Rmu = paramrmu;
    this.mEntityManager = paramEntityManager;
  }
  
  public static List<rmw> a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new rmw((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List<rmw> paramList)
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
      paramEntityManager.persistOrReplace(((rmw)paramList.next()).a());
    }
    paramEntityManager.getTransaction().commit();
    paramEntityManager.getTransaction().end();
  }
  
  @Nullable
  public rmw a()
  {
    return this.jdField_a_of_type_Rmw;
  }
  
  public void a(rmw paramrmw)
  {
    this.jdField_a_of_type_Rmw = paramrmw;
  }
  
  public boolean a(reh.a parama)
  {
    if (this.jdField_a_of_type_Reh$a != null) {
      if (this.jdField_a_of_type_Reh$a.equals(parama)) {}
    }
    while (parama != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull reh.a parama)
  {
    ram.b("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parama);
    this.jdField_a_of_type_Reh$a = parama;
    if (parama.aHk) {}
    for (parama = new pzj(parama.musicType, parama.BP, "", 20);; parama = new pzj("", 20))
    {
      ppv.a().a(parama, new rms(this));
      return;
    }
  }
  
  public void c(@Nonnull reh.a parama)
  {
    ram.b("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parama);
    this.jdField_a_of_type_Reh$a = parama;
    if (parama.aHk) {}
    for (parama = new pzj(parama.musicType, parama.BP, this.avr, 20);; parama = new pzj(this.avr, 20))
    {
      ppv.a().a(parama, new rmt(this));
      return;
    }
  }
  
  public List<rmw> ck()
  {
    return this.nD;
  }
  
  public void fb(List<rmw> paramList)
  {
    this.nD.clear();
    this.nD.addAll(paramList);
  }
  
  public boolean isEnd()
  {
    return this.blG == 1;
  }
  
  public void reset()
  {
    this.nD.clear();
    this.jdField_a_of_type_Reh$a = null;
    this.avr = "";
    this.blG = 1;
    this.jdField_a_of_type_Rmw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmr
 * JD-Core Version:    0.7.0.1
 */