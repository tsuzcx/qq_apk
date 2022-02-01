package cooperation.readinjoy;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class ReadInJoyProxyActivity
  extends PluginProxyActivity
{
  protected static Class<? extends PluginProxyActivity> e(String paramString)
  {
    return ReadInJoyProxyActivity.class;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return e(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyProxyActivity
 * JD-Core Version:    0.7.0.1
 */