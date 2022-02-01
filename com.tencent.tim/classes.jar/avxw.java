import android.content.Context;
import android.os.RemoteException;

class avxw
  extends avxr.a
{
  avxw(avxv paramavxv, avxl.a parama, Context paramContext, avxl.b paramb) {}
  
  public void a(String paramString, float paramFloat, long paramLong)
    throws RemoteException
  {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {}
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_Avxl$a.a(true, this.val$context, this.jdField_a_of_type_Avxl$b);
      return;
    }
    this.jdField_a_of_type_Avxl$a.a(false, this.val$context, this.jdField_a_of_type_Avxl$b);
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    this.jdField_a_of_type_Avxl$a.a(true, this.val$context, this.jdField_a_of_type_Avxl$b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxw
 * JD-Core Version:    0.7.0.1
 */