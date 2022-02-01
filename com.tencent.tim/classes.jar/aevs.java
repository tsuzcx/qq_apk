import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Iterator;
import java.util.List;

public class aevs
{
  public long WP;
  public long WQ;
  public LebaPluginInfo a;
  public String bCo;
  public String bCp;
  public boolean bWG = true;
  public byte bo;
  public int cPu;
  public int cPv = 2147483647;
  
  public static String H(List<aevs> paramList)
  {
    if (paramList == null) {
      return " print lebaData == null";
    }
    if (paramList.isEmpty()) {
      return " print lebaData.isEmpty()";
    }
    StringBuilder localStringBuilder = new StringBuilder(" print lebaData size = ").append(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aevs localaevs = (aevs)paramList.next();
      if (localaevs == null)
      {
        localStringBuilder.append("|item = null");
      }
      else
      {
        localStringBuilder.append("|item = ").append(localaevs.WP).append("|").append(localaevs.bCo).append("|").append(localaevs.bCp).append("|").append(localaevs.cPu).append("|").append(localaevs.bo).append("|").append(localaevs.WQ).append("|").append(localaevs.bWG).append("|");
        if (localaevs.a == null) {
          localStringBuilder.append("info=null");
        } else {
          localStringBuilder.append(localaevs.a.toString());
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean aif()
  {
    return (this.bWG) && (this.a != null) && (this.a.cCanChangeState != 0);
  }
  
  public boolean aig()
  {
    return (!aif()) || (this.cPv == 2147483647);
  }
  
  public void cXq()
  {
    this.bo = 0;
  }
  
  public void cXr()
  {
    this.bo = 1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (this.WP == 0L)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      if (!(paramObject instanceof aevs)) {
        break;
      }
      paramObject = (aevs)paramObject;
      bool1 = bool2;
    } while (this.WP == paramObject.WP);
    return false;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.WP).hashCode();
  }
  
  public boolean isOpen()
  {
    return this.bo == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevs
 * JD-Core Version:    0.7.0.1
 */