import com.tencent.qphone.base.util.QLog;

class aiqz
  implements acci
{
  protected void bs(boolean paramBoolean, Object paramObject) {}
  
  protected void bt(boolean paramBoolean, Object paramObject) {}
  
  protected void bu(boolean paramBoolean, Object paramObject) {}
  
  protected void bv(boolean paramBoolean, Object paramObject) {}
  
  protected void bw(boolean paramBoolean, Object paramObject) {}
  
  protected void bx(boolean paramBoolean, Object paramObject) {}
  
  protected void by(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationObserverBase", 2, new Object[] { "onUpdate: invoked. ", " type: ", Integer.valueOf(paramInt), " isSuccess: ", Boolean.valueOf(paramBoolean), " data: ", paramObject });
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      by(paramBoolean, paramObject);
      return;
    case 2: 
      bs(paramBoolean, paramObject);
      return;
    case 3: 
      bx(paramBoolean, paramObject);
      return;
    case 4: 
      bw(paramBoolean, paramObject);
      return;
    case 5: 
      bv(paramBoolean, paramObject);
      return;
    case 6: 
      bu(paramBoolean, paramObject);
      return;
    }
    bt(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqz
 * JD-Core Version:    0.7.0.1
 */