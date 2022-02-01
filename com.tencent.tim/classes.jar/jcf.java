import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.a;
import com.tencent.qphone.base.util.QLog;

class jcf
  implements QavListItemBase.a
{
  jcf(jcc paramjcc) {}
  
  public void a(long paramLong, int paramInt, QavListItemBase paramQavListItemBase)
  {
    if ((System.currentTimeMillis() - this.this$0.oI < 500L) && (paramInt > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QAVPtvTemplateAdapter", 1, "onItemClicked begin, position[" + paramInt + "], mCurSelectedPosition[" + this.this$0.awQ + "], ignore[" + bool + "], seq[" + paramLong + "]");
      }
      if (!bool) {
        break;
      }
      return;
    }
    QLog.w("QAVPtvTemplateAdapter", 1, "onItemClicked valid, position[" + paramInt + "], mCurSelectedPosition[" + this.this$0.awQ + "], seq[" + paramLong + "]");
    this.this$0.oI = System.currentTimeMillis();
    int i = this.this$0.awQ;
    this.this$0.awQ = paramInt;
    this.this$0.bW(i, this.this$0.awQ);
    this.this$0.mD(this.this$0.awQ);
    this.this$0.K(paramLong, this.this$0.awQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcf
 * JD-Core Version:    0.7.0.1
 */