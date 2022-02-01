import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class aolb
  implements ITransCallbackForReport
{
  aolb(aokz paramaokz) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.this$0.a("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, this.this$0.clf, this.this$0.mUuid, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolb
 * JD-Core Version:    0.7.0.1
 */