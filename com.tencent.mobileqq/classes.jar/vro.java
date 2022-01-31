import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class vro
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<vrn> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<vrn> b = new ArrayList();
  
  public vro(@NonNull Groups paramGroups, @NonNull List<vrn> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (vrn)paramGroups.next();
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
  public List<vrn> a()
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
  
  public void a(vrn paramvrn)
  {
    paramvrn.a();
    if ((paramvrn.jdField_a_of_type_Boolean) && (!this.b.contains(paramvrn)))
    {
      this.b.add(paramvrn);
      return;
    }
    if ((!paramvrn.jdField_a_of_type_Boolean) && (this.b.contains(paramvrn)))
    {
      this.b.remove(paramvrn);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramvrn.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramvrn));
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
  public List<vrn> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      vrn localvrn = (vrn)localIterator.next();
      localvrn.jdField_a_of_type_Boolean = true;
      this.b.add(localvrn);
    }
  }
  
  public void b(vrn paramvrn)
  {
    paramvrn.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramvrn)) {
      this.b.add(paramvrn);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrn)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vro
 * JD-Core Version:    0.7.0.1
 */