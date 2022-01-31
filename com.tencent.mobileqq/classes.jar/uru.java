import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.List;

public class uru
  extends uyl
{
  public uru(urr paramurr) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(urr.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(urr.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        sxp.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (urr.a(this.a) == null);
      urr.a(this.a).a(paramObject, paramInt);
      return;
    } while (urr.a(this.a) == null);
    urr.a(this.a).L_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(urr.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(urr.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (urr.a(this.a) == null);
      urr.a(this.a).b(paramObject, paramInt);
      return;
    } while (urr.a(this.a) == null);
    urr.a(this.a).L_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uru
 * JD-Core Version:    0.7.0.1
 */