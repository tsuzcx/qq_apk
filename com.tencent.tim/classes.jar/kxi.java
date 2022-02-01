final class kxi
  implements mis.b<String>
{
  public boolean match(String paramString)
  {
    return (paramString.toLowerCase().contains("readinjoy")) && (!paramString.contains("readinjoy_local_reset_config_version")) && (!paramString.contains("readinjoy_remote_reset_config_version"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxi
 * JD-Core Version:    0.7.0.1
 */