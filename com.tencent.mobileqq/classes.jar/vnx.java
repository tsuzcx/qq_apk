import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class vnx
  extends vnz
{
  private ElasticImageView a;
  
  public vnx(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.a = ((ElasticImageView)paramViewGroup.findViewById(2131364341));
    this.a.setOnClickListener(new vny(this));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnx
 * JD-Core Version:    0.7.0.1
 */