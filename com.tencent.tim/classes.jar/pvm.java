import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;
import java.util.List;

public class pvm
{
  private boolean aCf = true;
  private boolean aCg = true;
  private int bkG = 1;
  
  public void a(@NonNull puh parampuh, pvm.a parama)
  {
    if (this.aCf)
    {
      if (this.aCg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabVideoPreloaderDataProvider", 2, "下载vidList和VideoInfo");
        }
        Stream.of(parampuh).map(new puv("MsgTabPreloader")).map(new pus(null)).subscribe(new pvn(this, parama, parampuh));
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgTabVideoPreloaderDataProvider", 2, "只加载vidList");
    }
    Stream.of(parampuh).map(new puv("MsgTabPreloader")).subscribe(new pvp(this, parama, parampuh));
  }
  
  public void ss(boolean paramBoolean)
  {
    this.aCf = paramBoolean;
  }
  
  public void st(boolean paramBoolean)
  {
    this.aCg = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(@Nullable puh parampuh, Error paramError);
    
    public abstract void a(@Nullable puh parampuh, @NonNull List<StoryVideoItem> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvm
 * JD-Core Version:    0.7.0.1
 */