package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class ad
{
  private final String[] a;
  
  ad(ae paramae)
  {
    this.a = ((String[])paramae.a.toArray(new String[paramae.a.size()]));
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public int a()
  {
    return this.a.length / 2;
  }
  
  public String a(int paramInt)
  {
    return this.a[(paramInt * 2)];
  }
  
  @Nullable
  public String a(String paramString)
  {
    return a(this.a, paramString);
  }
  
  public String b(int paramInt)
  {
    return this.a[(paramInt * 2 + 1)];
  }
  
  public List b(String paramString)
  {
    int j = a();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(a(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(b(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return Collections.unmodifiableList(localObject1);
    }
    return Collections.emptyList();
  }
  
  public ae b()
  {
    ae localae = new ae();
    Collections.addAll(localae.a, this.a);
    return localae;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ad)) && (Arrays.equals(((ad)paramObject).a, this.a));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = a();
    while (i < j)
    {
      localStringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ad
 * JD-Core Version:    0.7.0.1
 */