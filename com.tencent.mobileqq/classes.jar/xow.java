class xow
  extends xos
{
  xow(xot paramxot, xpb paramxpb) {}
  
  public void onFailure(String paramString)
  {
    wsv.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onFail: " + paramString);
    this.jdField_a_of_type_Xpb.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    wsv.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onSuccess: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xow
 * JD-Core Version:    0.7.0.1
 */