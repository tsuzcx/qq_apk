import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.List;

public class uey
  extends ulp
{
  public uey(uev paramuev) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(uev.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(uev.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        skt.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (uev.a(this.a) == null);
      uev.a(this.a).a(paramObject, paramInt);
      return;
    } while (uev.a(this.a) == null);
    uev.a(this.a).N_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(uev.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(uev.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (uev.a(this.a) == null);
      uev.a(this.a).b(paramObject, paramInt);
      return;
    } while (uev.a(this.a) == null);
    uev.a(this.a).N_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uey
 * JD-Core Version:    0.7.0.1
 */