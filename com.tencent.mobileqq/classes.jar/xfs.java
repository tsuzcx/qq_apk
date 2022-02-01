import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;

public class xfs
  extends xfu
{
  private ElasticImageView a;
  
  public xfs(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.a = ((ElasticImageView)paramViewGroup.findViewById(2131364714));
    this.a.setOnClickListener(new xft(this));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfs
 * JD-Core Version:    0.7.0.1
 */