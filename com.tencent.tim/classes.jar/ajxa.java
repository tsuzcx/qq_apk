import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ajxa
  extends jnm.c
{
  ajxa(ajww paramajww, String paramString, ajww.a parama) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      QLog.i("getMediaDetailInfo", 1, "getMediaDetailInfo错误   errorCode=" + paramInt + ", data=" + paramArrayOfByte + ", mQueryString=" + this.bSK);
    }
    if (this.jdField_a_of_type_Ajww$a != null) {
      this.jdField_a_of_type_Ajww$a.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxa
 * JD-Core Version:    0.7.0.1
 */