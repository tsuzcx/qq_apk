import android.text.TextUtils;

public class uzh
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.a)) {
      localStringBuilder.append("feed_id=").append(this.a).append("|");
    }
    if (!TextUtils.isEmpty(this.d)) {
      localStringBuilder.append("ctim=").append(this.d).append("|");
    }
    if (!TextUtils.isEmpty(this.e)) {
      localStringBuilder.append("poster_id=").append(this.e).append("|");
    }
    if (!TextUtils.isEmpty(this.b)) {
      localStringBuilder.append("comment_id=").append(this.b).append("|");
    }
    if (!TextUtils.isEmpty(this.c)) {
      localStringBuilder.append("reply_id=").append(this.c).append("|");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public uzh a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public uzh b(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public uzh c(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public uzh d(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public uzh e(String paramString)
  {
    this.d = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzh
 * JD-Core Version:    0.7.0.1
 */