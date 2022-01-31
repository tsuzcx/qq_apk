import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class tzf
  extends tzh
{
  private ElasticImageView a;
  
  public tzf(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.a = ((ElasticImageView)paramViewGroup.findViewById(2131364274));
    this.a.setOnClickListener(new tzg(this));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzf
 * JD-Core Version:    0.7.0.1
 */