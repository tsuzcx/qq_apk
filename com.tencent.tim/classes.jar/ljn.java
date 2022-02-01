import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ljn
  implements ljh.a<BEAN>
{
  ljn(ljm paramljm) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt1, Boolean paramBoolean1, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      ljm.a(this.a, paramBoolean1.booleanValue(), paramInt1, paramList);
      return;
    }
    QLog.i("ListPresenter", 2, "loadFirstPage error, errorCode=" + paramInt2 + ", errorMsg= " + paramString);
    ljm.a(this.a, paramBoolean1.booleanValue(), paramList, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljn
 * JD-Core Version:    0.7.0.1
 */