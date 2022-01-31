class xtf
  extends xtb
{
  xtf(xtc paramxtc, xtk paramxtk) {}
  
  public void onFailure(String paramString)
  {
    wxe.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onFail: " + paramString);
    this.jdField_a_of_type_Xtk.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    wxe.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onSuccess: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xtf
 * JD-Core Version:    0.7.0.1
 */