import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.todo.data.TodoInfo;
import java.util.List;

class auny
  extends aupd
{
  auny(aunx paramaunx) {}
  
  private void refreshList()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    long l;
    if (aunx.a(this.a) != null)
    {
      aunx.a(this.a);
      aunx.b(this.a);
      l = aunx.a(this.a);
      if (aunx.a(this.a).aJx())
      {
        locala = (aunw.a)aunx.b(this.a);
        i = aunx.erI;
        if (l == aunx.erL) {
          bool1 = true;
        }
        locala.f(true, i, bool1);
      }
    }
    else
    {
      return;
    }
    aunw.a locala = (aunw.a)aunx.c(this.a);
    int i = aunx.erJ;
    bool1 = bool2;
    if (l == aunx.erL) {
      bool1 = true;
    }
    locala.f(true, i, bool1);
  }
  
  public void Dq(boolean paramBoolean)
  {
    if (aunx.d(this.a) == null) {}
    do
    {
      return;
      super.Dq(paramBoolean);
    } while (!paramBoolean);
    refreshList();
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, TodoInfo paramTodoInfo, int paramInt2)
  {
    if (aunx.e(this.a) == null) {}
    do
    {
      return;
      super.a(paramBoolean, paramInt1, paramString, paramTodoInfo, paramInt2);
    } while (!paramBoolean);
    ((auoi)aunx.a(this.a).getManager(376)).Zu(paramString);
    refreshList();
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, TodoInfo paramTodoInfo)
  {
    if (aunx.k(this.a) == null) {
      return;
    }
    super.a(paramBoolean, paramString, paramInt, paramTodoInfo);
    if ((!paramBoolean) && ((paramInt == 2) || (paramInt == 3))) {
      ((aunw.a)aunx.l(this.a)).qw("切换状态失败，请稍后重试。");
    }
    refreshList();
  }
  
  public void aq(boolean paramBoolean, String paramString)
  {
    super.aq(paramBoolean, paramString);
    if (aunx.m(this.a) == null) {
      return;
    }
    if (!paramBoolean) {
      ((aunw.a)aunx.n(this.a)).qw("删除失败，请稍后再试。");
    }
    refreshList();
  }
  
  public void bY(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (aunx.o(this.a) == null) {}
    do
    {
      return;
      super.bY(paramBoolean, paramInt);
    } while (!paramBoolean);
    long l = aunx.a(this.a);
    if (aunx.a(this.a).aJx())
    {
      locala = (aunw.a)aunx.p(this.a);
      paramInt = aunx.erI;
      paramBoolean = bool1;
      if (l == aunx.erL) {
        paramBoolean = true;
      }
      locala.f(true, paramInt, paramBoolean);
      return;
    }
    aunw.a locala = (aunw.a)aunx.q(this.a);
    paramInt = aunx.erJ;
    paramBoolean = bool2;
    if (l == aunx.erL) {
      paramBoolean = true;
    }
    locala.f(true, paramInt, paramBoolean);
  }
  
  public void c(boolean paramBoolean, long paramLong, List<TodoInfo> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (aunx.f(this.a) == null) {}
    do
    {
      return;
      super.c(paramBoolean, paramLong, paramList);
      if (!paramBoolean)
      {
        ((aunw.a)aunx.g(this.a)).qw("获取已完成列表失败，请稍后再试。");
        return;
      }
      this.a.Le.removeAll(this.a.Lf);
      aunx.b(this.a);
    } while (!aunx.h(this.a).Pp());
    if (aunx.a(this.a).aJx())
    {
      paramList = (aunw.a)aunx.i(this.a);
      i = aunx.erI;
      paramBoolean = bool1;
      if (paramLong == aunx.erL) {
        paramBoolean = true;
      }
      paramList.f(true, i, paramBoolean);
      return;
    }
    paramList = (aunw.a)aunx.j(this.a);
    int i = aunx.erJ;
    paramBoolean = bool2;
    if (paramLong == aunx.erL) {
      paramBoolean = true;
    }
    paramList.f(true, i, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auny
 * JD-Core Version:    0.7.0.1
 */