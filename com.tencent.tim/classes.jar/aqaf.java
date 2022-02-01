import java.util.ArrayList;
import java.util.List;

public class aqaf
{
  public final List<aqae> IC = new ArrayList();
  public final aqae a = new aqae();
  
  public int a(aqaf paramaqaf)
  {
    int j;
    int i;
    label22:
    int k;
    if (paramaqaf != null) {
      if (this.IC == null)
      {
        j = 0;
        if (paramaqaf.IC != null) {
          break label100;
        }
        i = 0;
        if (j != i) {
          break label144;
        }
        k = 0;
        i = 1;
        label32:
        if ((i == 0) || (k >= j)) {
          break label113;
        }
        if (aqft.equalsWithNullCheck((aqae)this.IC.get(k), (aqae)paramaqaf.IC.get(k))) {
          break label161;
        }
        i = 0;
      }
    }
    label144:
    label161:
    for (;;)
    {
      k += 1;
      break label32;
      j = this.IC.size();
      break;
      label100:
      i = paramaqaf.IC.size();
      break label22;
      label113:
      if (i != 0) {
        i = 0;
      }
      while (aqft.equalsWithNullCheck(paramaqaf.a, this.a)) {
        if (i == 0)
        {
          return 0;
          i = 3;
          continue;
          i = 3;
        }
        else
        {
          return 1;
        }
      }
      if (i == 0) {
        return 2;
      }
      return 3;
      return 3;
    }
  }
  
  public Object clone()
  {
    aqaf localaqaf = new aqaf();
    localaqaf.a.a(this.a);
    int i = 0;
    while (i < this.IC.size())
    {
      aqae localaqae = (aqae)this.IC.get(i);
      localaqaf.IC.add((aqae)localaqae.clone());
      i += 1;
    }
    return localaqaf;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int j;
    if ((paramObject instanceof aqaf))
    {
      paramObject = (aqaf)paramObject;
      bool1 = bool2;
      if (aqft.equalsWithNullCheck(paramObject.a, this.a)) {
        if (this.IC == null)
        {
          i = 0;
          if (paramObject.IC != null) {
            break label134;
          }
          j = 0;
          label55:
          bool1 = bool2;
          if (i != j) {
            break label147;
          }
          bool1 = true;
          j = 0;
          label69:
          if ((!bool1) || (j >= i)) {
            break label147;
          }
          if (aqft.equalsWithNullCheck((aqae)this.IC.get(j), (aqae)paramObject.IC.get(j))) {
            break label150;
          }
          bool1 = false;
        }
      }
    }
    label134:
    label147:
    label150:
    for (;;)
    {
      j += 1;
      break label69;
      i = this.IC.size();
      break;
      j = paramObject.IC.size();
      break label55;
      return bool1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[head]").append("type = ").append(this.a.type).append(", value = ").append(aqft.pl(this.a.value)).append("\r\n");
    if (this.IC == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(this.IC.size()))
    {
      int j = ((Integer)localObject).intValue();
      int i = 0;
      while (i < j)
      {
        localObject = (aqae)this.IC.get(i);
        if (localObject != null) {
          localStringBuilder.append("[more item]").append("type = ").append(((aqae)localObject).type).append(", value = ").append(aqft.pl(((aqae)localObject).value)).append("\r\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqaf
 * JD-Core Version:    0.7.0.1
 */