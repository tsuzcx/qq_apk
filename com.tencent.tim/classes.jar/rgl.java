import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class rgl
{
  public final String category;
  public final Drawable drawable;
  public final String name;
  
  public rgl(@NonNull String paramString1, @NonNull String paramString2, Drawable paramDrawable)
  {
    this.category = paramString1;
    this.name = paramString2;
    this.drawable = paramDrawable;
  }
  
  public String toString()
  {
    return "SelectedItem{category='" + this.category + '\'' + ", name='" + this.name + '\'' + ", drawable=" + this.drawable + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgl
 * JD-Core Version:    0.7.0.1
 */