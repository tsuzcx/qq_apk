import java.util.ArrayList;
import java.util.Iterator;

public class txl
  implements nmg
{
  public int a;
  public String a;
  private ArrayList<nnx> a;
  private int b;
  public String b;
  private int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public txl(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((nnx)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(nnx paramnnx)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramnnx)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramnnx);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(nnx paramnnx)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramnnx);
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((nnx)localIterator.next()).loaded(paramString, paramInt);
    }
  }
  
  public void progress(int paramInt)
  {
    this.c = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((nnx)localIterator.next()).progress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txl
 * JD-Core Version:    0.7.0.1
 */