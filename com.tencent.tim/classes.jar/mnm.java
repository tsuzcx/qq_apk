import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;

class mnm
  implements mne
{
  mnm(mnj parammnj, ColumnInfo paramColumnInfo) {}
  
  public void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "createTopic response errorCode = " + paramInt1 + ", errorMsg = " + paramString1 + ", tip = " + paramString2 + ", topicId = " + paramInt2);
    if (mnj.a(this.a) == null) {
      return;
    }
    mnj.a(this.a).aQx();
    if (paramInt1 == 0)
    {
      if (paramString2.equals(Integer.toString(0)))
      {
        this.c.columnID = paramInt2;
        mnj.a(this.a).b(this.c, true);
        mnj.a(this.a).showTips(2131718402);
        mnj.a(this.a).aQH();
        return;
      }
      mnj.a(this.a).b(this.c, false);
      if (!paramString1.isEmpty())
      {
        mnj.a(this.a).showTips(paramString1);
        return;
      }
      mnj.a(this.a).showTips(2131718401);
      return;
    }
    mnj.a(this.a).b(this.c, false);
    mnj.a(this.a).showTips(2131718401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnm
 * JD-Core Version:    0.7.0.1
 */