import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

class njs
  extends DataSetObserver
{
  njs(njr paramnjr) {}
  
  public void onChanged()
  {
    QLog.d(FastWebActivity.a(this.a.this$0), 2, "DataSetObserver ");
    FastWebActivity.a(this.a.this$0, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njs
 * JD-Core Version:    0.7.0.1
 */