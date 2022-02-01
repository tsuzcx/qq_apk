import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class yxo
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<yxn> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<yxn> b = new ArrayList();
  
  public yxo(@NonNull Groups paramGroups, @NonNull List<yxn> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (yxn)paramGroups.next();
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
  public List<yxn> a()
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
  
  public void a(yxn paramyxn)
  {
    paramyxn.a();
    if ((paramyxn.jdField_a_of_type_Boolean) && (!this.b.contains(paramyxn)))
    {
      this.b.add(paramyxn);
      return;
    }
    if ((!paramyxn.jdField_a_of_type_Boolean) && (this.b.contains(paramyxn)))
    {
      this.b.remove(paramyxn);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramyxn.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramyxn));
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
  public List<yxn> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      yxn localyxn = (yxn)localIterator.next();
      localyxn.jdField_a_of_type_Boolean = true;
      this.b.add(localyxn);
    }
  }
  
  public void b(yxn paramyxn)
  {
    paramyxn.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramyxn)) {
      this.b.add(paramyxn);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxn)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxo
 * JD-Core Version:    0.7.0.1
 */