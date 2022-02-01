class rqd
  extends rpz
{
  rqd(rqa paramrqa, rqi paramrqi) {}
  
  public void onFailure(String paramString)
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onFail: " + paramString);
    this.b.onFailure(paramString);
  }
  
  public void onSuccess(String paramString)
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs change ts onSuccess: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqd
 * JD-Core Version:    0.7.0.1
 */