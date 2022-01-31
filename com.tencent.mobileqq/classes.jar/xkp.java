import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class xkp
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<xko> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<xko> b = new ArrayList();
  
  public xkp(@NonNull Groups paramGroups, @NonNull List<xko> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (xko)paramGroups.next();
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
  public List<xko> a()
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
  
  public void a(xko paramxko)
  {
    paramxko.a();
    if ((paramxko.jdField_a_of_type_Boolean) && (!this.b.contains(paramxko)))
    {
      this.b.add(paramxko);
      return;
    }
    if ((!paramxko.jdField_a_of_type_Boolean) && (this.b.contains(paramxko)))
    {
      this.b.remove(paramxko);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramxko.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramxko));
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
  public List<xko> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      xko localxko = (xko)localIterator.next();
      localxko.jdField_a_of_type_Boolean = true;
      this.b.add(localxko);
    }
  }
  
  public void b(xko paramxko)
  {
    paramxko.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramxko)) {
      this.b.add(paramxko);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xko)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xkp
 * JD-Core Version:    0.7.0.1
 */