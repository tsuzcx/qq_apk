import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public abstract interface wns
{
  public abstract void a(@Nullable wly paramwly, Error paramError);
  
  public abstract void a(@Nullable wly paramwly, @NonNull List<StoryVideoItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wns
 * JD-Core Version:    0.7.0.1
 */