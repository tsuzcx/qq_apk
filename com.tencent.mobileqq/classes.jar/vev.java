import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class vev
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<veu> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<veu> b = new ArrayList();
  
  public vev(@NonNull Groups paramGroups, @NonNull List<veu> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (veu)paramGroups.next();
      if (paramList.jdField_a_of_type_Boolean) {
        this.b.add(paramList);
      }
    }
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  @NonNull
  public List<veu> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void a(veu paramveu)
  {
    paramveu.a();
    if ((paramveu.jdField_a_of_type_Boolean) && (!this.b.contains(paramveu)))
    {
      this.b.add(paramveu);
      return;
    }
    if ((!paramveu.jdField_a_of_type_Boolean) && (this.b.contains(paramveu)))
    {
      this.b.remove(paramveu);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramveu.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramveu));
  }
  
  public boolean a()
  {
    return (!this.b.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.size() == this.b.size());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @NonNull
  public List<veu> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      veu localveu = (veu)localIterator.next();
      localveu.jdField_a_of_type_Boolean = true;
      this.b.add(localveu);
    }
  }
  
  public void b(veu paramveu)
  {
    paramveu.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramveu)) {
      this.b.add(paramveu);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((veu)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vev
 * JD-Core Version:    0.7.0.1
 */