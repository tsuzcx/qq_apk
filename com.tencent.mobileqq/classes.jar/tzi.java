import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class tzi
  extends tzk
{
  private ElasticImageView a;
  
  public tzi(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.a = ((ElasticImageView)paramViewGroup.findViewById(2131364275));
    this.a.setOnClickListener(new tzj(this));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzi
 * JD-Core Version:    0.7.0.1
 */