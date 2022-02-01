import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class zbv
  extends acfd
{
  zbv(zbq paramzbq) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      zbq.a(this.this$0, true);
      zbq.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbv
 * JD-Core Version:    0.7.0.1
 */