class zql
  extends zqh
{
  zql(zqi paramzqi, zqq paramzqq) {}
  
  public void onFailure(String paramString)
  {
    yuk.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onFail: " + paramString);
    this.jdField_a_of_type_Zqq.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    yuk.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onSuccess: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zql
 * JD-Core Version:    0.7.0.1
 */