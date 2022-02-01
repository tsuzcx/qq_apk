import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class qip
  extends qir
{
  private ElasticImageView a;
  
  public qip(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    this.a = ((ElasticImageView)paramViewGroup.findViewById(2131364694));
    this.a.setOnClickListener(new qiq(this));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qip
 * JD-Core Version:    0.7.0.1
 */