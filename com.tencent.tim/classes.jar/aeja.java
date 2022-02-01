import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aeja
  extends aejb
{
  private int mIndex;
  
  public aeja(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  public Object g(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      paramObject = (ArrayList)paramObject;
      if (!(paramObject instanceof ArrayList))
      {
        QLog.e("ArkMsgReplyConfigMgr", 1, "getElement instance wrong");
        return null;
      }
    } while ((this.mIndex < 0) || (this.mIndex >= paramObject.size()));
    return paramObject.get(this.mIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeja
 * JD-Core Version:    0.7.0.1
 */