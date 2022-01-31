import com.tencent.biz.qqstory.database.PublishVideoEntry;

class ukw
  extends blpg
{
  private long jdField_a_of_type_Long;
  
  ukw(uku paramuku, PublishVideoEntry paramPublishVideoEntry, ula paramula, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Ula.a(-3);
    this.jdField_a_of_type_Ula.a("task canceled");
    uku.a(this.jdField_a_of_type_Uku, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    wsv.c(uku.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    wsv.c(uku.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Ula.a(paramInt);
      this.jdField_a_of_type_Ula.a("unknown error the music download failed");
    }
    for (;;)
    {
      yvu.a("edit_music_download", yvu.a(this.jdField_a_of_type_Ula.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, xmx.a(paramString)));
      uku.a(this.jdField_a_of_type_Uku, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_Ula.a(0);
      this.jdField_a_of_type_Ula.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_Ula.a(-2);
      this.jdField_a_of_type_Ula.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukw
 * JD-Core Version:    0.7.0.1
 */