import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

public abstract class afoi
  extends afll
{
  afkn jdField_a_of_type_Afkn = new afok(this);
  afkq jdField_a_of_type_Afkq = new afoj(this);
  protected int cSJ = 2;
  
  public afoi(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    afkd.a().a(this.jdField_a_of_type_Afkn);
    afkr.a().a(this.jdField_a_of_type_Afkq);
  }
  
  public void MQ(int paramInt) {}
  
  public void d(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void destory()
  {
    super.destory();
    afkd.a().b(this.jdField_a_of_type_Afkn);
    afkr.a().b(this.jdField_a_of_type_Afkq);
  }
  
  public void f(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void k(EmoticonPackage paramEmoticonPackage) {}
  
  public void l(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoi
 * JD-Core Version:    0.7.0.1
 */