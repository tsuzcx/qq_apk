package dov.com.qq.im.capture.text;

import acfp;
import axol;
import axug;
import com.tencent.common.app.AppInterface;
import java.util.Arrays;
import java.util.Map;

public final class DynamicTextBuilder$1
  implements Runnable
{
  public void run()
  {
    String str = axol.getAppInterface().getCurrentNickname();
    axug.access$000().put(Integer.valueOf(5), Arrays.asList(new String[] { acfp.m(2131705370), "MY JOURNEY \n" + str }));
    axug.access$000().put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextBuilder.1
 * JD-Core Version:    0.7.0.1
 */