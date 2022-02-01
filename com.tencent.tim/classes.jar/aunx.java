import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.todo.data.TodoInfo;
import java.util.ArrayList;
import java.util.List;

public class aunx
  extends augv
  implements aunw.b
{
  public static int erI;
  public static int erJ = 1;
  public static int erK = 2;
  public static int erL;
  List<aupm> Le = new ArrayList();
  List<aupm> Lf = new ArrayList();
  private aupd jdField_a_of_type_Aupd = new auny(this);
  private aupp jdField_a_of_type_Aupp = new aupp();
  
  public aunx(QQAppInterface paramQQAppInterface, aunw.a parama, boolean paramBoolean)
  {
    super(paramQQAppInterface, parama);
    this.jdField_a_of_type_Aupp.VW(paramBoolean);
  }
  
  private void evG()
  {
    auoi localauoi = (auoi)this.app.getManager(376);
    this.Le.clear();
    this.Le.addAll(localauoi.et());
  }
  
  private void evH()
  {
    auoi localauoi = (auoi)this.app.getManager(376);
    this.Lf.clear();
    if ((localauoi.eu() != null) && (localauoi.eu().size() > 0)) {
      this.Lf.add(this.jdField_a_of_type_Aupp);
    }
    if (this.jdField_a_of_type_Aupp.aJx()) {
      this.Lf.addAll(localauoi.eu());
    }
    this.Le.addAll(this.Le.size(), this.Lf);
  }
  
  private long iD()
  {
    return ((auoi)this.app.getManager(376)).iD();
  }
  
  public void a(TodoInfo paramTodoInfo)
  {
    aunu localaunu = (aunu)this.app.getBusinessHandler(181);
    if (paramTodoInfo.status == 2)
    {
      localaunu.b(paramTodoInfo.todoId, 3, paramTodoInfo.content, paramTodoInfo.remindTime);
      aupe.L(this.app, "0X80091C3", 1);
    }
    while (paramTodoInfo.status != 1) {
      return;
    }
    localaunu.b(paramTodoInfo.todoId, 2, paramTodoInfo.content, paramTodoInfo.remindTime);
  }
  
  public boolean aJu()
  {
    if (this.jdField_a_of_type_Aupp != null) {
      return this.jdField_a_of_type_Aupp.aJx();
    }
    return false;
  }
  
  public void evI()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_Aupp;
    if (!this.jdField_a_of_type_Aupp.aJx()) {}
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      ((aupp)localObject).VW(bool1);
      l = iD();
      if (!this.jdField_a_of_type_Aupp.aJx()) {
        break;
      }
      this.Le.removeAll(this.Lf);
      evH();
      if (l == -1L) {
        ((aunu)this.app.getBusinessHandler(181)).bk(l, 15);
      }
      localObject = (aunw.a)this.c;
      i = erI;
      bool1 = bool2;
      if (l == erL) {
        bool1 = true;
      }
      ((aunw.a)localObject).f(true, i, bool1);
      aupe.L(this.app, "0X80091C7", 1);
      return;
    }
    this.Le.removeAll(this.Lf);
    this.Lf.clear();
    this.Lf.add(this.jdField_a_of_type_Aupp);
    this.Le.addAll(this.Le.size(), this.Lf);
    localObject = (aunw.a)this.c;
    int i = erJ;
    bool1 = bool3;
    if (l == erL) {
      bool1 = true;
    }
    ((aunw.a)localObject).f(true, i, bool1);
    aupe.L(this.app, "0X80091C8", 1);
  }
  
  public void evJ()
  {
    long l = iD();
    ((aunu)this.app.getBusinessHandler(181)).bk(l, 15);
  }
  
  public boolean hasMore()
  {
    return iD() != erL;
  }
  
  public List<? extends aupm> hq()
  {
    return this.Le;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.app.addObserver(this.jdField_a_of_type_Aupd);
  }
  
  protected void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Aupd);
    this.Le.clear();
    this.Lf.clear();
    super.onDestroy();
  }
  
  public void onStart()
  {
    evG();
    aunu localaunu = (aunu)this.app.getBusinessHandler(181);
    localaunu.evE();
    localaunu.evF();
    auoi localauoi = (auoi)this.app.getManager(376);
    localauoi.nv(-1L);
    localauoi.evP();
    this.Lf.clear();
    localaunu.bk(-1L, 15);
    if (this.jdField_a_of_type_Aupp.aJx())
    {
      ((aunw.a)this.c).f(true, erI, false);
      return;
    }
    ((aunw.a)this.c).f(true, erJ, false);
  }
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunx
 * JD-Core Version:    0.7.0.1
 */