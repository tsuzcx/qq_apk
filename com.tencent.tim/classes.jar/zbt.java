import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class zbt
  extends afsr
{
  zbt(zbq paramzbq) {}
  
  protected void Bv(boolean paramBoolean)
  {
    zbm localzbm = this.this$0.a(2);
    localzbm.extraInfo = Boolean.valueOf(paramBoolean);
    if ((localzbm.bqw) && (paramBoolean)) {
      zbq.a(this.this$0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onResourceStateUpdate [id: %s, canBeShown: %s, isReady: %s]", new Object[] { Integer.valueOf(localzbm.id), Boolean.valueOf(localzbm.bqw), Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbt
 * JD-Core Version:    0.7.0.1
 */