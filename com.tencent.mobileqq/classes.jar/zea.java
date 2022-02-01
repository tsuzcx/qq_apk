import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zea
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<zdz> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<zdz> b = new ArrayList();
  
  public zea(@NonNull Groups paramGroups, @NonNull List<zdz> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (zdz)paramGroups.next();
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
  public List<zdz> a()
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
  
  public void a(zdz paramzdz)
  {
    paramzdz.a();
    if ((paramzdz.jdField_a_of_type_Boolean) && (!this.b.contains(paramzdz)))
    {
      this.b.add(paramzdz);
      return;
    }
    if ((!paramzdz.jdField_a_of_type_Boolean) && (this.b.contains(paramzdz)))
    {
      this.b.remove(paramzdz);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramzdz.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramzdz));
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
  public List<zdz> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zdz localzdz = (zdz)localIterator.next();
      localzdz.jdField_a_of_type_Boolean = true;
      this.b.add(localzdz);
    }
  }
  
  public void b(zdz paramzdz)
  {
    paramzdz.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramzdz)) {
      this.b.add(paramzdz);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zdz)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zea
 * JD-Core Version:    0.7.0.1
 */