import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class vie
{
  private final int jdField_a_of_type_Int = 20;
  private atmp jdField_a_of_type_Atmp;
  private String jdField_a_of_type_JavaLangString = "";
  private List<vik> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uwb jdField_a_of_type_Uwb;
  private final vih jdField_a_of_type_Vih;
  private vik jdField_a_of_type_Vik;
  private int b = 1;
  
  public vie(vih paramvih, atmp paramatmp)
  {
    this.jdField_a_of_type_Vih = paramvih;
    this.jdField_a_of_type_Atmp = paramatmp;
  }
  
  public static List<vik> a(atmp paramatmp)
  {
    Object localObject = a(paramatmp, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramatmp = (atmp)localObject;
    if (localObject == null) {
      paramatmp = new ArrayList();
    }
    localObject = new ArrayList();
    paramatmp = paramatmp.iterator();
    while (paramatmp.hasNext()) {
      ((List)localObject).add(new vik((TagItemEntry)paramatmp.next()));
    }
    return localObject;
  }
  
  public static List<? extends atmo> a(atmp paramatmp, Class<? extends atmo> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramatmp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(atmp paramatmp, List<vik> paramList)
  {
    try
    {
      Object localObject = a(paramatmp, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramatmp.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramatmp.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramatmp.b(((vik)paramList.next()).a());
    }
    paramatmp.a().c();
    paramatmp.a().b();
  }
  
  public List<vik> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public vik a()
  {
    return this.jdField_a_of_type_Vik;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Uwb = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Vik = null;
  }
  
  public void a(List<vik> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nonnull uwb paramuwb)
  {
    urk.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramuwb);
    this.jdField_a_of_type_Uwb = paramuwb;
    if (paramuwb.jdField_a_of_type_Boolean) {}
    for (paramuwb = new tak(paramuwb.jdField_a_of_type_Int, paramuwb.jdField_a_of_type_Long, "", 20);; paramuwb = new tak("", 20))
    {
      slv.a().a(paramuwb, new vif(this));
      return;
    }
  }
  
  public void a(vik paramvik)
  {
    this.jdField_a_of_type_Vik = paramvik;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(uwb paramuwb)
  {
    if (this.jdField_a_of_type_Uwb != null) {
      if (this.jdField_a_of_type_Uwb.equals(paramuwb)) {}
    }
    while (paramuwb != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull uwb paramuwb)
  {
    urk.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramuwb);
    this.jdField_a_of_type_Uwb = paramuwb;
    if (paramuwb.jdField_a_of_type_Boolean) {}
    for (paramuwb = new tak(paramuwb.jdField_a_of_type_Int, paramuwb.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramuwb = new tak(this.jdField_a_of_type_JavaLangString, 20))
    {
      slv.a().a(paramuwb, new vig(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vie
 * JD-Core Version:    0.7.0.1
 */