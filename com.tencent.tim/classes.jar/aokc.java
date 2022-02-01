import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class aokc
  implements ITransCallbackForReport
{
  aokc(aojz paramaojz) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    aojz localaojz = this.this$0;
    String str2 = this.this$0.clf;
    if (this.this$0.mResid == null) {}
    for (String str1 = this.this$0.mUuid;; str1 = this.this$0.mResid)
    {
      localaojz.a("actRichMediaNetMonitor_pttUp", false, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokc
 * JD-Core Version:    0.7.0.1
 */