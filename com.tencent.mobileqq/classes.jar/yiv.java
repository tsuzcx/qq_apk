import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class yiv
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<yiu> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<yiu> b = new ArrayList();
  
  public yiv(@NonNull Groups paramGroups, @NonNull List<yiu> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (yiu)paramGroups.next();
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
  public List<yiu> a()
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
  
  public void a(yiu paramyiu)
  {
    paramyiu.a();
    if ((paramyiu.jdField_a_of_type_Boolean) && (!this.b.contains(paramyiu)))
    {
      this.b.add(paramyiu);
      return;
    }
    if ((!paramyiu.jdField_a_of_type_Boolean) && (this.b.contains(paramyiu)))
    {
      this.b.remove(paramyiu);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramyiu.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramyiu));
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
  public List<yiu> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yiu localyiu = (yiu)localIterator.next();
      localyiu.jdField_a_of_type_Boolean = true;
      this.b.add(localyiu);
    }
  }
  
  public void b(yiu paramyiu)
  {
    paramyiu.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramyiu)) {
      this.b.add(paramyiu);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yiu)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiv
 * JD-Core Version:    0.7.0.1
 */