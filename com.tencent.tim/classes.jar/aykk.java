import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class aykk
{
  public final String category;
  public final Drawable drawable;
  public final int eGY;
  public final String name;
  
  public aykk(@NonNull String paramString1, @NonNull String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.category = paramString1;
    this.name = paramString2;
    this.drawable = paramDrawable;
    this.eGY = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SelectedItem{");
    localStringBuilder.append("category='").append(this.category).append('\'');
    localStringBuilder.append(", name='").append(this.name).append('\'');
    localStringBuilder.append(", drawable=").append(this.drawable);
    localStringBuilder.append(", isDynamic=").append(this.eGY);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykk
 * JD-Core Version:    0.7.0.1
 */