import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.List;

public class wks
  extends wrj
{
  public wks(wkp paramwkp) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(wkp.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(wkp.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        uqn.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (wkp.a(this.a) == null);
      wkp.a(this.a).a(paramObject, paramInt);
      return;
    } while (wkp.a(this.a) == null);
    wkp.a(this.a).Q_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(wkp.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(wkp.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (wkp.a(this.a) == null);
      wkp.a(this.a).b(paramObject, paramInt);
      return;
    } while (wkp.a(this.a) == null);
    wkp.a(this.a).Q_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wks
 * JD-Core Version:    0.7.0.1
 */