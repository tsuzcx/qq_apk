import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class tzu
  implements appt
{
  tzu(tzr paramtzr) {}
  
  public void a(appw paramappw)
  {
    int i;
    int j;
    if ((paramappw instanceof apuw))
    {
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    apur localapur;
    int k;
    int m;
    do
    {
      this.a.a.getEditableText().replace(i, j, baiy.c(((apuw)paramappw).a));
      do
      {
        return;
      } while (!(paramappw instanceof apur));
      localapur = (apur)paramappw;
      i = this.a.a.getSelectionStart();
      j = this.a.a.getSelectionEnd();
      k = localapur.a;
      m = localapur.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramappw = baiy.c(m);; paramappw = baiy.a(m))
    {
      this.a.a.getEditableText().replace(i, j, paramappw);
      this.a.a.requestFocus();
      localapur.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      return;
    }
  }
  
  public void a(appw paramappw1, appw paramappw2, Drawable paramDrawable) {}
  
  public boolean a(appw paramappw)
  {
    return true;
  }
  
  public void b()
  {
    if (this.a.a.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.a.a.getText();
        int i = this.a.a.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.a.a.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(appw paramappw) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzu
 * JD-Core Version:    0.7.0.1
 */