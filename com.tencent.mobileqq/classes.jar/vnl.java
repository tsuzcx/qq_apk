class vnl
  extends vnh
{
  vnl(vni paramvni, vnq paramvnq) {}
  
  public void onFailure(String paramString)
  {
    urk.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onFail: " + paramString);
    this.jdField_a_of_type_Vnq.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    urk.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onSuccess: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnl
 * JD-Core Version:    0.7.0.1
 */