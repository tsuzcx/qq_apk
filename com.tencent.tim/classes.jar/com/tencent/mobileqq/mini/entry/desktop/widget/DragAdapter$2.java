package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.os.Handler;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class DragAdapter$2
  implements MiniAppCmdInterface
{
  DragAdapter$2(DragAdapter paramDragAdapter, MiniAppInfo paramMiniAppInfo, DesktopAppInfo paramDesktopAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    DragAdapter.access$500(this.this$0).post(new DragAdapter.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.2
 * JD-Core Version:    0.7.0.1
 */