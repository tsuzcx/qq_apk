import com.tencent.biz.qqstory.database.PublishVideoEntry;

class wmm
  extends bpor
{
  private long jdField_a_of_type_Long;
  
  wmm(wmk paramwmk, PublishVideoEntry paramPublishVideoEntry, wmq paramwmq, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Wmq.a(-3);
    this.jdField_a_of_type_Wmq.a("task canceled");
    wmk.a(this.jdField_a_of_type_Wmk, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    yuk.c(wmk.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    yuk.c(wmk.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Wmq.a(paramInt);
      this.jdField_a_of_type_Wmq.a("unknown error the music download failed");
    }
    for (;;)
    {
      abbe.a("edit_music_download", abbe.a(this.jdField_a_of_type_Wmq.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, zom.a(paramString)));
      wmk.a(this.jdField_a_of_type_Wmk, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_Wmq.a(0);
      this.jdField_a_of_type_Wmq.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_Wmq.a(-2);
      this.jdField_a_of_type_Wmq.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmm
 * JD-Core Version:    0.7.0.1
 */