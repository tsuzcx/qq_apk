import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class xny
{
  private final int jdField_a_of_type_Int = 20;
  private awgf jdField_a_of_type_Awgf;
  private String jdField_a_of_type_JavaLangString = "";
  private List<xoe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xbv jdField_a_of_type_Xbv;
  private final xob jdField_a_of_type_Xob;
  private xoe jdField_a_of_type_Xoe;
  private int b = 1;
  
  public xny(xob paramxob, awgf paramawgf)
  {
    this.jdField_a_of_type_Xob = paramxob;
    this.jdField_a_of_type_Awgf = paramawgf;
  }
  
  public static List<xoe> a(awgf paramawgf)
  {
    Object localObject = a(paramawgf, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramawgf = (awgf)localObject;
    if (localObject == null) {
      paramawgf = new ArrayList();
    }
    localObject = new ArrayList();
    paramawgf = paramawgf.iterator();
    while (paramawgf.hasNext()) {
      ((List)localObject).add(new xoe((TagItemEntry)paramawgf.next()));
    }
    return localObject;
  }
  
  public static List<? extends awge> a(awgf paramawgf, Class<? extends awge> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawgf.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(awgf paramawgf, List<xoe> paramList)
  {
    try
    {
      Object localObject = a(paramawgf, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramawgf.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramawgf.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramawgf.b(((xoe)paramList.next()).a());
    }
    paramawgf.a().c();
    paramawgf.a().b();
  }
  
  public List<xoe> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public xoe a()
  {
    return this.jdField_a_of_type_Xoe;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Xbv = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Xoe = null;
  }
  
  public void a(List<xoe> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nonnull xbv paramxbv)
  {
    wxe.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramxbv);
    this.jdField_a_of_type_Xbv = paramxbv;
    if (paramxbv.jdField_a_of_type_Boolean) {}
    for (paramxbv = new vge(paramxbv.jdField_a_of_type_Int, paramxbv.jdField_a_of_type_Long, "", 20);; paramxbv = new vge("", 20))
    {
      urp.a().a(paramxbv, new xnz(this));
      return;
    }
  }
  
  public void a(xoe paramxoe)
  {
    this.jdField_a_of_type_Xoe = paramxoe;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(xbv paramxbv)
  {
    if (this.jdField_a_of_type_Xbv != null) {
      if (this.jdField_a_of_type_Xbv.equals(paramxbv)) {}
    }
    while (paramxbv != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull xbv paramxbv)
  {
    wxe.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramxbv);
    this.jdField_a_of_type_Xbv = paramxbv;
    if (paramxbv.jdField_a_of_type_Boolean) {}
    for (paramxbv = new vge(paramxbv.jdField_a_of_type_Int, paramxbv.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramxbv = new vge(this.jdField_a_of_type_JavaLangString, 20))
    {
      urp.a().a(paramxbv, new xoa(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xny
 * JD-Core Version:    0.7.0.1
 */