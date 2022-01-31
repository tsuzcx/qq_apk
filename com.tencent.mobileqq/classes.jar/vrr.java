import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class vrr
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<vrq> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<vrq> b = new ArrayList();
  
  public vrr(@NonNull Groups paramGroups, @NonNull List<vrq> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (vrq)paramGroups.next();
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
  public List<vrq> a()
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
  
  public void a(vrq paramvrq)
  {
    paramvrq.a();
    if ((paramvrq.jdField_a_of_type_Boolean) && (!this.b.contains(paramvrq)))
    {
      this.b.add(paramvrq);
      return;
    }
    if ((!paramvrq.jdField_a_of_type_Boolean) && (this.b.contains(paramvrq)))
    {
      this.b.remove(paramvrq);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramvrq.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramvrq));
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
  public List<vrq> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      vrq localvrq = (vrq)localIterator.next();
      localvrq.jdField_a_of_type_Boolean = true;
      this.b.add(localvrq);
    }
  }
  
  public void b(vrq paramvrq)
  {
    paramvrq.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramvrq)) {
      this.b.add(paramvrq);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vrq)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrr
 * JD-Core Version:    0.7.0.1
 */