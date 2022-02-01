import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;

class ajzu
  implements ajvz.a
{
  ajzu(ajzr paramajzr) {}
  
  public void a(Comments.Comment paramComment, int paramInt)
  {
    if (ajzr.a(this.a) != null)
    {
      if (paramInt == 0)
      {
        ajzr.a(this.a).c(paramComment);
        ajzr.a(this.a).showToast(BaseApplicationImpl.getApplication().getString(2131698608));
        anot.a(null, "dc02676", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    ajzr.a(this.a).showToast(BaseApplicationImpl.getApplication().getString(2131698607));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzu
 * JD-Core Version:    0.7.0.1
 */