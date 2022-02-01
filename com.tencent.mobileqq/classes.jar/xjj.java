import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.List;

public class xjj
  extends xqa
{
  public xjj(xjg paramxjg) {}
  
  public void a(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xjg.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(xjg.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        vpl.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (xjg.a(this.a) == null);
      xjg.a(this.a).a(paramObject, paramInt);
      return;
    } while (xjg.a(this.a) == null);
    xjg.a(this.a).H_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xjg.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(xjg.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (xjg.a(this.a) == null);
      xjg.a(this.a).b(paramObject, paramInt);
      return;
    } while (xjg.a(this.a) == null);
    xjg.a(this.a).H_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjj
 * JD-Core Version:    0.7.0.1
 */