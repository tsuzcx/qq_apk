import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.List;

public class xye
  extends yev
{
  public xye(xyb paramxyb) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xyb.a(this.a)).size())) {}
    do
    {
      do
      {
        do
        {
          return;
          paramObject = (CommentEntry)this.a.a.a(xyb.a(this.a)).get(paramInt);
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
        weg.a(paramView.getContext(), 12, paramObject.authorUnionId);
        return;
      } while (xyb.a(this.a) == null);
      xyb.a(this.a).a(paramObject, paramInt);
      return;
    } while (xyb.a(this.a) == null);
    xyb.a(this.a).J_();
  }
  
  public void b(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xyb.a(this.a)).size())) {}
    do
    {
      do
      {
        return;
        paramObject = (CommentEntry)this.a.a.a(xyb.a(this.a)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (xyb.a(this.a) == null);
      xyb.a(this.a).b(paramObject, paramInt);
      return;
    } while (xyb.a(this.a) == null);
    xyb.a(this.a).J_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xye
 * JD-Core Version:    0.7.0.1
 */