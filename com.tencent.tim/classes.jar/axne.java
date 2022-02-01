import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;

public final class axne
  implements rxc.a<CLIENT.StBatchGetMusicInfoRsp>
{
  public axne(rxc.a parama, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    axiy.i("AEEditorMusicHelper", "[requestDetailedMusicInfo], onReceive(), isSuccess=" + paramBoolean + ", retCode=" + paramLong + ", errMsg=" + paramString);
    if (this.a != null) {
      this.a.a(paramBoolean, paramLong, paramString, paramStBatchGetMusicInfoRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.aCq;
    axim.a().l((int)paramLong, l1 - l2 + "", "AEEditorMusicInfo", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axne
 * JD-Core Version:    0.7.0.1
 */