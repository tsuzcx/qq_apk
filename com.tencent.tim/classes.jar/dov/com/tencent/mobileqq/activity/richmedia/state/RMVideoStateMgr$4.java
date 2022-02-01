package dov.com.tencent.mobileqq.activity.richmedia.state;

import azam;

final class RMVideoStateMgr$4
  implements Runnable
{
  RMVideoStateMgr$4(String paramString) {}
  
  public void run()
  {
    String str = azam.zR();
    if ((str != null) && (!"".equals(str)) && (str.contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      RMVideoStateMgr.l(str, this.cXZ, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.4
 * JD-Core Version:    0.7.0.1
 */