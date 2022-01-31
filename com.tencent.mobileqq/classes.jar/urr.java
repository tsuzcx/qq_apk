import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.List;

public class urr
  extends uyi
{
  public urr(uro paramuro) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(uro.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(uro.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        sxm.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (uro.a(this.a) == null);
      uro.a(this.a).a(paramObject, paramInt);
      return;
    } while (uro.a(this.a) == null);
    uro.a(this.a).L_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(uro.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(uro.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (uro.a(this.a) == null);
      uro.a(this.a).b(paramObject, paramInt);
      return;
    } while (uro.a(this.a) == null);
    uro.a(this.a).L_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urr
 * JD-Core Version:    0.7.0.1
 */