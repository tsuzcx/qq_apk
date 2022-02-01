import com.tencent.qphone.base.util.QLog;

class aaei
  implements aafe.a
{
  aaei(aaeh paramaaeh, aaeh.a parama) {}
  
  public void Ce(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "TensorFlow init:" + paramBoolean);
    }
    if (paramBoolean) {
      aaeh.a(this.this$0, aaeh.a(this.this$0), this.a, true);
    }
    while (this.a == null) {
      return;
    }
    this.a.onInit(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaei
 * JD-Core Version:    0.7.0.1
 */