package retrofit.client;

public final class Header
{
  private final String name;
  private final String value;
  
  public Header(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Header)paramObject;
      if (this.name != null)
      {
        if (this.name.equals(paramObject.name)) {}
      }
      else {
        while (paramObject.name != null) {
          return false;
        }
      }
      if (this.value == null) {
        break;
      }
    } while (this.value.equals(paramObject.value));
    for (;;)
    {
      return false;
      if (paramObject.value == null) {
        break;
      }
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.name != null) {}
    for (int i = this.name.hashCode();; i = 0)
    {
      if (this.value != null) {
        j = this.value.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.name != null)
    {
      str = this.name;
      localStringBuilder = localStringBuilder.append(str).append(": ");
      if (this.value == null) {
        break label58;
      }
    }
    label58:
    for (String str = this.value;; str = "")
    {
      return str;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.client.Header
 * JD-Core Version:    0.7.0.1
 */