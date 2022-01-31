class wah
  extends wad
{
  wah(wae paramwae, wam paramwam) {}
  
  public void onFailure(String paramString)
  {
    veg.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onFail: " + paramString);
    this.jdField_a_of_type_Wam.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    veg.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onSuccess: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wah
 * JD-Core Version:    0.7.0.1
 */