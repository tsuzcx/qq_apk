import android.text.TextUtils;

public class alag
{
  public String businessId;
  public String name;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.businessId)) && (!TextUtils.isEmpty(this.name));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PrecoverBusinessInfo:");
    localStringBuilder.append("businessId=").append(this.businessId);
    localStringBuilder.append(", name=").append(this.name);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alag
 * JD-Core Version:    0.7.0.1
 */