import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zhv
{
  @NonNull
  protected final Groups a;
  @NonNull
  private final List<zhu> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NonNull
  private final List<zhu> b = new ArrayList();
  
  public zhv(@NonNull Groups paramGroups, @NonNull List<zhu> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataGroups = paramGroups;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramGroups = paramList.iterator();
    while (paramGroups.hasNext())
    {
      paramList = (zhu)paramGroups.next();
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
  public List<zhu> a()
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
  
  public void a(zhu paramzhu)
  {
    paramzhu.a();
    if ((paramzhu.jdField_a_of_type_Boolean) && (!this.b.contains(paramzhu)))
    {
      this.b.add(paramzhu);
      return;
    }
    if ((!paramzhu.jdField_a_of_type_Boolean) && (this.b.contains(paramzhu)))
    {
      this.b.remove(paramzhu);
      return;
    }
    throw new IllegalStateException("onFriendClick, friend select:" + paramzhu.jdField_a_of_type_Boolean + ",contains:" + this.b.contains(paramzhu));
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
  public List<zhu> b()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void b()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zhu localzhu = (zhu)localIterator.next();
      localzhu.jdField_a_of_type_Boolean = true;
      this.b.add(localzhu);
    }
  }
  
  public void b(zhu paramzhu)
  {
    paramzhu.jdField_a_of_type_Boolean = true;
    if (!this.b.contains(paramzhu)) {
      this.b.add(paramzhu);
    }
  }
  
  public void c()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((zhu)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhv
 * JD-Core Version:    0.7.0.1
 */