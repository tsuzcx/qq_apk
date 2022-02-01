import com.tencent.biz.qqstory.database.PublishVideoEntry;

class wir
  extends bomw
{
  private long jdField_a_of_type_Long;
  
  wir(wip paramwip, PublishVideoEntry paramPublishVideoEntry, wiv paramwiv, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Wiv.a(-3);
    this.jdField_a_of_type_Wiv.a("task canceled");
    wip.a(this.jdField_a_of_type_Wip, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    yqp.c(wip.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    yqp.c(wip.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Wiv.a(paramInt);
      this.jdField_a_of_type_Wiv.a("unknown error the music download failed");
    }
    for (;;)
    {
      aaxb.a("edit_music_download", aaxb.a(this.jdField_a_of_type_Wiv.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, zkr.a(paramString)));
      wip.a(this.jdField_a_of_type_Wip, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_Wiv.a(0);
      this.jdField_a_of_type_Wiv.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_Wiv.a(-2);
      this.jdField_a_of_type_Wiv.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wir
 * JD-Core Version:    0.7.0.1
 */