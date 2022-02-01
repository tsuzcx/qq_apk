import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ajqr
  extends achq
{
  ajqr(ajqp paramajqp) {}
  
  protected void p(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (((Integer)paramArrayOfObject[0]).intValue() != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "onInsertIntoBlackList from nearby");
    }
    if ((paramBoolean) && (paramArrayOfObject.length == 4))
    {
      ((Long)paramArrayOfObject[1]).longValue();
      String str = (String)paramArrayOfObject[2];
      int i = ((Integer)paramArrayOfObject[3]).intValue();
      ajrb.c(this.this$0.app.getAccount(), "blacklist_sequence", Integer.valueOf(i));
      paramArrayOfObject = new ArrayList();
      paramArrayOfObject.add(Long.valueOf(str));
      this.this$0.app.addObserver(this.this$0.a);
      ((aizg)this.this$0.app.getManager(16)).a(1001, paramArrayOfObject, 1);
      return;
    }
    ajqp.a(this.this$0, 4115, new Object[] { Boolean.valueOf(false) });
  }
  
  protected void s(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "onRemoveFromBlackList from nearby");
    }
    if (paramBoolean)
    {
      aizg localaizg = (aizg)this.this$0.app.getManager(16);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramString));
      this.this$0.app.addObserver(this.this$0.a);
      localaizg.b(1001, localArrayList, 1);
      return;
    }
    ajqp.a(this.this$0, 4116, new Object[] { Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqr
 * JD-Core Version:    0.7.0.1
 */