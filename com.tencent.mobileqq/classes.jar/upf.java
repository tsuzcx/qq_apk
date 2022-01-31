import com.tencent.biz.qqstory.database.PublishVideoEntry;

class upf
  extends blts
{
  private long jdField_a_of_type_Long;
  
  upf(upd paramupd, PublishVideoEntry paramPublishVideoEntry, upj paramupj, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Upj.a(-3);
    this.jdField_a_of_type_Upj.a("task canceled");
    upd.a(this.jdField_a_of_type_Upd, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    wxe.c(upd.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    wxe.c(upd.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Upj.a(paramInt);
      this.jdField_a_of_type_Upj.a("unknown error the music download failed");
    }
    for (;;)
    {
      zaj.a("edit_music_download", zaj.a(this.jdField_a_of_type_Upj.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, xrg.a(paramString)));
      upd.a(this.jdField_a_of_type_Upd, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_Upj.a(0);
      this.jdField_a_of_type_Upj.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_Upj.a(-2);
      this.jdField_a_of_type_Upj.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upf
 * JD-Core Version:    0.7.0.1
 */