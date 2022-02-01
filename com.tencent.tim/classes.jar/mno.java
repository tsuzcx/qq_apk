import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class mno
  extends jnm.d
{
  mno(mnn parammnn, lji.a parama) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    mnn.a(this.jdField_a_of_type_Mnn, false);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      this.jdField_a_of_type_Lji$a.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
    mnn.a(this.jdField_a_of_type_Mnn, this.jdField_a_of_type_Lji$a, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mno
 * JD-Core Version:    0.7.0.1
 */