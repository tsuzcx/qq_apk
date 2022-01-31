import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class vci
  implements vch
{
  private List<vcf> a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((vcf)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((vcf)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(vcf paramvcf)
  {
    if (paramvcf == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramvcf)) {
      throw new IllegalStateException("Observer " + paramvcf + " is already registered.");
    }
    this.a.add(paramvcf);
  }
  
  public void b(vcf paramvcf)
  {
    if (paramvcf == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    int i;
    synchronized (this.a)
    {
      i = this.a.indexOf(paramvcf);
      if (i == -1) {
        throw new IllegalStateException("Observer " + paramvcf + " was not registered.");
      }
    }
    this.a.remove(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vci
 * JD-Core Version:    0.7.0.1
 */