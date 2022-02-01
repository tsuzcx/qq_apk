import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class ljl
  implements lji.a<BEAN, COOKIE>
{
  ljl(lji paramlji, ljh.e parame) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Lji.q.addAll(paramArrayList);
    if (paramBoolean1)
    {
      lji.a(this.jdField_a_of_type_Lji, paramCOOKIE);
      paramArrayList = this.jdField_a_of_type_Lji;
      if (paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      lji.a(paramArrayList, paramBoolean2);
      this.jdField_a_of_type_Ljh$e.a(paramBoolean1, this.jdField_a_of_type_Lji.q, paramInt2, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljl
 * JD-Core Version:    0.7.0.1
 */