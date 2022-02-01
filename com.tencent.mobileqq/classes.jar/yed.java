import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.List;

public class yed
  extends yku
{
  public yed(yea paramyea) {}
  
  public void a(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(yea.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(yea.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        wjz.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (yea.a(this.a) == null);
      yea.a(this.a).a(paramObject, paramInt);
      return;
    } while (yea.a(this.a) == null);
    yea.a(this.a).N_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(yea.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(yea.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (yea.a(this.a) == null);
      yea.a(this.a).b(paramObject, paramInt);
      return;
    } while (yea.a(this.a) == null);
    yea.a(this.a).N_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yed
 * JD-Core Version:    0.7.0.1
 */