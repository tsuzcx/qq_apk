import com.tencent.mobileqq.highway.api.ITransCallbackForReport;

class aonw
  implements ITransCallbackForReport
{
  aonw(aonu paramaonu) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    aonu localaonu = this.this$0;
    String str2 = this.this$0.mFileName;
    if (this.this$0.mResid == null) {}
    for (String str1 = this.this$0.mUuid;; str1 = this.this$0.mResid)
    {
      localaonu.a("actRichMediaNetMonitor_videoUp", false, paramInt, paramString1, paramString2, str2, str1, this.this$0.dQq + "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonw
 * JD-Core Version:    0.7.0.1
 */